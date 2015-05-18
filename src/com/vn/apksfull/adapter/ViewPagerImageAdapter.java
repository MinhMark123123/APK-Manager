package com.vn.apksfull.adapter;

import java.util.ArrayList;

import com.vn.apksfull.detailapp.FragmentImage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.AdapterView;

public class ViewPagerImageAdapter extends FragmentStatePagerAdapter{

	private ArrayList<String> urlScreenshot;

	public ViewPagerImageAdapter(FragmentManager fm,ArrayList<String> urlScreenshot) {
		super(fm);
		this.urlScreenshot = urlScreenshot;
	}

	@Override
	public Fragment getItem(int arg0) {
		return FragmentImage.newInstance(urlScreenshot.get(arg0));
	}

	@Override
	public int getCount() {
		return urlScreenshot.size();
	}

	
	

}
