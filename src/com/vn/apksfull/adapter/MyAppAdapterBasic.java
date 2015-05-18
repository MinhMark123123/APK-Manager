package com.vn.apksfull.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.telpoo.frame.adapter.TelpooAdapter;
import com.telpoo.frame.object.BaseObject;
import com.vn.apksfull.R;
import com.vn.apksfull.object.BaseAppBasicObj;

public class MyAppAdapterBasic extends TelpooAdapter {

	private ArrayList<BaseObject> mAppBasicObjs;
	private Context mContext;
	private int mResource;

	public MyAppAdapterBasic(Context mContext, int mResource,
			ArrayList<BaseObject> mAppBasicObjs) {
		super(mContext, mResource, mAppBasicObjs);
		this.mAppBasicObjs = mAppBasicObjs;
		this.mContext = mContext;
		this.mResource = mResource;
	}

	@Override
	public int getCount() {
		return mAppBasicObjs.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			// convertView = (new LayoutInflater()).inflate(mResource, parent,
			// false);
			viewHolder = new ViewHolder();
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(mResource, parent, false);
			viewHolder.mNameApp = (TextView) convertView.findViewById(R.id.listview_item_nameapp);
			viewHolder.mShortName = (TextView) convertView.findViewById(R.id.listview_item_nameshort);
			viewHolder.mCountDown = (TextView) convertView.findViewById(R.id.listview_item_countdown);
			viewHolder.mSize = (TextView) convertView.findViewById(R.id.listview_item_size);
			viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.listview_item_imageview);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.mNameApp.setText(mAppBasicObjs.get(position).get(BaseAppBasicObj.APP_NAME));
		viewHolder.mShortName.setText(mAppBasicObjs.get(position).get(BaseAppBasicObj.APP_SHORTNAME));
		viewHolder.mCountDown.setText(mAppBasicObjs.get(position).get(BaseAppBasicObj.APP_COUNTDOWN));
		viewHolder.mSize.setText(mAppBasicObjs.get(position).get(BaseAppBasicObj.APP_SIZE));
		viewHolder.mImageView.setImageResource(R.drawable.ic_launcher);
		ImageLoader.getInstance().displayImage(mAppBasicObjs.get(position).get(BaseAppBasicObj.APP_LINKIMAGE), viewHolder.mImageView);
		
		// viewHolder.mNameApp.setText(mAppBasicObjs.get(position).get(BaseAppBasicObj.APP_NAME));
		return convertView;
	}

	private class ViewHolder {
		TextView mNameApp, mShortName, mCountDown, mSize;
		ImageView mImageView;
	}

}
