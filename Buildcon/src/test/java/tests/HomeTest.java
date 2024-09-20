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
		@SuppressWarnings("unused")
		String screenshot= getscreenshot("Screenshot", driver);
	}
	//Login
	@Test(dataProvider="getdata")
	public void ShaligramHome(String accountname, String username, String pass) throws IOException {
		LoginPage l = new LoginPage(driver);
		l.getAccountName().sendKeys(accountname);
		l.getUserName().sendKeys(username);
		l.getpass().sendKeys(pass);
		l.getvisible().click();
		l.getremember().click();
		l.getsignIn().click();
	}
	//close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}
	//DataProvidor for the login.
	@DataProvider
	public Object[][] getdata() {
		return new Object[][] {
            {"SA001", "Admin","Sit@1234"},//Valid user
        };
	}
}
