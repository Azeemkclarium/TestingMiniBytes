package com.tmb.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tmb.drivers.DriverManager;

public final class ScreenShot {

	public static String takeScreenShot_B64(String message) {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
