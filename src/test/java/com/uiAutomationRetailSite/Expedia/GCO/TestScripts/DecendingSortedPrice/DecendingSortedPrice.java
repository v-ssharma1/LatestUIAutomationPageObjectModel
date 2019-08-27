package com.uiAutomationRetailSite.Expedia.GCO.TestScripts.DecendingSortedPrice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Assertion.AssertionHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;

import com.uiAutomationRetailSite.Expedia.GCO.PageObject.NavigationMenu.NavigationMenu;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.ProductCategoryPages.ProductCategoryPage;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class DecendingSortedPrice extends TestBase {

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
		Iterator<WebElement> itr = allPrice.iterator();
		ArrayList<Integer> data = productCategoryPage.getPriceMassagedData(itr);
		boolean status = productCategoryPage.verifyArrayHasAscendingData(data);
		AssertionHelper.updateTestStatus(status);

	}
}
