package com.vn.apksfull;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.telpoo.frame.object.BaseObject;
import com.vn.apksfull.db.SharePrefsSupport;
import com.vn.apksfull.object.GoogleAccountOBj;

/**
 * Fragment used for managing interactions for and presentation of a navigation
 * drawer. See the <a href=
 * "https://developer.android.com/design/patterns/navigation-drawer.html#Interaction"
 * > design guidelines</a> for a complete explanation of the behaviors
 * implemented here.
 */
public class NavigationDrawerFragmentInit extends Fragment implements OnClickListener{

	/**
	 * Remember the position of the selected item.
	 */
	protected static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

	/**
	 * Per the design guidelines, you should show the drawer on launch until the
	 * user manually expands it. This shared preference tracks this.
	 */
	protected static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

	/**
	 * A pointer to the current callbacks instance (the Activity).
	 */
	protected NavigationDrawerCallbacks mCallbacks;

	/**
	 * Helper component that ties the action bar to the navigation drawer.
	 */

	protected ActionBarDrawerToggle mDrawerToggle;

	protected DrawerLayout mDrawerLayout;
	protected View mFragmentContainerView;

	protected int mCurrentSelectedPosition = 0;
	protected boolean mFromSavedInstanceState;
	protected boolean mUserLearnedDrawer;

	// =1
	protected View mnViCuaToi, mnChuyenTien, mnThoat, mnNapTienGame;

	protected View mnCaiDat, mnMuaMaThe;

	protected View mnNapTien, mnNapTienTS, mnNapTienTT, mnQuanLythe, mnRutTien, mnTienTich, mnTroGiup, mnUngdung;

	protected TextView tvName;

	protected TextView tvPhone;

	protected ImageView ivGoToAccount;

	protected static ImageView ivAvatar;
	private TextView mHompage, mFavoriteApp, mAppManager, mApkManager, mScanQbare, mInstall, mlogOut, mExit, mReport, mRate;

	private static TextView mAcountName, mAccountEmail;
	//SharePrefsSupport sharePrefsSupport;

	
	public NavigationDrawerFragmentInit() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Read in the flag indicating whether or not the user has demonstrated
		// awareness of the
		// drawer. See PREF_USER_LEARNED_DRAWER for details.
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
		mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

		if (savedInstanceState != null) {
			mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
			mFromSavedInstanceState = true;
		}

		// Select either the default item (0) or the last selected item.
		//selectItem(mCurrentSelectedPosition);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Indicate that this fragment would like to influence the set of
		// actions in the action bar.
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.menu, container, false);

		// =2
//		mnViCuaToi = v.findViewById(R.id.mnViCuaToi);
//		mnChuyenTien = v.findViewById(R.id.mnChuyenTien);
//		mnThoat = v.findViewById(R.id.mnDangXuat);
//		mnNapTienGame = v.findViewById(R.id.mnNapTienGame);
		mAppManager = (TextView) v.findViewById(R.id.tv_ql_ungdung);
		mApkManager = (TextView) v.findViewById(R.id.tv_ql_file_apk);
		mScanQbare = (TextView) v.findViewById(R.id.tv_quyetmavach);
		mlogOut = (TextView) v.findViewById(R.id.tv_dangxuat);
		mExit = (TextView) v.findViewById(R.id.tv_thoat);
		mFavoriteApp = (TextView) v.findViewById(R.id.tv_yeuthich);
		mHompage = (TextView) v.findViewById(R.id.tv_home);
		mReport = (TextView) v.findViewById(R.id.tv_phanhoi);
		mInstall = (TextView) v.findViewById(R.id.tv_caidat);
		mReport = (TextView) v.findViewById(R.id.tv_phanhoi);
		mRate = (TextView) v.findViewById(R.id.tv_danhgia);
		mAccountEmail = (TextView) v.findViewById(R.id.tv_mail);		
		mAcountName = (TextView) v.findViewById(R.id.tv_name);
		ivAvatar = (ImageView) v.findViewById(R.id.img_avata);		
		View v1 = v.findViewById(R.id.myUserinfo_menu);
		//check login
		SharePrefsSupport sharePrefsSupport = new SharePrefsSupport(getActivity());
		if( !sharePrefsSupport.loadString(SharePrefsSupport.EMAIL_ACCCOUTN_GOOGLE).equals("unknow")){
			loadDataLogin(getActivity());
		}
		//
		v1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(11);
			}
		});
		//
		mHompage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(0);
			}
		});
		mFavoriteApp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(1);
			}
		});
		mAppManager.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(2);
			}
		});
		mApkManager.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(3);
			}
		});
		
		mScanQbare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(4);
			}
		});
		mInstall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(5);
			}
		});
		mReport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(6);
			}
		});
		mRate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(7);
			}
		});
		
		mlogOut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(8);
			}
		});
		mExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selectItem(9);
			}
		});
		
		return v;
	}

	public boolean isDrawerOpen() {
		return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	/**
	 * Users of this fragment must call this method to set up the navigation
	 * drawer interactions.
	 * 
	 * @param fragmentId
	 *            The android:id of this fragment in its activity's layout.
	 * @param drawerLayout
	 *            The DrawerLayout containing this fragment's UI.
	 */
	public void setUp(int fragmentId, DrawerLayout drawerLayout) {
		mFragmentContainerView = getActivity().findViewById(fragmentId);
		mDrawerLayout = drawerLayout;

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.btn_left, /* nav drawer image to replace 'Up' caret */
		R.string.navigation_drawer_open, /*
										 * "open drawer" description for
										 * accessibility
										 */
		R.string.navigation_drawer_close /*
										 * "close drawer" description for
										 * accessibility
										 */
		) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				if (!isAdded()) {
					return;
				}

				getActivity().supportInvalidateOptionsMenu(); // calls
																// onPrepareOptionsMenu()
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				if (!isAdded()) {
					return;
				}

				if (!mUserLearnedDrawer) {
					// The user manually opened the drawer; store this flag to
					// prevent auto-showing
					// the navigation drawer automatically in the future.
					mUserLearnedDrawer = true;
					SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
					sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
				}

				getActivity().supportInvalidateOptionsMenu(); // calls
																// onPrepareOptionsMenu()
			}
		};

		// If the user hasn't 'learned' about the drawer, open it to introduce
		// them to the drawer,
		// per the navigation drawer design guidelines.
		if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
			mDrawerLayout.openDrawer(mFragmentContainerView);
		}

		// Defer code dependent on restoration of previous instance state.
		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});

		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}
	


	protected void selectItem(int position) {
		mCurrentSelectedPosition = position;

		Log.i("TONYSTARK", "click menu at " + mCurrentSelectedPosition);
		if (mDrawerLayout != null) {
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}
		if (mCallbacks != null) {
			mCallbacks.onNavigationDrawerItemSelected(position);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mCallbacks = (NavigationDrawerCallbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = null;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// If the drawer is open, show the global app actions in the action bar.
		// See also
		// showGlobalContextActionBar, which controls the top-left area of the
		// action bar.
		if (mDrawerLayout != null && isDrawerOpen()) {
			inflater.inflate(R.menu.global, menu);
			showGlobalContextActionBar();
		}
		super.onCreateOptionsMenu(menu, inflater);
	}

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// if (mDrawerToggle.onOptionsItemSelected(item)) {
	// return true;
	// }
	//
	// if (item.getItemId() == R.id.action_example) {
	// Toast.makeText(getActivity(), "Example action.",
	// Toast.LENGTH_SHORT).show();
	// return true;
	// }
	//
	// return super.onOptionsItemSelected(item);
	// }

	/**
	 * Per the navigation drawer design guidelines, updates the action bar to
	 * show the global app 'context', rather than just what's in the current
	 * screen.
	 */
	private void showGlobalContextActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setTitle(R.string.app_name);
	}

	protected ActionBar getActionBar() {
		return ((ActionBarActivity) getActivity()).getSupportActionBar();
	}

	/**
	 * Callbacks interface that all activities using this fragment must
	 * implement.
	 */
	public static interface NavigationDrawerCallbacks {
		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(int position);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_ql_ungdung:
			selectItem(2);
			//mCurrentSelectedPosition = 0;
			break;
		case R.id.tv_ql_file_apk:
			//mCurrentSelectedPosition = 1;
			selectItem(3);
			break;

		default:
			break;
		}
	}
	public static void setDataLogin(JSONObject accountInfo, Context context){
		
		try {
			//save data account info
			SharePrefsSupport sharePrefsSupport = new SharePrefsSupport(context);
			sharePrefsSupport.saveString(SharePrefsSupport.NAME_ACCCOUTN_GOOGLE, accountInfo.get(GoogleAccountOBj.ACCOUTN_EMAIL)+"");
			sharePrefsSupport.saveString(SharePrefsSupport.EMAIL_ACCCOUTN_GOOGLE, accountInfo.get(GoogleAccountOBj.ACCOUTN_EMAIL)+"");
			sharePrefsSupport.saveString(SharePrefsSupport.PIC_ACCCOUTN_GOOGLE, accountInfo.get(GoogleAccountOBj.ACCOUTN_PICTURE)+"");
			
			//
			mAccountEmail.setText(accountInfo.get(GoogleAccountOBj.ACCOUTN_EMAIL)+"");
			mAcountName.setText(accountInfo.get(GoogleAccountOBj.ACCOUTN_NAME)+"");
			ImageLoader.getInstance().displayImage(accountInfo.getString(GoogleAccountOBj.ACCOUTN_PICTURE), ivAvatar);
			
			Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadDataLogin( Context context){
		try {
			//save data account info
			SharePrefsSupport sharePrefsSupport = new SharePrefsSupport(context);
			String email = sharePrefsSupport.loadString(SharePrefsSupport.NAME_ACCCOUTN_GOOGLE);
			String name = sharePrefsSupport.loadString(SharePrefsSupport.EMAIL_ACCCOUTN_GOOGLE);
			String link = sharePrefsSupport.loadString(SharePrefsSupport.PIC_ACCCOUTN_GOOGLE);
			
			//
			mAccountEmail.setText(email+"");
			mAcountName.setText(name+"");
			ImageLoader.getInstance().displayImage(link , ivAvatar);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
