package com.tmb.constants;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tmb.enums.PropertiesEnums;
import com.tmb.utilities.ReadPropertyFile;

public final class FrameworkConstant {

	// public final class because no one should Inherit

	// private constructor prevents creating Object for the class

	private FrameworkConstant() {
	}

	private static final String REPORT_TIMESTAMP = new SimpleDateFormat("MM-dd-yyyy_hhmm").format(new Date());

	private static final String ROOTPATH = System.getProperty("user.dir");

	private static final String CHROMEDRIVERPATH = ROOTPATH + "/src/test/resources/executables/chromedriver.exe";

	private static final String CONFIG_PROPERTYFILEPATH = ROOTPATH + "/src/test/resources/Property/config.properties";
	private static final String MESSAGE_PROPERTYFILEPATH = ROOTPATH
			+ "/src/test/resources/Property/messages.properties";

	private static final String EXCELTESTDATAPATH = ROOTPATH + "/src/test/resources/testdata/TestDataSheet.xlsx";

	private static final String EXTENT_REPORT_PATH = ROOTPATH + "/ExtentReport/";

	public static final String EXTENT_DOC_TITLE = "ExtentReportTestOutput" + REPORT_TIMESTAMP;

	public static final int TIMEOUT = 6;
	public static final int POLLING = 2;

	public static String getExtentReportPath() {

		if (ReadPropertyFile.getvalue(PropertiesEnums.OVERIDEREPORT).equalsIgnoreCase("yes")) {
			return EXTENT_REPORT_PATH + "TestExecutionReport.html";
		} else {
			return EXTENT_REPORT_PATH + "TestExecutionReport_" + REPORT_TIMESTAMP + ".html";
		}
	}

	public static String getExcelTestDataPath() {

		return EXCELTESTDATAPATH;
	}

	private static final int EXPLICITWAITTIME = 15;

	public static int getExplicitWaitTime() {
		return EXPLICITWAITTIME;
	}

	public static String getConfigPropertyFilePath() {
		return CONFIG_PROPERTYFILEPATH;
	}

	public static String getMessagePropertyFilePath() {
		return MESSAGE_PROPERTYFILEPATH;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

}
