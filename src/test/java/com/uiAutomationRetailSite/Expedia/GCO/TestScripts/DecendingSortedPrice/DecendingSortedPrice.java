package com.uiAutomationRetailSite.Expedia.GCO.TestScripts.DecendingSortedPrice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.NavigationMenu.NavigationMenu;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.ProductCategoryPages.ProductCategoryPage;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class DecendingSortedPrice extends TestBase {
	private final static Logger log = LoggerHelper.getLogger(DecendingSortedPrice.class);

	@Test(description = "Check the product of lowets price.")
	public static void validateLowestPrice() throws InterruptedException {
		getApplicationUrl(ObjectReader.reader.getUrlFromPropertyFile());

		NavigationMenu navigationMenu = new NavigationMenu(driver);
		ProductCategoryPage productCategoryPage = navigationMenu.clickOnMenu(navigationMenu.womenMenu);
		// select price filter
		productCategoryPage.selectSortByFilter("Price: Lowest first");
		// wait for sometime for price to be sorted
		Thread.sleep(8000);
		// get price of all products
		List<WebElement> allPrice = productCategoryPage.getAllProductsPrice();
		ArrayList<Integer> array = new ArrayList<Integer>();
		Iterator<WebElement> itr = allPrice.iterator();
		while (itr.hasNext()) {
			String p = itr.next().getText();
			// remove $ sign from price string before converting it to doubld.
			if (p.contains("$")) {
				String actaulData = p.substring(1);
				log.info(actaulData);
				double price = Double.parseDouble(actaulData);
				int productPrice = (int) (price);
				array.add(productPrice);
			}
		}
		log.info(array);
		for (int i = 0; i < array.size() - 1; i++) {
			if (array.get(i) <= array.get(i + 1)) {
				log.info("obj.get(i):-" + array.get(i));
				log.info("obj.get(i+1):-" + array.get(i + 1));
			} else {
				Assert.assertTrue(false, "Price filter is working fine.");
			}
		}
	}
}
