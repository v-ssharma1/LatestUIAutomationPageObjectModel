package com.uiAutomationRetailSite.Expedia.GCO.Helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class AlertHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);

	/*
	 * Constructor for initializing web driver which will be used to fetch the
	 * elements of the page.
	 */
	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Alert helper has been initiated.");
	}

	/*
	 * Test method will be used to test the alert.
	 */
	public Alert getAlert() {
		log.info("Alert test: " + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}

	/*
	 * Test method will be used to accept the alert.
	 */
	public void acceptAlert() {
		getAlert().accept();
		log.info("Alert is accepted");
	}

	/*
	 * Test method will be used to dismiss the alert.
	 */
	public void dismissAlert() {
		getAlert().dismiss();
		log.info("Alert is dismissed");
	}

	/*
	 * Test method will be used to get the alert text.
	 */
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	/*
	 * Test method will be used to check if the alert is present.
	 */
	public boolean alertPresent() {
		try {
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/*
	 * Test method will be used to accept alert if it is present.
	 */
	public void acceptAlertIfPresent() {
		if (alertPresent()) {
			acceptAlert();
		} else {
			log.info("Alert is not present.");
		}
	}

	/*
	 * Test method will be used to accept prompt.
	 */
	public void acceptPrompt(String text) {
		if (alertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("alert test: " + text);
		}
	}
}
