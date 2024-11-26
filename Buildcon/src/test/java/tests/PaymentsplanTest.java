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
	@Test(dataProvider = "getAdddata")
	public void Add_Payment_Plan(String PaymentsPlanpage1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getaddpaymentplan().click();
		
		paymentplan.getaddpaymentplandataenter().sendKeys(PaymentsPlanpage1);
		//Data Validation of Payment Plan
		String valid_string = valid_alphanum(PaymentsPlanpage1,"paymentplan",10);
		String valid_paymentplan = valid_string;
		System.out.println(valid_paymentplan);
		
		Thread.sleep(3000);
		paymentplan.getcheckediscommercial().click();
		paymentplan.getpaymentplansave().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_paymentplan, "paymentplan is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Edit Payments Plan
	@Test(dataProvider = "getEditdata")
	public void Edit_Payment_Plan(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getEditpaymentplan().click();
		
		paymentplan.getEditpaymentplandata().clear();
		paymentplan.getEditpaymentplandata().sendKeys(PaymentsPlanpage1);
		//Data Validation of Payment Plan
		String valid_string = valid_alphanum(PaymentsPlanpage1,"paymentplan",20);
		String valid_paymentplan = valid_string;
		System.out.println(valid_paymentplan);
		
		Thread.sleep(2000);
		paymentplan.getEditpaymentplansave().click();
	}

	//Delete Payments Plan
	@Test
	public void Delete_banks() throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getDeletepaymentplanclick().click();
		unit.getDeleteconfirmation().click();
		Thread.sleep(2000);
	}

	//Searched Payments Plan
	@Test(dataProvider = "getsearched")
	public void searched_banks(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getseaechingpaymentplan().sendKeys(PaymentsPlanpage1);
		unit.getsearchedclick().click();
		Thread.sleep(2000);
	}
	
	@Test
	public void Excel_banks() throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getexcelclickclick().click();
		Thread.sleep(2000);
	}
	

	//Add Validation Payment Plan
	@Test
	public void Add_Validation_Payment_Plan() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getaddpaymentplan().click();

		paymentplan.getcheckediscommercial().click();
		paymentplan.getpaymentplansave().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div"
				+ "/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "1Payment Plan name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Payment Plan name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
		softAssert.assertAll();
	}

	@Test
	public void Edit_validationpaymentsplan() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getpaymentplan().click();
		paymentplan.getEditpaymentplan().click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String xpath = "/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input";
		String nm1 = (String) js.executeScript("return document.evaluate('" + xpath + "', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value;");
		System.out.println(nm1);

		WebElement name111 = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input"));
		String nm = name111.getText();
		System.out.println(nm);
		//int ml = nm.length();
		for (int i = 1; i < 12; i++) {
			paymentplan.getaddpaymentplandataenter().sendKeys(Keys.BACK_SPACE);
		}
		paymentplan.getEditpaymentplansave().click();
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
//
	 //close the driver
	@AfterMethod
	public void teaddown() {
		// driver.close();
	}

	//DataProvider for Add Payments Plan
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "xomicpayment" } };
	}

	//DataProvider for Apply Searched for Payments Plan
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Googlepayplan12" } };
	}
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "Googlepayplan12" } };
	}
}