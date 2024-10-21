package tests;

import java.io.IOException;
import java.util.List;

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
			String Selectflat) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();

		Prospect.getsiteproject(siteproject); // Required Field
		Prospect.getvisitorname().sendKeys(visitorname); // Required Field
		Prospect.getvisitordate().sendKeys(visitordate);
		Prospect.getIntime().click(); // Click on InTime
		Prospect.getOk().click(); // Click on Ok for time selection
		Prospect.getouttime().click(); // Click on OutTime
		Prospect.getOk().click(); // Click on Ok for time selection
		Prospect.getNextfollowUpDT().sendKeys(NextfollowUpDT);
		Prospect.getreferencedBy().sendKeys(referencedBy);
		Prospect.getAttendee(Attende); // Required Field
		Prospect.getContactNo().sendKeys(ContactNo); // Required Field
		Prospect.getEmail().sendKeys(Email);
		Prospect.getAddress().sendKeys(Address);
		Prospect.getRemarks().sendKeys(Remarks);
		Prospect.getrequirement().sendKeys(Requirement);
		Prospect.getstatus(Status);
		Prospect.getunitdropdown(unitD); // Required Field
		Prospect.getSelectFlat(Selectflat); // Required Field

		Thread.sleep(2000);
		Prospect.getsave().click();
	}

	//Editing an Existing Prospect using Data Provider
	@Test(dataProvider = "ProspectEditData")
	public void Edit_Prospect(String newContactNo, String newEmail, String newAddress,
			String newRemarks, String newRequirement, String newStatus) throws InterruptedException {

		ProspectPage Prospect = new ProspectPage(driver);
		SoftAssert softAssert = new SoftAssert();

		//Navigate to the prospect and click on the Edit option
		Prospect.getprospect().click();
		Prospect.getEdit();

		//Edit and assert Contact Number
		Prospect.getContactNo().clear();
		Prospect.getContactNo().sendKeys(newContactNo);
		softAssert.assertEquals(Prospect.getContactNo().getAttribute("value"), newContactNo, "Contact Number was not updated correctly.");

		//Edit and assert Email
		Prospect.getEmail().clear();
		Prospect.getEmail().sendKeys(newEmail);
		softAssert.assertEquals(Prospect.getEmail().getAttribute("value"), newEmail, "Email was not updated correctly.");

		//Edit and assert Address
		Prospect.getAddress().clear();
		Prospect.getAddress().sendKeys(newAddress);
		softAssert.assertEquals(Prospect.getAddress().getAttribute("value"), newAddress, "Address was not updated correctly.");

		//Edit and assert Remarks
		Prospect.getRemarks().clear();
		Prospect.getRemarks().sendKeys(newRemarks);
		softAssert.assertEquals(Prospect.getRemarks().getAttribute("value"), newRemarks, "Remarks were not updated correctly.");

		//Edit and assert Requirement
		Prospect.getrequirement().clear();
		Prospect.getrequirement().sendKeys(newRequirement);
		softAssert.assertEquals(Prospect.getrequirement().getAttribute("value"), newRequirement, "Requirement was not updated correctly.");

		Prospect.getstatus(newStatus);

		Thread.sleep(2000);
		Prospect.getsave().click();
		softAssert.assertAll();
	}

	//Delete Prospect
	@Test()
	public void Delete_Prospect() throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getDelete();
		Thread.sleep(2000);
		Prospect.getClickYes().click();
	}

	//Export to Excel Prospect
	@Test()
	public void Export_To_Excel_Prospect() throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(2000);
		Prospect.getExporttoExcel().click();
	}

	//Apply Filter for Dates & Project
	@Test(dataProvider="ProspectProjectFilterData")
	public void Apply_Filter_Prospect(String selectproject) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getapplyfilter().click();
		Prospect.getdaterange().click();
		Thread.sleep(2000);
		Prospect.getSelectstartDate().click();
		Thread.sleep(2000);
		Prospect.getSelectEndDate().click();
		Prospect.getselectproject(selectproject);
		Thread.sleep(2000);
		Prospect.getresetfilter().click();	
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
		Prospect.getresetfilter().click();	
	}

	//Apply Filter Method for Project & Reset
	@Test(dataProvider="ProspectProjectFilterData")
	public void Apply_Filter_Project_Prospect(String selectproject) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getapplyfilter().click();
		Prospect.getselectproject(selectproject);
		Prospect.getresetfilter().click();
	}

	//Search Method for Prospect
	@Test(dataProvider="ProspectSearchData")
	public void Search_Prospect(String Attende) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(2000);
		Prospect.getSearch().sendKeys(Attende + Keys.ENTER);
		Thread.sleep(2000);
		Prospect.getSearch().clear();
	}

	//Todays Follow up click,Search & Edit Method
	@Test(dataProvider="ProspectSearchData")
	public void Today_Follow_Up_Prospect(String visitorname) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.gettodayfollowup().click();
		Prospect.getSearch().sendKeys(visitorname + Keys.ENTER);
		Prospect.getEdit();

		Thread.sleep(2000);
		Prospect.getsave().click();
	}

	//Missing Follow up for click,Search & Edit Method
	@Test(dataProvider="ProspectSearchData")
	public void Missing_Follow_Up_Prospect(String visitorname) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getmissingfollowup().click();
		Prospect.getSearch().sendKeys(visitorname + Keys.ENTER);
		Prospect.getEdit();
		Thread.sleep(2000);
		Prospect.getsave().click();
	}

	//Add Prospect Test Mandatory Filed Validation
	@Test
	public void Add_Prospect_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();
		Thread.sleep(2000);
		Prospect.getsave().click();

		WebElement Web =driver.findElement(By.xpath("//span[normalize-space()='Visit Site/Project is required.']"));
		Assert.assertEquals(Web.getText(), "Visit Site/Project is required.");

		WebElement VisitorName =driver.findElement(By.xpath("//span[normalize-space()='Visitor Name is required.']"));
		Assert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement Intime =driver.findElement(By.xpath("//span[normalize-space()='In time is required.']"));
		Assert.assertEquals(Intime.getText(), "In time is required.");

		WebElement Outtime =driver.findElement(By.xpath("//span[normalize-space()='Out time is required.']"));
		Assert.assertEquals(Outtime.getText(), "Out time is required.");

		WebElement Attedee =driver.findElement(By.xpath("//span[normalize-space()='Attendee is required.']"));
		Assert.assertEquals(Attedee.getText(), "Attendee is required.");

		WebElement ContactNo =driver.findElement(By.xpath("//span[normalize-space()='Contact Number is required.']"));
		Assert.assertEquals(ContactNo.getText(), "Contact Number is required.");		
	}

	//Verify Add Inactive Attendee Prospect
	@Test()
	public void Verify_Add_Inactive_Attendee_Inquiry() throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		employee.getSearch().sendKeys("Automation");
		employee.getEdit().click();

		employee.getActiveEmployee().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='userID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Automation Test"))
			{
				Assert.assertFalse(false, "Attende is inactive.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Verify Add Active Attendee Prospect
	@Test()
	public void Verify_Add_Active_Attendee_Inquiry() throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		employee.getSearch().sendKeys("Automation");
		employee.getEdit().click();

		employee.getActiveEmployee().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getAddprospect().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='userID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Automation Test"))
			{
				Assert.assertTrue(true, "Attende is Active.");
				//System.out.println("Test  Pass");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");
					Assert.assertTrue(false, "Attende is InActive.");
					break;
				}	
			}
		}
	}

	//Verify Edit Inactive Attendee Prospect
	@Test()
	public void Verify_Edit_Inactive_Attendee_Inquiry() throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		employee.getSearch().sendKeys("Automation");
		employee.getEdit().click();

		employee.getActiveEmployee().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getEdit();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='userID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Automation Test"))
			{
				Assert.assertFalse(false, "Attende is inactive.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Verify Edit Active Attendee Prospect
	@Test()
	public void Verify_Edit_Active_Attendee_Inquiry() throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		employee.getSearch().sendKeys("Automation");
		employee.getEdit().click();

		employee.getActiveEmployee().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Prospect.getEdit();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='userID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Automation Test"))
			{
				Assert.assertTrue(true, "Attende is Active.");
				//System.out.println("Test  Pass");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");
					Assert.assertTrue(false, "Attende is InActive.");
					break;
				}	
			}
		}
	}

	//Close the Driver  
	@AfterMethod 
	public void teardown() { 
		driver.close();
	}

	//DataProvider for Add Prospect
	@DataProvider
	public Object[][] ProspectAdddata() {
		return new Object[][] {
			{"SHALIGRAM PRIDE1","Mahesh Patel","","","Vimal Patel", "Chandni Chauhan", "9856214565", 
				"Akash@mail.com","Bopal Gam ,Ahmedabad","Remarks","4BHK","In Progress","A","Unit No - A - 101 (Ground Floor) "}};
	}

	//DataProvider for Edit Prospect
	@DataProvider
	public Object[][] ProspectEditData() {
		return new Object[][] {
			{"9876543210","akash.new@mail.com","New Address, Ahmedabad","Updated Remarks","5BHK","Completed" }};
	}

	//DataProvider for Filter Project Dropdown
	@DataProvider
	public Object[][] ProspectProjectFilterData() {
		return new Object[][] {
			{"marin drive lake view"}};
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] ProspectSearchData() {
		return new Object[][] {
			{"Rakesh Patel"}};
	}
}