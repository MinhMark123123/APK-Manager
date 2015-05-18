package com.vn.apksfull.listview;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vn.apksfull.MyFragment;
import com.vn.apksfull.R;
import com.vn.apksfull.adapter.ManagerApkAdapter;
import com.vn.apksfull.adapter.ManagerAppAdapter;
import com.vn.apksfull.object.ManagerApkObj;
import com.vn.apksfull.object.ManagerAppObj;

public class FragmentManager extends MyFragment {

	public static String STYLE_SHOW_KEY = "styleshowkey";
	public final static int LISTSHOW_MANAGERAPP = 0;
	public final static int LISTSHOW_MANAGERAPK = 1;

	private ManagerAppAdapter mAdapterLvApp;
	private ManagerApkAdapter mAdapterLvApk;
	private ListView mListView;
	private ArrayList<ManagerAppObj> mManagerAppObj;
	private ArrayList<ManagerApkObj> mManagerApkObj;

	public static FragmentManager newInstance(int stypeShow) {
		FragmentManager myFragmentManager = new FragmentManager();
		Bundle bundle = new Bundle();
		bundle.putInt(STYLE_SHOW_KEY, stypeShow);
		myFragmentManager.setArguments(bundle);
		return myFragmentManager;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_apk_list_mng,
				container, false);
		int type = getArguments().getInt(STYLE_SHOW_KEY);
		mListView = (ListView) rootView.findViewById(R.id.lv_mng);

		loadData(type);

		return rootView;
	}

	private void loadData(int type) {
		switch (type) {
		case LISTSHOW_MANAGERAPP:
			mManagerAppObj = new ArrayList<ManagerAppObj>();
			loadDataListApp();
			mAdapterLvApp = new ManagerAppAdapter(getActivity(),
					R.layout.fragment_apk_item_mng_app, mManagerAppObj);
			mListView.setAdapter(mAdapterLvApp);
			break;
		case LISTSHOW_MANAGERAPK:

			mManagerApkObj = new ArrayList<ManagerApkObj>();
			loadDataListApk();
			mAdapterLvApk = new ManagerApkAdapter(getActivity(),
					R.layout.fragment_apk_item_mng_apk, mManagerApkObj);
			mListView.setAdapter(mAdapterLvApk);
			break;

		default:
			break;
		}
	}

	private void loadDataListApp() {
		// mAppBasicObjs = new ArrayList<BaseAppBasicObj>();
		for (int i = 0; i < 10; i++) {
			ManagerAppObj appObject = new ManagerAppObj();
			appObject.set(ManagerAppObj.APP_NAME, (i+1) + ". Name App");
			appObject.set(ManagerAppObj.APP_VERSION, "Phiên bản hiện tại:" + i);
			appObject.set(ManagerAppObj.APP_STATUS,
					"Trạng thái ứng dụng: An toàn");
			//appObject.set(ManagerAppObj.APP_IMAGE_APP, "chua cap nhat");
			appObject.set(ManagerAppObj.APP_SIZE, ((i * 1000) / 2) + "MB");
			mManagerAppObj.add(appObject);
		}
	}

	private void loadDataListApk() {
		// mAppBasicObjs = new ArrayList<BaseAppBasicObj>();
		for (int i = 0; i < 10; i++) {
			ManagerApkObj apkObject = new ManagerApkObj();
			apkObject.set(ManagerApkObj.APK_NAME, (i+1) + ". Name App");
			apkObject.set(ManagerApkObj.APK_DIRECTORY, "/mnt/sdcard/" + i);
			apkObject.set(ManagerApkObj.APK_STATUS,
					"Trạng thái ứng dụng: An toàn");
			apkObject.set(ManagerApkObj.APK_IMAGE_APK, "chua cap nhat");
			apkObject.set(ManagerApkObj.APK_SIZE, ((i * 1000) / 2) + "MB");
			mManagerApkObj.add(apkObject);
		}
	}
}
