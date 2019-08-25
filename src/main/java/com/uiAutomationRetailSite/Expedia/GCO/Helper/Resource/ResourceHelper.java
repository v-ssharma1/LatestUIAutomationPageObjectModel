package com.uiAutomationRetailSite.Expedia.GCO.Helper.Resource;

public class ResourceHelper {

	public static String getResorcePath(String path) {
		return System.getProperty("user.dir") + path;
	}

	// //Main method to test getResorcePath(path) method without setup.
	// public static void main(String[] args) {
	// System.out.println(System.getProperty("user.dir"));
	// System.out.println(ResourceHelper.getResorcePath("/src/main/resources/configfile/log4j.properties"));
	// }
}
