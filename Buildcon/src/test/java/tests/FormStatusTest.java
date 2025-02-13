package tests;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.FormStatuspage;
import pageObjects.LoginPage;
import resources.base;

public class FormStatusTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());
    //public boolean myflag = true;
    //public FormStatuspage FormStatus;
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

	// Add Method
	@Test(dataProvider = "getAdddata", priority = 1)
	public void Add_formstatus(String addformstatus1, String addformstatus2, String addformstatus3)
			throws InterruptedException {
		FormStatuspage FormStatus = new FormStatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		FormStatus.getconfiguration().click();
		FormStatus.getFormStatuscick().click();
		// FormStatus.getNameofformstatus().click();
		FormStatus.getNameofformstatus().sendKeys(addformstatus1);
		Thread.sleep(2000);
		String valid_string = valid_alphanum(addformstatus1, "FORMSTATUS", 30);
		String valid_formstatus = valid_string;
		System.out.println(valid_formstatus);
		
		FormStatus.getusersclick2().click();
		
		FormStatus.userSelected(addformstatus2);

		FormStatus.getdisplayform().click();
		FormStatus.getdisplayform().clear();
		FormStatus.getdisplayform().sendKeys(addformstatus3);
		String valid_string1 = valid_number(addformstatus3, "displayform");
		String valid_Displayform = valid_string1;
		System.out.println(valid_Displayform);
		FormStatus.getClickonsavebutton().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_formstatus, "FORMSTATUS is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Displayform, "displayform is a Valid Number");
		softAssert.assertAll();

	}
	// Edit terms and condition types

	@Test(dataProvider = "getEditdata", priority = 2)
	public void Edit_formstatus(String Editformstatus1, String searchedentertexttermscondition1)
			throws InterruptedException {
		FormStatuspage FormStatus = new FormStatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		FormStatus.getconfiguration().click();
		FormStatus.getFormStatuscick().click();
		FormStatus.getsearchsearchForm().sendKeys(searchedentertexttermscondition1);
		Thread.sleep(2000);
		FormStatus.getclicksearchformstatus().click();
		FormStatus.geteditclickformstatus().click();
		FormStatus.geteditclickenterdata().clear();
		FormStatus.geteditclickenterdata().sendKeys(Editformstatus1);
		String valid_string = valid_alphanum(Editformstatus1, "FORMSTATUS", 30);
		String valid_formstatus = valid_string;
		System.out.println(valid_formstatus);
		Thread.sleep(2000);
		FormStatus.geteditclicksaveformstatus().click();
		Thread.sleep(2000);
		softAssert.assertEquals(valid_formstatus, "FORMSTATUS is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	@Test(dataProvider = "getdeleted", priority = 7)
	public void Delete_formstatus(String delstring) throws InterruptedException {
		
		
		FormStatuspage FormStatus = new FormStatuspage(driver);
		
		    FormStatus = new FormStatuspage(driver);
		    FormStatus.getconfiguration().click();
		    Thread.sleep(2000);
		    FormStatus.getFormStatuscick().click();
		  
		
		Thread.sleep(2000);
		FormStatus.getsearchsearchForm().sendKeys(delstring);
		Thread.sleep(2000);
		FormStatus.getsearchsearchForm().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		FormStatus.getdeleteclickFormstatus().click();
		Thread.sleep(2000);
		FormStatus.getdeleteclickconfirmationformstatus().click();
		Thread.sleep(2000);
	}
	
	// DataProvider for Delete
		@DataProvider
		public Object[][] getdeleted() {
			return new Object[][] { { "Test FormStatus 1" }, { "Test FormStatus 2" }, { "Test FormStatus 3" }, { "Test FormStatus 4" }  };
		}
	

	@Test(dataProvider = "getsearched", priority = 3)
	public void searching_formstatus(String searchedentertexttermscondition1) throws InterruptedException {
		FormStatuspage form = new FormStatuspage(driver);
		form.getconfiguration().click();
		form.getFormStatuscick().click();
		form.getsearchsearchForm().sendKeys(searchedentertexttermscondition1);
		Thread.sleep(2000);
		form.getclicksearchformstatus().click();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void exportexcel_formstatus() throws InterruptedException {
		FormStatuspage FormStatus = new FormStatuspage(driver);
		FormStatus.getconfiguration().click();
		FormStatus.getFormStatuscick().click();
		Thread.sleep(2000);
		FormStatus.getclickexportasexcelformstatus().click();
		Thread.sleep(2000);

	}

	@Test(priority = 5)
	public void Add_validation_formstatus() throws InterruptedException {
		FormStatuspage FormStatus = new FormStatuspage(driver);
		SoftAssert softAssert = new SoftAssert();
		FormStatus.getconfiguration().click();
		FormStatus.getFormStatuscick().click();
		FormStatus.getClickonsavebutton().click();
		Thread.sleep(2000);

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

	@Test(dataProvider = "editsearchedvalidation", priority =6 )
	public void EditFormStatusMultiples(String searchedentertexttermscondition1, String[] desiredValues)
			throws InterruptedException {
		FormStatuspage FormStatus = new FormStatuspage(driver);
		SoftAssert softAssert = new SoftAssert();

		// Navigation steps
		FormStatus.getconfiguration().click();
		FormStatus.getFormStatuscick().click();
		FormStatus.getsearchsearchForm().sendKeys(searchedentertexttermscondition1);
		Thread.sleep(2000);
		FormStatus.getclicksearchformstatus().click();
		Thread.sleep(2000);
		FormStatus.geteditclickformstatus().click();
		Thread.sleep(2000);

		// Clear input field
		int formstatus = FormStatus.geteditclickenterdata().getAttribute("value").length();
		for (int i = 1; i <= formstatus; i++) {
			FormStatus.geteditclickenterdata().sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);

		// Open the dropdown once
		FormStatus.getuserdropdownopen().click();
		Thread.sleep(2000);
		FormStatus.getuserdropdownselect(desiredValues);

		// Close the dropdown and move forward
		FormStatus.getuserdropdownopen().sendKeys(Keys.TAB);
		Thread.sleep(3000);

		// Clear the input in the display order field
		WebElement displayOrder = FormStatus.getdisplayformindividual();
		int nm = displayOrder.getAttribute("value").length();
		for (int i = 0; i < nm; i++) {
			displayOrder.sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(2000);
		FormStatus.getClickonsavebuttonindividual().click();
		Thread.sleep(2000);

		// Assertions for error messages
		WebElement messageElement = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr/td[1]/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage = messageElement.getText();
		System.out.println(actualMessage);

		// Define the expected message
		String expectedMessage = "Form status name is required.";

		// Assert the actual message matches the expected message
		softAssert.assertEquals(actualMessage, expectedMessage);

		WebElement messageElement1 = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr/td[2]/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage1 = messageElement1.getText();
		System.out.println(actualMessage1);

		// Define the expected message
		String expectedMessage1 = "Users is required";

		// Assert the actual message matches the expected message
		softAssert.assertEquals(actualMessage1, expectedMessage1);

		WebElement messageElement2 = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr/td[3]/div/mat-form-field/div[2]/div/mat-error/span"));

		String actualMessage2 = messageElement2.getText();
		System.out.println(actualMessage2);

		// Define the expected message
		String expectedMessage2 = "Display Order is required.";

		// Assert the actual message matches the expected message
		softAssert.assertEquals(actualMessage2, expectedMessage2);

		// Final assertion check
		softAssert.assertAll();
	}

	/// close driver.
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getAdddata() {
		return new Object[][] { { "Test FormStatus 1", "Nilesh Panchal", "10" }, { "Test FormStatus 2", "Nilesh Panchal", "20" },
				{ "Test FormStatus 3", "Nilesh Panchal", "30" }, { "Test FormStatus 4", "Nilesh Panchal", "40" } };
	}

	// DataProvider for edit form status
	@DataProvider
	public Object[][] getEditdata() {
		return new Object[][] { { "Test FormStatus 2 Up", "Test FormStatus 2" } };
	}

	// DataProvider for Search
	@DataProvider
	public Object[][] getsearched() {
		return new Object[][] { { "Test FormStatus 1" } };
	}

	@DataProvider(name = "editsearchedvalidation")
	public Object[][] provideData() {
		return new Object[][] {
				{ "Test FormStatus 4", new String[] { "Nilesh Panchal", "AutomationEmpDelete Test", "Automation Test" } }

		};
	}

}
