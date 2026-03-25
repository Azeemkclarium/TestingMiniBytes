package com.tmb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.dataprovider.DataProviderUtil;
import com.tmb.enums.TestCategory;
import com.tmb.pages.LoginPage;
import com.tmb.reports.ExtentManager;

public final class LoginTest_HRM extends BaseTest {

	private LoginTest_HRM() {
	};

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void validloginTest(Map<String, String> map) {


		LoginPage loginPage = new LoginPage();
		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();

		boolean timeworkDisplay = loginPage.gettimeAtWork();
		Assert.assertTrue(timeworkDisplay, "Time at Work element is NOT displayed, Login Failed");

		loginPage.profileClick();
		loginPage.logOutClick();

	}

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void inValidloginTest1(Map<String, String> map) {

		LoginPage loginPage = new LoginPage();
		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();

		Assert.assertTrue(loginPage.invalidCredential());

	}

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void inValidloginTest2(Map<String, String> map) {

		LoginPage loginPage = new LoginPage();
		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();

		Assert.assertTrue(loginPage.invalidCredential());

	}

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void inValidloginTest3(Map<String, String> map) {

		LoginPage loginPage = new LoginPage();
		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();

		Assert.assertTrue(loginPage.invalidCredential());

	}

}
