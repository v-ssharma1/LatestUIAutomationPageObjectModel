package com.uiAutomationRetailSite.Expedia.GCO.Helper.JavaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class JavaScriptHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

	/*
	 * Constructor for initializing web driver which will be used to fetch the
	 * elements of the page.
	 */
	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Java script helper has been initiated.");
	}

	/*
	 * This method will execute the java script of your project.
	 */
	public Object excecuteJavaScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	/*
	 * This method will execute the java script with multiple arguments of your
	 * project.
	 */
	public Object excecuteJavaScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	/*
	 * This method will be used to scroll to the element.
	 */
	public void scrollToElement(WebElement element) {
		log.info("Scroll to web element.");
		excecuteJavaScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
				element.getLocation().y);
	}

	/*
	 * This method will be used to scroll to the element and click it.
	 */
	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("element " + element.toString() + " is clicked.");
	}

	/*
	 * This method will be used to scroll Into View.
	 */
	public void scrollIntoView(WebElement element) {
		excecuteJavaScript("arguments[0].scrollIntoView()", element);
		log.info("element " + element.toString() + " is clicked.");
	}

	/*
	 * This method will be used to scroll Into View and click it.
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("element " + element.toString() + " is clicked.");
	}

	/*
	 * This method will be used to scroll the window down vertically.
	 */
	public void scrollDownVertically() {
		log.info("Scrolling down vertically down.");
		excecuteJavaScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/*
	 * This method will be used to scroll the window up vertically.
	 */
	public void scrollUpVertically() {
		log.info("Scrolling down vertically up.");
		excecuteJavaScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	/*
	 * This method will be used to scroll the window down by pixel. (e.g pixel=1500)
	 */
	public void scrollDownByPixel(int pixel) {
		log.info("Scrolling down the window by " + pixel + " pixels");
		excecuteJavaScript("window.scrollBY(0,"+pixel+")");
	}

	/*
	 * This method will be used to scroll the window up by pixel. (e.g pixel=1500)
	 */
	public void scrollUpByPixel(int pixel) {
		log.info("Scrolling up the window by " + pixel + " pixels");
		excecuteJavaScript("window.scrollBy(0,-" + pixel + ")");
	}

	/*
	 * This method will be used to zoom the screen in by x%
	 */
	public void zoomINTheScrin(int percent) {
		log.info("Zooming in the window by " + percent + " percent");
		excecuteJavaScript("document.body.style.zoom='" + percent + "'");
	}

	/*
	 * This method will be used to zoom the screen out by x%
	 */
	public void zoomOutTheScrin(int percent) {
		log.info("Zooming out the window by " + percent + " percent");
		excecuteJavaScript("document.body.style.zoom='-" + percent + "'");
	}

	/*
	 * This method will be used to click the element at very top.
	 */
	public void clickElement(WebElement element) {
		log.info("Clicking at " + element);
		excecuteJavaScript("arguments[0].click();", element);
	}

}
