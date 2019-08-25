package com.uiAutomationRetailSite.Expedia.GCO.Helper.Listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class ExtentListener implements ITestListener {
	public static ExtentReports extent;
	public static ExtentTest test;
	private Logger log = LoggerHelper.getLogger(ExtentListener.class);

	@Override
	public void onFinish(ITestContext arg0) {
		// extent.flush();
		// Below is for emailed test ng report in output forlder of project
		Reporter.log(arg0.getName() + "Test finished.");
		log.info(arg0.getName() + "Test Finished.");
	}

	@Override
	public void onStart(ITestContext arg0) {
		// extent = ExtentManager.getInstance();
		// test = extent.createTest(arg0.getName());
		// test = extent.createTest(arg0.getCurrentXmlTest().getName());
		// Below is for emailed test ng report in output forlder of project
		Reporter.log(arg0.getName() + "Class started.");
		log.info(arg0.getName() + "Class started.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// test.log(Status.FAIL, arg0.getThrowable());
		// Below is for emailed test ng report in output forlder of project
		Reporter.log(arg0.getMethod().getMethodName() + "Test failed." + arg0.getThrowable());
		log.error(arg0.getMethod().getMethodName() + "Test failed." + arg0.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// test.log(Status.SKIP, arg0.getThrowable());
		// Below is for emailed test ng report in output forlder of project
		Reporter.log(arg0.getMethod().getMethodName() + "Test skipped." + arg0.getThrowable());
		log.warn(arg0.getMethod().getMethodName() + "Test skipped." + arg0.getThrowable());
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// test.log(Status.INFO, arg0.getName() + " Started.");
		// Below is for emailed test ng report in output forlder of project
		Reporter.log(arg0.getMethod().getMethodName() + "Test started.");
		log.info(arg0.getMethod().getMethodName() + "Test started.");

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// test.log(Status.INFO, arg0.getName() + " Passed.");
		// Below is for emailed test ng report in output forlder of project
		Reporter.log(arg0.getMethod().getMethodName() + "Test passed.");
		log.info(arg0.getMethod().getMethodName() + "Test passed.");
	}

}
