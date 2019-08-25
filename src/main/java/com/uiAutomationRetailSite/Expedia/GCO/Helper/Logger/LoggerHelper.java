package com.uiAutomationRetailSite.Expedia.GCO.Helper.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.uiAutomationRetailSite.Expedia.GCO.Helper.Resource.ResourceHelper;

public class LoggerHelper {

	private static boolean root=false;
	
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class cls) {
		if(root) {
			return Logger.getLogger(cls);
		}
		
		PropertyConfigurator.configure(ResourceHelper.getResorcePath("/src/main/resources/configfile/log4j.properties"));
	    root=true;
	    return Logger.getLogger(cls);
	}
	//to test the logger setup without whole framework setup
//	public static void main(String[] args) {
//		Logger log=LoggerHelper.getLogger(LoggerHelper.class);
//		log.info("Logger is configured.");
//		log.info("Logger is configured.");
//		log.info("Logger is configured.");
//	}
}
