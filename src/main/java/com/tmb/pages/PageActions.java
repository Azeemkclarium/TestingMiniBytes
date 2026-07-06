package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tmb.drivers.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.extents.ExtentLogger;
import com.tmb.factories.ExplicitWaitFactory;

public class PageActions {

	protected PageActions() {
	};

	protected void click(By by, WaitStrategy wait, String elementName) {

		ExplicitWaitFactory.performExplicitWait(by, wait).click();

		ExtentLogger.pass("User clicked the : '" + elementName + " Successfully", true);

	}

	protected void sendKeys(By by, String value, WaitStrategy wait, String elementName) {
		ExplicitWaitFactory.performExplicitWait(by, wait).clear();

		ExplicitWaitFactory.performExplicitWait(by, wait).sendKeys(value);

		ExtentLogger.pass(" User Entered the : '" + value + "' in the " + elementName + " Successfully", true);

	}

	protected static boolean isElementPresent(By by, WaitStrategy wait) {
		return ExplicitWaitFactory.performExplicitWait(by, wait).isDisplayed();
	}

	protected static void mouseClick(WebElement element) {
		Actions actions = new Actions(DriverManager.getDriver());

		actions.moveToElement(element).click().perform();
	}
}
