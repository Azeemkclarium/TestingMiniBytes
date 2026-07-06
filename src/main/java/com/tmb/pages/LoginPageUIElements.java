package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;

public final class LoginPageUIElements extends PageActions {

	private final By loginPageHeaderH1 = By.xpath("//div[@class='login-page__header']/child::h1");

	private final By loginPageHeaderH1_Accent = By.xpath("//div[@class='login-page__header']/child::div");

	private final By loginPageHeaderH1_SubTitle = By.xpath("//div[@class='login-page__header']/child::p");

	private final By logo = By.xpath("//div[@class='login-page__logo-wrap']/child::img");

	private final By brandPanelEyeBrow = By.xpath("//div[@class='brand-panel__hero']/child::p");
	private final By brandPanelTitle = By.xpath("//div[@class='brand-panel__hero']/child::h2");

	private final By brandFeatureCard_1_Title = By
			.xpath("//div[@class='brand-panel__features-grid']/child::div[1]/p[1]");
	private final By brandFeatureCard_1_Desc = By
			.xpath("//div[@class='brand-panel__features-grid']/child::div[1]/p[2]");

	private final By brandFeatureCard_2_Title = By
			.xpath("//div[@class='brand-panel__features-grid']/child::div[2]/p[1]");
	private final By brandFeatureCard_2_Desc = By
			.xpath("//div[@class='brand-panel__features-grid']/child::div[2]/p[2]");

	private final By brandFeatureCard_3_Title = By
			.xpath("//div[@class='brand-panel__features-grid']/child::div[3]/p[1]");
	private final By brandFeatureCard_3_Desc = By
			.xpath("//div[@class='brand-panel__features-grid']/child::div[3]/p[2]");

	private final By loginSupportText = By.xpath("//div[@class='login-page__support-section']/p");

	private final By loginFooterText = By.xpath("//div[@class='login-page__footer']/span[2]");

	public final WebElement headerText() {

		return ExplicitWaitFactory.performExplicitWait(loginPageHeaderH1, WaitStrategy.VISIBLE);
	}

	public final WebElement loginPageSubTitle() {

		return ExplicitWaitFactory.performExplicitWait(loginPageHeaderH1_SubTitle, WaitStrategy.VISIBLE);
	}

	public final boolean headerAccent() {

		return isElementPresent(loginPageHeaderH1_Accent, WaitStrategy.PRESENT);
	}

	public final By getHeaderAccent() {

		return this.loginPageHeaderH1_Accent;
	}
	
	public final By verifyLogo() {
		return this.logo;
		
	}
	
	public final WebElement leftPanel() {

		return ExplicitWaitFactory.performExplicitWait(brandPanelEyeBrow, WaitStrategy.VISIBLE);
	}
	
	public final WebElement leftPanelDesc() {

		return ExplicitWaitFactory.performExplicitWait(brandPanelTitle, WaitStrategy.VISIBLE);
	}
	
	public final WebElement grid1_title() {

		return ExplicitWaitFactory.performExplicitWait(brandFeatureCard_1_Title, WaitStrategy.VISIBLE);
	}
	
	public final WebElement grid1_desc() {

		return ExplicitWaitFactory.performExplicitWait(brandFeatureCard_1_Desc, WaitStrategy.VISIBLE);
	}
	
	public final WebElement grid2_title() {

		return ExplicitWaitFactory.performExplicitWait(brandFeatureCard_2_Title, WaitStrategy.VISIBLE);
	}
	
	public final WebElement grid2_desc() {

		return ExplicitWaitFactory.performExplicitWait(brandFeatureCard_2_Desc, WaitStrategy.VISIBLE);
	}
	
	public final WebElement grid3_title() {

		return ExplicitWaitFactory.performExplicitWait(brandFeatureCard_3_Title, WaitStrategy.VISIBLE);
	}
	
	public final WebElement grid3_desc() {

		return ExplicitWaitFactory.performExplicitWait(brandFeatureCard_3_Desc, WaitStrategy.VISIBLE);
	}
	
	public final WebElement assistence() {

		return ExplicitWaitFactory.performExplicitWait(loginSupportText, WaitStrategy.VISIBLE);
	}
	
	public final WebElement footertext() {

		return ExplicitWaitFactory.performExplicitWait(loginFooterText, WaitStrategy.VISIBLE);
	}
	
	
	
	
	

}
