package com.automation.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.automation.common.util.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DefaultDriverManager {

	/* Initiate driver according to your requirement currently I have done for chrome as well as firefox browser */
	
	
	/* below commented line will get the browser from config file but currently we are accepting browser as CLI arguments */ 
	
//	private static String selectBrowser = ConfigReader.ReadProperty("config", "Browser");

	private static String selectBrowser =  getParameter("browser");
	
	public static RemoteWebDriver getDriver() throws MalformedURLException {

		RemoteWebDriver driver = null;

		if (selectBrowser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (selectBrowser.equalsIgnoreCase("FF")|| selectBrowser.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			
		} else {
			System.out.println("Please select valid browser");
			Assert.fail();
		}

		driver.get(ConfigReader.ReadProperty("config", "URL"));
		
		driver.manage().timeouts().pageLoadTimeout(Integer.valueOf(ConfigReader.ReadProperty("config", "PageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(ConfigReader.ReadProperty("config", "ImplicitTimeout")), TimeUnit.SECONDS);
		return driver;

	}

	private static String getParameter(String name) {
		  String value = System.getProperty(name);
		  if (value == null)
		     throw new RuntimeException(name + " is not a parameter!");

		  if (value.isEmpty())
		    throw new RuntimeException(name + " is empty!");

		  return value;
		 }
	
}
