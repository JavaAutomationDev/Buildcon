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
	public void Add_inquiryresponse(String InquiryResponsepage1) throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getAddInquiryResponsepageclick().click();
		unit.getAddInquiryResponsenewdata().sendKeys(InquiryResponsepage1);
		// inquiry response type  Name Text Data Validation ---------------------------------
		String valid_string = valid_alphanum(InquiryResponsepage1, "inquiryresponse", 10);
		String valid_inquiryresponse = valid_string;
		System.out.println(valid_inquiryresponse);
		Thread.sleep(3000);
		unit.getInquiryresponsesave().click();
		softAssert.assertEquals(valid_inquiryresponse, "inquiryresponse is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
		
	}

	//Edit Method
	@Test(dataProvider = "getEditdata")
	public void Edit_inquiryresponse(String InquiryResponsepage2) throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
	    unit.getEditinquiryresponsetype().click();
	    unit.getEditinquiryresponsetypeenter().clear();
		unit.getEditinquiryresponsetypeenter().sendKeys(InquiryResponsepage2);
		String valid_string = valid_alphanum(InquiryResponsepage2, "inquiryresponse", 10);
		String valid_inquiryresponse = valid_string;
		System.out.println(valid_inquiryresponse);
		Thread.sleep(3000);
		unit.getEditinquiryresponsesave().click();
		softAssert.assertEquals(valid_inquiryresponse, "inquiryresponse is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();

	}

	//Status Method
	@Test
	public void Status_inquiryresponse() throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getChangeInquiryrsponsestatus().click();
		Thread.sleep(2000);
		unit.getChangeInquiryresponseconfirm().click();
	}

	//Delete Method
	@Test
	public void delete_inquiryresponse() throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getInquiryresponsedeleteclick().click();
		Thread.sleep(2000);
		unit.getInquiryresponsedeleteconfirmationk().click();
	}

	//Search Method
	@Test(dataProvider = "getsearched")
	public void searched_inquiryresponse(String InquiryResponsepage1) throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getInquiryresponsesearched().sendKeys(InquiryResponsepage1);
		unit.getInquiryresponsesearchedclick().click();
	}

	@Test
	public void Excel_inquiryresponse() throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getinquiryresponseExcel().click();
	}

	@Test
	public void Add_validation_inquiryresponse() throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getAddInquiryResponsepageclick().click();

		unit.getInquiryresponsesave().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Inquiry Response Type name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Inquiry Response Type name is required", expectedMessage, actualMessage);
	}

	@Test
	public void Edit_validation_inquiryresponse() throws InterruptedException {
		InquiryResponsepage unit = new InquiryResponsepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquiryResponsepageclick().click();
		unit.getEditinquiryresponsetype().click();
		for (int i = 1; i <= 15; i++) {
			unit.getEditinquiryresponsetypeenter().sendKeys(Keys.BACK_SPACE);
		}
		;
		unit.getEditinquiryresponsesave().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Inquiry Response Type name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Inquiry Response Type name is required", expectedMessage, actualMessage);

	}

	// close the driver
	@AfterMethod
	public void teardown() {
		 driver.close();
	}

	//DataProvider for Add
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Nishant123444444" } };
	}

	// edit
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