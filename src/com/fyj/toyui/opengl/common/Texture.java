package com.fyj.toyui.opengl.common;

public interface Texture {

	public int getWidth();

	public int getHeight();

	public void draw(GLCanvas canvas, int x, int y);

	public void draw(GLCanvas canvas, int x, int y, int w, int h);

	public boolean isOpaque();

}
