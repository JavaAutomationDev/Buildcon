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

import pageObjects.EmployeePage;
import pageObjects.InquiryPage;
import pageObjects.InquiryResponsepage;
import pageObjects.Inquirycommunicationmodepage;
import pageObjects.Inquirystatuspage;
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
	@Test(dataProvider = "InquiryAdddata")
	public void Add_Inquiry(String siteproject, String visitorname, String NextfollowUpDT, String referencedBy,
			String Attende, String ContactNo, String Email, String Address, String Remarks, String Requirement,
			String Status) throws InterruptedException {

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();

		Thread.sleep(2000);
		Inquiry.getsiteproject(siteproject);
		Inquiry.getvisitorname().sendKeys(visitorname);

		Inquiry.getIntime().click(); //click on InTime Required fields
		Inquiry.getOk().click(); //Click on Ok time

		Inquiry.getouttime().click(); //Click on OutTime Required fields
		Inquiry.getOk().click(); // Click on Ok time

		Inquiry.getNextfollowUpDT().sendKeys(NextfollowUpDT);
		Inquiry.getreferencedBy().sendKeys(referencedBy);
		Thread.sleep(2000);		
		Inquiry.getAttendee(Attende);
		Inquiry.getContactNo().sendKeys(ContactNo);
		Inquiry.getEmail().sendKeys(Email);
		Inquiry.getAddress().sendKeys(Address);
		Inquiry.getRemarks().sendKeys(Remarks);
		Inquiry.getrequirement().sendKeys(Requirement);
		Inquiry.getstatus(Status);

		Thread.sleep(2000);
		Inquiry.getsave().click();
	}

	//Editing an existing Inquiry using Data Provider
	@Test(dataProvider = "InquiryEditData")
	public void Edit_Inquiry(String newvisitorname,String newContactNo, String newEmail, String newAddress, String newRemarks,
			String newRequirement, String newStatus) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getEdit();

		Thread.sleep(2000);
		Inquiry.getvisitorname().clear();
		Inquiry.getvisitorname().sendKeys(newvisitorname);

		Inquiry.getEdit().click();
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
		Inquiry.getUpdate().click();
	}

	//Delete Inquiry
	@Test(dataProvider="InquiryDeleteData")
	public void Delete_Inquiry(int iteration) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getDelete();
		Thread.sleep(2000);
		Inquiry.getClickYes().click();
	}

	//Export to Excel Inquiry
	@Test()
	public void Export_To_Excel_Inquiry() throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getExporttoExcel().click();
	}

	//Apply Filter for Dates & Project
	@Test(dataProvider = "InquiryprojectfilterData")
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
	@Test(dataProvider = "InquiryprojectfilterData")
	public void Apply_Filter_Project_Inquiry(String selectproject) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getapplyfilter().click();
		Inquiry.getselectproject(selectproject);
		Thread.sleep(5000);
		Inquiry.getresetfilter().click();
	}

	//Search Inquiry
	@Test(dataProvider = "InquirySearchData")
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
	@Test(dataProvider = "InquirySearchData")
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
	@Test(dataProvider = "InquirySearchData")
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
	@Test(dataProvider = "InquiryaddprospectData")
	public void Add_Prospect_Inquiry(String unitD, String Selectflat) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getAddprospect().click();
		Inquiry.getunitdropdown(unitD);
		Inquiry.getSelectFlat(Selectflat);

		Thread.sleep(2000);
		Inquiry.getClickYes().click();
	}

	//Add Inquiry Test Mandatory Filed Validation
	@Test
	public void Add_Inquiry_Test_Mandatory_Filed_Validation() throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();
		Inquiry.getsave().click();
		Thread.sleep(2000);

		WebElement Visitsiteproject =driver.findElement(By.xpath("//span[normalize-space()='Visit Site/Project is required.']"));
		Assert.assertEquals(Visitsiteproject.getText(), "Visit Site/Project is required.");

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

	//Edit Inquiry Test Mandatory Filed Validation
	@Test()
	public void Edit_Inquiry_Test_Mandatory_Field_Validation() throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.Getedit();
		Thread.sleep(2000);

		Inquiry.getIntime().click();
		Inquiry.getOk().click();
		Inquiry.getIntime().sendKeys(Keys.BACK_SPACE);
		Inquiry.getIntime().sendKeys(Keys.BACK_SPACE);
		Inquiry.getIntime().sendKeys(Keys.BACK_SPACE);
		Inquiry.getIntime().sendKeys(Keys.BACK_SPACE);
		Inquiry.getIntime().sendKeys(Keys.BACK_SPACE);
		Inquiry.getIntime().sendKeys(Keys.TAB);

		Inquiry.getBlankoutTime().sendKeys(Keys.DELETE);
		Inquiry.getBlankoutTime().sendKeys(Keys.TAB);

		Inquiry.getContactNo().click();

		for(int i=1;i<=10;i++)
		{
			Inquiry.getContactNo().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(2000);
		Inquiry.getContactNo().sendKeys(Keys.TAB);

		WebElement VisitorName =driver.findElement(By.xpath("//span[normalize-space()='Visitor Name is required.']"));
		Assert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement Intime =driver.findElement(By.xpath("//span[normalize-space()='In time is required.']"));
		Assert.assertEquals(Intime.getText(), "In time is required.");

		WebElement Outtime =driver.findElement(By.xpath("//span[normalize-space()='Out time is required.']"));
		Assert.assertEquals(Outtime.getText(), "Out time is required.");

		WebElement ContactNo =driver.findElement(By.xpath("//span[normalize-space()='Contact Number is required.']"));
		Assert.assertEquals(ContactNo.getText(), "Contact Number is required.");		
	}

	//Verify Add Inactive Attendee Inquiry
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

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();

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

	//Verify Add Active Attendee Inquiry
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

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click(); 
		Inquiry.getaddInquiry().click();

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

	//Verify Edit Inactive Attendee Inquiry
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

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getEdit();

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

	//Verify Edit Active Attendee Inquiry
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

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click(); 
		Inquiry.getEdit();

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

	//Active Inactive Inquiry Status
	//Verify Add Inactive Inquiry Status
	@Test()
	public void Verify_Add_Inactive_Inquiry_Status() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getEditInquirystatus().click();
		Thread.sleep(2000);
		unit.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		unit.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getaddInquiry().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='statusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Akash Inquiry"))
			{
				Assert.assertFalse(false, "Inquiry Status is inactive.");
				System.out.println("Test Failed");
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

	//Verify Add Active Inquiry Status
	@Test()
	public void Verify_Add_Active_Inquiry_Status() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getEditInquirystatus().click();
		Thread.sleep(2000);
		unit.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		unit.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click(); 
		Inquiry.getaddInquiry().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='statusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Akash Inquiry"))
			{
				Assert.assertTrue(true, "Inquiry Status is Active.");
				System.out.println("Test Pass");
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

	//Verify Edit Inactive Inquiry Status
	@Test()
	public void Verify_Edit_Inactive_Inquiry_Status() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getEditInquirystatus().click();
		Thread.sleep(2000);
		unit.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		unit.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getEdit();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='statusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Automation Test"))
			{
				Assert.assertFalse(false, "Inquiry Status is inactive.");
				System.out.println("Test failed");
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

	//Verify Edit Active Inquiry Status
	@Test()
	public void Verify_Edit_Active_Inquiry_Status() throws InterruptedException {
		Inquirystatuspage unit = new Inquirystatuspage(driver);
		unit.getconfiguration().click();
		unit.getInquirystatusclick().click();
		unit.getEditInquirystatus().click();
		Thread.sleep(2000);
		unit.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		unit.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click(); 
		Inquiry.getEdit().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='statusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Akash Inquiry"))
			{
				Assert.assertTrue(true, "Inquiry Status is Active.");
				System.out.println("Test Pass");
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
	
	//Verify Edit Inactive Inquiry Response Type
	@Test()
	public void Verify_Edit_Inactive_Inquiry_response_Type() throws InterruptedException {
		InquiryResponsepage Iresponse = new InquiryResponsepage(driver);
		Iresponse.getconfiguration().click();
		Thread.sleep(2000);
		Iresponse.getInquiryResponsepageclick().click();
		Thread.sleep(2000);
		Iresponse.getEditinquiryresponsetype().click();
		Thread.sleep(2000);
		Iresponse.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Iresponse.getEditinquiryresponsesave().click();
		Thread.sleep(2000);
		
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Inquiry.getMissingFollowUpEditBtn().click();
		Inquiry.getFollowUpDetails().click();
		Inquiry.getAddFollowDetails().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='responseTypeID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Nishant"))
			{
				Assert.assertFalse(false, "Inquiry Response Type is inactive.");
				System.out.println("Test failed");
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

	//Verify Edit Active Inquiry Response Type
	@Test()
	public void Verify_Edit_Active_Inquiry_Resposne_Type() throws InterruptedException {
		InquiryResponsepage Iresponse = new InquiryResponsepage(driver);
		Iresponse.getconfiguration().click();
		Thread.sleep(2000);
		Iresponse.getInquiryResponsepageclick().click();
		Thread.sleep(2000);
		Iresponse.getEditinquiryresponsetype().click();
		Thread.sleep(2000);
		Iresponse.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Iresponse.getEditinquiryresponsesave().click();
		Thread.sleep(2000);
		
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Inquiry.getMissingFollowUpEditBtn().click();
		Inquiry.getFollowUpDetails().click();
		Inquiry.getAddFollowDetails().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='responseTypeID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Nishant"))
			{
				Assert.assertFalse(false, "Inquiry Response Type is Active.");
				System.out.println("Test failed");
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

	//Inquiry Communcation mode
	//Verify Edit Inactive Inquiry Communcation mode
		@Test()
		public void Verify_Edit_Inactive_Inquiry_Communcation_mode() throws InterruptedException {
			Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
			Communication.getconfiguration().click();
			Communication.getInquirycommunicationmodepageclick().click();
			Communication.getEditinquirycommunicationrow().click();
			Thread.sleep(2000);
			Communication.getActiveInactive().click();
			Thread.sleep(2000);
			Communication.geteditsavebuttoninquirycommunication().click();
			Thread.sleep(2000);
			
			InquiryPage Inquiry = new InquiryPage(driver);
			Inquiry.getInquiry().click();
			Inquiry.getmissingfollowup().click();
			Inquiry.getMissingFollowUpEditBtn().click();
			Inquiry.getFollowUpDetails().click();
			Inquiry.getAddFollowDetails().click();

			driver.findElement(By.xpath("//mat-select[@formcontrolname='commTypeID']")).click();
			List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
			int Counter=0;
			for(int i=0;i<a.size();i++)
			{
				String b =a.get(i).getText(); 
				if(!b.equalsIgnoreCase("Akash"))
				{
					Assert.assertFalse(false, "Inquiry Communcation mode is inactive.");
					System.out.println("Test failed");
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

		//Verify Edit Active Inquiry Communcation mode
		@Test()
		public void Verify_Edit_Active_Inquiry_Communcation_mode() throws InterruptedException {
			Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
			Communication.getconfiguration().click();
			Communication.getInquirycommunicationmodepageclick().click();
			Communication.getEditinquirycommunicationrow().click();
			Thread.sleep(2000);
			Communication.getActiveInactive().click();
			Thread.sleep(2000);
			Communication.geteditsavebuttoninquirycommunication().click();
			Thread.sleep(2000);
			
			InquiryPage Inquiry = new InquiryPage(driver);
			Inquiry.getInquiry().click();
			Inquiry.getmissingfollowup().click();
			Inquiry.getMissingFollowUpEditBtn().click();
			Inquiry.getFollowUpDetails().click();
			Inquiry.getAddFollowDetails().click();

			driver.findElement(By.xpath("//mat-select[@formcontrolname='commTypeID']")).click();
			List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
			int Counter=0;
			for(int i=0;i<a.size();i++)
			{
				String b =a.get(i).getText(); 
				if(!b.equalsIgnoreCase("Akash"))
				{
					Assert.assertFalse(false, "Inquiry Communcation mode is Active.");
					System.out.println("Test failed");
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

	//Close the driver
	@AfterMethod 
	public void teardown() {
		driver.close(); 
	}

	//DataProvider for Add Inquiry
	@DataProvider
	public Object[][] InquiryAdddata() {
		return new Object[][] { 
			//{"Taj Mahal","Mahesh Patel","","Vimal Patel"," Nilesh Panchal1","9746547979","Akash@mail.com","Bopal Gam, Ahmedabad","Remarks","4BHK","In Progress" }
			{"Project3","Nilesh Modi","","Vimal1"," Akash Patel ","9898100001","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal2"," Akash Patel ","9898100002","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal3"," Akash Patel ","9898100003","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal4"," Akash Patel ","9898100004","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal5"," Akash Patel ","9898100006","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal6"," Akash Patel ","9898100007","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal7"," Akash Patel ","9898100008","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal8"," Akash Patel ","9898100009","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal9"," Akash Patel ","98981000010","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal10"," Akash Patel ","98981000011","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },	
			{"Project3","Nilesh Modi","","Vimal11"," Akash Patel ","98981000012","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal12"," Akash Patel ","98981000013","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal13"," Akash Patel ","98981000014","nilesh.m@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Nilesh Modi","","Vimal14"," Akash Patel ","98981000015","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal15"," Akash Patel ","98981000016","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },	
			{"Project3","Jaypalsinh Sarvaiya","","Vimal16"," Akash Patel ","98981000017","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal17"," Akash Patel ","98981000018","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal18"," Akash Patel ","98981000019","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal19"," Akash Patel ","98981000020","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal20"," Akash Patel ","98981000021","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },	
			{"Project3","Jaypalsinh Sarvaiya","","Vimal21"," Akash Patel ","98981000022","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal22"," Akash Patel ","98981000023","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal23"," Akash Patel ","98981000024","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal24"," Akash Patel ","98981000025","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Jaypalsinh Sarvaiya","","Vimal25"," Akash Patel ","98981000026","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },	
			{"Project3","Jaypalsinh Sarvaiya","","Vimal26"," Akash Patel ","98981000027","jaypalsinh@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal27"," Akash Patel ","98981000028","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal28"," Akash Patel ","98981000029","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal29"," Akash Patel ","98981000030","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal30"," Akash Patel ","98981000031","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },	
			{"Project3","Harpal Gohil","","Vimal31"," Akash Patel ","98981000032","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal32"," Akash Patel ","98981000033","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal33"," Akash Patel ","98981000034","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal34"," Akash Patel ","98981000035","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal35"," Akash Patel ","98981000036","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },	
			{"Project3","Harpal Gohil","","Vimal36"," Akash Patel ","98981000037","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal37"," Akash Patel ","98981000038","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Harpal Gohil","","Vimal38"," Akash Patel ","98981000039","harpal.g@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal39"," Akash Patel ","98981000040","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal40"," Akash Patel ","98981000041","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },	
			{"Project3","Ashok Solanki","","Vimal41"," Akash Patel ","98981000042","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal42"," Akash Patel ","98981000043","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal43"," Akash Patel ","98981000044","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal44"," Akash Patel ","98981000045","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal45"," Akash Patel ","98981000046","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },	
			{"Project3","Ashok Solanki","","Vimal46"," Akash Patel ","98981000047","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal47"," Akash Patel ","98981000048","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal48"," Akash Patel ","98981000049","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal49"," Akash Patel ","98981000050","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
			{"Project3","Ashok Solanki","","Vimal50"," Akash Patel ","98981000051","ashok.s@yopmail.com","Bopal Gam, Ahmedabad","Remarks","Bungalow","In Progress" },
		};
	}

	//DataProvider for Edit Inquiry
	@DataProvider
	public Object[][] InquiryEditData() {
		return new Object[][] {{"Testing","9876543210","akash.new@mail.com","Thaltej Square, Ahmedabad","Updated Remarks","5BHK","Completed"}};
	}

	//DataProvider Delete Inquiry
	@DataProvider
	public Object[][] InquiryDeleteData() {
		return new Object[][] 
				{{ 1 },{ 2 },{ 3 },{ 4 }};	
	}

	//DataProvider for Apply Filter for Project
	@DataProvider
	public Object[][] InquiryprojectfilterData() {
		return new Object[][] { {"SHALIGRAM PRIDE"} };
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] InquirySearchData() {
		return new Object[][] { {"Rakesh Patel"} };
	}

	//DataProvider for Add Prospect Data
	@DataProvider
	public Object[][] InquiryaddprospectData() {
		return new Object[][] {{" A "," Unit No - 102 (1 Floor) "}};
	}
}