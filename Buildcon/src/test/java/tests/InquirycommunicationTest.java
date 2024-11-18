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

	//Add Inquiry Communication Type
	@Test(dataProvider = "getAdddata")
	public void Add_inquirycommunication(String Inquirycommunication1) throws InterruptedException {
		Inquirycommunicationmodepage unit = new Inquirycommunicationmodepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquirycommunicationmodepageclick().click();
		unit.getInquirycommunicationmodeadd().click();
		unit.getAddNewInquiryCommunicationMode().sendKeys(Inquirycommunication1);
		// ----------inquiry communication Name Text Data Validation ------------
		String valid_string = valid_alphanum(Inquirycommunication1, "inquirycommunicationmode", 10);
		String valid_inquirycommunicationmode = valid_string;
		System.out.println(valid_inquirycommunicationmode);
		Thread.sleep(1000);
		unit.getsavebuttoninquirycommunication().click();
		softAssert.assertEquals(valid_inquirycommunicationmode, "inquirycommunication is a Valid Alpha-Numeric");
	}

	// Edit project types

	@Test(dataProvider = "getEditdata")
	public void Edit_inquirycommunication(String EditInquirycommunication1) throws InterruptedException {
		Inquirycommunicationmodepage unit = new Inquirycommunicationmodepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquirycommunicationmodepageclick().click();
		unit.getEditinquirycommunicationrow().click();
		unit.getEditInquiryCommunicationMode().clear();
		unit.getEditInquiryCommunicationMode().sendKeys(EditInquirycommunication1);
		// ----------inquiry communication Name Text Data Validation ------------
		String valid_string = valid_alphanum(EditInquirycommunication1, "inquirycommunicationmode", 10);
		String valid_inquirycommunicationmode = valid_string;
		System.out.println(valid_inquirycommunicationmode);
		Thread.sleep(3000);
		unit.geteditsavebuttoninquirycommunication().click();
		softAssert.assertEquals(valid_inquirycommunicationmode, "inquirycommunication is a Valid Alpha-Numeric");
	}

	//Status Method
	@Test
	public void Status_Change_Inquiry_Communication() throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getchangestatusinquirycommunication().click();
		Communication.getchangestatusconfirmationinquirycommunication().click();
	}

	//Delete Method
	@Test
	public void Delete_Inquiry_Communication() throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getdeleteclickinquirycommunication().click();
		Communication.getdeleteclickconfirmationinquirycommunication().click();
	}

	//Search Method
	@Test(dataProvider = "getsearcheds")
	public void searching_inquirycommunication(String searchedentertextinquiry1) throws InterruptedException {
		Inquirycommunicationmodepage unit = new Inquirycommunicationmodepage(driver);
		unit.getconfiguration().click();
		unit.getInquirycommunicationmodepageclick().click();
		unit.getsearchinquirycommunication().sendKeys(searchedentertextinquiry1);
		unit.getclicksearchedbuttoninquirycommunication().click();
	}

	@Test
	public void exportexcel_inquirycommunication() throws InterruptedException {
		Inquirycommunicationmodepage unit = new Inquirycommunicationmodepage(driver);
		unit.getconfiguration().click();
		unit.getInquirycommunicationmodepageclick().click();
		unit.getclickexportasexcelinquirycommunication().click();
	}

	@Test
	public void Add_validation_inquirycommunication() throws InterruptedException {
		Inquirycommunicationmodepage unit = new Inquirycommunicationmodepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquirycommunicationmodepageclick().click();
		unit.getInquirycommunicationmodeadd().click();

		unit.getsavebuttoninquirycommunication().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Inquiry Communication Mode name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Inquiry Communication Mode name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	@Test
	public void Edit_validation_inquirycommunication() throws InterruptedException {
		Inquirycommunicationmodepage unit = new Inquirycommunicationmodepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquirycommunicationmodepageclick().click();
		unit.getEditinquirycommunicationrow().click();
		for (int i = 1; i <= 30; i++) {
			unit.getEditInquiryCommunicationMode().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		unit.geteditsavebuttoninquirycommunication().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Inquiry Communication Mode name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Inquiry Communication Mode name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	@AfterMethod
	public void teaddown() {
		driver.close();
	}

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