package com.vn.apksfull.listview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.telpoo.frame.model.BaseModel;
import com.telpoo.frame.object.BaseObject;
import com.vn.apksfull.HomeActivity;
import com.vn.apksfull.MyFragment;
import com.vn.apksfull.R;
import com.vn.apksfull.TabId;
import com.vn.apksfull.adapter.CategoryAdapter;
import com.vn.apksfull.object.CategoryObj;
import com.vn.apksfull.task.TaskMinh;

public class CategoryFragment extends MyFragment implements OnItemClickListener {

	private CategoryAdapter mAdapterListview;
	private ListView mListView;
	private String app_catid;
	private int curPage = 0;
	BaseModel model;
	Button btn;
	View progress;
	public static CategoryFragment newInstance(String app_catid) {
		CategoryFragment categoryFragment = new CategoryFragment();
		Bundle bundle = new Bundle();
		bundle.putString("app_catid", app_catid);
		categoryFragment.setArguments(bundle);
		return categoryFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_apk_category,
				container, false);
		mListView = (ListView) rootView.findViewById(R.id.category_listview);
		//
		app_catid = getArguments().getString("app_catid");
		progress= rootView.findViewById(R.id.progress);
		btn= (Button) rootView.findViewById(R.id.btn);
		//
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// TODO Auto-generated method stub
		mListView.setOnItemClickListener(this);

		if (mAdapterListview == null) {
			mAdapterListview = new CategoryAdapter(getActivity(),
					R.layout.item_category, new ArrayList<BaseObject>());
		}
		mListView.setAdapter(mAdapterListview);
		model = new BaseModel() {
			@Override
			public void onSuccess(int taskType, ArrayList<?> list, String msg) {
				super.onSuccess(taskType, list, msg);

				switch (taskType) {
				case TASK_LOAD_CATEGORY:
					uiWhenSuccess();
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
				case TASK_LOAD_CATEGORY:
					--curPage;
					 showToast(msg);
					uiWhenFail();
					break;

				default:
					break;
				}

			}
		};
		
		
		loadData();
	}
	private void loadData() {
		uiWhenLoading();
		++curPage;
		ArrayList<String> list = new ArrayList<String>();
		list.add(app_catid);
		list.add(curPage + "");

		TaskMinh taskQ = new TaskMinh(model, TASK_LOAD_CATEGORY, list, getActivity());
		taskQ.exe();
	}

	@Override
	public void onSuccess(int taskType, ArrayList<?> list, String msg) {
		// TODO Auto-generated method stub
		super.onSuccess(taskType, list, msg);
		switch (taskType) {
		case TASK_LOAD_CATEGORY:
			uiWhenSuccess();
			mAdapterListview.Adds((List<BaseObject>) list);

			break;

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		BaseObject oj= (BaseObject) parent.getAdapter().getItem(position);
		HomeActivity.Instance().pushFragments(TabId.home, MyFragmentTS.newInstance(oj.get(CategoryObj.KEY_CAID)),false,"");
		
	}
	
	private void uiWhenLoading(){
		progress.setVisibility(View.VISIBLE);
		btn.setVisibility(View.GONE);
	}
	
	private void uiWhenFail(){
		progress.setVisibility(View.GONE);
		btn.setVisibility(View.VISIBLE);
	}
	
	private void uiWhenSuccess(){
		progress.setVisibility(View.GONE);
		btn.setVisibility(View.GONE);
	}
	
	

}
