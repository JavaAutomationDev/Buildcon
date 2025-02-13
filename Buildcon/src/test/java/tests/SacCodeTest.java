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
	@Test(dataProvider = "getAdddata",priority =1)
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
		softAssert.assertEquals(valid_saccode, "saccode is a Valid Number");
		softAssert.assertEquals(valid_sacdescription, "sacdescription is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_gst, "gst is a Valid Number");
		softAssert.assertAll();
	}
	
	//Edit Sac Code
	@Test(dataProvider = "getEditdata",priority =2)
	public void Edit_Saccode(String Saccode1,String description1,String editgst1,String searchedentertext) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getsearchsaccode().sendKeys(searchedentertext);
		saccode.getsearchsaccodeconfirmclick().click();
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
		Thread.sleep(2000);
		
		softAssert.assertEquals(valid_saccode, "saccode is a Valid Number");
		softAssert.assertEquals(valid_sacdescription, "sacdescription is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_gst, "gst is a Valid Number");
		softAssert.assertAll();
	}

	//Status Change Saccode
	@Test(dataProvider = "getstatuschanged",priority =3)
	public void Status_Change_Saccode(String searchedentertext) throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getsearchsaccode().sendKeys(searchedentertext);
		saccode.getsearchsaccodeconfirmclick().click();
		saccode.getchangestatus().click();
		saccode.getchangestatusconfirm().click();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] getstatuschanged() {
		return new Object[][] { { "SaccodeTest1"  } };
	}

	//Delete Saccode
	@Test(dataProvider = "getdelete",priority =6)
	public void Delete_Saccode(String searchedentertext) throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getsearchsaccode().sendKeys(searchedentertext);
		saccode.getsearchsaccodeconfirmclick().click();
		saccode.getdeletesaccode().click();
		saccode.getdeletesaccodeconfirm().click();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] getdelete() {
		return new Object[][] { { "SaccodeTest1"  },{ "SaccodeTest2"  },{ "SaccodeTest3"  },{ "SaccodeTest4"  }    };
	}

	//Search Saccode
	@Test(dataProvider = "getsearch",priority =5)
	public void Searching_Project_Types(String searchedentertext) throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getsearchsaccode().sendKeys(searchedentertext);
		saccode.getsearchsaccodeconfirmclick().click();
		Thread.sleep(2000);
	}

	//Export Excel Saccode
	@Test(priority =4)
	public void Export_Excel_Saccode() throws InterruptedException {
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getexcelclicksaccode().click();
		Thread.sleep(2000);
	}

	//Add Validation Saccode
	@Test(priority =7)
	public void Add_Validation_Saccode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getaddsaccode().click();
		saccode.getsavebuttonsaccode().click();
		Thread.sleep(2000);
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
	@Test(priority =8)
	public void Edit_Validation_Saccode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Saccodepage saccode = new Saccodepage(driver);
		saccode.getconfiguration().click();
		saccode.getsaccodeclick().click();
		saccode.getEditclicksaccode().click();
		int nm = saccode.getsaccodeenter().getAttribute("value").length();
		for (int i = 0; i <= nm; i++) {
			saccode.getsaccodeenter().sendKeys(Keys.BACK_SPACE);
		}
		int nm1 = saccode.getdescription().getAttribute("value").length();
		for (int i = 0; i <= nm1; i++) {
			saccode.getdescription().sendKeys(Keys.BACK_SPACE);
		}
		int nm2 = saccode.getgst().getAttribute("value").length();
		for (int i = 0; i <= nm2; i++) {
			saccode.getgst().sendKeys(Keys.BACK_SPACE);
		}
		saccode.getEditsavebutton().click();
		Thread.sleep(2000);

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
	
	//Close the driver
		@AfterMethod
		public void teardown() {
			 driver.close();
		}
	//DataProvider for Add
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "111111", "SaccodeTest1", "10" },{ "222222", "SaccodeTest2", "11" },{ "333333", "SaccodeTest3", "12" },{ "444444", "SaccodeTest4", "13" } };
	}

	//DataProvider for Edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "555555", "SaccodeTest2 update", "15","222222" } };
	}

	//DataProvider for Search 
	@DataProvider
	public Object[][] getsearch() {
		return new Object[][] { { "SaccodeTest1" } };
	}
}
