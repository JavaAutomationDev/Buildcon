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

		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Property Types
	@Test(dataProvider = "getAdddata")
	public void Add_propertytypes(String propertytype1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Propertytypepage propertytype = new Propertytypepage(driver);
		propertytype.getconfiguration().click();
		propertytype.getpropertytype().click();
		propertytype.getaddpropertytype().click();
		
		propertytype.getaddpropertytypedata().sendKeys(propertytype1);
		//Property Type Data Validation
		String valid_string = valid_alphanum(propertytype1,"propertytype",30);
		String valid_propertytype = valid_string;
		System.out.println(valid_propertytype);
		Thread.sleep(3000);
		propertytype.getsavebuttonaddpropertytype().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_propertytype, "propertytype is a Valid Alpha-Numeric");
	    softAssert.assertAll();
	}
	
	//Edit Project Types
	@Test(dataProvider = "getEditdata")
	public void Edit_Property_Types(String Editpropertyttypes1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Propertytypepage propertytype = new Propertytypepage(driver);
		propertytype.getconfiguration().click();
		propertytype.getpropertytype().click();
		propertytype.geteditpropertytype().click();
		
		propertytype.geteditpropertytypeenterdata().clear();
		propertytype.geteditpropertytypeenterdata().sendKeys(Editpropertyttypes1);
		//Property Type Data Validation
		String valid_string = valid_alphanum(Editpropertyttypes1,"projectstatus",30);
		String valid_propertytype = valid_string;
		System.out.println(valid_propertytype);
		Thread.sleep(3000);
		propertytype.getsavebuttoneditpropertytype().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_propertytype, "propertytype is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Delete Property type
	@Test
	public void Delete_Property_Type() throws InterruptedException {
		Propertytypepage property = new Propertytypepage(driver);
		property.getconfiguration().click();
		property.getpropertytype().click();
		property.getdeletepropertytypeclick().click();
		Thread.sleep(2000);
		property.getdeletepropertytypeconfirmation().click();
		Thread.sleep(2000);

	}

	//Status Change Property Type
	@Test
	public void Statuschang_propertytype() throws InterruptedException {
		Propertytypepage propertytype = new Propertytypepage(driver);
		propertytype.getconfiguration().click();
		propertytype.getpropertytype().click();
		propertytype.getpropertytypestatuschange().click();
		Thread.sleep(3000);
		propertytype.getpropertytypestatuschangeclick().click();
		Thread.sleep(3000);
	}

	//Excel Property Type
	@Test
	public void Excel_propertytype() throws InterruptedException {
		Propertytypepage propertytype = new Propertytypepage(driver);
		propertytype.getconfiguration().click();
		propertytype.getpropertytype().click();
		Thread.sleep(3000);
		propertytype.getpropertytypeexcel().click();
		Thread.sleep(3000);
	}

	//Search Property Types
	@Test(dataProvider = "getsearchdata")
	public void Search_Property_Types(String searchpropertyttypes1) throws InterruptedException {
		Propertytypepage property = new Propertytypepage(driver);
		property.getconfiguration().click();
		property.getpropertytype().click();
		property.getpropertytypesearch().sendKeys(searchpropertyttypes1);
		property.getpropertytypesearchclick().click();
		Thread.sleep(2000);
	}

	//Add Validation Property Types
	@Test
	public void Add_validation_Property_Types() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Propertytypepage propertytype = new Propertytypepage(driver);
		propertytype.getconfiguration().click();
		propertytype.getpropertytype().click();
		propertytype.getaddpropertytype().click();
		propertytype.getsavebuttonaddpropertytype().click();

		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		//Define the expected message
		String expectedMessage = "Property type is required";
		softAssert.assertEquals("Property type is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Edit Validation Property Types
	@Test
	public void Edit_Validation_Property_Types() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Propertytypepage propertytype = new Propertytypepage(driver);
		propertytype.getconfiguration().click();
		propertytype.getpropertytype().click();
		propertytype.geteditpropertytype().click();
		for (int i = 1; i <= 13; i++) {
			propertytype.geteditpropertytypeenterdata().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		propertytype.getsavebuttoneditpropertytype().click();
		Thread.sleep(2000);
		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add"
				+ "/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		//Define the expected message
		String expectedMessage = "Property type is required";
		softAssert.assertEquals("Property type is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Close the driver
	@AfterMethod
	public void teardown() {
		 driver.close();
	}

	//DataProvider for Add Data
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "ooops" } };
	}

	//DataProvider for Edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "nnn@@123" } };
	}
	//DataProvider for Search
	@DataProvider
	public Object[][] getsearchdata() {
		return new Object[][] { { "nnn@@123" } };
	}
}