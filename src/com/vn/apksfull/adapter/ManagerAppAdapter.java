package com.vn.apksfull.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vn.apksfull.R;
import com.vn.apksfull.object.ManagerAppObj;
import com.vn.apksfull.utils.AppTools;

public class ManagerAppAdapter extends ArrayAdapter<ManagerAppObj> {

	private ArrayList<ManagerAppObj> mManagerAppObj;
	private Context mContext;
	private int mResource;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mManagerAppObj.size();
	}
	public ManagerAppAdapter(Context mContext, int mResource,
			ArrayList<ManagerAppObj> mManagerAppObj) {
		super(mContext, mResource, mManagerAppObj);
		this.mManagerAppObj = mManagerAppObj;
		this.mContext = mContext;
		this.mResource = mResource;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(convertView==null){
			viewHolder=new ViewHolder();
			LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(mResource, parent,false);
			viewHolder.mNameApp=(TextView)convertView.findViewById(R.id.tv_app_name_app);
			viewHolder.mVersion=(TextView) convertView.findViewById(R.id.tv_app_version);
			viewHolder.mSize=(TextView) convertView.findViewById(R.id.tv_app_size);
			viewHolder.mStatus=(TextView) convertView.findViewById(R.id.tv_app_status);
			viewHolder.mImageView=(ImageView) convertView.findViewById(R.id.img_icon_app);
			viewHolder.mImageDelete = (ImageView) convertView.findViewById(R.id.img_delete);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.mNameApp.setText(mManagerAppObj.get(position).get(ManagerAppObj.APP_NAME));
		if(mManagerAppObj.get(position).get(ManagerAppObj.APP_STATUS).equals("Nguy hiem")){
			viewHolder.mStatus.setTextColor(Color.RED);
			viewHolder.mStatus.setText(mContext.getResources().getString(R.string.permission_dangerous));
		}else{
			viewHolder.mStatus.setTextColor(mContext.getResources().getColor(R.color.text_normal));
			viewHolder.mStatus.setText(mContext.getResources().getString(R.string.permission_normal));
		}		
		//if(viewHolder.mStatus.getText())
		viewHolder.mVersion.setText(mContext.getResources().getString(R.string.version_string)+mManagerAppObj.get(position).get(ManagerAppObj.APP_VERSION));
		viewHolder.mSize.setText(mManagerAppObj.get(position).get(ManagerAppObj.APP_SIZE));
		Drawable drawable = mManagerAppObj.get(position).getImageApp();
		if(drawable != null){
			viewHolder.mImageView.setImageDrawable(drawable);
		}else{
			viewHolder.mImageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_launcher));
		}
		final int ps = position; 
		viewHolder.mImageDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AppTools appTools = new AppTools(mContext);
				appTools.unInstallApp(mManagerAppObj.get(ps).get(ManagerAppObj.APP_PACKAGE_APP));
				remove(mManagerAppObj.get(ps));
			}
		});	
		return convertView;
	}
	
	private class ViewHolder {
		// TODO Auto-generated method stub
		TextView mNameApp, mVersion,mStatus,mSize;
		ImageView mImageView, mImageDelete;
	}
	public void notifydataApp(){
		notifyDataSetChanged();
	}
	/**
	 * return true if item is dangerous else false
	 * @return
	 */
	public boolean getStatusIsDangerous(int position){
		if(mManagerAppObj.get(position).get(ManagerAppObj.APP_STATUS).equals("Nguy hiem")){
			return true;
		}
		return false;
	}
}
