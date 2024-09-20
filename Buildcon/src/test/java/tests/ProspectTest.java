package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProspectPage;
import resources.base;

public class ProspectTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver=initializeDriver();
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

	@Test(dataProvider="getAdddata")
	public void Add_Prospect(String siteproject,String visitorname,String visitordate,
			String NextfollowUpDT,String referencedBy,String Attende,String ContactNo,
			String Email,String Address,String Remarks,String Requirement,String Status,String unitD
			,String Selectflat) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();
		Prospect.getsiteproject(siteproject);
		Prospect.getvisitorname().sendKeys(visitorname);
		Prospect.getvisitordate().sendKeys(visitordate);
		Prospect.getIntime().click();//click on InTime
		Prospect.getOk().click();//click on Ok time
		Prospect.getouttime().click();//Click on OutTime
		Prospect.getOk().click();//Click on Ok time
		Prospect.getNextfollowUpDT().sendKeys(NextfollowUpDT);
		Prospect.getreferencedBy().sendKeys(referencedBy);
		Prospect.getAttendee(Attende);
		Prospect.getContactNo().sendKeys(ContactNo);
		Prospect.getEmail().sendKeys(Email);
		Prospect.getAddress().sendKeys(Address);
		Prospect.getRemarks().sendKeys(Remarks);
		Prospect.getrequirement().sendKeys(Requirement);
		Prospect.getstatus(Status);
		Prospect.getunitdropdown(unitD);
		Prospect.getSelectFlat(Selectflat);
		Prospect.getsave().click();
	}

	// Editing an existing inquiry using Data Provider
	@Test(dataProvider = "getEditData")
	public void Edit_Prospect(String newContactNo, String newEmail, String newAddress,
			String newRemarks, String newRequirement, String newStatus) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getEdit();
		Prospect.getContactNo().clear();
		Prospect.getContactNo().sendKeys(newContactNo);
		Prospect.getEmail().clear();
		Prospect.getEmail().sendKeys(newEmail);
		Prospect.getAddress().clear();
		Prospect.getAddress().sendKeys(newAddress);
		Prospect.getRemarks().clear();
		Prospect.getRemarks().sendKeys(newRemarks);
		Prospect.getrequirement().clear();
		Prospect.getrequirement().sendKeys(newRequirement);
		Prospect.getstatus(newStatus);
		Prospect.getsave().click();
	}
	//Delete Method
	@Test()
	public void Delete_Prospect() throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getDelete();
		Prospect.getClickYes().click();
	}
	//Export to excel Method
	@Test()
	public void ExporttoExcel_Prospect() throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getExporttoExcel().click();
	}
	//Apply Filter Method for dates & Project
	@Test(dataProvider="getprojectfilterData")
	public void ApplyFilter_Prospect(String selectproject) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getapplyfilter().click();
		Prospect.getdaterange().click();
		Prospect.getSelectstartDate().click();
		Prospect.getSelectEndDate().click();
		Prospect.getselectproject(selectproject);
		Prospect.getresetfilter().click();	
	}
	//Apply filter method for Dates
	@Test()
	public void ApplyFilterDates_Prospect() throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getapplyfilter().click();
		Prospect.getdaterange().click();
		Prospect.getSelectstartDate().click();
		Prospect.getSelectEndDate().click();
		Prospect.getresetfilter().click();	
	}
	//Apply Filter Method for Project & reset
	@Test(dataProvider="getprojectfilterData")
	public void ApplyFilterProject_Prospect(String selectproject) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getapplyfilter().click();
		Prospect.getselectproject(selectproject);
		Prospect.getresetfilter().click();
	}
	//Search Method for Prospect
	@Test(dataProvider="getSearchData")
	public void Search_Prospect(String Attende) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getSearch().sendKeys(Attende + Keys.ENTER);
		Prospect.getSearch().clear();
	} 
	//Todays Follow up click,Search & Edit method
	@Test(dataProvider="getSearchData")
	public void TodayFollow_Prospect(String visitorname) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.gettodayfollowup().click();
		Prospect.getSearch().sendKeys(visitorname + Keys.ENTER);
		Prospect.getEdit();
		Prospect.getsave().click();
	}
	//Missing Follow up for click,Search & Edit method
	@Test(dataProvider="getSearchData")
	public void MissingFollow_Prospect(String visitorname) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getmissingfollowup().click();
		Prospect.getSearch().sendKeys(visitorname + Keys.ENTER);
		Prospect.getEdit();
		Prospect.getsave().click();
	}
	//close the driver
	@AfterMethod
	public void teaddown() {
		//driver.close();
	}
	//DataProvider for Add Inquiry
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] {
			{"SHALIGRAM PRIDE","Mahesh Patel","","","Vimal Patel", "Chandni Chauhan", "9856214565", 
				"Akash@mail.com","Bopal Gam ,Ahmedabad","Remarks","4BHK","In Progress","A","Unit No - A - 101 (Ground Floor) "}};
	}
	//DataProvider for Edit Inquiry
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] {
			{"9876543210", "akash.new@mail.com", "New Address, Ahmedabad", "Updated Remarks", "5BHK", "Completed" }};
	}
	//DataProvider for filter Project Dropdown
	@DataProvider
	public Object[][] getprojectfilterData() {
		return new Object[][] {
			{"marin drive lake view"}};
	}
	//DataProvider for search data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{ "Rakesh Patel"}};
	}

}