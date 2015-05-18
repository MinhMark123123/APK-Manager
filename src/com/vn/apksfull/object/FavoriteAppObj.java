package com.vn.apksfull.object;

import com.telpoo.frame.object.BaseObject;

public class FavoriteAppObj extends BaseObject{
	public static final String[] keys = { "appname", "version", "size",
		"status", "imageapp", "isfavorite" };
		public static final String FAVORITE_NAME = keys[0];
		public static final String FAVORITE_VERSION = keys[1];
		public static final String FAVORITE_SIZE = keys[2];
		public static final String FAVORITE_STATUS = keys[3];
		public static final String FAVORITE_IMAGE_APP = keys[4];
		public static final String FAVORITE_IS_FAVORITE = keys[5];
}
