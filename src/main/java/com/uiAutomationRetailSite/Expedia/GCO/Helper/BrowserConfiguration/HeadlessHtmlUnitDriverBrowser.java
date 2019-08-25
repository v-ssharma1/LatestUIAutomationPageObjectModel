package com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessHtmlUnitDriverBrowser {
	public static WebDriver getHeadlessHtmlUnitDriverBrowser(WebDriver driver) {
		return new HtmlUnitDriver();
	}
}
