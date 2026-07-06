package com.tmb.extents;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.enums.ColorsEnum;
import com.tmb.enums.MarkSideEnum;
import com.tmb.enums.PropertiesEnums;
import com.tmb.utilities.ReadPropertyFile;
import com.tmb.utilities.ScreenShot;

public final class ExtentLogger {

	private ExtentLogger() {
	};

	public static void pass(String message) {

		ExtentManager.getextent().pass(message);

	}

	public static void pass(String message, boolean isScreenShotNeed) {

		if (ReadPropertyFile.getvalue(PropertiesEnums.PASSEDSCREENSHOT).equalsIgnoreCase("yes") && isScreenShotNeed) {

			ExtentManager.getextent().pass(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShot.takeScreenShot_B64(message)).build());
		} else {
			pass(message);
		}

	}

	public static void pass(String message, boolean isScreenShotNeed, WebElement element, ColorsEnum color, String text,
			MarkSideEnum side) {
		if (ReadPropertyFile.getvalue(PropertiesEnums.PASSEDSCREENSHOT).equalsIgnoreCase("yes") && isScreenShotNeed) {
			ExtentManager.getextent().pass(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShot.takeScreenshot_B64(element, color, text, side))
					.build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message) {
		ExtentManager.getextent().fail(message);
	}

	public static void fail(String message, boolean isScreenShotNeed) {

		if (ReadPropertyFile.getvalue(PropertiesEnums.FAILEDSCREENSHOT).equalsIgnoreCase("yes") && isScreenShotNeed) {

			ExtentManager.getextent().fail(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShot.takeScreenShot_B64(message)).build());
		} else {
			fail(message);
		}

	}

	public static void fail(String message, boolean isScreenShotNeed, WebElement element, ColorsEnum color, String text,
			MarkSideEnum side) {
		if (ReadPropertyFile.getvalue(PropertiesEnums.FAILEDSCREENSHOT).equalsIgnoreCase("yes") && isScreenShotNeed) {
			ExtentManager.getextent().fail(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShot.takeScreenshot_B64(element, color, text, side))
					.build());
		} else {
			pass(message);
		}
	}

	public static void skip(String message) {

		ExtentManager.getextent().skip(message);

	}

}
