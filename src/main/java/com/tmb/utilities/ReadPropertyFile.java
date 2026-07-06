package com.tmb.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.tmb.constants.FrameworkConstant;
import com.tmb.enums.PropertiesEnums;

public final class ReadPropertyFile {

	private ReadPropertyFile() {
	};

	private static Properties property = new Properties();
	static {

		try {
			FileInputStream configFile = new FileInputStream(FrameworkConstant.getConfigPropertyFilePath());
			property.load(configFile);
			configFile.close();
			FileInputStream messageFile = new FileInputStream(FrameworkConstant.getMessagePropertyFilePath());
			property.load(messageFile);
			messageFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Property file not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to load property file");
		}

	}

	public static String getvalue(PropertiesEnums key) {
		String keyString = key.name().toLowerCase().toString();

		if (keyString == null || property.getProperty(keyString) == null) {
			try {
				throw new Exception("Property key / value is not found : " + keyString);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return property.getProperty(keyString);
	}
	
	public static String getvalue(String key) {
		String keyString = key.toString();

		if (keyString == null || property.getProperty(keyString) == null) {
			try {
				throw new Exception("Property key / value is not found : " + keyString);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return property.getProperty(keyString);
	}

}
