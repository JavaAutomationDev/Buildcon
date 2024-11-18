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

	//Add Property types
	@Test(dataProvider = "getAdddata")
	public void Add_propertytypes(String propertytype1) throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.getaddpropertytype().click();
		unit.getaddpropertytypedata().sendKeys(propertytype1);
		String valid_string = valid_alphanum(propertytype1,"propertytype",30);
		String valid_propertytype = valid_string;
		System.out.println(valid_propertytype);
		Thread.sleep(3000);
		unit.getsavebuttonaddpropertytype().click();
		softAssert.assertEquals(valid_propertytype, "propertytype is a Valid Alpha-Numeric");
		
	}
	
	//Edit project types
	@Test(dataProvider = "getEditdata")
	public void Edit_propertytypes(String Editpropertyttypes1) throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.geteditpropertytype().click();
		unit.geteditpropertytypeenterdata().clear();
		unit.geteditpropertytypeenterdata().sendKeys(Editpropertyttypes1);
		String valid_string = valid_alphanum(Editpropertyttypes1,"projectstatus",30);
		String valid_propertytype = valid_string;
		System.out.println(valid_propertytype);
		Thread.sleep(3000);
		unit.getsavebuttoneditpropertytype().click();
		softAssert.assertEquals(valid_propertytype, "propertytype is a Valid Alpha-Numeric");
		
	}

	//Delete Property type
	@Test
	public void Delete_Property_Type() throws InterruptedException {
		Propertytypepage property = new Propertytypepage(driver);
		property.getconfiguration().click();
		property.getpropertytype().click();
		property.getdeletepropertytypeclick().click();
		property.getdeletepropertytypeconfirmation().click();
	}

	@Test
	public void Status_Change_Property_Type() throws InterruptedException {
		Propertytypepage property = new Propertytypepage(driver);
		property.getconfiguration().click();
		property.getpropertytype().click();
		property.getpropertytypestatuschange().click();
		property.getpropertytypestatuschangeclick().click();
	}

	@Test
	public void Excel_propertytype() throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.getpropertytypeexcel().click();

	}

	@Test(dataProvider = "getsearchdata")
	public void Search_Property_Types(String searchpropertyttypes1) throws InterruptedException {
		Propertytypepage property = new Propertytypepage(driver);
		property.getconfiguration().click();
		property.getpropertytype().click();
		property.getpropertytypesearch().sendKeys(searchpropertyttypes1);
		property.getpropertytypesearchclick().click();
	}

	@Test
	public void Add_validation_propertytypes() throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.getaddpropertytype().click();
		unit.getsavebuttonaddpropertytype().click();

		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		// Define the expected message

		String expectedMessage = "Property type is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Property type is required", expectedMessage, actualMessage);

		softAssert.assertAll();

	}

	@Test
	public void Edit_validation_propertytypes() throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.geteditpropertytype().click();
		for (int i = 1; i <= 13; i++) {
			unit.geteditpropertytypeenterdata().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		unit.getsavebuttoneditpropertytype().click();
		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		// Define the expected message

		String expectedMessage = "Property type is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Property type is required", expectedMessage, actualMessage);

		softAssert.assertAll();
	}

	// close the driver
	@AfterMethod
	public void teaddown() {
		 driver.close();
	}

	//DataProvider for Add Property Type
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "property6068" } };
	}

	//DataProvider for Edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "nishantprop@@123" } };
	}

	@DataProvider
	public Object[][] getsearchdata() {
		return new Object[][] { { "Bopalproperty" } };
	}

}