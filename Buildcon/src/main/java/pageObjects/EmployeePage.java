package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import resources.base;

public class EmployeePage {
	public WebDriver driver;

	public EmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	//Page object for click Employee Module
	By Employee = By.xpath("//vex-sidenav-item[9]//a[1]");
	public WebElement getEmployee() {
		base.failedElementName = "Employee-EmpModule";
		return driver.findElement(Employee);
	}
	//Page object for Add Employee
	By Addemployee = By.xpath("//span[contains(text(),'Add New Employee')]");
	public WebElement getaddemployee() {
		base.failedElementName = "Employee-AddEmployee";
		return driver.findElement(Addemployee);
	}
	//Page object for Profile Image
	By profileimg= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/mat-dialog-content/div[1]/label/input");
	public WebElement getProfileImg() {
		base.failedElementName = "Employee-ProfileImg";
		return driver.findElement(profileimg);
	}

	//Page object for First Name
	By firstName= By.xpath("//input[@formcontrolname='firstName']");
	public WebElement getfname() {
		base.failedElementName = "Employee-Firstname";
		return driver.findElement(firstName);
	}
	//Page object for Middle Name
	By  middleName= By.xpath("//input[@formcontrolname='middleName']");
	public WebElement getmname() {
		base.failedElementName = "Employee-MiddleName";
		return driver.findElement(middleName);
	}
	//Page object for Last Name
	By lastName= By.xpath("//input[@formcontrolname='lastName']");
	public WebElement getlname() {
		base.failedElementName = "Employee-LastName";
		return driver.findElement(lastName);
	}
	//Page object for User Name
	By username= By.xpath("//input[@formcontrolname='userName']");
	public WebElement getUserName() {
		base.failedElementName = "Employee-UserName";
		return driver.findElement(username);
	}

	//Page object for Designation
	By Designation= By.xpath("//input[@formcontrolname='designation']");
	public WebElement getDesignation() {
		base.failedElementName = "Employee-Designation";
		return driver.findElement(Designation);
	}

	//Page object for opne calendar
	By opencalendar= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/mat-dialog-content/div[2]/div[4]/div/div[3]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");
	public WebElement getClickDOB() {
		base.failedElementName = "Employee-Designation";
		return driver.findElement(opencalendar);
	}

	//Page object for DOB
	public WebElement getDOB(String dob) throws InterruptedException {
		String btn1="/html/body/div[4]/div[4]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]";
		driver.findElement(By.xpath(btn1)).click();
		Thread.sleep(2000);

		//Start Year Select
		String[] YearParts =dob.split("/");
		String Year = YearParts[2];
		String Yearxpath="//span[normalize-space()='"+Year+"']";
		WebElement YearField = driver.findElement(By.xpath(Yearxpath));
		YearField.click();

		//Start Date
		String[] MonthParts = dob.split("/");
		String Month = MonthParts[1];
		String Monthxpath="//span[normalize-space()='"+Month+"']";
		driver.findElement(By.xpath(Monthxpath)).click();		

		//Open Start Date Picker
		String[] DayParts = dob.split("/");
		String Day = DayParts[0];
		String Dayxpath="//span[normalize-space()='"+Day+"']";
		WebElement startDateField = driver.findElement(By.xpath(Dayxpath));
		startDateField.click();
		return startDateField;
	}

	//Page object for Email
	By Email= By.xpath("//input[@formcontrolname='email']");
	public WebElement getEmail() {
		base.failedElementName = "Employee-Email";
		return driver.findElement(Email);
	}
	//Page object for Roles
	By Roles= By.xpath("//mat-select[@formcontrolname='roleRightId']");
	public void getRoles(String Role) {

		WebElement dropdown = driver.findElement(Roles);
		dropdown.click();

		base.failedElement = dropdown;
		base.failedElementName = "Employee-getRoles";

		String optionXPath = "//mat-option//span[contains(text(),'" + Role + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for City
	By City= By.xpath("//input[@formcontrolname='city']");
	public WebElement getcity() {
		base.failedElementName = "Employee-City";
		return driver.findElement(City);
	}
	//Page object for State
	By state= By.xpath("//mat-select[@formcontrolname='stateId']");
	public void getstate(String State) {

		WebElement dropdown = driver.findElement(state);
		dropdown.click();

		base.failedElement = dropdown;
		base.failedElementName = "Employee-getstate";

		String optionXPath = "//mat-option//span[contains(text(),'" + State + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Mobile No
	By mobileno= By.xpath("//input[@formcontrolname='mobile']");
	public WebElement getMobileno() {
		base.failedElementName = "Employee-MobileNo";
		return driver.findElement(mobileno);
	}
	//Page object for Password
	By password= By.xpath("//input[@formcontrolname='password']");
	public WebElement getPassword() {
		base.failedElementName = "Employee-Password";
		return driver.findElement(password);
	}	

	//Page object for Address
	By Address= By.xpath("//textarea[@formcontrolname='address']");
	public WebElement getAddress() {
		base.failedElementName = "Employee-Address";
		return driver.findElement(Address);
	}

	//Page object for Project Access
	By projectaccess= By.xpath("//mat-select[@formcontrolname='projectId']");
	public void getProjectAccess(String Proejct) throws InterruptedException {
		WebElement dropdown = driver.findElement(projectaccess);
		dropdown.click();

		base.failedElement = dropdown;
		base.failedElementName = "Employee-getProjectAccess";

		String optionXPath = "//mat-option//span[contains(text(),'" + Proejct + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
		Thread.sleep(2000);
		dropdown.sendKeys(Keys.TAB); 
	}

	//Page object for Aadhar Card
	By Adharcard= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[2]/div[8]/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement uploadAdharCard() {
		base.failedElementName = "Employee-AadharCard";
		return driver.findElement(Adharcard);
	}

	//Page object for Pan Card
	By Pancard= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[2]/div[8]/div/div[2]/mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement getPancard() {
		base.failedElementName = "Employee-PanCard";
		return driver.findElement(Pancard);
	}
	//Page object for Select Gender
	By Gender= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[3]/div[1]/mat-radio-group/mat-radio-button[1]/div/label");
	public WebElement SelectGender() {
		base.failedElementName = "Employee-Gender";
		return driver.findElement(Gender);
	}
	//Page object for Next Button
	By Nextbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "app-employee-save/div/form/mat-dialog-actions/button[2]");
	public WebElement Nextbtn() {
		base.failedElementName = "Employee-NextBtn";
		return driver.findElement(Nextbtn);
	}	
	//Page object for Show Phone Number
	By shownumber= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles"
			+ "/div/vex-roles-form/form/mat-dialog-content/div[1]/div/mat-checkbox/div/div/input");
	public WebElement Shownumber() {
		base.failedElementName = "Employee-ShowNumber";
		return driver.findElement(shownumber);
	}

	//Page object for Employee Radio Btn
	By empradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div/div[2]/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Empradiobtn() {
		base.failedElementName = "Employee-EmpRadio";
		return driver.findElement(empradiobtn);
	}
	//Page object for Project Radio Btn
	By projectradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div/div[2]/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Projectradiobtn() {
		base.failedElementName = "Employee-ProjectRadio";
		return driver.findElement(projectradiobtn);
	}
	//Page object for Receipt Radio Btn
	By receiptradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Receiptradiobtn() {
		base.failedElementName = "Employee-ReceiptRadio";
		return driver.findElement(receiptradiobtn);
	}
	//Page object for Collection Radio Btn
	By collectionradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[5]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Collectionradiobtn() {
		base.failedElementName = "Employee-CollectionRadio";
		return driver.findElement(collectionradiobtn);
	}
	//Page object for Customer Radio Btn
	By customerradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[6]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Customerradiobtn() {
		base.failedElementName = "Employee-CustomerRadio";
		return driver.findElement(customerradiobtn);
	}
	//Page object for Inquiry Radio Btn
	By inquiryradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[7]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Inquiryradiobtn() {
		base.failedElementName = "Employee-InquiryRadio";
		return driver.findElement(inquiryradiobtn);
	}
	//Page object for Prospect Radio Btn
	By prospectradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[8]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Prospectradiobtn() {
		base.failedElementName = "Employee-ProspectRadio";
		return driver.findElement(prospectradiobtn);
	}
	//Page object for Bookings Radio Btn
	By bookingradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[9]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Bookingsradiobtn() {
		base.failedElementName = "Employee-BookingRadio";
		return driver.findElement(bookingradiobtn);
	}
	//Page object for Documents Radio Btn
	By documentradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[10]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Documentsradiobtn() {
		base.failedElementName = "Employee-DocumentRadio";
		return driver.findElement(documentradiobtn);
	}
	//Page object for Create Btn
	By createbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/mat-dialog-actions/button[2]");
	public WebElement Createbtn() {
		base.failedElementName = "Employee-CreateBtn";
		return driver.findElement(createbtn);
	}

	//Add Employee with All Modules - Only View
	//Page object for Employee Select Btn
	By empselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div[1]/div[2]/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement EmpSelectbtn() {
		base.failedElementName = "Employee-SelectBtn";
		return driver.findElement(empselectbtn);
	}
	//Page object for Employee View
	By empview= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeView']");
	public WebElement EmpView() {
		base.failedElementName = "Employee-ProjectEntry";
		return driver.findElement(empview);
	}
	//Page object for Employee Entry
	By empentry= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeEntry']");
	public WebElement EmpEntry() {
		base.failedElementName = "Employee-EmpEntry";
		return driver.findElement(empentry);
	}
	//Page object for Employee Modify
	By empmodify= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeUpdate']");
	public WebElement EmpModify() {
		base.failedElementName = "Employee-EmpModify";
		return driver.findElement(empmodify);
	}
	//Page object for Employee Remove
	By empremove= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeDelete']");
	public WebElement EmpRemove() {
		base.failedElementName = "Employee-EmpRemove";
		return driver.findElement(empremove);
	}
	//Page object for Employee Export
	By empexport= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeExport']");
	public WebElement EmpExport() {
		base.failedElementName = "Employee-EmpExport";
		return driver.findElement(empexport);
	}

	//Page object for Project Select Btn
	By projectselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div[1]/div[2]/mat-radio-group/mat-radio-button[2]");
	public WebElement Projectselectbtn() {
		base.failedElementName = "Employee-ProjectelectBtn";
		return driver.findElement(projectselectbtn);
	}
	//Page object for Project View
	By projectview= By.xpath("//mat-checkbox[@formcontrolname='isProjectView']");
	public WebElement ProjectView() {
		base.failedElementName = "Employee-ProjectEntry";
		return driver.findElement(projectview);
	}
	//Page object for Project Entry
	By projectentry= By.xpath("//mat-checkbox[@formcontrolname='isProjectEntry']");
	public WebElement ProjectEntry() {
		base.failedElementName = "Employee-ProjectEntry";
		return driver.findElement(projectentry);
	}
	//Page object for Project Modify
	By projectmodify= By.xpath("//mat-checkbox[@formcontrolname='isProjectUpdate']");
	public WebElement ProjectModify() {
		base.failedElementName = "Employee-ProjectModify";
		return driver.findElement(projectmodify);
	}
	//Page object for Project Remove
	By projectremove= By.xpath("//mat-checkbox[@formcontrolname='isProjectDelete']");
	public WebElement ProjectRemove() {
		base.failedElementName = "Employee-ProjectRemove";
		return driver.findElement(projectremove);
	}
	//Page object for Project Export
	By projectexport= By.xpath("//mat-checkbox[@formcontrolname='isProjectExport']");
	public WebElement ProjectExport() {
		base.failedElementName = "Employee-ProjectExport";
		return driver.findElement(projectexport);
	}

	//Page object for Receipt Select Btn
	By receiptselecbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement Receiptselectbtn() {
		base.failedElementName = "Employee-ReceiptSelectBtn";
		return driver.findElement(receiptselecbtn);
	}
	//Page object for Receipt View
	By receiptview= By.xpath("//mat-checkbox[@formcontrolname='isReceiptView']");
	public WebElement ReceiptView() {
		base.failedElementName = "Employee-ReceiptEntry";
		return driver.findElement(receiptview);
	}
	//Page object for Receipt Entry
	By receiptentry= By.xpath("//mat-checkbox[@formcontrolname='isReceiptEntry']");
	public WebElement ReceiptEntry() {
		base.failedElementName = "Employee-ReceiptEntry";
		return driver.findElement(receiptentry);
	}
	//Page object for Receipt Modify
	By receiptmodify= By.xpath("//mat-checkbox[@formcontrolname='isReceiptUpdate']");
	public WebElement ReceiptModify() {
		base.failedElementName = "Employee-ReceiptModify";
		return driver.findElement(receiptmodify);
	}
	//Page object for Receipt Remove
	By receiptremove= By.xpath("//mat-checkbox[@formcontrolname='isReceiptDelete']");
	public WebElement ReceiptRemove() {
		base.failedElementName = "Employee-ReceiptRemove";
		return driver.findElement(receiptremove);
	}
	//Page object for Receipt Export
	By receiptexport= By.xpath("//mat-checkbox[@formcontrolname='isReceiptExport']");
	public WebElement ReceiptExport() {
		base.failedElementName = "Employee-ReceiptExport";
		return driver.findElement(receiptexport);
	}

	//Collection view Page object
	//Page object for Collection Select Btn
	By collectionselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[5]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement Collectionselectbtn() {
		base.failedElementName = "Employee-CollectionSelectBtn";
		return driver.findElement(collectionselectbtn);
	}

	//Page object for Collection View
	By collectionview=By.xpath("//mat-checkbox[@formcontrolname='isCollectionView']");
	public WebElement CollectionView() {
		base.failedElementName = "Employee-CollectionExport";
		return driver.findElement(collectionview);
	}
	//Page object for Collection Export
	By collectionexport=By.xpath("//mat-checkbox[@formcontrolname='isCollectionExport']");
	public WebElement CollectionExport() {
		base.failedElementName = "Employee-CollectionExport";
		return driver.findElement(collectionexport);
	}

	//Customer View Page object
	//Page object for Customer Select Btn
	By customerselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[6]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement Customerselectbtn() {
		base.failedElementName = "Employee-CustomerSelectBtn";
		return driver.findElement(customerselectbtn);
	}
	//Page object for Customer View
	By customerview = By.xpath("//mat-checkbox[@formcontrolname='isMemberView']");
	public WebElement CustomerView() {
		base.failedElementName = "Employee-CustomerExport";
		WebElement element = driver.findElement(customerview);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}
	//Page object for Customer Export
	By customerexport = By.xpath("//mat-checkbox[@formcontrolname='isMemberExport']");
	public WebElement CustomerExport() {
		base.failedElementName = "Employee-CustomerExport";
		WebElement element = driver.findElement(customerexport);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

	//Inquiry View Page object
	//Page object for Inquiry Select Btn
	By inquiryselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles"
			+ "/div/vex-roles-form/form/mat-dialog-content/div[7]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement InquirySelectbtn() {
		base.failedElementName = "Employee-InquirySelectBtn";
		return driver.findElement(inquiryselectbtn);
	}
	//Page object for Inquiry View
	By inquiryview=By.xpath("//mat-checkbox[@formcontrolname='isInquiryView']");
	public WebElement Inquiryview() {
		base.failedElementName = "Employee-InquiryEntry";
		return driver.findElement(inquiryview);
	}
	//Page object for Inquiry Entry
	By inquiryentry=By.xpath("//mat-checkbox[@formcontrolname='isInquiryEntry']");
	public WebElement InquiryEntry() {
		base.failedElementName = "Employee-InquiryEntry";
		return driver.findElement(inquiryentry);
	}

	//Page object for Inquiry Modify
	By inquirymodify=By.xpath("//mat-checkbox[@formcontrolname='isInquiryUpdate']");
	public WebElement InquiryModify() {
		base.failedElementName = "Employee-InquiryModify";
		return driver.findElement(inquirymodify);
	}
	//Page object for Inquiry Remove
	By inquiryremove=By.xpath("//mat-checkbox[@formcontrolname='isInquiryDelete']");
	public WebElement InquiryRemove() {
		base.failedElementName = "Employee-InquiryRemove";
		return driver.findElement(inquiryremove);
	}
	//Page object for Inquiry Export
	By inquiryexport=By.xpath("//mat-checkbox[@formcontrolname='isInquiryExport']");
	public WebElement InquiryExport() {
		base.failedElementName = "Employee-InquiryExport";
		return driver.findElement(inquiryexport);
	}		
	//Page object for Inquiry Follow Up
	By inquiryfollowup=By.xpath("//mat-checkbox[@formcontrolname='isInquiryFollowUpEntry']");
	public WebElement InquiryFollowUp() {
		base.failedElementName = "Employee-Inquiryfollowup";
		return driver.findElement(inquiryfollowup);
	}

	//Page object for Prospect
	//Page object for Prospect Select Btn
	By prospectselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[8]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement ProspectSelectbtn() {
		base.failedElementName = "Employee-ProspectSelectBtn";
		return driver.findElement(prospectselectbtn);
	}
	//Page object for Prospect View
	By prospectview=By.xpath("//mat-checkbox[@formcontrolname='isProspectView']");
	public WebElement ProspectView() {
		base.failedElementName = "Employee-Prospectview";
		WebElement element = driver.findElement(prospectview);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return driver.findElement(prospectview);
	}

	//Page object for Prospect Entry
	By prospectentry=By.xpath("//mat-checkbox[@formcontrolname='isProspectEntry']");
	public WebElement ProspectEntry() {
		base.failedElementName = "Employee-ProspectView";
		return driver.findElement(prospectentry);
	}
	//Page object for Prospect Modify
	By prospectmodify=By.xpath("//mat-checkbox[@formcontrolname='isProspectUpdate']");
	public WebElement ProspectModify() {
		base.failedElementName = "Employee-ProspectModify";
		return driver.findElement(prospectmodify);
	}
	//Page object for Prospect Remove
	By prospectremove=By.xpath("//mat-checkbox[@formcontrolname='isProspectDelete']");
	public WebElement ProspectRemove() {
		base.failedElementName = "Employee-ProspectRemove";
		return driver.findElement(prospectremove);
	}
	//Page object for Prospect Export
	By prospectexport=By.xpath("//mat-checkbox[@formcontrolname='isProspectExport']");
	public WebElement ProspectExport() {
		base.failedElementName = "Employee-ProspectExport";
		return driver.findElement(prospectexport);
	}
	//Page object for Prospect Follow Up
	By prospectfollowup=By.xpath("//mat-checkbox[@formcontrolname='isProspectFollowUpEntry']");
	public WebElement ProspectFollowUp() {
		base.failedElementName = "Employee-Prospectfollowup";
		return driver.findElement(prospectfollowup);
	}

	//Page object for Booking
	//Page object for Booking Select Btn
	By bookingseletbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/vex-roles-form/"
			+ "form/mat-dialog-content/div[9]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement BookingSelectBtn() {
		base.failedElementName = "Employee-BookingSelectBtn";
		return driver.findElement(bookingseletbtn);
	}
	//Page object for Booking Entry
	By bookingview=By.xpath("//mat-checkbox[@formcontrolname='isBookingsView']");
	public WebElement BookingView() {
		base.failedElementName = "Employee-BookingView";
		return driver.findElement(bookingview);
	}
	//Page object for Booking Entry
	By bookingentry=By.xpath("//mat-checkbox[@formcontrolname='isBookingsEntry']");
	public WebElement BookingEntry() {
		base.failedElementName = "Employee-BookingEntry";
		return driver.findElement(bookingentry);
	}
	//Page object for Booking Modify
	By bookingmodify=By.xpath("//mat-checkbox[@formcontrolname='isBookingsUpdate']");
	public WebElement BookingModify() {
		base.failedElementName = "Employee-BookingModify";
		return driver.findElement(bookingmodify);
	}
	//Page object for Booking Remove
	By bookingremove=By.xpath("//mat-checkbox[@formcontrolname='isBookingsDelete']");
	public WebElement BookingRemove() {
		base.failedElementName = "Employee-BookingRemove";
		return driver.findElement(bookingremove);
	}
	//Page object for Booking Export
	By bookingexport=By.xpath("//mat-checkbox[@formcontrolname='isBookingsExport']");
	public WebElement BookingExport() {
		base.failedElementName = "Employee-BookingExport";
		return driver.findElement(bookingexport);
	}
	//Page object for Allow Booking	
	By allowbooking=By.xpath("//mat-checkbox[@formcontrolname='isBookingsAllow']");
	public WebElement AllowBooking() {
		base.failedElementName = "Employee-allowbooking";
		return driver.findElement(allowbooking);
	}
	//Page object for Approve Reject	
	By approvereject=By.xpath("//mat-checkbox[@formcontrolname='isBookingsApproveOrReject']");
	public WebElement ApproveReject() {
		base.failedElementName = "Employee-approveeject";
		return driver.findElement(approvereject);
	}
	//Page object for Legal Entry	
	By legalentry=By.xpath("//mat-checkbox[@formcontrolname='isBookingsLegalEntry']");
	public WebElement LegalEntry() {
		base.failedElementName = "Employee-LegalEntry";
		WebElement element = driver.findElement(legalentry);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

	//Page object for Document
	//Page object for Document Select Btn
	By documentselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/vex-roles-form"
			+ "/form/mat-dialog-content/div[10]/div/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement DocumentSelectbtn() {
		base.failedElementName = "Employee-DocumentSelectBtn";
		return driver.findElement(documentselectbtn);
	}
	//Page object for Document View
	By documentview = By.xpath("//mat-checkbox[@formcontrolname='isDocumentView']");
	public WebElement DocumentView() {
		base.failedElementName = "Employee-DocumentView";
		return driver.findElement(documentview);
	}

	//Page object for Document Entry
	By documententry = By.xpath("//mat-checkbox[@formcontrolname='isDocumentEntry']");
	public WebElement DocumentEntry() {
		base.failedElementName = "Employee-DocumentEntry";
		return driver.findElement(documententry);
	}
	//Page object for Document Modify
	By documentmodify=By.xpath("//mat-checkbox[@formcontrolname='isDocumentUpdate']");
	public WebElement DocumentModify() {
		base.failedElementName = "Employee-DocumentModify";
		return driver.findElement(documentmodify);
	}
	//Page object for Document Remove
	By documentremove = By.xpath("//mat-checkbox[@formcontrolname='isDocumentDelete']");
	public WebElement DocumentRemove() {
		base.failedElementName = "Employee-DocumentRemove";
		return driver.findElement(documentremove);
	}
	//Page object for Document Export
	By documentexport = By.xpath("//mat-checkbox[@formcontrolname='isDocumentExport']");
	public WebElement DocumentExport() {
		base.failedElementName = "Employee-DocumentExport";
		return driver.findElement(documentexport);
	}
	//Page object for Create Button
	By createbtn1 = By.xpath("//button[@class='btn-dark mdc-button mat-mdc-button mdc-button--unelevated "
			+ "mat-mdc-unelevated-button mat-primary mat-mdc-button-base']");
	public WebElement CreateBtn1() {
		base.failedElementName = "Employee-Createbtn1";
		return driver.findElement(createbtn1);
	}

	//Page object for Update Button
	By updatebtn = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/mat-dialog-actions/button[2]");
	public WebElement getUpdate() {
		base.failedElementName = "Employee-UpdateBtn";
		return driver.findElement(updatebtn);
	}

	//Page object for Search
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		base.failedElementName = "Employee-Search";
		return driver.findElement(Search);
	}
	//Page object for Edit Employee
	By editemployee=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "app-employees/div/div[2]/div/div/div[2]/ul/li[4]/a/mat-icon");
	public WebElement getEdit() {
		base.failedElementName = "Employee-EditEmployee";
		return driver.findElement(editemployee);
	}	
	//Page object for Edit Employee
	By editemployee1=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-employees/div/div[2]/div/div/div[2]/ul/li[4]/a");
	                          
	public WebElement getEdit1() {
		base.failedElementName = "Employee-EditEmployee1";
		return driver.findElement(editemployee1);
	}

	//Page object for Active Employee
	By activeemployee=By.xpath("//mat-checkbox[@formcontrolname='isActive']");
	public WebElement getActiveEmployee() {
		WebElement element = driver.findElement(activeemployee);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		base.failedElementName = "Employee-getActiveEmployee";
		return element;
	}		
		
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-employees/div/div[1]/div[2]/div[3]/button");
	public void Applyfilter(String Filter) {
		WebElement dropdown = driver.findElement(filter);
		dropdown.click();

		base.failedElement = dropdown;
		base.failedElementName = "Employee-Applyfilter";

		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + Filter + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-employees/div/div[1]/div[2]/div[4]/button");
	public WebElement ExporttoExcel() {
		base.failedElementName = "Employee-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}

	//Page object for Delete Employee
	By deleteemp=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-employees/div/div[2]/div/div/div[2]/ul/li[3]/a/mat-icon");
	public WebElement deleteEmployee() {
		base.failedElementName = "Employee-Delete";
		return driver.findElement(deleteemp);
	}

	//Page object for Click Yes
	By ClickYes = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up"
			+ "/form/mat-dialog-actions/button[1]");
	public WebElement getClickYes() {
		base.failedElementName = "Employee-DeleteYes";
		return driver.findElement(ClickYes);
	}

	//Active Inactive Roles
	//Verify Add Inactive Roles
	//PAge object for Verify Add Inactive Roles
	public void AddInactiveRoles(String name) {
		driver.findElement(By.xpath("//mat-select[@formcontrolname='roleRightId']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText().trim(); 
			if(!b.equalsIgnoreCase(name))
			{
				Assert.assertFalse(false, "Roles is inactive.");
				//System.out.println("Test Failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Verify Add Active Roles
	//Page object for Verify Add Active Roles
	public void AddActiveRoles(String name) {
		driver.findElement(By.xpath("//mat-select[@formcontrolname='roleRightId']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText().trim(); 
			if(b.equalsIgnoreCase(name))
			{
				Assert.assertTrue(true, "Role is Active.");
				System.out.println("Test Pass");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");
					break;
				}	
			}
		}
	}

	//Verify Edit Inactive Roles
	//Page object for Verify Edit Inactive Roles
	public void EditInactiveRoles(String name) {
		driver.findElement(By.xpath("//mat-select[@formcontrolname='roleRightId']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText().trim(); 
			if(!b.equalsIgnoreCase(name))
			{
				Assert.assertFalse(false, "Roles is inactive.");
				//System.out.println("Test Failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Verify Edit Active Roles
	//Page object for Verify Edit Active Roles
	public void EditActiveRoles(String name) {
		driver.findElement(By.xpath("//mat-select[@formcontrolname='roleRightId']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText().trim(); 
			if(b.equalsIgnoreCase(name))
			{
				Assert.assertTrue(true, "Role is Active.");
				System.out.println("Test Pass");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");
					break;
				}	
			}
		}
	}
	
	// Page object for Active and Inactive button
	By activeInactivebtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-employees/div/div[1]/div[2]/div[1]");

	public WebElement getactiveInactivebtn() {
		base.failedElementName = "Employee-Active Inactive button";
		return driver.findElement(activeInactivebtn);
	}
}