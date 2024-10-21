package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeePage {
	public WebDriver driver;

	public EmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	//Page object for click Employee Module
	By Employee = By.xpath("//vex-sidenav-item[9]//a[1]");
	public WebElement getEmployee() {
		return driver.findElement(Employee);
	}
	//Page object for Add Employee
	By Addemployee = By.xpath("//span[contains(text(),'Add New Employee')]");
	public WebElement getaddemployee() {
		return driver.findElement(Addemployee);
	}
	//Page object for Profile Image
	By profileimg= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[1]/label/input");
	public WebElement getProfileImg() {
		return driver.findElement(profileimg);
	}

	//Page object for First Name
	By firstName= By.xpath("//input[@formcontrolname='firstName']");
	public WebElement getfname() {
		return driver.findElement(firstName);
	}
	//Page object for Middle Name
	By  middleName= By.xpath("//input[@formcontrolname='middleName']");
	public WebElement getmname() {
		return driver.findElement(middleName);
	}
	//Page object for Last Name
	By lastName= By.xpath("//input[@formcontrolname='lastName']");
	public WebElement getlname() {
		return driver.findElement(lastName);
	}
	//Page object for User Name
	By username= By.xpath("//input[@formcontrolname='userName']");
	public WebElement getUserName() {
		return driver.findElement(username);
	}

	//Page object for Designation
	By Designation= By.xpath("//input[@formcontrolname='designation']");
	public WebElement getDesignation() {
		return driver.findElement(Designation);
	}

	//Page object for DOB
	By dob= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/"
			+ "mat-dialog-content/div[2]/div[4]/div/div[3]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getDOB() {
		return driver.findElement(dob);
	}
	//Page object for Email
	By Email= By.xpath("//input[@formcontrolname='email']");
	public WebElement getEmail() {
		return driver.findElement(Email);
	}
	//Page object for Roles
	By Roles= By.xpath("//mat-select[@formcontrolname='roleRightId']");
	public void getRoles(String Role) {
		WebElement dropdown = driver.findElement(Roles);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + Role + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for City
	By City= By.xpath("//input[@formcontrolname='city']");
	public WebElement getcity() {
		return driver.findElement(City);
	}
	//Page object for State
	By state= By.xpath("//mat-select[@formcontrolname='stateId']");
	public void getstate(String State) {
		WebElement dropdown = driver.findElement(state);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + State + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Mobile No
	By mobileno= By.xpath("//input[@formcontrolname='mobile']");
	public WebElement getMobileno() {
		return driver.findElement(mobileno);
	}
	//Page object for Password
	By password= By.xpath("//input[@formcontrolname='password']");
	public WebElement getPassword() {
		return driver.findElement(password);
	}	

	//Page object for Address
	By Address= By.xpath("//textarea[@formcontrolname='address']");
	public WebElement getAddress() {
		return driver.findElement(Address);
	}

	//Page object for Project Access
	By projectaccess= By.xpath("//mat-select[@formcontrolname='projectId']");
	public void getProjectAccess(String Proejct) {
		WebElement dropdown = driver.findElement(projectaccess);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + Proejct + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
		dropdown.sendKeys(Keys.ESCAPE); 
	}

	//Page object for Aadhar Card
	By Adharcard= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[2]/div[8]/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement uploadAdharCard() {
		return driver.findElement(Adharcard);
	}

	//Page object for Pan Card
	By Pancard= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[2]/div[8]/div/div[2]/mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement getPancard() {
		return driver.findElement(Pancard);
	}
	//Page object for Select Gender
	By Gender= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[3]/div[1]/mat-radio-group/mat-radio-button[1]/div/label");
	public WebElement SelectGender() {
		return driver.findElement(Gender);
	}
	//Page object for Next Button
	By Nextbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/mat-dialog-actions/button[2]");
	public WebElement Nextbtn() {
		return driver.findElement(Nextbtn);
	}	
	//Page object for Show Phone Number
	By shownumber= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles"
			+ "/div/vex-roles-form/form/mat-dialog-content/div[1]/div/mat-checkbox/div/div/input");
	public WebElement Shownumber() {
		return driver.findElement(shownumber);
	}

	//Page object for Employee Radio Btn
	By empradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div/div[2]/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Empradiobtn() {
		return driver.findElement(empradiobtn);
	}
	//Page object for Project Radio Btn
	By projectradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div/div[2]/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Projectradiobtn() {
		return driver.findElement(projectradiobtn);
	}
	//Page object for Receipt Radio Btn
	By receiptradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Receiptradiobtn() {
		return driver.findElement(receiptradiobtn);
	}
	//Page object for Collection Radio Btn
	By collectionradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[5]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Collectionradiobtn() {
		return driver.findElement(collectionradiobtn);
	}
	//Page object for Customer Radio Btn
	By customerradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[6]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Customerradiobtn() {
		return driver.findElement(customerradiobtn);
	}
	//Page object for Inquiry Radio Btn
	By inquiryradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[7]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Inquiryradiobtn() {
		return driver.findElement(inquiryradiobtn);
	}
	//Page object for Prospect Radio Btn
	By prospectradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[8]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Prospectradiobtn() {
		return driver.findElement(prospectradiobtn);
	}
	//Page object for Bookings Radio Btn
	By bookingradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[9]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Bookingsradiobtn() {
		return driver.findElement(bookingradiobtn);
	}
	//Page object for Documents Radio Btn
	By documentradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[10]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Documentsradiobtn() {
		return driver.findElement(documentradiobtn);
	}
	//Page object for Create Btn
	By createbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/"
			+ "div/app-employee-roles/div/mat-dialog-actions/button[1]");
	public WebElement Createbtn() {
		return driver.findElement(createbtn);
	}

	//Add Employee with All Modules - Only View
	//Page object for Employee Select Btn
	By empselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div[1]/div[2]/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement EmpSelectbtn() {
		return driver.findElement(empselectbtn);
	}
	//Page object for Employee Entry
	By empentry= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeEntry']");
	public WebElement EmpEntry() {
		return driver.findElement(empentry);
	}
	//Page object for Employee Modify
	By empmodify= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeUpdate']");
	public WebElement EmpModify() {
		return driver.findElement(empmodify);
	}
	//Page object for Employee Remove
	By empremove= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeDelete']");
	public WebElement EmpRemove() {
		return driver.findElement(empremove);
	}
	//Page object for Employee Export
	By empexport= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeExport']");
	public WebElement EmpExport() {
		return driver.findElement(empexport);
	}

	//Page object for Project Select Btn
	By projectselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div[1]/div[2]/mat-radio-group/mat-radio-button[2]");
	public WebElement Projectselectbtn() {
		return driver.findElement(projectselectbtn);
	}
	//Page object for Project Entry
	By projectentry= By.xpath("//mat-checkbox[@formcontrolname='isProjectEntry']");
	public WebElement ProjectEntry() {
		return driver.findElement(projectentry);
	}
	//Page object for Project Modify
	By projectmodify= By.xpath("//mat-checkbox[@formcontrolname='isProjectUpdate']");
	public WebElement ProjectModify() {
		return driver.findElement(projectmodify);
	}
	//Page object for Project Remove
	By projectremove= By.xpath("//mat-checkbox[@formcontrolname='isProjectDelete']");
	public WebElement ProjectRemove() {
		return driver.findElement(projectremove);
	}
	//Page object for Project Export
	By projectexport= By.xpath("//mat-checkbox[@formcontrolname='isProjectExport']");
	public WebElement ProjectExport() {
		return driver.findElement(projectexport);
	}

	//Page object for Receipt Select Btn
	By receiptselecbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement Receiptselectbtn() {
		return driver.findElement(receiptselecbtn);
	}
	//Page object for Receipt Entry
	By receiptentry= By.xpath("//mat-checkbox[@formcontrolname='isReceiptEntry']");
	public WebElement ReceiptEntry() {
		return driver.findElement(receiptentry);
	}
	//Page object for Receipt Modify
	By receiptmodify= By.xpath("//mat-checkbox[@formcontrolname='isReceiptUpdate']");
	public WebElement ReceiptModify() {
		return driver.findElement(receiptmodify);
	}
	//Page object for Receipt Remove
	By receiptremove= By.xpath("//mat-checkbox[@formcontrolname='isReceiptDelete']");
	public WebElement ReceiptRemove() {
		return driver.findElement(receiptremove);
	}
	//Page object for Receipt Export
	By receiptexport= By.xpath("//mat-checkbox[@formcontrolname='isReceiptExport']");
	public WebElement ReceiptExport() {
		return driver.findElement(receiptexport);
	}

	//Collection view Page object
	//Page object for Collection Select Btn
	By collectionselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[5]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement Collectionselectbtn() {
		return driver.findElement(collectionselectbtn);
	}

	//Page object for Collection Export
	By collectionexport=By.xpath("//mat-checkbox[@formcontrolname='isCollectionExport']");
	public WebElement CollectionExport() {
		return driver.findElement(collectionexport);
	}

	//Customer View Page object
	//Page object for Customer Select Btn
	By customerselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[6]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement Customerselectbtn() {
		return driver.findElement(customerselectbtn);
	}
	//Page object for Customer Export
	By customerexport = By.xpath("//mat-checkbox[@formcontrolname='isMemberExport']");
	public WebElement CustomerExport() {
		WebElement element = driver.findElement(customerexport);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

	//Inquiry View Page object
	//Page object for Inquiry Select Btn
	By inquiryselectbtn=By.xpath("//*[@id=\"mat-radio-77\"]/div/div/div[3]");
	public WebElement InquirySelectbtn() {
		return driver.findElement(inquiryselectbtn);
	}

	//Page object for Inquiry Entry
	By inquiryentry=By.xpath("//mat-checkbox[@formcontrolname='isInquiryEntry']");
	public WebElement InquiryEntry() {
		return driver.findElement(inquiryentry);
	}

	//Page object for Inquiry Modify
	By inquirymodify=By.xpath("//mat-checkbox[@formcontrolname='isInquiryUpdate']");
	public WebElement InquiryModify() {
		return driver.findElement(inquirymodify);
	}
	//Page object for Inquiry Remove
	By inquiryremove=By.xpath("//mat-checkbox[@formcontrolname='isInquiryDelete']");
	public WebElement InquiryRemove() {
		return driver.findElement(inquiryremove);
	}
	//Page object for Inquiry Export
	By inquiryexport=By.xpath("//mat-checkbox[@formcontrolname='isInquiryExport']");
	public WebElement InquiryExport() {
		return driver.findElement(inquiryexport);
	}		
	//Page object for Inquiry Follow Up
	By inquiryfollowup=By.xpath("//mat-checkbox[@formcontrolname='isInquiryFollowUpEntry']");
	public WebElement InquiryFollowUp() {
		return driver.findElement(inquiryfollowup);
	}
	//Page object for Prospect
	//Page object for Prospect Select Btn
	By prospectselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[8]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement ProspectSelectbtn() {
		return driver.findElement(prospectselectbtn);
	}
	//Page object for Prospect View
	By prospectview=By.xpath("//mat-checkbox[@formcontrolname='isProspectView']");
	public WebElement ProspectView() {
		return driver.findElement(prospectview);
	}

	//Page object for Prospect Entry
	By prospectentry=By.xpath("//mat-checkbox[@formcontrolname='isProspectEntry']");
	public WebElement ProspectEntry() {
		return driver.findElement(prospectentry);

	}
	//Page object for Prospect Modify
	By prospectmodify=By.xpath("//mat-checkbox[@formcontrolname='isProspectUpdate']");
	public WebElement ProspectModify() {
		return driver.findElement(prospectmodify);
	}
	//Page object for Prospect Remove
	By prospectremove=By.xpath("//mat-checkbox[@formcontrolname='isProspectDelete']");
	public WebElement ProspectRemove() {
		return driver.findElement(prospectremove);
	}
	//Page object for Prospect Export
	By prospectexport=By.xpath("//mat-checkbox[@formcontrolname='isProspectExport']");
	public WebElement ProspectExport() {
		return driver.findElement(prospectexport);
	}
	//Page object for Prospect Follow Up
	By prospectfollowup=By.xpath("//mat-checkbox[@formcontrolname='isProspectFollowUpEntry']");
	public WebElement ProspectFollowUp() {
		return driver.findElement(prospectfollowup);
	}

	//Page object for Booking
	//Page object for Booking Select Btn
	By bookingseletbtn=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[9]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement BookingSelectBtn() {
		return driver.findElement(bookingseletbtn);
	}
	//Page object for Booking Entry
	By bookingentry=By.xpath("//mat-checkbox[@formcontrolname='isBookingsEntry']");
	public WebElement BookingEntry() {
		return driver.findElement(bookingentry);
	}
	//Page object for Booking Modify
	By bookingmodify=By.xpath("//mat-checkbox[@formcontrolname='isBookingsUpdate']");
	public WebElement BookingModify() {
		return driver.findElement(bookingmodify);
	}
	//Page object for Booking Remove
	By bookingremove=By.xpath("//mat-checkbox[@formcontrolname='isBookingsDelete']");
	public WebElement BookingRemove() {
		return driver.findElement(bookingremove);
	}
	//Page object for Booking Export
	By bookingexport=By.xpath("//mat-checkbox[@formcontrolname='isBookingsExport']");
	public WebElement BookingExport() {
		return driver.findElement(bookingexport);
	}
	//Page object for Allow Booking	
	By allowbooking=By.xpath("//mat-checkbox[@formcontrolname='isBookingsAllow']");
	public WebElement AllowBooking() {
		return driver.findElement(allowbooking);
	}
	//Page object for Approve Reject	
	By approvereject=By.xpath("//mat-checkbox[@formcontrolname='isBookingsApproveOrReject']");
	public WebElement ApproveReject() {
		return driver.findElement(approvereject);
	}
	//Page object for Legal Entry	
	By legalentry=By.xpath("//mat-checkbox[@formcontrolname='isBookingsLegalEntry']");
	public WebElement LegalEntry() {
		WebElement element = driver.findElement(legalentry);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

	//Page object for Document
	//Page object for Document Select Btn
	By documentselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/vex-roles-form/form/mat-dialog-content/div[10]/div/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement DocumentSelectbtn() {
		return driver.findElement(documentselectbtn);
	}
	//Page object for Document View
	By documentview = By.xpath("//mat-checkbox[@formcontrolname='isDocumentView']");
	public WebElement DocumentView() {
		return driver.findElement(documentview);
	}

	//Page object for Document Entry
	By documententry = By.xpath("//mat-checkbox[@formcontrolname='isDocumentEntry']");
	public WebElement DocumentEntry() {
		return driver.findElement(documententry);
	}
	//Page object for Document Modify
	By documentmodify=By.xpath("//mat-checkbox[@formcontrolname='isDocumentUpdate']");
	public WebElement DocumentModify() {
		return driver.findElement(documentmodify);
	}
	//Page object for Document Remove
	By documentremove = By.xpath("//mat-checkbox[@formcontrolname='isDocumentDelete']");
	public WebElement DocumentRemove() {
		return driver.findElement(documentremove);
	}
	//Page object for Document Export
	By documentexport = By.xpath("//mat-checkbox[@formcontrolname='isDocumentExport']");
	public WebElement DocumentExport() {
		return driver.findElement(documentexport);
	}
	//Page object for Create Button
	By createbtn1 = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/mat-dialog-actions/button[1]");
	public WebElement CreateBtn1() {
		return driver.findElement(createbtn1);
	}

	//Page object for Update Button
	By updatebtn = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/mat-dialog-actions/button[1]");
	public WebElement getUpdate() {
		return driver.findElement(updatebtn);
	}

	//Page object for Search
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		return driver.findElement(Search);
	}
	//Page object for Edit Employee
	By editemployee=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "app-employees/div/div[2]/div/div/div[2]/ul/li[4]/a/mat-icon");
	public WebElement getEdit() {
		return driver.findElement(editemployee);
    }	
	
	//Page object for Active Employee
	By activeemployee=By.xpath("//mat-checkbox[@formcontrolname='isActive']");
	public WebElement getActiveEmployee() {
		WebElement element = driver.findElement(activeemployee);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}
	
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-employees/div/div[1]/div[2]/div[3]/button");
	public void Applyfilter(String Filter) {
		WebElement dropdown = driver.findElement(filter);
		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + Filter + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-employees/div/div[1]/div[2]/div[4]/button");
	public WebElement ExporttoExcel() {
		return driver.findElement(ExporttoExcel);
	}
	
	//Page object for Delete Employee
	By deleteemp=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-employees/div/div[2]/div/div/div[2]/ul/li[3]/a/mat-icon");
	public WebElement deleteEmployee() {
		return driver.findElement(deleteemp);
	}
	
	//Page object for Click Yes
	By ClickYes = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up"
			+ "/form/mat-dialog-actions/button[1]");
	public WebElement getClickYes() {
		return driver.findElement(ClickYes);
	}
}