package com.vn.apksfull;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.vn.apksfull.R;

public class NavigationDrawerFm extends NavigationDrawerFragmentInit implements OnClickListener {

	public NavigationDrawerFm() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//selectItem(mCurrentSelectedPosition);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		OnClickListener clickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {

				selectItem(v.getId());

			}
		};
		// =3
//		mnChuyenTien.setOnClickListener(clickListener);
//		mnViCuaToi.setOnClickListener(clickListener);
//		mnThoat.setOnClickListener(clickListener);
//		mnNapTienGame.setOnClickListener(clickListener);

	}

	@Override
	protected void selectItem(int position) {

		super.selectItem(position);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		if (item.getItemId() == R.id.action_account) {
			Toast.makeText(getActivity(), "...", Toast.LENGTH_SHORT).show();
			return true;
		}

		// if(item.getItemId()==R.id.action_add_bank){
		// HomeActivity.Instance().pushFragments(TabId.QUANLYTHE,
		// AddEditBankFm.getInstanceAdd(0));
		// return true;
		// }

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
//		 switch (v.getId()) {
//		 case R.id.tv_ql_ungdung:
//		 selectItem(R.id.tv_ql_ungdung);
//		
//		 break;
		
		// case R.id.btnNotifi:
		// selectItem(R.id.btnNotifi);
		//
		// break;
		//
		// case R.id.btnSetting:
		// selectItem(R.id.btnSetting);
		//
		// break;
		//
		// case R.id.btnHelp:
		// selectItem(R.id.btnHelp);
		//
		// break;
		//
		// case R.id.btnExit:
		// selectItem(R.id.btnExit);
		//
		// break;
		//
		//
		// default:
		// break;
//		 }

	}

}
