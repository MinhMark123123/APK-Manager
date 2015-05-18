package com.vn.apksfull.object;

import android.graphics.drawable.Drawable;

import com.telpoo.frame.object.BaseObject;

public class ManagerAppObj extends BaseObject {

	public static final String[] keys = { "appname", "version", "size",
			"status",  "package" };
	public Drawable imageApp;
	public static final String APP_NAME = keys[0];
	public static final String APP_VERSION = keys[1];
	public static final String APP_SIZE = keys[2];
	public static final String APP_STATUS = keys[3];
	public static final String APP_PACKAGE_APP = keys[4];
	
	public Drawable getImageApp() {
		return imageApp;
	}
	public void setImageApp(Drawable imageApp) {
		this.imageApp = imageApp;
	}
	

}
