package com.vn.apksfull.object;

import android.graphics.drawable.Drawable;

public class LVAppObject {
	
	String appName, version, size, status;
	Drawable drawable;
	public LVAppObject(String appName, String version, String size,
			String status, Drawable drawable) {
		super();
		this.appName = appName;
		this.version = version;
		this.size = size;
		this.status = status;
		this.drawable = drawable;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Drawable getDrawable() {
		return drawable;
	}
	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}
	
}
