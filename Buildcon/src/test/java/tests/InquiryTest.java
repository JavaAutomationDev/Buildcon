package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.InquiryPage;
import pageObjects.LoginPage;
import resources.base;

public class InquiryTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Inquiry
	@Test(dataProvider = "getAdddata")
	public void Add_Inquiry(String siteproject, String visitorname, String NextfollowUpDT, String referencedBy,
			String Attende, String ContactNo, String Email, String Address, String Remarks, String Requirement,
			String Status) throws InterruptedException {
		//SoftAssert softAssert = new SoftAssert();
		//oftAssert.assertTrue("11".equals("11"), "The condition should be false but it is true.");
		
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();
		Inquiry.getsiteproject(siteproject);
		Inquiry.getvisitorname().sendKeys(visitorname);
		Inquiry.getIntime().click();// click on InTime
		Inquiry.getOk().click();// click on Ok time
		Inquiry.getouttime().click();// Click on OutTime
		Inquiry.getOk().click();// Click on Ok time
		Inquiry.getNextfollowUpDT().sendKeys(NextfollowUpDT);
		Inquiry.getreferencedBy().sendKeys(referencedBy);
		Inquiry.getAttendee(Attende);
		Inquiry.getContactNo().sendKeys(ContactNo);
		Inquiry.getEmail().sendKeys(Email);
		Inquiry.getAddress().sendKeys(Address);
		Inquiry.getRemarks().sendKeys(Remarks);
		Inquiry.getrequirement().sendKeys(Requirement);
		Inquiry.getstatus(Status);
		//Inquiry.getIsProspect().click();
		Thread.sleep(2000);
		Inquiry.getsave().click();
	}

	//Editing an existing Inquiry using Data Provider
	@Test(dataProvider = "getEditData")
	public void Edit_Inquiry(String newContactNo, String newEmail, String newAddress, String newRemarks,
			String newRequirement, String newStatus) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getEdit();
		Inquiry.getContactNo().clear();
		Inquiry.getContactNo().sendKeys(newContactNo);
		Inquiry.getEmail().clear();
		Inquiry.getEmail().sendKeys(newEmail);
		Inquiry.getAddress().clear();
		Inquiry.getAddress().sendKeys(newAddress);
		Inquiry.getRemarks().clear();
		Inquiry.getRemarks().sendKeys(newRemarks);
		Inquiry.getrequirement().clear();
		Inquiry.getrequirement().sendKeys(newRequirement);
		Inquiry.getstatus(newStatus);
		Thread.sleep(2000);
		Inquiry.getsave().click();
	}

	//Delete Inquiry
	@Test()
	public void Delete_Inquiry() throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getDelete();
		Thread.sleep(2000);
		Inquiry.getClickYes().click();
	}

	//Export to Excel Inquiry
	@Test()
	public void Export_to_Excel_Inquiry() throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getExporttoExcel().click();
	}

	//Apply Filter for Dates & Project
	@Test(dataProvider = "getprojectfilterData")
	public void Apply_Filter_Inquiry(String selectproject) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getapplyfilter().click();
		Inquiry.getdaterange().click();
		Inquiry.getSelectstartDate().click();
		Inquiry.getSelectEndDate().click();
		Thread.sleep(2000);
		Inquiry.getselectproject(selectproject);
		Thread.sleep(2000);
		Inquiry.getresetfilter().click();
	}

	//Apply Filter with Dates
	@Test()
	public void Apply_Filter_Dates_Inquiry() throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getapplyfilter().click();
		Inquiry.getdaterange().click();
		Inquiry.getSelectstartDate().click();
		Thread.sleep(2000);
		Inquiry.getSelectEndDate().click();
		Thread.sleep(2000);
		Inquiry.getresetfilter().click();
	}

	//Apply Filter with Project
	@Test(dataProvider = "getprojectfilterData")
	public void Apply_Filter_Project_Inquiry(String selectproject) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getapplyfilter().click();
		Inquiry.getselectproject(selectproject);
		Thread.sleep(5000);
		Inquiry.getresetfilter().click();
	}

	//Search Inquiry
	@Test(dataProvider = "getSearchData")
	public void Search_Inquiry(String Attende) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getSearch().sendKeys(Attende + Keys.ENTER);
		WebElement searchResult = Inquiry.getSearch();
		String resultText = searchResult.getText();
		Assert.assertFalse(resultText.contains(Attende));
	}

	//Todays Follow up Click,Search & Edit
	@Test(dataProvider = "getSearchData")
	public void Today_Follow_Inquiry(String visitorname) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.gettodayfollowup().click();
		Inquiry.getSearch().sendKeys(visitorname + Keys.ENTER);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.getsave().click();
	}

	//Missing Follow up for click,Search & Edit
	@Test(dataProvider = "getSearchData")
	public void Missing_Follow_Inquiry(String visitorname) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Inquiry.getSearch().sendKeys(visitorname + Keys.ENTER);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.getsave().click();
	}

	//Add To Prospect
	@Test(dataProvider = "getaddprospectData")
	public void Add_Prospect_Inquiry(String unitD, String Selectflat) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getAddprospect().click();
		Inquiry.getunitdropdown(unitD);
		Inquiry.getSelectFlat(Selectflat);
		Thread.sleep(2000);
		Inquiry.getClickYes().click();
	}
	@Test
	public void Testting()
	{
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();
		Inquiry.getsave().click();
		WebElement a = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		Assert.assertTrue(a.getText().equals("Vasdsadsadsadisit Site/Project is required."),"If both are not equal");
		
		WebElement b= driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[2]/mat-form-field/div[2]/div"));
		Assert.assertTrue(b.getText().equals("Visitor Name is required."),"If both are not equal");
			
	}

	//Close the driver
	@AfterMethod 
	public void teardown() {
		//driver.close(); 
	}

	//DataProvider for Add Inquiry
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { 
			{ "Taj Mahal", "Mahesh Patel", "", "Vimal Patel", " Nilesh Panchal ", "9746547979",
			"Akash@mail.com", "Bopal Gam, Ahmedabad", "Remarks", "4BHK", "In Progress" },
			{ "Taj Mahal", "Mahesh Patel", "", "Vimal Patel", " Nilesh Panchal ", "9746547979",
				"Akash@mail.com", "Bopal Gam, Ahmedabad", "Remarks", "4BHK", "In Progress" }
		};
	}

	//DataProvider for Edit Inquiry
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] { { "9876543210", "akash.new@mail.com", "Thaltej Square, Ahmedabad", "Updated Remarks",
			"5BHK", "Completed" } };
	}

	//DataProvider for Apply Filter for Project
	@DataProvider
	public Object[][] getprojectfilterData() {
		return new Object[][] { { "SHALIGRAM PRIDE" } };
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] { { "Rakesh Patel" } };
	}

	// DataProvider for Add Prospect Data
	@DataProvider
	public Object[][] getaddprospectData() {
		return new Object[][] { { " A ", " Unit No - 102 (1 Floor) " } };
	}
}