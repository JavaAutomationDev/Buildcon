package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.InquiryForm;
import pageObjects.LoginPage;
import resources.base;

public class InquiryFormTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver=initializeDriver();
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
	
	//Add Inquiry Form Data
	@Test(dataProvider = "getdata")
	public void Add_Inquiry_Form(String siteproject, String visitorname, String Attendee,
	                             String Number, String Email) throws InterruptedException {

	    InquiryForm inquiryForm = new InquiryForm(driver);
	    inquiryForm.getInquiry().click();
	    
	    inquiryForm.getsiteproject(siteproject);
	    inquiryForm.getvisitor().sendKeys(visitorname);
	    inquiryForm.getAttendee().sendKeys(Attendee);
	    inquiryForm.getContactNo().sendKeys(Number);
	    inquiryForm.getEmail().sendKeys(Email);

	    //Create SoftAssert instance to validate fields
	    SoftAssert softAssert = new SoftAssert();

	    //Validate that the fields are correctly filled with the provided data
	    softAssert.assertFalse(siteproject.isEmpty(), "Site Project is required.");
	    softAssert.assertFalse(visitorname.isEmpty(), "Visitor Name is required.");
	    softAssert.assertFalse(Attendee.isEmpty(), "Attendee is required.");
	    softAssert.assertFalse(Number.isEmpty(), "Contact Number is required.");
	    softAssert.assertTrue(Number.matches("\\d{10}"), "Contact Number must be 10 digits.");
	    
	    //Email validation: Check if it's filled and in the correct format
	    if (!Email.isEmpty()) {
	        softAssert.assertTrue(Email.matches("^[A-Za-z0-9+_.-]+@(.+)$"), "Email format is invalid.");
	    }

	    Thread.sleep(2000);
	    inquiryForm.getsave().click();

	    //Assert that all fields have been correctly validated
	    softAssert.assertAll();
	}
	
	//Close the driver
	@AfterMethod
	public void teardown() {
		driver.close(); 
	}

	//Add Inquiry Form Data
	@DataProvider
	public Object[][] getdata() {
		return new Object[][] {
			{"Taj Mahal","Akash Patel","Nilesh Panchal","9746547979","Akash@mail.com",}};
	}
	
}