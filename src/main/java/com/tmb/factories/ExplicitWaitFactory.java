package com.tmb.factories;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.tmb.constants.FrameworkConstant;
import com.tmb.drivers.DriverManager;
import com.tmb.enums.WaitStrategy;

public class ExplicitWaitFactory {

	private static FluentWait<WebDriver> getWait() {
		return new FluentWait<>(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(FrameworkConstant.TIMEOUT))
				.pollingEvery(Duration.ofSeconds(FrameworkConstant.POLLING)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}

	public static WebElement performExplicitWait(By by, WaitStrategy waitingstrateties) {

		switch (waitingstrateties) {

		case CLICKABLE:
			return getWait().until(ExpectedConditions.elementToBeClickable(by));
		case VISIBLE:
			return getWait().until(ExpectedConditions.visibilityOfElementLocated(by));

		case PRESENT:
			return getWait().until(ExpectedConditions.presenceOfElementLocated(by));
		case NONE:
			return DriverManager.getDriver().findElement(by);

		default:
			throw new IllegalArgumentException("Invalid wait strategy, Please select as per the Enums");

		}

	}

}
