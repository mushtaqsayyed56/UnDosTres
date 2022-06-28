package com.automation.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ConfigReader {
	
	/* This code is to read config files from resources package
	 * 
	 * 
	 */
	
	public static String ReadProperty(String properyFileName, String propertyValue) {

		String configPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + properyFileName + ".properties";

		FileInputStream fis;
		Properties prop;
		String property = null;

		try {

			fis = new FileInputStream(new File(configPath));

			prop = new Properties();

			prop.load(fis);

			property = prop.getProperty(propertyValue);

		} catch (IOException e) {
			// TODO: handle exception
		}

		return property;
	}
	
	
}
