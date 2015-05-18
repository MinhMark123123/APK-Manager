package com.vn.apksfull.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.telpoo.frame.adapter.TelpooAdapter;
import com.telpoo.frame.object.BaseObject;
import com.vn.apksfull.R;
import com.vn.apksfull.object.CategoryObj;

public class CategoryAdapter extends TelpooAdapter {

	private Context context;
	private int resource;
	private ArrayList<BaseObject> objects;

	public CategoryAdapter(Context context, int resource, ArrayList<BaseObject> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.resource = resource;
		this.objects = objects;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return objects.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// View rootView
		ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(resource, parent, false);
			//
			viewHolder.mAppCatNameTV = (TextView) convertView.findViewById(R.id.item_category_catname_tv);
			viewHolder.mCountTV = (TextView) convertView.findViewById(R.id.item_category_count_tv);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.mAppCatNameTV.setText(objects.get(position).get(CategoryObj.KEY_APP_NAME));
		viewHolder.mCountTV.setText("Count: "+objects.get(position).get(CategoryObj.KEY_COUNT));
		return convertView;
	}

	private class ViewHolder {
		TextView mAppCatNameTV, mCountTV;
	}

}
