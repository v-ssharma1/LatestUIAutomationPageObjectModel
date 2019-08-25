package com.uiAutomationRetailSite.Expedia.GCO.TestScripts.LoginTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Assertion.AssertionHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.LoginPages.LoginPage;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class LoginTest extends TestBase {
	private final static Logger log = LoggerHelper.getLogger(LoginTest.class);

	@Test(description = "Login Test with valid credentails.")
	public static void validateLoginFunctinality() {
		getApplicationUrl(ObjectReader.reader.getUrlFromPropertyFile());
		LoginPage logIn = new LoginPage(driver);
		logIn.loginToApplication(ObjectReader.reader.getUserNameFromPropertyFile(),
				ObjectReader.reader.getPasswordFromPropertyFile());
		AssertionHelper.updateTestStatus(logIn.verifySuccessLoginMsg());
		log.info("Login Test Successfully executed.");
		TestBase.logExtentReport("Login Test Successfully executed.");
	}
}
