package com.fyj.toyui.system;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.fyj.toyui.opengl.common.GLRootView;

public class MainUIActivity extends Activity {
	/** Called when the activity is first created. */

	private GLRootView mView;

	protected void setUpUI(GLRootView view) {

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// full screen
		final Window window = this.getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		window.requestFeature(Window.FEATURE_NO_TITLE);

		// CommonUtils.setSharedContext(this);

		mView = new GLRootView(this);
		setUpUI(mView);
		setContentView(mView);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mView.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mView.onResume();
	}

}