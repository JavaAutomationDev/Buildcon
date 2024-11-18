package tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Method
	@Test(dataProvider = "getAdddata")
	public void Add_formstatus(String addformstatus1, String addformstatus2, String addformstatus3)
			throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		// unit.getNameofformstatus().click();
		unit.getNameofformstatus().sendKeys(addformstatus1);
		Thread.sleep(2000);
		String valid_string = valid_alphanum(addformstatus1,"FORMSTATUS",10);
		String valid_formstatus = valid_string;
		System.out.println(valid_formstatus);
		unit.getusersclick2().click();
		unit.userSelected(addformstatus2);

		unit.getdisplayform().click();
		unit.getdisplayform().clear();
		unit.getdisplayform().sendKeys(addformstatus3);
		String valid_string1 = valid_number(addformstatus3,"displayform");
		String valid_Displayform = valid_string1;
		System.out.println(valid_Displayform);
		unit.getClickonsavebutton().click();
		softAssert.assertEquals(valid_formstatus, "Formstatus is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_Displayform, "Displayform is a valid Number");

	}
	// Edit terms and condition types

	@Test(dataProvider = "getEditdata")
	public void Edit_formstatus(String Editformstatus1) throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		unit.geteditclickformstatus().click();
		unit.geteditclickenterdata().clear();
		unit.geteditclickenterdata().sendKeys(Editformstatus1);
		String valid_string = valid_alphanum(Editformstatus1,"FORMSTATUS",10);
		String valid_formstatus = valid_string;
		System.out.println(valid_formstatus);
		Thread.sleep(2000);
		unit.geteditclicksaveformstatus().click();
		softAssert.assertEquals(valid_formstatus, "Formstatus is a Valid Alpha-Numeric");
	}

	@Test
	public void Delete_formstatus() throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		unit.getdeleteclickFormstatus().click();
		unit.getdeleteclickconfirmationformstatus().click();
	}

	@Test(dataProvider = "getsearched")
	public void searching_formstatus(String searchedentertexttermscondition1) throws InterruptedException {
		FormStatuspage form = new FormStatuspage(driver);
		form.getconfiguration().click();
		form.getFormStatuscick().click();
		form.getsearchsearchForm().sendKeys(searchedentertexttermscondition1);
		form.getclicksearchformstatus().click();
	}

	@Test
	public void exportexcel_formstatus() throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		unit.getclickexportasexcelformstatus().click();

	}

	@Test
	public void Add_validation_formstatus() throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		unit.getClickonsavebutton().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[1]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Form status name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Form status name is required", expectedMessage, actualMessage);

		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[2]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		// Define the expected message
		String expectedMessage1 = "Users is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Users is required", expectedMessage1, actualMessage1);

		WebElement messageElement2 = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[3]/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage2 = messageElement2.getText();
		System.out.println(messageElement2.getText());

		// Define the expected message
		String expectedMessage2 = "Display Order must be greater than 0";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Display Order must be greater than 0", expectedMessage2, actualMessage2);
		softAssert.assertAll();
	}

	@Test(dataProvider = "geteditsdata")
	public void EditFormStatusMultiple(String formstatus2, String formstatus3) throws InterruptedException {
		FormStatuspage unit = new FormStatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		// Navigation steps
		unit.getconfiguration().click();
		unit.getFormStatuscick().click();
		searching_formstatus("akash");
		unit.geteditclickformstatus().click();

		// Clear input field
		for (int i = 1; i <= 30; i++) {
			unit.geteditclickenterdata().sendKeys(Keys.BACK_SPACE);
		}

		// Wait for user selection
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(unit.getusersclick2())).click();

		// Uncheck the specified form status
		unit.userSelectedUnchecked(formstatus2);
		unit.getdisplayformindividual().click();
		unit.getdisplayformindividual().sendKeys(Keys.BACK_SPACE);
		unit.getdisplayformindividual().sendKeys(Keys.BACK_SPACE);
		// unit.getdisplayform().sendKeys(formstatus3);

		// Save changes
		unit.getClickonsavebuttonindividual().click();

		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr/td[1]/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(messageElement.getText());

		// Define the expected message
		String expectedMessage = "Form status name is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Form status name is required", expectedMessage, actualMessage);

		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr/td[2]/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(messageElement1.getText());

		// Define the expected message
		String expectedMessage1 = "Users is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Users is required", expectedMessage1, actualMessage1);

		WebElement messageElement2 = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr/td[3]/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage2 = messageElement2.getText();
		System.out.println(messageElement2.getText());

		// Define the expected message
		String expectedMessage2 = "Display Order is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals("Display Order is required", expectedMessage2, actualMessage2);
		softAssert.assertAll();
	}

//	@AfterMethod
//	public void teaddown() {
//		driver.close();
//	}

	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "anshul", "Automation Test", "20" } };
	}

	// DataProvider for edit form status
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Nishant12" } };
	}

	//DataProvider for Search
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "akash" } };
	}

	@DataProvider
	public Object[][] geteditsdata() {
		return new Object[][] { { "Automation Test", "20" } };
	}

}
