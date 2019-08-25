package com.uiAutomationRetailSite.Expedia.GCO.Utils;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger.LoggerHelper;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Resource.ResourceHelper;
import com.uiAutomationRetailSite.Expedia.GCO.TestBase.TestBase;

public class ExtentManager extends TestBase {
	private static Logger log = LoggerHelper.getLogger(ExtentManager.class);
	public static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			return createIntance(ResourceHelper.getResorcePath(
					"/src/test/TestResults/com/uiAutomationRetailSite/Expedia/GCO/Reports/extent.html"));
		} else {
			return extent;
		}
	}

	// Extent report instance creation whic will be used in getInstance of report.
	public static ExtentReports createIntance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		log.info("extent returned");
		return extent;
	}
}
