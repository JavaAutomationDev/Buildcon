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
import pageObjects.Projectstatuspage;
import resources.base;

public class ProjectStatusTest extends base {

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

	//Add Project Status
	@Test(dataProvider = "getAdddata")
	public void Add_Project_status(String projectstatus1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Projectstatuspage projectstatus = new Projectstatuspage(driver);
		projectstatus.getconfiguration().click();
		projectstatus.getprojectstatusclick().click();
		projectstatus.getaddprojectstatusclick().click();
		
		projectstatus.getprojectstatusadddata().sendKeys(projectstatus1);
		//Project Status Data Validation
		String valid_string = valid_alphanum(projectstatus1,"projectstatus",20);
		String valid_projectstatus = valid_string;
		System.out.println(valid_projectstatus);
		Thread.sleep(3000);
		projectstatus.getprojectstatussave().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_projectstatus, "projectstatus is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}
	
	//Edit Project Status
	@Test(dataProvider = "getEditdata")
	public void Edit_Project_Status(String Editprojectstatus1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Projectstatuspage projectstatus = new Projectstatuspage(driver);
		
		projectstatus.getconfiguration().click();
		projectstatus.getprojectstatusclick().click();
		projectstatus.getprojectstatuseditclick().click();
		
		projectstatus.getprojectStatuseditnewdataadd().clear();
		projectstatus.getprojectStatuseditnewdataadd().sendKeys(Editprojectstatus1);
		//Project Status Data Validation
		String valid_string = valid_alphanum(Editprojectstatus1,"projectstatus",20);
		String valid_projectstatus = valid_string;
		System.out.println(valid_projectstatus);
		
		Thread.sleep(3000);
		projectstatus.getprojectstatussave().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_projectstatus, "projectstatus is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Status Change Project Status
	@Test
	public void Status_Change_Project_Status() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectStatuschecked().click();
		unit.getprojectStatuscheckedconfirmation().click();
		Thread.sleep(2000);
	}

	//Delete Project Status
	@Test
	public void Delete_Project_Status() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectstatusdeleteclick().click();
		unit.getprojectstatusdeleteconfirmation().click();
		Thread.sleep(3000);
	}

	//Searching Project Status
	@Test(dataProvider = "getsearched")
	public void Searching_Project_Status1(String searchedentertext) throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectStatussearchedchecked().sendKeys(searchedentertext);
		unit.getprojectstatussearchediteam().click();
		Thread.sleep(2000);
	}

	//Excel Project Status
	@Test
	public void Excel_Project_Status() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectStatusexcel().click();
		Thread.sleep(2000);

	}

	//Add Validation Project Status
	@Test
	public void Add_Validation_Project_Status() throws InterruptedException {
		Projectstatuspage projectstatus = new Projectstatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		projectstatus.getconfiguration().click();
		projectstatus.getprojectstatusclick().click();
		projectstatus.getaddprojectstatusclick().click();
		projectstatus.getprojectstatussave().click();

		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-status-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		//Define the expected message
		String expectedMessage = "Project status name is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("Project status name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}
	
    //Edit Validation Project Status
	@Test(dataProvider = "getEditdata")
	public void Edit_validation_Project_Status(String Editprojectstatus1) throws InterruptedException {
		Projectstatuspage projectstatus = new Projectstatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		projectstatus.getconfiguration().click();
		projectstatus.getprojectstatusclick().click();
		projectstatus.getprojectstatuseditclick().click();
		for (int i = 1; i <= 13; i++) {
			projectstatus.getprojectStatuseditnewdataadd().sendKeys(Keys.BACK_SPACE);
		}
		projectstatus.getprojectstatussave().click();
		Thread.sleep(2000);

		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-status-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		//Define the expected message
		String expectedMessage = "Project status name is required";

		//Assert the actual message matches the expected message
		softAssert.assertEquals("Project status name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}
	
	//Close the driver
	@AfterMethod
	public void teardown() {
		 driver.close();
	}

	//DataProvider for Add Data
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "project maths" } };
	}

	//DataProvider for Edit Data
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { " saceconomics" } };
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "completed" } };
	}
}
