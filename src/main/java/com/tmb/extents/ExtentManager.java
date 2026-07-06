package com.tmb.extents;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {
	};

	private static ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

	public static ExtentTest getextent() {

		return extent.get();
	}

	protected static void setExtent(ExtentTest test) {
		extent.set(test);
	}

	protected static void unLoad() {
		extent.remove();
	}

}
