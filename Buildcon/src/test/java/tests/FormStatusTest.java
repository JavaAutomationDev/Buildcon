package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.FormStatuspage;
import pageObjects.LoginPage;
import resources.base;

public class FormStatusTest extends base {

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
	public void Add_formstatus(String formstatus1,String formstatus2 ) throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		//unit.getNameofformstatus().click();
		unit.getNameofformstatus().sendKeys(formstatus1);
		Thread.sleep(3000);
		unit.getusersclick().click();
		//unit.userselected(formstatus2);
		unit.getdisplayform().click();
		unit.getClickonsavebutton().click();
		
	}
	// Edit terms and condition types

//	@Test(dataProvider = "getEditdata")
//	public void Edit_formstatus(String Editformstatus1) throws InterruptedException {
//		FormStatuspage unit = new FormStatuspage(driver);
//		unit.getconfiguration().click();
//		unit.getFormStatuscick().click();
//		unit.getEditTermsandConditions().click();
//		unit.getupdateEditTermsandcondition().clear();
//		unit.getupdateEditTermsandcondition().sendKeys(Editformstatus1);
//		Thread.sleep(3000);
//		unit.geteditsavebuttonTermsandcondition().click();
//	}

	@Test(dataProvider = "getdelete")
	public void Delete_formstatus() throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		unit.getdeleteclickFormstatus().click();
		unit.getdeleteclickconfirmationformstatus().click();
	}

	@Test(dataProvider = "getsearched")
	public void searching_formstatus(String searchedentertexttermscondition1) throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		unit.getsearchsearchForm().sendKeys(searchedentertexttermscondition1);
		unit.getclicksearchformstatus().click();
	}

	@Test(dataProvider = "getexportexcel")
	public void exportexcel_formstatus(String searchedentertext) throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		unit.getclickexportasexcelformstatus().click();

	}

	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Akash"," Bhavin Patel " } };
	}

	// DataProvider for edit state
//	@DataProvider
//	public Object[][] getstateEditData() {
//		return new Object[][] { { "newruleandregulation" } };
//	}

	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "CCR" } };
	}

}
