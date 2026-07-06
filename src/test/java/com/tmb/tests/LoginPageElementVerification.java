package com.tmb.tests;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.dataprovider.DataProviderUtil;
import com.tmb.enums.ColorsEnum;
import com.tmb.enums.MarkSideEnum;
import com.tmb.enums.TestCategory;
import com.tmb.enums.WaitStrategy;
import com.tmb.pages.LoginPageUIElements;
import com.tmb.utilities.ReadPropertyFile;
import com.tmb.utilities.VerificationUtils;

public final class LoginPageElementVerification extends BaseTest {

	private LoginPageElementVerification() {
	};

	private static LoginPageUIElements loginpageverification = new LoginPageUIElements();

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void verifyUIElements(Map<String, String> map) {

		// Header 1 Verification
		VerificationUtils.verifyEquals(loginpageverification.headerText(), ReadPropertyFile.getvalue("login.header_H1"),
				"H1 - Present and Matches the Expected.", ColorsEnum.GOLDENYELLOW, "Header Successfully Verified.",
				MarkSideEnum.LEFT);

		// Header Sub-Title
		VerificationUtils.verifyEquals(loginpageverification.loginPageSubTitle(),
				ReadPropertyFile.getvalue("login.subtitle_H2"), "H2 - Present and Matches the Expected.",
				ColorsEnum.GOLDENYELLOW, "Header Sub-Title Successfully Verified.", MarkSideEnum.LEFT);

		// Header Accent Present
		VerificationUtils.elementPresent(loginpageverification.getHeaderAccent(), WaitStrategy.PRESENT,
				"Accent Presented in Landing epage", ColorsEnum.RED, "Accent Presented as expected", MarkSideEnum.RIGHT);

		VerificationUtils.elementPresent(loginpageverification.verifyLogo(), WaitStrategy.VISIBLE,
				"Logo presented in Landing Page.", ColorsEnum.RED, "Logo Verified", MarkSideEnum.RIGHT);

		VerificationUtils.verifyEquals(loginpageverification.leftPanel(), ReadPropertyFile.getvalue("leftpanel"),
				"Left Panel text Matches", ColorsEnum.GOLDENYELLOW, "Left Panel Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.leftPanelDesc(), ReadPropertyFile.getvalue("leftpaneldesc"),
				"Left Panel Desc text Matches", ColorsEnum.GOLDENYELLOW, "Left Panel Desc Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.grid1_title(), ReadPropertyFile.getvalue("grid1_title"),
				"Grid 1 Title", ColorsEnum.GOLDENYELLOW, "Grid 1 Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.grid1_desc(), ReadPropertyFile.getvalue("grid1_desc"),
				"Grid 1 Description", ColorsEnum.GOLDENYELLOW, "Grid 1 Description Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.grid2_title(), ReadPropertyFile.getvalue("grid2_title"),
				"Grid 2 Title", ColorsEnum.GOLDENYELLOW, "Grid 2 Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.grid2_desc(), ReadPropertyFile.getvalue("grid2_desc"),
				"Grid 2 Description", ColorsEnum.GOLDENYELLOW, "Grid 2 Description Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.grid3_title(), ReadPropertyFile.getvalue("grid3_title"),
				"Grid 3 Title", ColorsEnum.GOLDENYELLOW, "Grid 3 Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.grid3_desc(), ReadPropertyFile.getvalue("grid3_desc"),
				"Grid 3 Description", ColorsEnum.GOLDENYELLOW, "Grid 3 Description Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.assistence(), ReadPropertyFile.getvalue("assist"),
				"Assistance Text", ColorsEnum.GOLDENYELLOW, "Assistence Text Verified", MarkSideEnum.RIGHT);
		
		VerificationUtils.verifyEquals(loginpageverification.footertext(), ReadPropertyFile.getvalue("footer"),
				"Footer Text", ColorsEnum.GOLDENYELLOW, "Footer Verified", MarkSideEnum.LEFT);
	}

}
