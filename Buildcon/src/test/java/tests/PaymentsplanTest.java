package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

		// Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	// Add paymentsplan types:
	
	@Test(dataProvider = "getAdddata")
	public void Add_banks(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getaddpaymentplan().click();
		unit.getaddpaymentplan().sendKeys(PaymentsPlanpage1);
		Thread.sleep(3000);
		unit.getcheckediscommercial().click();
		unit.getpaymentplansave().click();
	}
	
	
	
	// Edit paymentsplan types:

	@Test(dataProvider = "getEditdata")
	public void Edit_banks(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		unit.getconfiguration().click();
		unit.getpaymentplan().click();
		unit.getEditpaymentplan().click();
		unit.getEditpaymentplansave().click();
		
	}
    
	// delete paymentsplan types:
	
	@Test
	public void Delete_banks() throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		unit.getconfiguration().click();
		unit.getDeletepaymentplanclick().click();
		unit.getDeleteconfirmation().click();
	}
	
	// Searched  paymentsplan types:
	@Test(dataProvider = "getsearched")
	public void searched_banks(String PaymentsPlanpage1) throws InterruptedException {
		PaymentsPlanpage unit = new PaymentsPlanpage(driver);
		unit.getconfiguration().click();
		unit.getseaechingpaymentplan().sendKeys(PaymentsPlanpage1);
		unit.getsearchedclick().click();
	}

//	// close the driver
//	@AfterMethod
//	public void teaddown() {
//		// driver.close();
//	}

	// DataProvider for Add paymentsplan
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { {"paymentplan"} };
	}

	

	// DataProvider for Apply searched for paymentsplan
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "paymentplan " } };
	}

}
