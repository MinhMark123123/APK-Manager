package com.vn.apksfull.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePrefsSupport {
	
	private Context mContext;
	//private String mNameSharePrefs;
	public static String NAME_PREFS = "share_prefs";
	public static String TOKEN_ACCCOUTN_GOOGLE = "token_google";
	public static String NAME_ACCCOUTN_GOOGLE = "name_google";
	public static String EMAIL_ACCCOUTN_GOOGLE = "email_google";
	public static String PIC_ACCCOUTN_GOOGLE = "pic_google";
	private SharedPreferences mSharedPreferences;

	
	public SharePrefsSupport(Context mContext) {
		super();
		this.mContext = mContext;
		
		mSharedPreferences = mContext.getSharedPreferences( NAME_PREFS, Context.MODE_PRIVATE);
	}


	public void saveString(String key ,String value){
		Editor editor = mSharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	/**
	 * load data from shareprefs 
	 * @param key 
	 * @return string value of key in shareprefs with default is "unknow"
	 */
	public String loadString(String key){		
		return mSharedPreferences.getString(key, "unknow");
	}
	
}
