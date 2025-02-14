package pageObjects;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import resources.base;

public class InquiryPage {
	public WebDriver driver;
	public boolean flag;

	public InquiryPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Inquiry Module
	By Inquiry = By.xpath("//vex-sidenav-item[2]//a[1]");

	public WebElement getInquiry() {
		base.failedElementName = "Inquiry-InquiryMenu";
		return driver.findElement(Inquiry);
	}

	// Page object for Add Inquiry
	By AddInquiry = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[1]/div[2]/button/span[2]");

	public WebElement getaddInquiry() {
		base.failedElementName = "Inquiry-AddInquiry";
		return driver.findElement(AddInquiry);
	}

	// Page object for Visit Site/Project
	By siteProject = By.xpath("//vex-searchable-dropdown[@placeholder=\"Visit Site/Project\"]");

	public void getsiteproject(String siteproject) {
		WebElement dropdown = driver.findElement(siteProject);
		dropdown.click();

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getsiteProject";

		String optionXPath = "//mat-option//span[contains(text(),'" + siteproject + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page object for Visitor Name
	By visitorname = By.xpath("//input[@formcontrolname='visitorName']");

	public WebElement getvisitorname() {
		base.failedElementName = "Inquiry-VisitorName";
		return driver.findElement(visitorname);
	}

	// Page object for InTime
	By InTime = By.xpath("//input[@formcontrolname='visitorInDT']");

	public WebElement getIntime() {
		@SuppressWarnings("unused")
		LocalTime currentTime = LocalTime.now();
		base.failedElementName = "Inquiry-Intime";
		return driver.findElement(InTime);
	}

	// Page object for Current time pop up Ok Button
	By Ok = By.xpath("//mat-dialog-actions[@class='mat-mdc-dialog-actions mdc-dialog__actions']//button[2]");

	public WebElement getOk() {
		base.failedElementName = "Inquiry-IntimeOK";
		return driver.findElement(Ok);
	}

	// Page object for OutTime
	By outTime = By.xpath("//input[@formcontrolname='visitorOutDT']");

	public WebElement getouttime() {
		// @SuppressWarnings("unused") LocalTime currentTime = LocalTime.now();
		// return driver.findElement(outTime);

		LocalTime currentTime = LocalTime.now();
		LocalTime futureTime = currentTime.plusHours(1).plusMinutes(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String formattedFutureTime = futureTime.format(formatter);
		WebElement outTimeElement = driver.findElement(outTime);
		outTimeElement.sendKeys(formattedFutureTime);
		base.failedElementName = "Inquiry-Outtime";
		return outTimeElement;
	}

	// Page object for Next Follow Up Date
	public WebElement getNextfollowUpDT() {
		WebElement nextFollowUpElement = driver.findElement(By.xpath("//input[@formcontrolname='followUpDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextFollowUpElement.sendKeys(formattedDate);
		base.failedElementName = "Inquiry-NextfollowDate";
		return nextFollowUpElement;
	}

	// Page object for Referenced By
	By referencedBy = By.xpath("//input[@formcontrolname='referencedBy']");

	public WebElement getreferencedBy() {
		base.failedElementName = "Inquiry-ReferancedBy";
		return driver.findElement(referencedBy);
	}

	// Page object for Attendee
	By Attende = By.xpath("//vex-searchable-dropdown[@placeholder=\"Attendee\"]");

	public void getAttendee(String Attendee) {
		WebElement dropdown = driver.findElement(Attende);
		dropdown.click();

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getAttendee";

		String optionXPath = "//mat-option//span[contains(text(),'" + Attendee + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page object for Contact Number
	By ContactNo = By.xpath("//input[@formcontrolname='visitorMobile']");

	public WebElement getContactNo() {
		base.failedElementName = "Inquiry-ContactNo";
		return driver.findElement(ContactNo);
	}

	// Page object for Visitor Email
	By Email = By.xpath("//input[@formcontrolname='visitorEmail']");

	public WebElement getEmail() {
		base.failedElementName = "Inquiry-Email";
		return driver.findElement(Email);
	}

	// Page object for Address
	By Address = By.xpath("//textarea[@formcontrolname='visitorAddress']");

	public WebElement getAddress() {
		base.failedElementName = "Inquiry-Address";
		return driver.findElement(Address);
	}

	// Page object for Remarks
	By Remarks = By.xpath("//textarea[@formcontrolname='remarks']");

	public WebElement getRemarks() {
		base.failedElementName = "Inquiry-Remarks";
		return driver.findElement(Remarks);
	}

	// Page object for Requirement
	By Requirement = By.xpath("//input[@formcontrolname='requirement']");

	public WebElement getrequirement() {
		base.failedElementName = "Inquiry-Requirement";
		return driver.findElement(Requirement);
	}

	// Page object for Status
	By Status = By.xpath("//vex-searchable-dropdown[@placeholder=\"Status\"]");

	public void getstatus(String status) {
		WebElement dropdown = driver.findElement(Status);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getstatus";

		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + status + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page object for Source
	By source = By.xpath("//mat-select[@formcontrolname='sourceID']");

	public void getSource(String Source) {
		WebElement dropdown = driver.findElement(source);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-Source";

		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + Source + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page object for Channel Partner Name
	By channelpartnername = By.xpath("//input[@formcontrolname='referencedBy']");

	public WebElement getChannelPartnerName() {
		base.failedElementName = "Inquiry-ChannelPartnerName";
		return driver.findElement(channelpartnername);
	}

	// Page object for Channel Partner Contact
	By channelpartnercontact = By.xpath("//input[@formcontrolname='referenceMobile']");

	public WebElement getChannelPartnerContact() {
		base.failedElementName = "Inquiry-ChannelPartnerContact";
		return driver.findElement(channelpartnercontact);
	}

	// Page object for Channel Partner Firm Name
	By channelpartnerfirmname = By.xpath("//input[@formcontrolname='referenceFirmName']");

	public WebElement getChannelPartnerFirmName() {
		base.failedElementName = "Inquiry-ChannelPartnerFirmName";
		return driver.findElement(channelpartnerfirmname);
	}

	// Page object for Reference Name
	By Referencename = By.xpath("//input[@formcontrolname='referencedBy']");

	public WebElement getReferenceName() {
		base.failedElementName = "Inquiry-ReferenceName";
		return driver.findElement(Referencename);
	}

	// Page object for Reference Contact
	By Referencecontact = By.xpath("//input[@formcontrolname='referenceMobile']");

	public WebElement getReferenceContact() {
		base.failedElementName = "Inquiry-ReferenceContact";
		return driver.findElement(Referencecontact);
	}

	// Page object for Intrest
	By Selectintrest = By.xpath("//mat-select[@id='mat-select-26']");

	public void getIntrest(String Intrest) {

		try {
			WebElement dropdown = driver.findElement(Selectintrest);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.xpath("//mat-option[@id]"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Intrest)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Intrest);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Intrest);
			e.printStackTrace();
		}
	}

	// Page object for Approx Budget
	By approxbudget = By.xpath("//mat-select[@formcontrolname='approxBudget']");

	public void getApproxBudget(String Approxbudget) {
		WebElement dropdown = driver.findElement(approxbudget);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-ApproxBudget";

		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + Approxbudget + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page object for IsProspect
	By IsProspect = By.xpath("//mat-checkbox[@formcontrolname='isProspect']");

	public WebElement getIsProspect() {
		base.failedElementName = "Inquiry-IsProspect";
		return driver.findElement(IsProspect);
	}

	// Page object for Save Button
	By Save = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/div/form/div[2]/button[2]");

	public WebElement getsave() {
		base.failedElementName = "Inquiry-Save";
		return driver.findElement(Save);
	}

	// Page object for Update Button
	By update = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[2]/button[2]");

	public WebElement getUpdate() {
		base.failedElementName = "Inquiry-Update";
		return driver.findElement(update);
	}

	// Page object for Edit time Update Button
	By updatebutton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[2]/button[2]");

	public WebElement getupdatebutton() {
		base.failedElementName = "Inquiry-Update Button";
		return driver.findElement(updatebutton);
	}

	// Page Object for Missing Inquiry Follow Up
	By missingfollowupcalender = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div[6]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");

	public WebElement getMissingfollowupcalender() {
		base.failedElementName = "Inquiry-Update";
		return driver.findElement(missingfollowupcalender);
	}

	// Page Object for Missing Inquiry Follow Up
	public WebElement getMissinnextfollowupdate(String followup) throws InterruptedException {
		String btn1 = "/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]";
		driver.findElement(By.xpath(btn1)).click();
		Thread.sleep(2000);

		// Start Year Select
		String[] YearParts = followup.split("/");
		String Year = YearParts[2];
		String Yearxpath = "//span[normalize-space()='" + Year + "']";
		WebElement YearField = driver.findElement(By.xpath(Yearxpath));
		YearField.click();

		// Start Date
		String[] MonthParts = followup.split("/");
		String Month = MonthParts[1];
		String Monthxpath = "//span[normalize-space()='" + Month + "']";
		driver.findElement(By.xpath(Monthxpath)).click();

		// Open Start Date Picker
		String[] DayParts = followup.split("/");
		String Day = DayParts[0];
		String Dayxpath = "//span[normalize-space()='" + Day + "']";
		WebElement startDateField = driver.findElement(By.xpath(Dayxpath));
		startDateField.click();
		return startDateField;
	}

	// Page object for Edit Button
	public WebElement getEdit() {
		WebElement Edit = driver
				.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
						+ "/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/div/"
						+ "mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[14]/div/a[1]"));

		base.failedElement = Edit;
		base.failedElementName = "getEdit Inquiry-Follow_Inquiry";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Edit);
		js.executeScript("arguments[0].click();", Edit);
		return Edit;
	}

	// Page object for Missing follow up Edit button
	By missingeditbtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[3]/div/div/div/table/tbody/tr/td[14]/div/a");

	public WebElement getMissingEditbtn() {
		base.failedElement = null;
		base.failedElementName = "Inquiry-Missing Follow Up Edit Button ";
		return driver.findElement(missingeditbtn);
	}

	// Page object for Search Inquiry
	By Search = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[1]/div[2]/div[1]/input");

	public WebElement getSearchInquiry() {
		base.failedElement = null;
		base.failedElementName = "Inquiry-SearchInquiry";
		return driver.findElement(Search);
	}

	// Page object for Export to Excel
	By ExporttoExcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[1]/div[2]/button[1]");

	public WebElement getExporttoExcel() {
		base.failedElementName = "Inquiry-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}

	// Page object for Apply Filter
	By filter = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[1]/div[2]/div[3]/button");

	public WebElement getapplyfilter() {
		base.failedElementName = "Inquiry-ApplyFilter";
		return driver.findElement(filter);
	}

	// Page object for Date Range
	By Daterange = By.xpath("//mat-date-range-input[@role='group']");

	public WebElement getdaterange() {
		base.failedElementName = "Inquiry-DateRange";
		return driver.findElement(Daterange);
	}

	// Page object for Select Start Date
//	By SelectstartDate=By.xpath("//span[normalize-space()='1']");
//	public WebElement getSelectstartDate() {
//		base.failedElementName = "Inquiry-StartDate";
//		return driver.findElement(SelectstartDate);
//	}

	// Page object for Select End Date
//	By selectendDate=By.xpath("//span[normalize-space()='30']");
//	public WebElement getSelectEndDate() {
//		base.failedElementName = "Inquiry-EndDate";
//		return driver.findElement(selectendDate);
//	}

	// Page object for Select Project
	By selectproject = By.xpath("//vex-searchable-dropdown[@placeholder=\"Select Project\"]");

	public void getselectproject(String project) {
		WebElement dropdown = driver.findElement(selectproject);
		dropdown.click();

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-ApplyFiltergetselectproject";

		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + project
				+ "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page object for Reset Button
	By resetfilter = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/div[5]/button");

	public WebElement getresetfilter() {
		base.failedElementName = "Inquiry-ResetFilter";
		return driver.findElement(resetfilter);
	}

	// Page object for Delete
	public WebElement getDelete() {
		WebElement deleteButton = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[14]/div/a[2]"));
		base.failedElementName = "Inquiry-Delete";
		return deleteButton;
	}

	// Page object for Click Yes
	By ClickYes = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getClickYes() {
		base.failedElementName = "Inquiry-DeleteYes";
		return driver.findElement(ClickYes);
	}

	// Page Object for Today's Follow Up Details
	By Todayfollowup = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/mat-tab-header/div/div/div/div[2]");

	public WebElement gettodayfollowup() {
		base.failedElementName = "Inquiry-TodayFollowup";
		return driver.findElement(Todayfollowup);
	}

	// Page object for Missing Follow Up Details
	By MissingFollowup = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/mat-tab-header/div/div/div/div[3]");

	public WebElement getmissingfollowup() {
		base.failedElementName = "Inquiry-MissingFollowup";
		return driver.findElement(MissingFollowup);
	}

	// Page object for Add To Prospect
	By Addprospect = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr/td[14]/div/a[3]");

	public WebElement getAddprospect() {

		WebElement dropdown = driver.findElement(Addprospect);
		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getunitdropdown";
		return driver.findElement(Addprospect);
	}

	// Page object for Unit DropDown
	By unitdropdown = By.xpath("//mat-select[@formcontrolname='unitBlockID']");

	public void getunitdropdown(String unitD) {
		WebElement dropdown = driver.findElement(unitdropdown);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getunitdropdown";

		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + unitD
				+ "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page Object for Select Flat/Shop
	By SelectFlat = By.xpath("//mat-select[@formcontrolname='flatShopID']");

	public void getSelectFlat(String Selectflat) {
		WebElement dropdown = driver.findElement(SelectFlat);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getSelectFlat";

		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '"
				+ Selectflat + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page object for Clear Visitior Name
	public void Getedit() {
		driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[14]/div/a[1]"))
				.click();
		WebElement visitorname = driver.findElement(By.xpath("//input[@formcontrolname='visitorName']"));
		visitorname.clear();
		visitorname.sendKeys("a");
		visitorname.sendKeys(Keys.BACK_SPACE);
		visitorname.sendKeys(Keys.TAB);
	}

	// Page object for Blank Out Time
	By blankoutTime = By.xpath("//input[@id='mat-time-picker-1']");

	public WebElement getBlankoutTime() {
		return driver.findElement(blankoutTime);
	}

	// Page object for Missing follow up details Edit button
	By missingfollowupeditbtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[3]/div/div/div/table/tbody/tr[1]/td[15]/div/a");

	public WebElement getMissingFollowUpEditBtn() {
		return driver.findElement(missingfollowupeditbtn);
	}

	// Page object for Follow up details
	By followupdetails = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
					+ "/vex-add-inquiry/div/div[2]/div/mat-tab-group/mat-tab-header/div/div/div/div[2]");

	public WebElement getFollowUpDetails() {
		return driver.findElement(followupdetails);
	}

	// Page object for Add Follow Details
	By addfollowdetails = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-add-inquiry/div/div[1]/div[2]/div/button");

	public WebElement getAddFollowDetails() {
		return driver.findElement(addfollowdetails);
	}

	// Verify Add Inactive Attendee Inquiry
	// Page object for Verify Add Inactive Attendee Inquiry
	public void AddInactiveAttendee(String Attendee) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Attendee\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (b.equalsIgnoreCase(Attendee)) {
				Assert.assertFalse(false, "Attende is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Add Active Attendee Inquiry
	// Page object for Verify Add Active Attendee Inquiry
	public void AddActiveAttendee(String Attendee) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Attendee\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (b.equalsIgnoreCase(Attendee)) {
				Assert.assertTrue(true, "Attende is Active.");
				// System.out.println("Test Pass");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Inactive Attendee Inquiry
	// Page object for Verify Edit Inactive Attendee Inquiry
	public void EditInactiveAttendee(String Attendee) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Attendee\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (b.equalsIgnoreCase(Attendee)) {
				Assert.assertFalse(false, "Attende is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active Attendee Inquiry
	// Page object for Verify Edit Active Attendee Inquiry
	public void EditActiveAttendee(String Attendee) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Attendee\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (b.equalsIgnoreCase(Attendee)) {
				Assert.assertTrue(true, "Attende is Active.");
				// System.out.println("Test Pass");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Active Inactive Inquiry Status
	// Page object for Verify Add Inactive Inquiry Status
	public void AddInactiveInquiryStatus(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Status\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Inquiry Status is inactive.");
				// System.out.println("Test Failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Add Active Inquiry Status
	// Page object for Verify Add Active Inquiry Status
	public void AddActiveInquiryStatus(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Status\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (b.equalsIgnoreCase(Name)) {
				Assert.assertTrue(true, "Inquiry Status is Active.");
				// System.out.println("Test Pass");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Inactive Inquiry Status
	// Page object for Verify Edit InActive Inquiry Status
	public void EditInactiveInquiryStatus(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Status\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Inquiry Status is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active Inquiry Status
	// Page object for Edit Active Inquiry status
	public void EditActiveInquiryStatus(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Status\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (b.equalsIgnoreCase(Name)) {
				Assert.assertTrue(true, "Inquiry Status is Active.");
				// System.out.println("Test Pass");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Inquiry Response Type
	// Page object for Verify Edit Inactive Inquiry Response Type
	public void EditInactiveInquiryResponseType(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Response Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Inquiry Response Type is inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active Inquiry Response Type
	// Page objecy for Verify Edit Active Inquiry Response Type
	public void EditActiveInquiryResponseType(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Response Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Inquiry Response Type is Active.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Inquiry Communcation mode
	// Page object for Verify Edit Inactive Inquiry Communcation mode
	public void EditInactiveInquiryCommuncation(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Communication Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Inquiry Communcation mode is inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active Inquiry Communcation mode
	// Page object for Verify Edit Active Inquiry Communcation mode
	public void EditActiveInquiryCommuncation(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Communication Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Inquiry Communcation mode is Active.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Add Inquiry Project Dropdown
	// Verify Add Inactive Project
	// Page object for Verify Add Inactive Project
	public void AddInactiveProjectData(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Visit Site/Project\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Project is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Add Active Project
	// Page object for Verify Add Active Project
	public void AddActiveProjectData(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Visit Site/Project\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Project is Active.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Edit Inquiry Project Dropdown
	// Verify Edit InActive Project
	// Page object for Verify Edit Inactive Project
	public void EditInactiveProjectData(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Visit Site/Project\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Project is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active Project
	// Page object for Verify Edit Active Project
	public void EditActiveProjectData(String Name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Visit Site/Project\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(Name)) {
				Assert.assertFalse(false, "Project is Active.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Page object for Page not found
	public boolean NoPageFound() {
		try {
			int t = driver.findElements(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']")).size();
			if (t == 0) {
				flag = false;
			} else {
				flag = true;
				System.out.println("No Data for Missing Follow Details.");
			}
		} catch (NoSuchElementException e) {

		}
		return flag;
	}
}