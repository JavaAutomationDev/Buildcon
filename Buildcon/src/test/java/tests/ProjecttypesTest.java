package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Projecttypespage;
import resources.base;

public class ProjecttypesTest extends base {

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

	// Add project types
	@Test(dataProvider = "getAdddata")
	public void Add_Project_Types(String projecttypes1) throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.Clickaddprojecttypes().click();
		projecttype.getaddprojecttypesdata().sendKeys(projecttypes1);
		Thread.sleep(3000);
		projecttype.getsavebuttonprojecttypes().click();
	}
	// Edit project types

	@Test(dataProvider = "getEditdata")
	public void Edit_Project_Types(String Editprojecttypes1) throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.geteditprojecttypes().click();
		projecttype.geteditexistingdata().clear();
		projecttype.geteditexistingdata().sendKeys(Editprojecttypes1);
		Thread.sleep(3000);
		projecttype.geteditsave().click();
	}
	
	@Test
	public void Status_Change_Project_Types() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.getclickchangestatus().click();
		projecttype.getconfirmationchangestatus().click();
	}
	
	@Test
	public void Delete_Project_Type() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.getdeleteclick().click();
		projecttype.getdeleteclickconfirmation().click();
	}
	
	@Test(dataProvider = "getsearched")
	public void Searching_Project_Types(String searchedentertext) throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.getsearchprojecttypes().sendKeys(searchedentertext);
		projecttype.getclicksearchedbutton().click();
	}
	
	@Test
	public void Excel_Project_Types( ) throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.getclickexcelbuttonproject().click();
	}
	
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "CCR" } };
	}

	// DataProvider for edit state
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Addee" } };
	}
	
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "CCR" }};
	}
}
