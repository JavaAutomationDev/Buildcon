package tests;

import java.io.IOException;
import java.time.Duration;

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

		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));  
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));  
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Prospect
	@Test(dataProvider="ProspectAdddata")
	public void Add_Prospect(String siteproject, String visitorname, String visitordate,String NextfollowUpDT, String referencedBy,
			String Attende, String ContactNo,String Email, String Address, String Remarks, String Requirement, String Status, String unitD,
			String Selectflat) throws InterruptedException, IOException {
		SoftAssert softAssert=new SoftAssert(); 
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();

		Prospect.getsiteproject(siteproject.trim());//Required Field
		
		Prospect.getvisitorname().sendKeys(visitorname);//Required Field
		softAssert.assertFalse(visitorname.isEmpty(), "Visitor Name is required.");
		//Visitor Name Text Data Validation
		String valid_string = validateText(visitorname,"VisitorName", 5, 30);
		String valid_visitorname = valid_string;
		System.out.println(valid_visitorname);
		
		Prospect.getvisitordate().sendKeys(visitordate);
		
		Prospect.getIntime().click();//Click on InTime
		Prospect.getOk().click();//Click on Ok for time selection
		
		Prospect.getouttime().click();//Click on OutTime
		Prospect.getOk().click();//Click on Ok for time selection
		
		Prospect.getNextfollowUpDT().sendKeys(NextfollowUpDT);
		
		Prospect.getreferencedBy().sendKeys(referencedBy);
		//Referenced By Text Data Validation
		valid_string = validateText(referencedBy,"ReferencedBy", 5, 30);
		String valid_referancedby = valid_string;
		System.out.println(valid_referancedby);		
		
		Prospect.getAttendee(Attende.trim());//Required Field
		
		Prospect.getContactNo().sendKeys(ContactNo); //Required Field
		//Contact No Number Validation
		valid_string = valid_number(ContactNo, "InquiryContactNo");
		String valid_contactno = valid_string;
		System.out.println(valid_contactno);
		softAssert.assertFalse(ContactNo.isEmpty(), "Contact Number is required.From The Prospect Form");
		
		Prospect.getEmail().sendKeys(Email);
		//Email Validation
		valid_string = valid_EMail(Email, "InquiryEmail");
		String valid_email = valid_string;
		System.out.println(valid_email);		
		
		Prospect.getAddress().sendKeys(Address);
		//Adress Alphanumeric  Validation
		valid_string = valid_alphanum(Address, "InquiryAddress", 10);
		String valid_address = valid_string;
		System.out.println(valid_address);
		
		Prospect.getRemarks().sendKeys(Remarks);
		//Remarks Text Data Validation
		valid_string = validateText(Remarks,"Remarks", 5, 10);
		String valid_remarks = valid_string;
		System.out.println(valid_remarks);
		
		Prospect.getrequirement().sendKeys(Requirement);
	
		Prospect.getstatus(Status.trim());
		Prospect.getunitdropdown(unitD.trim()); //Required Field
		Prospect.getSelectFlat(Selectflat.trim()); //Required Field

		Thread.sleep(2000);
		Prospect.getsave().click();
		
		softAssert.assertEquals(valid_visitorname, "VisitorName is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_referancedby, "ReferencedBy is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_contactno, "InquiryContactNo is a Valid Number");
		softAssert.assertEquals(valid_address, "InquiryAddress is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_email, "InquiryEmail is a Valid EMail");
		softAssert.assertEquals(valid_remarks, "Remarks is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Editing an Existing Prospect using Data Provider
	@Test(dataProvider = "ProspectEditData")
	public void Edit_Prospect(String visitorname,String newContactNo, String newEmail, String newAddress,
			String newRemarks, String newRequirement, String newStatus) throws InterruptedException, IOException{
        SoftAssert softAssert = new SoftAssert();
        
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getSearch().sendKeys(visitorname.trim() + Keys.ENTER);
		Prospect.getEdit().click();

		Prospect.getContactNo().clear();
		Prospect.getContactNo().sendKeys(newContactNo);
		//Contact No Number Validation
		String valid_contactno = valid_number(newContactNo, "ContactNo");
		System.out.println(valid_contactno);
		
		Prospect.getEmail().clear();
		Prospect.getEmail().sendKeys(newEmail);
		//Email Validation
		String valid_email = valid_EMail(newEmail, "Email");
		System.out.println(valid_email);
		
		Prospect.getAddress().clear();
		Prospect.getAddress().sendKeys(newAddress);
		//Adress Alphanumeric  Validation
		String valid_address = valid_alphanum(newAddress, "Address", 10);
		System.out.println(valid_address);
		
		Prospect.getRemarks().clear();
		Prospect.getRemarks().sendKeys(newRemarks);
		//Remarks Text Data Validation
		String valid_remarks = validateText(newRemarks, "Remarks", 5, 10);
		System.out.println(valid_remarks);
				
		Prospect.getrequirement().clear();
		Prospect.getrequirement().sendKeys(newRequirement);
		Prospect.getstatus(newStatus.trim());
		Thread.sleep(2000);
		Prospect.getsave().click();
		
		softAssert.assertEquals(valid_contactno, "ContactNo is a Valid Number");
		softAssert.assertEquals(valid_email, "Email is a Valid EMail");
		softAssert.assertEquals(valid_address, "Address is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_remarks, "Remarks is a Valid text - is a valid Minlenght - is not a valid Maxlenght");
		softAssert.assertAll();
	}

	//Delete Prospect
	@Test(dataProvider="DeleteProspectData")
	public void Delete_Prospect(String Attende) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getSearch().sendKeys(Attende.trim() + Keys.ENTER);
		Prospect.getDelete();
		Thread.sleep(2000);
		Prospect.getClickYes().click();
	}

	//Export to Excel Prospect
	@Test()
	public void Export_To_Excel_Prospect() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getExporttoExcel().click();
	}

	//Apply Filter for Dates & Project
	@Test(dataProvider="ProspectProjectFilterData")
	public void Apply_Filter_Prospect(String selectproject) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getapplyfilter().click();
		Prospect.getdaterange().click();
		Prospect.getSelectstartDate().click();
		Prospect.getSelectEndDate().click();
		Prospect.getselectproject(selectproject.trim());
		
		try {
		    WebElement NRF = driver.findElement(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']"));
		    boolean flag = NRF.isDisplayed();
		    if (!flag) {
		        Prospect.getresetfilter().click();
		    } else {
		        Prospect.getresetfilter().click();
		    }
		} catch (Exception e) {
		    System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	//Apply Filter for Dates
	@Test()
	public void Apply_Filter_Dates_Prospect() throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getapplyfilter().click();
		Prospect.getdaterange().click();
		Prospect.getSelectstartDate().click();
		Thread.sleep(2000);
		Prospect.getSelectEndDate().click();
		Thread.sleep(2000);
		
		try {
			WebElement NRF = driver.findElement(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']"));
			boolean flag = NRF.isDisplayed();
			if (!flag) {
				Prospect.getresetfilter().click();
			} else {
				Prospect.getresetfilter().click();
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	//Apply Filter Method for Project & Reset
	@Test(dataProvider="ProspectProjectFilterData")
	public void Apply_Filter_Project_Prospect(String selectproject) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getapplyfilter().click();
		Prospect.getselectproject(selectproject.trim());
		
		try {
			WebElement NRF = driver.findElement(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']"));
			boolean flag = NRF.isDisplayed();
			if (!flag) {
				Prospect.getresetfilter().click();
			} else {
				Prospect.getresetfilter().click();
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	//Search Method for Prospect
	@Test(dataProvider="ProspectSearchData")
	public void Search_Prospect(String Attende) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(2000);
		Prospect.getSearch().sendKeys(Attende.trim() + Keys.ENTER);
		Thread.sleep(2000);
		Prospect.getSearch().clear();
	}

	//Todays Follow up click,Search & Edit Method
	@Test(dataProvider="ProspectSearchData")
	public void Today_Follow_Up_Prospect(String visitorname) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.gettodayfollowup().click();
		Prospect.getSearch().sendKeys(visitorname.trim() + Keys.ENTER);
		
		WebElement NRF =driver.findElement(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']"));
		@SuppressWarnings("unused")
		boolean flag=NRF.isDisplayed();
		if(flag=false) {
		
		Prospect.getEdit();

		Thread.sleep(2000);
		Prospect.getsave().click();
		}
	}

	//Missing Follow up for click,Search & Edit Method
	@Test(dataProvider="ProspectSearchData")
	public void Missing_Follow_Up_Prospect(String visitorname) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getmissingfollowup().click();
		Prospect.getSearch().sendKeys(visitorname.trim() + Keys.ENTER);
		
		WebElement NRF =driver.findElement(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']"));
		@SuppressWarnings("unused")
		boolean flag=NRF.isDisplayed();
		if(flag=false) {
		Prospect.getEdit();
		Thread.sleep(2000);
		Prospect.getsave().click();
		}
	}

	//Add Prospect Test Mandatory Filed Validation
	@Test
	public void Add_Prospect_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();
		Thread.sleep(2000);
		Prospect.getsave().click();

		SoftAssert softAssert = new SoftAssert();
		WebElement Visitsite =driver.findElement(By.xpath("//span[normalize-space()='Visit Site/Project is required.']"));
		softAssert.assertEquals(Visitsite.getText(), "Visit Site/Project is required.");

		WebElement VisitorName =driver.findElement(By.xpath("//span[normalize-space()='Visitor Name is required.']"));
		softAssert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement Intime =driver.findElement(By.xpath("//span[normalize-space()='In Time is required.']"));
		softAssert.assertEquals(Intime.getText(), "In Time is required.");

		WebElement Outtime =driver.findElement(By.xpath("//span[normalize-space()='Out Time is required.']"));
		softAssert.assertEquals(Outtime.getText(), "Out Time is required.");

		WebElement Attedee =driver.findElement(By.xpath("//span[normalize-space()='Attendee is required.']"));
		softAssert.assertEquals(Attedee.getText(), "Attendee is required.");

		WebElement ContactNo =driver.findElement(By.xpath("//span[normalize-space()='Contact Number is required.']"));
		softAssert.assertEquals(ContactNo.getText(), "Contact Number is required.");	
		softAssert.assertAll();
	}
	
	//Edit Prospect Test Mandatory Filed Validation
	@Test(dataProvider="EditProspectTestMandatoryData")
	public void Edit_Prospect_Test_Mandatory_Filed_Validation(String visitorname ) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getSearch().sendKeys(visitorname + Keys.ENTER);
		Prospect.getEdit().click();
		Thread.sleep(2000);
		
		Prospect.getvisitorname().click();
		int Vname  = Prospect.getvisitorname().getAttribute("value").length();
		for (int i = -1; i <Vname ; i++) {
			Prospect.getvisitorname().sendKeys(Keys.BACK_SPACE);
		}
		
		Prospect.getContactNo().click();
		int contactno = Prospect.getContactNo().getAttribute("value").length();
		for (int i = 0; i <contactno ; i++) {
			Prospect.getContactNo().sendKeys(Keys.BACK_SPACE);
		}
		Prospect.getContactNo().sendKeys(Keys.TAB);
		
		WebElement VisitorName =driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[2]/mat-form-field/div[2]/div"));
		softAssert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement ContactNo =driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[9]/mat-form-field/div[2]/div"));
		softAssert.assertEquals(ContactNo.getText(), "Contact Number is required.");
		softAssert.assertAll();
	}

	//Verify Add Inactive Attendee Prospect
	@Test(dataProvider="AddInactiveAttendeeProspect")
	public void Verify_Add_Inactive_Attendee_Prospect(String Employeename,String Attendename) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(Employeename+Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();
		
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();
        Prospect.AddInactiveAttendeeProspect(Attendename);
	}
	
	//Verify Add Active Attendee Prospect
	@Test(dataProvider="AddActiveAttendeeProspect")
	public void Verify_Add_Active_Attendee_Prospect(String Employeename,String Attendename) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(Employeename+Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();
        Prospect.AddActiveAttendeeProspect(Attendename);
	}

	//Verify Edit Inactive Attendee Prospect
	@Test(dataProvider="EditInactiveAttendeeProspect")
	public void Verify_Edit_Inactive_Attendee_Prospect(String Employeename,String Attendename) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(Employeename+Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getEdit();
		Prospect.EditInactiveAttendeeProspect(Attendename);
	}

	//Verify Edit Active Attendee Prospect
	@Test(dataProvider="EditActiveAttendeeProspect")
	public void Verify_Edit_Active_Attendee_Prospect(String Employeename,String Attendename) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(Employeename+Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getEdit();
        Prospect.EditActiveAttendeeProspect(Attendename);
	}

	//Close the Driver  
	@AfterMethod 
	public void teardown() { 
		//driver.close();
	}

	//DataProvider for Add Prospect
	@DataProvider
	public Object[][] ProspectAdddata() {
		return new Object[][] {
			{"Automation Project1","Mahesh Patel","","","Vimal Patel", "Nilesh Panchal", "9856214565", 
				"Akash@mail.com","Bopal Gam ,Ahmedabad","Remarks","4BHK","In Progress","A","Unit No - 101 (1st Floor)"},
			{"Automation Project1","Suresh Patel","","","Vimal Patel", "Nilesh Panchal", "9856214501", 
				"Akash@mail.com","Bopal Gam ,Ahmedabad","Remarks","4BHK","In Progress","A","Unit No - 102 (1st Floor)"},
			{"Automation Project1","Meet Patel","","","Vimal Patel", "Nilesh Panchal", "9856214574", 
				"Akash@mail.com","Bopal Gam ,Ahmedabad","Remarks","4BHK","In Progress","A","Unit No - 103 (1st Floor)"},
			{"Automation Project1","Mahi Patel","","","Vimal Patel", "Nilesh Panchal", "9856214532", 
				"Akash@mail.com","Bopal Gam ,Ahmedabad","Remarks","4BHK","In Progress","A","Unit No - 104 (1st Floor)"}
		};
	}

	//DataProvider for Edit Prospect
	@DataProvider
	public Object[][] ProspectEditData() {
		return new Object[][] {
			{"Mahesh Patel","9876543210","akash.new@mail.com","New Address, Ahmedabad","Updated Remarks","5BHK","Completed" }};
	}

	//DataProvider for Filter Project Dropdown
	@DataProvider
	public Object[][] ProspectProjectFilterData() {
		return new Object[][] {{"Automation Project1"}};
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] ProspectSearchData() {
		return new Object[][] {{"Nilesh Panchal"}};
	}
	
	//DataProvider for Delete Prospect Data
	@DataProvider
	public Object[][] DeleteProspectData() {
		return new Object[][] {{"Suresh Patel"},{"Mahesh Patel"},{"Meet Patel"},{"Mahi Patel"}};
	}
	
	//DataProvider for Edit Prospect Test Mandatory Data
	@DataProvider
	public Object[][] EditProspectTestMandatoryData() {
		return new Object[][] {{"Nilesh Panchal"}};
	}
	
	//DataProvider for Add Inactive Attendee Prospect
	@DataProvider
	public Object[][] AddInactiveAttendeeProspect() {
		return new Object[][] {{"Automation Test","Automation Test"}};
	}
	
	//DataProvider for Add Active Attendee Prospect
	@DataProvider
	public Object[][] AddActiveAttendeeProspect() {
		return new Object[][] {{"Automation Test","Automation Test"}};
	}
	
	//DataProvider for Edit Inactive Attendee Prospect
	@DataProvider
	public Object[][] EditInactiveAttendeeProspect() {
		return new Object[][] {{"Automation Test","Automation Test"}};
	}
	
	//DataProvider for Edit Active Attendee Prospect
	@DataProvider
	public Object[][] EditActiveAttendeeProspect() {
		return new Object[][] {{"Automation Test","Automation Test"}};
	}
}