package com.uiAutomationRetailSite.Expedia.GCO.Helper.DropDown;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class DropDownHelper {
	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(DropDownHelper.class);

	/*
	 * Constructor for initializing web driver which will be used to fetch the
	 * elements of the page.
	 */
	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Dropdown helper has been initiated.");
	}

	/*
	 * This method will will be use to select something from drop down when the
	 * value is given.
	 */
	public void selectUsingValue(WebElement element, String value) {
		log.info("Selecting " + value + " from dropdown.");
		Select select = new Select(element);
		select.selectByValue(value);
		log.info(value + " has been selected.");
	}

	/*
	 * This method will will be use to deselect something from drop down when the
	 * value is given.
	 */
	public void deselectUsingValue(WebElement element, String value) {
		log.info("deselecting " + value + " from dropdown.");
		Select select = new Select(element);
		select.deselectByValue(value);
		log.info(value + " has been de selected.");
	}

	/*
	 * This method will will be use to select something from drop down when the
	 * Index is given.
	 */
	public void selectUsingIndex(WebElement element, int index) {
		log.info("Selecting the value of index" + index + " from dropdown.");
		Select select = new Select(element);
		select.selectByIndex(index);
		log.info("Value at Index " + index + " has been selected.");
	}

	/*
	 * This method will will be use to select something from drop down when the
	 * Index is given.
	 */
	public void deselectUsingIndex(WebElement element, int index) {
		log.info("deselecting the value of index" + index + " from dropdown.");
		Select select = new Select(element);
		select.deselectByIndex(index);
		log.info("Value at Index " + index + " has been deselected.");
	}

	/*
	 * This method will will be use to select something from drop down when the text
	 * is visible.
	 */
	public void selectUsingVisibleText(WebElement element, String text) {
		log.info("Selecting " + text + " from dropdown.");
		Select select = new Select(element);
		select.selectByVisibleText(text);
		log.info(text + " has been selected.");
	}

	/*
	 * This method will will be use to deselect something from drop down when the
	 * text is visible.
	 */
	public void deselectUsingText(WebElement element, String text) {
		log.info("deselecting " + text + " from dropdown.");
		Select select = new Select(element);
		select.deselectByVisibleText(text);
		log.info(text + " has been deselected.");
	}

	/*
	 * This method will will be used to select all the elements in the drop down.
	 */

	public List<String> selectAllTheElementsOfDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elements = select.getOptions();
		List<String> ValueOfElements = new ArrayList<String>();
		for (WebElement ele : elements) {
			ValueOfElements.add(ele.getText());
		}
		return ValueOfElements;
	}
}
