package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.RoleRightsPage;
import resources.base;

public class RoleRightsOnlyEntryTest extends base {
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		//Login Process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("OnlyView_user"));
		loginPage.getpass().sendKeys(prop.getProperty("OnlyView_pass"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}
	
	//Verify Only Entry Roles Inquiry
		@Test()
		public void Verify_OnlyViewRoles_Inquiry() {
			SoftAssert softAssert=new SoftAssert();
			RoleRightsPage Inquiry = new RoleRightsPage(driver);
			Inquiry.getInquiry().click();

			//Inquiry Add Button
			boolean flag = true;
			try {
				WebElement addInquiry = Inquiry.getaddInquiry();
				flag = addInquiry.isDisplayed();
			} catch (Exception e) {
				System.out.println("Element not found: " + e.getMessage());
				flag = true;
			}
			System.out.println("Is Add Inquiry visible: " + flag);
			softAssert.assertFalse(flag);
			}

	
	
	
	
	
	
	
	
	
	
	
}
