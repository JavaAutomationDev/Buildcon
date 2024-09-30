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

		// Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));  
        loginPage.getUserName().sendKeys(prop.getProperty("USER"));  
        loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");

		//screenshot capture
		@SuppressWarnings("unused")
		String screenshot= getscreenshot("Screenshot", driver);
	}
	//Customer List grid data
	@Test()
	public void Verify_Customer_List_Customer() throws InterruptedException {
		CustomerPage customer = new CustomerPage(driver);
		customer.getCustomer().click();
		customer.webElementList();
	}
	//Customer Search Method
	@Test(dataProvider="getSearchData")
	public void Search_Customer(String siteproject) throws InterruptedException {
		CustomerPage customer = new CustomerPage(driver);
		customer.getCustomer().click();
		Thread.sleep(2000);
		customer.getSearch().sendKeys(siteproject + Keys.ENTER);
	}

	//Customer Export to Excel Method
	@Test()
	public void Export_to_Excel_Customer() throws InterruptedException {
		CustomerPage customer = new CustomerPage(driver);
		customer.getCustomer().click();
		customer.webElementList();
		Thread.sleep(2000);
		customer.getExporttoExcel().click();
	}
	//Apply Filter Method for Project & Reset
	@Test(dataProvider="getprojectdropdownData")
	public void Apply_Filter_Project_Customer(String selectproject) throws InterruptedException {
		CustomerPage customer = new CustomerPage(driver);
		customer.getCustomer().click();
		customer.getapplyfilter().click();
		Thread.sleep(2000);
		customer.getselectproject(selectproject);
		customer.getradiobtn().click();
		customer.getresetfilter().click();
		customer.getDocumentview().click();
		customer.getFiles().click();
		customer.getdocument().click();
		Thread.sleep(2000);
		customer.getcross().click();
	}
	
	//Close the Driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	//DataProvider for search data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{ "project test"}};
	}
	//DataProvider for filter Project Dropdown
	@DataProvider
	public Object[][] getprojectdropdownData() {
		return new Object[][] {
			{"marin drive lake view"}};
	}

}