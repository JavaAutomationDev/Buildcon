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
import pageObjects.Projecttypespage;
import resources.base;

public class ProjecttypesTest extends base {

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

	//Add Project
	@Test(dataProvider = "getAdddata")
	public void Add_Project_Types(String projecttypes1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.Clickaddprojecttypes().click();
		
		projecttype.getaddprojecttypesdata().sendKeys(projecttypes1);
		//Prject type Data validation
		String valid_string = valid_alphanum(projecttypes1, "projecttype", 10);
		String valid_projecttype = valid_string;
		System.out.println(valid_projecttype);
		
		Thread.sleep(3000);
		projecttype.getsavebuttonprojecttypes().click();
		softAssert.assertEquals(valid_projecttype, "projecttypes is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Edit Project types
	@Test(dataProvider = "getEditdata")
	public void Edit_Project_Types(String Editprojecttypes1) throws InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.geteditprojecttypes().click();
		
		projecttype.geteditexistingdata().clear();
		projecttype.geteditexistingdata().sendKeys(Editprojecttypes1);
		//Prject type Data validation
		String valid_string = valid_alphanum(Editprojecttypes1, "projecttype", 10);
		String valid_projecttype = valid_string;
		System.out.println(valid_projecttype);
		
		Thread.sleep(3000);
		projecttype.geteditsave().click();
		
		softAssert.assertEquals(valid_projecttype, "projecttypes is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Status Change Project Type
	@Test()
	public void Status_Change_Project_Types() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.getclickchangestatus().click();
		projecttype.getconfirmationchangestatus().click();
	}

	//Delete Project Type
	@Test()
	public void Delete_Project_Type() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.getdeleteclick().click();
		projecttype.getdeleteclickconfirmation().click();
	}

	//Search Project Type
	@Test(dataProvider = "getsearched")
	public void Searching_Project_Types(String searchedentertext) throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.getsearchprojecttypes().sendKeys(searchedentertext);
		projecttype.getclicksearchedbutton().click();
	}

	//Add Validation Project Types
	@Test()
	public void Add_Validation_Project_Types() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.Clickaddprojecttypes().click();
		projecttype.getsavebuttonprojecttypes().click();

		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-type-add/div/form/mat-dialog-content/div"
						+ "[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		//Define the expected message
		String expectedMessage = "Project type name is required";
		softAssert.assertEquals("Project type name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Edit Validation Project Types(
	@Test(dataProvider = "getEditdata")
	public void Edit_Validation_Project_Types(String Editprojecttypes1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.geteditprojecttypes().click();

		for (int i = 1; i <= 7; i++) {
			projecttype.geteditexistingdata().sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(2000);
		projecttype.geteditsave().click();

		WebElement messagelement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-type-add/"
				+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[2]/div/mat-error/span"));
		String actualMessage = messagelement.getText();
		System.out.println(messagelement.getText());

		//Define the expected message
		String expectedMessage = "Project type name is required";
		softAssert.assertEquals("Project type name is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}

	//Excel Project Types
	@Test()
	public void Excel_Project_Types() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.getclickexcelbuttonproject().click();
	}

	//Close the driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	//DataProvider for Add Data
	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "physics123333333333" } };
	}

	//DataProvider for Edit Data
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "chemisry11" } };
	}

	//DataProvider for Serach Data
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "CCR" } };
	}
}