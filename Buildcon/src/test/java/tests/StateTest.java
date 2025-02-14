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
	@Test(dataProvider = "getstateAdddata",priority =1)
	public void Add_State(String statename1, String statecode1) throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatename().click();
		
		state.eneterstatename().sendKeys(statename1);
		//State Name Text Data Validation
		String valid_string = validateText(statename1,"statename",5,20);
		String valid_statename = valid_string;
		System.out.println(valid_statename);
		
		state.getstatecode().sendKeys(statecode1);
		//State Code Text Data Validation
		String valid_string1 = valid_number(statecode1,"statecode");
		String valid_statecode = valid_string1;
		System.out.println(valid_statecode);
		
		state.getsavestate().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_statename, "statename is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_statecode, "statecode is a Valid Number");
		softAssert.assertAll();
	}

	//Editing an existing state using Data Provider
	@Test(dataProvider = "getstateEditData",priority =2)
	public void Edit_state(String newstatename1,String editsearchedstate) throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatesearching().sendKeys(editsearchedstate);
		state.getstatesearchingclick().click();
		state.editrow().click();
		
		state.editadddata().clear();
		state.editadddata().sendKeys(newstatename1);
		String valid_string = validateText(newstatename1,"statename",5,25);
		String valid_statename = valid_string;
		System.out.println(valid_statename);
		
		state.editrowaddstatecode().clear();
		//state.editrowaddstatecode().sendKeys(newstatecode1);
		//String valid_string1 = valid_number(newstatecode1,"statecode");
		//String valid_statecode = valid_string1;
		//System.out.println(valid_statecode);
		
		Thread.sleep(2000);
		state.editrowsavebutton().click();
		Thread.sleep(2000);
		
		softAssert.assertEquals(valid_statename, "statename is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		//softAssert.assertEquals(valid_statecode, "statecode is a Valid Number");
		softAssert.assertAll();	
	}

	//Status change of the existing record
	@Test(dataProvider ="getstatesearchstatus",priority =3 )
	public void Status_state(String statesearch1)throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatesearching().sendKeys(statesearch1);
		state.getstatesearchingclick().click();
		Thread.sleep(2000);
		state.getstatusclick().click();
		state.getstatusconfirmation().click();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] getstatesearchstatus() {
		return new Object[][] { { "Test state four" } };
	}

	

	//Delete record of the existing records
	@Test(dataProvider = "getdeletestatesearch",priority =5)
	public void Delete_State(String statesearch1) throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatesearching().sendKeys(statesearch1);
		state.getstatesearchingclick().click();
		state.getdeletestate().click();
		state.getdeletestateconfirm().click();
		Thread.sleep(2000);
	}
	// delete  with search:
	@DataProvider
	public Object[][] getdeletestatesearch() {
		return new Object[][] { { "Test state one" },{ "Test state two"},{ "Test state three" },{ "Test state four" } };
	}

	//Search Method
	@Test(dataProvider = "getstatesearch",priority= 4)
	public void search_state(String statesearch1) throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatesearching().sendKeys(statesearch1);
		state.getstatesearchingclick().click();
		Thread.sleep(2000);
	}
	
	//Export to Excel 
	@Test(priority =6)
	public void State_Excel() throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstateexcel().click();
		Thread.sleep(2000);
	}

	//Add State Test Mandatory Filed Validation
	@Test(priority =7)
	public void Add_State_Test_Mandatory_Filed_Validation() throws InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		Thread.sleep(2000);
		state.getstatename().click();
		Thread.sleep(2000);
		state.getsavestate().click();
		Thread.sleep(2000);

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div"
				+ "/form/mat-dialog-content/div[1]/mat-form-field[1]/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "State name is required";
		softAssert.assertEquals("State name is required", expectedMessage, actualMessage);

		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		//Define the expected message
		String expectedMessage1 = "State code is required";
		softAssert.assertEquals("State code is required", expectedMessage1, actualMessage1);
		softAssert.assertAll();
	}

	//Edit State Test Mandatory Filed Validation
	@Test(priority =8)
	public void Edit_state_Test_Mandatory_Filed_Validation() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		Thread.sleep(2000);
		state.editrow().click();
		int nm  = state.editadddata().getAttribute("value").length();
		for (int i = 0; i < nm ; i++) {
			state.editadddata().sendKeys(Keys.BACK_SPACE);
		}
		int nm1  = state.editrowaddstatecode().getAttribute("value").length();
		for (int i = 0; i < nm1 ; i++) {
			state.editrowaddstatecode().sendKeys(Keys.BACK_SPACE);
		}
		
		state.getsavestate().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div"
				+ "/form/mat-dialog-content/div[1]/mat-form-field[1]/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "State name is required";

		softAssert.assertEquals("State name is required", expectedMessage, actualMessage);
		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div"
				+ "/form/mat-dialog-content/div[1]/mat-form-field[2]/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		//Define the expected message
		String expectedMessage1 = "State code is required";

		softAssert.assertEquals("State code is required", expectedMessage1, actualMessage1);
		softAssert.assertAll();
	}
	
	

	//Close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	//DataProvider for Add state
	@DataProvider
	public Object[][] getstateAdddata() {
		return new Object[][] { { "Test state one", "111" },{ "Test state two", "112" },{ "Test state three", "113" },{ "Test state four", "114" } };
	}

	//DataProvider for Edit State
	@DataProvider
	public Object[][] getstateEditData() {
		return new Object[][] { {"Test state one update","Test state one"} };
	}
	
	
	//DataProvider for Search State
	@DataProvider
	public Object[][] getstatesearch() {
		return new Object[][] { {  "Test state three" } };
	}
}