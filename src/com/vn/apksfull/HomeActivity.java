package com.vn.apksfull;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.telpoo.frame.net.BaseNetSupportBeta;
import com.telpoo.frame.net.NetConfig;
import com.telpoo.frame.net.NetUtils;
import com.telpoo.frame.object.BaseObject;
import com.telpoo.frame.ui.BetaBaseFragment;
import com.telpoo.frame.utils.Mlog;
import com.vn.apksfull.feedback.DialogFeedBack;
import com.vn.apksfull.object.GoogleAccountOBj;
import com.vn.apksfull.setting.ActivitySetting;
import com.vn.apksfull.task.AbstractGetNameTask;
import com.vn.apksfull.task.GetNameInForeground;
import com.vn.apksfull.task.LoginTaskControl;
import com.vn.apksfull.utils.Common;

public class HomeActivity extends MyHomeActivity implements LoginTaskControl {

	private String TAG = "[HomeActivity]";
	private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.profile";
	static HomeActivity me;
	// private FragmentManager mFragmentManager;
	private ActionBar mActionBar;
	public static final String EXTRA_ACCOUNTNAME = "extra_accountname";
	static final int REQUEST_CODE_PICK_ACCOUNT = 1000;
	static final int REQUEST_CODE_RECOVER_FROM_AUTH_ERROR = 1001;
	static final int REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR = 1002;
	// private GoogleAccountOBj mGoogleAccountOBj;
	private String mEmailAccount;

	public static HomeActivity Instance() {
		return me;
	}

	// private ViewIndicatorPagerAdapter mAdapter;
	// private ViewPager mPager;
	// private ;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// Mlog.isLog=true;
		mActionBar = getSupportActionBar();
		mActionBar.setIcon(new ColorDrawable(getResources().getColor(
				android.R.color.transparent)));
		me = HomeActivity.this;
		// mFragmentManager = getSupportFragmentManager();
		if (savedInstanceState == null) {

			ArrayList<BaseObject> arr = new ArrayList<BaseObject>();

			arr = loadListData();
			HomeActivity.Instance().pushFragments(TabId.home,
					ApkFragmentHome.newInstance(arr));

		}

		init();

	}

	private void init() {
		NetConfig netConfig = new NetConfig.Builder().userAgent(
				NetUtils.UserAgent.IPHONE4).build();
		// setTrackingId("UA-46761559-2");
		BaseNetSupportBeta.getInstance().init(netConfig);

		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(false).cacheOnDisc(true)
				.showImageForEmptyUri(R.drawable.ic_launcher)
				.showImageOnFail(R.drawable.ic_launcher)
				.bitmapConfig(Config.RGB_565)
				// .displayer(new FadeInBitmapDisplayer(300))
				.build();

		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(
				getBaseContext()).defaultDisplayImageOptions(options).build();

		ImageLoader.getInstance().init(configuration);

	}

	public ArrayList<BaseObject> loadListData() {
		ArrayList<BaseObject> mResArrays = new ArrayList<BaseObject>();

		BaseObject ar = new BaseObject();

		// -----------------//
		ar = new BaseObject();
		ar.set("app_catid", Common.CATID_CATEGORYED);
		ar.set("title", getResources().getString(R.string.tag_Category));
		mResArrays.add(ar);

		//
		ar = new BaseObject();
		ar.set("app_catid", Common.CATID_NEWED);
		ar.set("title", getResources().getString(R.string.tag_newapp));
		mResArrays.add(ar);

//		// -----------------//
//		ar = new BaseObject();
//		ar.set("app_catid", Common.CATID_NEWED);
//		ar.set("title", getResources().getString(R.string.tag_newapp));
//		mResArrays.add(ar);
		// -----------------//
		return mResArrays;
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {

		switch (position) {
		case 0:
			ArrayList<BaseObject> arr = loadListData();
			HomeActivity.Instance().pushFragments(TabId.home,
					ApkFragmentHome.newInstance(arr));

			break;
		case 1:
			// mActionBar.setTitle(getResources().getString(R.string.tag_favorite_app));
			// HomeActivity.Instance().pushFragments(TabId.TAG_FRAGMENT_FAVORITE_APP,
			// MyFragmentTS.newInstance(MyFragmentTS.LISTSHOW_FAVORITEAPP, 0));
			break; // =5
		case 2:
			// mActionBar.setTitle(getResources().getString(R.string.tag_app_manager));
			// HomeActivity.Instance().pushFragments(TabId.TAG_FRAGMENT_APP_MANAGER,
			// MyFragmentTS.newInstance(MyFragmentTS.LISTSHOW_MANAGERAPP, 0));
			break;
		case 3:
			// mActionBar.setTitle(getResources().getString(R.string.tag_apk_manager));
			// HomeActivity.Instance().pushFragments(TabId.TAG_FRAGMENT_APK_MANAGER,
			// MyFragmentTS.newInstance(MyFragmentTS.LISTSHOW_MANAGERAPK, 0));
			break;
		case 4:
			Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
			startActivityForResult(intent, 0);
			break;
		case 5:
			Intent intent2 = new Intent(this, ActivitySetting.class);
			intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent2);
			break;
		case 6:
			// HomeActivity.Instance().pushFragments( TAG.TAG_FRAGMENT_EMAIL ,
			// new FragmentEmail());
			// mFragmentManager.beginTransaction().replace(R.id.realTabContent,
			// new FragmentEmail()).commit();
			showDialogFeedBack();
			break;
		case 7:
			launchMarket();
			break;
		case 8:
			finish();
			break;
		case 9:
			finish();
			break;
		case 11:
			pickUserAccount();

		default:
			break;
		}

	}

	public void hideActionBar() {
		getSupportActionBar().hide();
	}

	public void showActionBar() {
		getSupportActionBar().show();
	}

	@Override
	protected void onPause() {

		super.onPause();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final FragmentManager childFragmentManager = getSupportFragmentManager();

		if (childFragmentManager != null) {
			final List<Fragment> nestedFragments = childFragmentManager
					.getFragments();

			if (nestedFragments == null || nestedFragments.size() == 0)
				return super.onOptionsItemSelected(item);

			for (Fragment childFragment : nestedFragments) {
				if (childFragment != null && !childFragment.isDetached()
						&& !childFragment.isRemoving()) {
					if (childFragment instanceof BetaBaseFragment) {
						return ((BetaBaseFragment) childFragment)
								.onOptionsItemSelected(item);
					}
				}
			}
		}

		return super.onOptionsItemSelected(item);

	}

	@Override
	protected void onResume() {

		super.onResume();

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (requestCode == REQUEST_CODE_PICK_ACCOUNT) {
			if (resultCode == RESULT_OK) {
				mEmailAccount = data
						.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
				syncGoogleAccount();
				// getUsername();
			} else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(this, "You must pick an account",
						Toast.LENGTH_SHORT).show();
			}
		} else if ((requestCode == REQUEST_CODE_RECOVER_FROM_AUTH_ERROR || requestCode == REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR)
				&& resultCode == RESULT_OK) {
			handleAuthorizeResult(resultCode, data);
			return;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void handleAuthorizeResult(int resultCode, Intent data) {
		if (data == null) {
			show("Unknown error, click the button again");
			return;
		}
		if (resultCode == RESULT_OK) {
			Log.i(TAG, "Retrying");
			getTask(this, mEmailAccount, SCOPE).execute();
			return;
		}
		if (resultCode == RESULT_CANCELED) {
			show("User rejected authorization.");
			return;
		}
		show("Unknown error, click the button again");
	}

	private void showDialogFeedBack() {
		DialogFeedBack dlFeedBack = new DialogFeedBack(this);
		dlFeedBack.show();
	}

	private void launchMarket() {
		Uri uri = Uri.parse("market://details?id=" + getPackageName());
		Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
		try {
			startActivity(goToMarket);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(this, "Couldn't launch market!", Toast.LENGTH_LONG)
					.show();
		}
	}

	/**
	 * This method is a hook for background threads and async tasks that need to
	 * provide the user a response UI when an exception occurs.
	 */
	public void handleException(final Exception e) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (e instanceof GooglePlayServicesAvailabilityException) {
					// The Google Play services APK is old, disabled, or not
					// present.
					// Show a dialog created by Google Play services that allows
					// the user to update the APK
					int statusCode = ((GooglePlayServicesAvailabilityException) e)
							.getConnectionStatusCode();
					Dialog dialog = GooglePlayServicesUtil.getErrorDialog(
							statusCode, HomeActivity.this,
							REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
					dialog.show();
				} else if (e instanceof UserRecoverableAuthException) {
					// Unable to authenticate, such as when the user has not yet
					// granted
					// the app access to the account, but the user can fix this.
					// Forward the user to an activity in Google Play services.
					Intent intent = ((UserRecoverableAuthException) e)
							.getIntent();
					startActivityForResult(intent,
							REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
				}
			}
		});
	}

	//
	//
	private AbstractGetNameTask getTask(HomeActivity activity, String email,

	String scope) {
		return new GetNameInForeground(activity, email, scope, this);
	}

	public void syncGoogleAccount() {

		if (NetUtils.isNetworkAvailable(this) == true) {

			// String[] accountarrs = getAccountNames();
			if (mEmailAccount != null || !mEmailAccount.equals("")) {
				//
				// // you can set here account for login
				// mEmailAccount = accountarrs[0];

				getTask(HomeActivity.this, mEmailAccount, SCOPE).execute();
				//
			} else {
				//
				Toast.makeText(HomeActivity.this, "No Google Account Sync!",
				//
						Toast.LENGTH_SHORT).show();
				//
			}

		} else {

			Toast.makeText(HomeActivity.this, "No Network Service!",

			Toast.LENGTH_SHORT).show();

		}

	}

	/**
	 * Starts an activity in Google Play Services so the user can pick an
	 * account
	 */
	private void pickUserAccount() {
		String[] accountTypes = new String[] { "com.google" };
		Intent intent = AccountPicker.newChooseAccountIntent(null, null,
				accountTypes, false, null, null, null, null);
		startActivityForResult(intent, REQUEST_CODE_PICK_ACCOUNT);
	}

	public JSONObject getUserData() {
		JSONObject jsonObject = null;
		// GoogleAccountOBj mGoogleAccountOBj = new GoogleAccountOBj();
		try {
			jsonObject = new JSONObject(AbstractGetNameTask.GOOGLE_USER_DATA);
			jsonObject.put(GoogleAccountOBj.ACCOUTN_EMAIL, mEmailAccount);
			// mGoogleAccountOBj = new GoogleAccountOBj();
			// id
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_ID,
			// jsonObject.getString(GoogleAccountOBj.ACCOUTN_ID));
			// //name
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_NAME,
			// jsonObject.getString(GoogleAccountOBj.ACCOUTN_NAME));
			// //give name
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_GIVE_NAME,
			// jsonObject.getString(GoogleAccountOBj.ACCOUTN_GIVE_NAME));
			// //family name
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_FAMILY_NAME,
			// jsonObject.getString(GoogleAccountOBj.ACCOUTN_FAMILY_NAME));
			// //link
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_LINK,
			// jsonObject.getString(GoogleAccountOBj.ACCOUTN_LINK));
			// //picture
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_PICTURE,
			// jsonObject.getString(GoogleAccountOBj.ACCOUTN_PICTURE));
			// //gender
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_GENDER,
			// jsonObject.getString(GoogleAccountOBj.ACCOUTN_GENDER));
			// //local
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_LOCAL,
			// jsonObject.getString(GoogleAccountOBj.ACCOUTN_LOCAL));
			// //email
			// mGoogleAccountOBj.set(GoogleAccountOBj.ACCOUTN_EMAIL,
			// mEmailAccount);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Log.d("JSON OBJECT", jsonObject.toString());
		return jsonObject;
	}

	private String[] getAccountNames() {

		AccountManager mAccountManager = AccountManager.get(this);

		Account[] accounts = mAccountManager

		.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);

		String[] names = new String[accounts.length];

		for (int i = 0; i < names.length; i++) {

			names[i] = accounts[i].name;

		}

		return names;

	}

	public void show(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void doInTaskDone() {
		// TODO Auto-generated method stub
		getUserData();
		NavigationDrawerFragmentInit.setDataLogin(getUserData(), this);
	}

}
