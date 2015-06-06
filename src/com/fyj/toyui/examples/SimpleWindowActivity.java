package com.fyj.toyui.examples;

import com.fyj.toyui.opengl.common.GLRootView;
import com.fyj.toyui.opengl.common.GLView;
import com.fyj.toyui.system.MainUIActivity;

public class SimpleWindowActivity extends MainUIActivity {

	GLView win;

	@Override
	protected void setUpUI(GLRootView view) {
		// TODO Auto-generated method stub
		win = new GLView();
		win.onAttachToRoot(view);
		view.setContentPanel(win);
	}

}
