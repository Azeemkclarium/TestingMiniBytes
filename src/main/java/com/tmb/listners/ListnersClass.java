package com.tmb.listners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.reports.ExtendReports;
import com.tmb.reports.ExtentLogger;

public class ListnersClass implements ITestListener, ISuiteListener {

	public void onStart(ISuite suite) {
		ExtendReports.initReports();
	}

	public void onFinish(ISuite suite) {
		try {
			ExtendReports.flushReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		ExtendReports.creatTest(result.getMethod().getDescription());

		ExtendReports.addAuthor(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class).authorName());

		ExtendReports.addTestType(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class).testCategory());

	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " Is Passed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " Is Failed due to " + result.getThrowable(), true);

	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " Is Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		// not implemented
	}

}
