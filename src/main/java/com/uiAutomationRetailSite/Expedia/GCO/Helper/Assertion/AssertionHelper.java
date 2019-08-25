package com.uiAutomationRetailSite.Expedia.GCO.Helper.Assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;

public class AssertionHelper {
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	/*
	 * This method will check the test results against actual string.
	 */
	public static void verifyText(String actaulString, String testResultString) {
		log.info("Verifying if " + actaulString + "is equals to " + testResultString);
		Assert.assertEquals(actaulString, testResultString);
	}

	/*
	 * This method will make the assert true .
	 */
	public static void markPass() {
		log.info("Marking script pass...");
		Assert.assertTrue(true);
	}

	/*
	 * This method will make the assert false .
	 */
	public static void markFail() {
		log.info("Marking script fail...");
		Assert.assertTrue(false);
	}

	/*
	 * This method will print the text message while passing the script.
	 */
	public static void makeTrue(String message) {
		log.info("Making script pass.with message..");
		Assert.assertTrue(true, message);
	}

	/*
	 * This method will print the text message while failing the script.
	 */
	public static void makeFale(String message) {
		log.info("Making script fale.with message..");
		Assert.assertTrue(false, message);
	}

	/*
	 * This method verify if the returned status is true.
	 */
	public static void verifyTrue(boolean status) {
		log.info("Checking if the status is true.");
		Assert.assertTrue(status);
	}

	/*
	 * This method verify if the returned status is false.
	 */
	public static void verifyFalse(boolean status) {
		log.info("Checking if the status is false.");
		Assert.assertFalse(status);
	}

	/*
	 * This method verify if the string is null.
	 */
	public static void verifyNull(String str) {
		log.info("Checking if the string is null.");
		Assert.assertNull(str);
	}

	/*
	 * This method verify if the string is not null.
	 */
	public static void verifyNotNull(String str) {
		log.info("Checking if the string is not null.");
		Assert.assertNotNull(str);
	}
	
	public static void Fail(){
		Assert.assertTrue(false);
	}
	
	public static void Pass(){
		Assert.assertTrue(true);
	}

	/*
	 * This method to check the test staus.
	 */
	public static void updateTestStatus(boolean status){
		if(status){
			Pass();
		}
		else{
			Fail();
		}
	}
}
