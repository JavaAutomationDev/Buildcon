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

		// Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	// Add Role
	@Test(dataProvider = "getAdddata")
	public void Add_Rolepage(String Rolepage1 ) throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getaddnewrole().click();
		unit.getaddrolename().sendKeys(Rolepage1);
		unit.getshowphonenumberchecked().click();
		Thread.sleep(3000);
		unit.getclickcreate().click();
	}
	// Edit Role

	@Test(dataProvider = "getEditdata")
	public void Edit_Rolepage(String EditRolepage1) throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getEditRolebuttonclick().click();
		unit.getupdateEditrole().clear();
		unit.getupdateEditrole().sendKeys(EditRolepage1);
		Thread.sleep(3000);
		unit.geteditsavebuttonrole().click();
	}

	@Test
	public void Status_Rolepage1() throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getRolestatusclick().click();
		unit.getRolestatusclickconfirm().click();
	}


	@Test
	public void Delete_Rolepage() throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getdeleteclickRole().click();
		unit.getdeleteclickconfirmationRole().click();
	}

	@Test(dataProvider = "getsearch")
	public void searching_Rolepage(String searchedentertextRolepage1) throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getsearchRole().sendKeys(searchedentertextRolepage1);
		unit.getclicksearchrole().click();
	}
	
	@Test
	public void exportexcel_Rolepage() throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getclickexportasexcelRole().click();
	
	}

	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Adminoldside" } };
	}

	// DataProvider for edit state
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Adminnewside" } };
	}

	@DataProvider
	public Object[][] getsearch() {
		return new Object[][] { {"Admin"} };
	}

}
