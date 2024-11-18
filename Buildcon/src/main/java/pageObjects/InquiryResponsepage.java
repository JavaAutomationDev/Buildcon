package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class InquiryResponsepage {

	public WebDriver driver;

	public InquiryResponsepage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");
	public WebElement getconfiguration() {
		base.failedElementName = "InquiryResponse-Configuration";
		return driver.findElement(Configurationform);
	}

	By InquiryResponsepageclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[10]/div/mat-icon");
	public WebElement getInquiryResponsepageclick() {
		base.failedElementName = "InquiryResponse-Menuclick";
		return driver.findElement(InquiryResponsepageclick);
	}

	By AddInquiryResponsepageclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[1]/div[2]/button[2]");
	public WebElement getAddInquiryResponsepageclick() {
		base.failedElementName = "InquiryResponse-Add";
		return driver.findElement(AddInquiryResponsepageclick);
	}

	By AddInquiryResponsenewdata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getAddInquiryResponsenewdata() {
		base.failedElementName = "InquiryResponse-AddInquiryResponsenewdata";
		return driver.findElement(AddInquiryResponsenewdata);
	}

	By Inquiryresponsesave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getInquiryresponsesave() {
		base.failedElementName = "InquiryResponse-Save";
		return driver.findElement(Inquiryresponsesave);
	}

	//Pom for edit inquirystatus:
	By Editinquiryresponsetype = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");
	public WebElement getEditinquiryresponsetype() {
		base.failedElementName = "InquiryResponse-Editinquiryresponsetype";
		return driver.findElement(Editinquiryresponsetype);
	}

	By Editinquiryresponsetypeenter = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getEditinquiryresponsetypeenter() {
		return driver.findElement(Editinquiryresponsetypeenter);
	}

	

	//Pom for clickon save button

	By Editinquiryresponsesave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getEditinquiryresponsesave() {
		base.failedElementName = "InquiryResponse-EditSave";
		return driver.findElement(Editinquiryresponsesave);
	}

	//Pom for status changed click:
	By ChangeInquiryrsponsestatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");

	public WebElement getChangeInquiryrsponsestatus() {
		base.failedElementName = "InquiryResponse-ChangeInquiryrsponsestatus";
		return driver.findElement(ChangeInquiryrsponsestatus);
	}
	//Pom for confirmation click:
	By ChangeInquiryresponseconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]");
	public WebElement getChangeInquiryresponseconfirm() {
		base.failedElementName = "InquiryResponse-ChangeInquiryresponseconfirm";
		return driver.findElement(ChangeInquiryresponseconfirm);
	}

	//Pom for searched for inquiry status:
	By Inquiryresponsesearched = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[1]/div[2]/div/input");
	public WebElement getInquiryresponsesearched() {
		base.failedElementName = "InquiryResponse-Inquiryresponsesearched";
		return driver.findElement(Inquiryresponsesearched);
	}

	By Inquiryresponsesearchedclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[1]/div[2]/div/mat-icon");
	public WebElement getInquiryresponsesearchedclick() {
		base.failedElementName = "InquiryResponse-Inquiryresponsesearchedclick";
		return driver.findElement(Inquiryresponsesearchedclick);
	}

	// pom for delete click:

	By Inquiryresponsedeleteclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[3]");

	public WebElement getInquiryresponsedeleteclick() {
		base.failedElementName = "InquiryResponse-Delte";
		return driver.findElement(Inquiryresponsedeleteclick);
	}

	// pom for delete confirmation:

	By Inquiryresponsedeleteconfirmationk = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getInquiryresponsedeleteconfirmationk() {
		base.failedElementName = "InquiryResponse-DeleteConfirm";
		return driver.findElement(Inquiryresponsedeleteconfirmationk);
	}

	By inquiryresponseExcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[1]/div[2]/button[1]");
	public WebElement getinquiryresponseExcel() {
		base.failedElementName = "InquiryResponse-inquiryresponseExcel";
		return driver.findElement(inquiryresponseExcel);
	}
	
	//Page object for active inactive 
	By inquiryactiveinactive = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");
	public WebElement getInquiryActiveInactive() {
		return driver.findElement(inquiryactiveinactive);
	}
}