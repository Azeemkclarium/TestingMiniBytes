package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.dataprovider.DataProviderUtil;
import com.tmb.enums.TestCategory;
import com.tmb.pages.DomainFunction;

public final class DeleteDomain {

	private DeleteDomain() {
	};

	private static DomainFunction delete = new DomainFunction();

	@FrameworkAnnotations(authorName = { "Azeem" }, testCategory = { TestCategory.REGRESSION_TEST })
	@Test(dataProvider = "testdata", dataProviderClass = DataProviderUtil.class)
	private static void ValidateDeleteDomain(Map<String, String> map) {

		delete.DeactivateDomain(map.get("Domain Name"));
		delete.DeleteDomain(map.get("Domain Name"));

	}

}
