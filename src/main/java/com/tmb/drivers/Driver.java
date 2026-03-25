package com.tmb.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tmb.enums.PropertiesEnums;
import com.tmb.utilities.ReadPropertyFile;

public final class Driver {
	private Driver() {
	};

	private static void commonBrowserSetup() {
		DriverManager.getDriver().get(ReadPropertyFile.getvalue(PropertiesEnums.URL).toString());

		DriverManager.getDriver().manage().window().maximize();
	}

	public static void initDriver(String browser) throws Exception {

		if (DriverManager.getDriver() == null) {

			switch (browser.toLowerCase()) {
			case "chrome":
				DriverManager.setDriver(new ChromeDriver());
				break;
			case "firefox":
				DriverManager.setDriver(new FirefoxDriver());
				break;
			case "ie":
				DriverManager.setDriver(new InternetExplorerDriver());
				break;

			default:
				throw new IllegalArgumentException(
						browser + " : Given browser is not defined. Please provide the correct browser name.");
			}
			commonBrowserSetup();

		}

	}

	public static void quiteDriver() {

		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
			DriverManager.unLoad();
		}
	}

}
