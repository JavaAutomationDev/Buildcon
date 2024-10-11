package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

		// Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	// Add terms and condition types
	@Test(dataProvider = "getAdddata")
	public void Add_Termsandcondition(String TermsandconditionTest1 ) throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getaddnewTermsandcondition().click();
		unit.getAddNewTermsandConditionsdata().sendKeys(TermsandconditionTest1);
		Thread.sleep(3000);
		unit.getsavebuttonTermsandConditions().click();
	}
	
	// Edit terms and condition types
	@Test(dataProvider = "getEditdata")
	public void Edit_Termsandcondition(String EditTermsandconditionTest1) throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getEditTermsandConditions().click();
		unit.getupdateEditTermsandcondition().clear();
		unit.getupdateEditTermsandcondition().sendKeys(EditTermsandconditionTest1);
		Thread.sleep(3000);
		unit.geteditsavebuttonTermsandcondition().click();
	}

	@Test
	public void Delete_Termsandcondition() throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getdeleteclickinquirycommunication().click();
		unit.getdeleteclickconfirmationTermsandcondition().click();
	}

	@Test(dataProvider = "getsearched")
	public void searching_Termsandcondition(String searchedentertexttermscondition1) throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getsearchtermsandcondition().sendKeys(searchedentertexttermscondition1);
		unit.getclicksearchtermsandcondition().click();
	}
	
	@Test
	public void exportexcel_Termsandcondition() throws InterruptedException {
		Termsandconditionpage unit = new Termsandconditionpage(driver);
		unit.getconfiguration().click();
		unit.getTermsandconditionclick().click();
		unit.getclickexportasexceltermsandcondition().click();
	
	}

	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Termsandconition" } };
	}

	// DataProvider for edit state
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "newruleandregulation" } };
	}

	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { {"communication"} };
	}
}