package com.vn.apksfull.utils;

import com.telpoo.frame.utils.Cons.Defi;
import com.telpoo.frame.utils.Utils;

import android.content.Context;

public class MySpr {
	public static void saveToken(Context context, String token){
		Utils.saveStringSPR("gtoken", token, context);
	}
	
	public static String getToken(Context context){
		String tk= Utils.getStringSPR("gtoken", context);
		if(Defi.SPR_GET_FALL.equals(tk)) return null;
		return tk;
		
	}

}
