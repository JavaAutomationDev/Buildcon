package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inquirystatuspage {

	public WebDriver driver;

	public Inquirystatuspage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	//Pom for Inquirystatuspage:
	By Inquirystatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[9]/div/mat-icon");
	public WebElement getInquirystatusclick() {
		return driver.findElement(Inquirystatusclick);
	}

	By AddInquirystatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/button[2]");
	public WebElement getAddInquirystatusclick() {
		return driver.findElement(AddInquirystatusclick);
	}

	By AddInquirystatus = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/label");
	public WebElement getAddInquirystatus() {
		return driver.findElement(AddInquirystatus);
	}

	By AddInquirystatussave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getAddInquirystatussave() {
		return driver.findElement(AddInquirystatussave);
	}

	//Pom for edit inquirystatus:
	By EditInquirystatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");
	public WebElement getEditInquirystatus() {
		return driver.findElement(EditInquirystatusclick);
	}

	//Pom for clickon save button
	By EditInquirystatussave = By.xpath(
	        "/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-actions/button[2]");
	public WebElement getEditInquirystatussave() {
		return driver.findElement(EditInquirystatussave);
	}

	//Pom for status changed click:
	By ChangeInquirystatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");
	public WebElement getChangeInquirystatus() {
		return driver.findElement(ChangeInquirystatus);
	}
	
	//Pom for confirmation click:
	By ChangeInquirystatusconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getChangeInquirystatusconfirm() {
		return driver.findElement(ChangeInquirystatusconfirm);
	}

	// pom for searched for inquiry status:
	By Inquirystatussearched = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/div/input");
	public WebElement getInquirystatussearched() {
		return driver.findElement(Inquirystatussearched);
	}
	
	//Pom for searche click:
	By Inquirystatussearchedclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/div/mat-icon");
	public WebElement getInquirystatussearchedclick() {
		return driver.findElement(Inquirystatussearchedclick);
	}
	
	//Pom for delete click:
	By Inquirystatusdeleteclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/div/mat-icon");
	public WebElement getInquirystatusdeleteclick() {
		return driver.findElement(Inquirystatusdeleteclick);
	}
	
	//Pom for delete confirmation:
	By Inquirystatusdeleteconfirmationk = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getInquirystatusdeleteconfirmationk() {
		return driver.findElement(Inquirystatusdeleteconfirmationk);
	}
	
	By inquiryExcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-status/div/div[1]/div[2]/button[1]");
	public WebElement getinquiryExcel() {
		return driver.findElement(inquiryExcel);
	}
	
	//Page object for Active Inactive Status
	By activeinactive = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-status-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox");
	public WebElement getInquiryActiveInactive() {
		return driver.findElement(activeinactive);
	}
}
