package com.tmb.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.tmb.enums.ColorsEnum;
import com.tmb.enums.MarkSideEnum;
import com.tmb.enums.WaitStrategy;
import com.tmb.extents.ExtentLogger;
import com.tmb.factories.ExplicitWaitFactory;

public final class VerificationUtils {

	private VerificationUtils() {
	};
	
	public static SoftAssert sfAssert = new SoftAssert();

	public static void verifyEquals(WebElement element, String expected, String message, ColorsEnum color, String text,
			MarkSideEnum side) {

		String element_text = element.getText();
		try {
			sfAssert.assertEquals(element_text, expected, message);

			ExtentLogger.pass(message+" - PASSED - Expected: [" + expected + "] and Actual: [" + element_text + "]", true,
					element, color, text, side);
		} catch (AssertionError e) {
			ExtentLogger.fail("Title - FAILED. Expected: [" + expected + "] but Actual: [" + element_text + "]", true);
			throw e; // Rethrow to make sure TestNG marks the test case as failed
		}
	}

	public static void elementPresent(boolean isPresent, String message) {

		try {

			sfAssert.assertTrue(isPresent, message);
			ExtentLogger.pass(message + " - PASSED: Element Present", true);

		} catch (Exception e) {
			ExtentLogger.fail(message + " - FAILED: Element Present", true);
			throw e;
		}

	}

	public static void elementPresent(By by, WaitStrategy waitStrategy, String message, ColorsEnum color, String text,
			MarkSideEnum side) {
		try {
			WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
			sfAssert.assertTrue(element.isDisplayed(), message);

			ExtentLogger.pass(message, true, element, color, text, side);
		} catch (Exception | AssertionError e) {
			ExtentLogger.fail(message + " - FAILED. Error: " + e.getMessage(), true);
			throw e;
		}
	}
}
