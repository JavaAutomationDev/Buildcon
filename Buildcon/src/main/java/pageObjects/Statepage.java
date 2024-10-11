package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Statepage {

	public WebDriver driver;

	public Statepage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// page object model for click on the state module:
	By Stateform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations"
					+ "/div/div[2]/div/a[2]/div/mat-icon");

	public WebElement getclickstate() {
		return driver.findElement(Stateform);
	}

	// page object model for add the state name:
	By addstateclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-states/div/div[1]/div[2]/button");

	public WebElement getstatename() {
		return driver.findElement(addstateclick);
	}

	// page object model for enter the state name:
	By statenameenter = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/"
					+ "div[1]/mat-form-field[1]/div[1]/div[2]/div[2]/input");

	public WebElement eneterstatename() {
		return driver.findElement(statenameenter);
	}

	// page object model for add the state code:
	By statecode = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/div[1]/mat-form-field[2]/"
					+ "div[1]/div[2]/div[2]/input");

	public WebElement getstatecode() {
		return driver.findElement(statecode);
	}

	// page object model for add the state save button:
	By savestate = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getsavestate() {
		return driver.findElement(savestate);
	}

	// PAGE OBJECT MODEL FOR EDIT ROW
	By editstaterow = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-states/div/div[2]/div/table/tbody/tr[2]/td[4]/div/button[2]");

	public WebElement editrow() {
		return driver.findElement(editstaterow);
	}

	// PAGE OBJECT MODEL FOR EDIT ROW add data for statename
	By editstaterowopen = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/div[1]/mat-form-field[1]/div[1]/div[2]/div[2]/input");

	public WebElement editadddata() {
		return driver.findElement(editstaterowopen);
	}

	// PAGE OBJECT MODEL FOR EDIT row state code
	By editstatecode = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[1]/div[2]/div[2]/input");

	public WebElement editrowaddstatecode() {
		return driver.findElement(editstatecode);
	}

	// PAGE OBJECT MODEL FOR EDIT ROW
	By editstaterowsave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-actions/button[1]");

	public WebElement editrowsavebutton() {
		return driver.findElement(editstaterowsave);
	}
   
	By statusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-states/div/div[2]/div/table/tbody/tr[2]/td[4]/div/button[1]");

	public WebElement getstatusclick() {
		return driver.findElement(statusclick);
	}
	
	By statusconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getstatusconfirmation() {
		return driver.findElement(statusconfirmation);
	}
	
	By deletestate = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-states/div/div[2]/div/table/tbody/tr[2]/td[4]/div/button[3]");

	public WebElement getdeletestate() {
		return driver.findElement(deletestate);
	}
	
	By deletestateconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getdeletestateconfirm() {
		return driver.findElement(deletestateconfirm);
	}
	
	By statesearching = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-states/div/div[1]/div[2]/div/input");
	public WebElement getstatesearching() {
		return driver.findElement(statesearching);
	}
	
	By statesearchingclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-states/div/div[1]/div[2]/div/mat-icon");
	public WebElement getstatesearchingclick() {
		return driver.findElement(statesearchingclick);
	}
	
	By stateexcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-states/div/div[1]/div[2]/div/button");
	public WebElement getstateexcel() {
		return driver.findElement(stateexcel);
	}
	
	//Page object for active
	By active = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-state-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");
	public WebElement getActive() {
		return driver.findElement(active);
	}
}
