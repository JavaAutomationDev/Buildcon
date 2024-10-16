package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.InquiryResponsepage;
import pageObjects.LoginPage;
import resources.base;

public class InquiryResponseTest extends base {

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
	public void Add_inquiryresponse(String InquiryResponsepage1) throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getAddInquiryResponsepageclick().click();
		unit.getAddInquiryResponsenewdata().sendKeys(InquiryResponsepage1);
		Thread.sleep(3000);
		unit.getInquiryresponsesave().click();
	}

	@Test(dataProvider = "getEditdata")
	public void Edit_inquiryresponse(String InquiryResponsepage1) throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getEditinquiryresponsetype().sendKeys(InquiryResponsepage1);
		unit.getEditinquiryresponsetype().click();

		unit.getEditinquiryresponsesave().click();

	}

	@Test
	public void Status_inquiryresponse() throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getChangeInquiryrsponsestatus().click();
		unit.getChangeInquiryresponseconfirm().click();
	}

	@Test
	public void delete_inquiryresponse() throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getInquiryresponsedeleteclick().click();
		unit.getInquiryresponsedeleteconfirmationk().click();
	}

	@Test(dataProvider = "getsearched")
	public void searched_inquiryresponse(String InquiryResponsepage1) throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getInquiryresponsesearched().sendKeys(InquiryResponsepage1);
		unit.getInquiryresponsesearchedclick().click();
	}

	@Test
	public void Excel_inquiryresponse() throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getinquiryresponseExcel().click();
	}

	// close the driver
	@AfterMethod
	public void teaddown() {
		// driver.close();
	}

	// DataProvider for Add paymentsplan
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Nishant" } };
	}
	
	// edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Sitops" } };
	}

	// DataProvider for Apply searched for paymentsplan
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "paymentmetthod" } };
	}

}
