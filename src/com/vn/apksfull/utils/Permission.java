package com.vn.apksfull.utils;

import android.content.Context;

import com.vn.apksfull.R;

public class Permission {
	private Context mContext;

	public Permission(Context mContext) {
		this.mContext = mContext;
	}

	public String getPermissionDetail(String permisison) {
		String res = "";

		if (permisison.equals("ACCESS_CHECKIN_PROPERTIES")) {
			res = mContext.getResources().getString(
					R.string.ACCESS_CHECKIN_PROPERTIES);
		}
		if (permisison.equals("ACCESS_COARSE_LOCATION")) {
			res = mContext.getResources().getString(
					R.string.ACCESS_COARSE_LOCATION);
		}
		if (permisison.equals("ACCESS_FINE_LOCATION")) {
			res = mContext.getResources().getString(
					R.string.ACCESS_FINE_LOCATION);
		}
		if (permisison.equals("ACCESS_LOCATION_EXTRA_COMMANDS")) {
			res = mContext.getResources().getString(
					R.string.ACCESS_LOCATION_EXTRA_COMMANDS);
		}
		if (permisison.equals("ACCESS_MOCK_LOCATION")) {
			res = mContext.getResources().getString(
					R.string.ACCESS_MOCK_LOCATION);
		}
		if (permisison.equals("ACCESS_NETWORK_STATE")) {
			res = mContext.getResources().getString(
					R.string.ACCESS_NETWORK_STATE);
		}
		if (permisison.equals("ACCESS_SURFACE_FLINGER")) {
			res = mContext.getResources().getString(
					R.string.ACCESS_SURFACE_FLINGER);
		}
		if (permisison.equals("ACCESS_WIFI_STATE")) {
			res = mContext.getResources().getString(R.string.ACCESS_WIFI_STATE);
		}
		if (permisison.equals("ACCOUNT_MANAGER")) {
			res = mContext.getResources().getString(R.string.ACCOUNT_MANAGER);
		}
		if (permisison.equals("ADD_VOICEMAIL")) {
			res = mContext.getResources().getString(R.string.ADD_VOICEMAIL);
		}
		if (permisison.equals("AUTHENTICATE_ACCOUNTS")) {
			res = mContext.getResources().getString(
					R.string.AUTHENTICATE_ACCOUNTS);
		}
		if (permisison.equals("BATTERY_STATS")) {
			res = mContext.getResources().getString(R.string.BATTERY_STATS);
		}
		if (permisison.equals("BIND_ACCESSIBILITY_SERVICE")) {
			res = mContext.getResources().getString(
					R.string.BIND_ACCESSIBILITY_SERVICE);
		}
		if (permisison.equals("BIND_APPWIDGET")) {
			res = mContext.getResources().getString(R.string.BIND_APPWIDGET);
		}
		if (permisison.equals("BIND_DEVICE_ADMIN")) {
			res = mContext.getResources().getString(R.string.BIND_DEVICE_ADMIN);
		}
		if (permisison.equals("BIND_INPUT_METHOD")) {
			res = mContext.getResources().getString(R.string.BIND_INPUT_METHOD);
		}
		if (permisison.equals("BIND_NFC_SERVICE")) {
			res = mContext.getResources().getString(R.string.BIND_NFC_SERVICE);
		}
		if (permisison.equals("BIND_NOTIFICATION_LISTENER_SERVICE")) {
			res = mContext.getResources().getString(
					R.string.BIND_NOTIFICATION_LISTENER_SERVICE);
		}
		if (permisison.equals("BIND_PRINT_SERVICE")) {
			res = mContext.getResources()
					.getString(R.string.BIND_PRINT_SERVICE);
		}
		if (permisison.equals("BIND_REMOTEVIEWS")) {
			res = mContext.getResources().getString(R.string.BIND_REMOTEVIEWS);
		}
		if (permisison.equals("BIND_TEXT_SERVICE")) {
			res = mContext.getResources().getString(R.string.BIND_TEXT_SERVICE);
		}
		if (permisison.equals("BIND_VPN_SERVICE")) {
			res = mContext.getResources().getString(R.string.BIND_VPN_SERVICE);
		}
		if (permisison.equals("BIND_WALLPAPER")) {
			res = mContext.getResources().getString(R.string.BIND_WALLPAPER);
		}
		if (permisison.equals("BLUETOOTH")) {
			res = mContext.getResources().getString(R.string.BLUETOOTH);
		}
		if (permisison.equals("BLUETOOTH_ADMIN")) {
			res = mContext.getResources().getString(R.string.BLUETOOTH_ADMIN);
		}
		if (permisison.equals("BLUETOOTH_PRIVILEGED")) {
			res = mContext.getResources().getString(
					R.string.BLUETOOTH_PRIVILEGED);
		}
		if (permisison.equals("BODY_SENSORS")) {
			res = mContext.getResources().getString(R.string.BODY_SENSORS);
		}
		if (permisison.equals("BRICK")) {
			res = mContext.getResources().getString(R.string.BRICK);
		}
		if (permisison.equals("BROADCAST_PACKAGE_REMOVED")) {
			res = mContext.getResources().getString(
					R.string.BROADCAST_PACKAGE_REMOVED);
		}
		if (permisison.equals("BROADCAST_SMS")) {
			res = mContext.getResources().getString(R.string.BROADCAST_SMS);
		}
		if (permisison.equals("BROADCAST_STICKY")) {
			res = mContext.getResources().getString(R.string.BROADCAST_STICKY);
		}
		if (permisison.equals("BROADCAST_WAP_PUSH")) {
			res = mContext.getResources()
					.getString(R.string.BROADCAST_WAP_PUSH);
		}
		if (permisison.equals("CALL_PHONE")) {
			res = mContext.getResources().getString(R.string.CALL_PHONE);
		}
		if (permisison.equals("CALL_PRIVILEGED")) {
			res = mContext.getResources().getString(R.string.CALL_PRIVILEGED);
		}
		if (permisison.equals("CAMERA")) {
			res = mContext.getResources().getString(R.string.CAMERA);
		}
		if (permisison.equals("CAPTURE_AUDIO_OUTPUT")) {
			res = mContext.getResources().getString(
					R.string.CAPTURE_AUDIO_OUTPUT);
		}
		if (permisison.equals("CAPTURE_SECURE_VIDEO_OUTPUT")) {
			res = mContext.getResources().getString(
					R.string.CAPTURE_SECURE_VIDEO_OUTPUT);
		}
		if (permisison.equals("CAPTURE_VIDEO_OUTPUT")) {
			res = mContext.getResources().getString(
					R.string.CAPTURE_VIDEO_OUTPUT);
		}
		if (permisison.equals("CHANGE_COMPONENT_ENABLED_STATE")) {
			res = mContext.getResources().getString(
					R.string.CHANGE_COMPONENT_ENABLED_STATE);
		}
		if (permisison.equals("CHANGE_CONFIGURATION")) {
			res = mContext.getResources().getString(
					R.string.CHANGE_CONFIGURATION);
		}
		if (permisison.equals("CHANGE_NETWORK_STATE")) {
			res = mContext.getResources().getString(
					R.string.CHANGE_NETWORK_STATE);
		}
		if (permisison.equals("CHANGE_WIFI_MULTICAST_STATE")) {
			res = mContext.getResources().getString(
					R.string.CHANGE_WIFI_MULTICAST_STATE);
		}
		if (permisison.equals("CHANGE_WIFI_STATE")) {
			res = mContext.getResources().getString(R.string.CHANGE_WIFI_STATE);
		}
		if (permisison.equals("CLEAR_APP_USER_DATA")) {
			res = mContext.getResources().getString(R.string.CLEAR_APP_USER_DATA);
		}	
		if (permisison.equals("CONTROL_LOCATION_UPDATES")) {
			res = mContext.getResources().getString(R.string.CONTROL_LOCATION_UPDATES);
		}
		if (permisison.equals("DELETE_CACHE_FILES")) {
			res = mContext.getResources().getString(R.string.DELETE_CACHE_FILES);
		}
		if (permisison.equals("DELETE_PACKAGES")) {
			res = mContext.getResources().getString(R.string.DELETE_PACKAGES);
		}
		if (permisison.equals("DEVICE_POWER")) {
			res = mContext.getResources().getString(R.string.DEVICE_POWER);
		}
		if (permisison.equals("DIAGNOSTIC")) {
			res = mContext.getResources().getString(R.string.DIAGNOSTIC);
		}
		if (permisison.equals("DISABLE_KEYGUARD")) {
			res = mContext.getResources().getString(R.string.DISABLE_KEYGUARD);
		}		
		if (permisison.equals("DUMP")) {
			res = mContext.getResources().getString(R.string.DISABLE_KEYGUARD);
		}
		if (permisison.equals("EXPAND_STATUS_BAR")) {
			res = mContext.getResources().getString(R.string.DISABLE_KEYGUARD);
		}		
		if (permisison.equals("FACTORY_TEST")) {
			res = mContext.getResources().getString(R.string.FACTORY_TEST);
		}
		if (permisison.equals("FLASHLIGHT")) {
			res = mContext.getResources().getString(R.string.FLASHLIGHT);
		}		
		if (permisison.equals("FORCE_BACK")) {
			res = mContext.getResources().getString(R.string.FORCE_BACK);
		}
		if (permisison.equals("GET_ACCOUNTS")) {
			res = mContext.getResources().getString(R.string.GET_ACCOUNTS);
		}		
		if (permisison.equals("GET_PACKAGE_SIZE")) {
			res = mContext.getResources().getString(R.string.GET_PACKAGE_SIZE);
		}
		if (permisison.equals("GET_TASKS")) {
			res = mContext.getResources().getString(R.string.GET_TASKS);
		}				
		if (permisison.equals("GET_TOP_ACTIVITY_INFO")) {
			res = mContext.getResources().getString(R.string.GET_TOP_ACTIVITY_INFO);
		}
		if (permisison.equals("GLOBAL_SEARCH")) {
			res = mContext.getResources().getString(R.string.GLOBAL_SEARCH);
		}		
		if (permisison.equals("HARDWARE_TEST")) {
			res = mContext.getResources().getString(R.string.HARDWARE_TEST);
		}
		if (permisison.equals("INJECT_EVENTS")) {
			res = mContext.getResources().getString(R.string.INJECT_EVENTS);
		}		
		if (permisison.equals("INSTALL_LOCATION_PROVIDER")) {
			res = mContext.getResources().getString(R.string.INSTALL_LOCATION_PROVIDER);
		}
		if (permisison.equals("INSTALL_PACKAGES")) {
			res = mContext.getResources().getString(R.string.INSTALL_PACKAGES);
		}		
		if (permisison.equals("INSTALL_SHORTCUT")) {
			res = mContext.getResources().getString(R.string.INSTALL_SHORTCUT);
		}
		if (permisison.equals("INTERNAL_SYSTEM_WINDOW")) {
			res = mContext.getResources().getString(R.string.INTERNAL_SYSTEM_WINDOW);
		}		
		if (permisison.equals("INTERNAL_SYSTEM_WINDOW")) {
			res = mContext.getResources().getString(R.string.INTERNAL_SYSTEM_WINDOW);
		}
		if (permisison.equals("INTERNET")) {
			res = mContext.getResources().getString(R.string.INTERNET);
		}		
		if (permisison.equals("KILL_BACKGROUND_PROCESSES")) {
			res = mContext.getResources().getString(R.string.KILL_BACKGROUND_PROCESSES);
		}
		if (permisison.equals("LOCATION_HARDWARE")) {
			res = mContext.getResources().getString(R.string.LOCATION_HARDWARE);
		}		
		if (permisison.equals("MANAGE_ACCOUNTS")) {
			res = mContext.getResources().getString(R.string.MANAGE_ACCOUNTS);
		}
		if (permisison.equals("MANAGE_APP_TOKENS")) {
			res = mContext.getResources().getString(R.string.MANAGE_APP_TOKENS);
		}		
		if (permisison.equals("MANAGE_DOCUMENTS")) {
			res = mContext.getResources().getString(R.string.MANAGE_DOCUMENTS);
		}
		if (permisison.equals("MASTER_CLEAR")) {
			res = mContext.getResources().getString(R.string.MASTER_CLEAR);
		}		
		if (permisison.equals("MEDIA_CONTENT_CONTROL")) {
			res = mContext.getResources().getString(R.string.MEDIA_CONTENT_CONTROL);
		}		
		if (permisison.equals("MODIFY_AUDIO_SETTINGS")) {
			res = mContext.getResources().getString(R.string.MODIFY_AUDIO_SETTINGS);
		}
		if (permisison.equals("MODIFY_PHONE_STATE")) {
			res = mContext.getResources().getString(R.string.MODIFY_PHONE_STATE);
		}		
		if (permisison.equals("MOUNT_FORMAT_FILESYSTEMS")) {
			res = mContext.getResources().getString(R.string.MOUNT_FORMAT_FILESYSTEMS);
		}
		if (permisison.equals("MOUNT_UNMOUNT_FILESYSTEMS")) {
			res = mContext.getResources().getString(R.string.MOUNT_UNMOUNT_FILESYSTEMS);
		}		
		if (permisison.equals("NFC")) {
			res = mContext.getResources().getString(R.string.NFC);
		}
		if (permisison.equals("PERSISTENT_ACTIVITY")) {
			res = mContext.getResources().getString(R.string.PERSISTENT_ACTIVITY);
		}		
		if (permisison.equals("PROCESS_OUTGOING_CALLS")) {
			res = mContext.getResources().getString(R.string.PROCESS_OUTGOING_CALLS);
		}		
		if (permisison.equals("READ_CALENDAR")) {
			res = mContext.getResources().getString(R.string.READ_CALENDAR);
		}
		if (permisison.equals("READ_CALL_LOG")) {
			res = mContext.getResources().getString(R.string.READ_CALL_LOG);
		}
		if (permisison.equals("READ_CONTACTS")) {
			res = mContext.getResources().getString(R.string.READ_CONTACTS);
		}
		if (permisison.equals("READ_EXTERNAL_STORAGE")) {
			res = mContext.getResources().getString(R.string.READ_EXTERNAL_STORAGE);
		}
		if (permisison.equals("READ_FRAME_BUFFER")) {
			res = mContext.getResources().getString(R.string.READ_FRAME_BUFFER);
		}
		if (permisison.equals("READ_HISTORY_BOOKMARKS")) {
			res = mContext.getResources().getString(R.string.READ_HISTORY_BOOKMARKS);
		}
		if (permisison.equals("READ_INPUT_STATE")) {
			res = mContext.getResources().getString(R.string.READ_INPUT_STATE);
		}

		if (permisison.equals("READ_LOGS")) {
			res = mContext.getResources().getString(R.string.READ_LOGS);
		}
		if (permisison.equals("READ_PHONE_STATE")) {
			res = mContext.getResources().getString(R.string.READ_PHONE_STATE);
		}
		if (permisison.equals("READ_PROFILE")) {
			res = mContext.getResources().getString(R.string.READ_PROFILE);
		}
		if (permisison.equals("READ_SMS")) {
			res = mContext.getResources().getString(R.string.READ_SMS);
		}
		if (permisison.equals("READ_SOCIAL_STREAM")) {
			res = mContext.getResources().getString(R.string.READ_SOCIAL_STREAM);
		}
		if (permisison.equals("READ_SYNC_SETTINGS")) {
			res = mContext.getResources()
					.getString(R.string.READ_SYNC_SETTINGS);
		}
		if (permisison.equals("READ_SYNC_STATS")) {
			res = mContext.getResources().getString(R.string.READ_SYNC_STATS);
		}
		if (permisison.equals("READ_USER_DICTIONARY")) {
			res = mContext.getResources().getString(
					R.string.READ_USER_DICTIONARY);
		}
		if (permisison.equals("REBOOT")) {
			res = mContext.getResources().getString(R.string.REBOOT);
		}
		if (permisison.equals("RECEIVE_BOOT_COMPLETED")) {
			res = mContext.getResources().getString(
					R.string.RECEIVE_BOOT_COMPLETED);
		}
		if (permisison.equals("RECEIVE_MMS")) {
			res = mContext.getResources().getString(R.string.RECEIVE_MMS);
		}
		if (permisison.equals("RECEIVE_SMS")) {
			res = mContext.getResources().getString(R.string.RECEIVE_SMS);
		}
		if (permisison.equals("RECEIVE_WAP_PUSH")) {
			res = mContext.getResources().getString(R.string.RECEIVE_WAP_PUSH);
		}
		if (permisison.equals("RECORD_AUDIO")) {
			res = mContext.getResources().getString(R.string.RECORD_AUDIO);
		}
		if (permisison.equals("REORDER_TASKS")) {
			res = mContext.getResources().getString(R.string.REORDER_TASKS);
		}
		if (permisison.equals("RESTART_PACKAGES")) {
			res = mContext.getResources().getString(R.string.RESTART_PACKAGES);
		}
		if (permisison.equals("SEND_RESPOND_VIA_MESSAGE")) {
			res = mContext.getResources().getString(
					R.string.SEND_RESPOND_VIA_MESSAGE);
		}
		if (permisison.equals("SEND_SMS")) {
			res = mContext.getResources().getString(R.string.SEND_SMS);
		}
		if (permisison.equals("SET_ACTIVITY_WATCHER")) {
			res = mContext.getResources().getString(
					R.string.SET_ACTIVITY_WATCHER);
		}
		if (permisison.equals("SET_ALARM")) {
			res = mContext.getResources().getString(R.string.SET_ALARM);

		}
		if (permisison.equals("SET_ALWAYS_FINISH")) {
			res = mContext.getResources().getString(R.string.SET_ALWAYS_FINISH);
		}
		if (permisison.equals("SET_ANIMATION_SCALE")) {
			res = mContext.getResources().getString(
					R.string.SET_ANIMATION_SCALE);
		}
		if (permisison.equals("SET_DEBUG_APP")) {
			res = mContext.getResources().getString(R.string.SET_DEBUG_APP);
		}
		if (permisison.equals("SET_ORIENTATION")) {
			res = mContext.getResources().getString(R.string.SET_ORIENTATION);
		}
		if (permisison.equals("SET_POINTER_SPEED")) {
			res = mContext.getResources().getString(R.string.SET_POINTER_SPEED);

		}
		if (permisison.equals("SET_PREFERRED_APPLICATIONS")) {
			res = mContext.getResources().getString(
					R.string.SET_PREFERRED_APPLICATIONS);
		}
		if (permisison.equals("SET_PROCESS_LIMIT")) {
			res = mContext.getResources().getString(R.string.SET_PROCESS_LIMIT);
		}
		if (permisison.equals("SET_TIME")) {
			res = mContext.getResources().getString(R.string.SET_TIME);
		}
		if (permisison.equals("SET_TIME_ZONE")) {
			res = mContext.getResources().getString(R.string.SET_TIME_ZONE);
		}
		if (permisison.equals("SET_WALLPAPER")) {
			res = mContext.getResources().getString(R.string.SET_WALLPAPER);
		}
		if (permisison.equals("SET_WALLPAPER_HINTS")) {
			res = mContext.getResources().getString(
					R.string.SET_WALLPAPER_HINTS);
		}
		if (permisison.equals("SIGNAL_PERSISTENT_PROCESSES")) {
			res = mContext.getResources().getString(
					R.string.SIGNAL_PERSISTENT_PROCESSES);
		}
		if (permisison.equals("STATUS_BAR")) {
			res = mContext.getResources().getString(R.string.STATUS_BAR);
		}
		if (permisison.equals("SUBSCRIBED_FEEDS_READ")) {
			res = mContext.getResources().getString(
					R.string.SUBSCRIBED_FEEDS_READ);
		}
		if (permisison.equals("SUBSCRIBED_FEEDS_WRITE")) {
			res = mContext.getResources().getString(
					R.string.SUBSCRIBED_FEEDS_WRITE);
		}
		if (permisison.equals("SYSTEM_ALERT_WINDOW")) {
			res = mContext.getResources().getString(
					R.string.SYSTEM_ALERT_WINDOW);
		}
		if (permisison.equals("TRANSMIT_IR")) {
			res = mContext.getResources().getString(R.string.TRANSMIT_IR);
		}
		if (permisison.equals("UNINSTALL_SHORTCUT")) {
			res = mContext.getResources()
					.getString(R.string.UNINSTALL_SHORTCUT);
		}
		if (permisison.equals("UPDATE_DEVICE_STATS")) {
			res = mContext.getResources().getString(
					R.string.UPDATE_DEVICE_STATS);
		}
		if (permisison.equals("USE_CREDENTIALS")) {
			res = mContext.getResources().getString(R.string.USE_CREDENTIALS);
		}
		if (permisison.equals("USE_SIP")) {
			res = mContext.getResources().getString(R.string.USE_SIP);
		}
		if (permisison.equals("VIBRATE")) {
			res = mContext.getResources().getString(R.string.VIBRATE);
		}
		if (permisison.equals("WAKE_LOCK")) {
			res = mContext.getResources().getString(R.string.WAKE_LOCK);
		}
		if (permisison.equals("WRITE_APN_SETTINGS")) {
			res = mContext.getResources()
					.getString(R.string.WRITE_APN_SETTINGS);
		}
		if (permisison.equals("WRITE_CALENDAR")) {
			res = mContext.getResources().getString(R.string.WRITE_CALENDAR);
		}
		//
		if (permisison.equals("WRITE_CALL_LOG")) {
			res = mContext.getResources().getString(R.string.WRITE_CALL_LOG);
		}
		if (permisison.equals("WRITE_CONTACTS")) {
			res = mContext.getResources().getString(R.string.WRITE_CONTACTS);

		}
		if (permisison.equals("WRITE_EXTERNAL_STORAGE")) {
			res = mContext.getResources().getString(
					R.string.WRITE_EXTERNAL_STORAGE);
		}
		if (permisison.equals("WRITE_GSERVICES")) {
			res = mContext.getResources().getString(R.string.WRITE_GSERVICES);
		}
		if (permisison.equals("WRITE_HISTORY_BOOKMARKS")) {
			res = mContext.getResources().getString(
					R.string.WRITE_HISTORY_BOOKMARKS);
		}
		if (permisison.equals("WRITE_PROFILE")) {
			res = mContext.getResources().getString(R.string.WRITE_PROFILE);
		}
		if (permisison.equals("WRITE_SECURE_SETTINGS")) {
			res = mContext.getResources().getString(
					R.string.WRITE_SECURE_SETTINGS);
		}
		if (permisison.equals("WRITE_SETTINGS")) {
			res = mContext.getResources().getString(R.string.WRITE_SETTINGS);
		}
		if (permisison.equals("WRITE_SMS")) {
			res = mContext.getResources().getString(R.string.WRITE_SMS);

		}
		if (permisison.equals("WRITE_SOCIAL_STREAM")) {
			res = mContext.getResources().getString(
					R.string.WRITE_SOCIAL_STREAM);
		}
		if (permisison.equals("WRITE_SYNC_SETTINGS")) {
			res = mContext.getResources().getString(
					R.string.WRITE_SYNC_SETTINGS);
		}
		if (permisison.equals("WRITE_USER_DICTIONARY")) {
			res = mContext.getResources().getString(
					R.string.WRITE_USER_DICTIONARY);
		}
		return res;
	}

	/**
	 * check permisison is dangerous or not
	 * 
	 * @param permisisonName
	 * @return true if is dangerous
	 */
	public boolean isDangerousPermisison(String permisisonName) {
		String[] mDangerousPermisison = { "android.permission.SEND_SMS",
				"android.permission.RECEIVE_SMS",
				"android.permission.RECEIVE_MMS",
				"android.permission.READ_CELL_BROADCASTS",
				"android.permission.READ_SMS", 
				"android.permission.WRITE_SMS",
				"android.permission.RECEIVE_WAP_PUSH",
				"android.permission.READ_CONTACTS",
				"android.permission.WRITE_CONTACTS",
				"android.permission.READ_CALL_LOG",
				"android.permission.WRITE_CALL_LOG",
				"android.permission.READ_SOCIAL_STREAM",
				"android.permission.WRITE_SOCIAL_STREAM",
				"android.permission.READ_PROFILE",
				"android.permission.WRITE_PROFILE",
				"android.permission.READ_CALENDAR",
				"android.permission.WRITE_CALENDAR",
				"android.permission.READ_USER_DICTIONARY",
				"com.android.browser.permission.READ_HISTORY_BOOKMARKS",
				"com.android.browser.permission.WRITE_HISTORY_BOOKMARKS",
				"com.android.voicemail.permission.ADD_VOICEMAIL",
				"android.permission.ACCESS_FINE_LOCATION",
				"android.permission.ACCESS_COARSE_LOCATION",
				"android.permission.ACCESS_MOCK_LOCATION",				
				"android.permission.CHANGE_WIFI_STATE",
				"android.permission.CHANGE_WIMAX_STATE",
				"android.permission-group.BLUETOOTH_NETWORK",
				"android.permission.BLUETOOTH_ADMIN",
				"android.permission.NFC",
				"android.permission.AUTHENTICATE_ACCOUNTS",
				"android.permission.USE_CREDENTIALS",
				"android.permission.MANAGE_ACCOUNTS",
				"android.permission.CHANGE_WIFI_MULTICAST_STATE",
				"android.permission.RECORD_AUDIO", 
				"android.permission.CAMERA",
				"android.permission.PROCESS_OUTGOING_CALLS",
				"android.permission.READ_PHONE_STATE",
				"android.permission.READ_PRECISE_PHONE_STATE",
				"android.permission.CALL_PHONE",
				"android.permission-group.PHONE_CALLS",				
				"android.permission.DISABLE_KEYGUARD",
				"android.permission.GET_TASKS",
				"android.permission.SYSTEM_ALERT_WINDOW",
				"com.android.launcher.permission.INSTALL_SHORTCUT",
				"com.android.launcher.permission.UNINSTALL_SHORTCUT",
				"android.permission.SUBSCRIBED_FEEDS_WRITE",
				"android.permission.CLEAR_APP_CACHE"};
		for(String item: mDangerousPermisison){
			if(permisisonName.equals(item)){
				return true;
			}				
		}
		return false;
	}
}
