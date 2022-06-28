package com.automation.flow;

import org.openqa.selenium.WebDriver;

import com.automation.common.util.ConfigReader;
import com.automation.po.Payment;

public class Flow_Payment {

	/*
	 * here I have called all my page object of payment according to my business
	 * flow or requirement
	 * 
	 * 
	 * this flow will take care care of all the payment related journeys
	 * 
	 * in business flow we can add many scenarios here I have only covered happy flow for payment
	 */

	public static void SuccessPayment(WebDriver driver) {

		Payment pay = new Payment(driver);
		pay.SelectPaymentMode(driver);
		pay.SelectCardGroup(driver);
		pay.EnterCardNo(driver);
		pay.EnterMonth(driver);
		pay.EnterDate(driver);
		pay.EnterCVV(driver);
		pay.EnterEmail(driver);
		pay.SelectPayButton(driver);
		pay.EnterUsername(driver);
		pay.EnterPassword(driver);
		pay.HandleCaptcha(driver);
	boolean isLimitExceeded =	pay.clickOnLoginButton(driver);
		if (isLimitExceeded) {
			pay.PayWithAlreadyAddedCard(driver);
		}

	}

}
