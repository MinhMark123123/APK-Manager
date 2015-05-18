package com.vn.apksfull.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.telpoo.frame.model.BaseModel;
import com.telpoo.frame.object.BaseObject;
import com.telpoo.frame.utils.Utils;
import com.vn.apksfull.MyFragment;
import com.vn.apksfull.R;
import com.vn.apksfull.adapter.MyAppAdapterBasic;
import com.vn.apksfull.detailapp.DetailAppActivity;
import com.vn.apksfull.task.TaskQue;
import com.vn.apksfull.utils.MyUtils;

public class MyFragmentTS extends MyFragment implements OnItemClickListener {

	private MyAppAdapterBasic mAdapterListview;
	private ListView mListView;
	private String app_catid;
	// private ArrayList<BaseAppBasicObj> mAppBasicObjs;
	// private ArrayList<ManagerAppObj> mManagerAppArray;
	// private ArrayList<ManagerApkObj> mManagerApkArray;
	// private FavoriteAppAdapter mFavoriteAppAdapter;
	// private ArrayList<FavoriteAppObj> mFavoriteAppObArrayList;
	// private ArrayList<LVAppObject> mLvAppObjects;
	// private ActionBar mActionBar;
	private ProgressDialog mProgressDialog;
	private int curPage = 0;
	View progressLv;
	private boolean isLoading = false;
	BaseModel model;

	public static MyFragmentTS newInstance(String app_catid) {
		MyFragmentTS myFragmentTS = new MyFragmentTS();
		Bundle bundle = new Bundle();
		bundle.putString("app_catid", app_catid);
		myFragmentTS.setArguments(bundle);
		return myFragmentTS;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_apk_listview,
				container, false);

		app_catid = getArguments().getString("app_catid");
		mListView = (ListView) rootView.findViewById(R.id.listview);
		mListView.setOnItemClickListener(this);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		progressLv = getLayoutInflater(savedInstanceState).inflate(
				R.layout.progress, null, false);
		mListView.addFooterView(progressLv);
		if (mAdapterListview == null)
			mAdapterListview = new MyAppAdapterBasic(getActivity(),
					R.layout.listview_item, new ArrayList<BaseObject>());
		mListView.setAdapter(mAdapterListview);
		mListView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView arg0, int arg1) {

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {

				if (firstVisibleItem + visibleItemCount == totalItemCount - 5) {
					loadData();
				}

			}
		});

		model = new BaseModel() {
			@Override
			public void onSuccess(int taskType, ArrayList<?> list, String msg) {
				super.onSuccess(taskType, list, msg);

				switch (taskType) {
				case TASK_GET_APP:
					isLoading = false;

					mAdapterListview.Adds((List<BaseObject>) list);

					break;

				default:
					break;
				}
			}

			@Override
			public void onFail(int taskType, String msg) {
				super.onFail(taskType, msg);

				switch (taskType) {
				case TASK_GET_APP:
					--curPage;
					// showToast(msg);
					isLoading = false;

					break;

				default:
					break;
				}

			}
		};

		loadData();

	}

	private void loadData() {
		if (isLoading)
			return;
		isLoading = true;
		++curPage;
		ArrayList<String> list = new ArrayList<String>();
		list.add(app_catid);
		list.add(curPage + "");

		TaskQue taskQ = new TaskQue(model, TASK_GET_APP, list, getActivity());
		taskQ.exe();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		MyUtils.gotoDetail(getActivity(), arg2, mAdapterListview.getAll());

	}

}
