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
import pageObjects.InquiryPage;
import pageObjects.LoginPage;
import resources.base;

public class ActiveInactiveEmployee extends base {

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

	//Add Employee with All Modules - All Roles
	@Test(dataProvider="EmployeeAddData")
	public void Add_Employee_All_Roles(String profileImg,String Firstname,String Midllename,String Lastname,String Username,String designation,
			String dob,String email,String Role,String City,String State,String mobileno,String password,String address,String Project,
			String Adharcard,String pancard,String ActiveFirstname) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);

		SoftAssert softAssert = new SoftAssert();

		employee.getEmployee().click();
		employee.getaddemployee().click();

		employee.getProfileImg().sendKeys(profileImg);

		softAssert.assertFalse(Firstname.isEmpty(), "First name is required.");
		softAssert.assertNotNull(Firstname, "First name cannot be null.");
		employee.getfname().sendKeys(Firstname);//Required Field

		employee.getmname().sendKeys(Midllename);

		softAssert.assertFalse(Lastname.isEmpty(), "Last name is required.");
		softAssert.assertNotNull(Lastname, "Last name cannot be null.");
		employee.getlname().sendKeys(Lastname);//Required Field

		employee.getUserName().sendKeys(Username);

		softAssert.assertFalse(designation.isEmpty(), "Designation is required.");
		softAssert.assertNotNull(designation, "Designation cannot be null.");
		employee.getDesignation().sendKeys(designation);//Required Field

		employee.getDOB().sendKeys(dob);

		softAssert.assertFalse(email.isEmpty(), "Email is required.");
		softAssert.assertNotNull(email, "Email cannot be null.");    
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		softAssert.assertTrue(email.matches(emailRegex), "Invalid email format.");
		employee.getEmail().sendKeys(email);//Required Field

		employee.getRoles(Role);
		employee.getcity().sendKeys(City);

		softAssert.assertFalse(State.isEmpty(), "State is required.");
		softAssert.assertNotNull(State, "State cannot be null.");
		employee.getstate(State);//Required Field

		softAssert.assertFalse(mobileno.isEmpty(), "Mobile number is required.");
		softAssert.assertNotNull(mobileno, "Mobile number cannot be null.");
		employee.getMobileno().sendKeys(mobileno);//Required Field

		employee.getPassword().sendKeys(password);
		employee.getAddress().sendKeys(address);
		employee.getProjectAccess(Project);

		softAssert.assertFalse(Adharcard.isEmpty(), "Aadhar card file path is required.");
		softAssert.assertNotNull(Adharcard, "Aadhar card file path cannot be null.");
		employee.uploadAdharCard().sendKeys(Adharcard);//Required Field

		softAssert.assertFalse(pancard.isEmpty(), "PAN card is required.");
		softAssert.assertNotNull(pancard, "PAN card cannot be null.");
		employee.getPancard().sendKeys(pancard);//Required Field

		WebElement genderElement = employee.SelectGender();
		softAssert.assertTrue(genderElement.isEnabled(), "Gender selection is required but not enabled.");
		genderElement.click();
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

		employee.getSearch().sendKeys(ActiveFirstname+ Keys.ENTER);//Required Field
		employee.getEdit().click();

		employee.getActiveEmployee().click();

		Thread.sleep(2000);
		employee.Nextbtn().click();

		Thread.sleep(2000);
		employee.getUpdate().click();
		softAssert.assertAll();
	}

	//Add Inquiry
	@Test(dataProvider = "InquiryAdddata")
	public void Add_Inquiry(String Attende) throws InterruptedException {
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
				Assert.assertTrue(false, "Attende is inactive.");
				//System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test ");	
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

	//DataProvider for Add Employee
	@DataProvider
	public Object[][] EmployeeAddData() {
		return new Object[][] {
			{"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","Automation","QA","Test","Automation","SDET","06/09/2006","akash20@mailinator.com",
				"","Ahmedabad","Goa","9865321254","Sit@321#","Ambli,Bopal gam"," marin drive lake view ",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","Automation"}};
	}
	//DataProvider for Add Inquiry
	@DataProvider
	public Object[][] InquiryAdddata() {
		return new Object[][] { 
			{"Automation Test"}};
	}
}