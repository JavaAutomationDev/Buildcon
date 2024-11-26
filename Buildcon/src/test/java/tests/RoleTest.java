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
	public void Add_Role(String Rolepage1 ) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getaddrolename().sendKeys(Rolepage1);
        //Role text Data validation
		String valid_string = valid_alphanum(Rolepage1,"Rolepage",10);
		String valid_Rolepage = valid_string;
		System.out.println(valid_Rolepage);
		
		Role.getshowphonenumberchecked().click();
		
		Thread.sleep(3000);
		Role.getclickcreate().click();
		
		softAssert.assertEquals(valid_Rolepage, "Rolepage is a Valid Alpha-Numeric");
	    softAssert.assertAll();
	}

	//Edit Role
	@Test(dataProvider = "getEditdata")
	public void Edit_Role(String EditRolepage1) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getEditRolebuttonclick().click();
		
		Role.getupdateEditrole().clear();
		Role.getupdateEditrole().sendKeys(EditRolepage1);
		//Role Data Validation
		String valid_string = valid_alphanum(EditRolepage1,"Rolepage",10);
		String valid_Rolepage = valid_string;
		System.out.println(valid_Rolepage);
		
		Thread.sleep(3000);
		Role.geteditsavebuttonrole().click();
		Thread.sleep(3000);
		softAssert.assertEquals(valid_Rolepage, "Rolepage is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Status Role Method
	@Test
	public void Status_Role() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getRolestatusclick().click();
		Role.getRolestatusclickconfirm().click();
	}

	//Delete Role Method
	@Test
	public void Delete_Role() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getdeleteclickRole().click();
		Role.getdeleteclickconfirmationRole().click();
		Thread.sleep(2000);
	}

	//Search Role Method
	@Test(dataProvider = "getsearch")
	public void Search_Role(String searchedentertextRolepage1) throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getsearchRole().sendKeys(searchedentertextRolepage1);
		Role.getclicksearchrole().click();
		Thread.sleep(2000);
	}

	//Export To Excel Method
	@Test
	public void Export_Excel_Role() throws InterruptedException {
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getclickexportasexcelRole().click();
	}
	
	//Add Validation Role
	@Test
	public void Add_Validation_Role() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getaddnewrole().click();
		Role.getshowphonenumberchecked().click();
		
		Thread.sleep(2000);
		Role.getclickcreate().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
				+ "mat-dialog-content/form/div/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "1Role is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Role is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}
	
	//Edit Validation Role
	@Test
	public void Edit_Validation_Role() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Rolepage Role = new Rolepage(driver);
		Role.getconfiguration().click();
		Role.getRoleclick().click();
		Role.getEditRolebuttonclick().click();
		for(int i =1;i<=30;i++) {
			Role.getupdateEditrole().sendKeys(Keys.BACK_SPACE);
		}
		
		Thread.sleep(3000);
		Role.geteditsavebuttonroleptionsecond().click();
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div"
				+ "/mat-dialog-content/form/div/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		//Define the expected message
		String expectedMessage = "Role is required";
		softAssert.assertEquals("Role is required", expectedMessage, actualMessage);
		softAssert.assertAll();
	}
	
	// close the driver
		@AfterMethod
		public void teaddown() {
			 driver.close();
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