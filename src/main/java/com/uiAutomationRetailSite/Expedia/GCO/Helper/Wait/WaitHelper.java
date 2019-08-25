package com.uiAutomationRetailSite.Expedia.GCO.Helper.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class WaitHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	/*
	 * Constructor for initializing web driver which will be used to fetch the
	 * elements of the page.
	 */
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Wait helper object is created..");
	}

	/*
	 * This method is for making sure that the page is loaded.
	 */
	public void pageLoadTime(long timeout, TimeUnit unit) {
		log.info("Waiting for page to load for: " + unit + " seconds");
		log.info("Implicit wait has been set to: " + timeout);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page is loaded.");
	}

	/*
	 * This method is for implement the implicit wait.
	 */
	public void setImplicitwait(long timeout, TimeUnit unit) {
		log.info("Implicit wait for element to be loaded has been set to: " + timeout + " seconds");
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	/*
	 * This method is for getting the WebDriverWait object.
	 */
	private WebDriverWait getWait(int TimeOutInSeconds, int pollingEveryInMilisec) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMilisec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	/*
	 * This method is for making sure that the element is visible now.
	 */
	public void WaitForElementVisible(WebElement element, int TimeOutInSeconds, int pollingEveryInMilisec) {
		log.info("Waiting for : " + element + " for " + TimeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(TimeOutInSeconds, pollingEveryInMilisec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now.");
	}

	/*
	 * This method is for making sure that the element is invisible now.
	 */
	public boolean WaitForElementNotPresent(WebElement element, int TimeOutInSeconds) {
		log.info("Waiting for : " + element + " for " + TimeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(TimeOutInSeconds, TimeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is not visible now.");
		return status;
	}

	/*
	 * This method is for making sure that the element is clickable now.
	 */
	public void WaitForElementClickable(WebElement element, int TimeOutInSeconds) {
		log.info("Waiting for : " + element + " for " + TimeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(TimeOutInSeconds, TimeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now.");
	}

	/*
	 * This method is for making sure that the frame is visible and switched now.
	 */
	public void WaitForframeToBeAvailableAndSwitchToIt(WebElement element, int TimeOutInSeconds) {
		log.info("Waiting for : " + element + " for " + TimeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(TimeOutInSeconds, TimeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is visible and switched now.");
	}

	/*
	 * This method is for getting the fluent wait object.
	 */
	private Wait<WebDriver> getFluentWait(int TimeOutInSeconds, int pollingEveryInMilisec) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(TimeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMilisec)).ignoring(NoSuchElementException.class);
		return fWait;
	}

	/*
	 * This method is for making sure that the element is visible now by checking it
	 * at certain polling frequency.
	 */
	public WebElement WaitForElement(WebElement element, int TimeOutInSeconds, int pollingEveryInMilisec) {
		log.info("Waiting for : " + element + " for " + TimeOutInSeconds + " seconds");
		Wait<WebDriver> fwait = getFluentWait(TimeOutInSeconds, pollingEveryInMilisec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now.");
		return element;
	}

	/*
	 * Very Imp Note: The following are the Expected Conditions that can be used in
	 * Explicit Wait : alertIsPresent() elementSelectionStateToBe(),
	 * elementToBeClickable(), elementToBeSelected(),
	 * frameToBeAvaliableAndSwitchToIt(), invisibilityOfTheElementLocated()
	 * invisibilityOfElementWithText() presenceOfAllElementsLocatedBy()
	 * presenceOfElementLocated() textToBePresentInElement()
	 * textToBePresentInElementLocated() textToBePresentInElementValue() titleIs()
	 * titleContains() visibilityOf() visibilityOfAllElements()
	 * visibilityOfAllElementsLocatedBy() visibilityOfElementLocated()
	 */

	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
}
