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
	public void InquiryFormTest1(String siteproject,String visitorname,String Attendee,
			String Number,String Email,String Source) throws InterruptedException {
		InquiryForm i = new InquiryForm(driver);
		i.getInquiry().click();
		i.getsiteproject(siteproject);
		i.getvisitor().sendKeys(visitorname);
		i.getAttendee().sendKeys(Attendee);;
		i.getContactNo().sendKeys(Number);
		i.getEmail().sendKeys(Email);
		i.getsource().sendKeys(Source);
        i.getsave().click();
	}
	//close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}
	//Add Inquiry Form data
	@DataProvider
	public Object[][] getdata() {
		return new Object[][] {
            {" Test Project1 ","Akash Patel", "Nilesh Panchal", "9746547979", "Akash@mail.com", "On Site" }};
	}
}