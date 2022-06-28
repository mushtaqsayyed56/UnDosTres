package com.automation.po;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.common.util.ActionBot;
import com.automation.common.util.ConfigReader;
import com.automation.common.util.ExtentReport;
import com.aventstack.extentreports.Status;

/*
 * Kept all the payment related page object in this file using page factory
 * 
 */

public class Payment extends ExtentReport {

	static Logger log = Logger.getLogger(Payment.class);
	WebDriver driver = null;

	public Payment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='panelTextStyleDesktop']")
	private List<WebElement> selectPaymentMode;

	@FindBy(xpath = "//tr[@id='radio-n']/td/label/a/span")
	private WebElement selectCardGroup;

	@FindBy(id = "cardnumberunique")
	private WebElement cardNo;

	@FindBy(xpath = "//input[@data-qa='mes-input']")
	private WebElement cardMonth;

	@FindBy(xpath = "//input[@data-qa='expyear-input']")
	private WebElement cardDate;

	@FindBy(xpath = "//input[@data-qa='cvv-input']")
	private WebElement CVV;

	@FindBy(xpath = "//div[@class='row correoElectronicoPaymentsRow']//input[@placeholder='Correo electrónico' and @type='email']")
	private WebElement EMAIL;

	@FindBy(id = "paylimit")
	private WebElement PayButton;

	@FindBy(id = "usrname")
	private WebElement UserName;

	@FindBy(id = "psw")
	private WebElement Password;

	@FindBy(id = "loginBtn")
	private WebElement lgnBtn;

	@FindBy(className = "confirmButton")
	private WebElement EntendidoBtn;

	@FindBy(xpath = "//div[@class='visual-message']")
	private WebElement scsMsg;

	@FindBy(xpath = "//div[contains(@class,'spinner big-spinner')]")
	private WebElement spinner;

	@FindBy(id = "paylimitcardsaved")
	private WebElement payWithAlreadyAddedCard;

	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	private List<WebElement> CaptchaCheckBox;

	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	private List<WebElement> iFrame;

	
	
	public void SelectPaymentMode(WebDriver driver) {

		try {

			for (WebElement ele : selectPaymentMode) {
				if (ele.getText().equals(ConfigReader.ReadProperty("testdata", "PaymentMode"))) {
					ele.click();
					break;
				}
			}
			log.info("successfully selected PaymentMode");
			test.log(Status.PASS, "successfully selected PaymentMode");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("problem in selecting PaymentMode");
			test.log(Status.ERROR, "unable to selecting PaymentMode");
			Assert.fail();
		}

	}

	public void SelectCardGroup(WebDriver driver) {
		try {

			ActionBot.click(driver, selectCardGroup);
			ActionBot.click(driver, selectCardGroup);

			if (ActionBot.isDisplayed(driver, cardNo)) {
				ActionBot.click(driver, selectCardGroup);
			}

			if (ActionBot.isDisplayed(driver, cardNo)) {
				log.info("successfully selected on CardGroup");
				test.log(Status.PASS, "successfully selected on CardGroup");
			} else {
				log.info("unable to select on CardGroup");
				test.log(Status.FAIL, "unable to select on CardGroup");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("problem in selecting CardGroup");
			test.log(Status.ERROR, "unable to selectingCardGroup CardGroup");
			Assert.fail();
		}

	}

	public void EnterCardNo(WebDriver driver) {
		try {

			ActionBot.type(driver, cardNo, ConfigReader.ReadProperty("testdata", "CardNo"));
			log.info("successfully entered CardNo");
			test.log(Status.PASS, "successfully entered CardNo");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering CardNo in CardNo textfield");
			test.log(Status.ERROR, "problem in entering CardNo in CardNo textfield");
			Assert.fail();
		}
	}

	public void EnterMonth(WebDriver driver) {
		try {

			ActionBot.type(driver, cardMonth, ConfigReader.ReadProperty("testdata", "ExpiryMonth"));
			log.info("successfully entered ExpiryMonth");
			test.log(Status.PASS, "successfully entered ExpiryMonth");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering ExpiryMonth in ExpiryMonth textfield");
			test.log(Status.ERROR, "problem in entering ExpiryMonth in ExpiryMonth textfield");
			Assert.fail();
		}
	}

	public void EnterDate(WebDriver driver) {
		try {

			ActionBot.type(driver, cardDate, ConfigReader.ReadProperty("testdata", "ExpiryDate"));
			log.info("successfully entered ExpiryDate");
			test.log(Status.PASS, "successfully entered ExpiryDate");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering ExpiryMonth in ExpiryMonth textfield");
			test.log(Status.ERROR, "problem in entering ExpiryMonth in ExpiryMonth textfield");
			Assert.fail();
		}
	}

	public void EnterCVV(WebDriver driver) {
		try {

			ActionBot.type(driver, CVV, ConfigReader.ReadProperty("testdata", "CVV"));
			log.info("successfully entered CVV");
			test.log(Status.PASS, "successfully entered CVV");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering ExpiryMonth in CVV textfield");
			test.log(Status.ERROR, "problem in entering CVV in CVV textfield");
			Assert.fail();
		}
	}

	public void EnterEmail(WebDriver driver) {
		try {

			ActionBot.type(driver, EMAIL, ConfigReader.ReadProperty("testdata", "EMAIL"));
			log.info("successfully entered EMAIL");
			test.log(Status.PASS, "successfully entered EMAIL");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering ExpiryMonth in EMAIL textfield");
			test.log(Status.ERROR, "problem in entering EMAIL in CVV textfield");
			Assert.fail();
		}
	}

	public void SelectPayButton(WebDriver driver) {

		try {
			ActionBot.click(driver, PayButton);

			if (ActionBot.isDisplayed(driver, UserName)) {
				log.info("successfully selected PaymentMode");
				test.log(Status.PASS, "successfully selected PaymentMode");
			} else {
				log.info("unable to select PaymentMode");
				test.log(Status.FAIL, "unable to select PaymentMode");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("problem in selecting PaymentMode");
			test.log(Status.ERROR, "unable to selecting PaymentMode");
			Assert.fail();
		}

	}

	public void EnterUsername(WebDriver driver) {
		try {

			ActionBot.type(driver, UserName, ConfigReader.ReadProperty("testdata", "USERNAME"));
			log.info("successfully entered UserName");
			test.log(Status.PASS, "successfully entered UserName");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering ExpiryMonth in UserName textfield");
			test.log(Status.ERROR, "problem in entering UserName in CVV textfield");
			Assert.fail();
		}
	}

	public void EnterPassword(WebDriver driver) {
		try {

			ActionBot.type(driver, Password, ConfigReader.ReadProperty("testdata", "PASSWORD"));
			log.info("successfully entered Password");
			test.log(Status.PASS, "successfully entered Password");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in entering ExpiryMonth in Password textfield");
			test.log(Status.ERROR, "problem in entering Password in CVV textfield");
			Assert.fail();
		}
	}

	public void HandleCaptcha(WebDriver driver) {
		try {
			ActionBot.frameSwitchingByElement(driver, iFrame.get(0));

			ActionBot.click(driver, CaptchaCheckBox.get(0));

			ActionBot.switchToDefaultContent(driver);

			log.info("successfully HandleCaptcha");
			test.log(Status.PASS, "successfully HandleCaptcha");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("problem in Handling Captcha");
			test.log(Status.ERROR, "problem in Handling Captcha");
			Assert.fail();
		}
	}

	public boolean clickOnLoginButton(WebDriver driver) {
		boolean dailylimit = false;
		try {
			ActionBot.click(driver, lgnBtn);

			if (ActionBot.isDisplayed(driver, EntendidoBtn)) {
				dailylimit = true;
			} else {

				if (ActionBot.getText(driver, scsMsg).equals(ConfigReader.ReadProperty("testdata", "SUCCESSMSG"))) {

					log.info("Recharge is done successfully");
					test.log(Status.PASS, "Recharge is done successfully");
				} else {
					log.info("Found issue while making recharge");
					test.log(Status.FAIL, "Found issue while making recharge");
					Assert.fail();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("problem in doing successful recharge");
			test.log(Status.ERROR, "problem in doing successful recharge");
			Assert.fail();
		}
		return dailylimit;

	}

	public void PayWithAlreadyAddedCard(WebDriver driver) {

		try {

			ActionBot.click(driver, EntendidoBtn);

			ActionBot.click(driver, payWithAlreadyAddedCard);

			try {
				if (ActionBot.getText(driver, scsMsg).equals(ConfigReader.ReadProperty("testdata", "SUCCESSMSG"))) {
					log.info("Recharge is done successfully using already added card");
					test.log(Status.PASS, "Recharge is done successfully using already added card");
				} else {
					log.info("Found issue while making recharge using already added card");
					test.log(Status.FAIL, "Found issue while making recharge using already added card");
					Assert.fail();
				}
			} catch (WebDriverException e) {
				// TODO: handle exception
				if (ActionBot.getText(driver, scsMsg).equals(ConfigReader.ReadProperty("testdata", "SUCCESSMSG"))) {
					log.info("Recharge is done successfully using already added card");
					test.log(Status.PASS, "Recharge is done successfully using already added card");
				} else {
					log.info("Found issue while making recharge using already added card");
					test.log(Status.FAIL, "Found issue while making recharge using already added card");
					Assert.fail();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("problem in doing successful recharge using already added card");
			test.log(Status.ERROR, "problem in doing successful recharge using already added card");
			Assert.fail();
		}

	}

}
