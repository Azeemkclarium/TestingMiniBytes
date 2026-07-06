package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.dataprovider.DataProviderUtil;
import com.tmb.enums.TestCategory;
import com.tmb.pages.DomainFunction;

public final class DomainCreationTest extends BaseTest {

	private DomainCreationTest() {
	};

	private static DomainFunction domain = new DomainFunction();

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.SMOKE_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void CreateDomain(Map<String, String> map) {
		domain.SidebarDomainButton();
		domain.clickAddButton();
		domain.EnterDomainName(map.get("Domain Name"));
		domain.EnterDomainDesc(map.get("Domain Description"));
		domain.clickSave();
		domain.DomainCreationValidation(map.get("Domain Name"));
	}

}
