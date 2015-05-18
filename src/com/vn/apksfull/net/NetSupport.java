package com.vn.apksfull.net;

import java.util.ArrayList;

import org.json.JSONException;

import com.telpoo.frame.net.BaseNetSupportBeta;
import com.telpoo.frame.object.BaseObject;
import com.telpoo.frame.utils.JsonSupport;
import com.telpoo.frame.utils.Mlog;
import com.vn.apksfull.utils.Common;

public class NetSupport {
	static final String baseUrl="http://sameapk.com/api/api.php";
	 private static final String categoryUrl = "http://sameapk.com/api/cat.php";
	public static NetData getApp(String app_catid,String page) {
		NetData data=new NetData();
		String url= getUrlApp(app_catid,page);
		String res= BaseNetSupportBeta.getInstance().method_GET(url);
		if(res==null){
			data.status= NetData.STATUS_NO_NETWORK;
			return data;
		}
		
		try {
			ArrayList<BaseObject> vl = JsonSupport.jsonArray2BaseOj(res);
			data.data=vl;
			data.status=0;
		} catch (JSONException e) {
			Mlog.E("NetSupport -getApp "+e);
			data.status=NetData.STATUS_ERROR_SERVER;
		}
		
		return data;
	}

	private static String getUrlApp(String app_catid,String page) {
		if(Common.CATID_NEWED.equals(app_catid)) //moi nhat
			return baseUrl+"?page="+page;
		
		 return baseUrl+"?page="+page+"&cat="+app_catid;
		
	}
	
	public static NetData getCategory(){
		NetData data=new NetData();
		String res = BaseNetSupportBeta.getInstance().method_GET(categoryUrl);
		if (res == null) {
			data.status = NetData.STATUS_NO_NETWORK;
			return data;
		}

		try {
			ArrayList<BaseObject> vl = JsonSupport.jsonArray2BaseOj(res);
			data.data = vl;
			data.status = 0;
		} catch (JSONException e) {
			Mlog.E("NetSupport -getApp " + e);
			data.status = NetData.STATUS_ERROR_SERVER;
		}

		return data;
	}


}
