package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public final class HomePage extends PageActions {

	private final By profileIcon = By.xpath("//p[@class='oxd-userdropdown-name']");
	private final By logoutBtn = By
			.xpath("//ul[@class='oxd-dropdown-menu']/child::li/a[@href='/web/index.php/auth/logout']");

	public void profileClick() {

		click(profileIcon, WaitStrategy.CLICKABLE, "Profile Logo");
	}

	public void logOutClick() {
		click(logoutBtn, WaitStrategy.CLICKABLE, "Logout Button");
	}

}
