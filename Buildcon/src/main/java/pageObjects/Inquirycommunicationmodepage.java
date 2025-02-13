package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Inquirycommunicationmodepage {

	public WebDriver driver;

	public Inquirycommunicationmodepage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}

	//Page object model for Click on the inquiry communication mode page
	By Inquirycommunicationmodepageclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[11]/div/mat-icon");
	public WebElement getInquirycommunicationmodepageclick() {
		base.failedElementName = "InquiryCommunicationMode-MenuClick";
		return driver.findElement(Inquirycommunicationmodepageclick);
	}

	//Page object model for add inquiry communication mode data
	By Inquirycommunicationmodeadd  = By.xpath(
			"//span[contains(text(),'Add New Inquiry Communication Mode')]");
	public WebElement getInquirycommunicationmodeadd() {
		base.failedElementName = "InquiryCommunicationMode-ClickAdd";
		return driver.findElement(Inquirycommunicationmodeadd);
	}

	//Page object model for Add New Inquiry Communication Mode
	By AddNewInquiryCommunicationMode = By.xpath(
			"//input[@formcontrolname='inqCommModeName']");
	public WebElement getAddNewInquiryCommunicationMode() {
		base.failedElementName = "InquiryCommunicationMode-Name";
		return driver.findElement(AddNewInquiryCommunicationMode);
	}

	//Page object model for save button inquiry communication
	By savebuttoninquirycommunication = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getsavebuttoninquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-ClickSave";
		return driver.findElement(savebuttoninquirycommunication);
	}

	//Page object model for Edit inquiry communication row
	By Editinquirycommunicationrow = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[2]/div/table/tbody/tr/td[3]/div/button[2]");
	public WebElement getEditinquirycommunicationrow() {
		base.failedElementName = "InquiryCommunicationMode-Editrow";
		return driver.findElement(Editinquirycommunicationrow);
	}

	//Page object model for Edit Inquiry Communication Mode
	By EditInquiryCommunicationMode = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add"
			+ "/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getEditInquiryCommunicationMode() {
		base.failedElementName = "InquiryCommunicationMode-EditMode";
		return driver.findElement(EditInquiryCommunicationMode);
	}

	//Page object model for edit save button
	By editsavebuttoninquirycommunication = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/div/form/mat-dialog-actions/button[1]");
	public WebElement geteditsavebuttoninquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-EditSave";
		return driver.findElement(editsavebuttoninquirycommunication);
	}

	//Page object model for change status inquiry communication
	By changestatusinquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[2]/div/table/tbody/tr/td[3]/div/button[1]");
	public WebElement getchangestatusinquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-ChangeStatus";
		return driver.findElement(changestatusinquirycommunication);
	}

	//Page object for change status confirmation dialog box
	By changestatusconfirmationinquirycommunication = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getchangestatusconfirmationinquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-ChangeStatusConfirm";
		return driver.findElement(changestatusconfirmationinquirycommunication);
	}

	//Page object for delete click inquiry communication
	By deleteclickinquirycommunication = By.xpath(
			
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[2]/div/table/tbody/tr/td[3]/div/button[3]");
	public WebElement getdeleteclickinquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-ClickDelete";
		return driver.findElement(deleteclickinquirycommunication);
	}

	//Pom for delete click confirmation:
	By deleteclickconfirmationinquirycommunication = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getdeleteclickconfirmationinquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-DeleteConfirm";
		return driver.findElement(deleteclickconfirmationinquirycommunication);
	}

	//Page object model for search inquiry communication
	By searchinquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[1]/div[2]/div/input");
	public WebElement getsearchinquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-SearchInquiry";
		return driver.findElement(searchinquirycommunication);
	}
    
	//Page objcet for click searched button inquiry communication
	By clicksearchedbuttoninquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[1]/div[2]/div/mat-icon");
	public WebElement getclicksearchedbuttoninquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-ClickSearchButtonInquiry";
		return driver.findElement(clicksearchedbuttoninquirycommunication);
	}
	
	//Page objcet for click export as excel inquiry communication
	By clickexportasexcelinquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[1]/div[2]/button[1]");
	public WebElement getclickexportasexcelinquirycommunication() {
		base.failedElementName = "InquiryCommunicationMode-ClickExportExcel";
		return driver.findElement(clickexportasexcelinquirycommunication);
	}
	
	//Page object for Active Inactive Communication Mode
	By activeinactive = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-inquiry-communication-mode-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox");
	public WebElement getActiveInactive() {
		return driver.findElement(activeinactive);
	} 
}
