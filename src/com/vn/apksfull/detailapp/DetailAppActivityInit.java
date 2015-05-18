package com.vn.apksfull.detailapp;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.telpoo.frame.ui.BetaBaseActionbarActivity;
import com.vn.apksfull.R;
import com.vn.apksfull.utils.NotifyingScrollView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailAppActivityInit extends BetaBaseActionbarActivity {
	private Drawable mActionbarDrawable;
	private HorizontalScrollView mHorizontalScrollView;
	private NotifyingScrollView.OnScrollChangedListener mOnScrollChangedListener = new NotifyingScrollView.OnScrollChangedListener() {

		@Override
		public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
			// TODO Auto-generated method stub
			ImageView imageView = (ImageView) findViewById(R.id.image_header);
			final int headerHeight = imageView.getHeight() - getSupportActionBar().getHeight();
			Log.d("ABC", "[DetailAppActivity]-onscrollchange imagevieew getheight : " + imageView.getHeight() + " actionbar height = " + getSupportActionBar().getHeight());
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
			final int newAlpha = (int) (ratio * 255);
			mActionbarDrawable.setAlpha(newAlpha);
		}
	};

	protected TextView app_version, app_os, app_title, app_size, app_author, otName, otName2, otName3;
	protected WebView app_content;
	protected ImageView image_header, app_icon;
	protected Button btnReadMoreDes, btnDownload;
	protected ImageView otIcon, otIcon2, otIcon3;

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_home_detail);

		otIcon = (ImageView) findViewById(R.id.otIcon);
		otIcon2 = (ImageView) findViewById(R.id.otIcon2);
		otIcon3 = (ImageView) findViewById(R.id.otIcon3);
		otName = (TextView) findViewById(R.id.otName);
		otName2 = (TextView) findViewById(R.id.otName2);
		otName3 = (TextView) findViewById(R.id.otName3);

		app_version = (TextView) findViewById(R.id.app_version);
		app_os = (TextView) findViewById(R.id.app_os);
		app_title = (TextView) findViewById(R.id.app_title);
		app_content = (WebView) findViewById(R.id.app_content);
		app_size = (TextView) findViewById(R.id.app_size);
		app_author = (TextView) findViewById(R.id.app_author);

		btnReadMoreDes = (Button) findViewById(R.id.btnReadMoreDes);
		btnDownload = (Button) findViewById(R.id.btnDownload);

		image_header = (ImageView) findViewById(R.id.image_header);
		app_icon = (ImageView) findViewById(R.id.app_icon);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		mActionbarDrawable = new ColorDrawable(Color.parseColor("#bf3e11"));
		mActionbarDrawable.setAlpha(0);
		actionBar.setBackgroundDrawable(mActionbarDrawable);
		actionBar.setDisplayHomeAsUpEnabled(true);
		mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.activity_home_detail_horizontalImageview);
		// ----------------------------- this is is i don;t know
		// aaaaaaaaaaaaaaaaaaaaaaaaaaa
		//
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
			mActionbarDrawable.setCallback(mDrawableCallback);
		}
		//

		((NotifyingScrollView) findViewById(R.id.notify_scrollview)).setOnScrollChangedListener(mOnScrollChangedListener);

	};

	private Drawable.Callback mDrawableCallback = new Drawable.Callback() {
		@Override
		public void invalidateDrawable(Drawable who) {
			getSupportActionBar().setBackgroundDrawable(who);
		}

		@Override
		public void scheduleDrawable(Drawable who, Runnable what, long when) {
		}

		@Override
		public void unscheduleDrawable(Drawable who, Runnable what) {
		}
	};

	protected void loadImageListScorllHorizontal(final ArrayList<String> urlScreenshot) {
		// create layout store image
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		// set layout params with width = wrap_content and height =
		// mathc_parrent
		linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
		//
		for (int i = 0; i < urlScreenshot.size(); i++) {
			ImageView imageView = new ImageView(this);
			// imageView.setImageDrawable(this.getResources().getDrawable(
			// mIdImageDrawable.get(i)));
			imageView.setLayoutParams(new LayoutParams(500, ViewGroup.LayoutParams.MATCH_PARENT));
			int scale;
			scale = (imageView.getWidth() / 500);
			// imageView.setsca

			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			final int position = i;
			imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(DetailAppActivityInit.this, ImageViewpagerActivity.class);
					intent.putExtra(ImageViewpagerActivity.POSITION_IMAGE, position);
					intent.putExtra("listimg", urlScreenshot);

					startActivity(intent);
				}
			});
			linearLayout.addView(imageView);
			ImageLoader.getInstance().displayImage(urlScreenshot.get(i), imageView);
		}
		mHorizontalScrollView.addView(linearLayout);
	}
}
