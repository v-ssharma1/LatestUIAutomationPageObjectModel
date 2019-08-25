package com.uiAutomationRetailSite.Expedia.GCO.PageObject.CreditSlips;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Wait.WaitHelper;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class CreditSlips {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(CreditSlips.class);
	WaitHelper waitHelper;

	public CreditSlips(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(msgAfterLogin,
		// ObjectReader.reader.getExplicitWaitValueFromPropertyFile());
		new TestBase().getNavigationScreen(driver);
	}
}
