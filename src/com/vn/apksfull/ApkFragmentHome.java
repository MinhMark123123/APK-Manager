package com.vn.apksfull;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpoo.frame.object.BaseObject;
import com.viewpagerindicator.PageIndicator;
import com.vn.apksfull.adapter.ViewIndicatorPagerAdapter;

public class ApkFragmentHome extends MyFragment{
	
	ViewIndicatorPagerAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    private ArrayList<BaseObject> data;
    private static String PASS_DATA = "VIEWPAGER_TYPESHOW"; 
    public static ApkFragmentHome newInstance(ArrayList<BaseObject> data){
    	ApkFragmentHome apkFragmentHome = new ApkFragmentHome();
    	Bundle bundle = new Bundle();
    	bundle.putParcelableArrayList(PASS_DATA, data);
    	apkFragmentHome.setArguments(bundle);
    	return apkFragmentHome;
    }    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_apk_home, container , false);
		data = getArguments().getParcelableArrayList(PASS_DATA);
		
		mPager = (ViewPager) rootView.findViewById(R.id.pager);
		//--------------------------><------------------------------------------------		
		mAdapter = new ViewIndicatorPagerAdapter(getChildFragmentManager(),data, getActivity());
		mPager.setAdapter(mAdapter);
		mPager.setOffscreenPageLimit(3);
		//----------------------------------------------------------------------------
		mIndicator = (PageIndicator) rootView.findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
		mPager.setCurrentItem(0);
		//----------------------------------------------------------------------------
		
		return rootView;
	}
}
