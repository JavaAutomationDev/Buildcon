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

	// Add unit
	@Test(dataProvider = "getAdddata",priority =1)
	public void Add_Unit(String unitname1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getclickaddunit().click();
		unit.gettextnameunit().clear();
		unit.gettextnameunit().sendKeys(unitname1);
		Thread.sleep(3000);

		// Unit Name Text Data Validation
		String valid_string = valid_alphanum(unitname1, "Unitname", 20);
		String valid_unitname = valid_string;
		System.out.println(valid_unitname);
		unit.getaddunitsave().click();
         Thread.sleep(2000);
		softAssert.assertEquals(valid_unitname, "Unitname is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	// Editing an existing unit using Data Provider
	@Test(dataProvider = "getEditData",priority =2)
	public void Edit_Unit(String newunitname1,String unitnamesearchededit) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getentertext().sendKeys(unitnamesearchededit);
		Thread.sleep(2000);
		unit.getrowsearched().click();
		unit.geteditunit().click();
		unit.geteditunittext().clear();

		// Unit Name data validation -----
		unit.geteditunittext().sendKeys(newunitname1);
		String valid_string = valid_alphanum(newunitname1, "Unitname", 20);
		String valid_unitname = valid_string;
		System.out.println(valid_unitname);
		Thread.sleep(2000);
		unit.geteditsave().click();
      Thread.sleep(2000);
		softAssert.assertEquals(valid_unitname, "Unitname is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	// Status change of the existing record
	@Test(dataProvider = "getstatuschange",priority =3)
	public void Status_Unit(String searchesstatus ) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getentertext().sendKeys(searchesstatus);
		Thread.sleep(2000);
		unit.getrowsearched().click();
		unit.getchangestatus().click();
		Thread.sleep(2000);
		unit.getstatuschange1().click();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] getstatuschange() {
		return new Object[][] { { "Test unit 2" } // Replace with actual unit identifiers you want to delete

		};
	}

	@Test(dataProvider = "getdeleteData",priority =5)
	// delete the record with search:
	public void Deletesearch_Unit(String deletesearched) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getentertext().sendKeys(deletesearched);
		Thread.sleep(2000);
		unit.getrowsearched().click();
		unit.getdeleteclick().click();
		Thread.sleep(2000);
		unit.getdeleteclickconfirm().click();
		Thread.sleep(2000);
	}

	// data provider of delete:
	@DataProvider
	public Object[][] getdeleteData() {
		return new Object[][] { { "Test unit 1" },{ "Test unit 2" },{ "Test unit 3" },{ "Test unit 4" } // Replace with actual unit identifiers you want to delete

		};
	}

	@Test(priority =6)
	public void Excel_Record_Download() throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.excelclick().click();
		Thread.sleep(2000);
	}

	// Enter the data on searched box:
	@Test(dataProvider = "getentersearcheddata",priority =4)
	public void Enter_Search(String getsearchediteam) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getentertext().sendKeys(getsearchediteam);
		Thread.sleep(2000);
		unit.getrowsearched().click();
		Thread.sleep(3000);
	}

	// Add Unit Test Mandatory Filed Validation
	@Test(priority =7)
	public void Add_Unit_Test_Mandatory_Filed_Validation() throws InterruptedException {
	
		SoftAssert softAssert = new SoftAssert();
		Unitpage units = new Unitpage(driver);
		units.getconfiguration().click();
		units.getclickunit().click();
		Thread.sleep(2000);
		units.getclickaddunit().click();
		Thread.sleep(2000);
		units.getaddunitsave().click();
   Thread.sleep(2000);
		WebElement messageElement = driver
				.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-"
						+ "add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Unit name is required";
		Assert.assertEquals("Unit name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	// Edit Unit Test Mandatory Filed Validation
	@Test(priority =8)
	public void Edit_Unit_Test_Mandatory_Filed_Validation() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Unitpage units = new Unitpage(driver);
		units.getconfiguration().click();
		units.getclickunit().click();
		units.geteditunit().click();
		Thread.sleep(2000);
		int nm  = units.geteditunittext().getAttribute("value").length();
		for (int i = 0; i < nm ; i++) {
			units.geteditunittext().sendKeys(Keys.BACK_SPACE);
		}
		
		Thread.sleep(2000);
		units.geteditsave().click();
		Thread.sleep(2000);
		WebElement messageElement = driver
				.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-"
						+ "add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());
		String expectedMessage = "Unit name is required";

		Assert.assertEquals("Unit name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	// Close the driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	//DataProvider for Add Unit
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Test unit 1" },{ "Test unit 2" },{ "Test unit 3" },{ "Test unit 4" } };
	}

	// DataProvider for Edit Unit
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] { { "Test unit 3 update", "Test unit 3" } };
	}

	// DataProvider for Search Unit
	@DataProvider
	public Object[][] getentersearcheddata() {
		return new Object[][] { { "Test unit 2" } };
	}
}