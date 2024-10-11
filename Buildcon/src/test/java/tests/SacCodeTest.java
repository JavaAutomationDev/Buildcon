package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Saccodepage;
import resources.base;

public class SacCodeTest extends base {

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
	public void Add_Saccode(String Saccode1,String DESCRIPTION1,String gst1) throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getaddsaccode().click();
		unit.getsaccodeenter().sendKeys(Saccode1);
		unit.getdescription().sendKeys(DESCRIPTION1);
		unit.getgst().sendKeys(gst1);
		unit.getsavebuttonsaccode().click();
	}
	// Edit project types

	@Test(dataProvider = "getEditdata")
	public void Edit_saccode(String editgst1) throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getEditclicksaccode().click();
		unit.getEditgst().sendKeys(editgst1);
		unit.getEditsavebutton().click();
	}

	@Test
	public void statuschange_saccode() throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getchangestatus().click();
		unit.getchangestatusconfirm().click();
	}

	@Test
	public void Delete_saccode() throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getdeletesaccode().click();
		unit.getdeletesaccodeconfirm().click();
	}

	@Test(dataProvider = "getsearch")
	public void searching_projecttypes(String searchedentertext) throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getsearchsaccode().sendKeys(searchedentertext);
		unit.getsearchsaccodeconfirmclick().click();
	}
    
	
	@Test
	public void Exportasaexcel_saccode() throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getexcelclicksaccode().click();
	}
	
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "saccod","Hello","4" } };
	}

	// DataProvider for edit state
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "EditSacCode" } };
	}

	@DataProvider
	public Object[][] getsearch() {
		return new Object[][] { { "EditSacCode" } };
	}
}
