package com.hrms.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped " + result.getName());
		
	
	}
}
