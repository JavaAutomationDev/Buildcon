package tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CustomerPage;
import pageObjects.LoginPage;
import resources.base;

public class CustomerTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver=initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		//Login Process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));  
        loginPage.getUserName().sendKeys(prop.getProperty("USER"));  
        loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");		
	}
	
	//Customer Search Method
	@Test(dataProvider="CustomerSearchData",priority=1)
	public void Search_Customer(String siteproject) throws InterruptedException {
		CustomerPage customer = new CustomerPage(driver);
		customer.getCustomer().click();
		Thread.sleep(2000);
		customer.getSearch().sendKeys(siteproject.trim() + Keys.ENTER);
	}

	//Customer Export to Excel Method
	@Test(priority=2)
	public void Export_To_Excel_Customer() throws InterruptedException {
		CustomerPage customer = new CustomerPage(driver);
		customer.getCustomer().click();
		Thread.sleep(2000);
		customer.getExporttoExcel().click();
		Thread.sleep(2000);
	}
	
	//Apply Filter Method for Project & Reset
	@Test(dataProvider="CustomerProjectDropdownData",priority=3)
	public void Apply_Filter_Project_Customer(String selectproject) throws InterruptedException {
		CustomerPage customer = new CustomerPage(driver);
		customer.getCustomer().click();
		customer.getapplyfilter().click();
		Thread.sleep(2000);
		customer.getselectproject(selectproject.trim());
		Thread.sleep(2000);
		customer.getresetfilter().click();
		Thread.sleep(2000);
		customer.getDocumentview().click();
		Thread.sleep(2000);
		customer.getFiles().click();
		Thread.sleep(2000);
		customer.getdocument().click();
		Thread.sleep(2000);
		customer.getcross().click();
	}
	
	//Apply Filter Method for Project Cancel
	@Test(dataProvider="CustomerProjectDropdownData",priority=4)
	public void Apply_Filter_Project_Customer_Cancel(String selectproject) throws InterruptedException {
		CustomerPage customer = new CustomerPage(driver);
		customer.getCustomer().click();
		customer.getapplyfilter().click();
		Thread.sleep(2000);
		customer.getselectproject(selectproject.trim());
		Thread.sleep(2000);
		customer.getCancelRadioBtn().click();
	}
	
	//Close the Driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	//DataProvider for Search data
	@DataProvider
	public Object[][] CustomerSearchData() {
		return new Object[][] {
			{ "Automation Project1"}};
	}
	
	//DataProvider for Filter Project Dropdown
	@DataProvider
	public Object[][] CustomerProjectDropdownData() {
		return new Object[][] {
			{"Automation Project1"}};
	}
}