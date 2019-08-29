package com.uiAutomationRetailSite.Expedia.GCO.TestBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.BrowserType;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.ChromeBrowser;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.FirefoxBrowser;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.HeadlessHtmlUnitDriverBrowser;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.ObjectReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.BrowserConfiguration.config.PropertyReader;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Excel.ExcelHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Generic.CalanderAndDateFormeter;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Generic.RandomNumberGenerator;
//import com.uiAutomationRetailSite.Expedia.GCO.Helper.JavaScript.JavaScriptHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Resource.ResourceHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Wait.WaitHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Utils.ExtentManager;

public class TestBase {
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	public static WebDriver driver;
	public ChromeBrowser chrome;
	public FirefoxBrowser firefox;
	public HeadlessHtmlUnitDriverBrowser htmlunitdriver;
	public WaitHelper wait;
	public static File reportDirectory;
	public static ExtentReports extent;
	public static ExtentTest test;

	// get browser object from BrowserType enum created.
	public WebDriver getBrowserObject(BrowserType broswerType) throws Exception {
		try {

			switch (broswerType) {
			case Chrome:
				// create instance of chrome below is the another way of creating object.
				// this will be used to get the chrome options for getChromeDriver method of
				// ChromeBrowser class.
				chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeOptions());

			case FireFox:
				// Exactly same as for above.
				firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxOptions());

			default:
				throw new Exception("Driver not found.." + broswerType.name());
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	// Once the reader is intialzied in before test method and data of property file
	// is read before any
	// test then you can run the below method to initalize the driver and open the
	// browser, set wait and load the page timeout switch (broswerType) {
	public void setUpDriver(BrowserType broswerType) throws Exception {
		driver = getBrowserObject(broswerType);
		log.info("Intialized the driver: " + driver.hashCode());
		wait = new WaitHelper(driver);
		wait.setImplicitwait(60, TimeUnit.SECONDS);
		wait.pageLoadTime(60, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
	}

	public String captureScreenShot(String fileName, WebDriver driver) {
		if (driver == null) {
			log.info("driver is null");
			return null;
		}
		if (fileName == "") {
			fileName = "Blank";
		}
		Reporter.log("captureScreen method called");
		File destFile = null;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// reportDirectory was intialzed before test.
			// reportDirectory = new
			// File(ResourceHelper.getResorcePath("/src/test/TestResults/com/uiAutomationRetailSite/Expedia/GCO/ScreenShots/");

			destFile = new File(reportDirectory + "/" + fileName + "_" + RandomNumberGenerator.randomGenerator() + "_"
					+ CalanderAndDateFormeter.dateFormetor() + ".png");
			Files.copy(scrFile.toPath(), destFile.toPath());
			// System.out.println("destFile getAbsolutePath: " +
			// destFile.getAbsolutePath());
			// This will help us to link the screen shot in testNG extent report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	/*
	 * This method is to capture the screenshot of all the navigated pages of page
	 * object model and add them into the emailed and extent reports.afterMethod
	 * will take the screenshots of just success and failes .
	 */
	public void getNavigationScreen(WebDriver driver) {
		log.info("capturing ui navigation screen...");
		// Screen size is very big hence screenshots are not coming properly and hence
		// we are jooming in for 40% so that screenshot may come properly.
		// new JavaScriptHelper(driver).zoomINTheScrin(40);
		// below line will add the screenshot to emailed report under output folder.
		String screen = captureScreenShot("", driver);
		// if you zoom the screen in it is necessay to zoom it out back to normal
		// othervise system will not be able to read object locators.
		// new JavaScriptHelper(driver).zoomINTheScrin(100);
		try {
			// below line will add the screenshot to extent report under report folder.
			test.addScreenCaptureFromPath(screen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logExtentReport(String s1) {
		test.log(Status.INFO, s1);
	}

	public static void getApplicationUrl(String url) {
		driver.get(url);
		logExtentReport("navigating to ..." + url);
	}

	public Object[][] getExcelData(String excelName, String sheetName) {
		String excelLocation = ResourceHelper.getResorcePath("src/main/resources/configfile/") + excelName;
		log.info("excel location " + excelLocation);
		ExcelHelper excelHelper = new ExcelHelper();
		Object[][] data = excelHelper.getExcelData(excelLocation, sheetName);
		return data;
	}

	/*-----------------Before and After Method--------------*/
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
	}

	// this will initialze your brwser related data before every test.
	// Here we are creating the PropertyReader object and asssigning it to inteface
	// refrence variable to achieve loose coupling.
	@BeforeTest
	public void beforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		reportDirectory = new File(ResourceHelper
				.getResorcePath("/src/test/TestResults/com/uiAutomationRetailSite/Expedia/GCO/ScreenShots/"));
		setUpDriver(ObjectReader.reader.getBrowserTypeValueFromPropertyFile());
		test = extent.createTest(getClass().getSimpleName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "**************test started***************");
		log.info("**************" + method.getName() + "Started***************");
	}

	// @BeforeClass
	// public void beforeClass() {
	// // test = extent.createTest(getClass().getName());
	// test = extent.createTest(getClass().getSimpleName());
	// }

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreenShot(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is pass");
			// String imagePath = captureScreenShot(result.getName(), driver);
			// test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		log.info("**************" + result.getName() + "Finished***************");
		extent.flush();
	}

	@AfterTest
	public void afterTest() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}
}
