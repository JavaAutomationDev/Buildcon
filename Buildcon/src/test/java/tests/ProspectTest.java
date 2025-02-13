package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.EmployeePage;
import pageObjects.ProspectPage;
import pageObjects.SelectfilterDatesPage;
import resources.base;

public class ProspectTest extends base {

	// Add Prospect
	@Test(dataProvider = "ProspectAdddata", priority = 1)
	public void Add_Prospect(String siteproject, String visitorname, String visitordate, String NextfollowUpDT,
			String Status,String Attende, String ContactNo, String Email, String Address,
			String Remarks, String Requirement, String source, String channelpartnerORreferencename,
			String channelpartnerORreferencecontact, String channelpartnerfirmname, String intrest, String approxbudget,

			String unitD, String Selectflat) throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getAddprospect().click();
		Thread.sleep(1000);

		Prospect.getsiteproject(siteproject.trim());// Required Field
		Thread.sleep(1000);
		
		Prospect.getvisitorname().sendKeys(visitorname);// Required Field
		softAssert.assertFalse(visitorname.isEmpty(), "Visitor Name is required.");
		// Visitor Name Text Data Validation
		String valid_string = validateText(visitorname, "VisitorName", 5, 30);
		String valid_visitorname = valid_string;
		System.out.println(valid_visitorname);
		Thread.sleep(1000);

		Prospect.getvisitordate().sendKeys(visitordate);
		Thread.sleep(1000);

		Prospect.getIntime().click();// Click on InTime
		Prospect.getOk().click();// Click on Ok for time selection
		Thread.sleep(1000);

		Prospect.getouttime().click();// Click on OutTime
		Prospect.getOk().click();// Click on Ok for time selection
		Thread.sleep(1000);

		Prospect.getNextfollowUpDT().sendKeys(NextfollowUpDT);
		Thread.sleep(1000);

		Prospect.getstatus(Status.trim());
		Thread.sleep(1000);
		
		Prospect.getAttendee(Attende.trim());// Required Field
		Thread.sleep(1000);
		
		Prospect.getContactNo().sendKeys(ContactNo); // Required Field
		// Contact No Number Validation
		valid_string = valid_number(ContactNo, "InquiryContactNo");
		String valid_contactno = valid_string;
		System.out.println(valid_contactno);
		softAssert.assertFalse(ContactNo.isEmpty(), "Contact Number is required.From The Prospect Form");
		Thread.sleep(1000);
		
		Prospect.getEmail().sendKeys(Email);
		// Email Validation
		valid_string = valid_EMail(Email, "InquiryEmail");
		String valid_email = valid_string;
		System.out.println(valid_email);
		Thread.sleep(1000);
		
		Prospect.getAddress().sendKeys(Address);
		// Adress Alphanumeric Validation
		valid_string = valid_alphanum(Address, "InquiryAddress", 10);
		String valid_address = valid_string;
		System.out.println(valid_address);
		Thread.sleep(1000);
		
		Prospect.getRemarks().sendKeys(Remarks);
		// Remarks Text Data Validation
		valid_string = validateText(Remarks, "Remarks", 5, 10);
		String valid_remarks = valid_string;
		System.out.println(valid_remarks);
		Thread.sleep(1000);
		
		Prospect.getrequirement().sendKeys(Requirement);
		Thread.sleep(1000);
		
		Prospect.getSource(source.trim());
		Thread.sleep(1000);
		if (source.contains("Chanel Partner")) {
			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Chanel Partner Name is required.");
			Prospect.getChannelPartnerName().sendKeys(channelpartnerORreferencename);
			// Channel Partner Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "channel partner name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"channel partner name is a Valid Alpha-Numeric is a valid Maxlenght");

			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Chanel Partner's Contact is required.");
			Prospect.getChannelPartnerContact().sendKeys(channelpartnerORreferencecontact);
			// channel partner OR reference contact Number Validation
			valid_string = valid_number(channelpartnerORreferencecontact, "Channel Partner Contact");
			String valid_channelpartnerORreferencecontact = valid_string;
			System.out.println(valid_channelpartnerORreferencecontact);
			softAssert.assertEquals(valid_channelpartnerORreferencecontact,
					"Channel Partner Contact is a Valid Number");

			Prospect.getChannelPartnerFirmName().sendKeys(channelpartnerfirmname);
			// Channel Partner's Firm Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerfirmname, "Channel Partner Firm Name", 50);
			String valid_channelpartnerfirmname = valid_string;
			System.out.println(valid_channelpartnerfirmname);
			softAssert.assertEquals(valid_channelpartnerfirmname,
					"Channel Partner Firm Name is a Valid Alpha-Numeric is a valid Maxlenght");

		} else if (source.contains("Other")) {
			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Reference Name is required.");
			Prospect.getReferenceName().sendKeys(channelpartnerORreferencename);
			// Channel Partner Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "Reference Name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"Reference Name is a Valid Alpha-Numeric is a valid Maxlenght");

			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Reference's Contact is required.");
			Prospect.getReferenceContact().sendKeys(channelpartnerORreferencecontact);
			// channel partner OR reference contact Number Validation
			valid_string = valid_number(channelpartnerORreferencecontact, "Reference Contact");
			String valid_channelpartnerORreferencecontact = valid_string;
			System.out.println(valid_channelpartnerORreferencecontact);
			softAssert.assertEquals(valid_channelpartnerORreferencecontact, "Reference Contact is a Valid Number");

		} else {
			Prospect.getReferenceName().sendKeys(channelpartnerORreferencename);
			// Channel Partner Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "Reference Name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"Reference Name is a Valid Alpha-Numeric is a valid Maxlenght");
		}
		Thread.sleep(2000);

		Prospect.getIntrest(intrest);
		Thread.sleep(1000);
		
		Prospect.getApproxBudget(approxbudget);
		Thread.sleep(1000);

		Prospect.getunitdropdown(unitD.trim()); // Required Field
		Thread.sleep(1000);
		
		Prospect.getSelectFlat(Selectflat.trim()); // Required Field
		Thread.sleep(1000);

		Thread.sleep(2000);
		Prospect.getsave().click();
		Thread.sleep(2000);

		softAssert.assertEquals(valid_visitorname,
				"VisitorName is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_contactno, "InquiryContactNo is a Valid Number");
		softAssert.assertEquals(valid_address, "InquiryAddress is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_email, "InquiryEmail is a Valid EMail");
		softAssert.assertEquals(valid_remarks, "Remarks is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertAll();
	}

	// Editing an Existing Prospect using Data Provider
	@Test(dataProvider = "ProspectEditData", priority = 2)
	public void Edit_Prospect(String visitorname, String newContactNo, String newEmail, String newAddress,
			String newRemarks, String newRequirement, String source, String channelpartnerORreferencename,
			String channelpartnerORreferencecontact, String channelpartnerfirmname, String newStatus)
			throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getSearch().sendKeys(visitorname.trim() + Keys.ENTER);
		Thread.sleep(2000);
		Prospect.getProspectEditBtn().click();
		Thread.sleep(1000);
		
		Prospect.getContactNo().clear();
		Prospect.getContactNo().sendKeys(newContactNo);
		// Contact No Number Validation
		String valid_contactno = valid_number(newContactNo, "ContactNo");
		System.out.println(valid_contactno);
		Thread.sleep(1000);
		
		Prospect.getEmail().clear();
		Prospect.getEmail().sendKeys(newEmail);
		// Email Validation
		String valid_email = valid_EMail(newEmail, "Email");
		System.out.println(valid_email);
		Thread.sleep(1000);
		
		Prospect.getAddress().clear();
		Prospect.getAddress().sendKeys(newAddress);
		// Adress Alphanumeric Validation
		String valid_address = valid_alphanum(newAddress, "Address", 10);
		System.out.println(valid_address);
		Thread.sleep(1000);
		
		Prospect.getRemarks().clear();
		Prospect.getRemarks().sendKeys(newRemarks);
		// Remarks Text Data Validation
		String valid_remarks = validateText(newRemarks, "Remarks", 5, 10);
		System.out.println(valid_remarks);
		Thread.sleep(1000);
		
		Prospect.getrequirement().clear();
		Prospect.getrequirement().sendKeys(newRequirement);
		Thread.sleep(1000);
		
		Prospect.getSource(source.trim());
		Thread.sleep(1000);
		if (source.contains("Chanel Partner")) {
			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Chanel Partner Name is required.");
			Prospect.getChannelPartnerName().clear();
			Prospect.getChannelPartnerName().sendKeys(channelpartnerORreferencename);
			// Channel Partner Name Alphanumeric Validation
			String valid_string = valid_alphanum(channelpartnerORreferencename, "channel partner name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"channel partner name is a Valid Alpha-Numeric is a valid Maxlenght");

			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Chanel Partner's Contact is required.");
			Prospect.getChannelPartnerContact().clear();
			Prospect.getChannelPartnerContact().sendKeys(channelpartnerORreferencecontact);
			// Channel Partner Contact Number Validation
			valid_string = valid_number(channelpartnerORreferencecontact, "Channel Partner Contact");
			String valid_channelpartnerORreferencecontact = valid_string;
			System.out.println(valid_channelpartnerORreferencecontact);
			softAssert.assertEquals(valid_channelpartnerORreferencecontact,
					"Channel Partner Contact is a Valid Number");

			Prospect.getChannelPartnerFirmName().clear();
			Prospect.getChannelPartnerFirmName().sendKeys(channelpartnerfirmname);
			// Channel Partner's Firm Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerfirmname, "Channel Partner Firm Name", 50);
			String valid_channelpartnerfirmname = valid_string;
			System.out.println(valid_channelpartnerfirmname);
			softAssert.assertEquals(valid_channelpartnerfirmname,
					"Channel Partner Firm Name is a Valid Alpha-Numeric is a valid Maxlenght");

		} else if (source.contains("Other")) {
			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Reference Name is required.");
			Prospect.getReferenceName().clear();
			Prospect.getReferenceName().sendKeys(channelpartnerORreferencename);
			// Reference Name Alphanumeric Validation
			String valid_string = valid_alphanum(channelpartnerORreferencename, "Reference Name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"Reference Name is a Valid Alpha-Numeric is not a valid Maxlenght");

			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Reference's Contact is required.");
			Prospect.getReferenceContact().clear();
			Prospect.getReferenceContact().sendKeys(channelpartnerORreferencecontact);
			// Reference Contact Number Validation
			valid_string = valid_number(channelpartnerORreferencecontact, "Reference Contact");
			String valid_channelpartnerORreferencecontact = valid_string;
			System.out.println(valid_channelpartnerORreferencecontact);
			softAssert.assertEquals(valid_channelpartnerORreferencecontact, "Reference Contact is a Valid Number");

		} else {
			Prospect.getReferenceName().clear();
			Prospect.getReferenceName().sendKeys(channelpartnerORreferencename);
			// Reference Name Alphanumeric Validation
			String valid_string = valid_alphanum(channelpartnerORreferencename, "Reference Name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"Reference Name is a Valid Alpha-Numeric is not a valid Maxlenght");
		}

		Prospect.getstatus(newStatus.trim());
		Thread.sleep(2000);
		Prospect.getsave().click();
		Thread.sleep(2000);

		softAssert.assertEquals(valid_contactno, "ContactNo is a Valid Number");
		softAssert.assertEquals(valid_email, "Email is a Valid EMail");
		softAssert.assertEquals(valid_address, "Address is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_remarks,
				"Remarks is a Valid text - is a valid Minlenght - is not a valid Maxlenght");
		softAssert.assertAll();
	}

	// Delete Prospect
	@Test(dataProvider = "DeleteProspectData", priority = 16)
	public void Delete_Prospect(String name) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getSearch().sendKeys(name.trim() + Keys.ENTER);
		Thread.sleep(1000);
		Prospect.getDelete();
		Thread.sleep(2000);
		Prospect.getClickYes().click();
		Thread.sleep(2000);
	}

	// Export to Excel Prospect
	@Test(priority = 3)
	public void Export_To_Excel_Prospect() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getExporttoExcel().click();
		Thread.sleep(2000);
	}

	// Apply Filter for Dates & Project
	@Test(dataProvider = "ProspectProjectFilterData", priority = 4)
	public void Apply_Filter_Prospect(String daterange, String Daterange, String selectproject)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ProspectPage Prospect = new ProspectPage(driver);
		SelectfilterDatesPage Prodpectdates = new SelectfilterDatesPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getapplyfilter().click();
		Thread.sleep(1000);
		Prospect.getdaterange().click();
		Thread.sleep(1000);
		Prodpectdates.getSelectDateRange(daterange, Daterange);
		Thread.sleep(2000);
		Prospect.getselectproject(selectproject.trim());
		boolean flag = Prospect.NoPageFound();
		if (flag == false) {
			Prospect.getresetfilter().click();
		}
	}

	// Apply Filter for Dates
	@Test(dataProvider = "ProspectFilterDate", priority = 5)
	public void Apply_Filter_Dates_Prospect(String daterange, String Daterange) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		SelectfilterDatesPage Prodpectdates = new SelectfilterDatesPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(2000);
		Prospect.getapplyfilter().click();
		Thread.sleep(2000);
		Prospect.getdaterange().click();
		Thread.sleep(2000);
		Prodpectdates.getSelectDateRange(daterange, Daterange);
		Thread.sleep(2000);
		boolean flag = Prospect.NoPageFound();
		if (flag == false) {
			Prospect.getresetfilter().click();
		}
	}

	// Apply Filter Method for Project & Reset
	@Test(dataProvider = "ProspectProjectResetData", priority = 6)
	public void Apply_Filter_Project_Prospect(String selectproject) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getapplyfilter().click();
		Thread.sleep(1000);
		Prospect.getselectproject(selectproject);
		Thread.sleep(2000);
		try {
			WebElement NRF = driver.findElement(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']"));
			boolean flag = NRF.isDisplayed();
			if (!flag) {
				Prospect.getresetfilter().click();
			} else {
				Prospect.getresetfilter().click();
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	// Search Method for Prospect
	@Test(dataProvider = "ProspectSearchData", priority = 7)
	public void Search_Prospect(String Attende) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(2000);
		Prospect.getSearch().sendKeys(Attende.trim() + Keys.ENTER);
		Thread.sleep(2000);
		Prospect.getSearch().clear();
		Thread.sleep(2000);
		boolean flag = Prospect.NoPageFound();
		if (flag == false) {
		}
	}

	// Todays Follow up click,Search & Edit Method
	@Test(dataProvider = "ProspectSearchData1", priority = 8)
	public void Today_Follow_Up_Prospect(String visitorname) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.gettodayfollowup().click();
		Thread.sleep(1000);
		Prospect.getSearch().sendKeys(visitorname.trim() + Keys.ENTER);
		Thread.sleep(1000);
		boolean flag = Prospect.NoPageFound();
		if (flag == false) {
			Prospect.getEdit().click();
			Thread.sleep(1000);
			Prospect.getsave().click();
			Thread.sleep(1000);
		}
	}

	// Missing Follow up for click,Search & Edit Method
	@Test(dataProvider = "ProspectSearchData2", priority = 9)
	public void Missing_Follow_Up_Prospect(String visitorname) throws InterruptedException {
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getmissingfollowup().click();
		Thread.sleep(1000);
		Prospect.getSearch().sendKeys(visitorname.trim() + Keys.ENTER);
		Thread.sleep(1000);
		boolean flag = Prospect.NoPageFound();
		if (flag == false) {
			Prospect.getEditBtn().click();
			Thread.sleep(1000);
			Prospect.getsave().click();
			Thread.sleep(1000);
		}
	}

	// Add Prospect Test Mandatory Filed Validation
	@Test(dataProvider = "AddProspectTestMandatoryData", priority = 10)
	public void Add_Prospect_Test_Mandatory_Filed_Validation(String source) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getAddprospect().click();
		Thread.sleep(2000);
		Prospect.getSource(source.trim());
		Thread.sleep(1000);
		Prospect.getsave().click();
		Thread.sleep(2000);
		
		if (source.contains("Chanel Partner")) {
			WebElement ChanelPartnerName = driver
					.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[15]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(ChanelPartnerName.getText().trim(), "Chanel Partner Name is required.");
			
			WebElement ChanelPartnerContact = driver
					.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[16]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(ChanelPartnerContact.getText().trim(), "Chanel Partner's Contact is required.");

		} else if (source.contains("Other")) {
			WebElement ReferenceName = driver
					.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[15]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(ReferenceName.getText().trim(), "Reference Name is required.");
			
			WebElement ReferenceContact = driver
					.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[16]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(ReferenceContact.getText().trim(), "Reference's Contact is required.");
			
		} else {
		}
		
		WebElement Visitsite = driver
				.findElement(By.xpath("//span[normalize-space()='Visit Site/Project is required.']"));
		softAssert.assertEquals(Visitsite.getText(), "Visit Site/Project is required.");

		WebElement VisitorName = driver.findElement(By.xpath("//span[normalize-space()='Visitor Name is required.']"));
		softAssert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement Intime = driver.findElement(By.xpath("//span[normalize-space()='In Time is required.']"));
		softAssert.assertEquals(Intime.getText(), "In Time is required.");

		WebElement Outtime = driver.findElement(By.xpath("//span[normalize-space()='Out Time is required.']"));
		softAssert.assertEquals(Outtime.getText(), "Out Time is required.");

		WebElement Attedee = driver.findElement(By.xpath("//span[normalize-space()='Attendee is required.']"));
		softAssert.assertEquals(Attedee.getText(), "Attendee is required.");

		WebElement ContactNo = driver.findElement(By.xpath("//span[normalize-space()='Contact Number is required.']"));
		softAssert.assertEquals(ContactNo.getText(), "Contact Number is required.");
		softAssert.assertAll();
	}

	// Edit Prospect Test Mandatory Filed Validation
	@Test(dataProvider = "EditProspectTestMandatoryData", priority = 11)
	public void Edit_Prospect_Test_Mandatory_Filed_Validation(String visitorname, String source)
			throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getSearch().sendKeys(visitorname.trim() + Keys.ENTER);
		Thread.sleep(1000);
		Prospect.getProspectEditBtn().click();
		Thread.sleep(2000);

		Prospect.getvisitorname().click();
		int Vname = Prospect.getvisitorname().getAttribute("value").length();
		for (int i = -1; i < Vname; i++) {
			Prospect.getvisitorname().sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(1000);

		Prospect.getContactNo().click();
		int contactno = Prospect.getContactNo().getAttribute("value").length();
		for (int i = 0; i < contactno; i++) {
			Prospect.getContactNo().sendKeys(Keys.BACK_SPACE);
		}
		Prospect.getContactNo().sendKeys(Keys.TAB);
		Thread.sleep(1000);

		Prospect.getSource(source.trim());
		Thread.sleep(1000);
		if (source.contains("Chanel Partner")) {
			Prospect.getChannelPartnerName().click();
			Prospect.getChannelPartnerName().sendKeys(Keys.END);
			int b = Prospect.getChannelPartnerName().getAttribute("value").length();
			for (int i = 0; i < b; i++) {
				Prospect.getChannelPartnerName().sendKeys(Keys.BACK_SPACE);
			}
			Prospect.getChannelPartnerName().sendKeys(Keys.TAB);
			Thread.sleep(2000);

			Prospect.getChannelPartnerContact().click();
			Prospect.getChannelPartnerContact().sendKeys(Keys.END);
			int c = Prospect.getChannelPartnerContact().getAttribute("value").length();
			for (int i = 0; i < c; i++) {
				Prospect.getChannelPartnerContact().sendKeys(Keys.BACK_SPACE);
			}
			Prospect.getChannelPartnerContact().sendKeys(Keys.TAB);
			Thread.sleep(2000);

		} else if (source.contains("Other")) {
			Prospect.getReferenceName().click();
			Prospect.getReferenceName().sendKeys(Keys.END);
			int e = Prospect.getReferenceName().getAttribute("value").length();
			for (int i = 0; i < e; i++) {
				Prospect.getReferenceName().sendKeys(Keys.BACK_SPACE);
			}
			Prospect.getReferenceName().sendKeys(Keys.TAB);
			Thread.sleep(2000);

			Prospect.getReferenceContact().click();
			Prospect.getReferenceContact().sendKeys(Keys.END);
			int f = Prospect.getReferenceContact().getAttribute("value").length();
			for (int i = 0; i < f; i++) {
				Prospect.getReferenceContact().sendKeys(Keys.BACK_SPACE);
			}
			Prospect.getReferenceContact().sendKeys(Keys.TAB);
			Thread.sleep(2000);
		} else {
		}

		WebElement VisitorName = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[2]/mat-form-field/div[2]/div"));
		softAssert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement ContactNo = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[9]/mat-form-field/div[2]/div"));
		softAssert.assertEquals(ContactNo.getText(), "Contact Number is required.");
		softAssert.assertAll();
	}

	// Verify Add Inactive Attendee Prospect
	@Test(dataProvider = "AddInactiveAttendeeProspect", priority = 12)
	public void Verify_Add_Inactive_Attendee_Prospect(String Employeename, String Attendename)
			throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(1000);
		employee.getSearch().sendKeys(Employeename + Keys.ENTER);
		Thread.sleep(1000);
		employee.getEdit1().click();
		Thread.sleep(1000);
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getAddprospect().click();
		Thread.sleep(1000);
		Prospect.AddInactiveAttendeeProspect(Attendename);
		Thread.sleep(1000);
	}

	// Verify Add Active Attendee Prospect
	@Test(dataProvider = "AddActiveAttendeeProspect", priority = 13)
	public void Verify_Add_Active_Attendee_Prospect(String Employeename, String Attendename)
			throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(1000);
		employee.getactiveInactivebtn().click();
		Thread.sleep(1000);
		employee.getSearch().sendKeys(Employeename + Keys.ENTER);
		Thread.sleep(1000);
		employee.getEdit1().click();
		Thread.sleep(1000);
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(1000);
		Prospect.getAddprospect().click();
		Thread.sleep(1000);
		Prospect.AddActiveAttendeeProspect(Attendename);
		Thread.sleep(2000);

	}

	// Verify Edit Inactive Attendee Prospect
	@Test(dataProvider = "EditInactiveAttendeeProspect", priority = 14)
	public void Verify_Edit_Inactive_Attendee_Prospect(String Employeename, String Visitorname, String Attendename)
			throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(1000);
		employee.getSearch().sendKeys(Employeename + Keys.ENTER);
		Thread.sleep(1000);
		employee.getEdit().click();
		Thread.sleep(1000);
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();
		Thread.sleep(2000);

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(2000);
		Prospect.getSearch().sendKeys(Visitorname + Keys.ENTER);
		Thread.sleep(2000);
		Prospect.getProspectEditBtn().click();
		Thread.sleep(2000);
		Prospect.EditInactiveAttendeeProspect(Attendename);
		Thread.sleep(2000);
	}

	// Verify Edit Active Attendee Prospect
	@Test(dataProvider = "EditActiveAttendeeProspect", priority = 15)
	public void Verify_Edit_Active_Attendee_Prospect(String Employeename, String Visitorname, String Attendename)
			throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(1000);
		employee.getactiveInactivebtn().click();
		Thread.sleep(1000);
		employee.getSearch().sendKeys(Employeename + Keys.ENTER);
		Thread.sleep(1000);
		employee.getEdit().click();
		Thread.sleep(1000);
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();
		Thread.sleep(2000);

		ProspectPage Prospect = new ProspectPage(driver);
		Prospect.getprospect().click();
		Thread.sleep(2000);
		Prospect.getSearch().sendKeys(Visitorname + Keys.ENTER);
		Thread.sleep(2000);
		Prospect.getProspectEditBtn().click();
		Thread.sleep(2000);
		Prospect.EditActiveAttendeeProspect(Attendename);
		Thread.sleep(2000);
	}

	// Close the Driver
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	// DataProvider for Add Prospect
	@DataProvider
	public Object[][] ProspectAdddata() {
		return new Object[][] { { "Automation Project1", "Make Prot", "", "", "In Progress",
				"Nilesh Panchal", "9856214565", "Akash@mail.com", "Bopal Gam ,Ahmedabad", "Remarks", "3 BHK",
				"Chanel Partner", "Akash Patel 123", "9856234512", "Shaligram Software 123", "ops123",
				"50,00,000 - 75,00,000", "A", "Unit No - 105 (1st Floor)" },
			
				{ "Automation Project1", "Bill Great", "", "","In Progress", 
					"Nilesh Panchal", "9856214501",	"Akash@mail.com", "Bopal Gam ,Ahmedabad", "Remarks", "3BHK",
					"Other", "Akash Patel 123","9856234512", "Shaligram Software 123", "ops123",
						"50,00,000 - 75,00,000","B", "Unit No - 1 (1st Floor)" },
				
				{ "Automation Project1", "Adil Dan", "", "", "In Progress",
							"Nilesh Panchal", "9856214574","Akash@mail.com", "Bopal Gam ,Ahmedabad", "Remarks", "3BHK",
							"Walk-In", "Akash Patel 123","9856234512", "Shaligram Software 123", "ops123",
						"50,00,000 - 75,00,000","B", "Unit No - 10 (2nd Floor)" },
				
				{ "Automation Project1", "Jay Uso", "", "","In Progress",
							"Nilesh Panchal", "9856214532","Akash@mail.com", "Bopal Gam ,Ahmedabad", "Remarks", "3BHK",
							"Chanel Partner","Akash Patel 123", "9856234512", "Shaligram Software 123", "ops123",
						"50,00,000 - 75,00,000","B","Unit No - 2 (1st Floor)" }
		};
	}

	// DataProvider for Edit Prospect
	@DataProvider
	public Object[][] ProspectEditData() {
		return new Object[][] { { "Make Prot", "9876543210", "akash.new@mail.com", "New Address, Ahmedabad",
				"New Updated Remarks", "5BHK", "Chanel Partner", "Akash Patel 123 Test", "9856234000",
				"Shaligram Software 123 Test", "Completed" } };
	}
	
	// DataProvider for Delete Prospect Data
	@DataProvider
	public Object[][] DeleteProspectData() {
		return new Object[][] { { "Make Prot" }, { "Bill Great" }, { "Adil Dan" }, { "Jay Uso" } };
	}

	// DataProvider for Filter Project Dropdown
	@DataProvider
	public Object[][] ProspectProjectFilterData() {
		return new Object[][] { { "11/DEC/2024", "17/DEC/2025", "Automation Project1" } };
	}

	// DataProvider for Filter Prospect Filter Date Data
	@DataProvider
	public Object[][] ProspectFilterDate() {
		return new Object[][] { { "11/DEC/2024", "17/DEC/2025" } };
	}

	// Data Provider for Prospect Project Reset Data
	@DataProvider
	public Object[][] ProspectProjectResetData() {
		return new Object[][] { { "Automation Project1" } };
	}

	// DataProvider for Search Data
	@DataProvider
	public Object[][] ProspectSearchData() {
		return new Object[][] { { "Nilesh Panchal" } };
	}

	// DataProvider for Search Data
	@DataProvider
	public Object[][] ProspectSearchData1() {
		return new Object[][] { { "Mahesh Patel123" } };
	}

	// DataProvider for Search Data
	@DataProvider
	public Object[][] ProspectSearchData2() {
		return new Object[][] { { "Nilesh Panchal123" } };
	}

	// DataProvider for Add Prospect Test Mandatory Data
		@DataProvider
		public Object[][] AddProspectTestMandatoryData() {
			return new Object[][] { { "Chanel Partner" } };
		}
		
	// DataProvider for Edit Prospect Test Mandatory Data
	@DataProvider
	public Object[][] EditProspectTestMandatoryData() {
		return new Object[][] { { "Make Prot", "Chanel Partner" } };
	}

	// DataProvider for Add Inactive Attendee Prospect
	@DataProvider
	public Object[][] AddInactiveAttendeeProspect() {
		return new Object[][] { { "AutomationEmpEdit Test", "AutomationEmpEdit Test" } };
	}

	// DataProvider for Add Active Attendee Prospect
	@DataProvider
	public Object[][] AddActiveAttendeeProspect() {
		return new Object[][] { { "AutomationEmpEdit Test", "AutomationEmpEdit Test" } };
	}

	// DataProvider for Edit Inactive Attendee Prospect
	@DataProvider
	public Object[][] EditInactiveAttendeeProspect() {
		return new Object[][] { { "AutomationEmpView Test", "Mahesh Patel", "AutomationEmpView Test" } };
	}

	// DataProvider for Edit Active Attendee Prospect
	@DataProvider
	public Object[][] EditActiveAttendeeProspect() {
		return new Object[][] { { "AutomationEmpView Test", "Mahesh Patel", "AutomationEmpView Test" } };
	}
}