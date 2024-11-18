package pageObjects;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class InquiryPage {
	public WebDriver driver;

	public InquiryPage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Inquiry Module
	By Inquiry = By.xpath("//vex-sidenav-item[2]//a[1]");
	public WebElement getInquiry() {
		base.failedElementName = "Inquiry-InquiryMenu";
		return driver.findElement(Inquiry);
	}

	//Page object for Add Inquiry
	By AddInquiry = By.xpath("//span[contains(text(),'Add New Inquiry')]");
	public WebElement getaddInquiry() {
		base.failedElementName = "Inquiry-Add";
		return driver.findElement(AddInquiry);
	}

	//Page object for Visit Site/Project
	By siteProject = By.xpath("//mat-select[@formcontrolname='projectID']");
	public void getsiteproject(String siteproject) {
		WebElement dropdown = driver.findElement(siteProject);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getsiteProject";

		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + siteproject + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	//Page object for Visitor Name
	By visitorname = By.xpath("//input[@formcontrolname='visitorName']");
	public WebElement getvisitorname() {
		base.failedElementName = "Inquiry-VisitorName";
		return driver.findElement(visitorname);
	}

	//Page object for InTime
	By InTime = By.xpath("//input[@formcontrolname='visitorInDT']");
	public WebElement getIntime() {
		@SuppressWarnings("unused")
		LocalTime currentTime = LocalTime.now();
		base.failedElementName = "Inquiry-Intime";
		return driver.findElement(InTime);
	}

	//Page object for Current time pop up Ok Button
	By Ok = By.xpath("//mat-dialog-actions[@class='mat-mdc-dialog-actions mdc-dialog__actions']//button[2]");
	public WebElement getOk() {
		base.failedElementName = "Inquiry-IntimeOK";
		return driver.findElement(Ok);
	}

	//Page object for OutTime
	By outTime = By.xpath("//input[@formcontrolname='visitorOutDT']");
	public WebElement getouttime() {
		// @SuppressWarnings("unused") LocalTime currentTime = LocalTime.now();
		//return driver.findElement(outTime);

		LocalTime currentTime = LocalTime.now();
		LocalTime futureTime = currentTime.plusHours(1).plusMinutes(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String formattedFutureTime = futureTime.format(formatter);
		WebElement outTimeElement = driver.findElement(outTime);
		outTimeElement.sendKeys(formattedFutureTime);
		base.failedElementName = "Inquiry-Outtime";
		return outTimeElement;
	}

	//Page object for Next Follow Up Date
	public WebElement getNextfollowUpDT() {
		WebElement nextFollowUpElement = driver.findElement(By.xpath("//input[@formcontrolname='followUpDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextFollowUpElement.sendKeys(formattedDate);
		base.failedElementName = "Inquiry-NextfollowDate";
		return nextFollowUpElement;
	}

	//Page object for Referenced By
	By referencedBy = By.xpath("//input[@formcontrolname='referencedBy']");
	public WebElement getreferencedBy() {
		base.failedElementName = "Inquiry-ReferancedBy";
		return driver.findElement(referencedBy);
	}

	//Page object for Attendee
	By Attende = By.xpath("//mat-select[@formcontrolname='userID']");
	public void getAttendee(String Attendee) {
		WebElement dropdown = driver.findElement(Attende);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getAttendee";

		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + Attendee + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();	
	}

	//Page object for Contact Number
	By ContactNo = By.xpath("//input[@formcontrolname='visitorMobile']");
	public WebElement getContactNo() {
		base.failedElementName = "Inquiry-ContactNo";
		return driver.findElement(ContactNo);
	}

	//Page object for Visitor Email
	By Email = By.xpath("//input[@formcontrolname='visitorEmail']");
	public WebElement getEmail() {
		base.failedElementName = "Inquiry-Email";
		return driver.findElement(Email);
	}

	//Page object for Address
	By Address = By.xpath("//textarea[@formcontrolname='visitorAddress']");
	public WebElement getAddress() {
		base.failedElementName = "Inquiry-Address";
		return driver.findElement(Address);
	}

	//Page object for Remarks
	By Remarks = By.xpath("//textarea[@formcontrolname='remarks']");
	public WebElement getRemarks() {
		base.failedElementName = "Inquiry-Remarks";
		return driver.findElement(Remarks);
	}

	//Page object for Requirement
	By Requirement = By.xpath("//input[@formcontrolname='requirement']");
	public WebElement getrequirement() {
		base.failedElementName = "Inquiry-Requirement";
		return driver.findElement(Requirement);
	}

	//Page object for Status
	By Status = By.xpath("//mat-select[@formcontrolname='statusID']");
	public void getstatus(String status) {
		WebElement dropdown = driver.findElement(Status);
		
		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getstatus";
		
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + status + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	//Page object for IsProspect
	By IsProspect = By.xpath("//mat-checkbox[@formcontrolname='isProspect']");
	public WebElement getIsProspect() {
		base.failedElementName = "Inquiry-IsProspect";
		return driver.findElement(IsProspect);
	}

	//Page object for Save Button
	By Save = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-inquiry/div/div[2]/div/div/form/div[2]/button[2]");
	public WebElement getsave() {
		base.failedElementName = "Inquiry-Save";
		return driver.findElement(Save);
	}
	//Page object for Update Button
	By update = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-inquiry/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[2]/button[2]");
			public WebElement getUpdate() {
				base.failedElementName = "Inquiry-Update";
				return driver.findElement(update);
			}
	//Page object for Edit Button
	public WebElement getEdit() {
		WebElement Edit = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
				+ "vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[14]/div/a[1]"));

		
		base.failedElement = Edit;
		base.failedElementName = "getEdit Inquiry-Follow_Inquiry";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Edit);
		js.executeScript("arguments[0].click();", Edit);
		return Edit;
	}

	//Page object for Search
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		base.failedElement = null;
		base.failedElementName = "Missing_Follow_Inquiry";
		return driver.findElement(Search);
		
		
	}
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("//html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-inquires/div/div[1]/div[2]/button[1]");
	public WebElement getExporttoExcel() {
		base.failedElementName = "Inquiry-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-inquires/div/div[1]/div[2]/div[3]/button/span[3]");
	public WebElement getapplyfilter() {
		base.failedElementName = "Inquiry-ApplyFilter";
		return driver.findElement(filter);
	}

	//Page object for Date Range
	By Daterange=By.xpath("//mat-date-range-input[@role='group']");
	public WebElement getdaterange() {
		base.failedElementName = "Inquiry-DateRange";
		return driver.findElement(Daterange);
	}

	//Page object for Select Start Date
	By SelectstartDate=By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']");
	public WebElement getSelectstartDate() {
		base.failedElementName = "Inquiry-StartDate";
		return driver.findElement(SelectstartDate);
	}

	//Page object for Select End Date
	By selectendDate=By.xpath("//span[normalize-space()='30']");
	public WebElement getSelectEndDate() {
		base.failedElementName = "Inquiry-EndDate";
		return driver.findElement(selectendDate);
	}
	//Page object for Select Project
	By selectproject=By.xpath("//mat-select[@placeholder='Select Project']");
	public void getselectproject(String project) {
		WebElement dropdown = driver.findElement(selectproject);
		dropdown.click();

		base.failedElement = dropdown;
		base.failedElementName = "getselectproject Inquiry-Apply Filter";

		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + project + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Reset Button
	By resetfilter=By.xpath("//button[@mattooltip='Reset Filters']");
	public WebElement getresetfilter() {
		base.failedElementName = "Inquiry-ResetFilter";
		return driver.findElement(resetfilter);
	}
	//Page object for Delete
	public WebElement getDelete() {
		WebElement deleteButton = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
				+ "/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/div/"
				+ "mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[13]/div/a[2]/mat-icon"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", deleteButton);
		js.executeScript("arguments[0].click();", deleteButton);
		base.failedElementName = "Inquiry-Delete";
		return deleteButton;
	}
	//Page object for Click Yes
	By ClickYes = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up"
			+ "/form/mat-dialog-actions/button[1]");
	public WebElement getClickYes() {
		base.failedElementName = "Inquiry-DeleteYes";
		return driver.findElement(ClickYes);
	}

	//Page Object for Today's Follow Up Details
	By Todayfollowup = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content"
			+ "/main/vex-inquires/div/div[2]/div/mat-tab-group/mat-tab-header/div/div/div/div[2]");
	public WebElement gettodayfollowup() {
		base.failedElementName = "Inquiry-TodayFollowup";
		return driver.findElement(Todayfollowup);
	}
	//Page object for Missing Follow Up Details
	By MissingFollowup = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-inquires/div/div[2]/div/mat-tab-group/mat-tab-header/div/div/div/div[3]");
	public WebElement getmissingfollowup() {
		base.failedElementName = "Inquiry-MissingFollowup";
		return driver.findElement(MissingFollowup);
	}

	//Page object for Add To Prospect
	By Addprospect = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]"
			+ "/div/mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[13]/div/a[3]");
	public WebElement getAddprospect() {
		
		WebElement dropdown = driver.findElement(Addprospect);
		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getunitdropdown";
		
		return driver.findElement(Addprospect);
		
	}
	
	//Page object for Unit DropDown
	By unitdropdown = By.xpath("//mat-select[@formcontrolname='unitBlockID']");
	public void getunitdropdown(String unitD) {
		WebElement dropdown = driver.findElement(unitdropdown);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getunitdropdown";

		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + unitD + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page Object for Select Flat/Shop
	By SelectFlat = By.xpath("//mat-select[@formcontrolname='flatShopID']");
	public void getSelectFlat(String Selectflat) {
		WebElement dropdown = driver.findElement(SelectFlat);

		base.failedElement = dropdown;
		base.failedElementName = "Inquiry-getSelectFlat";

		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + Selectflat + "')]";  
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Clear Visitior Name
	public void Getedit()
	{
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[13]/div/a[1]")).click();
		WebElement visitorname = driver.findElement(By.xpath("//input[@formcontrolname='visitorName']"));
		visitorname.clear();
		visitorname.sendKeys("a");
		visitorname.sendKeys(Keys.BACK_SPACE);
		visitorname.sendKeys(Keys.TAB);
	}

	//Page object for Blank Out Time
	By blankoutTime = By.xpath("//input[@id='mat-time-picker-1']");
	public WebElement getBlankoutTime() {
		return driver.findElement(blankoutTime);
	}
	//Page object for Missing follow up details Edit button
	By missingfollowupeditbtn = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
				+ "vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[3]/div/div/div/table/tbody/tr[1]/td[13]/div/a");
	public WebElement getMissingFollowUpEditBtn() {
		return driver.findElement(missingfollowupeditbtn);
	}
	//Page object for Follow up details 
	By followupdetails = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-inquiry/div/div[2]/div/mat-tab-group/mat-tab-header/div/div/div/div[2]");
	public WebElement getFollowUpDetails() {
		return driver.findElement(followupdetails);
	}
	//Page object for Add Follow Details
	By addfollowdetails = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
			+ "main/vex-add-inquiry/div/div[1]/div[2]/div/button");
    public WebElement getAddFollowDetails() {
    	return driver.findElement(addfollowdetails);
    }
}