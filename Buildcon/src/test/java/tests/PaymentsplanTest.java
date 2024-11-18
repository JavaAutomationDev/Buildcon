package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

	//Add paymentsplan types:
	@Test(dataProvider = "getAdddata")
	public void Add_paymentplan(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getaddpaymentplan().click();
		unit.getaddpaymentplandataenter().sendKeys(PaymentsPlanpage1);
		//data validation of payment plan
		String valid_string = valid_alphanum(PaymentsPlanpage1,"paymentplan",10);
		String valid_paymentplan = valid_string;
		System.out.println(valid_paymentplan);
		Thread.sleep(3000);
		unit.getcheckediscommercial().click();
		unit.getpaymentplansave().click();
		softAssert.assertEquals(valid_paymentplan, "paymentplan is a Valid Alpha-Numeric");
	}

	//Edit paymentsplan types:
	@Test(dataProvider = "getEditdata")
	public void Edit_banks(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getEditpaymentplan().click();
		unit.getEditpaymentplandata().clear();
		unit.getEditpaymentplandata().sendKeys(PaymentsPlanpage1);
		String valid_string = valid_alphanum(PaymentsPlanpage1,"paymentplan",20);
		String valid_paymentplan = valid_string;
		System.out.println(valid_paymentplan);
		Thread.sleep(2000);
		unit.getEditpaymentplansave().click();

	}

	//Delete paymentsplan types:
	@Test
	public void Delete_Banks() throws InterruptedException {
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getDeletepaymentplanclick().click();
		paymentplan.getDeleteconfirmation().click();
	}

	//Searched paymentsplan types:
	@Test(dataProvider = "getsearched")
	public void Search_Banks(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage paymentplan = new PaymentsPlanpage(driver);
		paymentplan.getconfiguration().click();
		paymentplan.getseaechingpaymentplan().sendKeys(PaymentsPlanpage1);
		paymentplan.getsearchedclick().click();
	}

	@Test
	public void Add_validation_paymentplan() throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getaddpaymentplan().click();

		unit.getcheckediscommercial().click();
		unit.getpaymentplansave().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Payment Plan name is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("Payment Plan name is required", expectedMessage, actualMessage);
	}

	@Test
	public void Edit_validationpaymentsplan() throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getEditpaymentplan().click();
		for (int i = 1; i < 12; i++) {
			unit.getaddpaymentplandataenter().sendKeys(Keys.BACK_SPACE);
		}
		unit.getEditpaymentplansave().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Payment Plan name is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("Payment Plan name is required", expectedMessage, actualMessage);
		softAssert.assertAll();

	}
	//
	// close the driver
	//	@AfterMethod
	//	public void teaddown() {
	//		// driver.close();
	//	}

	//DataProvider for Add Payments Plan
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "paymentplan14" } };
	}

	// DataProvider for Apply searched for paymentsplan
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Googlepayplan12" } };
	}

}
