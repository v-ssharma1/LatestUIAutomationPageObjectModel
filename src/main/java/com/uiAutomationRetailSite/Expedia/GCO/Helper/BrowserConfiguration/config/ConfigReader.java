package com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.BrowserType;

public interface ConfigReader {
	public int getImplicitWaitValueFromPropertyFile();

	public int getExplicitWaitValueFromPropertyFile();

	public int getPageLoadWaitValueFromPropertyFile();

	public BrowserType getBrowserTypeValueFromPropertyFile();

	public String getUrlFromPropertyFile();

	public String getUserNameFromPropertyFile();

	public String getPasswordFromPropertyFile();
}
