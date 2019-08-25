package com.uiAutomationRetailSite.Expedia.GCO.Helper.Generic;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalanderAndDateFormeter {
	public static Calendar calendar = Calendar.getInstance();
	public static SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	public static String dateFormetor() {
		return formater.format(calendar.getTime());
	}
}
