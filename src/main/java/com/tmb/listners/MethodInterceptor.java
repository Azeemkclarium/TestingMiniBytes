package com.tmb.listners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.utilities.ExcelUtils;

public final class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> result = new ArrayList<>();

		List<Map<String, String>> list = null;
		try {
			list = ExcelUtils.getRunnerData("RunManager");
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int a = 0; a < methods.size(); a++) {
			for (int b = 0; b < list.size(); b++) {

				if (methods.get(a).getMethod().getMethodName().equals(list.get(b).get("TestMethodName"))) {
					if (list.get(b).get("ExecuteConfirmation").equalsIgnoreCase("yes")) {

						String DESC = list.get(b).get("TestCaseName");
						String TCID = list.get(b).get("TC-ID");

						methods.get(a).getMethod().setDescription(TCID + "_" + DESC);
						result.add(methods.get(a));

					}

				}

			}

		}

		return result;
	}

}
