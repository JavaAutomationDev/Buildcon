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

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));  
        loginPage.getUserName().sendKeys(prop.getProperty("USER"));  
        loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}
	
	//Collection Total Method
	@Test()
	public void Total_Collection() throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getTotalCollection().click();
		collection.getcross().click();
	}
	
	//Collection Search Method
	@Test(dataProvider="CollectionSearchData")
	public void Search_Collection(String siteproject) throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getSearch().sendKeys(siteproject + Keys.ENTER);
		collection.getSearch().clear();
	}
	
	//Collection Export To Excel Method
	@Test()
	public void Export_To_Excel_Collection() throws InterruptedException {
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
	
	//Apply Filter Method for Project
	@Test(dataProvider="ApplyFilterProjectData")
	public void Apply_Filter_Project_Collection(String projectname) throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getapplyfilter().click();
		collection.getProjcetdropdown(projectname);
		collection.getresetfilter().click();	
	}
	
	//Collection Information Method
	@Test(dataProvider="InformationCollection")
	public void Information_Collection(String unitno) throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getSearch().sendKeys(unitno + Keys.ENTER);
		collection.getInfoBtn().click();
		Thread.sleep(2000);
        collection.getPrintInfoBtn().click();
	}
	
	//Print Collection Receipt Method
	@Test(dataProvider="PrintCollectionReceipt")
	public void Print_Collection_Receipt(String unitno) throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getSearch().sendKeys(unitno + Keys.ENTER);
		collection.getInfoBtn().click();
		Thread.sleep(2000);
        collection.getPrintInfoBtn().click();
	}
	
	//Download Collection Receipt Method
	@Test(dataProvider="DownloadCollectionReceipt")
	public void Download_Collection_Receipt(String unitno) throws InterruptedException {
		CollectionPage collection = new CollectionPage(driver);
		collection.getcollection().click();
		collection.getSearch().sendKeys(unitno + Keys.ENTER);
		collection.getInfoBtn().click();
		Thread.sleep(2000);
		collection.getDownloadReceiptBtn().click();
	}
		
	//Close the driver
	@AfterMethod
	public void teaddown() {
		//driver.close();
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] CollectionSearchData() {
		return new Object[][] {
			{"Taj Mahal"}};
	}
	
	//DataProvider for Apply Filter Project Data
	@DataProvider
	public Object[][] ApplyFilterProjectData() {
		return new Object[][] {
			{" Automation Project1 "}};
	}
		
	//DataProvider for Information Collection
	@DataProvider
	public Object[][] InformationCollection() {
		return new Object[][] {
			{" 3BHKsss NO - 103 "}};
	}
	
	//DataProvider for Print Collection Receipt
	@DataProvider
	public Object[][] PrintCollectionReceipt() {
		return new Object[][] {
			{" 3BHKsss NO - 103 "}};
	}
	
	//DataProvider for Download Collection Receipt
	@DataProvider
	public Object[][] DownloadCollectionReceipt() {
		return new Object[][] {
			{" 3BHKsss NO - 103 "}};
	}
	
}