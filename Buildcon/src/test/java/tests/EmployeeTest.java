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
import pageObjects.Rolepage;
import resources.base;

public class EmployeeTest extends base {
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver = initializeDriver();
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

	//Add Employee with All Modules - All Roles
	@Test(dataProvider="EmployeeAddData")
	public void Add_Employee_All_Roles(String profileImg,String Firstname,String Midllename,String Lastname,String Username,String designation,
			String dob,String email,String Role,String City,String State,String mobileno,String password,String address,String Project,
			String Adharcard,String pancard) throws InterruptedException {

			EmployeePage employee = new EmployeePage(driver);

		SoftAssert softAssert = new SoftAssert();
		
		employee.getEmployee().click();
		employee.getaddemployee().click();
		employee.Nextbtn().click();

		employee.getProfileImg().sendKeys(profileImg);
		softAssert.assertFalse(Firstname.isEmpty(), "First name is required.");
		softAssert.assertNotNull(Firstname, "First name cannot be null.");
		employee.getfname().sendKeys(Firstname);// Required Field
		
		String valid_string = valid_text(Firstname, "firstname");
		String valid_firstname = valid_string;
		System.out.println(valid_firstname);
		employee.getmname().sendKeys(Midllename);
		
		String valid_string1 = valid_text(Midllename, "middlename");
		String valid_middlename = valid_string1;
		System.out.println(valid_middlename);

		softAssert.assertFalse(Lastname.isEmpty(), "Last name is required.");
		softAssert.assertNotNull(Lastname, "Last name cannot be null.");
		employee.getlname().sendKeys(Lastname);// Required Field
		
		String valid_string2 = valid_text(Lastname, "lastname");
		String valid_Lastname = valid_string2;
		System.out.println(valid_Lastname);

		employee.getUserName().sendKeys(Username);
		String valid_string3 = valid_text(Username, "username");
		String valid_username = valid_string3;
		System.out.println(valid_username);

		softAssert.assertFalse(designation.isEmpty(), "Designation is required.");
		softAssert.assertNotNull(designation, "Designation cannot be null.");
		employee.getDesignation().sendKeys(designation);// Required Field
		String valid_string4 = valid_text(designation, "Designation");
		String valid_designation = valid_string4;
		System.out.println(valid_designation);

		employee.getDOB().sendKeys(dob);

		softAssert.assertFalse(email.isEmpty(), "Email is required.");
		softAssert.assertNotNull(email, "Email cannot be null.");
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		softAssert.assertTrue(email.matches(emailRegex), "Invalid email format.");
		employee.getEmail().sendKeys(email);// Required Field
		
		String valid_string5 = valid_EMail(email, "Email");
		String valid_emailid= valid_string5;
		System.out.println(valid_emailid);

		employee.getRoles(Role);
		employee.getcity().sendKeys(City);
		
		String valid_string6 = valid_text(City, "city");
		String valid_city = valid_string6;
		System.out.println(valid_city);

		softAssert.assertFalse(State.isEmpty(), "State is required.");
		softAssert.assertNotNull(State, "State cannot be null.");
		employee.getstate(State);// Required Field
		


		softAssert.assertFalse(mobileno.isEmpty(), "Mobile number is required.");
		softAssert.assertNotNull(mobileno, "Mobile number cannot be null.");
		employee.getMobileno().sendKeys(mobileno);// Required Field
		
              
		String valid_string8 = valid_number(mobileno, "Contactnumber");
		String valid_contactnumber = valid_string8;
		System.out.println(valid_contactnumber);

		employee.getPassword().sendKeys(password);
		
		String valid_string9 = valid_alphanum(password, "password", 10);
		String valid_password = valid_string9;
		System.out.println(valid_password);
		
		
		employee.getAddress().sendKeys(address);
		
		String valid_string10 = valid_alphanum(address, "ADDRESS", 40);
		String valid_address = valid_string10;
		System.out.println(valid_address);
		
		employee.getProjectAccess(Project);

		softAssert.assertFalse(Adharcard.isEmpty(), "Aadhar card file path is required.");
		softAssert.assertNotNull(Adharcard, "Aadhar card file path cannot be null.");
		employee.uploadAdharCard().sendKeys(Adharcard);// Required Field

		softAssert.assertFalse(pancard.isEmpty(), "PAN card is required.");
		softAssert.assertNotNull(pancard, "PAN card cannot be null.");
		employee.getPancard().sendKeys(pancard);// Required Field

		WebElement genderElement = employee.SelectGender();
		softAssert.assertTrue(genderElement.isEnabled(), "Gender selection is required but not enabled.");
		genderElement.click();
		employee.SelectGender().click();// Required Field

		Thread.sleep(2000);
		employee.Nextbtn().click();
		
		// data validation soft assert:
		 softAssert.assertEquals(valid_firstname, "Firstname is a  valid text");
		 softAssert.assertEquals(valid_middlename,"middlename is a valid text");
		 softAssert.assertEquals(valid_Lastname,  "Lastname is a valid text");
		 softAssert.assertEquals(valid_username, "username is a valid text");
		 softAssert.assertEquals(valid_designation, "Designation is a text");
		 softAssert.assertEquals(valid_emailid, "Email is a valid text");
		 softAssert.assertEquals(valid_city, "city is a valid text");
		 softAssert.assertEquals(valid_contactnumber, "contactname is a valid");
		 softAssert.assertEquals(valid_password, "password is a Valid Alpha-Numeric");
		 softAssert.assertEquals(valid_address, "address is a Valid Alpha-Numeric");
		
		// employee.Shownumber().click();
		
		
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

		softAssert.assertAll();
	}

	private String valid_text(String firstname, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	// Add Employee with All Modules - Only View
	@Test(dataProvider = "EmployeeAddData")
	public void Add_Employee_Only_View(String profileImg, String Firstname, String Midllename, String Lastname,
			String Username, String designation, String dob, String email, String Role, String City, String State,
			String mobileno, String password, String address, String Project, String Adharcard, String pancard)
			throws InterruptedException {
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

	// Add Employee with All Modules - Only Add
	@Test(dataProvider = "EmployeeAddData")
	public void Add_Employee_Only_Add(String profileImg, String Firstname, String Midllename, String Lastname,
			String Username, String designation, String dob, String email, String Role, String City, String State,
			String mobileno, String password, String address, String Project, String Adharcard, String pancard)
			throws InterruptedException {
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

	// Add Employee with All Modules - Only Edit
	@Test(dataProvider = "EmployeeAddData")
	public void Add_Employee_Only_Edit(String profileImg, String Firstname, String Midllename, String Lastname,
			String Username, String designation, String dob, String email, String Role, String City, String State,
			String mobileno, String password, String address, String Project, String Adharcard, String pancard)
			throws InterruptedException, IOException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();


		employee.getaddemployee().click();
		employee.getProfileImg().sendKeys(profileImg);
		employee.getfname().sendKeys(Firstname);
		
		String valid_string1 = validateText(Firstname, "Contactnumber",10, 20);
		String valid_Firstname = valid_string1;
		System.out.println(valid_Firstname);

		employee.getmname().sendKeys(Midllename);
		
		String valid_string2 = validateText(Midllename, "middlename",10, 20);
		String valid_middlename = valid_string2;
		System.out.println(valid_middlename);

		employee.getlname().sendKeys(Lastname);
		
		String valid_string3 = validateText(Lastname, "lastname",10, 20);
		String valid_Lastname = valid_string3;
		System.out.println(valid_Lastname);

		employee.getUserName().sendKeys(Username);
		
		String valid_string4 = validateText(Username, "username",5, 20);
		String valid_username = valid_string4;
		System.out.println(valid_username);

		employee.getDesignation().sendKeys(designation);
		
		String valid_string5 = valid_alphanum(Username, "username", 20);
		String valid_designation = valid_string5;
		System.out.println(valid_designation);
		employee.getDOB().sendKeys(dob);
		employee.getEmail().sendKeys(email);
		
		String valid_string6 = valid_EMail(email, "username");
		String valid_email = valid_string6;
		System.out.println(valid_email);
		
		employee.getRoles(Role);
		employee.getcity().sendKeys(City);

		String valid_string7= validateText(City, "city", 5, 15);
		String valid_city = valid_string7;
		System.out.println(valid_city);
		
		employee.getstate(State);
		employee.getMobileno().sendKeys(mobileno);
		
		String valid_string8= valid_number(mobileno, "number");
		String valid_mobilenumber = valid_string8;
		System.out.println(valid_mobilenumber);
		
		
		employee.getPassword().sendKeys(password);

		String valid_string9= valid_alphanumeric(password, "Password");
		String valid_password = valid_string9;
		System.out.println(valid_password);
		
		
		employee.getAddress().sendKeys(address);
		String valid_string10= valid_alphanumeric(address, "Address");
		String valid_Address = valid_string10;
		System.out.println(valid_Address);
		
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

	private String valid_alphanumeric(String mobileno, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	// Add Employee with All Modules - Only Delete
	@Test(dataProvider = "EmployeeAddData")
	public void Add_Employee_Only_Delete(String profileImg, String Firstname, String Midllename, String Lastname,
			String Username, String designation, String dob, String email, String Role, String City, String State,
			String mobileno, String password, String address, String Project, String Adharcard, String pancard)
			throws InterruptedException {
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

	// Edit Employee and Active Employee
	@Test(dataProvider = "EmployeeEditData")
	public void Edit_Employee(String Firstname, String Midllename, String designation, String newemail,
			String newmobileno) throws InterruptedException {

		EmployeePage employee = new EmployeePage(driver);
		SoftAssert softAssert = new SoftAssert();

		employee.getEmployee().click();

		employee.getSearch().sendKeys(Firstname + Keys.ENTER);// Required Field

		employee.getEdit().click();


		employee.getmname().clear();
		employee.getmname().sendKeys(Midllename);


		employee.getDesignation().clear();
		employee.getDesignation().sendKeys(designation);// Required Field

		employee.getEmail().clear();
		softAssert.assertFalse(newemail.isEmpty(), "Email is required.");
		softAssert.assertNotNull(newemail, "Email cannot be null.");
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		softAssert.assertTrue(newemail.matches(emailRegex), "Invalid email format.");
		employee.getEmail().sendKeys(newemail);// Required Field

		employee.getMobileno().clear();
		softAssert.assertFalse(newmobileno.isEmpty(), "Mobile number is required.");
		softAssert.assertNotNull(newmobileno, "Mobile number cannot be null.");
		employee.getMobileno().sendKeys(newmobileno);// Required Field

		Thread.sleep(2000);
		employee.getActiveEmployee().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		Thread.sleep(2000);
		employee.getUpdate().click();
	}

	// Delete Employee
	@Test(dataProvider = "EmployeeDeleteData")
	public void Delete_Employee(String Firstname) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);

		employee.getEmployee().click();
		employee.getSearch().sendKeys(Firstname + Keys.ENTER);
		employee.deleteEmployee().click();

		Thread.sleep(2000);
		employee.getClickYes().click();
	}

	// Search Employee
	@Test(dataProvider = "EmployeeSearchData")
	public void Search_Employee(String Firstname) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();

		Thread.sleep(2000);
		employee.getSearch().sendKeys(Firstname + Keys.ENTER);
	}

	// Designation Apply Filter
	@Test(dataProvider = "EmployeefilterData")
	public void Apply_Filter(String Filter) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();


		Thread.sleep(2000);
		employee.Applyfilter(Filter);
	}

	// Export to Excel Employee
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

		SoftAssert softAssert = new SoftAssert();
		WebElement firstname =driver.findElement(By.xpath("//span[normalize-space()='First Name is required.']"));
		softAssert.assertEquals(firstname.getText(), "First Name is required.");

		WebElement LastName =driver.findElement(By.xpath("//span[normalize-space()='Last Name is required.']"));
		softAssert.assertEquals(LastName.getText(), "Last Name is required.");

		WebElement Designation =driver.findElement(By.xpath("//span[normalize-space()='Designation is required.']"));
		softAssert.assertEquals(Designation.getText(), "Designation is required.");

		WebElement DOB =driver.findElement(By.xpath("//span[normalize-space()='Dob is required.']"));
		softAssert.assertEquals(DOB.getText(), "Dob is required.");

		WebElement Email =driver.findElement(By.xpath("//span[normalize-space()='Email is required.']"));
		softAssert.assertEquals(Email.getText(), "Email is required.");

		WebElement State =driver.findElement(By.xpath("//span[normalize-space()='State is required.']"));
		softAssert.assertEquals(State.getText(), "State is required.");		

		WebElement Mobile =driver.findElement(By.xpath("//span[normalize-space()='Mobile No is required.']"));
		softAssert.assertEquals(Mobile.getText(), "Mobile No is required.");		

		WebElement AdharCard =driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/mat-dialog-content/div[2]/div[8]/div/div[1]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(AdharCard.getText(), "Aadhar Card is required");		

		WebElement PanCard =driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/mat-dialog-content/div[2]/div[8]/div/div[2]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(PanCard.getText(), "PAN Card is required");		
		softAssert.assertAll();
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

		SoftAssert softAssert = new SoftAssert();
		WebElement firstname =driver.findElement(By.xpath("//span[normalize-space()='First Name is required.']"));
		softAssert.assertEquals(firstname.getText(), "First Name is required.");

		WebElement LastName =driver.findElement(By.xpath("//span[normalize-space()='Last Name is required.']"));
		softAssert.assertEquals(LastName.getText(), "Last Name is required.");

		WebElement Email =driver.findElement(By.xpath("//span[normalize-space()='Email is required.']"));
		softAssert.assertEquals(Email.getText(), "Email is required.");

		WebElement Mobile =driver.findElement(By.xpath("//span[normalize-space()='Mobile No is required.']"));
		softAssert.assertEquals(Mobile.getText(), "Mobile No is required.");
		softAssert.assertAll();
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

	// DataProvider for Add Employee
	@DataProvider
	public Object[][] EmployeeAddData() {
		return new Object[][] { { "D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png", "Automation", "QA", "Test",
				"Automation", "SDET", "06/09/2006", "akash20@mailinator.com", "", "Ahmedabad", "Goa", "9865321254",
				"Sit@321#", "Ambli,Bopal gam", " marin drive lake view ",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png", } };
	}

	// DataProvider for Edit Employee
	@DataProvider
	public Object[][] EmployeeEditData() {
		return new Object[][] {
				// Firstname, Middlename, Designation, Email, Mobile no
				{ "Automation", "QAT", "SDET", "akash2024@mail.com", "9806547854" } };
	}

	// DataProvider for Search Employee
	@DataProvider
	public Object[][] EmployeeSearchData() {
		return new Object[][] {
				// Firstname
				{ "Abhimanyu" } };
	}

	// DataProvider for Apply Filter for Employee
	@DataProvider
	public Object[][] EmployeefilterData() {
		return new Object[][] { { " Developer " } };
	}

	// DataProvider for Delete Employee
	@DataProvider
	public Object[][] EmployeeDeleteData() {
		return new Object[][] {
				// Firstname
				{ "Abhimanyu" } };
	}
}