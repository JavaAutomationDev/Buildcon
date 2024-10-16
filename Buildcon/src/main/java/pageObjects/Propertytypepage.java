package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Propertytypepage {

	public WebDriver driver;

	public Propertytypepage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// page object model for click of the property type
	By propertytype = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div"
					+ "[2]/div/a[5]/div/mat-icon");

	public WebElement getpropertytype() {
		return driver.findElement(propertytype);
	}

	// page object model for add property type:
	By addpropertytype = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div[1]/div"
					+ "[2]/button[2]");

	public WebElement getaddpropertytype() {
		return driver.findElement(addpropertytype);
	}

	// page object model for enter add property type data enter:
	By addpropertytypedata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div"
					+ "[2]/input");

	public WebElement getaddpropertytypedata() {
		return driver.findElement(addpropertytypedata);

	}

	// page object model for save button:
	By savebuttonaddpropertytype = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getsavebuttonaddpropertytype() {
		return driver.findElement(savebuttonaddpropertytype);
	}

	// edit the property type:
	By editpropertytypeclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div"
					+ "[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");

	public WebElement geteditpropertytype() {
		return driver.findElement(editpropertytypeclick);
	}

	By editpropertytypeenterdata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-content/div[1]/mat-form-field/div"
					+ "[1]/div[2]/div[2]/input");

	public WebElement geteditpropertytypeenterdata() {
		return driver.findElement(editpropertytypeenterdata);
	}

	By savebuttoneditpropertytype = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getsavebuttoneditpropertytype() {
		return driver.findElement(savebuttoneditpropertytype);
	}

	// pom for searching of the propertytypr:
	By searchpropertytype = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div[1]/div[2]/div/input");

	public WebElement getsearchpropertytype() {
		return driver.findElement(searchpropertytype);
	}

	// pom for searchingclick of the propertytype:
	By searchpropertytypeclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div[1]/div[2]/div/mat-icon");

	public WebElement getsearchpropertytypeclick() {
		return driver.findElement(searchpropertytypeclick);
	}

	// page object model for delete the property type:
	By deletepropertytypeclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div"
					+ "[2]/div/table/tbody/tr[1]/td[3]/div/button[3]");

	public WebElement getdeletepropertytypeclick() {
		return driver.findElement(deletepropertytypeclick);
	}

	By deletepropertytypeconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getdeletepropertytypeconfirmation() {
		return driver.findElement(deletepropertytypeconfirmation);
	}

	By propertytypeexcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div"
					+ "[1]/div[2]/button[1]");

	public WebElement getpropertytypeexcel() {
		return driver.findElement(propertytypeexcel);
	}
	
	
	By propertytypestatuschange = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");

	public WebElement getpropertytypestatuschange() {
		return driver.findElement(propertytypestatuschange);
	}
	
	
	By propertytypestatuschangeclick = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getpropertytypestatuschangeclick() {
		return driver.findElement(propertytypestatuschangeclick);
	}
	
	By propertytypesearch = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div[1]/div[2]/div/input");

	public WebElement getpropertytypesearch() {
		return driver.findElement(propertytypesearch);
	}
	
	By propertytypesearchclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div[1]/div[2]/div/mat-icon");

	public WebElement getpropertytypesearchclick() {
		return driver.findElement(propertytypesearchclick);
	}
}
