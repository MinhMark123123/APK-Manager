package com.vn.apksfull.detailapp;

import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.telpoo.frame.model.BaseModel;
import com.telpoo.frame.object.BaseObject;
import com.telpoo.frame.utils.ViewUtils;
import com.vn.apksfull.HomeActivity;
import com.vn.apksfull.R;
import com.vn.apksfull.object.AppOj;
import com.vn.apksfull.task.TaskQue;
import com.vn.apksfull.task.TaskType;
import com.vn.apksfull.utils.MyUtils;

public class DetailAppActivity extends DetailAppActivityInit implements
		OnClickListener, TaskType {
	BaseObject dataDetail;
	int positionClick = 0;
	private ArrayList<BaseObject> listData;
	int post1, post2, post3;
	BaseModel model;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		btnReadMoreDes.setOnClickListener(this);
		btnDownload.setOnClickListener(this);
		otIcon.setOnClickListener(this);
		otIcon2.setOnClickListener(this);
		otIcon3.setOnClickListener(this);
		btnDownload.setOnClickListener(this);
		listData = getIntent().getExtras().getParcelableArrayList("listdata");
		positionClick = getIntent().getExtras().getInt("data");
		dataDetail = listData.get(positionClick); // list ung dung cung
													// category, loai bo data da
													// dung roi
		listData.remove(positionClick);
		loadScreenShot(dataDetail);
		updateUI(dataDetail);

		model = new BaseModel() {
			@Override
			public void onSuccess(int taskType, ArrayList<?> list, String msg) {
				super.onSuccess(taskType, list, msg);
				
				closeProgressDialog();
			}

			@Override
			public void onFail(int taskType, String msg) {
				super.onFail(taskType, msg);
				
				showToast(msg);
				closeProgressDialog();
			}
		};

	}

	private void updateUI(BaseObject dataIntent2) {
		String content = dataIntent2.get(AppOj.APP_CONTENT);
		if (content.length() > 400) {
			content = content.substring(0, 400);
			btnReadMoreDes.setVisibility(View.VISIBLE);
		} else
			btnReadMoreDes.setVisibility(View.INVISIBLE);
		app_version.setText(getString(R.string.version_string)
				+ dataIntent2.get(AppOj.APP_VERSION));
		app_os.setText(getString(R.string.require)
				+ dataIntent2.get(AppOj.APP_OS));
		app_title.setText(dataIntent2.get(AppOj.APP_TITLE));
		ViewUtils.loadDataWv(app_content, content);
		app_size.setText(getString(R.string.size)
				+ dataIntent2.get(AppOj.APP_SIZE));
		app_author.setText(dataIntent2.get(AppOj.APP_AUTHOR));
		ImageLoader.getInstance().displayImage(dataIntent2.get(AppOj.APP_ICON),
				app_icon);

		if (listData.size() > 10) {
			post1 = new Random().nextInt(8);
			post2 = post1 + 1;
			post3 = 0;
			if (post1 > 2)
				post3 = post1 - 2;

			otName.setText(listData.get(post1).get(AppOj.APP_TITLE));
			otName2.setText(listData.get(post2).get(AppOj.APP_TITLE));
			otName3.setText(listData.get(post3).get(AppOj.APP_TITLE));
			ImageLoader.getInstance().displayImage(
					listData.get(post1).get(AppOj.APP_ICON), otIcon);
			ImageLoader.getInstance().displayImage(
					listData.get(post2).get(AppOj.APP_ICON), otIcon2);
			ImageLoader.getInstance().displayImage(
					listData.get(post3).get(AppOj.APP_ICON), otIcon3);

		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			Intent intent = new Intent(this, HomeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

	private void loadScreenShot(BaseObject dataIntent2) {
		String urlscr = dataIntent2.get(AppOj.APP_SCREENSHOTS);
		ArrayList<String> arr = new ArrayList<String>();
		try {
			JSONArray jar = new JSONArray(urlscr);
			for (int i = 0; i < jar.length(); i++) {
				arr.add(jar.get(i).toString());
			}
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		if (arr.size() > 0) {
			ImageLoader.getInstance().displayImage(arr.get(arr.size() - 1),
					image_header);
		}

		loadImageListScorllHorizontal(arr);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnReadMoreDes:
			ViewUtils.loadDataWv(app_content, dataDetail.get(AppOj.APP_CONTENT));
			btnReadMoreDes.setVisibility(View.INVISIBLE);
			break;
		case R.id.otIcon:
			MyUtils.gotoDetail(DetailAppActivity.this, post1, listData);
			finish();
			break;
		case R.id.otIcon2:
			MyUtils.gotoDetail(DetailAppActivity.this, post2, listData);
			finish();
			break;
		case R.id.otIcon3:
			MyUtils.gotoDetail(DetailAppActivity.this, post3, listData);
			finish();
			
		case R.id.btnDownload:
			
			ArrayList<String> list=new ArrayList<String>() ;
			
			list.add(dataDetail.get(AppOj.APP_MAINLINK));
			
			
			TaskQue taskg=new TaskQue(model, TASK_DOWNLOAD, list, DetailAppActivity.this);
			taskg.exe();
			showProgressDialog(DetailAppActivity.this);
			
			break;
		default:
			break;
		}

	}
}
