package com.uiAutomationRetailSite.Expedia.GCO.PageObject.CreateAccount;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class CreateAnAccountPage extends TestBase {
	public static final Logger log = Logger.getLogger(CreateAnAccountPage.class.getName());
	WebDriver driver;

	@FindBy(xpath = "//h3[@class='page-subheading'][contains(text(),'Your personal information')]")
	WebElement yourPersonalInfo;

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement mr;

	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement mrs;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//span[@class='form_info'][contains(text(),'(Five characters minimum)')]")
	WebElement passwordText;

	@FindBy(xpath = "//select[@id='days']")
	WebElement dayOfDOB;

	@FindBy(xpath = "//select[@id='months']")
	WebElement monthOfDOB;

	@FindBy(xpath = "//select[@id='years']")
	WebElement yearOfDOB;

	@FindBy(xpath = "//h3[@class='page-subheading'][contains(text(),'Your address')]")
	WebElement yourAddress;

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstNameForAddress;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastNameForAddress;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement firstLineOfAddress;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//select[@id='id_state']")
	WebElement state;

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement postalCode;

	@FindBy(xpath = "//select[@id='id_country']")
	WebElement country;

	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[@id='alias']")
	WebElement addressAlias;

	@FindBy(xpath = "//button[@id='submitAccount']")
	WebElement ragisterButton;

	@FindBy(xpath = "//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
	WebElement myAccount;

	public CreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void yourPersonalInfo(String gender, String firstName, String lastName, String pass, String day,
			String month, String year) {
		Select selectDay = new Select(dayOfDOB);
		Select selectMonth = new Select(monthOfDOB);
		Select selectYear = new Select(yearOfDOB);
		if (gender.equalsIgnoreCase("male")) {
			mr.click();
			log.info("Male Gender is selected succesfully.");
		} else {
			mrs.click();
			log.info("Female Gender is selected succesfully.");
		}
		this.firstName.click();
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		log.info("First name entered.");
		this.lastName.click();
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		log.info("Last name entered.");
		this.password.click();
		this.password.clear();
		password.sendKeys(pass);
		log.info("Password entered.");
		//selectDay.selectByIndex(Integer.parseInt(day)-1);
		//selectDay.selectByVisibleText(day);
		selectDay.selectByValue(day);
		log.info("Day of date of birth has been selected.");
		selectMonth.selectByValue(month);
		log.info("Month of date of birth has been selected.");
		selectYear.selectByValue(year);
		log.info("Year of date of birth has been selected.\n");
		log.info("Personal information is entered succesfully.");
	}

	public void yourAddress(String firstNameForAddress, String lastNameForAddress, String firstLineOfAddress,
			String city, String postalCode, String stateName, String countryName, String mobileNumber,
			String addressAlias) {
		Select selectState = new Select(state);
		Select selectCountry = new Select(country);
		this.firstNameForAddress.click();
		this.firstNameForAddress.clear();
		this.firstNameForAddress.sendKeys(firstNameForAddress);
		log.info("First name of address lines is entered.");
		this.lastNameForAddress.click();
		this.lastNameForAddress.clear();
		this.lastNameForAddress.sendKeys(lastNameForAddress);
		log.info("Last name of address lines is entered.");
		this.firstLineOfAddress.click();
		this.firstLineOfAddress.clear();
		this.firstLineOfAddress.sendKeys(firstLineOfAddress);
		log.info("First Line of address lines is entered.");
		this.city.click();
		this.city.clear();
		this.city.sendKeys(city);
		log.info("City of address lines is entered.");
		this.postalCode.click();
		this.postalCode.clear();
		this.postalCode.sendKeys(postalCode);
		log.info("Postal code is entered.");
		selectState.selectByVisibleText(stateName);
		log.info("State Name is selected.");
		selectCountry.selectByValue(countryName);
		log.info("Country Name is selected.");
		this.mobileNumber.click();
		this.mobileNumber.clear();
		this.mobileNumber.sendKeys(mobileNumber);
		log.info("Mobile Number is entered.");
		this.addressAlias.click();
		this.addressAlias.clear();
		this.addressAlias.sendKeys(addressAlias);
		log.info("Address Alias is entered.\n");
		log.info("Address information is entered successfully.");
	}
	
	public void clickOnRagisterButton(){
		ragisterButton.click();
		log.info("Ragister button is clicked");
	}

	public String successfullRagistationMessage() {
		return myAccount.getText();
	}
}
