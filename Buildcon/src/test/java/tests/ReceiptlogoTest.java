package tests;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ReceiptLogo;
import resources.base;

public class ReceiptlogoTest extends base {

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

	// Add terms and condition types
	@Test
	public void Add_formstatus() throws InterruptedException {
		ReceiptLogo ReceiptLogo = new ReceiptLogo(driver);
		ReceiptLogo.getconfiguration().click();
		ReceiptLogo.getReceiptlogo().click();
		Thread.sleep(2000);
		ReceiptLogo.getReceiptlogosave().click();
		Thread.sleep(2000);
		
	}
	
	@Test
	public void Edit_formstatus() throws InterruptedException {
		ReceiptLogo ReceiptLogo = new ReceiptLogo(driver);
		ReceiptLogo.getconfiguration().click();
		ReceiptLogo.getReceiptlogo().click();
		ReceiptLogo.getReceiptlogoclickremove().click();
		Thread.sleep(2000);
		ReceiptLogo.attachProfilePhoto();
		ReceiptLogo.getReceiptlogosave().click();
		Thread.sleep(2000);
		
	}
	
	@Test
	public void Add_validation_formstatus() throws InterruptedException {
		ReceiptLogo ReceiptLogo = new ReceiptLogo(driver);
		//SoftAssert softAssert = new SoftAssert();
		ReceiptLogo.getconfiguration().click();
		ReceiptLogo.getReceiptlogo().click();
		ReceiptLogo.getReceiptlogoclickremove().click();
		Thread.sleep(2000);
		//ReceiptLogo.attachProfilePhoto();
		ReceiptLogo.getReceiptlogosave().click();
		Thread.sleep(2000);
		List<WebElement> messages = driver.findElements(By.xpath("/html/body/div[1]/div"));
		for (WebElement message : messages) {
		    System.out.println(message.getText()); 
		}
	}
	
	
	@Test
	public void Edit_validation_formstatus() throws InterruptedException {
		ReceiptLogo ReceiptLogo = new ReceiptLogo(driver);
		ReceiptLogo.getconfiguration().click();
		ReceiptLogo.getReceiptlogo().click();
		ReceiptLogo.getReceiptlogoclickremove().click();
		Thread.sleep(2000);
		ReceiptLogo.getReceiptlogosave().click();
		Thread.sleep(2000);
		List<WebElement> messages = driver.findElements(By.xpath("/html/body/div[1]/div"));
		for (WebElement message : messages) {
		    System.out.println(message.getText()); 
		}
	}
	// close the driver
		@AfterMethod
		public void teaddown() {
			driver.close();
		}
	
}
