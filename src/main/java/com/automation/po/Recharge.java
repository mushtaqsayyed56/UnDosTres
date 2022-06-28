package com.automation.po;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.common.util.ActionBot;
import com.automation.common.util.ConfigReader;
import com.automation.common.util.ExtentReport;
import com.aventstack.extentreports.Status;

/*
 * Kept all the shopping cart page object in this file using page factory
 * 
 */

public class Recharge extends ExtentReport {

	static Logger log = Logger.getLogger(Recharge.class);
	WebDriver driver = null;

	public Recharge(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "operator")
	private WebElement operatorName;

	@FindBy(xpath = "//div[contains(@class,'suggestion')]/ul/li/a/div/b")
	private List<WebElement> operatorList;

	@FindBy(xpath = "//*[@data-qa='celular-mobile']")
	private WebElement enterMobile;

	@FindBy(xpath = "//*[@data-qa='celular-amount']")
	private WebElement amountTextfield;

	@FindBy(xpath = "//*[@data-cat='Recarga Saldo']/a/div/b")
	private List<WebElement> amountSuggestionList;

	@FindBy(xpath = "//*[@data-qa='celular-pay']")
	private WebElement siguienteButton;

	@FindBy(xpath = "//div[contains(@class,'spinner big-spinner')]")
	private WebElement spinner;
	
	@FindBy(id= "panel-title-card")
	private WebElement cardTab;

	
	
	public void selectOperator(WebDriver driver) {

		try {
			ActionBot.click(driver, operatorName);

			for (WebElement ele : operatorList) {
				if (ActionBot.getText(driver, ele).equals(ConfigReader.ReadProperty("testdata", "Operator"))) {
					ActionBot.click(driver, ele);
					break;
				}
			}

			if (ActionBot.isDisplayed(driver, enterMobile)) {
				log.info("successfully selected operator");
				test.log(Status.PASS, "successfully selected operator");
			} else {

				log.info("unable to select operator");
				test.log(Status.FAIL, "unable to select operator");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("problem in selecting operator");
			test.log(Status.ERROR, "problem in selecting operator");
			Assert.fail();
		}

	}

	public void EnterMobileNumber(WebDriver driver) {
		try {
			ActionBot.type(driver, enterMobile, ConfigReader.ReadProperty("testdata", "MobileNumber"));
			log.info("successfully entered MobileNumber");
			test.log(Status.PASS, "successfully entered MobileNumber");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering PostalCode in MobileNumber textfield");
			test.log(Status.ERROR, "problem in entering PostalCode in MobileNumber textfield");
			Assert.fail();
		}
	}

	public void EnterRechargeAmount(WebDriver driver) {
		try {
			ActionBot.click(driver, amountTextfield);

			for (WebElement ele : amountSuggestionList) {
				if (ActionBot.getText(driver, ele).equals(ConfigReader.ReadProperty("testdata", "Amount"))) {
					ActionBot.click(driver, ele);
					break;
				}
			}
			log.info("successfully entered MobileNumber");
			test.log(Status.PASS, "successfully entered MobileNumber");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering PostalCode in amountTextfield");
			test.log(Status.ERROR, "problem in entering PostalCode in MobileNumber textfield");
			Assert.fail();
		}
	}

	public void ClickOnSiguienteBtnValid(WebDriver driver) {

		try {
			ActionBot.click(driver, siguienteButton);
			if (ActionBot.isDisplayed(driver, cardTab)) {
				log.info("successfully clicked on Siguiente button");
				test.log(Status.PASS, "successfully clicked on Siguiente button");
			} else {

				log.info("unable to click on Siguiente button");
				test.log(Status.FAIL, "unable to click on Siguiente button");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("problem in clicking on Siguiente button");
			test.log(Status.ERROR, "problem in clicking on Siguiente button");
			Assert.fail();
		}

	}

}
