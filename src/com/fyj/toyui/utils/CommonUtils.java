package com.fyj.toyui.utils;

public class CommonUtils {

	private CommonUtils() {

	}

	// Throws AssertionError if the input is false.
	public static void assertTrue(boolean cond) {
		if (!cond) {
			throw new AssertionError();
		}
	}

	public static boolean isOpaque(int color) {
		return color >>> 24 == 0xFF;
	}
}
