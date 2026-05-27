package com.dvm.qa.selenium.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerCls implements ITestListener{

	public void onTestStart(ITestResult result) {

		System.out.println(result.getMethod().getMethodName() + " -> Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName() + " -> Test Pass");
	}

	public void onTestFailure(ITestResult result) {

		System.out.println(result.getMethod().getMethodName()+ " -> Test Failed");
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println(result.getMethod().getMethodName()+ " -> Test Skipped");

	}

}
