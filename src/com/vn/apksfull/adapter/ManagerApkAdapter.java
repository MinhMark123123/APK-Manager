package com.vn.apksfull.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vn.apksfull.R;
import com.vn.apksfull.object.ManagerApkObj;
import com.vn.apksfull.object.ManagerAppObj;

public class ManagerApkAdapter extends ArrayAdapter<ManagerApkObj> {

	private ArrayList<ManagerApkObj> mManagerApkObj;
	private Context mContext;
	private int mResource;

	public ManagerApkAdapter(Context mContext, int mResource,
			ArrayList<ManagerApkObj> mManagerApkObj) {
		super(mContext, mResource, mManagerApkObj);
		// TODO Auto-generated constructor stub
		this.mContext = mContext;
		this.mManagerApkObj = mManagerApkObj;
		this.mResource = mResource;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(convertView==null){
			viewHolder=new ViewHolder();
			LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(mResource, parent,false);
			viewHolder.mNameApk=(TextView) convertView.findViewById(R.id.tv_apk_name);
			viewHolder.mDirectory=(TextView) convertView.findViewById(R.id.tv_apk_directory);
			viewHolder.mStatus=(TextView) convertView.findViewById(R.id.tv_apk_size);
			viewHolder.mSize=(TextView) convertView.findViewById(R.id.tv_apk_size);
			viewHolder.mImageViewApk=(ImageView) convertView.findViewById(R.id.img_icon_apk);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		viewHolder.mNameApk.setText(mManagerApkObj.get(position).get(ManagerApkObj.APK_NAME));
		viewHolder.mStatus.setText(mManagerApkObj.get(position).get(ManagerApkObj.APK_STATUS));
		viewHolder.mDirectory.setText(mManagerApkObj.get(position).get(ManagerApkObj.APK_DIRECTORY));
		viewHolder.mSize.setText(mManagerApkObj.get(position).get(ManagerApkObj.APK_SIZE));
		viewHolder.mImageViewApk.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_app4));
		return convertView;
	}
	
	private class ViewHolder{
		TextView mNameApk, mDirectory,mStatus,mSize;
		ImageView mImageViewApk;
	}
}
