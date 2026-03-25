package com.tmb.listners;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.tmb.utilities.ExcelUtils;

public final class AnnotationTransform implements IAnnotationTransformer {

	private static List<Map<String, String>> list;

	static {
		try {
			list = ExcelUtils.getRunnerData("RunManager");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		for (Map<String, String> data : list) {

			if (testMethod.getName().equalsIgnoreCase(data.get("TestMethodName"))) {

				// Set Priority
				String priority = data.get("Priority");
				String invocationCount = data.get("InvocationCount");
				if (priority != null && !priority.isEmpty()) {
					annotation.setPriority(Integer.parseInt(priority));
					annotation.setInvocationCount(Integer.parseInt(invocationCount));
				}
				
				annotation.setRetryAnalyzer(RetryFailedTest.class);
				break;
			}
		}
	}
}
