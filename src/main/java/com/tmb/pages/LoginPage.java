package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utilities.DecodeUtils;

public final class LoginPage extends PageActions {

	private final By userNameTextBox = By.name("email");
	private final By passwordTextBox = By.name("password");
	private final By loginBtn = By.id("sign-in-button");

	private final By profileIconHomePage = By.xpath("//div[@class='profile-wrapper']/button");
	private final By signOutBTN = By.xpath("//span[text()='Sign Out']");
	
	private final By creadential_invalid_msg = By.xpath("//div[@class='login-form__alert']");
	
	private final By password_length_Error = By.id("id='login-password-error'");

	public void enterUserName(String username) {
		sendKeys(userNameTextBox, username, WaitStrategy.VISIBLE, "User Name Field");
	}

	public void enterUserPassword(String password) {
		sendKeys(passwordTextBox, DecodeUtils.getDecode(password), WaitStrategy.VISIBLE, "Password Field");
	}

	public void clickLoginButton() {

		click(loginBtn, WaitStrategy.CLICKABLE, "Login Button Clicked");
	}
	
	public void clickProfileIcon() {
		click(profileIconHomePage, WaitStrategy.CLICKABLE, "Profile Icon Clicked");
	}

	public void clickSignOutButton() {
		click(signOutBTN, WaitStrategy.CLICKABLE, "Logout Button Clicked");
	}
	
	public boolean profile_icon_verify() {
		return isElementPresent(profileIconHomePage, WaitStrategy.VISIBLE);
	}
	
	public void errorMsg() {
		isElementPresent(creadential_invalid_msg, WaitStrategy.PRESENT);
	}
	
	public void passwordLength_ErrorMsg() {
		isElementPresent(password_length_Error, WaitStrategy.PRESENT);
	}
	
	
	

}
