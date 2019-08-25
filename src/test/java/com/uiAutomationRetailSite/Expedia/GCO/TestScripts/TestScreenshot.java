package com.uiAutomationRetailSite.Expedia.GCO.TestScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class TestScreenshot extends TestBase {
	private Logger log = LoggerHelper.getLogger(TestScreenshot.class);

	@Test
	public void testScreen() {
		driver.get("https://www.facebook.com/");
		// captureScreenShot("FaceBookScreen", driver);
		new TestBase().getNavigationScreen(driver);
		log.info("TestScreenshot is passed.");
	}

	// @Test
	// public void testScreen1() {
	// AssertionHelper.makeAssertFalse();
	// }
	//
	// // @Test
	// public void testScreen2() {
	// AssertionHelper.makeAssertTrue();
	// }
	//
	// // @Test
	// public void testScreen4() {
	// AssertionHelper.makeAssertFalse();
	// }
}
