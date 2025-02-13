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

import pageObjects.LoginPage;
import pageObjects.Rolepage;
import resources.base;

public class RoleTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver = initializeDriver();
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

	//Add Role
	@Test(dataProvider = "getAdddata",priority =1)
	public void Add_Role(String Rolepage1 ) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(Rolepage1);
		//Role text Data validation
		String valid_string = valid_alphanum(Rolepage1,"Rolepage",10);
		String valid_Rolepage = valid_string;
		System.out.println(valid_Rolepage);

		Role.getshowphonenumberchecked().click();
		Thread.sleep(3000);
       
		Role.EmpAllselectbtn().click();
		Thread.sleep(1000);
		
		Role.ProjectAllselectbtn().click();
		Thread.sleep(1000);
		
		Role.ReceiptAllselectbtn().click();
		Thread.sleep(1000);
		
		Role.ColectionAllselectbtn().click();
		Thread.sleep(1000);
		
		Role.CustomerAllselectbtn().click();
		Thread.sleep(1000);
		
		Role.InquiryAllselectbtn().click();
		Thread.sleep(1000);
		
		Role.ProspectAllselectbtn().click();
		Thread.sleep(1000);
		
		Role.BookingAllselectbtn().click();
		Thread.sleep(1000);
		
		Role.documentAllselectbtn().click();
		Thread.sleep(1000);
		
		
		
		
		
		
		Thread.sleep(3000);
		Role.getclickcreate().click();
		Thread.sleep(3000);

		softAssert.assertEquals(valid_Rolepage, "Rolepage is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertAll();
		
	}

	//Add Role - Only View
	@Test(dataProvider = "Onlyviewdata",priority =2)
	public void Add_Role_Only_View(String Rolepage1 ) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(Rolepage1);

		Role.EmpSelectbtn().click();
		Role.EmpRoleView().click();

		Role.Projectselectbtn().click();
		Role.ProjectRoleView().click();

		Role.Receiptselectbtn().click();
		Role.ReceiptRoleView().click();

		Role.Collectionselectbtn().click();
		Role.CollectionRoleView().click();

		Role.Customerselectbtn().click();
		Role.CustomerRoleView().click();

		Role.Inquiryselectbtn().click();
		Role.InquiryRoleView().click();

		Role.Prospectselectbtn().click();
		Role.ProspectRoleView().click();

		Role.Bookingselectbtn().click();
		Role.BookingRoleView().click();

		Role.Documentselectbtn().click();
		Role.DocumentsRoleView().click();	

		Thread.sleep(3000);
		Role.getclickcreate().click();
		Thread.sleep(3000);
		
		softAssert.assertAll();
	}
	//Add Role - Only Entry
	@Test(dataProvider = "OnlyEntrydata",priority =3)
	public void Add_Role_Only_Entry(String Rolepage1 ) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(Rolepage1);

		Role.EmpSelectbtn().click();
		Role.EmpRoleEntry().click();

		Role.Projectselectbtn().click();
		Role.ProjectRoleEntry().click();

		Role.Receiptselectbtn().click();
		Role.ReceiptRoleEntry().click();

		Role.Inquiryselectbtn().click();
		Role.InquiryRoleEntry().click();

		Role.Prospectselectbtn().click();
		Role.ProspectRoleEntry().click();

		Role.Bookingselectbtn().click();
		Role.BookingRoleEntry().click();

		Role.Documentselectbtn().click();
		Role.DocumentsRoleEntry().click();	

		Thread.sleep(3000);
		Role.getclickcreate().click();
		Thread.sleep(3000);
		
		softAssert.assertAll();
	}

	//Add Role - Only Modify
	@Test(dataProvider = "OnlyUpdatedata",priority =4)
	public void Add_Role_Only_Update(String Rolepage1 ) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(Rolepage1);

		Role.EmpSelectbtn().click();
		Role.EmpRoleUpdate().click();

		Role.Projectselectbtn().click();
		Role.ProjectRoleUpdate().click();

		Role.Receiptselectbtn().click();
		Role.ReceiptRoleUpdate().click();

		Role.Inquiryselectbtn().click();
		Role.InquiryRoleUpdate().click();

		Role.Prospectselectbtn().click();
		Role.ProspectRoleUpdate().click();

		Role.Bookingselectbtn().click();
		Role.BookingRoleUpdate().click();

		Role.Documentselectbtn().click();
		Role.DocumentsRoleUpdate().click();	

		Thread.sleep(3000);
		Role.getclickcreate().click();
		Thread.sleep(3000);
		
		softAssert.assertAll();
	}

	//Add Role - Only Remove
	@Test(dataProvider = "OnlyRemovedata",priority =5)
	public void Add_Role_Only_Remove(String Rolepage1 ) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(Rolepage1);

		Role.EmpSelectbtn().click();
		Role.EmpRoleDelete().click();

		Role.Projectselectbtn().click();
		Role.ProjectRoleDelete().click();

		Role.Receiptselectbtn().click();
		Role.ReceiptRoleDelete().click();

		Role.Inquiryselectbtn().click();
		Role.InquiryRoleDelete().click();

		Role.Prospectselectbtn().click();
		Role.ProspectRoleDelete().click();

		Role.Bookingselectbtn().click();
		Role.BookingRoleDelete().click();

		Role.Documentselectbtn().click();
		Role.DocumentsRoleDelete().click();	

		Thread.sleep(3000);
		Role.getclickcreate().click();
		Thread.sleep(3000);
		
		softAssert.assertAll();
	}

	//Add Role - Only Export
	@Test(dataProvider = "OnlyExportdata",priority =6)
	public void Add_Role_Only_Export(String Rolepage1 ) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(Rolepage1);

		Role.EmpSelectbtn().click();
		Role.EmpRoleExport().click();

		Role.Projectselectbtn().click();
		Role.ProjectRoleExport().click();

		Role.Receiptselectbtn().click();
		Role.ReceiptRoleExport().click();

		Role.Collectionselectbtn().click();
		Role.CollectionRoleExport().click();

		Role.Customerselectbtn().click();
		Role.CustomerRoleExport().click();

		Role.Inquiryselectbtn().click();
		Role.InquiryRoleExport().click();

		Role.Prospectselectbtn().click();
		Role.ProspectRoleExport().click();

		Role.Bookingselectbtn().click();
		Role.BookingRoleExport().click();

		Role.Documentselectbtn().click();
		Role.DocumentsRoleExport().click();	

		Thread.sleep(3000);
		Role.getclickcreate().click();
		Thread.sleep(3000);
		
		softAssert.assertAll();
	}
	//Edit Role
	@Test(dataProvider = "getEditdata",priority =7)
	public void Edit_Role(String EditRolepage1,String searchedentertextRolepage1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getsearchRole().sendKeys(searchedentertextRolepage1);
		Role.getclicksearchrole().click();
		Role.getEditRolebuttonclick().click();

		Role.getupdateEditrole().clear();
		Role.getupdateEditrole().sendKeys(EditRolepage1);
		//Role Data Validation
		String valid_string = valid_alphanum(EditRolepage1,"Rolepage",30);
		String valid_Rolepage = valid_string;
		System.out.println(valid_Rolepage);

		Thread.sleep(3000);
		Role.geteditsavebuttonrole().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_Rolepage, "Rolepage is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Status Role Method
	@Test(dataProvider = "getstatuschange",priority =8)
	public void Status_Role(String searchedentertextRolepage1) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getsearchRole().sendKeys(searchedentertextRolepage1);
		Role.getclicksearchrole().click();
		Role.getRolestatusclick().click();
		Role.getRolestatusclickconfirm().click();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] getstatuschange() {
		return new Object[][] { {"Test RoleAll"} };
	}

	//Delete Role Method
	@Test(dataProvider = "getdelete",priority =11)
	public void Delete_Role(String searchedentertextRolepage1) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getsearchRole().sendKeys(searchedentertextRolepage1);
		Role.getclicksearchrole().click();
		Role.getdeleteclickRole().click();
		Role.getdeleteclickconfirmationRole().click();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] getdelete() {
		return new Object[][] { { "Test RoleAll" }, { "Test Role OnlyViw" }, {"Test Role OnlyAdd"}, {"Test Role OnlyUpdate"},{"Test Role OnlyRemove"},{"Test Role OnlyExport"}   };
	}

	//Search Role Method
	@Test(dataProvider = "getsearch",priority =9)
	public void Search_Role(String searchedentertextRolepage1) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getsearchRole().sendKeys(searchedentertextRolepage1);
		Role.getclicksearchrole().click();
		Thread.sleep(2000);
	}

	//Export To Excel Method
	@Test(priority =10)
	public void Export_Excel_Role() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getclickexportasexcelRole().click();
	}

	//Add Validation Role
	@Test(priority =12)
	public void Add_Validation_Role() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getshowphonenumberchecked().click();

		Thread.sleep(2000);
		Role.getclickcreate().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
						+ "mat-dialog-content/form/div/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Role is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Role is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Edit Validation Role
	@Test(priority =12)
	public void Edit_Validation_Role() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getEditRolebuttonclick().click();
		int roles = Role.getupdateEditrole().getAttribute("value").length();
		for(int i =1;i<=roles;i++) {
			Role.getupdateEditrole().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		Role.geteditsavebuttonroleptionsecond().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div"
						+ "/mat-dialog-content/form/div/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Role is required";
		softAssert.assertEquals("Role is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	// close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}
	//DataProvider for Add data
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Test RoleAll" } };
	}

	//DataProvider for Add with Only view data
	@DataProvider
	public Object[][] Onlyviewdata() {
		return new Object[][] { { "Test Role OnlyViw" } }; 
	}

	//DataProvider for Add with Only Entry data
	@DataProvider
	public Object[][] OnlyEntrydata() {
		return new Object[][] { { "Test Role OnlyAdd" } };
	}

	//DataProvider for Add with Only Update data
	@DataProvider
	public Object[][] OnlyUpdatedata() {
		return new Object[][] { { "Test Role OnlyUpdate" } };
	}
	
	//DataProvider for Add with Only Remove data
	@DataProvider
	public Object[][] OnlyRemovedata() {
		return new Object[][] { { "Test Role OnlyRemove" } };
	}
	
	//DataProvider for Add with Only Export data
	@DataProvider
	public Object[][] OnlyExportdata() {
		return new Object[][] { { "Test Role OnlyExport" } };
	}

	//DataProvider for Edit State
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { {"Test RoleAll Update","Test RoleAll"} };
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] getsearch() {
		return new Object[][] { {"Test RoleAll"} };
	}
}