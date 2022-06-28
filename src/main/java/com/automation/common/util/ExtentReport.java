package com.automation.common.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	/* code for extent report and logger 
	 * 
	 * 
	 */
	
	final static Logger log = Logger.getLogger(ExtentReport.class);
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeClass
	public void setUp() {
	
	DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
	DateFormat timeFormat = new SimpleDateFormat("hh.mm.ss");
	
	Date date = new Date();
	String currentDate1 = dateFormat.format(date);
	String currentTime1 = timeFormat.format(date);
	String currentDate = String.valueOf(currentDate1);
	String currentTime = String.valueOf(currentTime1);
	String path = System.getProperty("user.dir") + File.separator +"test-output"+ File.separator +"extent-reports"+ File.separator + currentDate;
	File file = new File(path);
	if (!file.exists()) {
	file.mkdirs();
	System.out.println("===============>> Extent repopprt path generated here" + path);
}
 
 path=path + File.separator +"_Test_Execution_report_"+ currentTime +".html";
 PropertyConfigurator.configure("log4j.properties");

System.out.println(path);
log.info("---starting test run---");
htmlReporter = new ExtentHtmlReporter(path);
extent = new ExtentReports();
extent.attachReporter(htmlReporter);

extent.setSystemInfo("OS", ConfigReader.ReadProperty("config", "OS"));
extent.setSystemInfo("Host Name", ConfigReader.ReadProperty("config", "HOSTNAME"));
extent.setSystemInfo("Environment", ConfigReader.ReadProperty("config", "ENVIRONMENT"));
extent.setSystemInfo("User Name", ConfigReader.ReadProperty("config", "USERNAME"));
htmlReporter.config().setReportName(ConfigReader.ReadProperty("config", "REPORTNAME"));

htmlReporter.config().setChartVisibilityOnOpen(true);
htmlReporter.config().setDocumentTitle(ConfigReader.ReadProperty("config", "DOCUMENTTITLE"));
htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
htmlReporter.config().setTheme(Theme.DARK);	
}
}
