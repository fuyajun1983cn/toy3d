package com.fyj.toyui.opengl.common;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * 
 * Render Class
 * 
 * @author mtk71339
 * 
 */
public class GLRootView extends GLSurfaceView implements
		GLSurfaceView.Renderer, GLRoot {

	private final String TAG = "GLRootView";

	private GL11 mGL;
	private GLCanvasImpl mCanvas;
	private GLView mContentPanel;

	private boolean renderRequested = false;

	public GLRootView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setRenderer(this);
	}

	public void requestRender() {
		renderRequested = true;
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		// mGL.glClearColor(0, 0, 0, 0);
		// mGL.glClear(GL11.GL_COLOR_BUFFER_BIT);

		renderRequested = false;

		mContentPanel.render(mCanvas);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		mCanvas.setSize(width, height);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		mGL = (GL11) gl;
		mCanvas = new GLCanvasImpl(mGL);
	}

	public GLCanvas getCanvas() {
		return mCanvas;
	}

	@Override
	public void setContentPanel(GLView panel) {
		// TODO Auto-generated method stub
		mContentPanel = panel;
	}

}
