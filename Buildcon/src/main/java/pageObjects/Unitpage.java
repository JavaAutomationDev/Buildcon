package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base;

public class Unitpage {

	public WebDriver driver;

	public Unitpage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "Unit-Configuration";
		return driver.findElement(Configurationform);
	}

	// page object model for click on the unitmodule:
	By unitform = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
					+ "/vex-configurations/div/div[2]/div/a[1]/div/img");

	public WebElement getclickunit() {
		base.failedElementName = "Unit-Unitform";
		return driver.findElement(unitform);
	}

	// page object module for the click on the add unit
	By addunitform = By.xpath("(//span[contains(text(),'add Unit')])");

	public WebElement getclickaddunit() {
		base.failedElementName = "Unit-ClickAdd";
		return driver.findElement(addunitform);
	}

	// page object model for Name unit
	By nameunit = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-content/div[1]"
					+ "/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement gettextnameunit() {
		base.failedElementName = "Unit-Name";
		return driver.findElement(nameunit);
	}

	// page object model for addunitsave
	By addunitsave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getaddunitsave() {
		base.failedElementName = "Unit-AddSave";
		return driver.findElement(addunitsave);
	}

	// PAGE object model for editbutton unit
	By Editbutton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[2]/div/table/tbody/tr/td[3]/div/button[2]");

	public WebElement geteditunit() {
		base.failedElementName = "Unit-Edit";
		return driver.findElement(Editbutton);
	}

	// page object model for enter new data on edit and clear data on edit
	By Edittext = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement geteditunittext() {
		base.failedElementName = "Unit-EiditName";
		return driver.findElement(Edittext);
	}

	// page object model for save button on edit
	By Editsave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-add/div/form/mat-dialog-actions/button[1]");

	public WebElement geteditsave() {
		base.failedElementName = "Unit-EditSave";
		return driver.findElement(Editsave);
	}

	// page object model for change the unit status:
	By statuschange = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[2]/div/table/tbody/tr/td[3]/div/button[1]");

	public WebElement getchangestatus() {
		base.failedElementName = "Unit-Statuschange";
		return driver.findElement(statuschange);
	}

	// page object model for change status of unit:
	By statuschange1 = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getstatuschange1() {
		base.failedElementName = "Unit-Statuschange1";
		return driver.findElement(statuschange1);
	}

	// page object model foe delete :
	// page object model for change status of unit:
	By deleteclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[2]/div/table/tbody/tr/td[3]/div/button[3]");

	public WebElement getdeleteclick() {
		base.failedElementName = "Unit-deleteclick";
		return driver.findElement(deleteclick);
	}
	
	By deleteclickconfirm = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
									  
	
	public WebElement getdeleteclickconfirm() {
		return driver.findElement(deleteclickconfirm);
	}
	
	// page object for export as a excel
	By Excel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[1]/div[2]/div[2]/button");

	public WebElement excelclick() {
		base.failedElementName = "Unit-Excel";
		return driver.findElement(Excel);
	}

	// page object model for searching
	By entertextonsearched = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/div/div[1]/div[2]/"
					+ "div[1]/input");

	public WebElement getentertext() {
		base.failedElementName = "Unit-Search";
		return driver.findElement(entertextonsearched);
	}

	// page object model for searched the row
	By searched = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-units/"
					+ "div/div[1]/div[2]/div[1]/mat-icon");

	public WebElement getrowsearched() {
		base.failedElementName = "Unit-Searched";
		return driver.findElement(searched);
	}

}