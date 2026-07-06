package com.tmb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.dataprovider.DataProviderUtil;
import com.tmb.enums.TestCategory;
import com.tmb.extents.ExtentManager;
import com.tmb.pages.LoginPage;
import com.tmb.utilities.ReadPropertyFile;
import com.tmb.utilities.VerificationUtils;

public final class LoginTest extends BaseTest {

	private LoginTest() {
	};

	private static LoginPage loginPage = new LoginPage();

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void ValidLogin_SignOutTest(Map<String, String> map) {

		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();
		VerificationUtils.elementPresent(loginPage.profile_icon_verify(), "Profile Icon Displayed, Login Successful!");
		loginPage.clickProfileIcon();
		loginPage.clickSignOutButton();

	}
	
	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void ValidLoginTest(Map<String, String> map) {

		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();
		VerificationUtils.elementPresent(loginPage.profile_icon_verify(), "Profile Icon Displayed, Login Successful!");

	}

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void InvalidPassword(Map<String, String> map) {

		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();
		loginPage.errorMsg();
	}

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void Invalidname(Map<String, String> map) {

		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();
		loginPage.errorMsg();

	}

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void InvalidUP(Map<String, String> map) {

		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();
		loginPage.errorMsg();

	}
	
	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void InvalidPasswordLength(Map<String, String> map) {

		loginPage.enterUserName(map.get("Username"));
		loginPage.enterUserPassword(map.get("Password"));
		loginPage.clickLoginButton();
		loginPage.passwordLength_ErrorMsg();

	}

}
