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
	@Test(dataProvider = "getAdddata",priority =1)
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
		Thread.sleep(2000);
		softAssert.assertEquals(valid_Banks, "banks is a Valid Alpha-Numeric is a valid Maxlenght");
	    softAssert.assertAll(); 	
	}
	
	//Edit Bank
	@Test(dataProvider = "getEditdata",priority =2)
	public void Edit_Banks(String Banks1,String bankssearched1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBankssearched().sendKeys(bankssearched1);
		Bank.getbankssearchedclick().click();
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
		softAssert.assertEquals(valid_Banks, "banks is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Delete Bank
	@Test(dataProvider = "getdelete",priority =6)
	public void Delete_banks(String bankssearched1) throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBankssearched().sendKeys(bankssearched1);
		Bank.getbankssearchedclick().click();
		Bank.getbanksdeleteclick().click();
		Thread.sleep(3000);
		Bank.getBanksdeleteconfirmation().click();
		Thread.sleep(3000);
	}
	@DataProvider
	public Object[][] getdelete() {
		return new Object[][] { { "Test Bank 1"},{"Test Bank 2"},{"Test Bank 3"},{"Test Bank 4" }  };
	}

	//Status Bank
	@Test(dataProvider = "getSTATUSSEARC",priority =4)
	public void status_banks(String bankssearched1) throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBankssearched().sendKeys(bankssearched1);
		Bank.getbankssearchedclick().click();
		Bank.getbanksstatus().click();
		Thread.sleep(2000);
		Bank.getbanksstatusconfirmation().click();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] getSTATUSSEARC() {
		return new Object[][] { { "Test Bank 3" } };
	}

	//Searched Bank
	@Test(dataProvider = "getsearched",priority =5)
	public void Searched_Banks(String bankssearched1) throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBankssearched().sendKeys(bankssearched1);
		Bank.getbankssearchedclick().click();
		Thread.sleep(2000);
	}

	//Excel Export Bank
	@Test(priority =3)
	public void Excel_Export_Banks() throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getbanksExcelclick().click();
		Bank.getbankssearchedclick().click();
		Thread.sleep(2000);
	}

	//Add Validation Banks
	@Test(priority =7)
	public void Add_Validation_Banks() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBanksadd().click();
		Bank.getbankssave().click();
		Thread.sleep(2000);

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
	@Test(priority =8)
	public void Edit_Validation_Banks() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getbankseditclick().click();
		int banks = Bank.getbankseditadddata().getAttribute("value").length();
		for (int i = 1; i <= banks; i++) {
			Bank.getbankseditadddata().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		Bank.getbankseditsave().click();
		Thread.sleep(2000);
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
		return new Object[][] { { "Test Bank 1"},{"Test Bank 2"},{"Test Bank 3"},{"Test Bank 4" } };
	}

	//DataProvider for Edit Bank
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Test Bank 1 update","Test Bank 1" } };
	}

	//DataProvider for Searched Bank
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "Test Bank 4"} };
	}
}
