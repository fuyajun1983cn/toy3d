package com.fyj.toyui.opengl.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import android.opengl.GLU;

import com.fyj.toyui.utils.CommonUtils;

public class GLCanvasImpl implements GLCanvas {

	private static final float OPAQUE_ALPHA = 0.95f;

	private GL11 mGL;

	private int mWidth = 0;
	private int mHeight = 0;

	public GLCanvasImpl(GL11 gl) {
		mGL = gl;
	}

	public void setSize(int width, int height) {
		CommonUtils.assertTrue(width > 0 && height > 0);

		mWidth = width;
		mHeight = height;
		GL11 gl = mGL;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL11.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluOrtho2D(gl, 0, width, 0, height);
		gl.glMatrixMode(GL11.GL_MODELVIEW);
		gl.glLoadIdentity();

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void translate(float x, float y, float z) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotate(float x, float y, float z) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scale(float x, float y, float z) {
		// TODO Auto-generated method stub

	}

	@Override
	public void restore() {
		// TODO Auto-generated method stub

	}

	/*
	 * 
	 * public void drawBitmap(BitmapTexture tex, float x, float y, GLPaint
	 * paint) { try { tex.loadToHardware(mGL); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); return; }
	 * 
	 * int hardwaredID[] = new int[2]; mGL.glGenBuffers(2, hardwaredID, 0);
	 * mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, hardwaredID[0]); FloatBuffer
	 * verBuffer = ByteBuffer.allocateDirect(2 * 4 * 4)
	 * .order(ByteOrder.nativeOrder()).asFloatBuffer(); verBuffer.put(new
	 * float[] { x, y, x + tex.getWidth(), y, x, y + tex.getHeight(), x +
	 * tex.getWidth(), y + tex.getHeight() }); verBuffer.position(0);
	 * mGL.glBufferData(GL11.GL_ARRAY_BUFFER, 2 * 4 * 4, verBuffer,
	 * GL11.GL_STATIC_DRAW); mGL.glVertexPointer(2, GL11.GL_FLOAT, 0, 0);
	 * 
	 * mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, hardwaredID[1]); FloatBuffer
	 * texBuffer = ByteBuffer.allocateDirect(2 * 4 * 4)
	 * .order(ByteOrder.nativeOrder()).asFloatBuffer(); texBuffer.put(new
	 * float[] { 0, 0, 1, 0, 0, 1, 1, 1 }); texBuffer.position(0);
	 * mGL.glBufferData(GL11.GL_ARRAY_BUFFER, 2 * 4 * 4, texBuffer,
	 * GL11.GL_STATIC_DRAW); mGL.glTexCoordPointer(2, GL11.GL_FLOAT, 0, 0);
	 * 
	 * GLState state = new GLState(mGL); //
	 * state.setTexEnvMode(GL11.GL_REPLACE);
	 * 
	 * mGL.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
	 * mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, 0); mGL.glDeleteBuffers(2,
	 * hardwaredID, 0); }
	 */
	@Override
	public void drawLine(float x1, float y1, float x2, float y2, GLPaint paint) {
		// TODO Auto-generated method stub

		int hardwaredID[] = new int[1];
		mGL.glGenBuffers(1, hardwaredID, 0);
		mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, hardwaredID[0]);
		FloatBuffer buffer = ByteBuffer.allocateDirect(2 * 2 * 4)
				.order(ByteOrder.nativeOrder()).asFloatBuffer();
		buffer.put(new float[] { x1, y1, x2, y2 });
		buffer.position(0);
		mGL.glBufferData(GL11.GL_ARRAY_BUFFER, 2 * 2 * 4, buffer,
				GL11.GL_STATIC_DRAW);
		mGL.glVertexPointer(2, GL11.GL_FLOAT, 0, 0);
		GLState state = new GLState(mGL);
		state.setColorMode(paint.getColor());
		state.setLineSmooth(true);
		state.setLineWidth(paint.getLineWidth());
		mGL.glDrawArrays(GL11.GL_LINES, 0, 2);
		mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, 0);
		mGL.glDeleteBuffers(1, hardwaredID, 0);
	}

	@Override
	public void drawRect(float x1, float y1, float x2, float y2, GLPaint paint) {
		// TODO Auto-generated method stub
		int hardwaredID[] = new int[1];
		mGL.glGenBuffers(1, hardwaredID, 0);
		mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, hardwaredID[0]);
		FloatBuffer buffer = ByteBuffer.allocateDirect(2 * 4 * 4)
				.order(ByteOrder.nativeOrder()).asFloatBuffer();
		buffer.put(new float[] { x1, y1, x2, y1, x2, y2, x1, y2 });
		buffer.position(0);
		mGL.glBufferData(GL11.GL_ARRAY_BUFFER, 2 * 4 * 4, buffer,
				GL11.GL_STATIC_DRAW);
		mGL.glVertexPointer(2, GL11.GL_FLOAT, 0, 0);
		GLState state = new GLState(mGL);
		state.setColorMode(paint.getColor());
		state.setLineSmooth(true);
		state.setLineWidth(paint.getLineWidth());
		mGL.glDrawArrays(GL11.GL_LINE_LOOP, 0, 4);
		mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, 0);
		mGL.glDeleteBuffers(1, hardwaredID, 0);
	}

	@Override
	public void fillRect(float x1, float y1, float x2, float y2, GLPaint paint) {
		// TODO Auto-generated method stub
		int hardwaredID[] = new int[1];
		mGL.glGenBuffers(1, hardwaredID, 0);
		mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, hardwaredID[0]);
		FloatBuffer buffer = ByteBuffer.allocateDirect(2 * 4 * 4)
				.order(ByteOrder.nativeOrder()).asFloatBuffer();
		buffer.put(new float[] { x1, y1, x2, y1, x2, y2, x1, y2 });
		buffer.position(0);
		mGL.glBufferData(GL11.GL_ARRAY_BUFFER, 2 * 4 * 4, buffer,
				GL11.GL_STATIC_DRAW);
		mGL.glVertexPointer(2, GL11.GL_FLOAT, 0, 0);
		GLState state = new GLState(mGL);
		state.setColorMode(paint.getColor());
		state.setLineSmooth(true);
		state.setLineWidth(paint.getLineWidth());
		mGL.glDrawArrays(GL11.GL_TRIANGLE_FAN, 0, 4);
		mGL.glBindBuffer(GL11.GL_ARRAY_BUFFER, 0);
		mGL.glDeleteBuffers(1, hardwaredID, 0);
	}

	@Override
	public void clearBuffer() {
		// TODO Auto-generated method stub
		mGL.glClearColor(0, 0, 0, 0);
		mGL.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	private static class GLState {

		private final GL11 mGL;

		private int mTexEnvMode = GL11.GL_REPLACE;
		private float mTextureAlpha = 1.0f;
		private boolean mTexture2DEnabled = true;
		private boolean mBlendEnabled = true;
		private float mLineWidth = 1.0f;
		private boolean mLineSmooth = false;

		public GLState(GL11 gl) {
			mGL = gl;

			// Disable unused state
			gl.glDisable(GL11.GL_LIGHTING);

			// Enable used features
			gl.glEnable(GL11.GL_DITHER);
			// gl.glEnable(GL11.GL_SCISSOR_TEST);

			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glEnable(GL11.GL_TEXTURE_2D);

			gl.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE,
					GL11.GL_REPLACE);

			// Set the background color
			gl.glClearColor(0f, 0f, 0f, 0f);
			gl.glClearStencil(0);

			gl.glEnable(GL11.GL_BLEND);
			gl.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_SRC_ALPHA);

			// We use 565 or 8888 format, so set the alignment to 2 bytes/pixel.
			gl.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 2);
		}

		public void setTexEnvMode(int mode) {
			if (mTexEnvMode == mode)
				return;
			mTexEnvMode = mode;
			mGL.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, mode);
		}

		public void setLineWidth(float width) {
			if (mLineWidth == width)
				return;
			mLineWidth = width;
			mGL.glLineWidth(width);
		}

		public void setLineSmooth(boolean enabled) {
			if (mLineSmooth == enabled)
				return;
			mLineSmooth = enabled;
			if (enabled) {
				mGL.glEnable(GL11.GL_LINE_SMOOTH);
			} else {
				mGL.glDisable(GL11.GL_LINE_SMOOTH);
			}
		}

		public void setTextureAlpha(float alpha) {
			if (mTextureAlpha == alpha)
				return;
			mTextureAlpha = alpha;
			if (alpha >= OPAQUE_ALPHA) {
				// The alpha is need for those texture without alpha channel
				mGL.glColor4f(1, 1, 1, 1);
				setTexEnvMode(GL11.GL_REPLACE);
			} else {
				mGL.glColor4f(alpha, alpha, alpha, alpha);
				setTexEnvMode(GL11.GL_MODULATE);
			}
		}

		public void setColorMode(int color) {
			// setBlendEnabled(!Utils.isOpaque(color));

			// Set mTextureAlpha to an invalid value, so that it will reset
			// again in setTextureAlpha(float) later.
			mTextureAlpha = -1.0f;

			setTexture2DEnabled(false);

			float r = (float) ((color >>> 24) & 0xFF) / 255;
			float g = (float) ((color >>> 16) & 0xFF) / 255;
			float b = (float) ((color >>> 8) & 0xFF) / 255;
			float a = (float) (color & 0xFF) / 255;

			mGL.glColor4f(r, g, b, a);
		}

		public void setTexture2DEnabled(boolean enabled) {
			if (mTexture2DEnabled == enabled)
				return;
			mTexture2DEnabled = enabled;
			if (enabled) {
				mGL.glEnable(GL11.GL_TEXTURE_2D);
			} else {
				mGL.glDisable(GL11.GL_TEXTURE_2D);
			}
		}

		public void setBlendEnabled(boolean enabled) {
			if (mBlendEnabled == enabled)
				return;
			mBlendEnabled = enabled;
			if (enabled) {
				mGL.glEnable(GL11.GL_BLEND);
			} else {
				mGL.glDisable(GL11.GL_BLEND);
			}
		}
	}
}
