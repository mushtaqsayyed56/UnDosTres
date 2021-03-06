package com.automation.main;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestRunner {

	/* generating testng.xml on runtime using testng. we have given this path in pom.xml so it will look for main method first   
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestNG myTestNG = new TestNG();

		// Create an instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("MySuite");
		// mySuite.setParallel(XmlSuite.ParallelMode.METHODS);

		mySuite.addListener("com.automation.common.util.ScreenShotListner");

		// Create an instance of XmlTest and assign a name for it.
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName("MyTest");

		// Create a list which can contain the classes that you want to run.
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		myClasses.add(new XmlClass("com.automation.testcases.smoke.Testcases"));

		// Assign that to the XmlTest Object created earlier.
		myTest.setXmlClasses(myClasses);

		// Create a list of XmlTests and add the Xmltest you created earlier to
		// it.
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(myTest);

		// add the list of tests to your Suite.
		mySuite.setTests(myTests);

		// Add the suite to the list of suites.
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);

		// Set the list of Suites to the testNG object you created earlier.
		myTestNG.setXmlSuites(mySuites);
		// mySuite.setFileName("TestNG.xml");
		// mySuite.setThreadCount(1);
		myTestNG.run();

	}

}
