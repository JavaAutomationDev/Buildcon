package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AgenciesPage;
import pageObjects.LoginPage;
import resources.base;

public class AgenciesTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver=initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("A_AC"));  
		loginPage.getUserName().sendKeys(prop.getProperty("A_USER"));  
		loginPage.getpass().sendKeys(prop.getProperty("A_PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Agencies
	@Test(dataProvider="AgenciesAddData")
	public void Add_Agencies(String companyname,String agencyshortname,String accountname,String gstno,String cinno,String startdate,String enddate,
			String allowunits,String email,String address1,String address2,String city,String state,String pincode,String mobileno,String logo,
			String adminfirstname,String adminmiddlename,String adminlastname,String adminmobile,String adminemail,String admindesignation,
			String modules) throws InterruptedException {
		AgenciesPage agencies = new AgenciesPage(driver);
		agencies.getAddAgencies().click();
		agencies.getCompanyName().sendKeys(companyname);
		agencies.getAgencyShortName().sendKeys(agencyshortname);
		agencies.getAccountName().sendKeys(accountname);
		agencies.getGSTNumber().sendKeys(gstno);
		agencies.getcinnumber().sendKeys(cinno);
		agencies.getSubscriptionStartDate().sendKeys(startdate);
		agencies.getSubscriptionEndDate().sendKeys(enddate);
		agencies.getAllocatedUnits().sendKeys(allowunits);
		agencies.getEmail().sendKeys(email);
		agencies.getAddressLine1().sendKeys(address1);
		agencies.getAddressLine2().sendKeys(address2);
		agencies.getCity().sendKeys(city);
		agencies.getstate(state);
		agencies.getPincode().sendKeys(pincode);
		agencies.getMobileNo().sendKeys(mobileno);
		Thread.sleep(2000);
		agencies.getCompanyLogo().sendKeys(logo);
		agencies.getNextBtn().click();
		agencies.getAdminFirstName().sendKeys(adminfirstname);
		agencies.getAdminMiddleName().sendKeys(adminmiddlename);
		agencies.getAdminLastName().sendKeys(adminlastname);
		agencies.getAdminMobile().sendKeys(adminmobile);
		agencies.getAdminemail().sendKeys(adminemail);
		agencies.getAdminDesignation().sendKeys(admindesignation);
		agencies.getNextBtn1().click();
		agencies.getModules(modules);
		agencies.getCreateBtn().click();
	}

	//Close driver
	@AfterMethod
	public void teaddown() {
		driver.close();
	}

	//DataProvider for Add Agencies
	@DataProvider
	public Object [][] AgenciesAddData(){
		return new Object [][] {
			//companyname,       agencyshortname,  accountname,    gstno,               cinno,         startdate, enddate, allowunits,  email,  
			{"Akash Infotech Ltd",   "MK457",     "A0074",   "09AAACH7409R1ZZ", "U12345AB6784CDE123456",   "",       "",     "40",   "Akash@mail.com" 
				//address1,          address2,         city,        state,        pincode,   mobileno,          logo
				,"Bopal Ambli road", "Near BigBazar", "Bopal", "Andhra Pradesh",  "380058", "9856231452", "D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png",
				//adminfirstname, adminmiddlename, adminlastname, adminmobile,  adminemail,   admindesignation
				"Akash",        "SDET",          "Patel",     "8754210235", "ak@mail.com",  "SDET-QA",          "Documents"}};
	}
}