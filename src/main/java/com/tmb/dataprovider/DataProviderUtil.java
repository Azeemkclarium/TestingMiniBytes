package com.tmb.dataprovider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tmb.utilities.ExcelUtils;

public class DataProviderUtil {

	public static List<Map<String, String>> list = new ArrayList<Map<String, String>>();

	@DataProvider(name = "testdata")
	public static Object[] getData(Method testMethod) throws IOException {

		String methodName = testMethod.getName();

		if (list.isEmpty()) {
			list = ExcelUtils.getRunnerData("RunManager");
		}

		List<Map<String, String>> smallList = new ArrayList<Map<String, String>>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).get("TestMethodName").equals(methodName)
					&& list.get(i).get("ExecuteConfirmation").equals("yes")) {
				smallList.add(list.get(i));
			}

		}

		return smallList.toArray();

	}

}
