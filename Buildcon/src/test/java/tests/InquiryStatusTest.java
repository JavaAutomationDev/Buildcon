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

		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Inquiry Status
	@Test(dataProvider = "getAdddata")
	public void Add_inquirystatus(String Inquirystatuspage1) throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getAddInquirystatusclick().click();
		unit.getAddInquirystatus().sendKeys(Inquirystatuspage1);
		 //data validation of the inquirystatus
		 
		String valid_string = valid_alphanum(Inquirystatuspage1,"inquirystatuspage",10);
		String valid_inquirystatuspage = valid_string;
		System.out.println(valid_inquirystatuspage);
		Thread.sleep(3000);
		unit.getAddInquirystatussave().click();
		softAssert.assertEquals(valid_inquirystatuspage, "inquirystatus is a Valid Alpha-Numeric");
		
	}

	//Edit Inquiry Status
	@Test(dataProvider = "getEditdata")
	public void Edit_inquirystatus(String Inquirystatuspage1) throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getEditInquirystatus().click();
		unit.getEditInquirystatusnew().clear();
		unit.getEditInquirystatusnew().sendKeys(Inquirystatuspage1);
		String valid_string = valid_alphanum(Inquirystatuspage1,"inquirystatuspage",10);
		String valid_inquirystatuspage = valid_string;
		System.out.println(valid_inquirystatuspage);
		Thread.sleep(3000);
		unit.getEditInquirystatussave().click();
		softAssert.assertEquals(valid_inquirystatuspage, "inquirystatus is a Valid Alpha-Numeric");

	}

	//Status Inquiry
	@Test
	public void Status_Inquiry_Status() throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getChangeInquirystatus().click();
		Inquirystatus.getChangeInquirystatusconfirm().click();
	}
	
	@Test
	public void delete_inquirystatus() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getInquirystatusdeleteclick().click();
		
		unit.getInquirystatusdeleteconfirmationk().click();

	}

	//Search Inquiry Status
	@Test(dataProvider = "getsearched")
	public void Searched_Inquiry_Status(String Inquirystatuspage1) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(Inquirystatuspage1);
		Inquirystatus.getInquirystatussearchedclick().click();
	}

	//Excel Inquiry
	@Test
	public void Excel_inquirystatus() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getinquiryExcel().click();
	}
	
	@Test
	public void Add_validation_inquirystatus() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getAddInquirystatusclick().click();
		unit.getAddInquirystatussave().click();
		
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Inquiry Status name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Inquiry Status name is required", expectedMessage, actualMessage);
	}
    
	

	@Test
	public void Edit_validation_inquirystatus() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getEditInquirystatus().click();
		for(int i=0;i<15;i++) {
			unit.getEditInquirystatusnew().sendKeys(Keys.BACK_SPACE);
		}
		unit.getEditInquirystatussave().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Inquiry Status name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Inquiry Status name is required", expectedMessage, actualMessage);
      
	}
	 //close the driver
	@AfterMethod
	public void teaddown() {
		 driver.close();
	}

	//DataProvider for Add 
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { {"inquiry123"}};
	}
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "inquiry888" } };
	}

	//DataProvider for Apply Searched
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "Nishant" } };
	}
}