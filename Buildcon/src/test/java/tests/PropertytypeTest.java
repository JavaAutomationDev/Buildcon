package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Propertytypepage;
import resources.base;

public class PropertytypeTest extends base {

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
	public void Add_propertytypes(String propertytype1) throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.getaddpropertytype().click();
		unit.getaddpropertytypedata().sendKeys(propertytype1);
		Thread.sleep(3000);
		unit.getsavebuttonaddpropertytype().click();
	}
	// Edit project types

	@Test(dataProvider = "getEditdata")
	public void Edit_propertytypes(String Editpropertyttypes1) throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.geteditpropertytype().click();
		unit.geteditpropertytypeenterdata().clear();
		unit.geteditpropertytypeenterdata().sendKeys(Editpropertyttypes1);
		Thread.sleep(3000);
		unit.getsavebuttoneditpropertytype().click();
	}

	@Test
	public void Delete_propertytype() throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.getdeletepropertytypeclick().click();
		unit.getdeletepropertytypeconfirmation().click();
	}
	
	@Test
	public void Statuschang_propertytype() throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.getpropertytypestatuschange().click();
		unit.getpropertytypestatuschangeclick().click();
	}
	
	
	@Test
	public void Excel_propertytype() throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.getpropertytypeexcel().click();
		
	}
	
	@Test(dataProvider = "getsearchdata")
	public void Search_propertytypes(String searchpropertyttypes1) throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.getpropertytypesearch().sendKeys(searchpropertyttypes1);
		unit.getpropertytypesearchclick().click();
	}

//	// close the driver
//	@AfterMethod
//	public void teaddown() {
//		// driver.close();
//	}

	// DataProvider for Add propertytype
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "OldProperty" } };
	}

	// DataProvider for Edit Inquiry
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Bopalproperty" } };
	}
	
	@DataProvider
	public Object[][] getsearchdata() {
		return new Object[][] { { "Bopalproperty" } };
	}
	

}
