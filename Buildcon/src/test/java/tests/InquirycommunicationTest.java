package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Inquirycommunicationmodepage;
import pageObjects.LoginPage;
import resources.base;

public class InquirycommunicationTest extends base {

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

	// Add inquiry communication types
	@Test(dataProvider = "getAdddata")
	public void Add_inquirycommunication(String Inquirycommunication1 ) throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getInquirycommunicationmodeadd().click();
		Communication.getAddNewInquiryCommunicationMode().sendKeys(Inquirycommunication1);
		Thread.sleep(1000);
		Communication.getsavebuttoninquirycommunication().click();
	}
	//Edit project types
	@Test(dataProvider = "getEditdata")
	public void Edit_inquirycommunication(String EditInquirycommunication1) throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getEditinquirycommunicationrow().click();
		Communication.getEditInquiryCommunicationMode().clear();
		Communication.getEditInquiryCommunicationMode().sendKeys(EditInquirycommunication1);
		Thread.sleep(3000);
		Communication.geteditsavebuttoninquirycommunication().click();
	}

	@Test
	public void statuschange_inquirycommunication() throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getchangestatusinquirycommunication().click();
		Communication.getchangestatusconfirmationinquirycommunication().click();
	}

	@Test
	public void Delete_inquirycommunication() throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getdeleteclickinquirycommunication().click();
		Communication.getdeleteclickconfirmationinquirycommunication().click();
	}

	@Test(dataProvider = "getsearcheds")
	public void searching_inquirycommunication(String searchedentertextinquiry1) throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getsearchinquirycommunication().sendKeys(searchedentertextinquiry1);
		Communication.getclicksearchedbuttoninquirycommunication().click();
	}
	
	@Test
	public void exportexcel_inquirycommunication() throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getclickexportasexcelinquirycommunication().click();
	}

	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Inquirycommunicationmodes" } };
	}

	// DataProvider for edit state
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Newcommunication" } };
	}

	@DataProvider
	public Object[][] getsearcheds() {
		return new Object[][] { {"communication"} };
	}
}
