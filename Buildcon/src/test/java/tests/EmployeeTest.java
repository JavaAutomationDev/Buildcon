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
import pageObjects.LoginPage;
import pageObjects.Rolepage;
import resources.base;

public class EmployeeTest extends base {
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

	//Add Employee with All Modules - All Roles
	@Test(dataProvider="EmployeeAddData")
	public void Add_Employee_All_Roles(String profileImg,String Firstname,String Midllename,String Lastname,String Username,String designation,
			String dob,String email,String Role,String City,String State,String mobileno,String password,String address,String Project,
			String Adharcard,String pancard) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getaddemployee().click();

		employee.getProfileImg().sendKeys(profileImg);
		employee.getfname().sendKeys(Firstname);//Required Field
		employee.getmname().sendKeys(Midllename);
		employee.getlname().sendKeys(Lastname);//Required Field

		employee.getUserName().sendKeys(Username);
		employee.getDesignation().sendKeys(designation);//Required Field
		employee.getDOB().sendKeys(dob);
		employee.getEmail().sendKeys(email);//Required Field

		employee.getRoles(Role);
		employee.getcity().sendKeys(City);
		employee.getstate(State);//Required Field
		employee.getMobileno().sendKeys(mobileno);//Required Field
		employee.getPassword().sendKeys(password);
		employee.getAddress().sendKeys(address);
		employee.getProjectAccess(Project);
		employee.uploadAdharCard().sendKeys(Adharcard);//Required Field
		employee.getPancard().sendKeys(pancard);//Required Field
		employee.SelectGender().click();//Required Field
		Thread.sleep(2000);
		employee.Nextbtn().click();

		//employee.Shownumber().click();
		employee.Empradiobtn().click();
		employee.Projectradiobtn().click();
		employee.Receiptradiobtn().click();
		employee.Collectionradiobtn().click();
		employee.Customerradiobtn().click();
		employee.Inquiryradiobtn().click();
		employee.Prospectradiobtn().click();
		employee.Bookingsradiobtn().click();
		employee.Documentsradiobtn().click();

		Thread.sleep(2000);
		employee.Createbtn().click();
	}

	//Add Employee with All Modules - Only View
	@Test(dataProvider="EmployeeAddData")
	public void Add_Employee_Only_View(String profileImg,String Firstname,String Midllename,String Lastname,String Username,String designation,
			String dob,String email,String Role,String City,String State,String mobileno,String password,String address,String Project,
			String Adharcard,String pancard) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		employee.getaddemployee().click();
		employee.getProfileImg().sendKeys(profileImg);
		employee.getfname().sendKeys(Firstname);
		employee.getmname().sendKeys(Midllename);
		employee.getlname().sendKeys(Lastname);
		employee.getUserName().sendKeys(Username);
		employee.getDesignation().sendKeys(designation);
		employee.getDOB().sendKeys(dob);
		employee.getEmail().sendKeys(email);
		employee.getRoles(Role);
		employee.getcity().sendKeys(City);
		employee.getstate(State);
		employee.getMobileno().sendKeys(mobileno);
		employee.getPassword().sendKeys(password);
		employee.getAddress().sendKeys(address);
		employee.getProjectAccess(Project);
		employee.uploadAdharCard().sendKeys(Adharcard);
		employee.getPancard().sendKeys(pancard);
		employee.SelectGender().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();
		employee.EmpSelectbtn().click(); 
		employee.EmpEntry().click();
		employee.EmpModify().click(); 
		employee.EmpRemove().click();
		employee.EmpExport().click(); 

		employee.Projectselectbtn().click();
		employee.ProjectEntry().click(); 
		employee.ProjectModify().click();
		employee.ProjectRemove().click(); 
		employee.ProjectExport().click();

		employee.Receiptselectbtn().click(); 
		employee.ReceiptEntry().click();
		employee.ReceiptModify().click(); 
		employee.ReceiptRemove().click();
		employee.ReceiptExport().click();

		employee.Collectionselectbtn().click();
		employee.CollectionExport().click();

		employee.Customerselectbtn().click();
		employee.CustomerExport().click();

		Thread.sleep(2000);
		employee.InquiryEntry().click();
		employee.InquiryModify().click();
		employee.InquiryRemove().click();
		employee.InquiryExport().click();

		employee.ProspectSelectbtn().click();
		employee.ProspectView().click();

		employee.BookingEntry().click();
		employee.BookingModify().click();
		employee.BookingRemove().click();
		employee.BookingExport().click();
		employee.ApproveReject().click();
		employee.AllowBooking().click();

		employee.DocumentSelectbtn().click();
		employee.DocumentEntry().click();
		employee.DocumentModify().click();
		employee.DocumentRemove().click();
		employee.DocumentExport().click();

		Thread.sleep(2000);
		employee.CreateBtn1().click();
	}

	//Add Employee with All Modules - Only Add
	@Test(dataProvider="EmployeeAddData")
	public void Add_Employee_Only_Add(String profileImg,String Firstname,String Midllename,String Lastname,String Username,String designation,
			String dob,String email,String Role,String City,String State,String mobileno,String password,String address,String Project,
			String Adharcard,String pancard) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		employee.getaddemployee().click();
		employee.getProfileImg().sendKeys(profileImg);
		employee.getfname().sendKeys(Firstname);
		employee.getmname().sendKeys(Midllename);
		employee.getlname().sendKeys(Lastname);
		employee.getUserName().sendKeys(Username);
		employee.getDesignation().sendKeys(designation);
		employee.getDOB().sendKeys(dob);
		employee.getEmail().sendKeys(email);
		employee.getRoles(Role);
		employee.getcity().sendKeys(City);
		employee.getstate(State);
		employee.getMobileno().sendKeys(mobileno);
		employee.getPassword().sendKeys(password);
		employee.getAddress().sendKeys(address);
		employee.getProjectAccess(Project);
		employee.uploadAdharCard().sendKeys(Adharcard);
		employee.getPancard().sendKeys(pancard);
		employee.SelectGender().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		employee.EmpSelectbtn().click(); 
		employee.EmpModify().click(); 
		employee.EmpRemove().click();
		employee.EmpExport().click(); 

		employee.Projectselectbtn().click();
		employee.ProjectModify().click();
		employee.ProjectRemove().click(); 
		employee.ProjectExport().click();

		employee.Receiptselectbtn().click(); 
		employee.ReceiptModify().click(); 
		employee.ReceiptRemove().click();
		employee.ReceiptExport().click();

		employee.Collectionselectbtn().click();
		employee.CollectionExport().click();

		employee.Customerselectbtn().click();
		employee.CustomerExport().click();

		employee.InquiryModify().click();
		employee.InquiryRemove().click();
		employee.InquiryExport().click();

		employee.ProspectSelectbtn().click();
		employee.ProspectView().click();
		employee.ProspectEntry().click();

		employee.BookingModify().click();
		employee.BookingRemove().click();
		employee.BookingExport().click();
		employee.ApproveReject().click();
		employee.AllowBooking().click();

		employee.DocumentSelectbtn().click();
		employee.DocumentView().click();
		employee.DocumentEntry().click();

		Thread.sleep(2000);
		employee.CreateBtn1().click();		
	}

	//Add Employee with All Modules - Only Edit
	@Test(dataProvider="EmployeeAddData")
	public void Add_Employee_Only_Edit(String profileImg,String Firstname,String Midllename,String Lastname,String Username,String designation,
			String dob,String email,String Role,String City,String State,String mobileno,String password,String address,String Project,
			String Adharcard,String pancard) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		employee.getaddemployee().click();
		employee.getProfileImg().sendKeys(profileImg);
		employee.getfname().sendKeys(Firstname);
		employee.getmname().sendKeys(Midllename);
		employee.getlname().sendKeys(Lastname);
		employee.getUserName().sendKeys(Username);
		employee.getDesignation().sendKeys(designation);
		employee.getDOB().sendKeys(dob);
		employee.getEmail().sendKeys(email);
		employee.getRoles(Role);
		employee.getcity().sendKeys(City);
		employee.getstate(State);
		employee.getMobileno().sendKeys(mobileno);
		employee.getPassword().sendKeys(password);
		employee.getAddress().sendKeys(address);
		employee.getProjectAccess(Project);
		employee.uploadAdharCard().sendKeys(Adharcard);
		employee.getPancard().sendKeys(pancard);
		employee.SelectGender().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		employee.EmpSelectbtn().click(); 
		employee.EmpEntry().click(); 
		employee.EmpRemove().click();
		employee.EmpExport().click(); 

		employee.Receiptselectbtn().click(); 
		employee.ReceiptEntry().click(); 
		employee.ReceiptRemove().click();
		employee.ReceiptExport().click();

		employee.InquiryEntry().click();
		employee.InquiryRemove().click();
		employee.InquiryExport().click();

		employee.ProspectSelectbtn().click();
		employee.ProspectEntry().click();
		employee.ProspectRemove().click();
		employee.ProspectExport().click();
		employee.ProspectFollowUp().click();

		employee.BookingEntry().click();
		employee.BookingRemove().click();
		employee.BookingExport().click();
		employee.ApproveReject().click();
		employee.AllowBooking().click();

		employee.DocumentSelectbtn().click();
		employee.DocumentEntry().click();
		employee.DocumentRemove().click();
		employee.DocumentExport().click();

		Thread.sleep(2000);
		employee.CreateBtn1().click();		
	}

	//Add Employee with All Modules - Only Delete
	@Test(dataProvider="EmployeeAddData")
	public void Add_Employee_Only_Delete(String profileImg,String Firstname,String Midllename,String Lastname,String Username,String designation,
			String dob,String email,String Role,String City,String State,String mobileno,String password,String address,String Project,
			String Adharcard,String pancard) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		employee.getaddemployee().click();
		employee.getProfileImg().sendKeys(profileImg);
		employee.getfname().sendKeys(Firstname);
		employee.getmname().sendKeys(Midllename);
		employee.getlname().sendKeys(Lastname);
		employee.getUserName().sendKeys(Username);
		employee.getDesignation().sendKeys(designation);
		employee.getDOB().sendKeys(dob);
		employee.getEmail().sendKeys(email);
		employee.getRoles(Role);
		employee.getcity().sendKeys(City);
		employee.getstate(State);
		employee.getMobileno().sendKeys(mobileno);
		employee.getPassword().sendKeys(password);
		employee.getAddress().sendKeys(address);
		employee.getProjectAccess(Project);
		employee.uploadAdharCard().sendKeys(Adharcard);
		employee.getPancard().sendKeys(pancard);
		employee.SelectGender().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		employee.EmpSelectbtn().click(); 
		employee.EmpEntry().click(); 
		employee.EmpModify().click();
		employee.EmpExport().click(); 

		employee.Receiptselectbtn().click(); 
		employee.ReceiptEntry().click(); 
		employee.ReceiptModify().click();
		employee.ReceiptExport().click();

		employee.InquiryEntry().click();
		employee.InquiryModify().click();
		employee.InquiryExport().click();

		employee.ProspectSelectbtn().click();
		employee.ProspectRemove().click();

		employee.BookingEntry().click();
		employee.BookingModify().click();
		employee.BookingExport().click();
		employee.ApproveReject().click();
		employee.AllowBooking().click();

		employee.DocumentSelectbtn().click();
		employee.DocumentEntry().click();
		employee.DocumentModify().click();
		employee.DocumentExport().click();

		Thread.sleep(2000);
		employee.CreateBtn1().click();		
	}

	//Edit Employee and Active Employee
	@Test(dataProvider="EmployeeEditData")
	public void Edit_Employee(String Firstname,String Midllename,String designation,String newemail,String newmobileno) throws InterruptedException {

		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(Firstname+ Keys.ENTER);//Required Field

		employee.getEdit().click();

		employee.getmname().clear();
		employee.getmname().sendKeys(Midllename);

		employee.getDesignation().clear();
		employee.getDesignation().sendKeys(designation);//Required Field

		employee.getEmail().clear();
		employee.getEmail().sendKeys(newemail);//Required Field

		employee.getMobileno().clear();
		employee.getMobileno().sendKeys(newmobileno);//Required Field

		Thread.sleep(2000);
		employee.getActiveEmployee().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		Thread.sleep(2000);
		employee.getUpdate().click();
	}

	//Delete Employee
	@Test(dataProvider="EmployeeDeleteData")
	public void Delete_Employee(String Firstname) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(Firstname+ Keys.ENTER);
		employee.deleteEmployee().click();

		Thread.sleep(2000);
		employee.getClickYes().click();
	}

	//Search Employee
	@Test(dataProvider="EmployeeSearchData")
	public void Search_Employee(String Firstname) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(2000);
		employee.getSearch().sendKeys(Firstname+ Keys.ENTER);
	}

	//Designation Apply Filter
	@Test(dataProvider="EmployeeFilterData")
	public void Apply_Filter(String Filter) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		Thread.sleep(2000);
		employee.Applyfilter(Filter);
	}

	//Export to Excel Employee
	@Test()
	public void Export_To_Excel_Employee() throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		Thread.sleep(2000);
		employee.ExporttoExcel().click();
	}

	//Add Employee Test Mandatory Filed Validation
	@Test
	public void Add_Employee_Test_Mandatory_Filed_Validation() throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getaddemployee().click();
		employee.Nextbtn().click();
		Thread.sleep(2000);

		WebElement firstname =driver.findElement(By.xpath("//span[normalize-space()='First Name is required.']"));
		Assert.assertEquals(firstname.getText(), "First Name is required.");

		WebElement LastName =driver.findElement(By.xpath("//span[normalize-space()='Last Name is required.']"));
		Assert.assertEquals(LastName.getText(), "Last Name is required.");

		WebElement Designation =driver.findElement(By.xpath("//span[normalize-space()='Designation is required.']"));
		Assert.assertEquals(Designation.getText(), "Designation is required.");

		WebElement DOB =driver.findElement(By.xpath("//span[normalize-space()='Dob is required.']"));
		Assert.assertEquals(DOB.getText(), "Dob is required.");

		WebElement Email =driver.findElement(By.xpath("//span[normalize-space()='Email is required.']"));
		Assert.assertEquals(Email.getText(), "Email is required.");

		WebElement State =driver.findElement(By.xpath("//span[normalize-space()='State is required.']"));
		Assert.assertEquals(State.getText(), "State is required.");		

		WebElement Mobile =driver.findElement(By.xpath("//span[normalize-space()='Mobile No is required.']"));
		Assert.assertEquals(Mobile.getText(), "Mobile No is required.");		

		WebElement AdharCard =driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/mat-dialog-content/div[2]/div[8]/div/div[1]/mat-form-field/div[2]/div/mat-error"));
		Assert.assertEquals(AdharCard.getText(), "Aadhar Card is required");		

		WebElement PanCard =driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/mat-dialog-content/div[2]/div[8]/div/div[2]/mat-form-field/div[2]/div/mat-error"));
		Assert.assertEquals(PanCard.getText(), "PAN Card is required");		

		//WebElement Gender =driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/mat-dialog-content/div[3]/div[1]/mat-error"));
		//Assert.assertEquals(Gender.getText(), "Gender is required.");		
	}

	//Edit Employee Test Mandatory Filed Validation
	@Test(dataProvider="EmployeeSearchData")
	public void Edit_Employee_Test_Mandatory_Filed_Validation(String Firstname) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(Firstname+ Keys.ENTER);
		employee.getEdit().click();

		employee.getfname().sendKeys(Keys.END);
		for(int i=1;i<=10;i++)
		{
			employee.getfname().sendKeys(Keys.BACK_SPACE);
		}
		employee.getlname().click();
		for (int i = 0; i < 4; i++) {
			employee.getlname().sendKeys(Keys.BACK_SPACE);
		}

		employee.getEmail().sendKeys(Keys.END);
		String emailText = employee.getEmail().getAttribute("value");
		int emailLength = emailText.length();

		for (int i = 0; i < emailLength; i++) {
			employee.getEmail().sendKeys(Keys.BACK_SPACE);
		}

		employee.getMobileno().sendKeys(Keys.END);
		String mobiletext=employee.getMobileno().getAttribute("value");
		int mobileLength=mobiletext.length();

		for (int i = 0; i < mobileLength; i++) {
			employee.getMobileno().sendKeys(Keys.BACK_SPACE);
		}

		employee.getPassword().sendKeys(Keys.TAB);

		WebElement firstname =driver.findElement(By.xpath("//span[normalize-space()='First Name is required.']"));
		Assert.assertEquals(firstname.getText(), "First Name is required.");

		WebElement LastName =driver.findElement(By.xpath("//span[normalize-space()='Last Name is required.']"));
		Assert.assertEquals(LastName.getText(), "Last Name is required.");

		WebElement Email =driver.findElement(By.xpath("//span[normalize-space()='Email is required.']"));
		Assert.assertEquals(Email.getText(), "Email is required.");

		WebElement Mobile =driver.findElement(By.xpath("//span[normalize-space()='Mobile No is required.']"));
		Assert.assertEquals(Mobile.getText(), "Mobile No is required.");		
	}

	//Active Inactive Roles
	//Verify Add Inactive Roles
	@Test()
	public void Verify_Add_Inactive_Roles() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Thread.sleep(2000);
		Role.getEditRolebuttonclick().click();
		Thread.sleep(2000);
		Role.getaddrolename().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		Role.getActiveInactiveRoles().click();
		Role.geteditsavebuttonrole().click();

		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getaddemployee().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='roleRightId']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Adminnewside"))
			{
				Assert.assertFalse(false, "Roles is inactive.");
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

	//Verify Add Active Roles
	@Test()
	public void Verify_Add_Active_Inquiry_Status() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Thread.sleep(2000);
		Role.getEditRolebuttonclick().click();
		Thread.sleep(2000);
		Role.getaddrolename().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		Role.getActiveInactiveRoles().click();
		Role.geteditsavebuttonrole().click();

		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getaddemployee().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='roleRightId']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Adminnewside"))
			{
				Assert.assertTrue(true, "Role is Active.");
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
	
	

	//Close the driver
	@AfterMethod()
	public void teardown() {
		//driver.close();
	}

	//DataProvider for Add Employee
	@DataProvider
	public Object[][] EmployeeAddData() {
		return new Object[][] {
			//{"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","Automation","QA","Test","Automation","SDET","06/09/2006",
				//"akash20@mailinator.com","","Ahmedabad","Goa","9865321254","Sit@321#","Ambli,Bopal gam"," marin drive lake view ",
				//"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png"}
			{"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","Parth","SDET","Patel","Admin","SDETQA","11/10/2006",
				"pp@yopmail.com","","Ahmedabad","Gujrat","8754210232","Sit@321#","Ghuma,Ahmedabad"," marin drive lake view ",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png"}
		};
	}

	//DataProvider for Edit Employee
	@DataProvider
	public Object[][] EmployeeEditData() {
		return new Object[][] {
			//Firstname,  Middlename, Designation,    Email,                        Mobile no
			{"Automation", "QAT",       "SDET",     "akash2024@mail.com",        "9806547854"}};
	}

	//DataProvider for Search Employee
	@DataProvider
	public Object[][] EmployeeSearchData() {
		return new Object[][] {
			//Firstname
			{"Automation"}};
	}

	//DataProvider for Apply Filter for Employee
	@DataProvider
	public Object[][] EmployeeFilterData() {
		return new Object[][] {
			{" Developer "}};
	}

	//DataProvider for Delete Employee
	@DataProvider
	public Object[][] EmployeeDeleteData() {
		return new Object[][] {
			{"Abhimanyu"}};//Firstname
	}
}