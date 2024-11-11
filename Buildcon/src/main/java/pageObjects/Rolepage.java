package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Rolepage {

	public WebDriver driver;

	public Rolepage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	//Page object model for Click on the role
	By Roleclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[13]/div/mat-icon");
	public WebElement getRoleclick() {
		return driver.findElement(Roleclick);

	}

	//Page object model for add role data
	By addnewrole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[1]/div[2]/button");
	public WebElement getaddnewrole() {
		return driver.findElement(addnewrole);
	}

	//Page object model for Add role data
	By addrolename = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-content/form/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getaddrolename() {
		return driver.findElement(addrolename);
	}

	//Page object model for Add role data
	By showphonenumberchecked = By.xpath(
			"//mat-checkbox[@formcontrolname='isMobileShow']");
	public WebElement getshowphonenumberchecked() {
		return driver.findElement(showphonenumberchecked);
	}

	By clickcreate = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-actions/button[1]");
	public WebElement getclickcreate() {
		return driver.findElement(clickcreate);
	}

	//Page object model for edit the role page
	By EditRolebuttonclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");
	public WebElement getEditRolebuttonclick() {
		return driver.findElement(EditRolebuttonclick);
	}

	//Page object model for add new data and clear existing data;
	By updateEditrole = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-content/form/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getupdateEditrole() {
		return driver.findElement(updateEditrole);
	}

	//Page object model for edit save button :
	By editsavebuttonrole = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-actions/button[2]");
	public WebElement geteditsavebuttonrole() {
		return driver.findElement(editsavebuttonrole);
	}

	//Page object model for change status button click :
	By Rolestatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");
	public WebElement getRolestatusclick() {
		return driver.findElement(Rolestatusclick);
	}
	
	//Page object model for change status button click :
	By Rolestatusclickconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getRolestatusclickconfirm() {
		return driver.findElement(Rolestatusclickconfirm);
	}

	//Pom for delete click:
	By deleteclickRole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[3]");
	public WebElement getdeleteclickRole() {
		return driver.findElement(deleteclickRole);
	}

	//Pom for delete click confirmation:
	By deleteclickconfirmationRole = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getdeleteclickconfirmationRole() {
		return driver.findElement(deleteclickconfirmationRole);
	}

	//Page object model for searching of project types:
	By searchRole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[1]/div[2]/div[1]/input");
	public WebElement getsearchRole() {
		return driver.findElement(searchRole);
	}

	By clicksearchrole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[1]/div[2]/div[1]/mat-icon");
	public WebElement getclicksearchrole() {
		return driver.findElement(clicksearchrole);
	}

	By clickexportasexcelRole = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-roles/div/div[1]/div[2]/div[2]/button");
	public WebElement getclickexportasexcelRole() {
		return driver.findElement(clickexportasexcelRole);
	}
	//Page object for Active Inactive Role status
	By activeinactiveroles = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-roles-add/div/mat-dialog-content/form/div/div[2]/mat-checkbox/div/div");
	public WebElement getActiveInactiveRoles() {
		return driver.findElement(activeinactiveroles);
	}
}