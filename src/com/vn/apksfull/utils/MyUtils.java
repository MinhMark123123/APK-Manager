package com.vn.apksfull.utils;

import java.util.ArrayList;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.telpoo.frame.object.BaseObject;
import com.vn.apksfull.detailapp.DetailAppActivity;

public class MyUtils {

	public static void gotoDetail(FragmentActivity activity, int position, ArrayList<BaseObject> all) {
		Intent it=new Intent(activity, DetailAppActivity.class);
		it.putExtra("data", position);
		it.putExtra("listdata", all);
		activity.startActivity(it);
		
	}

}
