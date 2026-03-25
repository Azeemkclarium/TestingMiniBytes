package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utilities.DecodeUtils;

public final class LoginPage extends PageActions {

	private final By userNameTextBox = By.name("username");
	private final By passwordTextBox = By.name("password");
	private final By loginBtn = By.xpath("//button[@type='submit']");

	private final By timeAtWork = By
			.xpath("//div[@class='orangehrm-dashboard-widget-name']/child::p[text()='Time at Work']");

	private final By invalidCredentialXpath = By
			.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']/child::p[text()='Invalid credentials']");

	private final By profileIcon = By.xpath("//p[@class='oxd-userdropdown-name']");
	private final By logoutBtn = By
			.xpath("//ul[@class='oxd-dropdown-menu']/child::li/a[@href='/web/index.php/auth/logout']");

	public void enterUserName(String username) {

		sendKeys(userNameTextBox, username, WaitStrategy.VISIBLE, "UserName Field");

	}

	public void enterUserPassword(String password) {
		sendKeys(passwordTextBox, DecodeUtils.getDecode(password), WaitStrategy.VISIBLE, "Password Field");
		System.out.println(DecodeUtils.getDecode(password));
	}

	public void clickLoginButton() {

		click(loginBtn, WaitStrategy.CLICKABLE, "Login Button");
	}

	public boolean gettimeAtWork() {

		return isElementDisplayed(timeAtWork, WaitStrategy.VISIBLE);
	}

	public boolean invalidCredential() {

		return isElementDisplayed(invalidCredentialXpath, WaitStrategy.VISIBLE);
	}

	public void profileClick() {

		click(profileIcon, WaitStrategy.CLICKABLE, "Profile Logo");
	}

	public void logOutClick() {
		click(logoutBtn, WaitStrategy.CLICKABLE, "Logout Button");
	}

}
