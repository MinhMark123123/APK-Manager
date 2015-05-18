package com.vn.apksfull.net;

import com.telpoo.frame.utils.FileSupport;

public class NetData {
	public int status; //0=ok ,!0=error
	public String msg;
	public Object data;
	public int errCode;
	public String res;
	public static final int STATUS_CONNECT_ERROR=2;
	public static final int STATUS_NO_NETWORK=3;
	public static final int STATUS_ERROR_SERVER=4;
	public String getMessage(){
		if(msg!=null){
			msg= FileSupport.fromUTF8String(msg);
			return msg;
		}
		if(status==STATUS_NO_NETWORK) return "Không có kết nối mạng";
		if(status==STATUS_ERROR_SERVER) return "Không có phản hồi từ server";
		 
		
		return "Lỗi kết nối, vui lòng kiểm tra lại kết nối mạng";
		 
	}

}
