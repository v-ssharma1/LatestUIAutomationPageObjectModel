package com.uiAutomationRetailSite.Expedia.GCO.Helper.Window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class WindowHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);

	/*
	 * Constructor for initializing web driver which will be used to fetch the
	 * elements of the page.
	 */
	public WindowHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Window helper has been initiated.");
	}

	/*
	 * This method is for switching to the parent window.
	 */
	public void switchToParentWindow() {
		log.info("Switching to parent window.");
		driver.switchTo().defaultContent();
		log.info("Swithced to parent window.");
	}

	/*
	 * This method is for switching to the child window based on window index.
	 */
	public void switchToWindow(int windowIndex) {
		log.info("Switching to child window.");
		Set<String> windowsSet = driver.getWindowHandles();
		int iWindowCounter = 1;
		for (String window : windowsSet) {
			if (iWindowCounter == windowIndex) {
				log.info("Switched to : "+windowIndex+ " window.");
				driver.switchTo().window(window);
			} else {
				iWindowCounter++;
			}
		}
		log.info("Swithced to child window.");
	}

	/*
	 * This method is for closing all the open tabs and switch to main window.
	 */
	public void closeAllTabsAndSwithToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		for(String window : windows) {
			if(!window.equalsIgnoreCase(mainWindow)) {
				driver.close();
			}
		}
		log.info("Swithced to main window.");
		driver.switchTo().window(mainWindow);
	}
	
	/*
	 * This method is for browser back navigation.
	 */
	public void bacwardNavigationOfWindow() {
		log.info("Navigating back.");
		driver.navigate().back();
	}
	
	/*
	 * This method is for browser forward navigation.
	 */
	public void forwardNavigationOfWindow() {
		log.info("Navigating forward.");
		driver.navigate().forward();
	}
}
