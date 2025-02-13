package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.PaymentsPlanpage;
import resources.base;

public class PaymentsplanTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Payments Plan Types
	@Test(dataProvider = "getAdddata",priority =1)
	public void Add_Payment_Plan(String PaymentsPlanpage1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getaddpaymentplan().click();
		
		paymentplan.getaddpaymentplandataenter().sendKeys(PaymentsPlanpage1);
		//Data Validation of Payment Plan
		String valid_string = valid_alphanum(PaymentsPlanpage1,"paymentplan",20);
		String valid_paymentplan = valid_string;
		System.out.println(valid_paymentplan);
		
		Thread.sleep(3000);
		paymentplan.getcheckediscommercial().click();
		paymentplan.getpaymentplansave().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_paymentplan, "paymentplan is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Edit Payments Plan
	@Test(dataProvider = "getEditdata",priority =2)
	public void Edit_Payment_Plan(String PaymentsPlanpage1,String PaymentsPlanpage2) throws InterruptedException {
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		SoftAssert softAssert = new SoftAssert();
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getseaechingpaymentplan().sendKeys(PaymentsPlanpage2);
		paymentplan.getsearchedclick().click();
		paymentplan.getEditpaymentplan().click();
		
		paymentplan.getEditpaymentplandata().clear();
		paymentplan.getEditpaymentplandata().sendKeys(PaymentsPlanpage1);
		//Data Validation of Payment Plan
		String valid_string = valid_alphanum(PaymentsPlanpage1,"paymentplan",20);
		String valid_paymentplan = valid_string;
		System.out.println(valid_paymentplan);
		
		Thread.sleep(2000);
		paymentplan.getEditpaymentplansave().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_paymentplan, "paymentplan is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Delete Payments Plan
	@Test(dataProvider = "getdelete",priority =5)
	public void Delete_banksString (String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getseaechingpaymentplan().sendKeys(PaymentsPlanpage1);
		paymentplan.getsearchedclick().click();
		paymentplan.getDeletepaymentplanclick().click();
		Thread.sleep(2000);
		paymentplan.getDeleteconfirmation().click();
		Thread.sleep(3000);
	}
	@DataProvider
	public Object[][] getdelete() {
		return new Object[][] { { "Test payment 1" },{ "Test payment 2" },{ "Test payment 3" },{ "Test payment 4" } };
	}

	//Searched Payments Plan
	@Test(dataProvider = "getsearched",priority =4)
	public void searched_banks(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getseaechingpaymentplan().sendKeys(PaymentsPlanpage1);
		paymentplan.getsearchedclick().click();
		Thread.sleep(2000);
	}
	
	@Test(priority =3)
	public void Excel_banks() throws InterruptedException {
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getexcelclickclick().click();
		Thread.sleep(2000);
	}
	

	//Add Validation Payment Plan
	@Test(priority =6)
	public void Add_Validation_Payment_Plan() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getaddpaymentplan().click();

		paymentplan.getcheckediscommercial().click();
		paymentplan.getpaymentplansave().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div"
				+ "/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Payment Plan name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Payment Plan name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
		
	}

	@Test(priority =7)
	public void Edit_validationpaymentsplan() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getEditpaymentplan().click();
		int nm  = paymentplan.getaddpaymentplandataenter().getAttribute("value").length();
		for (int i = 0; i < nm ; i++) {
			paymentplan.getaddpaymentplandataenter().sendKeys(Keys.BACK_SPACE);
		}
		
		paymentplan.getEditpaymentplansave().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Payment Plan name is required";
		softAssert.assertEquals("Payment Plan name is required", expectedMessage, actualMessage);
		softAssert.assertAll();

	}

	//close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	//DataProvider for Add Payments Plan
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Test payment 1" },{ "Test payment 2" },{ "Test payment 3" },{ "Test payment 4" } };
	}

	//DataProvider for Apply Searched for Payments Plan
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Test payment 2 update","Test payment 2" } };
	}
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "Test payment 3" } };
	}
}