package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProfessionPage;
import resources.base;

public class ProfessionTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	// Add Profession
	@Test(dataProvider = "AddProfessionData")
	public void Add_Profession(String professionname) throws InterruptedException, IOException {

		ProfessionPage Profession = new ProfessionPage(driver);
		Profession.getconfiguration().click();
		Profession.getProfession().click();
		Profession.getAddNewProfession().click();
		Thread.sleep(1000);
		Profession.getProfessionName().sendKeys(professionname);
		Thread.sleep(1000);
		Profession.getSaveButton().click();
	}

	// Change Status
	@Test(dataProvider = "Change_StatusProfessionData")
	public void Change_Status(String searchName) throws InterruptedException, IOException {

		ProfessionPage Profession = new ProfessionPage(driver);
		Profession.getconfiguration().click();
		Thread.sleep(1000);
		Profession.getProfession().click();
		Profession.getSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1000);
		Profession.getChangeStatus().click();
		Thread.sleep(1000);
		Profession.getYesButton().click();
	}

	// Update Profession
	@Test(dataProvider = "EditProfessionData")
	public void Edit_Profession(String searchName, String professionname) throws InterruptedException, IOException {

		ProfessionPage Profession = new ProfessionPage(driver);
		Profession.getconfiguration().click();
		Thread.sleep(1000);
		Profession.getProfession().click();
		Profession.getSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1000);
		Profession.getEditButton().click();
		Thread.sleep(1000);
		Profession.getProfessionName().clear();
		Thread.sleep(1000);
		Profession.getProfessionName().sendKeys(professionname);
		Thread.sleep(1000);
		Profession.getSaveButton().click();
	}

	// Delete Profession
	@Test(dataProvider = "DeleteProfessionData")
	public void Delete_Profession(String searchName) throws InterruptedException, IOException {

		ProfessionPage Profession = new ProfessionPage(driver);
		Profession.getconfiguration().click();
		Thread.sleep(1000);
		Profession.getProfession().click();
		Profession.getSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1000);
		Profession.getDeleteButton().click();
		Thread.sleep(1000);
		Profession.getYesButton().click();
	}

	// Search Profession
	@Test(dataProvider = "SearchProfessionData")
	public void Search_Profession(String searchName) throws InterruptedException, IOException {

		ProfessionPage Profession = new ProfessionPage(driver);
		Profession.getconfiguration().click();
		Thread.sleep(1000);
		Profession.getProfession().click();
		Profession.getSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1000);
	}

	// Export To Excel Profession
	@Test
	public void Export_To_Excel_Profession() throws InterruptedException, IOException {

		ProfessionPage Profession = new ProfessionPage(driver);
		Profession.getconfiguration().click();
		Thread.sleep(1000);
		Profession.getProfession().click();
		Thread.sleep(3000);
		Profession.getExportToExcel().click();

	}

	// Add Profession Data Provider
	@DataProvider
	public Object[][] AddProfessionData() {
		return new Object[][] { { "Developer" } };
	}

	// Change Status Profession Data Provider
	@DataProvider
	public Object[][] Change_StatusProfessionData() {
		return new Object[][] { { "Dev" } };
	}

	// Update Profession Data Provider
	@DataProvider
	public Object[][] EditProfessionData() {
		return new Object[][] { { "Engineer", "Jr.Developer" } };
	}

	// Delete Profession Data Provider
	@DataProvider
	public Object[][] DeleteProfessionData() {
		return new Object[][] { { "Dev" } };
	}

	// Search Profession Data Provider
	@DataProvider
	public Object[][] SearchProfessionData() {
		return new Object[][] { { "Dev" } };
	}
}
