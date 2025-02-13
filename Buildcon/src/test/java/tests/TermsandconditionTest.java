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

	//Add Terms and Condition
	@Test(dataProvider = "getAdddata",priority = 1)
	public void Add_Terms_Condition(String TermsandconditionTest1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Termsandconditionpage termscondition = new Termsandconditionpage(driver);
		termscondition.getconfiguration().click();
		termscondition.getTermsandconditionclick().click();
		termscondition.getaddnewTermsandcondition().click();
		
		termscondition.getAddNewTermsandConditionsdata().sendKeys(TermsandconditionTest1);
		//Terms and condition Text Data Validation
		String valid_string = valid_alphanum(TermsandconditionTest1, "Termsandcondition", 25);
		String valid_Termsandcondition = valid_string;
		System.out.println(valid_Termsandcondition);
		
		Thread.sleep(3000);
		termscondition.getsavebuttonTermsandConditions().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_Termsandcondition, "Termsandcondition is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	//Edit Terms and Condition
	@Test(dataProvider = "getEditdata",priority = 2)
	public void Edit_Terms_Condition(String EditTermsandconditionTest1,String searchedentertexttermscondition1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Termsandconditionpage termscondition = new Termsandconditionpage(driver);
		termscondition.getconfiguration().click();
		termscondition.getTermsandconditionclick().click();
		termscondition.getsearchtermsandcondition().sendKeys(searchedentertexttermscondition1);
		termscondition.getclicksearchtermsandcondition().click();
		termscondition.getEditTermsandConditions().click();
		
		termscondition.getupdateEditTermsandcondition().clear();
		termscondition.getupdateEditTermsandcondition().sendKeys(EditTermsandconditionTest1);
		//Terms and condition Text Data Validation
		String valid_string = valid_alphanum(EditTermsandconditionTest1, "Termsandcondition", 35);
		String valid_Termsandcondition = valid_string;
		System.out.println(valid_Termsandcondition);
		
		Thread.sleep(3000);
		termscondition.geteditsavebuttonTermsandcondition().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_Termsandcondition, "Termsandcondition is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
		
	}
    
	//Delete Terms and Condition
	@Test(dataProvider = "getdelete",priority = 5)
	public void Delete_Terms_Condition(String searchedentertexttermscondition1) throws InterruptedException {
		Termsandconditionpage termscondition = new Termsandconditionpage(driver);
		termscondition.getconfiguration().click();
		termscondition.getTermsandconditionclick().click();
		termscondition.getsearchtermsandcondition().sendKeys(searchedentertexttermscondition1);
		termscondition.getclicksearchtermsandcondition().click();
		termscondition.getdeleteclickinquirycommunication().click();
		Thread.sleep(2000);
		termscondition.getdeleteclickconfirmationTermsandcondition().click();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] getdelete() {
		return new Object[][] { { "Test termscondition 1" },{ "Test termscondition 2" },{ "Test termscondition 3" },{ "Test termscondition 4" } };
	}

	//Search Terms and Condition 
	@Test(dataProvider = "getsearched",priority = 4)
	public void Search_Terms_Condition(String searchedentertexttermscondition1) throws InterruptedException {
		Termsandconditionpage termscondition = new Termsandconditionpage(driver);
		termscondition.getconfiguration().click();
		termscondition.getTermsandconditionclick().click();
		termscondition.getsearchtermsandcondition().sendKeys(searchedentertexttermscondition1);
		termscondition.getclicksearchtermsandcondition().click();
		Thread.sleep(2000);
	}

	//Export Excel Terms Condition
	@Test(priority =3)
	public void exportexcel_Termsandcondition() throws InterruptedException {
		Termsandconditionpage termscondition = new Termsandconditionpage(driver);
		termscondition.getconfiguration().click();
		termscondition.getTermsandconditionclick().click();
		termscondition.getclickexportasexceltermsandcondition().click();
		Thread.sleep(2000);
	}

	//Add Validation Terms Condition
	@Test(priority = 6)
	public void Add_Validation_Terms_Condition() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Termsandconditionpage termscondition = new Termsandconditionpage(driver);
		termscondition.getconfiguration().click();
		termscondition.getTermsandconditionclick().click();
		termscondition.getaddnewTermsandcondition().click();
		termscondition.getsavebuttonTermsandConditions().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-terms-condition-add/"
				+ "div/form/mat-dialog-content/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Terms & Condition is required";
		softAssert.assertEquals("Terms & Condition is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Edit Validation Terms Condition
	@Test(priority = 7)
	public void Edit_Validation_Terms_Condition() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Termsandconditionpage termscondition = new Termsandconditionpage(driver);
		termscondition.getconfiguration().click();
		termscondition.getTermsandconditionclick().click();
		termscondition.getEditTermsandConditions().click();
		int nm = termscondition.getupdateEditTermsandcondition().getAttribute("value").length();
		for (int i = 1; i <= nm; i++) {
			termscondition.getupdateEditTermsandcondition().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(3000);
		termscondition.geteditsavebuttonTermsandcondition().click();
		Thread.sleep(2000);
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-terms-condition-add"
				+ "/div/form/mat-dialog-content/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Terms & Condition is required";
		softAssert.assertEquals("Terms & Condition is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	// close driver.
		@AfterMethod
		public void teaddown() {
			driver.close();
		}
	//DataProvider for Add Data
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Test termscondition 1" },{ "Test termscondition 2" },{ "Test termscondition 3" },{ "Test termscondition 4" } };
	}

	//DataProvider for Edit Data
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Test termscondition 1 update" ,"Test termscondition 1"  } };
	}

	//DataProvider for Search
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "Test termscondition 3"} };
	}
}