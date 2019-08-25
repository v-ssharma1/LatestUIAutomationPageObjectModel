package com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Resource.ResourceHelper;

public class ChromeBrowser {
	public ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return option;
	}

	public WebDriver getChromeDriver(ChromeOptions cap) {
		if (System.getProperty("os.name").contains("Mac OS X")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResorcePath("/src/main/resources/drivers/chromedriver"));
			return new ChromeDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResorcePath("/src/main/resources/drivers/chromedriver"));
			return new ChromeDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResorcePath("/src/main/resources/drivers/chromedriver"));
			return new ChromeDriver(cap);
		}

		return null;
	}
}
