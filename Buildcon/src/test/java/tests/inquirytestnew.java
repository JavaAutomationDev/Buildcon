package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.inquiryformnew;
import resources.base;

public class inquirytestnew extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeMethod
	public void initialize11() throws IOException {
		driver=initializeDriver();
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
	
	//Add Inquiry form data
		@Test(dataProvider="getdata")
		public void InquiryFormTestN(String sitesproject,String visitorsname) throws InterruptedException {
			inquiryformnew i = new inquiryformnew(driver);
			i.getinquirynewform().click();
			Thread.sleep(3000);
	        i.selectSiteProject(sitesproject);
	        Thread.sleep(3000);
	        i.getvisitor().sendKeys(visitorsname);
			
			
		}
		
		//Add Inquiry Form data
		@DataProvider
		public Object[][] getdata() {
			return new Object[][] {
	            {"Parisar homes","Nishant Singh"}};
		}

}
