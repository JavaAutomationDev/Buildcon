package pageObjects;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class ProspectPage {

	public WebDriver driver;

	public ProspectPage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Prospect Module
	By Prospect = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav"
			+ "/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[3]/a");
	public WebElement getprospect() {
		base.failedElementName = "Prospect-ClickMenu";
		return driver.findElement(Prospect);
	}
	//Page object for Add Prospect
	By Addprospect = By.xpath("//span[contains(text(),'Add New Prospect')]");
	public WebElement getAddprospect() {
		base.failedElementName = "Prospect-ClickAdd";
		return driver.findElement(Addprospect);
	}

	//Page object for Visit Site/Project
	By siteProject = By.xpath("//mat-select[@formcontrolname='projectID']");
	public void getsiteproject(String siteproject) {
		WebElement dropdown = driver.findElement(siteProject);
		dropdown.click();
		
		base.failedElement = dropdown;
        base.failedElementName = "Prospect-getsiteproject";
		
		String optionXPath = "//mat-option//span[contains(text(),'" + siteproject + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		

        
		option.click();
	}

	//Page object for Visitor Name
	By visitorname = By.xpath("//input[@formcontrolname='visitorName']");
	public WebElement getvisitorname() {
		base.failedElementName = "Prospect-VisitorName";
		return driver.findElement(visitorname);
	}

	//Page object for Visitor Date
	By visitordate = By.xpath("//input[@formcontrolname='visitDT']");
	public WebElement getvisitordate() {
		@SuppressWarnings("unused")
		Date a = new Date();
		base.failedElementName = "Prospect-VisitorDate";
		return driver.findElement(visitordate);
	}

	//Page object for In Time
	By InTime = By.xpath("//input[@formcontrolname='visitorInDT']");
	public WebElement getIntime() {
		@SuppressWarnings("unused")
		LocalTime currentTime = LocalTime.now();
		base.failedElementName = "Prospect-Intime";
		return driver.findElement(InTime);
	}

	//Page object for current time pop up ok Button
	By Ok = By.xpath("//mat-dialog-actions[@class='mat-mdc-dialog-actions mdc-dialog__actions']//button[2]");
	public WebElement getOk() {
		base.failedElementName = "Prospect-IntimeOK";
		return driver.findElement(Ok);
	}

	//Page object for Out Time
	By outTime = By.xpath("//input[@formcontrolname='visitorOutDT']");
	public WebElement getouttime() {
		LocalTime currentTime = LocalTime.now();

		//Add 1 hours and 30 minutes to the current time to get the future time
		LocalTime futureTime = currentTime.plusHours(1).plusMinutes(30);

		//Format the future time (optional, depending on the input format required)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String formattedFutureTime = futureTime.format(formatter);

		//Find the 'Out Time' input field
		WebElement outTimeElement = driver.findElement(outTime);

		// Set the future time in the input field
		outTimeElement.sendKeys(formattedFutureTime);
		base.failedElementName = "Prospect-outtime";
		return outTimeElement;
	}

	//Page object for Next Follow Up Date
	public WebElement getNextfollowUpDT() {
		WebElement nextFollowUpElement = driver.findElement(By.xpath("//input[@formcontrolname='followUpDT']"));

		//Get the current date and add 1 day
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1); // Add 1 day to current date
		Date tomorrow = calendar.getTime();

		//Format the date to the desired format (e.g., dd/MM/yyyy)
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		//Send the formatted date to the NextfollowUpDT input field
		nextFollowUpElement.sendKeys(formattedDate);
		base.failedElementName = "Prospect-NextFollowDate";
		return nextFollowUpElement;
	}

	//Page object for Referenced By
	By referencedBy = By.xpath("//input[@formcontrolname='referencedBy']");
	public WebElement getreferencedBy() {
		base.failedElementName = "Prospect-referancedBy";
		return driver.findElement(referencedBy);
	}

	//Page object for Attendee
	By Attende = By.xpath("//mat-select[@formcontrolname='userID']");
	public void getAttendee(String Attendee) {
		WebElement dropdown = driver.findElement(Attende);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Prospect-getAttendee";
		
		//Construct the XPath for the desired option
		String optionXPath = "//mat-option//span[contains(text(),'" + Attendee + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	//Page object for Contact Number
	By ContactNo = By.xpath("//input[@formcontrolname='visitorMobile']");
	public WebElement getContactNo() {
		base.failedElementName = "Prospect-contactno";
		return driver.findElement(ContactNo);
	}

	//Page object for Visitor Email
	By Email = By.xpath("//input[@formcontrolname='visitorEmail']");
	public WebElement getEmail() {
		base.failedElementName = "Prospect-Email";
		return driver.findElement(Email);
	}

	//Page object for Address
	By Address = By.xpath("//textarea[@formcontrolname='visitorAddress']");
	public WebElement getAddress() {
		base.failedElementName = "Prospect-Address";
		return driver.findElement(Address);
	}

	//Page object for Remarks
	By Remarks = By.xpath("//textarea[@formcontrolname='remarks']");
	public WebElement getRemarks() {
		base.failedElementName = "Prospect-Remarks";
		return driver.findElement(Remarks);
	}

	//Page object for Requirement
	By Requirement = By.xpath("//input[@formcontrolname='requirement']");
	public WebElement getrequirement() {
		base.failedElementName = "Prospect-Requirement";
		return driver.findElement(Requirement);
	}

	//Page object for Status
	By Status = By.xpath("//mat-select[@formcontrolname='statusID']");
	public void getstatus(String status) {
		
		WebElement dropdown = driver.findElement(Status);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Prospect-getStatus";
		
		String optionXPath = "//mat-option//span[contains(text(),'" + status + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Save Button
	By Save = By.xpath("//button[@type='submit']");
	public WebElement getsave() {
		base.failedElementName = "Prospect-Save";
		return driver.findElement(Save);
	}

	//Page object for Edit Button
	public WebElement getEdit() {
		WebElement Edit = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
				+ "mat-sidenav-container/mat-sidenav-content/main/vex-prospect/vex-inquires/div/div[2]/div/"
				+ "mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[15]/div/a[1]"));
		
		base.failedElement = Edit;
		base.failedElementName = "getEdit Prospect-Follow_Inquiry";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Edit);
		js.executeScript("arguments[0].click();", Edit);
		return Edit;
	}

	//Page object for Search
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		base.failedElementName = "Prospect-Search";
		return driver.findElement(Search);
	}
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-prospect/vex-inquires/div/div[1]/div[2]/button[1]");
	public WebElement getExporttoExcel() {
		base.failedElementName = "Prospect-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-prospect/vex-inquires/div/div[1]/div[2]/div[3]/button");
	public WebElement getapplyfilter() {
		base.failedElementName = "Prospect-filter";
		return driver.findElement(filter);
	}

	//Page object for Date Range
	By Daterange=By.xpath("//mat-date-range-input[@role='group']");
	public WebElement getdaterange() {
		base.failedElementName = "Prospect-daterange";
		return driver.findElement(Daterange);
	}

	//Page object for Select Start Date
	By SelectstartDate=By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']");
	public WebElement getSelectstartDate() {
		base.failedElementName = "Prospect-selectstdate";
		return driver.findElement(SelectstartDate);
	}

	//Page object for Select End Date
	By SelectendDate=By.xpath("//span[normalize-space()='30']");
	public WebElement getSelectEndDate() {
		base.failedElementName = "Prospect-selectenddt";
		return driver.findElement(SelectendDate);
	}
	//Page object for Select Project
	By selectproject=By.xpath("//mat-select[@placeholder='Select Project']");
	public void getselectproject(String project) {
		WebElement dropdown = driver.findElement(selectproject);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "getselectproject Prospect-Apply Filter";
		
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + project + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Reset Button
	By resetfilter=By.xpath("//button[@mattooltip='Reset Filters']");
	public WebElement getresetfilter() {
		base.failedElementName = "Prospect-ResetFilter";
		return driver.findElement(resetfilter);
	}
	//Page object for Delete Prospect
	public WebElement getDelete() {
		WebElement deleteButton = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
						+ "mat-sidenav-content/main/vex-prospect/vex-inquires/div/div[2]/div/"
						+ "mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[15]/div/a[2]"));
		
		base.failedElement = deleteButton;
		base.failedElementName = "getDelete Prospect";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", deleteButton);
		js.executeScript("arguments[0].click();", deleteButton);
		return deleteButton;
	}
	//Page object for Click Yes
	By ClickYes = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up"
			+ "/form/mat-dialog-actions/button[1]");
	public WebElement getClickYes() {
		base.failedElementName = "Prospect-ClickYes";
		return driver.findElement(ClickYes);
	}

	//Page Object for Today's Follow Up Details
	By Todayfollowup = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content"
			+ "/main/vex-prospect/vex-inquires/div/div[2]/div/mat-tab-group/mat-tab-header/div/div/div/div[2]");
	public WebElement gettodayfollowup() {
		base.failedElementName = "Prospect-Todayfollowup";
		return driver.findElement(Todayfollowup);
	}
	//Page object for Missing Follow Up Details
	By MissingFollowup = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content"
			+ "/main/vex-prospect/vex-inquires/div/div[2]/div/mat-tab-group/mat-tab-header/div/div/div/div[3]");
	public WebElement getmissingfollowup() {
		base.failedElementName = "Prospect-MissingFollowup";
		return driver.findElement(MissingFollowup);
	}
	//Page object for Unit Dropdown
	By unitdropdown = By.xpath("//mat-select[@formcontrolname='unitBlockID']");
	public void getunitdropdown(String unitD) {
		WebElement dropdown = driver.findElement(unitdropdown);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Prospect-getunitdropdown";

		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + unitD + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		
	
		option.click();
	}
	//Page Object for Select Flat/Shop
	By SelectFlat = By.xpath("//mat-select[@formcontrolname='flatShopID']");
	 
	public void getSelectFlat(String Selectflat) {
		WebElement dropdown = driver.findElement(SelectFlat);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Prospect-getSelectFlat";

		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + Selectflat + "')]";  
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
}