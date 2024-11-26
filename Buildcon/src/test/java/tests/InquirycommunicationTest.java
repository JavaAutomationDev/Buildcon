package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Inquiry Communication Mode
	@Test(dataProvider = "getAdddata")
	public void Add_Inquiry_Communication_Mode(String Inquirycommunication1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getInquirycommunicationmodeadd().click();
		
		Communication.getAddNewInquiryCommunicationMode().sendKeys(Inquirycommunication1);
		//Inquiry Communication Name Text Data Validation
		String valid_string = valid_alphanum(Inquirycommunication1, "inquirycommunicationmode", 10);
		String valid_inquirycommunicationmode = valid_string;
		System.out.println(valid_inquirycommunicationmode);
		
		Thread.sleep(1000);
		Communication.getsavebuttoninquirycommunication().click();
		
		softAssert.assertEquals(valid_inquirycommunicationmode, "inquirycommunication is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Edit Inquiry Communication Mode
	@Test(dataProvider = "getEditdata")
	public void Edit_Inquiry_Communication_Mode(String EditInquirycommunication1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getEditinquirycommunicationrow().click();
		
		Communication.getEditInquiryCommunicationMode().clear();
		Communication.getEditInquiryCommunicationMode().sendKeys(EditInquirycommunication1);
		//Inquiry communication Name Text Data Validation
		String valid_string = valid_alphanum(EditInquirycommunication1, "inquirycommunicationmode", 10);
		String valid_inquirycommunicationmode = valid_string;
		System.out.println(valid_inquirycommunicationmode);
		
		Thread.sleep(3000);
		Communication.geteditsavebuttoninquirycommunication().click();
		
		softAssert.assertEquals(valid_inquirycommunicationmode, "inquirycommunication is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Status Change Inquiry Communication Mode
	@Test
	public void Status_Change_Inquiry_Communication() throws InterruptedException {
		Inquirycommunicationmodepage unit = new Inquirycommunicationmodepage(driver);
		unit.getconfiguration().click();
		unit.getInquirycommunicationmodepageclick().click();
		unit.getchangestatusinquirycommunication().click();
		Thread.sleep(2000);
		unit.getchangestatusconfirmationinquirycommunication().click();
		Thread.sleep(2000);
	}
	// delete inquiry communication:
	@Test
	public void Delete_Inquiry_Communication() throws InterruptedException {
		Inquirycommunicationmodepage unit = new Inquirycommunicationmodepage(driver);
		unit.getconfiguration().click();
		unit.getInquirycommunicationmodepageclick().click();
		unit.getdeleteclickinquirycommunication().click();
		Thread.sleep(2000);
		unit.getdeleteclickconfirmationinquirycommunication().click();
		Thread.sleep(2000);
	}

	//Search Method
	@Test(dataProvider = "getsearcheds")
	public void Searching_Inquiry_Communication_Mode(String searchedentertextinquiry1) throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getsearchinquirycommunication().sendKeys(searchedentertextinquiry1);
		Communication.getclicksearchedbuttoninquirycommunication().click();
	}

	//Export Excel Inquiry Communication Mode
	@Test
	public void Export_Excel_Inquiry_Communication_Mode() throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getclickexportasexcelinquirycommunication().click();
	}
	
	//Add Validation Inquiry Communication Mode
	@Test
	public void Add_Validation_Inquiry_Communication_Mode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getInquirycommunicationmodeadd().click();

		Communication.getsavebuttoninquirycommunication().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Inquiry Communication Mode name is required";
		softAssert.assertEquals("Inquiry Communication Mode name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Edit Validation Inquiry Communication Mode
	@Test
	public void Edit_Validation_Inquiry_Communication_Mode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getEditinquirycommunicationrow().click();
		for (int i = 1; i <= 30; i++) {
			Communication.getEditInquiryCommunicationMode().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		Communication.geteditsavebuttoninquirycommunication().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Inquiry Communication Mode name is required";
		softAssert.assertEquals("Inquiry Communication Mode name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Close the driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	//DataProvider for Add 
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Inquiry125555555555" } };
	}

	//DataProvider for Edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "New123" } };
	}

	//DataProvider for Search
	@DataProvider
	public Object[][] getsearcheds() {
		return new Object[][] { { "communication" } };
	}
}