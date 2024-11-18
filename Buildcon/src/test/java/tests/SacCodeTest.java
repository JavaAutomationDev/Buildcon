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

	//Add Project types
	@Test(dataProvider = "getAdddata")
	public void Add_Saccode(String Saccode1, String DESCRIPTION1, String gst1) throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getaddsaccode().click();
		unit.getsaccodeenter().sendKeys(Saccode1);
		unit.getdescription().sendKeys(DESCRIPTION1);
		unit.getgst().sendKeys(gst1);
		String valid_string = valid_number(Saccode1,"saccode");
		String valid_saccode = valid_string;
		System.out.println(valid_saccode);
		String valid_string1 = valid_alphanum(DESCRIPTION1,"sacdescription",20);
		String valid_sacdescription = valid_string1;
		System.out.println(valid_sacdescription);
		String valid_string3 = valid_number(gst1,"gst");
		String valid_gst = valid_string3;
		System.out.println(valid_gst);
		unit.getsavebuttonsaccode().click();
		softAssert.assertEquals(valid_saccode, "saccode is a valid Number");
		softAssert.assertEquals(valid_sacdescription, "DESCRIPTION is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_gst, "gst is a valid Number");
	}
	
	//Edit Project types
	@Test(dataProvider = "getEditdata")
	public void Edit_saccode(String Saccode1,String description1,String editgst1) throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getEditclicksaccode().click();
		unit.getEditsacs().clear();
		unit.getEditsacs().sendKeys(Saccode1);
		unit.getEditsacdescription().clear();
		unit.getEditsacdescription().sendKeys(description1);
		unit.getEditgst().clear();
		unit.getEditgst().sendKeys(editgst1);
		String valid_string = valid_number(Saccode1,"saccode");
		String valid_saccode = valid_string;
		System.out.println(valid_saccode);
		String valid_string1 = valid_alphanum(description1,"sacdescription",20);
		String valid_sacdescription = valid_string1;
		System.out.println(valid_sacdescription);
		String valid_string3 = valid_number(editgst1,"gst");
		String valid_gst = valid_string3;
		System.out.println(valid_gst);
		unit.getEditsavebutton().click();
		softAssert.assertEquals(valid_saccode, "saccode is a valid Number");
		softAssert.assertEquals(valid_sacdescription, "DESCRIPTION is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_gst, "gst is a valid Number");
	}

	@Test
	public void statuschange_saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getchangestatus().click();
		saccode.getchangestatusconfirm().click();
	}

	@Test
	public void Delete_saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getdeletesaccode().click();
		saccode.getdeletesaccodeconfirm().click();
	}

	@Test(dataProvider = "getsearch")
	public void searching_projecttypes(String searchedentertext) throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getsearchsaccode().sendKeys(searchedentertext);
		saccode.getsearchsaccodeconfirmclick().click();
	}

	@Test
	public void Exportasaexcel_saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getexcelclicksaccode().click();
	}

	@Test
	public void Add_validation_Saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		SoftAssert softAssert = new SoftAssert();
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getaddsaccode().click();
		saccode.getsavebuttonsaccode().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div[1]/mat-form-field[1]/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "SAC code is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("SAC code is required", expectedMessage, actualMessage);

		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		//Define the expected message
		String expectedMessage1 = "Description is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("Description is required", expectedMessage1, actualMessage1);

		WebElement messageElement2 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div[1]/mat-form-field[3]/div[2]/div/mat-error/span"));

		String actualMessage2 = messageElement2.getText();
		System.out.println(messageElement2.getText());

		//Define the expected message
		String expectedMessage2 = "GST is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("GST is required", expectedMessage2, actualMessage2);
		softAssert.assertAll();
	}

	@Test
	public void Edit_validation_saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		SoftAssert softAssert = new SoftAssert();
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
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div[1]/mat-form-field[1]/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "SAC code is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("SAC code is required", expectedMessage, actualMessage);

		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		//Define the expected message
		String expectedMessage1 = "Description is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("Description is required", expectedMessage1, actualMessage1);

		WebElement messageElement2 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div[1]/mat-form-field[3]/div[2]/div/mat-error/span"));

		String actualMessage2 = messageElement2.getText();
		System.out.println(messageElement2.getText());

		//Define the expected message
		String expectedMessage2 = "GST is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("GST is required", expectedMessage2, actualMessage2);
		softAssert.assertAll();
	}

	//DataProvider for Add
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "747266", "Nishant", "42" } };
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
