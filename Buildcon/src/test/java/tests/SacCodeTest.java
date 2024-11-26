package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.Saccodepage;
import resources.base;

public class SacCodeTest extends base {

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

	//Add Sac Code
	@Test(dataProvider = "getAdddata")
	public void Add_Saccode(String Saccode1, String DESCRIPTION1, String gst1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getaddsaccode().click();
		
		saccode.getsaccodeenter().sendKeys(Saccode1);
		//Saccode Data Validation
		String valid_string = valid_number(Saccode1,"saccode");
		String valid_saccode = valid_string;
		System.out.println(valid_saccode);
		
		saccode.getdescription().sendKeys(DESCRIPTION1);
		//Description Data Validation
		String valid_string1 = valid_alphanum(DESCRIPTION1,"sacdescription",20);
		String valid_sacdescription = valid_string1;
		System.out.println(valid_sacdescription);
		
		saccode.getgst().sendKeys(gst1);
		//GST Data Validation
		String valid_string3 = valid_number(gst1,"gst");
		String valid_gst = valid_string3;
		System.out.println(valid_gst);
		saccode.getsavebuttonsaccode().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_saccode, "saccode is a valid Number");
		softAssert.assertEquals(valid_sacdescription, "DESCRIPTION is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_gst, "gst is a valid Number");
		softAssert.assertAll();
	}
	
	//Edit Sac Code
	@Test(dataProvider = "getEditdata")
	public void Edit_Saccode(String Saccode1,String description1,String editgst1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getEditclicksaccode().click();
		
		saccode.getEditsacs().clear();
		saccode.getEditsacs().sendKeys(Saccode1);
		//Sac code Data Validation
		String valid_string = valid_number(Saccode1,"saccode");
		String valid_saccode = valid_string;
		System.out.println(valid_saccode);
		
		
		saccode.getEditsacdescription().clear();
		saccode.getEditsacdescription().sendKeys(description1);
		//Description Data Validation
		String valid_string1 = valid_alphanum(description1,"sacdescription",20);
		String valid_sacdescription = valid_string1;
		System.out.println(valid_sacdescription);
		
		
		saccode.getEditgst().clear();
		saccode.getEditgst().sendKeys(editgst1);
		//GST Data Validation
		String valid_string3 = valid_number(editgst1,"gst");
		String valid_gst = valid_string3;
		System.out.println(valid_gst);
		
		saccode.getEditsavebutton().click();
		
		softAssert.assertEquals(valid_saccode, "saccode is a valid Number");
		softAssert.assertEquals(valid_sacdescription, "DESCRIPTION is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_gst, "gst is a valid Number");
		softAssert.assertAll();
	}

	//Status Change Saccode
	@Test
	public void Status_Change_Saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getchangestatus().click();
		saccode.getchangestatusconfirm().click();
	}

	//Delete Saccode
	@Test
	public void Delete_Saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getdeletesaccode().click();
		saccode.getdeletesaccodeconfirm().click();
	}

	//Search Saccode
	@Test(dataProvider = "getsearch")
	public void Searching_Project_Types(String searchedentertext) throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getsearchsaccode().sendKeys(searchedentertext);
		saccode.getsearchsaccodeconfirmclick().click();
	}

	//Export Excel Saccode
	@Test
	public void Export_Excel_Saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getexcelclicksaccode().click();
	}

	//Add Validation Saccode
	@Test
	public void Add_Validation_Saccode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getaddsaccode().click();
		saccode.getsavebuttonsaccode().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field[1]/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "SAC code is required";
		softAssert.assertEquals("SAC code is required", expectedMessage, actualMessage);

		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		//Define the expected message
		String expectedMessage1 = "Description is required";
		softAssert.assertEquals("Description is required", expectedMessage1, actualMessage1);

		WebElement messageElement2 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field[3]/div[2]/div/mat-error/span"));

		String actualMessage2 = messageElement2.getText();
		System.out.println(messageElement2.getText());

		//Define the expected message
		String expectedMessage2 = "GST is required";

		softAssert.assertEquals("GST is required", expectedMessage2, actualMessage2);
		softAssert.assertAll();
	}

	//Edit Validation Saccode
	@Test
	public void Edit_Validation_Saccode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getEditclicksaccode().click();
		for (int i = 1; i <= 10; i++) {
			saccode.getsaccodeenter().sendKeys(Keys.BACK_SPACE);
		}
		for (int i = 1; i <= 10; i++) {
			saccode.getdescription().sendKeys(Keys.BACK_SPACE);
		}
		for (int i = 1; i <= 10; i++) {
			saccode.getgst().sendKeys(Keys.BACK_SPACE);
		}
		saccode.getEditsavebutton().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field[1]/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "SAC code is required";
		softAssert.assertEquals("SAC code is required", expectedMessage, actualMessage);

		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		//Define the expected message
		String expectedMessage1 = "Description is required";
		softAssert.assertEquals("Description is required", expectedMessage1, actualMessage1);

		WebElement messageElement2 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field[3]/div[2]/div/mat-error/span"));

		String actualMessage2 = messageElement2.getText();
		System.out.println(messageElement2.getText());

		//Define the expected message
		String expectedMessage2 = "GST is required";
		softAssert.assertEquals("GST is required", expectedMessage2, actualMessage2);
		softAssert.assertAll();
	}

	//DataProvider for Add
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "999777", "Anshul", "50" } };
	}

	//DataProvider for Edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "747264","Akash123","44"  } };
	}

	//DataProvider for Search 
	@DataProvider
	public Object[][] getsearch() {
		return new Object[][] { { "EditSacCode" } };
	}
}
