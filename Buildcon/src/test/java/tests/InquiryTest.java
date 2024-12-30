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

import pageObjects.EmployeePage;
import pageObjects.InquiryPage;
import pageObjects.InquiryResponsepage;
import pageObjects.Inquirycommunicationmodepage;
import pageObjects.Inquirystatuspage;
import pageObjects.LoginPage;
import pageObjects.ProjectPage;
import pageObjects.SelectfilterDatesPage;
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
	@Test(dataProvider = "InquiryAdddata",priority=1)
	public void Add_Inquiry(String siteproject, String visitorname, String NextfollowUpDT, String referencedBy,
			String Attende, String ContactNo, String Email, String Address, String Remarks, String Requirement,
			String Status) throws InterruptedException, IOException {

		SoftAssert softAssert = new SoftAssert();
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();

		Thread.sleep(2000);
		softAssert.assertFalse(siteproject.isEmpty(), "Visit Site/Project is required.");
		Inquiry.getsiteproject(siteproject);

		Inquiry.getvisitorname().sendKeys(visitorname);
		softAssert.assertFalse(visitorname.isEmpty(), "Visitor Name is required.");
		//Visitor Name Text Data Validation
		String valid_string = validateText(visitorname,"VisitorName", 5, 30);
		String valid_visitorname = valid_string;
		System.out.println(valid_visitorname);

		Inquiry.getIntime().click(); //click on InTime Required fields
		Inquiry.getOk().click(); //Click on Ok time

		Inquiry.getouttime().click(); //Click on OutTime Required fields
		Inquiry.getOk().click(); //Click on Ok time

		Inquiry.getNextfollowUpDT().sendKeys(NextfollowUpDT);

		Inquiry.getreferencedBy().sendKeys(referencedBy);
		//ReferencedBy  Text Data Validation 
		valid_string = validateText(referencedBy,"ReferencedBy", 5, 30);
		String valid_referancedby = valid_string;
		System.out.println(valid_referancedby);

		Thread.sleep(2000);		
		softAssert.assertFalse(Attende.isEmpty(), "Attendee is required.");
		Inquiry.getAttendee(Attende);

		Inquiry.getContactNo().sendKeys(ContactNo);
		//ContactNo Number Validation
		valid_string = valid_number(ContactNo, "InquiryContactNo");
		String valid_contactno = valid_string;
		System.out.println(valid_contactno);
		softAssert.assertFalse(ContactNo.isEmpty(), "Contact Number is required.");

		Inquiry.getEmail().sendKeys(Email);
		//Email Validation
		valid_string = valid_EMail(Email, "InquiryEmail");
		String valid_email = valid_string;
		System.out.println(valid_email);

		Inquiry.getAddress().sendKeys(Address);
		//Adress Alphanumeric  Validation
		valid_string = valid_alphanum(Address, "InquiryAddress", 10);
		String valid_address = valid_string;
		System.out.println(valid_address);

		Inquiry.getRemarks().sendKeys(Remarks);
		//Remarks  Text Data Validation
		valid_string = validateText(Remarks,"Remarks", 5, 10);
		String valid_remarks = valid_string;
		System.out.println(valid_remarks);

		Inquiry.getrequirement().sendKeys(Requirement);
		Inquiry.getstatus(Status);

		Thread.sleep(2000);
		Inquiry.getsave().click();
		Thread.sleep(2000);
		
		softAssert.assertEquals(valid_visitorname, "VisitorName is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_referancedby, "ReferencedBy is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_contactno, "InquiryContactNo is a Valid Number");
		softAssert.assertEquals(valid_address, "InquiryAddress is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_email, "InquiryEmail is a Valid EMail");
		softAssert.assertEquals(valid_remarks, "Remarks is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Editing an existing Inquiry using Data Provider
	@Test(dataProvider = "InquiryEditData",priority=2)
	public void Edit_Inquiry(String Projectname,String siteproject,String newvisitorname,String newContactNo, String newEmail, 
			String newAddress,String newRemarks,String newRequirement, String newStatus) throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getSearchInquiry().sendKeys(Projectname + Keys.ENTER);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.getsiteproject(siteproject.trim());

		Thread.sleep(2000);
		Inquiry.getvisitorname().clear();
		Inquiry.getvisitorname().sendKeys(newvisitorname);
		//Visitor Name Text Data Validation
		String valid_string = validateText(newvisitorname,"VisitorName", 5, 30);
		String valid_visitorname = valid_string;
		System.out.println(valid_visitorname);
		softAssert.assertFalse(newvisitorname.isEmpty(), "Visitor Name is required.");

		Inquiry.getContactNo().clear();
		Inquiry.getContactNo().sendKeys(newContactNo);
		//ContactNo Number Validation
		valid_string = valid_number(newContactNo, "InquiryContactNo");
		String valid_contactno = valid_string;
		System.out.println(valid_contactno);
		softAssert.assertFalse(newContactNo.isEmpty(), "Contact Number is required.");

		Inquiry.getEmail().clear();
		Inquiry.getEmail().sendKeys(newEmail);
		//Email Validation
		valid_string = valid_EMail(newEmail, "InquiryEmail");
		String valid_email = valid_string;
		System.out.println(valid_email);

		Inquiry.getAddress().clear();
		Inquiry.getAddress().sendKeys(newAddress);
		//Adress Alphanumeric  Validation
		valid_string = valid_alphanum(newAddress, "InquiryAddress",10);
		String valid_address = valid_string;
		System.out.println(valid_address);

		Inquiry.getRemarks().clear();
		Inquiry.getRemarks().sendKeys(newRemarks);
		//Remarks  Text Data Validation
		valid_string = validateText(newRemarks,"Remarks", 5, 10);
		String valid_remarks = valid_string;
		System.out.println(valid_remarks);

		Inquiry.getrequirement().clear();
		Inquiry.getrequirement().sendKeys(newRequirement);
		Inquiry.getstatus(newStatus.trim());
		Inquiry.getUpdate().click();
		Thread.sleep(2000);
		
		softAssert.assertEquals(valid_visitorname, "VisitorName is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_email, "InquiryEmail is a Valid EMail");
		softAssert.assertEquals(valid_contactno, "InquiryContactNo is a Valid Number");
		softAssert.assertEquals(valid_address, "InquiryAddress is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_remarks, "Remarks is a Valid text - is a valid Minlenght - is not a valid Maxlenght");
		softAssert.assertAll();
	}

	//Delete Inquiry
	@Test(dataProvider="InquiryDeleteData",priority=29)
	public void Delete_Inquiry(String Visitiorname) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getSearchInquiry().sendKeys(Visitiorname + Keys.ENTER);
		Thread.sleep(3000);
		Inquiry.getDelete().click();
		Thread.sleep(2000);
		Inquiry.getClickYes().click();
		Thread.sleep(2000);
	}

	//Export To Excel Inquiry
	@Test(priority=3)
	public void Export_To_Excel_Inquiry() throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getExporttoExcel().click();
	}

	//Apply Filter for Dates & Project
	@Test(dataProvider = "InquiryprojectfilterData",priority=4)
	public void Apply_Filter_Inquiry(String daterange,String Daterange,String selectproject) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		SelectfilterDatesPage Inquirydates = new SelectfilterDatesPage(driver); 
		Inquiry.getInquiry().click();
		Inquiry.getapplyfilter().click();
		Inquiry.getdaterange().click();
		Inquirydates.getSelectDateRange(daterange, Daterange);
		Inquiry.getselectproject(selectproject.trim());
		Thread.sleep(2000);
		Inquiry.getresetfilter().click();
	}

	//Apply Filter with Date
	@Test(dataProvider="FilterDatesData",priority=5)
	public void Apply_Filter_Dates_Inquiry(String daterange,String Daterange) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		SelectfilterDatesPage Inquirydates = new SelectfilterDatesPage(driver); 
		Inquiry.getInquiry().click();
		Inquiry.getapplyfilter().click();
		Inquiry.getdaterange().click();
		Inquirydates.getSelectDateRange(daterange, Daterange);
		Thread.sleep(2000);
		Inquiry.getresetfilter().click();
	}

	//Apply Filter with Project 
	@Test(dataProvider = "InquirySelectProject",priority=6)
	public void Apply_Filter_Project_Inquiry(String selectproject) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getapplyfilter().click();
		Inquiry.getselectproject(selectproject.trim());
		Thread.sleep(2000);
		Inquiry.getresetfilter().click();
	}

	//Search Inquiry
	@Test(dataProvider = "InquirySearchData",priority=7)
	public void Search_Inquiry(String Attende) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getSearchInquiry().sendKeys(Attende.trim() + Keys.ENTER);
	}

	//Todays Follow up Click,Search & Edit
	@Test(dataProvider = "TodaysFollowUpData",priority=8)
	public void Today_Follow_Inquiry(String visitorname) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.gettodayfollowup().click();
		Inquiry.getSearchInquiry().sendKeys(visitorname.trim() + Keys.ENTER);
		boolean flag=Inquiry.NoPageFound();
		if (flag == false) {}
	}

	//Missing Follow up for click,Search & Edit
	@Test(dataProvider = "MissingFollowUpData",priority=9)
	public void Missing_Follow_Inquiry(String visitorname,String followup) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Inquiry.getSearchInquiry().sendKeys(visitorname.trim() + Keys.ENTER);
		boolean flag=Inquiry.NoPageFound();
		if (flag == false) {
		Inquiry.getMissingEditbtn().click();
		Thread.sleep(2000);
		Inquiry.getMissingfollowupcalender().click();
		Thread.sleep(2000);
		Inquiry.getMissinnextfollowupdate(followup);
		Thread.sleep(2000);
		Inquiry.getUpdate().click();
		Thread.sleep(2000);
		}
	}

	//Add To Prospect Inquiry
	@Test(dataProvider = "InquiryaddprospectData",priority=10)
	public void Add_Prospect_Inquiry(String Attende,String unitD, String Selectflat) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getSearchInquiry().sendKeys(Attende.trim() + Keys.ENTER);
		Thread.sleep(2000);
		Inquiry.getAddprospect().click();
		Inquiry.getunitdropdown(unitD.trim());
		Thread.sleep(2000);
		Inquiry.getSelectFlat(Selectflat);
		Thread.sleep(2000);
		Inquiry.getClickYes().click();
		Thread.sleep(2000);
	}

	//Add Inquiry Test Mandatory Field Validation
	@Test(priority=11)
	public void Add_Inquiry_Test_Mandatory_Field_Validation() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();
		Inquiry.getsave().click();
		Thread.sleep(2000);

		WebElement Visitsiteproject =driver.findElement(By.xpath("//span[normalize-space()='Visit Site/Project is required.']"));
		softAssert.assertEquals(Visitsiteproject.getText(), "Visit Site/Project is required.");

		WebElement VisitorName =driver.findElement(By.xpath("//span[normalize-space()='Visitor Name is required.']"));
		softAssert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement Intime =driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
						+ "vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[4]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Intime.getText(), "In Time is required.");

		WebElement Outtime =driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
						+ "vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[5]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Outtime.getText(), "Out Time is required.");

		WebElement Attedee =driver.findElement(By.xpath("//span[normalize-space()='Attendee is required.']"));
		softAssert.assertEquals(Attedee.getText(), "Attendee is required.");

		WebElement ContactNo =driver.findElement(By.xpath("//span[normalize-space()='Contact Number is required.']"));
		softAssert.assertEquals(ContactNo.getText(), "Contact Number is required.");
		softAssert.assertAll();
	}

	//Edit Inquiry Test Mandatory Field Validation
	@Test(dataProvider="EditInquiryMandatoryData",priority=12)
	public void Edit_Inquiry_Test_Mandatory_Field_Validation(String Attende) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getSearchInquiry().sendKeys(Attende.trim() + Keys.ENTER);
		Thread.sleep(2000);
		Inquiry.Getedit();
		Thread.sleep(2000);

		Inquiry.getIntime().click();
		Thread.sleep(2000);
		Inquiry.getOk().click();
		int intime  = Inquiry.getIntime().getAttribute("value").length();
		for (int i = 0; i <intime ; i++) {
			Inquiry.getIntime().sendKeys(Keys.BACK_SPACE);
		}
		Inquiry.getIntime().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		Inquiry.getBlankoutTime().sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		Inquiry.getBlankoutTime().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		Inquiry.getContactNo().click();
		int contactno=Inquiry.getContactNo().getAttribute("value").length();
		for(int i=1;i<=contactno;i++)
		{
			Inquiry.getContactNo().sendKeys(Keys.BACK_SPACE);
		}
		Inquiry.getContactNo().sendKeys(Keys.TAB);

		SoftAssert softAssert = new SoftAssert();
		WebElement VisitorName =driver.findElement(By.xpath("//span[normalize-space()='Visitor Name is required.']"));
		softAssert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement Intime =driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[4]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Intime.getText(), "In Time is required.");

		WebElement Outtime =driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[5]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Outtime.getText(), "Out Time is required.");

		WebElement ContactNo =driver.findElement(By.xpath("//span[normalize-space()='Contact Number is required.']"));
		softAssert.assertEquals(ContactNo.getText(), "Contact Number is required.");	
		softAssert.assertAll();
	}

	//Verify Add Inactive Attendee Inquiry
	@Test(dataProvider="AddInactiveAttendee",priority=13)
	public void Verify_Add_Inactive_Attendee_Inquiry(String employeename,String Attendee) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(employeename +Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();
		Inquiry.AddInactiveAttendee(Attendee);
	}

	//Verify Add Active Attendee Inquiry
	@Test(dataProvider="AddActiveAttendee",priority=14)
	public void Verify_Add_Active_Attendee_Inquiry(String employeename,String Attendee) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(employeename+Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click(); 
		Inquiry.getaddInquiry().click();
		Inquiry.AddActiveAttendee(Attendee);
	}

	//Verify Edit Inactive Attendee Inquiry
	@Test(dataProvider="EditInactiveAttendee",priority=15)
	public void Verify_Edit_Inactive_Attendee_Inquiry(String employeename,String Attendee) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(employeename+Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getEdit();
		Inquiry.EditInactiveAttendee(Attendee);
	}

	//Verify Edit Active Attendee Inquiry
	@Test(dataProvider="EditActiveAttendee",priority=16)
	public void Verify_Edit_Active_Attendee_Inquiry(String employeename,String Attendee) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(employeename+Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click(); 
		Inquiry.getEdit();
		Inquiry.EditInactiveAttendee(Attendee);
	}

	//Active Inactive Inquiry Status
	//Verify Add Inactive Inquiry Status
	@Test(dataProvider="AddInactiveInquiryStatus",priority=17)
	public void Verify_Add_Inactive_Inquiry_Status(String Statusname, String Name) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(Statusname+Keys.ENTER);
		Inquirystatus.getEditInquirystatus().click();
		Thread.sleep(2000);
		Inquirystatus.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();
		Inquiry.AddInactiveInquiryStatus(Name); 
	}

	//Verify Add Active Inquiry Status
	@Test(dataProvider="AddActiveInquiryStatus",priority=18)
	public void Verify_Add_Active_Inquiry_Status(String Statusname, String Name) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(Statusname+Keys.ENTER);
		Inquirystatus.getEditInquirystatus().click();
		Thread.sleep(2000);
		Inquirystatus.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click(); 
		Inquiry.getaddInquiry().click();
		Inquiry.AddActiveInquiryStatus(Name);
	}

	//Verify Edit Inactive Inquiry Status
	@Test(dataProvider="EditInactiveInquiryStatus",priority=19)
	public void Verify_Edit_Inactive_Inquiry_Status(String Statusname, String Name) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(Statusname+Keys.ENTER);
		Inquirystatus.getEditInquirystatus().click();
		Thread.sleep(2000);
		Inquirystatus.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getEdit();
		Inquiry.EditInactiveInquiryStatus(Name);
	}

	//Verify Edit Active Inquiry Status
	@Test(dataProvider="EditActiveInquiryStatus",priority=20)
	public void Verify_Edit_Active_Inquiry_Status(String Statusname, String Name) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Inquirystatus.getInquirystatusclick().click();
		Inquirystatus.getInquirystatussearched().sendKeys(Statusname+Keys.ENTER);
		Inquirystatus.getEditInquirystatus().click();
		Thread.sleep(2000);
		Inquirystatus.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click(); 
		Inquiry.getEdit();
		Inquiry.EditActiveInquiryStatus(Name);
	}

	//Inquiry Response Type
	//Verify Edit Inactive Inquiry Response Type
	@Test(dataProvider="EditInactiveInquiryResponseType",priority=21)
	public void Verify_Edit_Inactive_Inquiry_Response_Type(String responsetype,String Name) throws InterruptedException {
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getInquiryresponsesearched().sendKeys(responsetype+Keys.ENTER);
		Inquiryresponse.getEditinquiryresponsetype().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquiryresponse.getEditinquiryresponsesave().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getMissingFollowUpEditBtn().click();
		Inquiry.getFollowUpDetails().click();
		Inquiry.getAddFollowDetails().click();
		Inquiry.EditInactiveInquiryResponseType(Name);
	}

	//Verify Edit Active Inquiry Response Type
	@Test(dataProvider="EditActiveInquiryResponseType",priority=22)
	public void Verify_Edit_Active_Inquiry_Resposne_Type(String responsetype,String Name) throws InterruptedException {
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getInquiryresponsesearched().sendKeys(responsetype+Keys.ENTER);
		Inquiryresponse.getEditinquiryresponsetype().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquiryresponse.getEditinquiryresponsesave().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getMissingFollowUpEditBtn().click();
		Inquiry.getFollowUpDetails().click();
		Inquiry.getAddFollowDetails().click();
		Inquiry.EditActiveInquiryResponseType(Name);
	}

	//Inquiry Communcation mode
	//Verify Edit Inactive Inquiry Communcation mode
	@Test(dataProvider="EditInactiveInquiryCommuncation",priority=23)
	public void Verify_Edit_Inactive_Inquiry_Communcation_Mode(String Communcationtype,String Name) throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getsearchinquirycommunication().sendKeys(Communcationtype+Keys.ENTER);
		Communication.getEditinquirycommunicationrow().click();
		Thread.sleep(2000);
		Communication.getActiveInactive().click();
		Thread.sleep(2000);
		Communication.geteditsavebuttoninquirycommunication().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getMissingFollowUpEditBtn().click();
		Inquiry.getFollowUpDetails().click();
		Inquiry.getAddFollowDetails().click();
		Inquiry.EditInactiveInquiryCommuncation(Name);
	}

	//Verify Edit Active Inquiry Communcation mode
	@Test(dataProvider="EditActiveInquiryCommuncation",priority=24)
	public void Verify_Edit_Active_Inquiry_Communcation_Mode(String Communcationtype,String Name) throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Communication.getInquirycommunicationmodepageclick().click();
		Communication.getsearchinquirycommunication().sendKeys(Communcationtype+Keys.ENTER);
		Communication.getEditinquirycommunicationrow().click();
		Thread.sleep(2000);
		Communication.getActiveInactive().click();
		Thread.sleep(2000);
		Communication.geteditsavebuttoninquirycommunication().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getMissingFollowUpEditBtn().click();
		Inquiry.getFollowUpDetails().click();
		Inquiry.getAddFollowDetails().click();
		Inquiry.EditActiveInquiryCommuncation(Name);
	}

	//Add Inquiry Project Dropdown
	//Verify Add Inactive Project
	@Test(dataProvider="AddInactiveProjectData",priority=25)
	public void Verify_Add_Inactive_Project(String projectname,String Name) throws InterruptedException {
		ProjectPage Project = new ProjectPage(driver);
		Project.getproject().click();
		Project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		Project.getActiveproject().click();
		Thread.sleep(2000);
		Project.getClickYes().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(2000);
		Inquiry.AddInactiveProjectData(Name);
		Thread.sleep(2000);
	}	

	//Verify Add Active Project
	@Test(dataProvider="AddActiveProjectData",priority=26)
	public void Verify_Add_Active_Project(String projectname,String Name) throws InterruptedException {
		ProjectPage Project = new ProjectPage(driver);
		Project.getproject().click();
		Project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		Project.getActiveproject().click();
		Thread.sleep(2000);
		Project.getClickYes().click();
		Thread.sleep(2000);
		
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(2000);
		Inquiry.AddActiveProjectData(Name);
		Thread.sleep(2000);
	}

	//Edit Inquiry Project Dropdown
	//Verify Edit Inactive Project
	@Test(dataProvider="EditInactiveProjectData",priority=27)
	public void Verify_Edit_Inactive_Project(String projectname,String Projectname,String Name) throws InterruptedException {
		ProjectPage Project = new ProjectPage(driver);
		Project.getproject().click();
		Project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		Project.getActiveproject().click();
		Thread.sleep(2000);
		Project.getClickYes().click();
		Thread.sleep(2000);
		
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getSearchInquiry().sendKeys(Projectname + Keys.ENTER);
		Thread.sleep(1000);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.EditInactiveProjectData(Name);
		Thread.sleep(2000);
	}

	//Verify Edit Active Project
	@Test(dataProvider="EditActiveProjectData",priority=28)
	public void Verify_Edit_Active_Project(String projectname,String Projectname,String Name) throws InterruptedException {
		ProjectPage Project = new ProjectPage(driver);

		Project.getproject().click();
		Project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		Project.getActiveproject().click();
		Thread.sleep(2000);
		Project.getClickYes().click();
		Thread.sleep(2000);
		
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getSearchInquiry().sendKeys(Projectname + Keys.ENTER);
		Thread.sleep(2000);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.EditActiveProjectData(Name);
		Thread.sleep(2000);
	}

	//Close the driver
	@AfterMethod
	public void teardown() {
		base.failedElement = null;
		driver.close(); 
	}

	//DataProvider for Add Inquiry
	@DataProvider
	public Object[][] InquiryAdddata() {
		return new Object[][] { 
			{"Automation Project1", "Mahesh Patel","", "Vimal Patel", " Nilesh Panchal", "9825630021",
				"nilesh@gmail.com", "Shreenand Nagar, Part 4, Vejalpur, Ahmedabad", "Remarks", "4BHK", "In Progress" },

			{"Automation Project2", "Surendra Patel","", "Vimal Patel", " Nilesh Panchal", "9632147852",
					"nilesh@gmail.com", "Shreenand Nagar, Part 4, Vejalpur, Ahmedabad", "Remarks", "4BHK", "In Progress" },

			{"Automation Project3", "Meet Patel", "", "Vimal Patel", " Nilesh Panchal", "8523697410",
						"nilesh@gmail.com", "Shreenand Nagar, Part 4, Vejalpur, Ahmedabad", "Remarks", "4BHK", "In Progress" },

			{"Automation Project4", "Mahi Patel", "", "Vimal Patel", " Nilesh Panchal", "9901236541",
							"nilesh@gmail.com", "Shreenand Nagar, Part 4, Vejalpur, Ahmedabad", "Remarks", "4BHK", "In Progress" },
		};

	}

	//DataProvider for Edit Inquiry Data
	@DataProvider
	public Object[][] InquiryEditData() {
		return new Object[][] 
				{{"Automation Project1","Automation Project1","Mahi Patel Update","9876543210","akash.new@mail.com","Thaltej Square, Ahmedabad","Updated Remarks","5BHK","Completed"}};
	}

	//DataProvider for Delete Inquiry Data
	@DataProvider
	public Object[][] InquiryDeleteData() {
		return new Object[][] 
				{{"Mahesh Patel"},{"Surendra Patel"},{"Meet Patel"},{"Mahi Patel"}};
	}

	//DataProvider for Inquiry Apply Filter for Project Data
	@DataProvider
	public Object[][] InquiryprojectfilterData() {
		return new Object[][] { {"12/OCT/2024","31/DEC/2024","Automation Project1"} };
	}

	//DataProvider for Inquiry Select Project
	@DataProvider
	public Object[][] InquirySelectProject() {
		return new Object[][] { {"Automation Project1"} };
	}

	//DataProvider for Filter Dates Data
	@DataProvider
	public Object[][] FilterDatesData() {
		return new Object[][] {{"11/DEC/2021","17/DEC/2022"}};
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] InquirySearchData() {
		return new Object[][] { {"Mahesh Patel"} };
	}

	//DataProvider for Todays Follow Up Data
	@DataProvider
	public Object[][] TodaysFollowUpData() {
		return new Object[][] { {"Shubham Patel"} };
	}

	//DataProvider for Missing Follow Up Data
	@DataProvider
	public Object[][] MissingFollowUpData() {
		return new Object[][] { {"Akki Patel","26/DEC/2024"} };
	}

	//DataProvider for Add Prospect Data
	@DataProvider
	public Object[][] InquiryaddprospectData() {
		return new Object[][] {{"Mahesh Patel"," A "," Unit No - 102 (1 Floor) "}};
	}

	//DataProvider for Edit Inquiry Mandatory Data
	@DataProvider
	public Object[][] EditInquiryMandatoryData() {
		return new Object[][] {{"Mahesh Patel"}};
	}

	//DataProvider for Add Inactive Attendee Data
	@DataProvider
	public Object[][] AddInactiveAttendee() {
		return new Object[][] {{"AutomationEmpEdit","AutomationEmpEdit"}};
	}

	//DataProvider for Add Active Attendee Data
	@DataProvider
	public Object[][] AddActiveAttendee() {
		return new Object[][] {{"AutomationEmpEdit","AutomationEmpEdit"}};
	}

	//DataProvider for Edit Inactive Attendee Data
	@DataProvider
	public Object[][] EditInactiveAttendee() {
		return new Object[][] {{"AutomationEmpEdit","AutomationEmpEdit"}};
	}

	//DataProvider for Edit Active Attendee Data
	@DataProvider
	public Object[][] EditActiveAttendee() {
		return new Object[][] {{"AutomationEmpEdit","AutomationEmpEdit"}};
	}

	//DataProvider for Add Inactive Inquiry Status Data
	@DataProvider
	public Object[][] AddInactiveInquiryStatus() {
		return new Object[][] {{"SIT InquiryStatus","SIT InquiryStatus"}};
	}

	//DataProvider for Add Active Inquiry Status Data
	@DataProvider
	public Object[][] AddActiveInquiryStatus() {
		return new Object[][] {{"SIT InquiryStatus","SIT InquiryStatus"}};
	}

	//DataProvider for Edit Inactive Inquiry Status Data
	@DataProvider
	public Object[][] EditInactiveInquiryStatus() {
		return new Object[][] {{"SIT InquiryStatus","SIT InquiryStatus"}};
	}

	//DataProvider for Edit Inactive Inquiry Status Data
	@DataProvider
	public Object[][] EditActiveInquiryStatus() {
		return new Object[][] {{"SIT InquiryStatus","SIT InquiryStatus"}};
	}

	//DataProvider for Edit Inactive Inquiry Response Type
	@DataProvider
	public Object[][] EditInactiveInquiryResponseType() {
		return new Object[][] {{"SIT InquiryResponseType","SIT InquiryResponseType"}};
	}
	//DataProvider for Edit Active Inquiry Response Type
	@DataProvider
	public Object[][] EditActiveInquiryResponseType() {
		return new Object[][] {{"SIT InquiryResponseType","SIT InquiryResponseType"}};
	}

	//DataProvider for Edit Inactive Inquiry Communcation Mode
	@DataProvider
	public Object[][] EditInactiveInquiryCommuncation() {
		return new Object[][] {{"SIT InquiryCommunicationMode","SIT InquiryCommunicationMode"}};
	}
	//DataProvider for Edit Active Inquiry Communcation Mode
	@DataProvider
	public Object[][] EditActiveInquiryCommuncation() {
		return new Object[][] {{"SIT InquiryCommunicationMode","SIT InquiryCommunicationMode"}};
	}

	//DataProvider for AddInactiveProjectData
	@DataProvider
	public Object[][] AddInactiveProjectData() {
		return new Object[][] {{"Automation Project3","Automation Project3"}};
	}

	//DataProvider for Add Active Project Data
	@DataProvider
	public Object[][] AddActiveProjectData() {
		return new Object[][] {{"Automation Project2","Automation Project2"}};
	}
	//DataProvider for Edit Inactive Project Data
	@DataProvider
	public Object[][] EditInactiveProjectData() {
		return new Object[][] {{"Automation Project3","Automation Project1","Automation Project3"}};
	}
	//DataProvider for Edit Active Project Data
	@DataProvider
	public Object[][] EditActiveProjectData() {
		return new Object[][] {{"Automation Project2","Automation Project2","Automation Project2"}};
	}
}