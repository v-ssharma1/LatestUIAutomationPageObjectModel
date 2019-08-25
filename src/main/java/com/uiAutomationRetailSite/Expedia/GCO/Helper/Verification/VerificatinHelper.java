package com.uiAutomationRetailSite.Expedia.GCO.Helper.Verification;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class VerificatinHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificatinHelper.class);

	/*
	 * Constructor for initializing web driver which will be used to fetch the
	 * elements of the page.
	 */
	public VerificatinHelper(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will check if the element is displayed.
	 */
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is displayed.." + element.getText());
			return true;
		} catch (Exception e) {
			log.info("Element is not displayed.." + e.getClass());
			return false;
		}
	}

	/*
	 * This method will check if the element is not displayed.
	 */
	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is present.." + element.getText());
			return false;
		} catch (Exception e) {
			log.info("Element is not present..");
			return true;
		}
	}

	/*
	 * This method will validate the text from element.
	 */
	public String readTextFromElement(WebElement element) {
		if (null == element) {
			log.info("Web element is null");
			return null;
		}
		if (isDisplayed(element)) {
			log.info("Web element text is.." + element.getText());
			return element.getText();
		} else {
			return null;
		}
	}

	/*
	 * This method will get the title of the page.
	 */
	public String getTittle() {
		log.info("Validating the title of the page. and the title is: " + driver.getTitle());
		return driver.getTitle();
	}
}
