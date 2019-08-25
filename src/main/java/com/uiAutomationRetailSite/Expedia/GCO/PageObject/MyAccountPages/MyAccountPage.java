package com.uiAutomationRetailSite.Expedia.GCO.PageObject.MyAccountPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Verification.VerificatinHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Wait.WaitHelper;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.CreditSlips.CreditSlips;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.OrderHistory.OrderHistory;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class MyAccountPage {

	WebDriver driver;
	private Logger log = LoggerHelper.getLogger(MyAccountPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
	public static WebElement yourAccountPageMessage;

	@FindBy(xpath = "//span[contains(text(),'Order history and details')]/parent::a")
	WebElement orderHistoryAndDetails;

	@FindBy(xpath = "//span[contains(text(),'My credit slips')]/parent::a")
	WebElement myCreditSlips;

	@FindBy(xpath = "//span[contains(text(),'My addresses')]/parent::a")
	WebElement myAddresses;

	@FindBy(xpath = "//span[contains(text(),'My personal information')]/parent::a")
	WebElement myPersonalInfo;

	@FindBy(xpath = "//span[contains(text(),'My wishlists')]/parent::a")
	WebElement myWishlists;

	@FindBy(xpath = "//span[contains(text(),' Home')]/parent::a")
	WebElement home;

	@FindBy(xpath = "//div[@id='center_column']/p")
	WebElement msgAfterLogin;

	@FindBy(xpath = "//div[@id='center_column']/p")
	WebElement successMsgAfterClickingCategoryButton;

	@FindBy(xpath = "//p[@class='info-title']")
	WebElement successMsgAfterClickingMyCreditSlipsButton;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(orderHistoryAndDetails, ObjectReader.reader.getExplicitWaitValueFromPropertyFile());
		TestBase.logExtentReport("Object of MyAccountPage has been created successfully.");
		new TestBase().getNavigationScreen(driver);
	}

	public OrderHistory clickOnOrderHistoryButton() {
		log.info("Clicking on Order History and Details Button.");
		TestBase.logExtentReport("Clicking on Order History and Details Button.");
		orderHistoryAndDetails.click();
		log.info("Clicked on Order History and Details Button.");
		TestBase.logExtentReport("Clicked on Order History and Details Button.");
		return new OrderHistory(driver);
	}

	public boolean verifySuccessNaviGationToCategoryPage() {
		return new VerificatinHelper(driver).isDisplayed(successMsgAfterClickingCategoryButton);
	}

	public void orderHistoryAndDetailButtonNavigation() {
		clickOnOrderHistoryButton();
		verifySuccessNaviGationToCategoryPage();
	}

	public CreditSlips clickOnMyCreditSlipsButton() {
		log.info("Clicking on My Credit Slips Button.");
		TestBase.logExtentReport("Clicking on My Credit Slips Button.");
		myCreditSlips.click();
		log.info("Clicked on Order History and Details Button.");
		TestBase.logExtentReport("Clicked on My Credit Slips Button.");
		return new CreditSlips(driver);
	}

	public boolean verifySuccessNaviGationToCreditSlipPage() {
		return new VerificatinHelper(driver).isDisplayed(successMsgAfterClickingMyCreditSlipsButton);
	}

	public void credirSlipsButtonNavigation() {
		clickOnMyCreditSlipsButton();
		verifySuccessNaviGationToCreditSlipPage();
	}

	public boolean isYourAccountPageMessage() {
		return new VerificatinHelper(driver).isDisplayed(yourAccountPageMessage);
	}
}
