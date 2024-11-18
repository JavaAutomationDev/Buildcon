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
import pageObjects.Termsandconditionpage;
import resources.base;

public class TermsandconditionTest extends base {

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

	//Add terms and condition types
	@Test(dataProvider = "getAdddata")
	public void Add_Termsandcondition(String TermsandconditionTest1) throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getaddnewTermsandcondition().click();
		unit.getAddNewTermsandConditionsdata().sendKeys(TermsandconditionTest1);
		// ----------terms and communication Text Data Validation ------------
		String valid_string = valid_alphanum(TermsandconditionTest1, "Termsandcommunication", 25);
		String valid_Termsandcondition = valid_string;
		System.out.println(valid_Termsandcondition);
		Thread.sleep(3000);
		unit.getsavebuttonTermsandConditions().click();
		softAssert.assertEquals(valid_Termsandcondition, "termsandcondition is a Valid Alpha-Numeric");
	}

	// Edit terms and condition types
	@Test(dataProvider = "getEditdata")
	public void Edit_Termsandcondition(String EditTermsandconditionTest1) throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getEditTermsandConditions().click();
		unit.getupdateEditTermsandcondition().clear();
		unit.getupdateEditTermsandcondition().sendKeys(EditTermsandconditionTest1);
		String valid_string = valid_alphanum(EditTermsandconditionTest1, "Termsandcommunication", 25);
		String valid_Termsandcondition = valid_string;
		System.out.println(valid_Termsandcondition);
		Thread.sleep(3000);
		unit.geteditsavebuttonTermsandcondition().click();
		softAssert.assertEquals(valid_Termsandcondition, "termsandcondition is a Valid Alpha-Numeric");
		
	}
    
	//Delete Terms and condition
	@Test
	public void Delete_Terms_Condition() throws InterruptedException {
		Termsandconditionpage terms = new Termsandconditionpage(driver);
		terms.getconfiguration().click();
		terms.getTermsandconditionclick().click();
		terms.getdeleteclickinquirycommunication().click();
		terms.getdeleteclickconfirmationTermsandcondition().click();
	}

	//Search Terms and Condition 
	@Test(dataProvider = "getsearched")
	public void Search_Terms_Condition(String searchedentertexttermscondition1) throws InterruptedException {
		Termsandconditionpage terms = new Termsandconditionpage(driver);
		terms.getconfiguration().click();
		terms.getTermsandconditionclick().click();
		terms.getsearchtermsandcondition().sendKeys(searchedentertexttermscondition1);
		terms.getclicksearchtermsandcondition().click();
	}

	@Test
	public void exportexcel_Termsandcondition() throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getclickexportasexceltermsandcondition().click();

	}

	@Test
	public void Add_validation_Termsandcondition() throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getaddnewTermsandcondition().click();
		unit.getsavebuttonTermsandConditions().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-terms-condition-add/div/form/mat-dialog-content/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Terms & Condition is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Terms & Condition is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	@Test
	public void Edit_validation_Termsandcondition() throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getEditTermsandConditions().click();
		for (int i = 1; i <= 30; i++) {
			unit.getupdateEditTermsandcondition().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		unit.geteditsavebuttonTermsandcondition().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-terms-condition-add/div/form/mat-dialog-content/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Terms & Condition is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Terms & Condition is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Terms123" } };
	}

	//DataProvider for Edit
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "editterms123" } };
	}

	//DataProvider for Search
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "communication" } };
	}
}