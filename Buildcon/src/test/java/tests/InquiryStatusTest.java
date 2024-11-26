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

import pageObjects.Inquirystatuspage;
import pageObjects.LoginPage;
import resources.base;

public class InquiryStatusTest extends base {

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

	// Add Inquiry Status
	@Test(dataProvider = "getAdddata")
	public void Add_Inquiry_Status(String Inquirystatuspage1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Thread.sleep(2000);
		Inquirystatus.getAddnewInquirystatus().click();
		Thread.sleep(1000);
		Inquirystatus.getAddInquirystatus().sendKeys(Inquirystatuspage1);
		String valid_string = valid_alphanum(Inquirystatuspage1, "inquirystatuspage", 20);
		String valid_inquirystatuspage = valid_string;
		System.out.println(valid_inquirystatuspage);
		Thread.sleep(3000);
		Inquirystatus.getAddInquirystatussave().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_inquirystatuspage,
				"inquirystatuspage is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();

	}

	// Edit Inquiry Status
	@Test(dataProvider = "getEditdata")
	public void Edit_inquirystatus(String inqsearched, String Inquirystatuspage1) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(inqsearched);
		Thread.sleep(2000);
		Inquirystatus.getInquirystatussearchedclick().click();
		Inquirystatus.getEditInquirystatus().click();
		Inquirystatus.getEditInquirystatusnew().click();
		Inquirystatus.getEditInquirystatusnew().clear();
		Inquirystatus.getEditInquirystatusnew().sendKeys(Inquirystatuspage1);
		String valid_string = valid_alphanum(Inquirystatuspage1, "inquirystatuspage", 10);
		String valid_inquirystatuspage = valid_string;
		System.out.println(valid_inquirystatuspage);
		Thread.sleep(3000);
		Inquirystatus.getEditInquirystatussave().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_inquirystatuspage,
				"inquirystatuspage is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();

	}

	// Status Inquiry
	@Test(dataProvider = "getstatuschanged")

	public void Status_inquirystatus(String inqsearched) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(inqsearched);
		Thread.sleep(2000);
		Inquirystatus.getInquirystatussearchedclick().click();
		Inquirystatus.getChangeInquirystatus().click();
		Inquirystatus.getChangeInquirystatusconfirm().click();
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] getstatuschanged() {
		return new Object[][] { { "inqsta123", } };
	}

	@Test(dataProvider = "getdelete")
	public void delete_inquirystatus(String inqsearched) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(inqsearched);
		Thread.sleep(2000);
		Inquirystatus.getInquirystatussearchedclick().click();
		Inquirystatus.getInquirystatusdeleteclick().click();
		Thread.sleep(2000);
		Inquirystatus.getInquirystatusdeleteconfirmationk().click();
		Thread.sleep(2000);

	}

	@DataProvider
	public Object[][] getdelete() {
		return new Object[][] { { "tips123" } };
	}

	// Search Inquiry Status
	@Test(dataProvider = "getsearched")
	public void searched_inquirystatus(String Inquirystatuspage1) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(Inquirystatuspage1);
		Thread.sleep(2000);
		Inquirystatus.getInquirystatussearchedclick().click();
		Thread.sleep(2000);
	}

	// Excel Inquiry
	@Test
	public void Excel_inquirystatus() throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getinquiryExcel().click();
		Thread.sleep(2000);
	}

	@Test
	public void Add_Validation_Inquiry_Status() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getAddnewInquirystatus().click();
		Inquirystatus.getAddInquirystatussave().click();
		Thread.sleep(2000);

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Inquiry Status name is required";
		softAssert.assertEquals("Inquiry Status name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
		softAssert.assertAll();
	}

	@Test(dataProvider = "geteditmandatory")
	public void Edit_validation_inquirystatus(String inqsearched) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(inqsearched);
		Thread.sleep(2000);
		Inquirystatus.getInquirystatussearchedclick().click();
		Inquirystatus.getEditInquirystatus().click();
		Inquirystatus.getEditInquirystatusnew().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatusnew().clear();
		Thread.sleep(1000);
		// Inquirystatus.getEditInquirystatusclick().click();
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		Inquirystatus.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);

		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Inquiry Status name is required";
		softAssert.assertEquals("Inquiry Status name is required", expectedMessage, actualMessage);
		softAssert.assertAll();

	}

	@DataProvider
	public Object[][] geteditmandatory() {
		return new Object[][] { { "inqsta123", } };
	}

	// close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	// DataProvider for Add
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "approvedatatus123", } };
	}

	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "approvedatatus123", "inqsta123" } };
	}

	// DataProvider for Apply Searched
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "Nishant" } };
	}
}