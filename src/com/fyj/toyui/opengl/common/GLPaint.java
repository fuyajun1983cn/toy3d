package com.fyj.toyui.opengl.common;

import com.fyj.toyui.utils.CommonUtils;

public class GLPaint {
	public static final int FLAG_ANTI_ALIAS = 0x01;

	private int mFlags = 0;
	private float mLineWidth = 1f;
	private int mColor = 0;

	public int getFlags() {
		return mFlags;
	}

	public void setFlags(int flags) {
		mFlags = flags;
	}

	public void setColor(int color) {
		mColor = color;
	}

	public int getColor() {
		return mColor;
	}

	public void setLineWidth(float width) {
		CommonUtils.assertTrue(width >= 0);
		mLineWidth = width;
	}

	public float getLineWidth() {
		return mLineWidth;
	}

	public void setAntiAlias(boolean enabled) {
		if (enabled) {
			mFlags |= FLAG_ANTI_ALIAS;
		} else {
			mFlags &= ~FLAG_ANTI_ALIAS;
		}
	}

	public boolean getAntiAlias() {
		return (mFlags & FLAG_ANTI_ALIAS) != 0;
	}
}
