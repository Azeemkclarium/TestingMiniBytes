package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstant;
import com.tmb.enums.TestCategory;

public final class ExtendReports {

	private ExtendReports() {
	};

	private static ExtentReports extentReports;

	public static void initReports() {
		if (extentReports == null) {

			extentReports = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstant.getExtentReportPath());
			extentReports.attachReporter(sparkReporter);
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setDocumentTitle(FrameworkConstant.EXTENT_DOC_TITLE);
			sparkReporter.config().setReportName("TMB Framework ");

		}
	}

	public static void flushReport() throws IOException {

		if (extentReports != null) {

			extentReports.flush();

		}

		ExtentManager.unLoad();
		Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentReportPath()).toURI());

	}

	public static void creatTest(String testCaseName) {

		ExtentManager.setExtent(extentReports.createTest(testCaseName));
	}

	public static void addAuthor(String[] author) {

		for (String temp : author) {
			ExtentManager.getextent().assignAuthor(temp);
		}

	}

	public static void addTestType(TestCategory[] test) {

		for (TestCategory temp : test) {
			ExtentManager.getextent().assignCategory(temp.toString());
		}

	}

}
