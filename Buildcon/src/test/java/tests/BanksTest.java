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
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getBanksadd().click();
		// banks name data validation--
		unit.getBanksadddata().sendKeys(Banks1);
		String valid_string = valid_alphanum(Banks1,"banks",30);
		String valid_Banks = valid_string;
		System.out.println(valid_Banks);
		Thread.sleep(3000);
		unit.getbankssave().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_Banks, "Banks is a Valid Alpha-Numeric");
		
	}
	// Edit project types

	@Test(dataProvider = "getEditdata")
	public void Edit_banks(String Banks1) throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbankseditclick().click();
		unit.getbankseditadddata().clear();
		// banks name data validation--------------
		unit.getbankseditadddata().sendKeys(Banks1);
		String valid_string = valid_alphanum(Banks1,"banks",30);
		String valid_Banks = valid_string;
		System.out.println(valid_Banks);
		Thread.sleep(3000);
		unit.getbankseditsave().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_Banks, "Banks is a Valid Alpha-Numeric");
		
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

	@Test
	public void Add_validation_banks() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getBanksadd().click();

		unit.getbankssave().click();

		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();

		System.out.println(messagelement.getText());

		// Define the expected message

		String expectedMessage = "Bank name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Bank name is required", expectedMessage, actualMessage);

		softAssert.assertAll();
	}

	@Test
	public void Edit_validation_banks() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbankseditclick().click();
		//unit.getbankseditadddata().click();
		for (int i = 1; i <= 13; i++) {
			unit.getbankseditadddata().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		unit.getbankseditsave().click();
		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();

		System.out.println(messagelement.getText());

		// Define the expected message

		String expectedMessage = "Bank name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Bank name is required", expectedMessage, actualMessage);

		softAssert.assertAll();

	}

	 //close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	// DataProvider for Add banks
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "banks88" } };
	}

	// DataProvider for Edit Inquiry
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "BOI123" } };
	}

	// DataProvider for Apply searched for Project
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "HDFC " } };
	}

}
