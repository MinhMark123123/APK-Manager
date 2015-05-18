package com.vn.apksfull.utils;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.vn.apksfull.object.BaseAppObject;

public class ApksTools {

	private Context mContext;

	public ApksTools(Context mContext) {
		super();
		this.mContext = mContext;
	}
	//
	//
	public ArrayList<BaseAppObject> getAppNonSystem() {

		ArrayList<BaseAppObject> appBaselicationInfos = new ArrayList<BaseAppObject>();
		PackageManager packageManager = mContext.getPackageManager();
		ArrayList<ApplicationInfo> applicationInfos = (ArrayList<ApplicationInfo>) packageManager
				.getInstalledApplications(PackageManager.GET_META_DATA);
		for (ApplicationInfo item : applicationInfos) {

			if (packageManager.getLaunchIntentForPackage(item.packageName) != null) {
				// so if it is system app . system app couldn't lauch :)
				String nameAPP = "", packageName = "";
				nameAPP = packageManager.getApplicationLabel(item).toString();
				packageName = item.packageName;
				BaseAppObject app = new BaseAppObject();
				app.set(BaseAppObject.APP_NAME, nameAPP);
				app.set(BaseAppObject.APP_PACKAGENAME, packageName);
				appBaselicationInfos.add(app);
			}
		}
		return appBaselicationInfos;
	}

	public void unInstallApp(String packageName) {
		Intent intent = new Intent(Intent.ACTION_DELETE);
		intent.setData(Uri.parse("package:" + packageName));
		mContext.startActivity(intent);

	}

	public Drawable getIcon(String packageName) throws NameNotFoundException {
		return mContext.getPackageManager().getApplicationIcon(packageName);
	}

	public PermissionInfo[] getAppPermission(String packageName) {
		PackageManager manager = mContext.getPackageManager();
		ArrayList<PackageInfo> packageInfos = (ArrayList<PackageInfo>) manager
				.getInstalledPackages(PackageManager.GET_PERMISSIONS
						| PackageManager.GET_PROVIDERS);
		for (int i = 0; i < packageInfos.size(); i++) {
			
			if( packageInfos.get(i).packageName.equals(packageName) ){
				return packageInfos.get(i).permissions;
			}
		}	
		return null;
	}
	public String checkProtectionLevel(PermissionInfo permissionInfo){
		String protectionLevel = "";
		if(permissionInfo != null){
			switch (permissionInfo.protectionLevel) {
			case PermissionInfo.PROTECTION_NORMAL: protectionLevel = "Binh thuong"; break;
			case PermissionInfo.PROTECTION_DANGEROUS: protectionLevel = "Nguy hiem"; break;
			case PermissionInfo.PROTECTION_SIGNATURE: protectionLevel = "Dang ki"; break;
			case PermissionInfo.PROTECTION_SIGNATURE_OR_SYSTEM: protectionLevel = "He thong hoac dang ki"; break;
			default: protectionLevel = " <unknow>";
				break;
			}
		}
		return protectionLevel;
	}
	public String protectionLevel(String packageName){
		
		String status = "";
		PermissionInfo[] permissionInfos = getAppPermission(packageName);
		for(PermissionInfo item  : permissionInfos){
			if(checkProtectionLevel(item).equals("Nguy hiem")){
				status =  "Nguy hiem";
			}
		}
		if(status.equals("Nguy hiem")){
			return "Nguy hiem";
		}else{
			return "Binh thuong";
		}
		
		
	}
	public String getVersionName(String packageName){
		String versionCode = "";
		PackageManager packageManager = mContext.getPackageManager();
		try {
			PackageInfo pageInfo = packageManager.getPackageInfo(packageName, 0);
			versionCode = pageInfo.versionName ;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return versionCode;
	}
	public String toFinalPrms(String srcPermission){
		String path1 = "", path2 = "", permission= "";
		String[] array = srcPermission.split("\\{");
		path1 = array[1];
		String[] array2 = path1.split(" ");
		path2 = array2[1];
		permission = path2.replace("}", "");
		return permission;
		
	}
	

}
