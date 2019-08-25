package com.uiAutomationRetailSite.Expedia.GCO.PageObject.LoginPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.JavaScript.JavaScriptHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Verification.VerificatinHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Wait.WaitHelper;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.NavigationMenu.NavigationMenu;
import com.uiAutomationRetailSite.Expedia.GCO.PageObject.RagistrationPages.RagistrationPage;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class LoginPage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;
	//*[@id='header']/div[2]/div/div/nav/div[1]/a"
	@FindBy(xpath = "//input[@id='email']")
	WebElement signInEmailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forGotYourPassWord;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement submitLogin;

	// Welcome to your account. Here you can manage all of your personal information
	// and orders.
	// This will come after login
	@FindBy(xpath = "//div[@id='center_column']/p")
	WebElement successMsgAfterLogin;

	@FindBy(xpath = "//*[@id='email_create']")
	WebElement registrationEmailAddress;

	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement createAnAccount;

	@FindBy(xpath = "//*[@id='center_column']/h1")
	WebElement authenticate;

	@FindBy(xpath = "//*[@id='create-account_form']/div/p")
	WebElement createAnAccountMessage;

	@FindBy(xpath = "//*[@id='create-account_form']/div/p")
	WebElement createAccountsuccessVarification;
	//// div[@id='noSlide']/h1
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout;

	// contrutor of any page will be used to initiate all the page objects by
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// 'this' is refering to current class object. hence below line will initiate
		// PageFactory.initElements method.
		// all the web element of this page.
		PageFactory.initElements(driver, this);
		// create web helper class which take driver as input.
		waitHelper = new WaitHelper(driver);
		// timeOutInSeconds for waitForElement method of waitHelperclass will be read
		// from property file as ExplicitWaitValue.
		waitHelper.waitForElement(SignIn, ObjectReader.reader.getExplicitWaitValueFromPropertyFile());
		TestBase.logExtentReport("Object of  LoginPage has been created successfully.");
		// this line is for navigation and capture screen shots for reports..
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("LoginPage object is created.");
	}

	// This Method is for clicking the signing link.
	public void clickOnSignInLink() {
		log.info("clicked on sign in link...");
		// logExtentReport("clicked on sign in link...");
		SignIn.click();
	}

	// This Method is for entring email address in the field.
	public void enterEmailAddress(String emailAddress) {
		log.info("entering email address...." + emailAddress);
		// logExtentReport("entering email address...."+emailAddress);
		this.signInEmailAddress.sendKeys(emailAddress);
	}

	// This Method is for entring password address in the field.
	public void enterPassword(String password) {
		log.info("entering password...." + password);
		TestBase.logExtentReport("entering password...." + password);
		this.password.sendKeys(password);
	}

	// This Method is for clicking on submit button and navigate to Navigation Menu.
	public NavigationMenu clickOnSubmitButton() {
		log.info("clicking on submit button...");
		TestBase.logExtentReport("clicking on submit button...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		// new JavaScriptHelper(driver).scrollDownVertically();
		submitLogin.click();
		// below line will call and return the NavigationMenu class object.
		return new NavigationMenu(driver);
	}

	public boolean verifySuccessLoginMsg() {
		return new VerificatinHelper(driver).isDisplayed(successMsgAfterLogin);
	}

	public boolean verifySuccessEmailRagistartion() {
		return new VerificatinHelper(driver).isDisplayed(createAccountsuccessVarification);
	}

	public void enterRegistrationEmail() {
		String email = System.currentTimeMillis() + "@gmail.com";
		log.info("entering registration email.." + email);
		registrationEmailAddress.sendKeys(email);
	}

	public RagistrationPage clickOnCreateAnAccount() {
		createAnAccount.click();
		return new RagistrationPage(driver);
	}

	public void loginToApplication(String emailAddress, String password) {
		clickOnSignInLink();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}

	public void emailRagistartionForAccountCreation() {
		clickOnSignInLink();
		enterRegistrationEmail();
		clickOnCreateAnAccount();
	}

	public void logout() {
		logout.click();
		log.info("clicked on logout link");
		waitHelper.waitForElement(SignIn, ObjectReader.reader.getExplicitWaitValueFromPropertyFile());
	}

	// public void logExtentReport(String s1) {
	// TestBase.test.log(Status.INFO, s1);
	// }
}
