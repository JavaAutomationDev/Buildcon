package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Inquirystatuspage {

	public WebDriver driver;

	public Inquirystatuspage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}

	// pom for Inquirystatuspage:
	By Inquirystatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[9]/div/mat-icon");
	public WebElement getInquirystatusclick() {
		base.failedElementName = "InquiryStatus-MenuClick";
		return driver.findElement(Inquirystatusclick);
	}

	By AddInquirystatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/button[2]");
	public WebElement getAddnewInquirystatus() {
		base.failedElementName = "InquiryStatus-AddClick";
		return driver.findElement(AddInquirystatusclick);
	}

	By AddInquirystatus = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getAddInquirystatus() {
		base.failedElementName = "InquiryStatus-AddInquiryStatus";
		return driver.findElement(AddInquirystatus);
	}

	By AddInquirystatussave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getAddInquirystatussave() {
		base.failedElementName = "InquiryStatus-AddSave";
		return driver.findElement(AddInquirystatussave);
	}


	// pom for edit inquirystatus:

	By EditInquirystatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[2]/div/table/tbody/tr/td[3]/div/button[2]");

	public WebElement getEditInquirystatus() {
		return driver.findElement(EditInquirystatusclick);
	}
	
	By EditInquirystatusnew = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getEditInquirystatusnew() {
		return driver.findElement(EditInquirystatusnew);
	}
	
	// pom for clickon save button

	By EditInquirystatussave = By.xpath(
	        "/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getEditInquirystatussave() {
		base.failedElementName = "InquiryStatus-EditSave";
		return driver.findElement(EditInquirystatussave);
	}

	//Pom for status changed click:
	By ChangeInquirystatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[2]/div/table/tbody/tr/td[3]/div/button[1]");

	public WebElement getChangeInquirystatus() {
		base.failedElementName = "InquiryStatus-ChangeInquiryStatus";
		return driver.findElement(ChangeInquirystatus);
	}
	
	//Pom for confirmation click:
	By ChangeInquirystatusconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getChangeInquirystatusconfirm() {
		base.failedElementName = "InquiryStatus-ChangeStatusConfirm";
		return driver.findElement(ChangeInquirystatusconfirm);
	}

	// pom for searched for inquiry status:
	By Inquirystatussearched = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/div/input");
	public WebElement getInquirystatussearched() {
		base.failedElementName = "InquiryStatus-StatusSearched";
		return driver.findElement(Inquirystatussearched);
	}
	
	//Pom for searche click:
	By Inquirystatussearchedclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/div/mat-icon");
	public WebElement getInquirystatussearchedclick() {
		base.failedElementName = "InquiryStatus-SearchClick";
		return driver.findElement(Inquirystatussearchedclick);
	}
	
	//Pom for delete click:
	By Inquirystatusdeleteclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[2]/div/table/tbody/tr[3]/td[3]/div/button[3]");
	public WebElement getInquirystatusdeleteclick() {
		base.failedElementName = "InquiryStatus-DeleteClick";
		return driver.findElement(Inquirystatusdeleteclick);
	}
	
	//Pom for delete confirmation:
	By Inquirystatusdeleteconfirmationk = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getInquirystatusdeleteconfirmationk() {
		base.failedElementName = "InquiryStatus-DeleteConfirm";
		return driver.findElement(Inquirystatusdeleteconfirmationk);
	}
	
	By inquiryExcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/button[1]");
	public WebElement getinquiryExcel() {
		base.failedElementName = "InquiryStatus-InquiryExcel";
		return driver.findElement(inquiryExcel);
	}
	
	//Page object for Active Inactive Status
	By activeinactive = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox");
	public WebElement getInquiryActiveInactive() {
		return driver.findElement(activeinactive);
	}
}
