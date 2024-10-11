package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Inquirystatuspage;
import pageObjects.LoginPage;
import resources.base;

public class InquiryStatusTest extends base {

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

	@Test(dataProvider = "getAdddata")
	public void Add_inquirystatus(String Inquirystatuspage1) throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getAddInquirystatusclick().click();
		unit.getAddInquirystatus().sendKeys(Inquirystatuspage1);
		Thread.sleep(3000);
		unit.getAddInquirystatussave().click();
	}

	@Test(dataProvider = "getEditdata")
	public void Edit_inquirystatus(String Inquirystatuspage1) throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getEditInquirystatus().click();
		
		unit.getEditInquirystatussave().click();

	}

	@Test
	public void Status_inquirystatus() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getChangeInquirystatus().click();
		unit.getChangeInquirystatusconfirm().click();
	}
	
	@Test(dataProvider = "getdeletedata")
	public void delete_inquirystatus() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getInquirystatusdeleteclick().click();
		
		unit.getInquirystatusdeleteconfirmationk().click();

	}

	@Test(dataProvider = "getsearched")
	public void searched_inquirystatus(String Inquirystatuspage1) throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getInquirystatussearched().sendKeys(Inquirystatuspage1);
		unit.getInquirystatussearchedclick().click();
	}

	@Test
	public void Excel_inquirystatus(String PaymentsPlanpage1) throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getinquiryExcel().click();
	}

//	// close the driver
//	@AfterMethod
//	public void teaddown() {
//		// driver.close();
//	}

	// DataProvider for Add paymentsplan
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "newinquirystatus" } };
	}

	// DataProvider for Apply searched for paymentsplan
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "Nishant" } };
	}

}
