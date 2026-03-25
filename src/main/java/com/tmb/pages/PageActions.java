package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

public class PageActions {

	protected PageActions() {
	};

	protected void click(By by, WaitStrategy wait, String elementName) {

		ExplicitWaitFactory.performExplicitWait(by, wait).click();

		ExtentLogger.pass("User clicked the : '" + elementName + " Successfully", true);

	}

	protected void sendKeys(By by, String value, WaitStrategy wait, String elementName) {

		ExplicitWaitFactory.performExplicitWait(by, wait).sendKeys(value);

		ExtentLogger.pass(" User Entered the : '" + value + "' in the " + elementName + " Successfully", true);

	}

	protected boolean isElementDisplayed(By by, WaitStrategy wait) {

		return ExplicitWaitFactory.performExplicitWait(by, wait).isDisplayed();

	}

}
