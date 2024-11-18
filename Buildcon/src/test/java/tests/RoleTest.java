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
import pageObjects.Rolepage;
import resources.base;

public class RoleTest extends base {

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

	//Add Role
	@Test(dataProvider = "getAdddata")
	public void Add_Rolepage(String Rolepage1 ) throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getaddnewrole().click();
		unit.getaddrolename().sendKeys(Rolepage1);
		unit.getshowphonenumberchecked().click();
		String valid_string = valid_alphanum(Rolepage1,"Rolepage",10);
		String valid_Rolepage = valid_string;
		System.out.println(valid_Rolepage);
		Thread.sleep(3000);
		unit.getclickcreate().click();
		softAssert.assertEquals(valid_Rolepage, "Rolepage is a Valid Alpha-Numeric");
	}

	//Edit Role
	@Test(dataProvider = "getEditdata")
	public void Edit_Rolepage(String EditRolepage1) throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getEditRolebuttonclick().click();
		unit.getupdateEditrole().clear();
		unit.getupdateEditrole().sendKeys(EditRolepage1);
		String valid_string = valid_alphanum(EditRolepage1,"Rolepage",10);
		String valid_Rolepage = valid_string;
		System.out.println(valid_Rolepage);
		Thread.sleep(3000);
		unit.geteditsavebuttonrole().click();
		softAssert.assertEquals(valid_Rolepage, "Rolepage is a Valid Alpha-Numeric");
	}

	//Status Role Method
	@Test
	public void Status_Rolepage1() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getRolestatusclick().click();
		Role.getRolestatusclickconfirm().click();
	}

	//Delete Role Method
	@Test
	public void Delete_Rolepage() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getdeleteclickRole().click();
		Role.getdeleteclickconfirmationRole().click();
	}

	//Search Role Method
	@Test(dataProvider = "getsearch")
	public void searching_Rolepage(String searchedentertextRolepage1) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getsearchRole().sendKeys(searchedentertextRolepage1);
		Role.getclicksearchrole().click();
	}

	//Export To Excel Method
	@Test
	public void exportexcel_Rolepage() throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getclickexportasexcelRole().click();
	
	}
	
	@Test
	public void Add_validation_Rolepage() throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		 SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getaddnewrole().click();
	
		unit.getshowphonenumberchecked().click();
		Thread.sleep(2000);
		
		unit.getclickcreate().click();
		
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-content/form/div/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Role is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Role is required", expectedMessage, actualMessage);
	}
	
	@Test
	public void Edit_validation_Rolepage() throws InterruptedException {
		Rolepage unit = new Rolepage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getRoleclick().click();
		unit.getEditRolebuttonclick().click();
		for(int i =1;i<=30;i++) {
			unit.getupdateEditrole().sendKeys(Keys.BACK_SPACE);
		}
		
		Thread.sleep(3000);
		unit.geteditsavebuttonroleptionsecond().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-content/form/div/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Role is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Role is required", expectedMessage, actualMessage);
	}

	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Role777" } };
	}

	//DataProvider for Edit State
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { {"Adminnewside"} };
	}
	
    //DataProvider for Search Data
	@DataProvider
	public Object[][] getsearch() {
		return new Object[][] { {"Admin"} };
	}
}