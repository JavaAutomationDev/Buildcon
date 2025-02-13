package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.EmployeePage;
import pageObjects.InquiryPage;
import pageObjects.InquiryResponsepage;
import pageObjects.Inquirycommunicationmodepage;
import pageObjects.Inquirystatuspage;

import pageObjects.ProjectPage;
import pageObjects.SelectfilterDatesPage;
import resources.base;

public class InquiryTest extends base {

	// Add Inquiry
	@Test(dataProvider = "InquiryAdddata", priority = 1)
	public void Add_Inquiry(String siteproject, String visitorname, String NextfollowUpDT, String status,
			String Attende, String ContactNo, String Email, String Address, String Remarks,
			String Requirement, String source, String channelpartnerORreferencename,
			String channelpartnerORreferencecontact, String channelpartnerfirmname, String intrest, String approxbudget)
					throws InterruptedException, IOException {

		SoftAssert softAssert = new SoftAssert();
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(2000);

		softAssert.assertFalse(siteproject.isEmpty(), "Visit Site/Project is required.");
		Inquiry.getsiteproject(siteproject);
		Thread.sleep(1000);

		Inquiry.getvisitorname().sendKeys(visitorname);
		softAssert.assertFalse(visitorname.isEmpty(), "Visitor Name is required.");
		// Visitor Name Text Data Validation
		String valid_string = validateText(visitorname, "VisitorName", 5, 30);
		String valid_visitorname = valid_string;
		System.out.println(valid_visitorname);
		Thread.sleep(1000);

		Inquiry.getIntime().click(); // click on InTime Required fields
		Inquiry.getOk().click(); // Click on Ok time
		Thread.sleep(2000);

		Inquiry.getouttime().click(); // Click on OutTime Required fields
		Inquiry.getOk().click(); // Click on Ok time
		Thread.sleep(2000);

		Inquiry.getNextfollowUpDT().sendKeys(NextfollowUpDT);
		Thread.sleep(1000);

		Inquiry.getstatus(status);
		Thread.sleep(1000);

		softAssert.assertFalse(Attende.isEmpty(), "Attendee is required.");
		Inquiry.getAttendee(Attende);
		Thread.sleep(1000);

		Inquiry.getContactNo().sendKeys(ContactNo);
		// ContactNo Number Validation
		valid_string = valid_number(ContactNo, "InquiryContactNo");
		String valid_contactno = valid_string;
		System.out.println(valid_contactno);
		softAssert.assertFalse(ContactNo.isEmpty(), "Contact Number is required.");
		Thread.sleep(1000);

		Inquiry.getEmail().sendKeys(Email);
		// Email Validation
		valid_string = valid_EMail(Email, "InquiryEmail");
		String valid_email = valid_string;
		System.out.println(valid_email);
		Thread.sleep(1000);

		Inquiry.getAddress().sendKeys(Address);
		// Address Alphanumeric Validation
		valid_string = valid_alphanum(Address, "InquiryAddress", 10);
		String valid_address = valid_string;
		System.out.println(valid_address);
		Thread.sleep(1000);

		Inquiry.getRemarks().sendKeys(Remarks);
		// Remarks Text Data Validation
		valid_string = validateText(Remarks, "Remarks", 5, 10);
		String valid_remarks = valid_string;
		System.out.println(valid_remarks);
		Thread.sleep(1000);

		Inquiry.getrequirement().sendKeys(Requirement);
		Thread.sleep(1000);

		Inquiry.getSource(source.trim());
		if (source.contains("Chanel Partner")) {
			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Chanel Partner Name is required.");
			Inquiry.getChannelPartnerName().sendKeys(channelpartnerORreferencename);
			// Channel Partner Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "channel partner name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"channel partner name is a Valid Alpha-Numeric is a valid Maxlenght");

			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Chanel Partner's Contact is required.");
			Inquiry.getChannelPartnerContact().sendKeys(channelpartnerORreferencecontact);
			// channel partner OR reference contact Number Validation
			valid_string = valid_number(channelpartnerORreferencecontact, "Channel Partner Contact");
			String valid_channelpartnerORreferencecontact = valid_string;
			System.out.println(valid_channelpartnerORreferencecontact);
			softAssert.assertEquals(valid_channelpartnerORreferencecontact,
					"Channel Partner Contact is a Valid Number");

			Inquiry.getChannelPartnerFirmName().sendKeys(channelpartnerfirmname);
			// Channel Partner's Firm Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerfirmname, "Channel Partner Firm Name", 50);
			String valid_channelpartnerfirmname = valid_string;
			System.out.println(valid_channelpartnerfirmname);
			softAssert.assertEquals(valid_channelpartnerfirmname,
					"Channel Partner Firm Name is a Valid Alpha-Numeric is a valid Maxlenght");

		} else if (source.contains("Other")) {
			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Reference Name is required.");
			Inquiry.getReferenceName().sendKeys(channelpartnerORreferencename);
			// Channel Partner Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "Reference Name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"Reference Name is a Valid Alpha-Numeric is a valid Maxlenght");

			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Reference's Contact is required.");
			Inquiry.getReferenceContact().sendKeys(channelpartnerORreferencecontact);
			// channel partner OR reference contact Number Validation
			valid_string = valid_number(channelpartnerORreferencecontact, "Reference Contact");
			String valid_channelpartnerORreferencecontact = valid_string;
			System.out.println(valid_channelpartnerORreferencecontact);
			softAssert.assertEquals(valid_channelpartnerORreferencecontact, "Reference Contact is a Valid Number");

		} else {
			Inquiry.getReferenceName().sendKeys(channelpartnerORreferencename);
			// Channel Partner Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "Reference Name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"Reference Name is a Valid Alpha-Numeric is a valid Maxlenght");
		}
		Thread.sleep(1000);

		Inquiry.getIntrest(intrest);
		Thread.sleep(1000);

		Inquiry.getApproxBudget(approxbudget);
		Thread.sleep(2000);

		Inquiry.getsave().click();
		Thread.sleep(2000);

		softAssert.assertEquals(valid_visitorname,
				"VisitorName is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_contactno, "InquiryContactNo is a Valid Number");
		softAssert.assertEquals(valid_address, "InquiryAddress is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_email, "InquiryEmail is a Valid EMail");
		softAssert.assertEquals(valid_remarks, "Remarks is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertAll();
	}

	// Editing an existing Inquiry using Data Provider
	@Test(dataProvider = "InquiryEditData", priority = 2)
	public void Edit_Inquiry(String Projectname, String siteproject, String newvisitorname, String newStatus,
			String newContactNo, String newEmail, String newAddress, String newRemarks, String newRequirement,
			String source, String channelpartnerORreferencename, String channelpartnerORreferencecontact,
			String channelpartnerfirmname) throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getSearchInquiry().sendKeys(Projectname + Keys.ENTER);
		Thread.sleep(1000);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.getsiteproject(siteproject.trim());

		Thread.sleep(2000);
		Inquiry.getvisitorname().clear();
		Inquiry.getvisitorname().sendKeys(newvisitorname);
		// Visitor Name Text Data Validation
		String valid_string = validateText(newvisitorname, "VisitorName", 5, 30);
		String valid_visitorname = valid_string;
		System.out.println(valid_visitorname);
		softAssert.assertFalse(newvisitorname.isEmpty(), "Visitor Name is required.");

		Inquiry.getstatus(newStatus.trim());
		Thread.sleep(1000);

		Inquiry.getContactNo().clear();
		Inquiry.getContactNo().sendKeys(newContactNo);
		// ContactNo Number Validation
		valid_string = valid_number(newContactNo, "InquiryContactNo");
		String valid_contactno = valid_string;
		System.out.println(valid_contactno);
		softAssert.assertFalse(newContactNo.isEmpty(), "Contact Number is required.");

		Inquiry.getEmail().clear();
		Inquiry.getEmail().sendKeys(newEmail);
		// Email Validation
		valid_string = valid_EMail(newEmail, "InquiryEmail");
		String valid_email = valid_string;
		System.out.println(valid_email);

		Inquiry.getAddress().clear();
		Inquiry.getAddress().sendKeys(newAddress);
		// Adress Alphanumeric Validation
		valid_string = valid_alphanum(newAddress, "InquiryAddress", 10);
		String valid_address = valid_string;
		System.out.println(valid_address);

		Inquiry.getRemarks().clear();
		Inquiry.getRemarks().sendKeys(newRemarks);
		// Remarks Text Data Validation
		valid_string = validateText(newRemarks, "Remarks", 5, 10);
		String valid_remarks = valid_string;
		System.out.println(valid_remarks);

		Inquiry.getrequirement().clear();
		Inquiry.getrequirement().sendKeys(newRequirement);
		Thread.sleep(1000);

		Inquiry.getSource(source.trim());
		Thread.sleep(1000);
		if (source.contains("Chanel Partner")) {
			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Chanel Partner Name is required.");
			Inquiry.getChannelPartnerName().clear();
			Inquiry.getChannelPartnerName().sendKeys(channelpartnerORreferencename);
			// Channel Partner Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "channel partner name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"channel partner name is a Valid Alpha-Numeric is a valid Maxlenght");

			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Chanel Partner's Contact is required.");
			Inquiry.getChannelPartnerContact().clear();
			Inquiry.getChannelPartnerContact().sendKeys(channelpartnerORreferencecontact);
			// Channel Partner Contact Number Validation
			valid_string = valid_number(channelpartnerORreferencecontact, "Channel Partner Contact");
			String valid_channelpartnerORreferencecontact = valid_string;
			System.out.println(valid_channelpartnerORreferencecontact);
			softAssert.assertEquals(valid_channelpartnerORreferencecontact,
					"Channel Partner Contact is a Valid Number");

			Inquiry.getChannelPartnerFirmName().clear();
			Inquiry.getChannelPartnerFirmName().sendKeys(channelpartnerfirmname);
			// Channel Partner's Firm Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerfirmname, "Channel Partner Firm Name", 50);
			String valid_channelpartnerfirmname = valid_string;
			System.out.println(valid_channelpartnerfirmname);
			softAssert.assertEquals(valid_channelpartnerfirmname,
					"Channel Partner Firm Name is a Valid Alpha-Numeric is a valid Maxlenght");

		} else if (source.contains("Other")) {
			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Reference Name is required.");
			Inquiry.getReferenceName().clear();
			Inquiry.getReferenceName().sendKeys(channelpartnerORreferencename);
			// Reference Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "Reference Name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"Reference Name is a Valid Alpha-Numeric is not a valid Maxlenght");

			softAssert.assertFalse(channelpartnerORreferencename.isEmpty(), "Reference's Contact is required.");
			Inquiry.getReferenceContact().clear();
			Inquiry.getReferenceContact().sendKeys(channelpartnerORreferencecontact);
			// Reference Contact Number Validation
			valid_string = valid_number(channelpartnerORreferencecontact, "Reference Contact");
			String valid_channelpartnerORreferencecontact = valid_string;
			System.out.println(valid_channelpartnerORreferencecontact);
			softAssert.assertEquals(valid_channelpartnerORreferencecontact, "Reference Contact is a Valid Number");

		} else {
			Inquiry.getReferenceName().clear();
			Inquiry.getReferenceName().sendKeys(channelpartnerORreferencename);
			// Reference Name Alphanumeric Validation
			valid_string = valid_alphanum(channelpartnerORreferencename, "Reference Name", 50);
			String valid_channelpartnerORreferencename = valid_string;
			System.out.println(valid_channelpartnerORreferencename);
			softAssert.assertEquals(valid_channelpartnerORreferencename,
					"Reference Name is a Valid Alpha-Numeric is not a valid Maxlenght");
		}

		Inquiry.getUpdate().click();
		Thread.sleep(2000);

		softAssert.assertEquals(valid_visitorname,"VisitorName is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_email, "InquiryEmail is a Valid EMail");
		softAssert.assertEquals(valid_contactno, "InquiryContactNo is a Valid Number");
		softAssert.assertEquals(valid_address, "InquiryAddress is not a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_remarks,"Remarks is a Valid text - is a valid Minlenght - is not a valid Maxlenght");
		softAssert.assertAll();
	}

	// Delete Inquiry
	@Test(dataProvider = "InquiryDeleteData", priority = 29)
	public void Delete_Inquiry(String Visitiorname) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getSearchInquiry().sendKeys(Visitiorname + Keys.ENTER);
		Thread.sleep(3000);
		Inquiry.getDelete().click();
		Thread.sleep(3000);
		Inquiry.getClickYes().click();
		Thread.sleep(3000);
	}

	// Export To Excel Inquiry
	@Test(priority = 3)
	public void Export_To_Excel_Inquiry() throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getExporttoExcel().click();
		Thread.sleep(2000);
	}

	// Apply Filter for Dates & Project
	@Test(dataProvider = "InquiryprojectfilterData", priority = 4)
	public void Apply_Filter_Inquiry(String daterange, String Daterange, String selectproject)
			throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		SelectfilterDatesPage Inquirydates = new SelectfilterDatesPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getapplyfilter().click();
		Thread.sleep(1000);
		Inquiry.getdaterange().click();
		Thread.sleep(1000);
		Inquirydates.getSelectDateRange(daterange, Daterange);
		Thread.sleep(1000);
		Inquiry.getselectproject(selectproject.trim());
		Thread.sleep(2000);
		Inquiry.getresetfilter().click();
		Thread.sleep(2000);
	}

	// Apply Filter with Date
	@Test(dataProvider = "FilterDatesData", priority = 5)
	public void Apply_Filter_Dates_Inquiry(String daterange, String Daterange) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		SelectfilterDatesPage Inquirydates = new SelectfilterDatesPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getapplyfilter().click();
		Thread.sleep(1000);
		Inquiry.getdaterange().click();
		Thread.sleep(1000);
		Inquirydates.getSelectDateRange(daterange, Daterange);
		Thread.sleep(2000);
		Inquiry.getresetfilter().click();
		Thread.sleep(2000);
	}

	// Apply Filter with Project
	@Test(dataProvider = "InquirySelectProject", priority = 6)
	public void Apply_Filter_Project_Inquiry(String selectproject) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getapplyfilter().click();
		Thread.sleep(1000);
		Inquiry.getselectproject(selectproject.trim());
		Thread.sleep(2000);
		Inquiry.getresetfilter().click();
	}

	// Search Inquiry
	@Test(dataProvider = "InquirySearchData", priority = 7)
	public void Search_Inquiry(String Name) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getSearchInquiry().sendKeys(Name.trim() + Keys.ENTER);
	}

	// Todays Follow up Click,Search & Edit
	@Test(dataProvider = "TodaysFollowUpData", priority = 8)
	public void Today_Follow_Inquiry(String visitorname) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.gettodayfollowup().click();
		Thread.sleep(2000);
		Inquiry.getSearchInquiry().sendKeys(visitorname.trim() + Keys.ENTER);
		boolean flag = Inquiry.NoPageFound();
		if (flag == false) {
		}
	}

	// Missing Follow up for click,Search & Edit
	@Test(dataProvider = "MissingFollowUpData", priority = 9)
	public void Missing_Follow_Inquiry(String visitorname, String followup) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getSearchInquiry().sendKeys(visitorname.trim() + Keys.ENTER);
		Thread.sleep(2000);
		boolean flag = Inquiry.NoPageFound();
		if (flag == false) {
			Inquiry.getMissingEditbtn().click();
			Thread.sleep(2000);
			Inquiry.getMissingfollowupcalender().click();
			Thread.sleep(2000);
			Inquiry.getMissinnextfollowupdate(followup);
			Thread.sleep(2000);
			Inquiry.getUpdate().click();
			Thread.sleep(2000);
		}
	}

	// Add To Prospect Inquiry
	@Test(dataProvider = "InquiryaddprospectData", priority = 10)
	public void Add_Prospect_Inquiry(String Attende, String unitD, String Selectflat) throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getSearchInquiry().sendKeys(Attende.trim() + Keys.ENTER);
		Thread.sleep(2000);
		Inquiry.getAddprospect().click();
		Thread.sleep(2000);
		Inquiry.getunitdropdown(unitD.trim());
		Thread.sleep(2000);
		Inquiry.getSelectFlat(Selectflat.trim());
		Thread.sleep(2000);
		Inquiry.getClickYes().click();
		Thread.sleep(2000);
	}

	// Add Inquiry Test Mandatory Field Validation
	@Test(dataProvider = "AddInquiryMandatoryData",priority = 11)
	public void Add_Inquiry_Test_Mandatory_Field_Validation(String source) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(1000);
		Inquiry.getSource(source.trim());
		Thread.sleep(1000);
		Inquiry.getsave().click();
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

		WebElement Visitsiteproject = driver
				.findElement(By.xpath("//span[normalize-space()='Visit Site/Project is required.']"));
		softAssert.assertEquals(Visitsiteproject.getText().trim(), "Visit Site/Project is required.");

		WebElement VisitorName = driver.findElement(By.xpath("//span[normalize-space()='Visitor Name is required.']"));
		softAssert.assertEquals(VisitorName.getText().trim(), "Visitor Name is required.");

		WebElement Intime = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[4]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Intime.getText().trim(), "In Time is required.");

		WebElement Outtime = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[1]/div[5]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Outtime.getText().trim(), "Out Time is required.");

		WebElement Attedee = driver.findElement(By.xpath("//span[normalize-space()='Attendee is required.']"));
		softAssert.assertEquals(Attedee.getText().trim(), "Attendee is required.");

		WebElement ContactNo = driver.findElement(By.xpath("//span[normalize-space()='Contact Number is required.']"));
		softAssert.assertEquals(ContactNo.getText().trim(), "Contact Number is required.");

		softAssert.assertAll();

	}

	// Edit Inquiry Test Mandatory Field Validation
	@Test(dataProvider = "EditInquiryMandatoryData", priority = 12)
	public void Edit_Inquiry_Test_Mandatory_Field_Validation(String Attende, String source)
			throws InterruptedException {
		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getSearchInquiry().sendKeys(Attende.trim() + Keys.ENTER);
		Thread.sleep(2000);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.getvisitorname().click();
		Inquiry.getvisitorname().sendKeys(Keys.END);
		int a = Inquiry.getvisitorname().getAttribute("value").length();
		for (int i = 0; i < a; i++) {
			Inquiry.getvisitorname().sendKeys(Keys.BACK_SPACE);
		}
		Inquiry.getvisitorname().sendKeys(Keys.TAB);
		Thread.sleep(2000);

		Inquiry.getIntime().click();
		Thread.sleep(2000);
		Inquiry.getOk().click();
		int intime = Inquiry.getIntime().getAttribute("value").length();
		for (int i = 0; i < intime; i++) {
			Inquiry.getIntime().sendKeys(Keys.BACK_SPACE);
		}
		Inquiry.getIntime().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		Inquiry.getBlankoutTime().sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		Inquiry.getBlankoutTime().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		Inquiry.getContactNo().click();
		int contactno = Inquiry.getContactNo().getAttribute("value").length();
		for (int i = 1; i <= contactno; i++) {
			Inquiry.getContactNo().sendKeys(Keys.BACK_SPACE);
		}
		Inquiry.getContactNo().sendKeys(Keys.TAB);
		Thread.sleep(2000);

		Inquiry.getSource(source.trim());
		Thread.sleep(1000);
		if (source.contains("Chanel Partner")) {
			Inquiry.getChannelPartnerName().click();
			Inquiry.getChannelPartnerName().sendKeys(Keys.END);
			int b = Inquiry.getChannelPartnerName().getAttribute("value").length();
			for (int i = 0; i < b; i++) {
				Inquiry.getChannelPartnerName().sendKeys(Keys.BACK_SPACE);
			}
			Inquiry.getChannelPartnerName().sendKeys(Keys.TAB);
			Thread.sleep(2000);

			Inquiry.getChannelPartnerContact().click();
			Inquiry.getChannelPartnerContact().sendKeys(Keys.END);
			int c = Inquiry.getChannelPartnerContact().getAttribute("value").length();
			for (int i = 0; i < c; i++) {
				Inquiry.getChannelPartnerContact().sendKeys(Keys.BACK_SPACE);
			}
			Inquiry.getChannelPartnerContact().sendKeys(Keys.TAB);
			Thread.sleep(2000);

		} else if (source.contains("Other")) {
			Inquiry.getReferenceName().click();
			Inquiry.getReferenceName().sendKeys(Keys.END);
			int e = Inquiry.getReferenceName().getAttribute("value").length();
			for (int i = 0; i < e; i++) {
				Inquiry.getReferenceName().sendKeys(Keys.BACK_SPACE);
			}
			Inquiry.getReferenceName().sendKeys(Keys.TAB);
			Thread.sleep(2000);

			Inquiry.getReferenceContact().click();
			Inquiry.getReferenceContact().sendKeys(Keys.END);
			int f = Inquiry.getReferenceContact().getAttribute("value").length();
			for (int i = 0; i < f; i++) {
				Inquiry.getReferenceContact().sendKeys(Keys.BACK_SPACE);
			}
			Inquiry.getReferenceContact().sendKeys(Keys.TAB);
			Thread.sleep(2000);
		} else {
		}
		Inquiry.getupdatebutton().click();
		Thread.sleep(2000);

		SoftAssert softAssert = new SoftAssert();
		WebElement VisitorName = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[2]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(VisitorName.getText(), "Visitor Name is required.");

		WebElement Intime = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[4]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Intime.getText(), "In Time is required.");

		WebElement Outtime = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[5]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Outtime.getText(), "Out Time is required.");

		WebElement ContactNo = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[9]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(ContactNo.getText(), "Contact Number is required.");

		softAssert.assertAll();
	}

	// Verify Add Inactive Attendee Inquiry
	@Test(dataProvider = "AddInactiveAttendee", priority = 13)
	public void Verify_Add_Inactive_Attendee_Inquiry(String employeename, String Attendee) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(1000);
		employee.getSearch().sendKeys(employeename + Keys.ENTER);
		Thread.sleep(1000);
		employee.getEdit().click();
		Thread.sleep(1000);
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(2000);
		Inquiry.AddInactiveAttendee(Attendee);
	}

	// Verify Add Active Attendee Inquiry
	@Test(dataProvider = "AddActiveAttendee", priority = 14)
	public void Verify_Add_Active_Attendee_Inquiry(String employeename, String Attendee) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(1000);
		employee.getactiveInactivebtn().click();
		Thread.sleep(1000);
		employee.getSearch().sendKeys(employeename + Keys.ENTER);
		employee.getEdit().click();
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(1000);
		Inquiry.AddActiveAttendee(Attendee);
	}

	// Verify Edit Inactive Attendee Inquiry
	@Test(dataProvider = "EditInactiveAttendee", priority = 15)
	public void Verify_Edit_Inactive_Attendee_Inquiry(String employeename, String Attendee)
			throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(2000);
		employee.getSearch().sendKeys(employeename + Keys.ENTER);
		Thread.sleep(2000);
		employee.getEdit().click();
		Thread.sleep(2000);
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.EditInactiveAttendee(Attendee);
	}

	// Verify Edit Active Attendee Inquiry
	@Test(dataProvider = "EditActiveAttendee", priority = 16)
	public void Verify_Edit_Active_Attendee_Inquiry(String employeename, String Attendee) throws InterruptedException {
		EmployeePage employee = new EmployeePage(driver);
		employee.getEmployee().click();
		Thread.sleep(2000);
		employee.getactiveInactivebtn().click();
		Thread.sleep(1000);
		employee.getSearch().sendKeys(employeename + Keys.ENTER);
		Thread.sleep(2000);
		employee.getEdit().click();
		Thread.sleep(2000);
		employee.getActiveEmployee().click();
		Thread.sleep(2000);
		employee.Nextbtn().click();
		Thread.sleep(2000);
		employee.getUpdate().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(2000);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.EditInactiveAttendee(Attendee);
	}

	// Active Inactive Inquiry Status
	// Verify Add Inactive Inquiry Status
	@Test(dataProvider = "AddInactiveInquiryStatus", priority = 17)
	public void Verify_Add_Inactive_Inquiry_Status(String Statusname, String Name) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Thread.sleep(1000);
		Inquirystatus.getInquirystatusclick().click();
		Thread.sleep(1000);
		Inquirystatus.getInquirystatussearched().sendKeys(Statusname + Keys.ENTER);
		Thread.sleep(1000);
		Inquirystatus.getEditInquirystatus().click();
		Thread.sleep(2000);
		Inquirystatus.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(1000);
		Inquiry.AddInactiveInquiryStatus(Name);
	}

	// Verify Add Active Inquiry Status
	@Test(dataProvider = "AddActiveInquiryStatus", priority = 18)
	public void Verify_Add_Active_Inquiry_Status(String Statusname, String Name) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Thread.sleep(1000);
		Inquirystatus.getInquirystatusclick().click();
		Thread.sleep(1000);
		Inquirystatus.getInquirystatussearched().sendKeys(Statusname + Keys.ENTER);
		Thread.sleep(1000);
		Inquirystatus.getEditInquirystatus().click();
		Thread.sleep(2000);
		Inquirystatus.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(1000);
		Inquiry.AddActiveInquiryStatus(Name);
	}

	// Verify Edit Inactive Inquiry Status
	@Test(dataProvider = "EditInactiveInquiryStatus", priority = 19)
	public void Verify_Edit_Inactive_Inquiry_Status(String Statusname, String Name) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Thread.sleep(1000);
		Inquirystatus.getInquirystatusclick().click();
		Thread.sleep(1000);
		Inquirystatus.getInquirystatussearched().sendKeys(Statusname + Keys.ENTER);
		Thread.sleep(1000);
		Inquirystatus.getEditInquirystatus().click();
		Thread.sleep(2000);
		Inquirystatus.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getEdit();
		Thread.sleep(1000);
		Inquiry.EditInactiveInquiryStatus(Name);
	}

	// Verify Edit Active Inquiry Status
	@Test(dataProvider = "EditActiveInquiryStatus", priority = 20)
	public void Verify_Edit_Active_Inquiry_Status(String Statusname, String Name) throws InterruptedException {
		Inquirystatuspage Inquirystatus = new Inquirystatuspage(driver);
		Inquirystatus.getconfiguration().click();
		Thread.sleep(1000);
		Inquirystatus.getInquirystatusclick().click();
		Thread.sleep(1000);
		Inquirystatus.getInquirystatussearched().sendKeys(Statusname + Keys.ENTER);
		Thread.sleep(1000);
		Inquirystatus.getEditInquirystatus().click();
		Thread.sleep(2000);
		Inquirystatus.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquirystatus.getEditInquirystatussave().click();

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getEdit();
		Thread.sleep(1000);
		Inquiry.EditActiveInquiryStatus(Name);
	}

	// Inquiry Response Type
	// Verify Edit Inactive Inquiry Response Type
	@Test(dataProvider = "EditInactiveInquiryResponseType", priority = 21)
	public void Verify_Edit_Inactive_Inquiry_Response_Type(String responsetype, String Name)
			throws InterruptedException {
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getInquiryresponsesearched().sendKeys(responsetype + Keys.ENTER);
		Inquiryresponse.getEditinquiryresponsetype().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquiryresponse.getEditinquiryresponsesave().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getMissingFollowUpEditBtn().click();
		Thread.sleep(1000);
		Inquiry.getFollowUpDetails().click();
		Thread.sleep(1000);
		Inquiry.getAddFollowDetails().click();
		Thread.sleep(1000);
		Inquiry.EditInactiveInquiryResponseType(Name);
	}

	// Verify Edit Active Inquiry Response Type
	@Test(dataProvider = "EditActiveInquiryResponseType", priority = 22)
	public void Verify_Edit_Active_Inquiry_Resposne_Type(String responsetype, String Name) throws InterruptedException {
		InquiryResponsepage Inquiryresponse = new InquiryResponsepage(driver);
		Inquiryresponse.getconfiguration().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryResponsepageclick().click();
		Inquiryresponse.getInquiryresponsesearched().sendKeys(responsetype + Keys.ENTER);
		Inquiryresponse.getEditinquiryresponsetype().click();
		Thread.sleep(2000);
		Inquiryresponse.getInquiryActiveInactive().click();
		Thread.sleep(2000);
		Inquiryresponse.getEditinquiryresponsesave().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getMissingFollowUpEditBtn().click();
		Thread.sleep(1000);
		Inquiry.getFollowUpDetails().click();
		Thread.sleep(1000);
		Inquiry.getAddFollowDetails().click();
		Thread.sleep(1000);
		Inquiry.EditActiveInquiryResponseType(Name);
	}

	// Inquiry Communcation mode
	// Verify Edit Inactive Inquiry Communcation mode
	@Test(dataProvider = "EditInactiveInquiryCommuncation", priority = 23)
	public void Verify_Edit_Inactive_Inquiry_Communcation_Mode(String Communcationtype, String Name)
			throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Thread.sleep(1000);
		Communication.getInquirycommunicationmodepageclick().click();
		Thread.sleep(1000);
		Communication.getsearchinquirycommunication().sendKeys(Communcationtype + Keys.ENTER);
		Thread.sleep(1000);
		Communication.getEditinquirycommunicationrow().click();
		Thread.sleep(2000);
		Communication.getActiveInactive().click();
		Thread.sleep(2000);
		Communication.geteditsavebuttoninquirycommunication().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getMissingFollowUpEditBtn().click();
		Thread.sleep(1000);
		Inquiry.getFollowUpDetails().click();
		Thread.sleep(1000);
		Inquiry.getAddFollowDetails().click();
		Thread.sleep(1000);
		Inquiry.EditInactiveInquiryCommuncation(Name);
	}

	// Verify Edit Active Inquiry Communcation mode
	@Test(dataProvider = "EditActiveInquiryCommuncation", priority = 24)
	public void Verify_Edit_Active_Inquiry_Communcation_Mode(String Communcationtype, String Name)
			throws InterruptedException {
		Inquirycommunicationmodepage Communication = new Inquirycommunicationmodepage(driver);
		Communication.getconfiguration().click();
		Thread.sleep(1000);
		Communication.getInquirycommunicationmodepageclick().click();
		Thread.sleep(1000);
		Communication.getsearchinquirycommunication().sendKeys(Communcationtype + Keys.ENTER);
		Thread.sleep(1000);
		Communication.getEditinquirycommunicationrow().click();
		Thread.sleep(2000);
		Communication.getActiveInactive().click();
		Thread.sleep(2000);
		Communication.geteditsavebuttoninquirycommunication().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getmissingfollowup().click();
		Thread.sleep(2000);
		Inquiry.getMissingFollowUpEditBtn().click();
		Thread.sleep(1000);
		Inquiry.getFollowUpDetails().click();
		Thread.sleep(1000);
		Inquiry.getAddFollowDetails().click();
		Thread.sleep(1000);
		Inquiry.EditActiveInquiryCommuncation(Name);
	}

	// Add Inquiry Project Dropdown
	// Verify Add Inactive Project
	@Test(dataProvider = "AddInactiveProjectData", priority = 25)
	public void Verify_Add_Inactive_Project(String projectname, String Name) throws InterruptedException {
		ProjectPage Project = new ProjectPage(driver);
		Project.getproject().click();
		Thread.sleep(1000);
		Project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		Project.getActiveproject().click();
		Thread.sleep(2000);
		Project.getClickYes().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(2000);
		Inquiry.AddInactiveProjectData(Name);
		Thread.sleep(2000);
	}

	// Verify Add Active Project
	@Test(dataProvider = "AddActiveProjectData", priority = 26)
	public void Verify_Add_Active_Project(String projectname, String Name) throws InterruptedException {
		ProjectPage Project = new ProjectPage(driver);
		Project.getproject().click();
		Thread.sleep(1000);
		Project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		Project.getActiveproject().click();
		Thread.sleep(2000);
		Project.getClickYes().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getaddInquiry().click();
		Thread.sleep(2000);
		Inquiry.AddActiveProjectData(Name);
		Thread.sleep(2000);
	}

	// Edit Inquiry Project Dropdown
	// Verify Edit Inactive Project
	@Test(dataProvider = "EditInactiveProjectData", priority = 27)
	public void Verify_Edit_Inactive_Project(String projectname, String Projectname, String Name)
			throws InterruptedException {
		ProjectPage Project = new ProjectPage(driver);
		Project.getproject().click();
		Thread.sleep(1000);
		Project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		Project.getActiveproject().click();
		Thread.sleep(2000);
		Project.getClickYes().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Inquiry.getSearchInquiry().sendKeys(Projectname + Keys.ENTER);
		Thread.sleep(1000);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.EditInactiveProjectData(Name);
		Thread.sleep(2000);
	}

	// Verify Edit Active Project
	@Test(dataProvider = "EditActiveProjectData", priority = 28)
	public void Verify_Edit_Active_Project(String projectname, String Projectname, String Name)
			throws InterruptedException {
		ProjectPage Project = new ProjectPage(driver);

		Project.getproject().click();
		Project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		Project.getActiveproject().click();
		Thread.sleep(2000);
		Project.getClickYes().click();
		Thread.sleep(2000);

		InquiryPage Inquiry = new InquiryPage(driver);
		Inquiry.getInquiry().click();
		Thread.sleep(1000);
		Inquiry.getSearchInquiry().sendKeys(Projectname + Keys.ENTER);
		Thread.sleep(2000);
		Inquiry.getEdit();
		Thread.sleep(2000);
		Inquiry.EditActiveProjectData(Name);
		Thread.sleep(2000);
	}

	// Close the driver
	@AfterMethod
	public void teardown() {
		base.failedElement = null;
		driver.close();
	}

	// DataProvider for Add Inquiry
	@DataProvider
	public Object[][] InquiryAdddata() {
		return new Object[][] {
			{ "Automation Project1", "Joan Cena", "", "In Progress"," Nilesh Panchal", "9825630021",
				"nilesh@gmail.com", "Shreenand Nagar, Part 4, Vejalpur, Ahmedabad", "Remarks", "Requirement",
				"Chanel Partner", "Akash Patel 123", "9856234512", "Shaligram Software 123", "ops123",
			"50,00,000 - 75,00,000" },

			{ "Automation Project2", "Roman Raign", "", "In Progress", " Nilesh Panchal",
				"9825630021", "nilesh@gmail.com", "Shreenand Nagar, Part 4, Vejalpur, Ahmedabad", "Remarks",
				"Requirement", "Other", "Akash Patel 123", "9856234512", "Shaligram Software 123", "addprop22",
			"50,00,000 - 75,00,000" },

			{ "Automation Project3", "Undertekan", "", "In Progress"," Nilesh Panchal",
				"9825630021", "nilesh@gmail.com", "Shreenand Nagar, Part 4, Vejalpur, Ahmedabad", "Remarks",
				"Requirement", "Walk-In", "Akash Patel 123", "9856234512", "Shaligram Software 123", "FLAT",
			"50,00,000 - 75,00,000" },

			{ "Automation Project9", "Batista", "", "In Progress", " Nilesh Panchal", "9825630021",
				"nilesh@gmail.com", "Shreenand Nagar, Part 4, Vejalpur, Ahmedabad", "Remarks", "Requirement",
				"Chanel Partner", "Akash Patel 123", "9856234512", "Shaligram Software 123", "Flats & Shop",
			"50,00,000 - 75,00,000" },
		};
	}

	// DataProvider for Edit Inquiry Data
	@DataProvider
	public Object[][] InquiryEditData() {
		return new Object[][] { { "Automation Project1", "Automation Project1", "Joan Cena Update", "Completed",
			"9876543210", "akash.new@mail.com", "Thaltej Square, Ahmedabad", "Updated Remarks",
			"Chanel Partner Requirement", "Chanel Partner", "Akash Patel 123 Test", "9856234000",
		"Shaligram Software 123 Test" } };
	}

	// DataProvider for Delete Inquiry Data
	@DataProvider
	public Object[][] InquiryDeleteData() {
		return new Object[][] { { "Joan Cena Update" }, { "Roman Raign" }, { "Undertekan" }, { "Batista" } };
	}

	// DataProvider for Inquiry Apply Filter for Project Data
	@DataProvider
	public Object[][] InquiryprojectfilterData() {
		return new Object[][] { { "12/OCT/2024", "31/DEC/2024", "Automation Project1" } };
	}

	// DataProvider for Inquiry Select Project
	@DataProvider
	public Object[][] InquirySelectProject() {
		return new Object[][] { { "Automation Project1" } };
	}

	// DataProvider for Filter Dates Data
	@DataProvider
	public Object[][] FilterDatesData() {
		return new Object[][] { { "11/DEC/2021", "17/DEC/2022" } };
	}

	// DataProvider for Search Data
	@DataProvider
	public Object[][] InquirySearchData() {
		return new Object[][] { { "Jyotendra Patel" } };
	}

	// DataProvider for Todays Follow Up Data
	@DataProvider
	public Object[][] TodaysFollowUpData() {
		return new Object[][] { { "Mahesh Patel" } };
	}

	// DataProvider for Missing Follow Up Data
	@DataProvider
	public Object[][] MissingFollowUpData() {
		return new Object[][] { { "Jyotendra Patel", "26/DEC/2024" } };
	}

	// DataProvider for Add Prospect Data
	@DataProvider
	public Object[][] InquiryaddprospectData() {
		return new Object[][] { { "Joan Cena", "B", "Unit No - 1 (1 Floor)" } };
	}

	// DataProvider for Add Inquiry Mandatory Data
	@DataProvider
	public Object[][] AddInquiryMandatoryData() {
		return new Object[][] { {"Walk-In" } };
	}

	// DataProvider for Edit Inquiry Mandatory Data
	@DataProvider
	public Object[][] EditInquiryMandatoryData() {
		return new Object[][] { { "Roman Raign", "Walk-In" } };
	}

	// DataProvider for Add Inactive Attendee Data
	@DataProvider
	public Object[][] AddInactiveAttendee() {
		return new Object[][] { { "AutomationEmpExport", "AutomationEmpExport" } };
	}

	// DataProvider for Add Active Attendee Data
	@DataProvider
	public Object[][] AddActiveAttendee() {
		return new Object[][] { { "AutomationEmpExport", "AutomationEmpExport" } };
	}

	// DataProvider for Edit Inactive Attendee Data
	@DataProvider
	public Object[][] EditInactiveAttendee() {
		return new Object[][] { { "AutomationEmpEdit Test", "AutomationEmpEdit Test" } };
	}

	// DataProvider for Edit Active Attendee Data
	@DataProvider
	public Object[][] EditActiveAttendee() {
		return new Object[][] { { "AutomationEmpEdit Test", "AutomationEmpEdit Test" } };
	}

	// DataProvider for Add Inactive Inquiry Status Data
	@DataProvider
	public Object[][] AddInactiveInquiryStatus() {
		return new Object[][] { { "New Inquiry Status", "New Inquiry Status" } };
	}

	// DataProvider for Add Active Inquiry Status Data
	@DataProvider
	public Object[][] AddActiveInquiryStatus() {
		return new Object[][] { { "New Inquiry Status", "New Inquiry Status" } };
	}

	// DataProvider for Edit Inactive Inquiry Status Data
	@DataProvider
	public Object[][] EditInactiveInquiryStatus() {
		return new Object[][] { { "New Inquiry Status", "New Inquiry Status" } };
	}

	// DataProvider for Edit Inactive Inquiry Status Data
	@DataProvider
	public Object[][] EditActiveInquiryStatus() {
		return new Object[][] { { "New Inquiry Status", "New Inquiry Status" } };
	}

	// DataProvider for Edit Inactive Inquiry Response Type
	@DataProvider
	public Object[][] EditInactiveInquiryResponseType() {
		return new Object[][] { { "Sitops123", "Sitops123" } };
	}

	// DataProvider for Edit Active Inquiry Response Type
	@DataProvider
	public Object[][] EditActiveInquiryResponseType() {
		return new Object[][] { { "Sitops321", "Sitops321" } };
	}

	// DataProvider for Edit Inactive Inquiry Communcation Mode
	@DataProvider
	public Object[][] EditInactiveInquiryCommuncation() {
		return new Object[][] { { "SIT InquiryCommunicationMode", "SIT InquiryCommunicationMode" } };
	}

	// DataProvider for Edit Active Inquiry Communication Mode
	@DataProvider
	public Object[][] EditActiveInquiryCommuncation() {
		return new Object[][] { { "SIT InquiryCommunicationMode", "SIT InquiryCommunicationMode" } };
	}

	// DataProvider for AddInactiveProjectData
	@DataProvider
	public Object[][] AddInactiveProjectData() {
		return new Object[][] { { "Automation Project3", "Automation Project3" } };
	}

	// DataProvider for Add Active Project Data
	@DataProvider
	public Object[][] AddActiveProjectData() {
		return new Object[][] { { "Automation Project2", "Automation Project2" } };
	}

	// DataProvider for Edit Inactive Project Data
	@DataProvider
	public Object[][] EditInactiveProjectData() {
		return new Object[][] { { "Automation Project3", "Automation Project1", "Automation Project3" } };
	}

	// DataProvider for Edit Active Project Data
	@DataProvider
	public Object[][] EditActiveProjectData() {
		return new Object[][] { { "Automation Project2", "Automation Project2", "Automation Project2" } };
	}
}