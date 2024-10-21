package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DocumentPage;
import pageObjects.LoginPage;
import resources.base;

public class DocumentTest extends base {
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

	//Add Document
	@Test(dataProvider="DocumentAddData")
	public void Add_Document(String DTitle) throws InterruptedException {
		DocumentPage document = new DocumentPage(driver);
		document.getDocument().click();
		document.getAddDocument().click();
		document.getDocumentTitle().sendKeys(DTitle);
		
	}

	//Editing an existing Document using Data Provider
	@Test
	public void Edit_Document() throws InterruptedException {
		DocumentPage document = new DocumentPage(driver);
		document.getDocument().click();
		document.getAddDocument().click();
	}
	
	//Search Document
	@Test(dataProvider="DocumentSearchData")
	public void Search_Document(String Project) throws InterruptedException {
		DocumentPage document = new DocumentPage(driver);
		document.getDocument().click();
	}

	//Apply Filter Project Dropdown
	@Test()
	public void Apply_Filter_Document_Dropdown() throws InterruptedException {
		DocumentPage document = new DocumentPage(driver);
		document.getDocument().click();
	}
	
	//Apply Filter Reset
	@Test()
	public void Apply_Filter_Reset_Receipt() throws InterruptedException {
		DocumentPage document = new DocumentPage(driver);
		document.getDocument().click();
	}
	
	//Close the driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}	

	//DataProvider Add Document
	@DataProvider
	public Object[][] DocumentAddData() {
		return new Object[][] {
			{"Pan Card"}};
	}

	//DataProvider for Edit Document
	@DataProvider
	public Object[][] DocumentEditData() {
		return new Object[][] { 
			{ }};
	}

	//DataProvider for Search Document
	@DataProvider
	public Object[][] DocumentSearchData() {
		return new Object[][] {
			{ }};
	}
}