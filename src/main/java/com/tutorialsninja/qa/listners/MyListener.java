package com.tutorialsninja.qa.listners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;

public class MyListener implements ITestListener {
	
	WebDriver driver;
	ExtentReports extendReport;
	ExtentTest extentTest;
	String testname;

	public void onStart(ITestContext context) {

		extendReport = ExtentReporter.generateExtendReport();
	}

	public void onTestStart(ITestResult result) {
		testname = result.getName();
		extentTest = extendReport.createTest(testname);
		extentTest.log(Status.INFO, testname + " Started Executing!!!");
	}

	public void onTestSuccess(ITestResult result) {
		testname = result.getName();
		extentTest.log(Status.PASS, testname + " Executed Successfully!!!");
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException  | IllegalAccessException  | NoSuchFieldException | SecurityException e ) {
			e.printStackTrace();
		}
		String destinationScreenshotPath = Utilities.getScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " Execution Failed!!!");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+ " Execution Skipped!!!");
	}

	public void onFinish(ITestContext context) {
		
		extendReport.flush();
		File extentReportFile = new File(System.getProperty("user.dir")
				+"\\test-output\\Extent Reports\\extentReport.html");
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
