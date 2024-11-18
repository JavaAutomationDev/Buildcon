package tests;

import java.io.IOException;

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

import pageObjects.LoginPage;
import pageObjects.Unitpage;
import resources.base;

public class UnitTest extends base {
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

	//Add unit
	@Test(dataProvider = "getAdddata")
	public void Add_Unit(String unitname1) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getclickaddunit().click();
		unit.gettextnameunit().clear();
		unit.gettextnameunit().sendKeys(unitname1);
		Thread.sleep(2000);
		// unit  Name Text Data Validation ---------------------------------
		String valid_string = valid_alphanum(unitname1,"Unitname",10);
		String valid_unitname = valid_string;
		System.out.println(valid_unitname);
		unit.getaddunitsave().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_unitname, "Unitname is a Valid Alpha-Numeric");
	}

	//Editing an existing unit using Data Provider
	@Test(dataProvider = "getEditData")
	public void Edit_Unit(String newunitname1) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.geteditunit().click();
		unit.geteditunittext().clear();
		// unit name data validation -----
		unit.geteditunittext().sendKeys(newunitname1);
		String valid_string = valid_alphanum(newunitname1,"Unitname",10);
		String valid_unitname = valid_string;
		System.out.println(valid_unitname);
		Thread.sleep(2000);
		unit.geteditsave().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_unitname, "Unitname is a Valid Alpha-Numeric");
	}

	//Status change of the existing record
	@Test
	public void Status_Unit() throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getchangestatus().click();
		unit.getstatuschange1().click();
		Thread.sleep(2000);
	}

	//Delete record of the existing records
	@Test
	public void Delete_Unit() throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getdelete().click();
		unit.confirmationdelete().click();
		Thread.sleep(2000);
	}

	@Test
	public void Excel_Record_Download() throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.excelclick().click();
		Thread.sleep(2000);
	}

	//Enter the data on searched box:
	@Test(dataProvider = "getentersearcheddata")
	public void Enter_Search(String getsearchediteam) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getentertext().sendKeys(getsearchediteam);
		Thread.sleep(2000);
		unit.getrowsearched().click();
		Thread.sleep(3000);
	}

	@Test
	public void Add_unit_Test_Mandatory_Filed_Validation() throws InterruptedException {
		Unitpage units = new Unitpage(driver);
		units.getconfiguration().click();
		units.getclickunit().click();
		Thread.sleep(2000);
		units.getclickaddunit().click();
		Thread.sleep(2000);
		units.getaddunitsave().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Unit name is required";

		// Assert the actual message matches the expected message
		Assert.assertEquals("Unit name is required", expectedMessage, actualMessage);
	}

	@Test
	public void Edit_unit_Test_Mandatory_Filed_Validation() throws InterruptedException {
		Unitpage units = new Unitpage(driver);
		units.getconfiguration().click();
		units.getclickunit().click();
		units.geteditunit().click();
		Thread.sleep(2000);
		units.geteditunittext().sendKeys(Keys.BACK_SPACE);
		units.geteditunittext().sendKeys(Keys.BACK_SPACE);
		units.geteditunittext().sendKeys(Keys.BACK_SPACE);
		units.geteditunittext().sendKeys(Keys.BACK_SPACE);
		units.geteditunittext().sendKeys(Keys.BACK_SPACE);
		units.geteditunittext().sendKeys(Keys.BACK_SPACE);
		units.geteditunittext().sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		units.geteditsave().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Unit name is required";

		// Assert the actual message matches the expected message
		Assert.assertEquals("Unit name is required", expectedMessage, actualMessage);
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	//DataProvider for Add Unit
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { {"UNITSNAME"} };
	}

	//DataProvider for Edit Unit
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] { {"SapModule"} };
	}

	//DataProvider for Search Unit
	@DataProvider
	public Object[][] getentersearcheddata() {
		return new Object[][] { {"Sq.feet"} };
	}
}