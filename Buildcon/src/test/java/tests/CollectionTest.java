package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CollectionPage;
import pageObjects.LoginPage;
import resources.base;

public class CollectionTest extends base {

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
	}
	
	//Collection total collection Method
	@Test()
	public void Total_Collection_Collection() throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getTotalCollection().click();
		collection.getcross().click();
	}
	//Collection Search Method
	@Test(dataProvider="getSearchData")
	public void Search_Collection(String siteproject) throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getSearch().sendKeys(siteproject + Keys.ENTER);
		collection.getSearch().clear();
	}
	//Collection Export to excel Method
	@Test()
	public void Export_to_Excel_Collection() throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getExporttoExcel().click();
	}
	//Apply Filter Method for Dates
	@Test()
	public void Apply_Filter_Dates_Collection() throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getapplyfilter().click();
		collection.getdaterange().click();
		collection.getSelectstartDate().click();
		collection.getSelectEndDate().click();
		collection.getresetfilter().click();	
	}
	//close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	//DataProvider for search data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"Taj Mahal"}};
	}
}