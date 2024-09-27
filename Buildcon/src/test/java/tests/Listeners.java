package tests;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;
//ITestListener interface which implements Testing Listeners
public class Listeners extends base implements ITestListener {
	
	//here calling the static method for configuring extent report setting
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;
	
	//local ThreadG
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		//every start of test below line generated in extent report with testmethod name
	    test = extent.createTest(result.getMethod().getMethodName());	
	    //after creating test object you need to set with localThread
	    extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//generate a log in the extent report
		extenttest.get().log(Status.PASS, "TestCase Pass");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {		
		//generate a failure log in the extent report
		extenttest.get().fail(result.getThrowable());
		
		//taking screenshot of Failure Test Case identify failure test method name
		String testmethodname = result.getMethod().getMethodName();
		System.out.println("Starting test: " + testmethodname);
		
		//identify failure class driver object
		ITestContext context = result.getTestContext();
	    driver = (WebDriver) context.getAttribute("WebDriver");
		
		//pass failure metheod name and driver object to base class getscreenshot method
		if (driver == null) {
			System.out.println("Driver is null-Nilesh2");
		}
		//String dest = getscreenshot(testmethodname, driver);
		//extenttest.get().addScreenCaptureFromPath(dest, testmethodname );
	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		//on finish we flush our extent report
		extent.flush();
	}
}
