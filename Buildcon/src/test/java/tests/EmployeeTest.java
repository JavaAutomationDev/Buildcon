package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.EmployeePage;
import pageObjects.LoginPage;
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
	@Test(dataProvider="getAddData")
	public void Add_Employee_All_Roles(String profileImg,String Firstname,String Midllename,String Lastname,String Username,String designation,
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
	@Test(dataProvider="getAddData")
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
	@Test(dataProvider="getAddData")
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
	@Test(dataProvider="getAddData")
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
	@Test(dataProvider="getAddData")
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
	
	//Delete Employee
	@Test(dataProvider="EmployeeDeleteData")
	public void Delete_Employee(String employeeName) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.deleteEmployeeByName(employeeName);
		employee.getClickYes().click();
	}
	//Search Employee
	@Test(dataProvider="getSearchData")
	public void Search_Employee(String Firstname) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.getSearch().sendKeys(Firstname+ Keys.ENTER);
	}
	//Designation Apply Filter
	@Test(dataProvider="EmployeefilterData")
	public void Apply_Filter(String Filter) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.Applyfilter(Filter);
	}
	//Export to Excel Employee
	@Test()
	public void Export_To_Excel_Employee() throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		employee.ExporttoExcel().click();
	}
	
	@AfterMethod()
	public void teardown() {
		//driver.close();
	}

	//DataProvider for Add Employee
	@DataProvider
	public Object[][] getAddData() {
		return new Object[][] {
			{"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","Automation","QA","Test","Automation","SDET","06/09/2006","akash20@mailinator.com",
				"","Ahmedabad","","9865321254","Sit@321#","Ambli,Bopal gam"," marin drive lake view ",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png"}};
	}
	//DataProvider for Search Employee
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"Abhimanyu"}};
	}
	//DataProvider for Apply Filter for Employee
	@DataProvider
	public Object[][] EmployeefilterData() {
		return new Object[][] {
			{" Developer "}};
	}
	//DataProvider for Delete Employee
	@DataProvider
	public Object[][] EmployeeDeleteData() {
		return new Object[][] {
			{"Abhimanyu"}};
	}
}