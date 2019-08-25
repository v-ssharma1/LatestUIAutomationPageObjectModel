package com.uiAutomationRetailSite.Expedia.GCO.Helper.Frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class FrameHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);

	/*
	 * Constructor for initializing web driver which will be used to fetch the
	 * elements of the page.
	 */
	public FrameHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Frame helper has been initiated.");
	}

	/*
	 * This method is for switching the frame with the help of it's frame index in
	 * DOM.
	 */
	public void switchToFramebyIndex(int frameIndex) {
		driver.switchTo().frame(frameIndex);
		log.info("Swithc to  " + frameIndex + "frame");
	}

	/*
	 * This method is for switching the frame with the help of it's name in DOM.
	 */
	public void switchToFrameByname(String frameName) {
		driver.switchTo().frame(frameName);
		log.info("Swithc to  " + frameName + "frame");
	}

	/*
	 * This method is for switching the frame with the help of it's xpath in DOM.
	 */
	public void switchToFrameByWebElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		log.info("Swithc to frame: " + frameElement.toString());
	}
}
