package com.uiAutomationRetailSite.Expedia.GCO.TestScripts.RagistrationTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Assertion.AssertionHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.LoginPages.LoginPage;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.MyAccountPages.MyAccountPage;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.RagistrationPages.RagistrationPage;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class RagistrationTest extends TestBase {
	private final static Logger log = LoggerHelper.getLogger(RagistrationTest.class);
	RagistrationPage ragister;
	LoginPage login;
	MyAccountPage myAccountPage;

	@Test
	public void tesRagitsration() {

		// go to application
		getApplicationUrl(ObjectReader.reader.getUrlFromPropertyFile());

		// Reach at ragistation page
		login = new LoginPage(driver);

		login.emailRagistartionForAccountCreation();

		// Enter RagistrationData
		ragister = new RagistrationPage(driver);
		ragister.setMrRadioButton();
		ragister.setFirstName("firstName");
		ragister.setLastname("lastname");
		ragister.setPassword("password");
		ragister.setAddress("address");
		ragister.setDay("5");
		ragister.setMonth("June");
		ragister.setYear("2019");
		ragister.setYourAddressFirstName("Saurabh");
		ragister.setYourAddressLastName("Sharma");
		ragister.setYourAddressCompany("CTS");
		ragister.setYourAddressCity("Chicago");
		ragister.setYourAddressState("Illinois");
		ragister.setYourAddressPostCode("60660");
		ragister.setMobilePhone("3129753902");
		ragister.setAddressAlias("My Home");
		ragister.clickRegistration();

		myAccountPage = new MyAccountPage(driver);

		boolean status = myAccountPage.isYourAccountPageMessage();
		AssertionHelper.updateTestStatus(status);

		log.info("Ragistration Test Successfully executed.");
		TestBase.logExtentReport("Ragistration Test Successfully executed.");
	}

}
