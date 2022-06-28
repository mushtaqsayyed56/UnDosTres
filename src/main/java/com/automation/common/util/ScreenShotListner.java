package com.automation.common.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotListner implements ITestListener{

	/* This class will generate screenshot of passed or failed testcase and store in Screenshot folder*/
	
	
	public static Map<String, RemoteWebDriver> driversMap = new HashMap<String, RemoteWebDriver>();
	WebDriver driver = null;
	String filePath = System.getProperty("user.dir") +File.separator+ "test-output" + File.separator+ "Screenshots";
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		// getting the date
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd_MM_yyyy");// dd/MM/yyyy
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH_mm_ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String strTime = sdfTime.format(now);
		System.out.println(driversMap.get(testName));
		EventFiringWebDriver driver = new EventFiringWebDriver(driversMap.get(testName));
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File theDirc = new File(filePath + File.separator +"fail"+File.separator+strDate+File.separator+strTime);
		if (!theDirc.exists()) 
		{
			theDirc.mkdir();
			try {
				FileUtils.copyFile(srcFile,new File(theDirc+ File.separator+testName+ ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				FileUtils.copyFile(srcFile,new File(theDirc+ File.separator+testName+ ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		// getting the date
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd_MM_yyyy");// dd/MM/yyyy
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH_mm_ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String strTime = sdfTime.format(now);
		System.out.println(driversMap.get(testName));
		EventFiringWebDriver driver = new EventFiringWebDriver(driversMap.get(testName));
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File theDirc = new File(filePath + File.separator +"Pass"+File.separator+strDate+File.separator+strTime);
		if (!theDirc.exists()) 
		{
			theDirc.mkdir();
			try {
				FileUtils.copyFile(srcFile,new File(theDirc+ File.separator+testName+ ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				FileUtils.copyFile(srcFile,new File(theDirc+ File.separator+testName+ ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

