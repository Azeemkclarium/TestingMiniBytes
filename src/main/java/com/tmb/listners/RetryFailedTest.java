package com.tmb.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.PropertiesEnums;
import com.tmb.utilities.ReadPropertyFile;

public class RetryFailedTest implements IRetryAnalyzer {

	private int counter = 0;

	private final int retries = 2;

	@Override
	public boolean retry(ITestResult result) {

		if (ReadPropertyFile.getvalue(PropertiesEnums.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
			if (counter < retries) {
				counter++;
				return true;
			}
		}

		return false;
	};

}
