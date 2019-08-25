package com.uiAutomationRetailSite.Expedia.GCO.Helper.Generic;

import java.util.Random;

public class RandomNumberGenerator {
	public static Random rand;

	public static int randomGenerator() {
		rand = new Random();
		return rand.nextInt(100000);
	}
}
