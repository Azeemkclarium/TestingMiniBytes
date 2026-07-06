package com.tmb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.drivers.DriverManager;
import com.tmb.enums.ColorsEnum;
import com.tmb.enums.MarkSideEnum;
import com.tmb.enums.WaitStrategy;
import com.tmb.extents.ExtentLogger;
import com.tmb.factories.ExplicitWaitFactory;

public final class DomainFunction extends PageActions {

	private final By sidebar_domain_btn = By.xpath("//span[text()='Domains']");

	private final By edit_domain = By.xpath(
			"//div[@class='grid-content']/descendant::p[text()='Shipping']/following::*[local-name()='svg' and @class='lucide lucide-pencil'][1]");

	private final By delete_domain(String domainName) {
		String dynamicXpath = "//div[@class='grid-content']/descendant::p[text()='" + domainName
				+ "']/following::*[local-name()='svg' and @class='lucide lucide-trash'][1]";
		return By.xpath(dynamicXpath);
	}

	private final By confirm_Delete = By
			.xpath("//div[@class='confirmation-overlay']/descendant::button[contains(text(),'Delete')]");

	private final By confirm_Delete_Cancel = By
			.xpath("//div[@class='confirmation-overlay']/descendant::button[contains(text(),'Delete')]");

	private final By deactivate_domain(String deactivatedomainName) {

		String dynamicXpathString = "//div[@class='grid-content']/descendant::p[text()='" + deactivatedomainName
				+ "']/following::button[2]";
		System.out.println(dynamicXpathString);
		return By.xpath(dynamicXpathString);
	}

	private final By confirm_Deactivate = By
			.xpath("//div[@class='confirmation-overlay']/descendant::button[contains(text(),'Deactivate')]");

	private final By confirm_Deactivate_Cancel = By
			.xpath("//div[@class='confirmation-overlay']/descendant::button[contains(text(),'Cancel')]");

	private final By reactivate_domain = By.xpath(
			"//div[@class='grid-content']/descendant::p[text()='Shipping']/following::*[local-name()='svg' and @class='lucide lucide-refresh-ccw'][1]");

	private final By add_domain = By.xpath("//button[text()='Add Domain']");

	private final By domain_name_input_field = By.xpath("//input[@placeholder='e.g. Shipping Operations']");

	private final By domain_desc_field = By.xpath("//textarea[@placeholder]");

	private final By domain_creation_cancel = By.xpath("//div[@class='footer-actions']/button[@class='btn-cancel ']");

	private final By domain_creation_save = By.xpath("//div[@class='footer-actions']/button[@class='btn-save ']");

	private final By domain_creationpage_close_X = By.xpath("//*[name()='svg' and @class='lucide lucide-x']");

	private final By name_tablecell_datas = By.xpath("(//div[@class='grid-content'])[2]/descendant::p");

	public void SidebarDomainButton() {
		WebElement element = ExplicitWaitFactory.performExplicitWait(sidebar_domain_btn, WaitStrategy.NONE);
		mouseClick(element);
		//click(sidebar_domain_btnBy, WaitStrategy.PRESENT, "Side Bar Domain Clicked.");

	}

	public void clickAddButton() {
		click(add_domain, WaitStrategy.CLICKABLE, "Add Domain Clicked.");

	}

	public void EnterDomainName(String domainName) {
		sendKeys(domain_name_input_field, domainName, WaitStrategy.PRESENT, "Domain Name");

	}

	public void EnterDomainDesc(String domainDesc) {
		sendKeys(domain_desc_field, domainDesc, WaitStrategy.PRESENT, "Domain Description");

	}

	public void clickSave() {
		click(domain_creation_save, WaitStrategy.CLICKABLE, "Save Button Clicked");
	}

	public void clickCancel() {
		click(domain_creation_cancel, WaitStrategy.CLICKABLE, "Cancel Button Clicked");
	}

	public void clickClose() {
		click(domain_creationpage_close_X, WaitStrategy.CLICKABLE, "Close Button Clicked");
	}

	public void clickEdit() {
		click(edit_domain, WaitStrategy.CLICKABLE, "Edit Button Clicked");
	}

	public void clickDelete(String domainName) {
		click(delete_domain(domainName), WaitStrategy.CLICKABLE, "Delete Button Clicked");
	}

	public void clickDeactivate(String domainName) {
		click(deactivate_domain(domainName), WaitStrategy.CLICKABLE, "Deactivate Button Clicked");
	}

	public void clickReactivate() {
		click(reactivate_domain, WaitStrategy.PRESENT, "Reactivate Button Clicked");
	}

	public void DomainCreationValidation(String elementName) {
		List<WebElement> elements = DriverManager.getDriver().findElements(name_tablecell_datas);

		boolean elementFound = false;

		for (WebElement webElement : elements) {
			if (webElement.getText().equals(elementName)) {
				elementFound = true;
				ExtentLogger.pass(elementName + " - Domain Created Successfully!", elementFound, webElement,
						ColorsEnum.GREEN, "Domain Created Successfully", MarkSideEnum.BOTTOM);
				break;
			}

		}
		if (!elementFound) {

			ExtentLogger.fail(elementName + " - Not Created!");
		}
	}

	public void DeactivateDomain(String domainName) {
		WebElement element = DriverManager.getDriver().findElement(deactivate_domain(domainName));
		mouseClick(element);
		click(confirm_Deactivate, WaitStrategy.PRESENT, "Confirm De-Activate");
	}

	public void DeleteDomain(String domainName) {

		WebElement element = DriverManager.getDriver().findElement(delete_domain(domainName));
		mouseClick(element);
		click(confirm_Delete, WaitStrategy.PRESENT, "Confirm Delete");

	}

}
