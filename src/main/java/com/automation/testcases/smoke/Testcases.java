package com.automation.testcases.smoke;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.common.util.ExtentReport;
import com.automation.common.util.ScreenShotListner;
import com.automation.driver.DefaultDriverManager;
import com.automation.flow.Flow_Payment;
import com.automation.flow.Flow_Recharge;
import com.aventstack.extentreports.Status;

/**
 * This is my Testcase file where I will write all the testcases depending on the requirement
 *
 */
@Listeners(ScreenShotListner.class)
public class Testcases extends ExtentReport {
	static Logger log = Logger.getLogger(Testcases.class);
	public static RemoteWebDriver driver = null;

	@Test
	public void SuccessfulPayment() throws MalformedURLException {
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			test = extent.createTest(name);
			driver = DefaultDriverManager.getDriver();
			ScreenShotListner.driversMap.put(name, driver);
			Flow_Recharge.RechargePage(driver);
			Flow_Payment.SuccessPayment(driver);
			log.info("Please check Testcase " + name + " is Passed");
			test.log(Status.PASS, "Please check Testcase " + name + " is Passed");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Please check Testcase " + name + " is failed");
			test.log(Status.FAIL, "Please check Testcase " + name + " is failed");
			Assert.fail();
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		extent.close();
	}

}
