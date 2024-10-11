package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

		// Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add unit
	@Test(dataProvider = "getstateAdddata")
	public void Add_State(String statename1, String statecode1) throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatename().click();
		state.eneterstatename().sendKeys(statename1);
		state.getstatecode().sendKeys(statecode1);
		state.getsavestate().click();
	}

	//Editing an existing unit using Data Provider
	@Test(dataProvider = "getstateEditData")
	public void Edit_state(String newstatename1, String newstatecode1) throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.editrow().click();
		state.editadddata().clear();
		state.editadddata().sendKeys(newstatename1);
		state.editrowaddstatecode().clear();
		state.editrowaddstatecode().sendKeys(newstatecode1);
		Thread.sleep(2000);
		state.editrowsavebutton().click();
	}

	//status change of the existing record
	@Test
	public void status_state() throws InterruptedException {
		Statepage unit = new Statepage(driver);
		unit.getconfiguration().click();
		unit.getclickstate().click();
		unit.getstatusclick().click();
		unit.getstatusconfirmation().click();
		Thread.sleep(2000);
	}

	//delete record of the existing records
	@Test
	public void delete_state() throws InterruptedException {
		Statepage unit = new Statepage(driver);
		unit.getconfiguration().click();
		unit.getclickstate().click();
		unit.getdeletestate().click();
		unit.getdeletestateconfirm().click();
		Thread.sleep(2000);
	}
	
	//Search record
	@Test(dataProvider = "getstatesearch")
	public void search_state(String statesearch1) throws InterruptedException {
		Statepage unit = new Statepage(driver);
		unit.getconfiguration().click();
		unit.getclickstate().click();
		unit.getstatesearching().sendKeys(statesearch1);
		unit.getstatesearchingclick().click();
		Thread.sleep(2000);
	}
	
	@Test
	public void state_excel() throws InterruptedException {
		Statepage unit = new Statepage(driver);
		unit.getconfiguration().click();
		unit.getclickstate().click();
		unit.getstateexcel().click();
	}
	
    //Close the Driver
    @AfterMethod
	public void teaddown() {
		driver.close();
	}

	//DataProvider for Add state
	@DataProvider
	public Object[][] getstateAdddata() {
		return new Object[][] { { "Patna", "202" } };
	}

	//DataProvider for edit state
	@DataProvider
	public Object[][] getstateEditData() {
		return new Object[][] { { "Motihari", "102" } };
	}
	
	
	//DataProvider for search state
	@DataProvider
	public Object[][] getstatesearch() {
		return new Object[][] { { "Motihari" }};
	}

}