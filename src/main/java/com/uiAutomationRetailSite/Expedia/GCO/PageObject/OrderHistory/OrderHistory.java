package com.uiAutomationRetailSite.Expedia.GCO.PageObject.OrderHistory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Wait.WaitHelper;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.MyAccountPages.MyAccountPage;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class OrderHistory {
	WebDriver driver;
	private Logger log = LoggerHelper.getLogger(OrderHistory.class);
	WaitHelper waitHelper;

	public OrderHistory(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(msgAfterLogin,
		// ObjectReader.reader.getExplicitWaitValueFromPropertyFile());
		new TestBase().getNavigationScreen(driver);
	}
}
