package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class PaymentsPlanpage {

	public WebDriver driver;

	public PaymentsPlanpage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}

	//POM for Add Payment Plan
	By paymentplan = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[8]/div/mat-icon");
	public WebElement getpaymentplan() {
		base.failedElementName = "PaymentPlan-ClickMenu";
		return driver.findElement(paymentplan);
	}

	//POM for Add Payment Plan name in testbox
	By addpaymentplan = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-payment-plan-master/div/div[1]/div[2]/button[2]");
	public WebElement getaddpaymentplan() {
		base.failedElementName = "PaymentPlan-Name";
		return driver.findElement(addpaymentplan);
	}
  
	//POM for Add Paymnet Plan Date
	By addpaymentplandataenter = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/"
			+ "div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getaddpaymentplandataenter() {
		return driver.findElement(addpaymentplandataenter);
	}
	
	//POM for Add Is Commercial Check Box Click
	By checkediscommercial = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add"
			+ "/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");
	public WebElement getcheckediscommercial() {
		base.failedElementName = "PaymentPlan-CheckedComm";
		return driver.findElement(checkediscommercial);
	}

	//POM for Add Payment Plan Name in test box
	By paymentplansave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getpaymentplansave() {
		base.failedElementName = "PaymentPlan-AddSave";
		return driver.findElement(paymentplansave);
	}

	//POM for Edit the Payment Plan
	By EditpaymentplanClick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-payment-plan-master/div/div"
			+ "[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");

	public WebElement getEditpaymentplan() {
		base.failedElementName = "PaymentPlan-EditClick";
		return driver.findElement(EditpaymentplanClick);
	}
	
	//POM for Edit Payment Plan
	By Editpaymentplandata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/"
			+ "form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getEditpaymentplandata() {
		return driver.findElement(Editpaymentplandata);
	}

	//POM for Edit Save Button
	By Editpaymentplansave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getEditpaymentplansave() {
		base.failedElementName = "PaymentPlan-EditSave";
		return driver.findElement(Editpaymentplansave);
	}

	//POM For Delete the Entry
	By Deletepaymentplanclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-payment-plan-master/div/div"
			+ "[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");
	public WebElement getDeletepaymentplanclick() {
		base.failedElementName = "PaymentPlan-DeleteClick";
		return driver.findElement(Deletepaymentplanclick);
	}

	//POM for Delete Confirmation
	By Deleteconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getDeleteconfirmation() {
		base.failedElementName = "PaymentPlan-DeleteConfirm";
		return driver.findElement(Deleteconfirmation);
	}

	//POM for Searching the Entry
	By searchingpaymentplan = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
			+ "main/vex-payment-plan-master/div/div[1]/div[2]/div/input");
	public WebElement getseaechingpaymentplan() {
		base.failedElementName = "PaymentPlan-Search";
		return driver.findElement(searchingpaymentplan);
	}

	//POM for Searched Click
	By searchedclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-payment-plan-master/div/div[1]/div[2]/div/mat-icon");
	public WebElement getsearchedclick() {
		base.failedElementName = "PaymentPlan-SearchClick";
		return driver.findElement(searchedclick);
	}

	By excelclickclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-payment-plan-master/div/div[1]/div[2]/button[1]");

	public WebElement getexcelclickclick() {
		return driver.findElement(excelclickclick);
	}

}
