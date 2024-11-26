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

		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Banks
	@Test(dataProvider = "getAdddata")
	public void Add_Banks(String Banks1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBanksadd().click();
		
		//Banks name data validation
		Bank.getBanksadddata().sendKeys(Banks1);
		String valid_string = valid_alphanum(Banks1,"banks",30);
		String valid_Banks = valid_string;
		System.out.println(valid_Banks);
		
		Thread.sleep(3000);
		Bank.getbankssave().click();
		softAssert.assertEquals(valid_Banks, "Banks is a Valid Alpha-Numeric");
	    softAssert.assertAll(); 	
	}
	
	//Edit Bank
	@Test(dataProvider = "getEditdata")
	public void Edit_Banks(String Banks1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getbankseditclick().click();
		Bank.getbankseditadddata().clear();
		
		//Banks name data validation
		Bank.getbankseditadddata().sendKeys(Banks1);
		String valid_string = valid_alphanum(Banks1,"banks",30);
		String valid_Banks = valid_string;
		System.out.println(valid_Banks);
		
		Thread.sleep(3000);
		Bank.getbankseditsave().click();
		
		Thread.sleep(3000);
		softAssert.assertEquals(valid_Banks, "Banks is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Delete Bank
	@Test
	public void Delete_banks() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbanksdeleteclick().click();
		Thread.sleep(3000);
		unit.getBanksdeleteconfirmation().click();
		Thread.sleep(3000);
	}

	//Status Bank
	@Test
	public void status_banks() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbanksstatus().click();
		Thread.sleep(2000);
		unit.getbanksstatusconfirmation().click();
		Thread.sleep(2000);
	}

	//Searched Bank
	@Test(dataProvider = "getsearched")
	public void Searched_Banks(String bankssearched1) throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBankssearched().sendKeys(bankssearched1);
		Bank.getbankssearchedclick().click();
	}

	//Excel Export Bank
	@Test
	public void Excel_Export_Banks() throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getbanksExcelclick().click();
		Bank.getbankssearchedclick().click();
	}

	//Add Validation Banks
	@Test
	public void Add_Validation_Banks() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBanksadd().click();
		Bank.getbankssave().click();

		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/"
				+ "mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();

		System.out.println(messagelement.getText());

		//Define the expected message
		String expectedMessage = "Bank name is required";
		softAssert.assertEquals("Bank name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Edit Validation Banks
	@Test
	public void Edit_Validation_Banks() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getbankseditclick().click();
		//unit.getbankseditadddata().click();
		for (int i = 1; i <= 13; i++) {
			Bank.getbankseditadddata().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		Bank.getbankseditsave().click();
		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/"
				+ "mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		//Define the expected message
		String expectedMessage = "Bank name is required";
		softAssert.assertEquals("Bank name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	 //Close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	//DataProvider for Add Bank
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "centralbank" } };
	}

	//DataProvider for Edit Bank
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "BOI123" } };
	}

	//DataProvider for Searched Bank
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "HDFC" } };
	}
}
