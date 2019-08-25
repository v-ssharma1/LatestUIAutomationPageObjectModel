package com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.BrowserType;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Resource.ResourceHelper;

public class PropertyReader implements ConfigReader {
	public static String filePath;
	public static File file;
	private static FileInputStream inputFileStream;
	public static Properties prop;

	public PropertyReader() {
		// near future if we are adding any new config file then copy the code from line
		// 19 to 24, past it after line no 24 and chage the path of config file.
		try {
			filePath = ResourceHelper.getResorcePath("/src/main/resources/configfile/config.properties");
			file = new File(filePath);
			inputFileStream = new FileInputStream(file);
			prop = new Properties();
			prop.load(inputFileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// implimenting the configHeader interface methods beased on the loaded property
	// file in the constuctor of this class. Which will be called first.
	@Override
	public int getImplicitWaitValueFromPropertyFile() {
		return Integer.parseInt((prop.getProperty("implicitWait")));
	}

	@Override
	public int getExplicitWaitValueFromPropertyFile() {
		return Integer.parseInt((prop.getProperty("explicitWait")));
	}

	@Override
	public int getPageLoadWaitValueFromPropertyFile() {
		return Integer.parseInt((prop.getProperty("pageLoadTime")));
	}

	@Override
	public BrowserType getBrowserTypeValueFromPropertyFile() {
		return BrowserType.valueOf(prop.getProperty("browserType"));
	}

	public String getUrlFromPropertyFile() {
		//here in System.getProperty("url") url is the tag of pom.xml under name tag of propert tag.
		if (System.getProperty("url") != null) {
			return System.getProperty("url");
		}
		//if application Url is not coming from pom.xml then take it from property file and return.
		return prop.getProperty("applicationUrl");
	}

	public String getUserNameFromPropertyFile() {
		//here in System.getProperty("userName") url is the tag of pom.xml under name tag of propert tag.
		if (System.getProperty("userName") != null) {
			return System.getProperty("userName");
		}
		//if userName is not coming from pom.xml then take it from property file and return.
		return prop.getProperty("userName");
	}

	public String getPasswordFromPropertyFile() {
		//here in System.getProperty("password") url is the tag of pom.xml under name tag of propert tag.
		if (System.getProperty("password") != null) {
			return System.getProperty("password");
		}
		//if password is not coming from pom.xml then take it from property file and return.
		return prop.getProperty("password");
	}

}
