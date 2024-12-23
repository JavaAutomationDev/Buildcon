package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class RoleRightsPage {
	public WebDriver driver;

	public RoleRightsPage(WebDriver driver) {
		this.driver = driver;
	}

	//Inquiry Module
	//Page object for click Inquiry Module
	By Inquiry = By.xpath("//vex-sidenav-item[2]//a[1]");
	public WebElement getInquiry() {
		base.failedElementName = "Inquiry-InquiryMenu";
		return driver.findElement(Inquiry);
	}
	//Page object for Add Inquiry Button
	By AddInquiry = By.xpath("//span[contains(text(),'Add New Inquiry')]");
	public WebElement getaddInquiry() {
		base.failedElementName = "Inquiry-Add";
		return driver.findElement(AddInquiry);	
	}
	//Page object for Edit Inquiry Button
	By Edit = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquires/div/div[2]/"
					+ "div/mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[14]/div/a[1]");
	public WebElement getEdit() {
		base.failedElementName = "Inquiry-Edit";
		return driver.findElement(Edit);
	}
	//Page object for Inquiry Delete Button
	By deleteinquiry =By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-inquires/div/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[14]/div/a[2]");
	public WebElement getInquiryDelete() {
		base.failedElementName = "Inquiry-Delete";	
		return driver.findElement(deleteinquiry);
	}
	//Page object for Export Excel Inquiry
	By ExportExcelInquiry=By.xpath("//html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-inquires/div/div[1]/div[2]/button[1]");
	public WebElement getInquiryExport() {
		base.failedElementName = "Inquiry-ExportExcel";
		return driver.findElement(ExportExcelInquiry);
	}

	//Prospect Module
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
	//Page object for Edit Prospect Button
	public WebElement getEditProspect() {
		WebElement Edit = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
				+ "mat-sidenav-container/mat-sidenav-content/main/vex-prospect/vex-inquires/div/div[2]/div/"
				+ "mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[15]/div/a[1]"));

		base.failedElement = Edit;
		base.failedElementName = "Edit-Prospect";
		return Edit;
	}
	//Page object for Delete Button
	By deleteprospect =By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
					+ "mat-sidenav-content/main/vex-prospect/vex-inquires/div/div[2]/div/"
					+ "mat-tab-group/div/mat-tab-body[1]/div/div/div/table/tbody/tr[1]/td[15]/div/a[2]");
	public WebElement getDeleteProspect() {
		base.failedElementName = "Delete-Prospect";
		return driver.findElement(deleteprospect);
	}
	//Page object for Export Excel Prospect
	By ExportExcelProspect=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-prospect/vex-inquires/div/div[1]/div[2]/button[1]");
	public WebElement getExportExcelProspect() {
		base.failedElementName = "Prospect-ExportExcel";
		return driver.findElement(ExportExcelProspect);
	}

	//Project Module
	//Page object for Project Module
	By Project=By.xpath("//vex-sidenav-item[4]//a[1]");
	public WebElement getproject() {
		base.failedElementName = "Project-ProjectMenu";
		return driver.findElement(Project);
	}
	//Page object for Add Project
	By AddProject=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-projects/div/div[1]/div[2]/button");
	public WebElement getaddproject() {
		base.failedElementName = "Project-AddProject";
		return driver.findElement(AddProject);
	}
	//Page object for Edit Project Button
	By Editproject = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-projects/div/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[2]");
	public WebElement getEditProject() {
		base.failedElementName = "Project-Edit";
		return driver.findElement(Editproject);
	}
	//Page object for Delete Project
	By DeleteProject=By.xpath("//button[@mattooltip='Delete Project']");	
	public WebElement getDeleteproject() {
		base.failedElementName = "Project-Delete";
		return driver.findElement(DeleteProject);
	}
	//Page object for Export to Excel Project
	By ExporttoExcelproject=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/app-projects/div/div[1]/div[2]/div[2]/button");
	public WebElement getExporttoExcelProject() {
		base.failedElementName = "Project-ExportExcel";
		return driver.findElement(ExporttoExcelproject);
	}

	//Booking Module
	//Page object for click Booking module
	By booking = By.xpath("//vex-sidenav-item[5]//a[1]");
	public WebElement getBooking() {
		base.failedElementName = "Booking-BookingMenu";
		return driver.findElement(booking);
	}
	//Page object for Add Booking Module
	By addbooking = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/button");
	public WebElement getAddBooking() {
		base.failedElementName = "Booking-AddBooking";
		return driver.findElement(addbooking);
	}
	//Page object for Edit Button Booking
	By EditBooking = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-bookings/div/div[3]/div/div/table/tbody/tr[1]/td[10]/div/a[1]");
	public WebElement getEditBooking() {
		return driver.findElement(EditBooking);
	}	
	//Page object for Export Excel Booking
	By ExportExcelBooking=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/div[2]/button");
	public WebElement getExportExcelBooking() {
		base.failedElementName = "Booking-ExportExcel";
		return driver.findElement(ExportExcelBooking);	
	}
	
	//Customer Module
	//Page object for click Customer module
	By Customer = By.xpath("//vex-sidenav-item[6]//a[1]");
	public WebElement getCustomer() {
		base.failedElementName = "Customer-CustomerModule";
		return driver.findElement(Customer);
	}
	
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-members/div/div[1]/div[2]/div[2]/button");
	public WebElement getExporttoExcel() {
		base.failedElementName = "Customer-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}

	//Receipt Module
	//Page object for Receipt Module
	By receipt = By.xpath("//vex-sidenav-item[7]//a[1]");
	public WebElement getReceipt() {
		base.failedElementName = "Receipt-ClickMenu";
		return driver.findElement(receipt);
	}
	//Page object for Add Receipt Button
	By Addreceipt = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/button");
	public WebElement getAddReceipt() {
		base.failedElementName = "Receipt-ClickAdd";
		return driver.findElement(Addreceipt);
	}
	//Page object for Edit Receipt
	public WebElement getEditReceipt() {
		WebElement Edit = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
				+ "mat-sidenav-container/mat-sidenav-content/main/vex-receipts/"
				+ "div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[1]"));
		base.failedElementName = "Receipt-Edit";
		return Edit;
	}
	//Page object for Export Excel Receipt
	By ExportExcelreceipt=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/div/div[3]/button");
	public WebElement getExportExcelreceipt() {
		base.failedElementName = "Receipt-ExportExcel";
		return driver.findElement(ExportExcelreceipt);
	}
	
	//Employee Module
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
	//Page object for Edit Employee
	By editemployee=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "app-employees/div/div[2]/div/div/div[2]/ul/li[4]/a/mat-icon");
	public WebElement getEditEmployee() {
		base.failedElementName = "Employee-EditEmployee";
		return driver.findElement(editemployee);
	}
	//Page object for Export Excel Employee
	By ExportExcelEmployee=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-employees/div/div[1]/div[2]/div[4]/button");
	public WebElement ExportExcelEmployee() {
		base.failedElementName = "Employee-ExportExcel";
		return driver.findElement(ExportExcelEmployee);
	}

	//Collection Module
	//Page object for click Collection Module
	By Collection = By.xpath("//vex-sidenav-item[8]//a[1]");
	public WebElement getcollection() {
		base.failedElementName = "Collection-clickcollection";
		return driver.findElement(Collection);
	}
	//Page object for Export Excel Collecction
	By ExportExcelCollecction=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/vex-collections/div/div[1]/div[2]/div[2]/div[4]/button");
	public WebElement getExportExcelCollecction() {
		base.failedElementName = "Collection-ExportExcel";
		return driver.findElement(ExportExcelCollecction);
	}

	//Document Module
	//Page object for Document Module
	By document = By.xpath("//vex-sidenav-item[10]//a[1]");
	public WebElement getDocument() {
		base.failedElementName = "Document-DocumentModule";
		return driver.findElement(document);
	}
	//Page object for Add Document Module
	By Adddocument = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[1]/div[2]/button");
	public WebElement getAddDocument() {
		base.failedElementName = "Document-AddDocument";
		return driver.findElement(Adddocument);
	}
	//Page object for Edit Document
	By editDocument = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[2]/div/div/table/tbody/tr[1]/td[5]/div/a[1]");
	public WebElement getEditDocument() {
		base.failedElementName = "Document-Edit";
		return driver.findElement(editDocument);
	}
	//Page object for Delete Document
	By deleteDocument = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[2]/div/div/table/tbody/tr[1]/td[5]/div/a[2]");
	public WebElement getDeleteDocument() {
		base.failedElementName = "Document-Delete";
		return driver.findElement(deleteDocument);
	}
	//Page object for View Document
	By viewdocumnet = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[2]/div/div/table/tbody/tr[1]/td[5]/div/a[3]");
	public WebElement getViewDocument() {
		base.failedElementName = "Document-View";
		return driver.findElement(viewdocumnet);
	}	
}