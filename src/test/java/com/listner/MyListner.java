package com.listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utility.Utility_1;

public class MyListner implements ITestListener {
	public void onStart(ITestContext result)
	{
		
	}
	public void onFinish(ITestContext result)
	{
		
	}
	public void onTestSucess(ITestResult result)

	{
		Utility_1.takeScreenshot(null);
	}
	

}
