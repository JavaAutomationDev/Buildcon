package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Rolepage {

	public WebDriver driver;

	public Rolepage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}

	//Page object model for Click on the role
	By Roleclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[13]/div/mat-icon");
	public WebElement getRoleclick() {
		base.failedElementName = "Role-Roleclick";
		return driver.findElement(Roleclick);
	}

	//Page object model for add role data
	By addnewrole = By.xpath(
			"//span[contains(text(),'add Role')]");
	public WebElement getaddnewrole() {
		base.failedElementName = "Role-addNewRole";
		return driver.findElement(addnewrole);
	}

	//Page object model for Add role data
	By addrolename = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
					+ "mat-dialog-content/form/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getaddrolename() {
		base.failedElementName = "Role-RoleName";
		return driver.findElement(addrolename);
	}

	//Page object model for Add role data
	By showphonenumberchecked = By.xpath(
			"//mat-checkbox[@formcontrolname='isMobileShow']");
	public WebElement getshowphonenumberchecked() {
		base.failedElementName = "Role-ShowPhoneChecked";
		return driver.findElement(showphonenumberchecked);
	}

	//Page object for Create Button
	By clickcreate = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-actions/button[2]");
	public WebElement getclickcreate() {
		base.failedElementName = "Role-clickcreate";
		return driver.findElement(clickcreate);
	}

	//Page object model for edit the role page
	By EditRolebuttonclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[2]/div/table/tbody/tr/td[3]/div/button[2]");
	public WebElement getEditRolebuttonclick() {
		base.failedElementName = "Role-Editclick";
		return driver.findElement(EditRolebuttonclick);
	}

	//Page object model for add new data and clear existing data;
	By updateEditrole = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
					+ "mat-dialog-content/form/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getupdateEditrole() {
		base.failedElementName = "Role-updateEdit";
		return driver.findElement(updateEditrole);
	}

	//Page object model for edit save button :
	By editsavebuttonrole = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-actions/button[2]");
	public WebElement geteditsavebuttonrole() {
		base.failedElementName = "Role-EditSave";
		return driver.findElement(editsavebuttonrole);
	}
	
	By editsavebuttonroleptionsecond = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-actions/button[2]");
	public WebElement geteditsavebuttonroleptionsecond() {
		return driver.findElement(editsavebuttonroleptionsecond);
	}

	//Page object model for change status button click :
	By Rolestatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[2]/div/table/tbody/tr/td[3]/div/button[1]");
	public WebElement getRolestatusclick() {
		base.failedElementName = "Role-StatuClick";
		return driver.findElement(Rolestatusclick);
	}

	//Page object model for change status button click :
	By Rolestatusclickconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getRolestatusclickconfirm() {
		base.failedElementName = "Role-StatusConfirm";
		return driver.findElement(Rolestatusclickconfirm);
	}

	//Pom for delete click:
	By deleteclickRole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[2]/div/table/tbody/tr/td[3]/div/button[3]");
	public WebElement getdeleteclickRole() {
		base.failedElementName = "Role-DeleteClick";
		return driver.findElement(deleteclickRole);
	}

	//Pom for delete click confirmation:
	By deleteclickconfirmationRole = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getdeleteclickconfirmationRole() {
		base.failedElementName = "Role-DeleteConfirm";
		return driver.findElement(deleteclickconfirmationRole);
	}

	//Page object model for searching of project types:
	By searchRole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-roles/div/div[1]/div[2]/div[1]/input");
	public WebElement getsearchRole() {
		base.failedElementName = "Role-Search";
		return driver.findElement(searchRole);
	}

	//POM for Click search role
	By clicksearchrole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-roles/div/div[1]/div[2]/div[1]/mat-icon");
	public WebElement getclicksearchrole() {
		base.failedElementName = "Role-SearchClick";
		return driver.findElement(clicksearchrole);
	}

	//POM for click export role
	By clickexportasexcelRole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-roles/div/div[1]/div[2]/div[2]/button");
	public WebElement getclickexportasexcelRole() {
		base.failedElementName = "Role-ExportExcel";
		return driver.findElement(clickexportasexcelRole);
	}

	//Page object for Active Inactive Role status
	By activeinactiveroles = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-"
			+ "add/div/mat-dialog-content/form/div/div[2]/mat-checkbox/div/div");
	public WebElement getActiveInactiveRoles() {
		return driver.findElement(activeinactiveroles);
	}

	//Page object for select Employee All Radiobtn
	By empallselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div/div[2]/mat-radio-group/mat-radio-button[1]");
	
	public WebElement EmpAllselectbtn() {
		return driver.findElement(empallselectbtn);
	}
	
	//Page object for select Project All Radiobtn
	By projectallselectbtn= By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-roles-add[1]/div[1]/vex-roles-form[1]/form[1]/mat-dialog-content[1]/div[3]/div[1]/div[2]/mat-radio-group[1]/mat-radio-button[1]\r\n"
			+ "");
	public WebElement ProjectAllselectbtn() {
		return driver.findElement(projectallselectbtn);
	}

	//Page object for select Receipt All Radio btn
	By receiptallselectbtn= By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-roles-add[1]/div[1]/vex-roles-form[1]/form[1]/mat-dialog-content[1]/div[4]/div[1]/div[2]/div[1]/mat-radio-group[1]/mat-radio-button[1]\r\n"
			+ "");
	public WebElement ReceiptAllselectbtn() {
		return driver.findElement(receiptallselectbtn);
	}
	//Page object for select Collection All Radio btn
	By collectionallselectbtn= By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-roles-add[1]/div[1]/vex-roles-form[1]/form[1]/mat-dialog-content[1]/div[5]/div[1]/div[2]/div[1]/mat-radio-group[1]/mat-radio-button[1]\r\n"
			+ "");
	public WebElement ColectionAllselectbtn() {
		return driver.findElement(collectionallselectbtn);
	}

	//Page object for select Customer All Radio btn
	By customerallselectbtn= By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-roles-add[1]/div[1]/vex-roles-form[1]/form[1]/mat-dialog-content[1]/div[6]/div[1]/div[2]/div[1]/mat-radio-group[1]/mat-radio-button[1]\r\n"
			+ "");
	public WebElement CustomerAllselectbtn() {
		return driver.findElement(customerallselectbtn);
	}

	//Page object for select Inquiry All Radio btn
	By inquiryallselectbtn= By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-roles-add[1]/div[1]/vex-roles-form[1]/form[1]/mat-dialog-content[1]/div[7]/div[1]/div[2]/div[1]/mat-radio-group[1]/mat-radio-button[1]");
	public WebElement InquiryAllselectbtn() {
		return driver.findElement(inquiryallselectbtn);
	}			
	//Page object for select Prospect All Radio btn
		By prospectallselectbtn= By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-roles-add[1]/div[1]/vex-roles-form[1]/form[1]/mat-dialog-content[1]/div[8]/div[1]/div[2]/div[1]/mat-radio-group[1]/mat-radio-button[1]");
		public WebElement ProspectAllselectbtn() {
			return driver.findElement(prospectallselectbtn);
		}			
		
		//Page object for select booking All Radio btn
		By bookingallselectbtn= By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-roles-add[1]/div[1]/vex-roles-form[1]/form[1]/mat-dialog-content[1]/div[9]/div[1]/div[2]/div[1]/mat-radio-group[1]/mat-radio-button[1]");
		public WebElement BookingAllselectbtn() {
			return driver.findElement(bookingallselectbtn);
		}			
		
		//Page object for select Document All Radio btn
		By documentallselectbtn= By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-roles-add[1]/div[1]/vex-roles-form[1]/form[1]/mat-dialog-content[1]/div[10]/div[1]/div[2]/div[1]/mat-radio-group[1]/mat-radio-button[1]");
		public WebElement documentAllselectbtn() {
			return driver.findElement(documentallselectbtn);
		}			
	

		
	//Page object for Employee Select Btn
	By empselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div[1]/div[2]/mat-radio-group/mat-radio-button[2]");
	public WebElement EmpSelectbtn() {
		return driver.findElement(empselectbtn);
	}
	//Page object for Employee Role View
	By emproleview= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeView']");
	public WebElement EmpRoleView() {
		return driver.findElement(emproleview);
	}
	//Page object for Employee Role Entry
	By emproleentry= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeEntry']");
	public WebElement EmpRoleEntry() {
		return driver.findElement(emproleentry);
	}
	//Page object for Employee Role Update
	By emproleupdate= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeUpdate']");
	public WebElement EmpRoleUpdate() {
		return driver.findElement(emproleupdate);
	}
	//Page object for Employee Role Delete
	By emproledelete= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeDelete']");
	public WebElement EmpRoleDelete() {
		return driver.findElement(emproledelete);
	}
	//Page object for Employee Role Export
	By emproleexport= By.xpath("//mat-checkbox[@formcontrolname='isEmployeeExport']");
	public WebElement EmpRoleExport() {
		return driver.findElement(emproleexport);
	}
	
	//Page object for Project Select Btn
	By projectselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div[1]/div[2]/mat-radio-group/mat-radio-button[2]");
	public WebElement Projectselectbtn() {
		return driver.findElement(projectselectbtn);
	}
	//Page object for Project Role View
	By projectroleview= By.xpath("//mat-checkbox[@formcontrolname='isProjectView']");
	public WebElement ProjectRoleView() {
		return driver.findElement(projectroleview);
	}
	//Page object for Project Role Entry
	By projectroleentry= By.xpath("//mat-checkbox[@formcontrolname='isProjectEntry']");
	public WebElement ProjectRoleEntry() {
		return driver.findElement(projectroleentry);
	}
	//Page object for Project Role Update
	By projectroleupdate= By.xpath("//mat-checkbox[@formcontrolname='isProjectUpdate']");
	public WebElement ProjectRoleUpdate() {
		return driver.findElement(projectroleupdate);
	}
	//Page object for Project Role Delete
	By projectroledelete= By.xpath("//mat-checkbox[@formcontrolname='isProjectDelete']");
	public WebElement ProjectRoleDelete() {
		return driver.findElement(projectroledelete);
	}
	//Page object for Project Role Export
	By projectroleexport= By.xpath("//mat-checkbox[@formcontrolname='isProjectExport']");
	public WebElement ProjectRoleExport() {
		return driver.findElement(projectroleexport);
	}
	
	//Page object for Receipt Select Btn
	By receiptselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement Receiptselectbtn() {
		return driver.findElement(receiptselectbtn);
	}
	//Page object for Receipt Role View
	By receiptroleview= By.xpath("//mat-checkbox[@formcontrolname='isReceiptView']");
	public WebElement ReceiptRoleView() {
		return driver.findElement(receiptroleview);
	}
	//Page object for Receipt Role Entry
	By receiptroleentry= By.xpath("//mat-checkbox[@formcontrolname='isReceiptEntry']");
	public WebElement ReceiptRoleEntry() {
		return driver.findElement(receiptroleentry);
	}
	//Page object for Receipt Role Update
	By receiptroleupdate= By.xpath("//mat-checkbox[@formcontrolname='isReceiptUpdate']");
	public WebElement ReceiptRoleUpdate() {
		return driver.findElement(receiptroleupdate);
	}
	//Page object for Receipt Role Delete
	By receiptroledelete= By.xpath("//mat-checkbox[@formcontrolname='isReceiptDelete']");
	public WebElement ReceiptRoleDelete() {
		return driver.findElement(receiptroledelete);
	}
	//Page object for Receipt Role Export
	By receiptroleexport= By.xpath("//mat-checkbox[@formcontrolname='isReceiptExport']");
	public WebElement ReceiptRoleExport() {
		return driver.findElement(receiptroleexport);
	}
	
	//Page object for Collection Select Btn
	By collectionselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[5]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement Collectionselectbtn() {
		return driver.findElement(collectionselectbtn);
	}
	//Page object for Collection Role View
	By collectionroleview= By.xpath("//mat-checkbox[@formcontrolname='isCollectionView']");
	public WebElement CollectionRoleView() {
		return driver.findElement(collectionroleview);
	}
	//Page object for Collection Role Export
	By collectionroleexport= By.xpath("//mat-checkbox[@formcontrolname='isCollectionExport']");
	public WebElement CollectionRoleExport() {
		return driver.findElement(collectionroleexport);
	}

	//Page object for Customer Select Btn
	By customerselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[6]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement Customerselectbtn() {
		return driver.findElement(customerselectbtn);
	}
	//Page object for Customer Role View
	By customerroleview= By.xpath("//mat-checkbox[@formcontrolname='isMemberView']");
	public WebElement CustomerRoleView() {
		return driver.findElement(customerroleview);
	}
	//Page object for Customer Role Export
	By customerroleexport= By.xpath("//mat-checkbox[@formcontrolname='isMemberExport']");
	public WebElement CustomerRoleExport() {
		return driver.findElement(customerroleexport);
	}
	
	//Page object for Inquiry Select Btn
	By inquiryselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[7]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement Inquiryselectbtn() {
		return driver.findElement(inquiryselectbtn);
	}
	//Page object for Inquiry Role View
	By inquiryroleview= By.xpath("//mat-checkbox[@formcontrolname='isInquiryView']");
	public WebElement InquiryRoleView() {
		return driver.findElement(inquiryroleview);
	}
	//Page object for Inquiry Role Entry
	By inquiryroleentry= By.xpath("//mat-checkbox[@formcontrolname='isInquiryEntry']");
	public WebElement InquiryRoleEntry() {
		return driver.findElement(inquiryroleentry);
	}
	//Page object for Inquiry Role Update
	By inquiryroleupdate= By.xpath("//mat-checkbox[@formcontrolname='isInquiryUpdate']");
	public WebElement InquiryRoleUpdate() {
		return driver.findElement(inquiryroleupdate);
	}
	//Page object for Inquiry Role Delete
	By inquiryroledelete= By.xpath("//mat-checkbox[@formcontrolname='isInquiryDelete']");
	public WebElement InquiryRoleDelete() {
		return driver.findElement(inquiryroledelete);
	}
	//Page object for Inquiry Role Export
	By inquiryroleexport= By.xpath("//mat-checkbox[@formcontrolname='isInquiryExport']");
	public WebElement InquiryRoleExport() {
		return driver.findElement(inquiryroleexport);
	}
	//Page object for Inquiry Role FollowUp
	By inquiryrolefollowup= By.xpath("//mat-checkbox[@formcontrolname='isInquiryFollowUpEntry']");
	public WebElement InquiryRoleFollowUp() {
		return driver.findElement(inquiryrolefollowup);
	}
	
	//Page object for Prospect Select Btn
	By prospectselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[8]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement Prospectselectbtn() {
		return driver.findElement(prospectselectbtn);
	}
	//Page object for Prospect Role View
	By prospectroleview= By.xpath("//mat-checkbox[@formcontrolname='isProspectView']");
	public WebElement ProspectRoleView() {
		return driver.findElement(prospectroleview);
	}
	//Page object for Prospect Role Entry
	By prospectroleentry= By.xpath("//mat-checkbox[@formcontrolname='isProspectEntry']");
	public WebElement ProspectRoleEntry() {
		return driver.findElement(prospectroleentry);
	}
	//Page object for Prospect Role Update
	By prospectroleupdate= By.xpath("//mat-checkbox[@formcontrolname='isProspectUpdate']");
	public WebElement ProspectRoleUpdate() {
		return driver.findElement(prospectroleupdate);
	}
	//Page object for Prospect Role Delete
	By prospectroledelete= By.xpath("//mat-checkbox[@formcontrolname='isProspectDelete']");
	public WebElement ProspectRoleDelete() {
		return driver.findElement(prospectroledelete);
	}
	//Page object for Prospect Role Export
	By prospectroleexport= By.xpath("//mat-checkbox[@formcontrolname='isProspectExport']");
	public WebElement ProspectRoleExport() {
		return driver.findElement(prospectroleexport);
	}
	//Page object for Prospect Role FollowUp
	By prospectrolefollowup= By.xpath("//mat-checkbox[@formcontrolname='isProspectFollowUpEntry']");
	public WebElement ProspectRolefollowUp() {
		return driver.findElement(prospectrolefollowup);
	}
	
	//Page object for Bookings Select Btn
	By bookingselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[9]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement Bookingselectbtn() {
		return driver.findElement(bookingselectbtn);
	}
	//Page object for Bookings Role View
	By bookingroleview= By.xpath("//mat-checkbox[@formcontrolname='isBookingsView']");
	public WebElement BookingRoleView() {
		return driver.findElement(bookingroleview);
	}
	//Page object for Bookings Role Entry
	By bookingroleentry= By.xpath("//mat-checkbox[@formcontrolname='isBookingsEntry']");
	public WebElement BookingRoleEntry() {
		return driver.findElement(bookingroleentry);
	}
	//Page object for Bookings Role Update
	By bookingroleupdate= By.xpath("//mat-checkbox[@formcontrolname='isBookingsUpdate']");
	public WebElement BookingRoleUpdate() {
		return driver.findElement(bookingroleupdate);
	}
	//Page object for Bookings Role Delete
	By bookingroledelete= By.xpath("//mat-checkbox[@formcontrolname='isBookingsDelete']");
	public WebElement BookingRoleDelete() {
		return driver.findElement(bookingroledelete);
	}
	//Page object for Bookings Role Export
	By bookingroleexport= By.xpath("//mat-checkbox[@formcontrolname='isBookingsExport']");
	public WebElement BookingRoleExport() {
		return driver.findElement(bookingroleexport);
	}
	//Page object for Bookings Role AllowBooking
	By bookingroleallowbooking= By.xpath("//mat-checkbox[@formcontrolname='isBookingsAllow']");
	public WebElement BookingRoleAllowBooking() {
		return driver.findElement(bookingroleallowbooking);
	}
	//Page object for Bookings Role Approve/Reject
	By bookingroleapprovereject= By.xpath("//mat-checkbox[@formcontrolname='isBookingsApproveOrReject']");
	public WebElement BookingRoleApproveReject() {
		return driver.findElement(bookingroleapprovereject);
	}
	//Page object for Bookings Role LegalEntry
	By bookingrolelegalentry= By.xpath("//mat-checkbox[@formcontrolname='isBookingsLegalEntry']");
	public WebElement BookingRoleLegalEntry() {
		return driver.findElement(bookingrolelegalentry);
	}
	
	//Page object for Documents Select Btn
	By documentselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[10]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]");
	public WebElement Documentselectbtn() {
		return driver.findElement(documentselectbtn);
	}
	//Page object for Documents Role View
	By documentsroleview= By.xpath("//mat-checkbox[@formcontrolname='isDocumentView']");
	public WebElement DocumentsRoleView() {
		return driver.findElement(documentsroleview);
	}
	//Page object for Documents Role Entry
	By documentsroleentry= By.xpath("//mat-checkbox[@formcontrolname='isDocumentEntry']");
	public WebElement DocumentsRoleEntry() {
		return driver.findElement(documentsroleentry);
	}
	//Page object for Documents Role Update
	By documentsroleupdate= By.xpath("//mat-checkbox[@formcontrolname='isDocumentUpdate']");
	public WebElement DocumentsRoleUpdate() {
		return driver.findElement(documentsroleupdate);
	}
	//Page object for Documents Role Delete
	By documentsroledelete= By.xpath("//mat-checkbox[@formcontrolname='isDocumentDelete']");
	public WebElement DocumentsRoleDelete() {
		return driver.findElement(documentsroledelete);
	}
	//Page object for Documents Role Export
	By documentsroleexport= By.xpath("//mat-checkbox[@formcontrolname='isDocumentExport']");
	public WebElement DocumentsRoleExport() {
		return driver.findElement(documentsroleexport);
	}
}