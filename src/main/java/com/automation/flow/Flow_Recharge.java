package com.automation.flow;

import org.openqa.selenium.WebDriver;

import com.automation.po.Recharge;

public class Flow_Recharge {

	/* here I have called all my page objects of Recharge according to my business flow or requirement 
	 * 
	 *  this flow will take care care of all the recharge related journeys
	 *  
	 *  we can maintain the sequence of multiple page objects in business flow files depending on the scenarios like here we have covered happy flow but we can also add negative & edge cases.
	 * 
	 * */
	

	
	public static void RechargePage(WebDriver driver){
		
		Recharge rchg = new Recharge(driver);
		rchg.selectOperator(driver);
		rchg.EnterMobileNumber(driver);
		rchg.EnterRechargeAmount(driver);
		rchg.ClickOnSiguienteBtnValid(driver);
	}
	
	
}
