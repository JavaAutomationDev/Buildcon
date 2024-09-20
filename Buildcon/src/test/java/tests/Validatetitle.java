package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LoginPage;
import resources.base;

public class Validatetitle extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeClass
	public void setcontext(ITestContext context){
		context.setAttribute("WebDriver", driver);
	}

	@BeforeTest
	public void initalize1() throws IOException {
		driver=initializeDriver();
		log.info("Driver is Initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");
	}

	@Test
	public void validatetitle1() throws IOException {

		LoginPage l = new LoginPage(driver);
		//compare the browser text with expected value with the TestNG Assertion
		Assert.assertEquals(l.gettitle().getText(), "Login");
		log.info("Successfully validated Login Text");

		//check the remember me checkbox displayed or not by putting below TestNG assertion below assertion will pass becuase same checkbox there in page
		Assert.assertTrue(l.getremember().isDisplayed());

		//below assertion will fail becuase same checkbox there in page so we get true
		Assert.assertFalse(l.getremember().isDisplayed());
	}

	@AfterTest
	public void teaddown() {
		driver.close();
	}

}
