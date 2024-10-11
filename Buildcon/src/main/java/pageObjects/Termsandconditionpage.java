package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Termsandconditionpage {

	public WebDriver driver;

	public Termsandconditionpage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// page object model for Click on the terms and condition
	By Termsandconditionclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[12]/div/mat-icon");

	public WebElement getTermsandconditionclick() {
		return driver.findElement(Termsandconditionclick);

	}

	// page object model for add inquiry communication mode data
	By addnewTermsandcondition = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-terms-condition/div/div[1]/div[2]/button[2]");

	public WebElement getaddnewTermsandcondition() {
		return driver.findElement(addnewTermsandcondition);
	}

	// page object model for Add New Inquiry Communication Mode
	By AddNewTermsandConditionsdata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-terms-condition-add/div/form/mat-dialog-content/div/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getAddNewTermsandConditionsdata() {
		return driver.findElement(AddNewTermsandConditionsdata);
	}

	// page object model for save button for project types
	By savebuttonTermsandConditions = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-terms-condition-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getsavebuttonTermsandConditions() {
		return driver.findElement(savebuttonTermsandConditions);
	}

	// page object model for edit the inquiry communication mode page
	By EditTermsandConditions = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-terms-condition/div/div[2]/div/table/tbody/tr/td[2]/div/button[1]");

	public WebElement getEditTermsandConditions() {
		return driver.findElement(EditTermsandConditions);
	}

	// page object model for add new data and clear existing data;
	By updateEditTermsandcondition = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-terms-condition-add/div/form/mat-dialog-content/div/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getupdateEditTermsandcondition() {
		return driver.findElement(updateEditTermsandcondition);
	}

	// page object model for edit save button :
	By editsavebuttonTermsandcondition= By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-terms-condition-add/div/form/mat-dialog-actions/button[1]");

	public WebElement geteditsavebuttonTermsandcondition() {
		return driver.findElement(editsavebuttonTermsandcondition);
	}


	// pom for delete click:
	By deleteclickTermsandcondition = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-terms-condition/div/div[2]/div/table/tbody/tr/td[2]/div/button[2]");

	public WebElement getdeleteclickinquirycommunication() {
		return driver.findElement(deleteclickTermsandcondition);
	}

	// pom for delete click confirmation:
	By deleteclickconfirmationTermsandcondition = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]");

	public WebElement getdeleteclickconfirmationTermsandcondition() {
		return driver.findElement(deleteclickconfirmationTermsandcondition);
	}

	// page object model for searching of project types:
	By searchtermsandcondition = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-terms-condition/div/div[1]/div[2]/div/input");

	public WebElement getsearchtermsandcondition() {
		return driver.findElement(searchtermsandcondition);
	}

	By clicksearchtermsandcondition  = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-terms-condition/div/div[1]/div[2]/div/mat-icon");

	public WebElement getclicksearchtermsandcondition() {
		return driver.findElement(clicksearchtermsandcondition);
	}

	By clickexportasexceltermsandcondition = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-terms-condition/div/div[1]/div[2]/button[1]");

	public WebElement getclickexportasexceltermsandcondition() {
		return driver.findElement(clickexportasexceltermsandcondition);
	}

}
