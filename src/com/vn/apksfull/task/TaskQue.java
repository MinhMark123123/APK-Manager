package com.vn.apksfull.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.gc.android.market.api.MarketSession;
import com.gc.android.market.api.MarketSession.Callback;
import com.gc.android.market.api.model.Market.App;
import com.gc.android.market.api.model.Market.AppsRequest;
import com.gc.android.market.api.model.Market.AppsResponse;
import com.gc.android.market.api.model.Market.ResponseContext;
import com.gc.android.market.api.model.Market.GetAssetResponse.InstallAsset;
import com.telpoo.frame.model.BaseModel;
import com.telpoo.frame.model.BaseTask;
import com.telpoo.frame.model.TaskParams;
import com.telpoo.frame.object.BaseObject;
import com.telpoo.frame.utils.FileSupport;
import com.telpoo.frame.utils.Mlog;
import com.vn.apksfull.net.NetData;
import com.vn.apksfull.net.NetSupport;
import com.vn.apksfull.utils.MySpr;

public class TaskQue extends BaseTask implements TaskType {

	NetData netData;
	ArrayList<BaseObject> ojsRes = new ArrayList<BaseObject>();

	public TaskQue(BaseModel baseModel, int taskType, ArrayList<?> list,
			Context context) {
		super(baseModel, taskType, list, context);
	}

	@Override
	protected Boolean doInBackground(TaskParams... params) {

		switch (taskType) {
		case TASK_GET_APP:

			String app_catid = (String) dataFromModel.get(0);
			String page = (String) dataFromModel.get(1);
			netData = NetSupport.getApp(app_catid, page);
			if (netData.status != 0) // co loi xay ra
			{
				msg = netData.msg;
				return TASK_FAILED;
			}

			dataReturn = (ArrayList<BaseObject>) netData.data;
			return TASK_DONE;

		case TASK_DOWNLOAD:

			String pagepagename = (String) dataFromModel.get(0);

			MarketSession session1 = new MarketSession(false);
			//session1.login("naq219@gmail.com", "quequy2213", "3A9AB7941E7275FE");
			session1.setAuthSubToken(MySpr.getToken(context));
			String query = pagepagename;
			AppsRequest appsRequest = AppsRequest.newBuilder().setQuery(query)
					.setStartIndex(0).setEntriesCount(10)
					.setWithExtendedInfo(true).build();

			session1.append(appsRequest, new Callback<AppsResponse>() {
				@Override
				public void onResult(ResponseContext context1,
						AppsResponse response) {
					// Mlog.T(response.toString());

					List<App> apps = response.getAppList();
					String id1 = apps.get(0).getId();
					Mlog.T("id1=" + id1);
					com.chenfei.android.apk.downloader.bean.App ap = new com.chenfei.android.apk.downloader.bean.App();
					ap.setId(id1);
					Mlog.T("ap.getID()=" + ap.getID());

					MarketSession session = new MarketSession(true);
					session.setAuthSubToken(MySpr.getToken(context));
					System.out.println("Login...");
//					session.login("naq219@gmail.com", "quequy2213",
//							"3A9AB7941E7275FE");
					System.out.println("Login done");
					// session.setAuthSubToken(arg0)
					String assetId = ap.getID();
					if (session.queryGetAssetRequest(assetId)
							.getInstallAssetCount() == 0) {
						msg = "Not found link";
						return;
					}
					InstallAsset ia = session.queryGetAssetRequest(assetId)
							.getInstallAsset(0);
					String cookieName = ia.getDownloadAuthCookieName();
					String cookieValue = ia.getDownloadAuthCookieValue();

					try {

						URL url = new URL(ia.getBlobUrl());

						Mlog.T("ia.getBlobUrl()=" + ia.getBlobUrl());

						OutputStream outputStream = null;
						InputStream inputStream = null;
						URLConnection urlConnection;
						TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
							public java.security.cert.X509Certificate[] getAcceptedIssuers() {
								return null;
							}

							public void checkClientTrusted(
									X509Certificate[] certs, String authType) {
							}

							public void checkServerTrusted(
									X509Certificate[] certs, String authType) {
							}
						} };
						SSLContext sslContext = SSLContext.getInstance("SSL");
						sslContext.init(null, trustAllCerts,
								new java.security.SecureRandom());
						// /
						// /
						// -----------------------------------------------------------------------------------------
						// MySSLContextFactory contextFactory = new
						// MySSLContextFactory(mContext);
						// SSLContext sslContext =
						// contextFactory.newMySSLContext();
						// System.setProperty("http.keepAlive", "false");
						// -------------------------------------------------------------------------
						// set certificate for httpsurl connection
						//
						HttpsURLConnection
								.setDefaultSSLSocketFactory(sslContext
										.getSocketFactory());

						//
						HostnameVerifier allHostsValid = new HostnameVerifier() {
							public boolean verify(String hostname,
									SSLSession session) {
								return true;
							}
						};
						HttpsURLConnection
								.setDefaultHostnameVerifier(allHostsValid);
						// //
						// HttpsURLConnection.setReadTimeout(2);
						// httpsURLConnection.setConnectTimeout(30 * 1000);
						// httpsURLConnection.setDoOutput(true);
						// httpsURLConnection.setRequestProperty("User-Agent",
						// "Android");
						// httpsURLConnection.setRequestMethod("GET");
						//
						// httpsURLConnection.connect();
						//
						urlConnection = url.openConnection();
						urlConnection.setRequestProperty("User-Agent",
								"Android-Market/2 (sapphire PLAT-RC33); gzip");
						urlConnection.setRequestProperty("Cookie", cookieName
								+ "=" + cookieValue);
						urlConnection.setDoOutput(true);

						Mlog.T("Cookie=" + cookieName + "=" + cookieValue);
						inputStream = urlConnection.getInputStream();
						String t = "/sdcard/apkfull/"
								+ (String) dataFromModel.get(0) + ".apk";
						File fe = new File("/sdcard/apkfull/");
						fe.mkdirs();
						outputStream = new FileOutputStream(t);
						byte data[] = new byte[1004096];
						int count;
						int dem = 0;
						while ((count = inputStream.read(data)) != -1) {
							// allow canceling with back button
							// publishing the progress....
							Log.d("DownloadTask", "download");
							outputStream.write(data, 0, count);
							dem = dem + count;
						}
						Mlog.T("dem=" + dem);
						outputStream.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});

			session1.flush();
			if ("Not found link".equals(msg))
				return TASK_FAILED;
			msg = "File error";
			return TASK_FAILED;
		default:
			break;
		}

		return super.doInBackground(params);

	}

}
