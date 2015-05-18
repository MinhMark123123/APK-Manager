package com.vn.apksfull;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.telpoo.frame.net.BaseNetSupportBeta;
import com.telpoo.frame.net.NetConfig;
import com.telpoo.frame.ui.BetaBaseFmActivity;

public class MyHomeActivity extends BetaBaseFmActivity implements NavigationDrawerFm.NavigationDrawerCallbacks {
	static String[] tabids = TabId.tabids;
	TextView tvTitle, tvNotifi;

	public int menuId = 0;
	

	public MyHomeActivity() {
		super(tabids, R.id.realTabContent, "Bấm thêm lần nữa để thoát!");
	}

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFm mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;
	ActionBar actionBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		mNavigationDrawerFragment = (NavigationDrawerFm) getSupportFragmentManager().findFragmentById(
				R.id.navigation_drawer);
		
		mTitle = getTitle();

		
		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
		initNetWork();
		restoreActionBar();
	}

	public void hideMenu(boolean isHide) {
		DrawerLayout dr = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (isHide) {
			dr.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
		} else {
			dr.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
		}
	}

	private void initNetWork() {
		NetConfig netConfig = new NetConfig.Builder().authorization("vnp-mobile-app:A8aFPkuCmbeBcTXRQVyZNn4hW9q")
				.contentType("application/x-www-form-urlencoded").connectTimeout(10000).numberRetry(3).build();
		BaseNetSupportBeta.getInstance().init(netConfig);

	}

	public void onSectionAttached(int number) {
		switch (number) {
		// =5
//		case R.id.mnChuyenTien:
//			setTextTitle("Chuyá»ƒn tiá»�n");
//			break;

//
//		case R.id.mnDangXuat:
//			break;
//		case R.id.mnViCuaToi:
//			setTextTitle("VÃ­ cá»§a tÃ´i");
//			break;
//
//		case R.id.mnQuanLythe:
//			setTextTitle("Quáº£n lÃ½ tháº»/ngÃ¢n hÃ ng");
//			break;
		default:
			break;
		}
	}

	public void restoreActionBar() {
		actionBar = getSupportActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
				| ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE);
		android.support.v7.app.ActionBar.LayoutParams lp = new android.support.v7.app.ActionBar.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.RIGHT | Gravity.CENTER_VERTICAL);

		actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bgactionbar)));
		actionBar.setDisplayHomeAsUpEnabled(true);
		//actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
	}

	public void setTextTitle(String string) {
		tvTitle.setText(string);

	}

	

	public void setIconMenuBack() {

//		 actionBar.setIcon(R.drawable.back50);
//		 actionBar.setDisplayShowCustomEnabled(true);
//		 actionBar.setDisplayShowHomeEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			switch (menuId) {
			case 0:
				getMenuInflater().inflate(R.menu.home, menu);

				break;

			case 1:
				getMenuInflater().inflate(R.menu.home, menu);
				

			default:
				break;
			}

			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	public void updateMenu(int menuId) {
		this.menuId = menuId;
		ActivityCompat.invalidateOptionsMenu(this);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// TODO Auto-generated method stub

	}

	/**
	 * replace 1 fragment vao thay the
	 * 
	 * @param tab
	 * @param fragment
	 */
	public void pushFragments(String tab, Fragment fragment) {
		super.pushFragments(tab, fragment, true, null);
	}

}
