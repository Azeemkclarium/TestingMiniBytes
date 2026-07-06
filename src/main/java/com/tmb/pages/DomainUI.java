package com.tmb.pages;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.By;

public final class DomainUI {

	private DomainUI() {
	};
	
	private final By sidebar_domain_btnBy = By.xpath("//span[text()='Domains']");
	
	private final By h1_header_text = By.xpath("//div[@class='page-header-content']/h1");
	
	private final By h1_header_desc =  By.xpath("//div[@class='page-header-content']/p");
	
	private final By search_record_type = By.xpath("(//div[@class='grid-toolbar']//input[@class='grid-search-input'])[2]");
	
	private final By all_status_btn = By.xpath("(//span[@class='fb-select-label '])[2]");
	
	private final By allstatus_options = By.xpath("//div[@class='fb-dropdown-options']/child::div/span");
	
	private final By allstatus_filter_select = By.xpath("(//span[contains(@class,'fb-select-label')])[2]");
	
	private final By allstatus_clear_icon = By.xpath("(//*[name()='svg' and @class='lucide lucide-circle-x fb-clear-icon'])[2]");
	
	private final By allstatus_up_icon = By.xpath("(//*[name()='svg' and @class='lucide lucide-chevron-down fb-chevron fb-chevron--open'])");
	
	private final By allstatus_down_icon = By.xpath("(//*[name()='svg' and @class='lucide lucide-chevron-down fb-chevron'])[2]");
	
	private final By name_sort_up_arrow =  By.xpath("//*[name()='svg' and @class='lucide lucide-arrow-up grid-sort-arrow']");
	
	private final By name_sort_down_arrow =  By.xpath("//*[name()='svg' and @class='lucide lucide-arrow-down grid-sort-arrow']");
	
	private final By name_tablecell_datas = By.xpath("(//div[@class='grid-content'])[2]/descendant::p");
	
	private final By edit_domain = By.xpath("//div[@class='grid-content']/descendant::p[text()='Shipping']/following::*[local-name()='svg' and @class='lucide lucide-pencil'][1]");
	
	private final By delete_domain = By.xpath("//div[@class='grid-content']/descendant::p[text()='Shipping']/following::*[local-name()='svg' and @class='lucide lucide-trash'][1]");
	
	private final By deactivate_domain = By.xpath("//div[@class='grid-content']/descendant::p[text()='Z Invoice']/following::*[local-name()='svg' and @class='lucide lucide-power-off'][1]");
	
	private final By reactivate_domain = By.xpath("//div[@class='grid-content']/descendant::p[text()='Shipping']/following::*[local-name()='svg' and @class='lucide lucide-refresh-ccw'][1]");
	
	private final By domain_status = By.xpath("(//div[@class='grid-content'])[2]/descendant::span[text()='Active' or text()='Inactive']");
	
	private final By add_domain = By.xpath("//button[text()='Add Domain']");
	
	private final By add_domain_title = By.xpath("//h3[@class='dialog-header-title']");
	
	private final By domain_name_field_titel = By.xpath("(//label[@class='dynamic-form-label'])[1]");
	
	private final By domain_desc_title = By.xpath("(//label[@class='dynamic-form-label'])[2]");
	
	private final By domain_name_input_field = By.xpath("//input[@placeholder='e.g. Shipping Operations']");
	
	private final By domain_desc_field = By.xpath("//textarea[@placeholder]"); 
	
	private final By domain_creation_cancel = By.xpath("//div[@class='footer-actions']/button[@class='btn-cancel ']");
	
	private final By domain_creation_save = By.xpath("//div[@class='footer-actions']/button[@class='btn-save ']");
	
	private final By domain_creationpage_close_X = By.xpath("//*[name()='svg' and @class='lucide lucide-x']");
	

}
