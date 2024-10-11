package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inquirycommunicationmodepage {

	public WebDriver driver;

	public Inquirycommunicationmodepage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// page object model for Click on the inquiry communication mode page
	By Inquirycommunicationmodepageclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[11]/div/mat-icon");

	public WebElement getInquirycommunicationmodepageclick() {
		return driver.findElement(Inquirycommunicationmodepageclick);

	}

	// page object model for add inquiry communication mode data
	By Inquirycommunicationmodeadd  = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[1]/div[2]/button[2]");

	public WebElement getInquirycommunicationmodeadd() {
		return driver.findElement(Inquirycommunicationmodeadd);
	}

	// page object model for Add New Inquiry Communication Mode
	By AddNewInquiryCommunicationMode = By.xpath(
			"//input[@formcontrolname='inqCommModeName']");
	public WebElement getAddNewInquiryCommunicationMode() {
		return driver.findElement(AddNewInquiryCommunicationMode);
	}

	// page object model for save button for project types
	By savebuttoninquirycommunication = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getsavebuttoninquirycommunication() {
		return driver.findElement(savebuttoninquirycommunication);
	}

	// page object model for edit  the inquiry communication mode page
	By Editinquirycommunicationrow = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");

	public WebElement getEditinquirycommunicationrow() {
		return driver.findElement(Editinquirycommunicationrow);
	}

	// page object model for add new data and clear existing data;
	By EditInquiryCommunicationMode = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/div/form/mat-dialog-content/div"
			+ "[1]/mat-form-field/div[1]/div[2]/div[2]/input");
 
	public WebElement getEditInquiryCommunicationMode() {
		return driver.findElement(EditInquiryCommunicationMode);
	}

	// page object model for edit save button :
	By editsavebuttoninquirycommunication = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-inquiry-communication-mode-add/div/form/mat-dialog-actions/button[1]");

	public WebElement geteditsavebuttoninquirycommunication() {
		return driver.findElement(editsavebuttoninquirycommunication);
	}

	// page object model for change status
	By changestatusinquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[2]/div/table/tbody/tr[2]/td[3]/div/button[1]");

	public WebElement getchangestatusinquirycommunication() {
		return driver.findElement(changestatusinquirycommunication);
	}

	// pom for changestatus confirmation dialog box:
	By changestatusconfirmationinquirycommunication = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getchangestatusconfirmationinquirycommunication() {
		return driver.findElement(changestatusconfirmationinquirycommunication);
	}

	// pom for delete click:
	By deleteclickinquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[2]/div/table/tbody/tr[2]/td[3]/div/button[3]");

	public WebElement getdeleteclickinquirycommunication() {
		return driver.findElement(deleteclickinquirycommunication);
	}

	// pom for delete click confirmation:
	By deleteclickconfirmationinquirycommunication = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]");

	public WebElement getdeleteclickconfirmationinquirycommunication() {
		return driver.findElement(deleteclickconfirmationinquirycommunication);
	}

	// page object model for searching of project types:
	By searchinquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[1]/div[2]/div/input");

	public WebElement getsearchinquirycommunication() {
		return driver.findElement(searchinquirycommunication);
	}

	By clicksearchedbuttoninquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[1]/div[2]/div/mat-icon");

	public WebElement getclicksearchedbuttoninquirycommunication() {
		return driver.findElement(clicksearchedbuttoninquirycommunication);
	}
	
	
	By clickexportasexcelinquirycommunication = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-communication-mode/div/div[1]/div[2]/button[1]");

	public WebElement getclickexportasexcelinquirycommunication() {
		return driver.findElement(clickexportasexcelinquirycommunication);
	}
	
	

}
