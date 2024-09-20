package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

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
	//using TestNG Data Provider we will do parametersied login scenarios with 2 users login with valid credentials and login with invalid credentials
	@Test(dataProvider="getdata")
	public void homepage1(String accountname, String username, String pass) throws IOException {
		LoginPage l = new LoginPage(driver);
		l.getAccountName().sendKeys(accountname);
		l.getUserName().sendKeys(username);
		l.getpass().sendKeys(pass);
		l.getvisible().click();
		l.getremember().click();
		l.getsignIn().click();
		log.info("Click the SignIN button");

		//System.out.println(type+"-->"+useremail+"-->"+pass);
		log.info(username+"-->"+pass+"-->"+accountname);
	}
	//close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}
	//use DataProvidor annotation for the login credentials parameterization.
	@DataProvider
	public Object[][] getdata() {
		return new Object[][] {
            { "sit12", "Chandni","Sit@123#"},//Valid user
            { "sit12", "Chandnis","Sit@123#s"}//Invalid user
        };
	}
}
