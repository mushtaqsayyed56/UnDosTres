package com.automation.common.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionBot {

	/*
	 * We can keep all the selenium actions in this class currently I have
	 * implemented few methods as per my requirement
	 * 
	 * 
	 */

	public static void click(WebDriver driver, WebElement ele) {
		waitUntilVisibility(driver, ele);
		ele.click();
	}

	public static void type(WebDriver driver, WebElement ele, String value) {
		waitUntilClickable(driver, ele);
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}

	public static String getText(WebDriver driver, WebElement ele) {
		waitUntilVisibility(driver, ele);
		return ele.getText();
	}

	public static void frameSwitchingByElement(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public static boolean isDisplayed(WebDriver driver, WebElement ele) {

		boolean bool = false;
		try {

			ActionBot.waitUntilVisibility(driver, ele);
			bool = ele.isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				ActionBot.waitUntilVisibility(driver, ele);
				bool = ele.isDisplayed();
			} catch (Exception e2) {
				e.printStackTrace();
			Assert.fail();
			}
		}

		return bool;
	}

	public static void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static void waitUntilVisibility(WebDriver driver, WebElement ele) {
	
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfAllElements(ele));
	
	}
	
	public static void waitUntilClickable(WebDriver driver, WebElement ele) {
		
		new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(ele));
	
	}

}
