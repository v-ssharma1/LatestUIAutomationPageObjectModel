package com.uiAutomationRetailSite.Expedia.GCO.Helper.Listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class arg1, @SuppressWarnings("rawtypes") Constructor arg2, Method arg3) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if (retry == null) {
			annotation.setRetryAnalyzer(Retry.class);
		}
		
	}

}
	