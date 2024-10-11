package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Projectstatuspage;
import resources.base;

public class ProjectStatusTest extends base {

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

	// Add project status
	@Test(dataProvider = "getAdddata")
	public void Add_projectstatus(String projectstatus1) throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getaddprojectstatusclick().click();
		unit.getprojectstatusadddata().sendKeys(projectstatus1);
		Thread.sleep(3000);
		unit.getprojectstatussave().click();
	}
	// Edit project status

	@Test(dataProvider = "getEditdata")
	public void Edit_projectstatus(String Editprojectstatus1) throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectstatuseditclick().click();
		unit.getprojectStatuseditnewdataadd().clear();
		unit.getprojectStatuseditnewdataadd().sendKeys(Editprojectstatus1);
		Thread.sleep(3000);
		unit.getprojectstatussave().click();
	}
	
	@Test
	public void statuschange_projectstatus() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectStatuschecked().click();
		unit.getprojectStatuscheckedconfirmation().click();
	}
	
	@Test
	public void Delete_projectstatus() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectstatusdeleteclick().click();
		unit.getprojectstatusdeleteconfirmation().click();
	}
	
	@Test(dataProvider = "getsearched")
	public void searching_projectstatus1(String searchedentertext) throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectStatussearchedchecked().sendKeys(searchedentertext);
		unit.getprojectstatussearchediteam().click();
	}
	
	@Test
	public void excel_projectstatus() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectStatusexcel().click();
	}
    
	
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "completed" } };
	}

	// DataProvider for edit state
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "pvartiallycompleted" } };
	}
	
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "completed" }};
	}
}
