package com.vn.apksfull.adapter;

import java.util.ArrayList;

import com.telpoo.frame.object.BaseObject;
import com.vn.apksfull.R;
import com.vn.apksfull.listview.CategoryFragment;
import com.vn.apksfull.listview.MyFragmentTS;
import com.vn.apksfull.utils.Common;
import com.vn.apksfull.utils.TestFm;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewIndicatorPagerAdapter extends FragmentStatePagerAdapter {

//	protected static final String[] CONTENT = new String[] { "New App",
//			"Top Download", "Top Hot" };	
//	protected static final int[] CONTENT = new int[] { R.string.tag_newapp,
//		R.string.tag_topdownload, R.string.tag_tophotapp };
	//private int mCount = CONTENT.length;	
	//private int mTypeShow;
	private Context mContext;
	private ArrayList<BaseObject> ojs;

	public ViewIndicatorPagerAdapter(FragmentManager fm,ArrayList<BaseObject> ojs, Context mContext) {
		super(fm);
		this.ojs = ojs;
		this.mContext = mContext;
	}

	@Override
	public Fragment getItem(int position) {
		if(position==1)
		return MyFragmentTS.newInstance(ojs.get(position).get("app_catid"));
		else return CategoryFragment.newInstance(Common.CATID_CATEGORYED);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return ojs.get(position).get("title");
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//if(mTypeShow == 1){
		return ojs.size();
		
	}

}
