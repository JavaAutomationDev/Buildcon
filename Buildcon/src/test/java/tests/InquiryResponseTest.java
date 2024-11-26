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

import pageObjects.InquiryResponsepage;
import pageObjects.LoginPage;
import resources.base;

public class InquiryResponseTest extends base {

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

	//Add Method
	@Test(dataProvider = "getAdddata")
	public void Add_Inquiryresponse(String InquiryResponsepage1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getAddInquiryResponsepageclick().click();
		
		Inquiryresponse.getAddInquiryResponsenewdata().sendKeys(InquiryResponsepage1);
		//Inquiry Response type  Name Text Data Validation
		String valid_string = valid_alphanum(InquiryResponsepage1, "inquiryresponse", 10);
		String valid_inquiryresponse = valid_string;
		System.out.println(valid_inquiryresponse);
		
		Thread.sleep(3000);
		Inquiryresponse.getInquiryresponsesave().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_inquiryresponse, "inquiryresponse is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Edit Method
	@Test(dataProvider = "getEditdata")
	public void Edit_Inquiryresponse(String InquiryResponsepage2) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Inquiryresponse.getInquiryResponsepageclick().click();
	    Inquiryresponse.getEditinquiryresponsetype().click();
	 
	    Inquiryresponse.getEditinquiryresponsetypeenter().clear();
		Inquiryresponse.getEditinquiryresponsetypeenter().sendKeys(InquiryResponsepage2);
		String valid_string = valid_alphanum(InquiryResponsepage2, "inquiryresponse", 10);
		String valid_inquiryresponse = valid_string;
		System.out.println(valid_inquiryresponse);
		
		Thread.sleep(3000);
		Inquiryresponse.getEditinquiryresponsesave().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_inquiryresponse, "inquiryresponse is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Status Inquiry Response
	@Test
	public void Status_Inquiryresponse() throws InterruptedException {
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getChangeInquiryrsponsestatus().click();
		Thread.sleep(2000);
		Inquiryresponse.getChangeInquiryresponseconfirm().click();
		Thread.sleep(2000);
	}

	//Delete Method
	@Test
	public void Delete_Inquiryresponse() throws InterruptedException {
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getInquiryresponsedeleteclick().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryresponsedeleteconfirmationk().click();
		Thread.sleep(2000);
	}

	//Search Method
	@Test(dataProvider = "getsearched")
	public void searched_inquiryresponse(String InquiryResponsepage1) throws InterruptedException {
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getInquiryresponsesearched().sendKeys(InquiryResponsepage1);
		Inquiryresponse.getInquiryresponsesearchedclick().click();
		Thread.sleep(2000);
	}

	//Excel Inquiry Response
	@Test
	public void Excel_inquiryresponse() throws InterruptedException {
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getinquiryresponseExcel().click();
		Thread.sleep(2000);
	}

	//Add Validation Inquiry Response
	@Test
	public void Add_validation_Inquiryresponse() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getAddInquiryResponsepageclick().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryresponsesave().click();
		Thread.sleep(2000);

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Inquiry Response Type name is required";
		softAssert.assertEquals("Inquiry Response Type name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Edit Validation Inquiryresponse
	@Test
	public void Edit_Validation_Inquiryresponse() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Inquiryresponse.getInquiryResponsepageclick().click();
		Thread.sleep(2000);
		Inquiryresponse.getEditinquiryresponsetype().click();
		for (int i = 1; i <= 15; i++) {
			Inquiryresponse.getEditinquiryresponsetypeenter().sendKeys(Keys.BACK_SPACE);
		}
		;
		Inquiryresponse.getEditinquiryresponsesave().click();
		Thread.sleep(2000);

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Inquiry Response Type name is required";
		softAssert.assertEquals("Inquiry Response Type name is required", expectedMessage, actualMessage);
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
		return new Object[][] { { "Nishant12" } };
	}

	//DataProvider for Edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Sitops123" } };
	}

	//DataProvider for Apply Searched
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { {"paymentmetthod"} };
	}
}