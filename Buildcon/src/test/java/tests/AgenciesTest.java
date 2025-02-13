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

import pageObjects.AgenciesPage;
import pageObjects.LoginPage;
import resources.base;

public class AgenciesTest extends base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver = initializeDriver();
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

	// Add Agencies
	@Test(dataProvider = "AgenciesAddData", priority = 1)
	public void Add_Agencies(String companyname, String agencyshortname, String accountname, String gstno, String cinno,
			String startdate, String enddate, String allowunits, String email, String address1, String address2,
			String city, String state, String pincode, String mobileno, String logo, String AgencyFavicon,
			String adminfirstname, String adminmiddlename, String adminlastname, String adminmobile, String adminemail,
			String admindesignation, String modules) throws InterruptedException {
		
		AgenciesPage agencies = new AgenciesPage(driver);
		agencies.getAddAgencies().click();
		Thread.sleep(1000);
		agencies.getCompanyName().sendKeys(companyname);
		agencies.getAgencyShortName().sendKeys(agencyshortname);
		agencies.getAccountName().sendKeys(accountname);
		agencies.getGSTNumber().sendKeys(gstno);
		agencies.getcinnumber().sendKeys(cinno);
		agencies.getSubscriptionStartDate().click();
		agencies.getSelectSingleDate(startdate);
		Thread.sleep(1000);
		agencies.getSubscriptionEndDate().click();
		agencies.getSelectSingleDate(enddate);
		Thread.sleep(1000);
		agencies.getAllocatedUnits().sendKeys(allowunits);
		agencies.getEmail().sendKeys(email);
		agencies.getAddressLine1().sendKeys(address1);
		agencies.getAddressLine2().sendKeys(address2);
		agencies.getCity().sendKeys(city);
		agencies.getstate(state);
		Thread.sleep(1000);
		agencies.getPincode().sendKeys(pincode);
		agencies.getMobileNo().sendKeys(mobileno);
		Thread.sleep(1000);
		agencies.getCompanyLogo().sendKeys(logo);
		Thread.sleep(1000);
		agencies.getAgencyFavicon().sendKeys(AgencyFavicon);
		Thread.sleep(1000);
		agencies.getNextBtn().click();
		Thread.sleep(1000);
		agencies.getAdminFirstName().sendKeys(adminfirstname);
		Thread.sleep(1000);
		agencies.getAdminMiddleName().sendKeys(adminmiddlename);
		Thread.sleep(1000);
		agencies.getAdminLastName().sendKeys(adminlastname);
		Thread.sleep(1000);
		agencies.getAdminMobile().sendKeys(adminmobile);
		Thread.sleep(1000);
		agencies.getAdminemail().sendKeys(adminemail);
		Thread.sleep(1000);
		agencies.getAdminDesignation().sendKeys(admindesignation);
		Thread.sleep(1000);
		agencies.getNextBtn1().click();
		Thread.sleep(1000);
		agencies.getModules(modules);
		Thread.sleep(1000);
		agencies.getCreateBtn().click();
	}

	@Test(dataProvider = "AgenciesEditData", priority = 2)
	public void Edit_Agencies(String agencyame, String companyname, String agencyshortname, String accountname,
			String gstno, String cinno, String startdate, String enddate, String allowunits, String email,
			String address1, String address2, String city, String state, String pincode, String mobileno,
			String adminfirstname, String adminmiddlename, String adminlastname, String adminmobile, String adminemail,
			String admindesignation, String modules) throws InterruptedException {
		AgenciesPage agencies = new AgenciesPage(driver);
		agencies.getSearchAgency().sendKeys(agencyame);
		agencies.getSearchAgency().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		agencies.getEditButton().click();
		Thread.sleep(1000);
		agencies.getCompanyName().clear();
		agencies.getCompanyName().sendKeys(companyname);
		agencies.getAgencyShortName().clear();
		agencies.getAgencyShortName().sendKeys(agencyshortname);
		agencies.getAccountName().clear();
		agencies.getAccountName().sendKeys(accountname);
		agencies.getGSTNumber().clear();
		agencies.getGSTNumber().sendKeys(gstno);
		agencies.getcinnumber().clear();
		agencies.getcinnumber().sendKeys(cinno);
		agencies.getSubscriptionStartDate().click();
		agencies.getSelectSingleDate(startdate);
		Thread.sleep(1000);
		agencies.getSubscriptionEndDate().click();
		agencies.getSelectSingleDate(enddate);
		Thread.sleep(1000);
		agencies.getAllocatedUnits().clear();
		agencies.getAllocatedUnits().sendKeys(allowunits);
		agencies.getEmail().clear();
		agencies.getEmail().sendKeys(email);
		agencies.getAddressLine1().clear();
		agencies.getAddressLine1().sendKeys(address1);
		agencies.getAddressLine2().clear();
		agencies.getAddressLine2().sendKeys(address2);
		agencies.getCity().clear();
		agencies.getCity().sendKeys(city);
		agencies.getstate(state);
		Thread.sleep(1000);
		agencies.getPincode().clear();
		agencies.getPincode().sendKeys(pincode);
		agencies.getMobileNo().clear();
		agencies.getMobileNo().sendKeys(mobileno);
		Thread.sleep(1000);
		agencies.getEditnextbtn().click();
		Thread.sleep(1000);
		agencies.getAdminFirstName().clear();
		agencies.getAdminFirstName().sendKeys(adminfirstname);
		agencies.getAdminMiddleName().clear();
		agencies.getAdminMiddleName().sendKeys(adminmiddlename);
		agencies.getAdminLastName().clear();
		agencies.getAdminLastName().sendKeys(adminlastname);
		agencies.getAdminMobile().clear();
		agencies.getAdminMobile().sendKeys(adminmobile);
		agencies.getAdminemail().clear();
		agencies.getAdminemail().sendKeys(adminemail);
		agencies.getAdminDesignation().clear();
		agencies.getAdminDesignation().sendKeys(admindesignation);
		agencies.getNextBtn1().click();
		Thread.sleep(1000);
		agencies.getModules(modules);
		Thread.sleep(1000);
		agencies.getCreateBtn().click();
	}

	@Test(dataProvider = "AgenciesSearchData", priority = 3)
	public void Search_Agencies(String agencyame) throws InterruptedException {
		AgenciesPage agencies = new AgenciesPage(driver);
		agencies.getSearchAgency().sendKeys(agencyame);
		agencies.getSearchAgency().sendKeys(Keys.ENTER);
		boolean flag = agencies.NoPageFound();
		if (flag == false) {
		}
		Thread.sleep(2000);
	}

	@Test(dataProvider = "ChangeStatusData", priority = 4)
	public void Change_Status_Agencies(String changestatus) throws InterruptedException {
		AgenciesPage agencies = new AgenciesPage(driver);
		agencies.getSearchAgency().sendKeys(changestatus);
		agencies.getSearchAgency().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		agencies.getChangeStatus().click();
		Thread.sleep(1000);
		agencies.getYesButton().click();
		Thread.sleep(1000);
	}

	@Test(dataProvider = "GenerateURLData", priority = 5)
	public void GenerateURL(String agencyame) throws InterruptedException {
		AgenciesPage agencies = new AgenciesPage(driver);
		agencies.getSearchAgency().sendKeys(agencyame);
		agencies.getSearchAgency().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		agencies.getGenerateURL().click();
		Thread.sleep(2000);
		agencies.getAgencyURLCrossIcon().click();
		Thread.sleep(2000);
	}

	@Test(dataProvider = "AgenciesDeleteData", priority = 6)
	public void Delete_Agencies(String agencyame) throws InterruptedException {
		AgenciesPage agencies = new AgenciesPage(driver);
		agencies.getSearchAgency().sendKeys(agencyame);
		agencies.getSearchAgency().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		agencies.getDeleteButton().click();
		Thread.sleep(1000);
		agencies.getYesButton().click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	// Close driver
	@AfterMethod
	public void teaddown() {
		if (driver != null)
			driver.close();
	}

	// DataProvider for Add Agencies
	@DataProvider
	public Object[][] AgenciesAddData() {
		return new Object[][] {
				// companyname, agencyshortname, accountname, gstno, cinno,
				// subscriptionstartdate, subscriptionenddate, allowunits, email,
				{ "Akash Infotech Ltd", "MK457", "A0074", "09AAACH7409R1ZA", "U12345AB6784CDE123456", "23/JAN/2025",
						"23/JAN/2026", "40", "Akash@mail.com"
						// address1, address2, city, state, pincode, mobileno, Companylogo, Agency
						// Favicon,
						, "Bopal Ambli road", "Near BigBazar", "Bopal", "Andhra Pradesh", "380058", "9856231452",
						"C:\\Vimal\\Bugs_Screenshot&video\\Sample_Image\\1LogoShaligram.png",
						"C:\\Vimal\\Bugs_Screenshot&video\\Sample_Image\\1LogoShaligram.png",
						// adminfirstname, adminmiddlename, adminlastname, adminmobile,
						// adminemail,admindesignation, Module Access,
						"Akash", "SDET", "Patel", "8754210235", "ak@mail.com", "SDET-QA", "Documents" }

		};
	}

	// DataProvider for Agencies Edit
	@DataProvider
	public Object[][] AgenciesEditData() {
		return new Object[][] { { "Akash Infotech Ltd", "Akash Infotech Ltd", "MK457", "A0074", "09AAACH7409R1ZA",
				"U12345AB6784CDE123456", "23/JAN/2025", "23/JAN/2026", "40", "Akash@mail.com", "Bopal Ambli road",
				"Near BigBazar", "Bopal", "Andhra Pradesh", "380058", "9856231452", "Akash", "SDET", "Patel",
				"8754210235", "ak@mail.com", "SDET-QA", "Documents" } };
	}

	// DataProvider for Agencies Delete
	@DataProvider
	public Object[][] AgenciesDeleteData() {
		return new Object[][] { { "Akash Infotech Ltd" } };
	}

	// DataProvider for Agencies Search
	@DataProvider
	public Object[][] AgenciesSearchData() {
		return new Object[][] { { "Akash Infotech Ltd sdjhksd" } };
	}

	// DataProvider for Change Status
	@DataProvider
	public Object[][] ChangeStatusData() {
		return new Object[][] { { "Agency" } };
	}

	// DataProvider for Generate URL
	@DataProvider
	public Object[][] GenerateURLData() {
		return new Object[][] { { "Agency 9" } };
	}
}