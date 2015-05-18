package com.vn.apksfull;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;

import com.telpoo.frame.ui.BetaBaseFragment;
import com.telpoo.frame.utils.Utils;
import com.vn.apksfull.task.TaskType;

public class MyFragment extends BetaBaseFragment implements TaskType  {
	
	
	
	protected void addFragment(int resource, Fragment fm) {

		FragmentManager manager = getActivity().getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		ft.add(resource, fm);
		ft.commit();
	}

	protected void showFragment(int resource, Fragment fm) {

		FragmentManager manager = getActivity().getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		ft.show(fm);
		ft.commit();
	}
	
	protected void hideFragment(int resource, Fragment fm) {

		FragmentManager manager = getActivity().getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		ft.hide(fm);
		ft.commit();
	}
	protected void replaceFragment(int resource, Fragment fm) {

		FragmentManager manager = getActivity().getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		ft.replace(resource,fm);
		ft.commit();
	}
	
	protected void setTitle(int mntitle){
		HomeActivity.Instance().onSectionAttached(mntitle);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		hidekeyboard(getView(), getActivity());
	}

	public void hidekeyboard(final View view, final Activity activity) {
		if (view == null)
			return;
		
		view.setOnTouchListener(new OnTouchListener() {
			// View mview=view;
			public boolean onTouch(View v, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					if (!(view instanceof EditText))
						if (activity != null)
							Utils.hideSoftKeyboard(activity);

					/*
					 * if(count1>=30){ loadAdFull(activity);
					 * Utils.saveStringSPR(Defi.SPR.countClick, "0", activity);
					 * }
					 */
				}
				return false;
			}

		});

		// If a layout container, iterate over children and seed recursion.
		if (view instanceof ViewGroup) {

			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

				View innerView = ((ViewGroup) view).getChildAt(i);

				hidekeyboard(innerView, activity);
			}
		}
	}
	
	

}
