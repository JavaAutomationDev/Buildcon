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
import pageObjects.Statepage;
import resources.base;

public class StateTest extends base {
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

	//Add State
	@Test(dataProvider = "getstateAdddata")
	public void Add_State(String statename1, String statecode1) throws InterruptedException, IOException {
		Statepage state = new Statepage(driver);
		SoftAssert softAssert = new SoftAssert();
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatename().click();
		state.eneterstatename().sendKeys(statename1);
		state.getstatecode().sendKeys(statecode1);
		// unit  Name Text Data Validation ---------------------------------
		String valid_string = validateText(statename1,"statename",5,20);
		String valid_statename = valid_string;
		System.out.println(valid_statename);
		String valid_string1 = valid_number(statecode1,"statecode");
		String valid_statecode = valid_string1;
		System.out.println(valid_statecode);
		state.getsavestate().click();
		softAssert.assertEquals(valid_statename, "statename is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_statecode, "statecode is a Valid Number");
		softAssert.assertAll();
		
	}

	

	//Editing an existing unit using Data Provider
	@Test(dataProvider = "getstateEditData")
	public void Edit_state(String newstatename1, String newstatecode1) throws InterruptedException, IOException {
		Statepage state = new Statepage(driver);
		SoftAssert softAssert = new SoftAssert();
		state.getconfiguration().click();
		state.getclickstate().click();
		state.editrow().click();
		state.editadddata().clear();
		state.editadddata().sendKeys(newstatename1);
		state.editrowaddstatecode().clear();
		state.editrowaddstatecode().sendKeys(newstatecode1);
		String valid_string = validateText(newstatename1,"statename",5,20);
		String valid_statename = valid_string;
		System.out.println(valid_statename);
		String valid_string1 = valid_number(newstatecode1,"statecode");
		String valid_statecode = valid_string1;
		System.out.println(valid_statecode);
		Thread.sleep(2000);
		state.editrowsavebutton().click();
		softAssert.assertEquals(valid_statename, "statename is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_statecode, "statecode is a Valid Number");
		softAssert.assertAll();
		
	}

	//Status change of the existing record
	@Test
	public void Status_state() throws InterruptedException {
		Statepage unit = new Statepage(driver);
		unit.getconfiguration().click();
		unit.getclickstate().click();
		unit.getstatusclick().click();
		unit.getstatusconfirmation().click();
		Thread.sleep(2000);
	}

	//Delete record of the existing records
	@Test
	public void Delete_State() throws InterruptedException {
		Statepage unit = new Statepage(driver);
		unit.getconfiguration().click();
		unit.getclickstate().click();
		unit.getdeletestate().click();
		unit.getdeletestateconfirm().click();
		Thread.sleep(2000);
	}

	@Test(dataProvider = "getstatesearch")
	public void search_state(String statesearch1) throws InterruptedException {
		Statepage unit = new Statepage(driver);
		unit.getconfiguration().click();
		unit.getclickstate().click();
		unit.getstatesearching().sendKeys(statesearch1);
		unit.getstatesearchingclick().click();
		Thread.sleep(2000);
	}
	
	//Export to Excel 
	@Test
	public void State_Excel() throws InterruptedException {
		Statepage unit = new Statepage(driver);
		unit.getconfiguration().click();
		unit.getclickstate().click();
		unit.getstateexcel().click();
	}

	@Test
	public void Add_state_Test_Mandatory_Filed_Validation() throws InterruptedException {
		Statepage state = new Statepage(driver);
		SoftAssert softAssert = new SoftAssert();
		state.getconfiguration().click();
		state.getclickstate().click();
		Thread.sleep(2000);
		state.getstatename().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/div[1]/mat-form-field[1]/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "State name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("State name is required", expectedMessage, actualMessage);

	
		
		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		// Define the expected message

		String expectedMessage1 = "State code is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("State code is required", expectedMessage1, actualMessage1);

		softAssert.assertAll();

	}

	@Test
	public void Edit_state_Test_Mandatory_Filed_Validation() throws InterruptedException {
		Statepage state = new Statepage(driver);
		SoftAssert softAssert = new SoftAssert();
		state.getconfiguration().click();
		state.getclickstate().click();
		Thread.sleep(2000);
		state.editrow().click();
		for (int i = 1; i <= 7; i++) {
			state.editadddata().sendKeys(Keys.BACK_SPACE);
			state.editrowaddstatecode().sendKeys(Keys.BACK_SPACE);
		}

		state.getsavestate().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/div[1]/mat-form-field[1]/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "State name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("State name is required", expectedMessage, actualMessage);

		
		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		// Define the expected message

		String expectedMessage1 = "State code is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("State code is required", expectedMessage1, actualMessage1);

		softAssert.assertAll();

	}

	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	//DataProvider for Add state
	@DataProvider
	public Object[][] getstateAdddata() {
		return new Object[][] { { "lucknow", "555" } };
	}

	//DataProvider for Edit State
	@DataProvider
	public Object[][] getstateEditData() {
		return new Object[][] { { "Shark", "101" } };
	}
	
	
	//DataProvider for Search State
	@DataProvider
	public Object[][] getstatesearch() {
		return new Object[][] { { "Motihari" } };
	}
}