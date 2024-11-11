package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	public void Add_unit(String unitname1) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getclickaddunit().click();
		unit.gettextnameunit().sendKeys(unitname1);
		Thread.sleep(3000);
		unit.getunitsave().click();
	}

	//Editing an existing unit using Data Provider
	@Test(dataProvider = "getEditData")
	public void Edit_unit(String newunitname1) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.geteditunit().click();
		unit.geteditunittext().clear();
		unit.geteditunittext().sendKeys(newunitname1);
		Thread.sleep(2000);
		unit.geteditsave().click();
	}

	//status change of the existing record
	@Test
	public void status_unit() throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getchangestatus().click();
		unit.getstatuschange1().click();
		Thread.sleep(2000);
	}

	//delete record of the existing records
	@Test
	public void delete() throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getdelete().click();
		unit.confirmationdelete().click();
		Thread.sleep(2000);
	}

	//Excel record downloading
	@Test
	public void excelrecord() throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.excelclick().click();
		Thread.sleep(2000);
	}

	//Enter the data on searched box:
	@Test(dataProvider = "getentersearcheddata")
	public void entersearched(String getsearchediteam) throws InterruptedException {
		Unitpage unit = new Unitpage(driver);
		unit.getconfiguration().click();
		unit.getclickunit().click();
		unit.getentertext().sendKeys(getsearchediteam);
		Thread.sleep(2000);
		unit.getrowsearched().click();
		Thread.sleep(3000);
	}

	//Close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	//DataProvider for Add unit
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "UNITSNAME" } };
	}

	//DataProvider for edit unit
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] { { "SapModule" } };
	}

	@DataProvider
	public Object[][] getentersearcheddata() {
		return new Object[][] { { "Sq.feet" } };
	}
}