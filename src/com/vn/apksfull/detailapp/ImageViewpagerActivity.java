package com.vn.apksfull.detailapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

import com.telpoo.frame.ui.BetaBaseActionbarActivity;
import com.vn.apksfull.R;
import com.vn.apksfull.adapter.ViewPagerImageAdapter;

public class ImageViewpagerActivity extends BetaBaseActionbarActivity{

	private ViewPager mViewPager;	
	private ViewPagerImageAdapter mViewPagerImageAdapter;	
	private int mPostion;
	public final static String POSITION_IMAGE = "postion_image";
	 ArrayList<String> urlScreenshot;
	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
		urlScreenshot= getIntent().getStringArrayListExtra("listimg");
		setContentView(R.layout.activity_viewimage_app);		
		Bundle bundle = getIntent().getExtras();
		if(bundle != null){
			mPostion = bundle.getInt(POSITION_IMAGE);
		}		
		setContentView(R.layout.activity_viewimage_app);
		
		mViewPager = (ViewPager) findViewById(R.id.activity_viewimage_pager);
		
		mViewPagerImageAdapter = new ViewPagerImageAdapter(getSupportFragmentManager(),urlScreenshot);
		mViewPager.setAdapter(mViewPagerImageAdapter);
		mViewPager.setCurrentItem(mPostion);
		
	}
}
