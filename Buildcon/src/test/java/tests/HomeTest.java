package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class HomeTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver=initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");
		
		//screenshot capture
		//@SuppressWarnings("unused")
		//String screenshot= getscreenshot("Screenshot", driver);
	}
	
	//Login Method for Buildcon
	@Test(dataProvider="Logindata")
	public void Shaligram_Login(String accountname,String username,String pass) throws IOException {
		LoginPage login = new LoginPage(driver);
		login.getAccountName().sendKeys(accountname);
		login.getUserName().sendKeys(username);
		login.getpass().sendKeys(pass);
		login.getvisible().click();
		login.getremember().click();
		login.getsignIn().click();
	}
	
	//Close the driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	//DataProvidor for login
	@DataProvider
	public Object[][] Logindata() {
		return new Object[][] {
            {"Sit12", "Chandni","Sit@123#"}
        };
	}
}
