package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Bankspage;
import pageObjects.LoginPage;
import resources.base;

public class BanksTest extends base {

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
	public void Add_banks(String Banks1) throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getBanksadd().click();
		unit.getBanksadddata().sendKeys(Banks1);
		Thread.sleep(3000);
		unit.getbankssave().click();
	}
	// Edit project types

	@Test(dataProvider = "getEditdata")
	public void Edit_banks(String Banks1) throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbankseditclick().click();
		unit.getbankseditadddata().clear();
		unit.getbankseditadddata().sendKeys(Banks1);
		Thread.sleep(3000);
		unit.getbankseditsave().click();
	}

	@Test
	public void Delete_banks() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbanksdeleteclick().click();
		unit.getBanksdeleteconfirmation().click();
	}

	@Test
	public void status_banks() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbanksstatus().click();
		unit.getbanksstatusconfirmation().click();
	}

	@Test(dataProvider = "getsearched")
	public void searched_banks(String bankssearched1) throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getBankssearched().sendKeys(bankssearched1);
		unit.getbankssearchedclick().click();
	}
	
	@Test
	public void Excelexport_banks() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbanksExcelclick().click();
		unit.getbankssearchedclick().click();
	}
	

	// close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	// DataProvider for Add banks
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { {"RBI"} };
	}

	// DataProvider for Edit Inquiry
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "BOI" } };
	}

	// DataProvider for Apply searched for Project
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "HDFC " } };
	}

	
}
