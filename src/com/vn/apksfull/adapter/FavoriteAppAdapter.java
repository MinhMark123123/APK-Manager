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
import com.vn.apksfull.object.BaseAppBasicObj;
import com.vn.apksfull.object.FavoriteAppObj;

public class FavoriteAppAdapter extends ArrayAdapter<FavoriteAppObj> {

	private ArrayList<FavoriteAppObj> mAppBasicObjs;
	private Context mContext;
	private int mResource;

	public FavoriteAppAdapter(Context mContext, int mResource,
			ArrayList<FavoriteAppObj> mAppBasicObjs) {
		super(mContext, mResource, mAppBasicObjs);
		// TODO Auto-generated constructor stub
		this.mAppBasicObjs = mAppBasicObjs;
		this.mContext = mContext;
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
		if (convertView == null) {
			// convertView = (new LayoutInflater()).inflate(mResource, parent,
			// false);
			viewHolder = new ViewHolder();
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(mResource, parent, false);
			viewHolder.mNameApp = (TextView) convertView.findViewById(R.id.fragment_apk_item_favorite_nametv);
			viewHolder.mVersion = (TextView) convertView.findViewById(R.id.fragment_item_favoriteapp_versiontv);
			viewHolder.mStatus = (TextView) convertView.findViewById(R.id.fragment_item_favoriteapp_status);
			viewHolder.mSize = (TextView) convertView.findViewById(R.id.fragment_item_favoriteapp_size);
			viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.fragment_item_favoriteapp_imgapp);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.mNameApp.setText( mAppBasicObjs.get(position).get(FavoriteAppObj.FAVORITE_NAME));
		viewHolder.mVersion.setText( mAppBasicObjs.get(position).get(FavoriteAppObj.FAVORITE_VERSION));
		viewHolder.mStatus.setText( mAppBasicObjs.get(position).get(FavoriteAppObj.FAVORITE_STATUS));
		viewHolder.mSize.setText( mAppBasicObjs.get(position).get(FavoriteAppObj.FAVORITE_SIZE));
		viewHolder.mImageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_app4));
		 
		return convertView;
	}

	private class ViewHolder {
		TextView mNameApp, mVersion, mStatus, mSize;
		ImageView mImageView, mIcon;
	}

}
