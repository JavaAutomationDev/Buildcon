package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Projectstatuspage {

	public WebDriver driver;

	public Projectstatuspage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "Unit-Configuration";
		return driver.findElement(Configurationform);
	}

	//Page object for project status click
	// Page object for project status click:
	By projectStatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div"
					+ "[2]/div/a[4]/div/img");

	public WebElement getprojectstatusclick() {
		base.failedElementName = "ProjectStatus-ClickMenu";
		return driver.findElement(projectStatusclick);
	}

	// Page object for project status click:
	By addprojectStatusclick = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-project-status/div/div[1]/div[2]/button[2]");

	public WebElement getaddprojectstatusclick() {
		base.failedElementName = "ProjectStatus-AddClick";
		return driver.findElement(addprojectStatusclick);
	}

	// Page object for project status click:
	By projectStatusdataadd = By
			.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-status-add/div/form/"
					+ "mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getprojectstatusadddata() {
		base.failedElementName = "ProjectStatus-Addstatus";
		return driver.findElement(projectStatusdataadd);
	}

	// Page object for project status click:
	By projectStatussave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-status-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getprojectstatussave() {
		base.failedElementName = "ProjectStatus-AddSave";
		return driver.findElement(projectStatussave);
	}

	// Page object for project status click:
	By projectStatusEditclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-status/div/div[2]/div/table/tbody/tr[2]/td[3]/div/button[2]");

	public WebElement getprojectstatuseditclick() {
		base.failedElementName = "ProjectStatus-EditClick";
		return driver.findElement(projectStatusEditclick);
	}

	// Page object for project status click:
	By projectStatuseditnewdataadd = By
			.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-status-add/div/form/"
					+ "mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getprojectStatuseditnewdataadd() {
		base.failedElementName = "ProjectStatus-EditStatus";
		return driver.findElement(projectStatuseditnewdataadd);
	}

	// Page object for project status click:
	By projectStatuscheckedclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-status/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");

	public WebElement getprojectStatuschecked() {
		//base.failedElementName = "ProjectStatus-StatusCheckedClick";
		return driver.findElement(projectStatuscheckedclick);
	}

	// Page object for project status click:
	By projectStatuscheckedconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]");

	public WebElement getprojectStatuscheckedconfirmation() {
		base.failedElementName = "ProjectStatus-StatusCheckedConfirm";
		return driver.findElement(projectStatuscheckedconfirmation);
	}

	// Page object for project status click:
	By projectStatusexcel = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-project-status/div/div[1]/div[2]/button[1]");

	public WebElement getprojectStatusexcel() {
		base.failedElementName = "ProjectStatus-ExportExcel";
		return driver.findElement(projectStatusexcel);
	}

	//Page object for project Status searched checked
	By projectStatussearchedchecked = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
					+ "mat-sidenav-content/main/vex-project-status/div/div[1]/div[2]/div/input");

	public WebElement getprojectStatussearchedchecked() {
		base.failedElementName = "ProjectStatus-SearchedChecked";
		return driver.findElement(projectStatussearchedchecked);
	}

	//Page object for project status searched item
	By projectstatussearchediteam = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-status/div/div"
					+ "[1]/div[2]/div/mat-icon");

	public WebElement getprojectstatussearchediteam() {
		base.failedElementName = "ProjectStatus-Search";
		return driver.findElement(projectstatussearchediteam);
	}

	//Page object for project status delete click
	By projectstatusdeleteclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-status/div/div[2]/div/table/tbody/tr[2]/td[3]/div/button[3]");

	public WebElement getprojectstatusdeleteclick() {
		base.failedElementName = "ProjectStatus-DeleteClick";
		return driver.findElement(projectstatusdeleteclick);
	}

	//Page object for project status delete confirmation
	By projectstatusdeleteconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getprojectstatusdeleteconfirmation() {
		base.failedElementName = "ProjectStatus-DeleteConfirm";
		return driver.findElement(projectstatusdeleteconfirmation);
	}

	// Page object for Active/Inactive
	By activestatus = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-project-status-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");

	public WebElement getActiveStatus() {
		base.failedElementName = "ProjectStatus-ActiveStatus";
		return driver.findElement(activestatus);
	}
}