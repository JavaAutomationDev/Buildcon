package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	//Add Inquiry form data
	@Test(dataProvider="getdata")
	public void Add_Inquiry_Form(String siteproject,String visitorname,String Attendee,
			String Number,String Email,String Source) throws InterruptedException {
		InquiryForm inquiryForm = new InquiryForm(driver);
		inquiryForm.getInquiry().click();
		inquiryForm.getsiteproject(siteproject);
		inquiryForm.getvisitor().sendKeys(visitorname);
		inquiryForm.getAttendee().sendKeys(Attendee);;
		inquiryForm.getContactNo().sendKeys(Number);
		inquiryForm.getEmail().sendKeys(Email);
		inquiryForm.getsource().sendKeys(Source);
		inquiryForm.getsave().click();
	}
	//close the driver
	@AfterMethod
	public void teardown() {
		driver.close(); 
	}

	//Add Inquiry Form data
	@DataProvider
	public Object[][] getdata() {
		return new Object[][] {
			{"Taj Mahal","Akash Patel", "Nilesh Panchal", "9746547979", "Akash@mail.com", "On Site" }};
	}
}