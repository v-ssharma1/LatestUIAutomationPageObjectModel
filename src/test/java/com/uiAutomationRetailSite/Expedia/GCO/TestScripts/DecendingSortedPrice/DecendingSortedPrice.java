package com.uiAutomationRetailSite.Expedia.GCO.TestScripts.DecendingSortedPrice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Assertion.AssertionHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
=======
=======
>>>>>>> df56135e3e3980d496dbe1e5490751ce426d26a7
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
<<<<<<< HEAD
>>>>>>> df56135e3e3980d496dbe1e5490751ce426d26a7
=======
>>>>>>> df56135e3e3980d496dbe1e5490751ce426d26a7
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.NavigationMenu.NavigationMenu;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.ProductCategoryPages.ProductCategoryPage;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class DecendingSortedPrice extends TestBase {
<<<<<<< HEAD
<<<<<<< HEAD
=======
	private final static Logger log = LoggerHelper.getLogger(DecendingSortedPrice.class);
>>>>>>> df56135e3e3980d496dbe1e5490751ce426d26a7
=======
	private final static Logger log = LoggerHelper.getLogger(DecendingSortedPrice.class);
>>>>>>> df56135e3e3980d496dbe1e5490751ce426d26a7

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
<<<<<<< HEAD
<<<<<<< HEAD
		// ArrayList<Integer> array = new ArrayList<Integer>();
		Iterator<WebElement> itr = allPrice.iterator();

		ArrayList<Integer> data = productCategoryPage.getPriceMassagedData(itr);
		boolean status = productCategoryPage.verifyArrayHasAscendingData(data);
		AssertionHelper.updateTestStatus(status);

=======
=======
>>>>>>> df56135e3e3980d496dbe1e5490751ce426d26a7
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
<<<<<<< HEAD
>>>>>>> df56135e3e3980d496dbe1e5490751ce426d26a7
=======
>>>>>>> df56135e3e3980d496dbe1e5490751ce426d26a7
	}
}
