package com.vn.apksfull.detailapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.vn.apksfull.MyFragment;
import com.vn.apksfull.R;

public class FragmentImage extends MyFragment{
	//private ArrayList<Drawable> mDrawables;
	private int[] mImageIds = {R.drawable.screen1, R.drawable.screen2, R.drawable.screen3, R.drawable.screen4, R.drawable.screen5};
	private ImageView mImageView;
	private static final String LINK_IMAGE = "LINK_IMAGE";
	public static FragmentImage newInstance(String url){
		FragmentImage fragmentImage = new FragmentImage();
		Bundle bundle = new Bundle();
		bundle.putString(LINK_IMAGE, url);
		fragmentImage.setArguments(bundle);
		return fragmentImage;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		String url = getArguments().getString(LINK_IMAGE);
		View rootView = inflater.inflate(R.layout.fragment_image_details, container, false);		
		mImageView = (ImageView) rootView.findViewById(R.id.fragment_image_details_image);
		
		ImageLoader.getInstance().displayImage(url, mImageView);
		return rootView;
	}
}
