package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	@Test(dataProvider = "getAdddata")
	public void Add_Rolepage(String Rolepage1 ) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(Rolepage1);
		Role.getshowphonenumberchecked().click();
		Thread.sleep(2000);
		Role.getclickcreate().click();
	}

	//Edit Role
	@Test(dataProvider = "getEditdata")
	public void Edit_Rolepage(String EditRolepage1) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getEditRolebuttonclick().click();
		Role.getupdateEditrole().clear();
		Role.getupdateEditrole().sendKeys(EditRolepage1);
		Thread.sleep(3000);
		Role.geteditsavebuttonrole().click();
	}

	//Status Role Method
	@Test
	public void Status_Rolepage1() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getRolestatusclick().click();
		Role.getRolestatusclickconfirm().click();
	}

	//Delete Role Method
	@Test
	public void Delete_Rolepage() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getdeleteclickRole().click();
		Role.getdeleteclickconfirmationRole().click();
	}

	//Search Role Method
	@Test(dataProvider = "getsearch")
	public void searching_Rolepage(String searchedentertextRolepage1) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getsearchRole().sendKeys(searchedentertextRolepage1);
		Role.getclicksearchrole().click();
	}

	//Export To Excel Method
	@Test
	public void exportexcel_Rolepage() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getclickexportasexcelRole().click();
	}

	//Add Role with - Only View Rights
	@Test(dataProvider="getAdddata")
	public void Add_Role_Only_View(String RoleName) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(RoleName);
		
		Role.EmpSelectbtn().click();
		Role.EmpRoleView().click();
		Role.Projectselectbtn().click();
		Role.ProjectRoleView().click();
		Role.Receiptselectbtn().click();
		Role.ReceiptRoleView().click();
		Role.Collectionselectbtn().click();
		Role.CollectionRoleView().click();
		Role.Inquiryselectbtn().click();
		Role.InquiryRoleView().click();
		Role.Prospectselectbtn().click();
		Role.ProspectRoleView().click();
		Role.Bookingselectbtn().click();
		Role.BookingRoleView().click();
		Role.Documentselectbtn().click();
		Role.DocumentsRoleView().click();
		Thread.sleep(2000);
		Role.getclickcreate().click();
	}

	//Add Role with - Add Rights only
	@Test(dataProvider="getAdddata")
	public void Add_Role_Only_Add(String RoleName) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(RoleName);
			
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
		Thread.sleep(2000);
		Role.getclickcreate().click();
	}

	//Add Role with - Only Update Rights
	@Test(dataProvider="getAdddata")
	public void Add_Role_Only_Update(String RoleName) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(RoleName);
				
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
		Thread.sleep(2000);
		Role.getclickcreate().click();
	}
	
	//Add Role with - Only Delete Rights
	@Test(dataProvider="getAdddata")
	public void Add_Role_Only_Delete(String RoleName) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(RoleName);
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
		Thread.sleep(2000);
		Role.getclickcreate().click();
	}
	
	//Add Role with - Only Export Rights
	@Test(dataProvider="getAdddata")
	public void Add_Role_Only_Export(String RoleName) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(RoleName);
			
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
			
		Thread.sleep(2000);
		Role.getclickcreate().click();
	}
	
	//Add Role with - Only Follow Up Rights
	@Test(dataProvider="getAdddata")
	public void Add_Role_Only_FollowUp(String RoleName) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(RoleName);
				
		Role.Inquiryselectbtn().click();
		Role.InquiryRoleFollowUp().click();
		Role.Prospectselectbtn().click();
		Role.ProspectRolefollowUp().click();
				
		Thread.sleep(2000);
		Role.getclickcreate().click();
	}
	
	   //Add Role with - Only Allow Booking Rights
    @Test(dataProvider="getAdddata")
    public void Add_Role_Only_AllowBooking(String RoleName) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(RoleName);
					
		Role.Bookingselectbtn().click();
		Role.BookingRoleApproveReject().click();
		Role.BookingRoleLegalEntry().click();
			
		Thread.sleep(2000);
		Role.getclickcreate().click();
	}
	
	//DataProvider for Add Data
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { {"AdminSuper"} };
	}

	//DataProvider for Edit State
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { {"Adminnewside"} };
	}
	
    //DataProvider for Search Data
	@DataProvider
	public Object[][] getsearch() {
		return new Object[][] { {"Admin"} };
	}
}