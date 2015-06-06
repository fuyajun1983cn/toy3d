/*
 * Copyright (C) 2012 Jackson Fu(fuyajun1983cn@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fyj.toyui.opengl.common;

import java.util.ArrayList;

import android.graphics.Rect;
import android.view.KeyEvent;

import com.fyj.toyui.utils.CommonUtils;

public class GLView {
	private static final String TAG = "GLView";

	public static final int VISIBLE = 0;
	public static final int INVISIBLE = 1;

	protected GLRoot mRoot;

	protected GLView mParent;
	protected ArrayList<GLView> mChildren;

	protected final Rect mBounds = new Rect();
	protected final Rect mPaddings = new Rect();

	protected int mWidth;
	protected int mHeight;

	/**
	 * methods for maintain relation to GLRoot
	 */
	public void attachToRoot(GLRoot root) {
		onAttachToRoot(root);
	}

	public void detachFromRoot() {
		onDetachFromRoot();
	}

	public void onAttachToRoot(GLRoot root) {
		mRoot = root;
	}

	public void onDetachFromRoot() {
		mRoot = null;
	}

	/**
	 * methods for animaiton
	 */

	/**
	 * methods for controlling view's visibility
	 */
	public void setVisibility(int visibility) {
		onVisibilityChanged(visibility);
	}

	protected void onVisibilityChanged(int visibility) {

	}

	public int getVisibility() {
		return 0;
	}

	/**
	 * methods for manage view tree structure
	 */
	public int getChildrenCount() {
		return mChildren == null ? 0 : mChildren.size();
	}

	public GLView getChild(int index) {
		CommonUtils.assertTrue(index >= 0 && index < mChildren.size());
		return mChildren.get(index);
	}

	public void addChild(GLView view) {
		CommonUtils.assertTrue(view != null);
		if (mChildren.contains(view))
			return;
		view.mParent = this;
		mChildren.add(view);
	}

	public void removeChild(GLView child) {
		CommonUtils.assertTrue(child != null);
		mChildren.remove(child);
	}

	public void removeAllChildren() {
		mChildren.clear();
	}

	/**
	 * methods for maintain view's geometry attributes
	 */
	public void setSize(int w, int h) {
		mWidth = w;
		mHeight = h;
	}

	public int getWidth() {
		return mWidth;
	}

	public int getHeight() {
		return mHeight;
	}

	public Rect getBounds() {
		return null;
	}

	public void setBounds() {

	}

	/**
	 * methods for rendering view
	 */
	protected void render(GLCanvas canvas) {
		renderBackground(canvas);
		for (int i = 0, n = getChildrenCount(); i < n; ++i) {
			renderChild(canvas, getChild(i));
		}
	}

	protected void renderBackground(GLCanvas canvas) {
		canvas.clearBuffer();
		GLPaint paint = new GLPaint();
		paint.setColor(0xffff0ff);
		paint.setLineWidth(2.0f);
		canvas.drawRect(150, 150, 400, 400, paint);
		canvas.drawLine(600, 200, 800, 500, paint);
		paint.setColor(0x00ff00ff);
		canvas.fillRect(900, 200, 1100, 500, paint);

		/*
		 * BitmapTexture bt = new BitmapTexture(PixelFormat.RGBA_8888,
		 * TextureOptions.NEAREST, null); bt.loadBitmap(R.drawable.ic_launcher);
		 * canvas.drawBitmap(bt, 150, 450, paint);
		 */
	}

	protected void renderChild(GLCanvas canvas, GLView child) {
		child.render(canvas);
	}

	/**
	 * methods for event handling
	 */
	protected boolean dispatchKeyEvent(KeyEvent event) {
		return false;
	}

	/**
	 * methods for layout view
	 */
	public Rect getPaddings() {
		return null;
	}

	public void setPaddings() {

	}

	public void setPaddings(int left, int top, int right, int bottom) {

	}

	public void layout(int left, int top, int right, int bottom) {
		onLayout(false, left, top, right, bottom);
	}

	protected void onLayout(boolean changedSize, int left, int top, int right,
			int bottom) {

	}
}
