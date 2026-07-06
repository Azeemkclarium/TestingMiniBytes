package com.tmb.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.tmb.constants.FrameworkConstant;
import com.tmb.drivers.Driver;
import com.tmb.enums.PropertiesEnums;
import com.tmb.extents.ExtendReports;
import com.tmb.utilities.EmailUtils;
import com.tmb.utilities.ReadPropertyFile;

public class BaseTest {

	protected BaseTest() {
	};

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] getdata) throws Exception {
		Map<String, String> map = (Map<String, String>) getdata[0];

		if (ReadPropertyFile.getvalue(PropertiesEnums.PARALLELBROWSEREXECUTION).equalsIgnoreCase("yes")) {
			Driver.initDriver(map.get("Browser").toLowerCase());
		} else {

			Driver.initDriver(ReadPropertyFile.getvalue(PropertiesEnums.BROWSER));
		}

	}

	@AfterSuite
	protected void globalTearDown() throws IOException {
		Driver.quiteDriver();

		ExtendReports.flushReport();
	}

}
