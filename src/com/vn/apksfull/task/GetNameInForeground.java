package com.vn.apksfull.task;

import java.io.IOException;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.telpoo.frame.utils.Mlog;
import com.vn.apksfull.HomeActivity;
import com.vn.apksfull.db.SharePrefsSupport;
import com.vn.apksfull.utils.MySpr;

public class GetNameInForeground extends AbstractGetNameTask {
		 
		  public GetNameInForeground(HomeActivity activity, String email, String scope,LoginTaskControl mLoginTaskControl) {
		      super(activity, email, scope, mLoginTaskControl);
		  }
		 
		  /**
		   * Get a authentication token if one is not available. If the error is not recoverable then
		   * it displays the error message on parent activity right away.
		   */
		  @Override
		  protected String fetchToken() throws IOException {
		      try {
		    	  String token = GoogleAuthUtil.getToken(mActivity, mEmail, mScope);
		    	  MySpr.saveToken(mActivity, token);
		    	  Mlog.D("token="+token);
		    	  SharePrefsSupport sharePrefsSupport = new SharePrefsSupport(mActivity);
		    	  sharePrefsSupport.saveString(SharePrefsSupport.TOKEN_ACCCOUTN_GOOGLE,token);
		          return token;
		      } catch (UserRecoverableAuthException userRecoverableException) {
		          // GooglePlayServices.apk is either old, disabled, or not present, which is
		          // recoverable, so we need to show the user some UI through the activity.
		          mActivity.handleException(userRecoverableException);
		      } catch (GoogleAuthException fatalException) {
		          onError("Unrecoverable error " + fatalException.getMessage(), fatalException);
		      }
		      return null;
		  }
}
