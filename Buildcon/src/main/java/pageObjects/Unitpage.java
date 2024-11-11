package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Unitpage {

	public WebDriver driver;

	public Unitpage(WebDriver driver) {
		this.driver=driver;
	}

	//Page object for click Configuration  form module
	By Configurationform = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
			+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	//Page object model for click on the  unitmodule:
	By unitform = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
			+ "/vex-configurations/div/div[2]/div/a[1]/div/img");
	public WebElement getclickunit() {
		return driver.findElement(unitform);
	}

	//Page object module for the click on the add unit
	By addunitform = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-units/div/div[1]/div[2]/button/span[2]/span");
	public WebElement getclickaddunit() {
		return driver.findElement(addunitform);
	}

	//Page object model for Name unit
	By nameunit = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-content/div[1]"
			+ "/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement gettextnameunit() {
		return driver.findElement(nameunit);
	}

	//Page object model for addunitsave
	By addunitsave = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getunitsave() {
		return driver.findElement(addunitsave);
	}

	//Page object model for editbutton unit	
	By Editbutton = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[2]/div/table/tbody/tr[3]/td[3]/div/button[2]");
	public WebElement geteditunit() {
		return driver.findElement(Editbutton);
	}

	//Page  object model for enter new data on edit and clear data on edit
	By Edittext = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement geteditunittext() {
		return driver.findElement(Edittext);
	}

	//Page object model for save button on edit
	By Editsave = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-actions/button[1]");
	public WebElement geteditsave() {
		return driver.findElement(Editsave);
	}

	//Page object model for change the unit status:
	By statuschange =By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content"
			+ "/main/vex-units/div/div[2]/div/table/tbody/tr[3]/td[3]/div/button[1]");

	public WebElement getchangestatus() {
		return driver.findElement(statuschange);
	}

	//Page object model for change status of unit:
	By statuschange1 = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getstatuschange1() {
		return driver.findElement(statuschange1);
	}

	//Page object model for delete the record
	By deleteunit = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[2]"
			+ "/div/table/tbody/tr[3]/td[3]/div/button[3]");
	public WebElement getdelete() {
		return driver.findElement(deleteunit);
	}

	//Page object model for delete confirmation
	By deleteconfirmation = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement confirmationdelete() {
		return driver.findElement(deleteconfirmation);
	}

	//Page object for export as a excel
	By Excel = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[1]/div[2]/div[2]/button");
	public WebElement excelclick() {
		return driver.findElement(Excel);
	}

	//Page object model for searching
	By entertextonsearched = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[1]/div[2]/"
			+ "div[1]/input");
	public WebElement getentertext() {
		return driver.findElement(entertextonsearched);
	}

	//Page object model for searched the row
	By searched = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/"
			+ "div/div[1]/div[2]/div[1]/mat-icon");
	public WebElement getrowsearched() {
		return driver.findElement(searched);
	}
	
	//Page object for Active Inactive Status
	By activeinactive = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-inquiry-status-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/div[4]");
	public WebElement getActiveInactive() {
		return driver.findElement(activeinactive);
	}
}
