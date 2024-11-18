
package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	@Test(dataProvider = "InquiryFormAdddata")
	public void Add_Inquiry_Form(String siteproject,String visitorname,String Attendee,String Number,
			String Email) throws InterruptedException {
		InquiryForm inquiryForm = new InquiryForm(driver);
		inquiryForm.getInquiry().click();

		inquiryForm.getsiteproject(siteproject);
		inquiryForm.getvisitor().sendKeys(visitorname);
		inquiryForm.getAttendee().sendKeys(Attendee);
		inquiryForm.getContactNo().sendKeys(Number);
		inquiryForm.getEmail().sendKeys(Email);	   
		Thread.sleep(2000);
		inquiryForm.getsave().click();
	}

	//Add Inquiry Form Test Mandatory Filed Validation
	@Test
	public void Add_Prospect_Test_Mandatory_Filed_Validation() throws InterruptedException {
		InquiryForm inquiryForm = new InquiryForm(driver);
		inquiryForm.getInquiry().click();
		inquiryForm.getsave().click();

		SoftAssert softAssert = new SoftAssert();
		WebElement Web =driver.findElement(By.xpath("//span[normalize-space()='Visit Site/Project is required.']"));
		softAssert.assertEquals(Web.getText(), "Visit Site/Project is required.");

		WebElement VisitorName =driver.findElement(By.xpath("//span[normalize-space()='Visitor Name is required.']"));
		softAssert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement ContactNo =driver.findElement(By.xpath("//span[normalize-space()='Contact Number is required.']"));
		softAssert.assertEquals(ContactNo.getText(), "Contact Number is required.");	
		softAssert.assertAll();
	}

	//Close the driver
	@AfterMethod
	public void teardown() {
		driver.close(); 
	}

	//Add Inquiry Form Data
	@DataProvider
	public Object[][] InquiryFormAdddata() {
		return new Object[][] {
			{"Taj Mahal1","Akash Patel", "Nilesh Panchal", "9746547979", "Akash@mail.com"}};
	}
}
