package com.fyj.toyui.opengl.common;

/**
 * class for drawing all kinds of geometries and textures
 * 
 * @author mtk71339
 * 
 */
public interface GLCanvas {

	/**
	 * methods for affine transformation
	 */
	public void save();

	public void translate(float x, float y, float z);

	public void rotate(float x, float y, float z);

	public void scale(float x, float y, float z);

	public void restore();

	/**
	 * methods for drawing all kinds of objects
	 */
	public void drawLine(float x1, float y1, float x2, float y2, GLPaint paint);

	public void drawRect(float x1, float y1, float x2, float y2, GLPaint paint);

	public void fillRect(float x1, float y1, float x2, float y2, GLPaint paint);

	// public void drawBitmap(BitmapTexture tex, float x, float y, GLPaint
	// paint);

	public void clearBuffer();
}
