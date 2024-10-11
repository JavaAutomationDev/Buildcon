package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InquiryResponsepage {

	public WebDriver driver;

	public InquiryResponsepage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	By InquiryResponsepageclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[10]/div/mat-icon");

	public WebElement getInquiryResponsepageclick() {
		return driver.findElement(InquiryResponsepageclick);
	}

	By AddInquiryResponsepageclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[1]/div[2]/button[2]");

	public WebElement getAddInquiryResponsepageclick() {
		return driver.findElement(AddInquiryResponsepageclick);
	}

	By AddInquiryResponsenewdata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getAddInquiryResponsenewdata() {
		return driver.findElement(AddInquiryResponsenewdata);
	}

	By Inquiryresponsesave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getInquiryresponsesave() {
		return driver.findElement(Inquiryresponsesave);
	}

	// pom for edit inquirystatus:

	By Editinquiryresponsetype = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");

	public WebElement getEditinquiryresponsetype() {
		return driver.findElement(Editinquiryresponsetype);
	}

	// pom for clickon save button

	By Editinquiryresponsesave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-response-type-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getEditinquiryresponsesave() {
		return driver.findElement(Editinquiryresponsesave);
	}

	// pom for status changed click:

	By ChangeInquiryrsponsestatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");

	public WebElement getChangeInquiryrsponsestatus() {
		return driver.findElement(ChangeInquiryrsponsestatus);
	}
	// pom for confirmation click:

	By ChangeInquiryresponseconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]");

	public WebElement getChangeInquiryresponseconfirm() {
		return driver.findElement(ChangeInquiryresponseconfirm);
	}

	// pom for searched for inquiry status:

	By Inquiryresponsesearched = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[1]/div[2]/div/input");

	public WebElement getInquiryresponsesearched() {
		return driver.findElement(Inquiryresponsesearched);
	}
	
	
	
	
	By Inquiryresponsesearchedclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[1]/div[2]/div/mat-icon");

	public WebElement getInquiryresponsesearchedclick() {
		return driver.findElement(Inquiryresponsesearchedclick);
	}
	
	// pom for delete click:
	
	By Inquiryresponsedeleteclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[3]");

	public WebElement getInquiryresponsedeleteclick() {
		return driver.findElement(Inquiryresponsedeleteclick);
	}
	
	// pom for delete confirmation:
	
	By Inquiryresponsedeleteconfirmationk = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getInquiryresponsedeleteconfirmationk() {
		return driver.findElement(Inquiryresponsedeleteconfirmationk);
	}
	
	By inquiryresponseExcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-response-type/div/div[1]/div[2]/button[1]");

	public WebElement getinquiryresponseExcel() {
		return driver.findElement(inquiryresponseExcel);
	}

}
