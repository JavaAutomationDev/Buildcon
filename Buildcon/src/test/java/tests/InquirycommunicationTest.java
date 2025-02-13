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

		// Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	// Add Inquiry Communication Mode
	@Test(dataProvider = "getAdddata",priority =1)
	public void Add_Inquiry_Communication_Mode(String Inquirycommunication1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirycommunicationmodepage inquirycommunication = new Inquirycommunicationmodepage(driver);
		inquirycommunication.getconfiguration().click();
		inquirycommunication.getInquirycommunicationmodepageclick().click();
		inquirycommunication.getInquirycommunicationmodeadd().click();

		inquirycommunication.getAddNewInquiryCommunicationMode().sendKeys(Inquirycommunication1);
		// Inquiry Communication Name Text Data Validation
		String valid_string = valid_alphanum(Inquirycommunication1, "inquirycommunicationmode", 30);
		String valid_inquirycommunicationmode = valid_string;
		System.out.println(valid_inquirycommunicationmode);

		Thread.sleep(1000);
		inquirycommunication.getsavebuttoninquirycommunication().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_inquirycommunicationmode,
				"inquirycommunicationmode is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	// Edit Inquiry Communication Mode
	@Test(dataProvider = "getEditdata",priority =2)
	public void Edit_Inquiry_Communication_Mode(String EditInquirycommunication1, String searchedentertextinquiry1)
			throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirycommunicationmodepage inquirycommunication = new Inquirycommunicationmodepage(driver);
		inquirycommunication.getconfiguration().click();
		inquirycommunication.getInquirycommunicationmodepageclick().click();
		inquirycommunication.getsearchinquirycommunication().sendKeys(searchedentertextinquiry1);
		inquirycommunication.getclicksearchedbuttoninquirycommunication().click();
		inquirycommunication.getEditinquirycommunicationrow().click();

		inquirycommunication.getEditInquiryCommunicationMode().clear();
		inquirycommunication.getEditInquiryCommunicationMode().sendKeys(EditInquirycommunication1);
		// Inquiry communication Name Text Data Validation
		String valid_string = valid_alphanum(EditInquirycommunication1, "inquirycommunicationmode", 50);
		String valid_inquirycommunicationmode = valid_string;
		System.out.println(valid_inquirycommunicationmode);

		Thread.sleep(3000);
		inquirycommunication.geteditsavebuttoninquirycommunication().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_inquirycommunicationmode,
				"inquirycommunicationmode is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	// Status Change Inquiry Communication Mode
	@Test(dataProvider = "getstatuschange",priority =3)
	public void Status_Change_Inquiry_Communication(String searchedentertextinquiry1) throws InterruptedException {
		Inquirycommunicationmodepage inquirycommunication = new Inquirycommunicationmodepage(driver);
		inquirycommunication.getconfiguration().click();
		inquirycommunication.getInquirycommunicationmodepageclick().click();
		inquirycommunication.getsearchinquirycommunication().sendKeys(searchedentertextinquiry1);
		inquirycommunication.getclicksearchedbuttoninquirycommunication().click();
		inquirycommunication.getchangestatusinquirycommunication().click();
		Thread.sleep(2000);
		inquirycommunication.getchangestatusconfirmationinquirycommunication().click();
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] getstatuschange() {
		return new Object[][] { { "Test Inq communication2" } };
	}

	// delete inquiry communication:
	@Test(dataProvider = "getdelete",priority =6)
	public void Delete_Inquiry_Communication(String searchedentertextinquiry1) throws InterruptedException {
		Inquirycommunicationmodepage inquirycommunication = new Inquirycommunicationmodepage(driver);
		inquirycommunication.getconfiguration().click();
		inquirycommunication.getInquirycommunicationmodepageclick().click();
		inquirycommunication.getsearchinquirycommunication().sendKeys(searchedentertextinquiry1);
		inquirycommunication.getclicksearchedbuttoninquirycommunication().click();
		inquirycommunication.getdeleteclickinquirycommunication().click();
		Thread.sleep(2000);
		inquirycommunication.getdeleteclickconfirmationinquirycommunication().click();
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] getdelete() {
		return new Object[][] { { "Test Inq communication4" } };
	}

	// Search Method
	@Test(dataProvider = "getsearcheds",priority =5)
	public void Searching_Inquiry_Communication_Mode(String searchedentertextinquiry1) throws InterruptedException {
		Inquirycommunicationmodepage inquirycommunication = new Inquirycommunicationmodepage(driver);
		inquirycommunication.getconfiguration().click();
		inquirycommunication.getInquirycommunicationmodepageclick().click();
		inquirycommunication.getsearchinquirycommunication().sendKeys(searchedentertextinquiry1);
		inquirycommunication.getclicksearchedbuttoninquirycommunication().click();
		Thread.sleep(2000);
	}

	// Export Excel Inquiry Communication Mode
	@Test(priority =4)
	public void Export_Excel_Inquiry_Communication_Mode() throws InterruptedException {
		Inquirycommunicationmodepage inquirycommunication = new Inquirycommunicationmodepage(driver);
		inquirycommunication.getconfiguration().click();
		inquirycommunication.getInquirycommunicationmodepageclick().click();
		inquirycommunication.getclickexportasexcelinquirycommunication().click();
		Thread.sleep(2000);
	}

	// Add Validation Inquiry Communication Mode
	@Test(priority =7)
	public void Add_Validation_Inquiry_Communication_Mode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getInquirycommunicationmodeadd().click();

		Communication.getsavebuttoninquirycommunication().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(
				By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/"
						+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Inquiry Communication Mode name is required";
		softAssert.assertEquals("Inquiry Communication Mode name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	// Edit Validation Inquiry Communication Mode
	@Test(priority =8)
	public void Edit_Validation_Inquiry_Communication_Mode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirycommunicationmodepage inquirycommunication = new Inquirycommunicationmodepage(driver);
		inquirycommunication.getconfiguration().click();
		inquirycommunication.getInquirycommunicationmodepageclick().click();
		inquirycommunication.getEditinquirycommunicationrow().click();
		int nm = inquirycommunication.getEditInquiryCommunicationMode().getAttribute("value").length();
		for (int i = 1; i <= nm; i++) {
			inquirycommunication.getEditInquiryCommunicationMode().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		inquirycommunication.geteditsavebuttoninquirycommunication().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(
				By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/"
						+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Inquiry Communication Mode name is required";
		softAssert.assertEquals("Inquiry Communication Mode name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	// Close the driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	// DataProvider for Add
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Test Inq communication1" }, { "Test Inq communication2" }, { "Test Inq communication3" }, { "Test Inq communication4" } };
	}

	// DataProvider for Edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Test Inq communication1 update", "Test Inq communication1" } };
	}

	// DataProvider for Search
	@DataProvider
	public Object[][] getsearcheds() {
		return new Object[][] { { "Test Inq communication4" } };
	}
}