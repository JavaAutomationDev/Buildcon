package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Propertytypepage {

	public WebDriver driver;

	public Propertytypepage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}


	//Page object model for click of the property type
	By propertytype = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-configurations/div/div[2]/div/a[5]/div/mat-icon");
	public WebElement getpropertytype() {
		base.failedElementName = "PropertyType-ClickMenu";
		return driver.findElement(propertytype);
	}

	//Page object model for add property type
	By addpropertytype = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-property-type/div/div[1]/div[2]/button[2]");
	public WebElement getaddpropertytype() {
		base.failedElementName = "PropertyType-ClickAdd";
		return driver.findElement(addpropertytype);
	}

	//Page object model for enter add property type data enter
	By addpropertytypedata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/"
			+ "mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getaddpropertytypedata() {
		base.failedElementName = "PropertyType-addpropertytypedata";
		return driver.findElement(addpropertytypedata);
	}

	//Page object model for save button
	By savebuttonaddpropertytype = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getsavebuttonaddpropertytype() {
		return driver.findElement(savebuttonaddpropertytype);
	}

	//Page object for edit the property type
	By editpropertytypeclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div"
					+ "[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");
	public WebElement geteditpropertytype() {
		return driver.findElement(editpropertytypeclick);
	}

	//Page object for edit the property type enter data
	By editpropertytypeenterdata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-content/div[1]/"
			+ "mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement geteditpropertytypeenterdata() {
		base.failedElementName = "PropertyType-editpropertytypeenterdata";
		return driver.findElement(editpropertytypeenterdata);
	}

    //Page object for save button edit property type
	By savebuttoneditpropertytype = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getsavebuttoneditpropertytype() {
		return driver.findElement(savebuttoneditpropertytype);
	}

	//Page object for searching of the property type
	By searchpropertytype = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-property-type/div/div[1]/div[2]/div/input");
	public WebElement getsearchpropertytype() {
		base.failedElementName = "PropertyType-SerchProperyType";
		return driver.findElement(searchpropertytype);
	}

	//Page object for searching click of the property type
	By searchpropertytypeclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-property-type/div/div[1]/div[2]/div/mat-icon");
	public WebElement getsearchpropertytypeclick() {
		return driver.findElement(searchpropertytypeclick);
	}

	//Page object model for delete the property type
	By deletepropertytypeclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-property-type/div/div"
					+ "[2]/div/table/tbody/tr[1]/td[3]/div/button[3]");
	public WebElement getdeletepropertytypeclick() {
		return driver.findElement(deletepropertytypeclick);
	}

	//Page object model for delete property type confirmation
	By deletepropertytypeconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getdeletepropertytypeconfirmation() {
		return driver.findElement(deletepropertytypeconfirmation);
	}

	//Page object model for property type excel
	By propertytypeexcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-property-type/div/div[1]/div[2]/button[1]");
	public WebElement getpropertytypeexcel() {
		base.failedElementName = "PropertyType-ExportExcel";
		return driver.findElement(propertytypeexcel);
	}
	
	//Page object model for property type status change
	By propertytypestatuschange = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-property-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");
	public WebElement getpropertytypestatuschange() {
		base.failedElementName = "PropertyType-StatusChange";
		return driver.findElement(propertytypestatuschange);
	}
	
	//Page object model for property type status change click
	By propertytypestatuschangeclick = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getpropertytypestatuschangeclick() {
		return driver.findElement(propertytypestatuschangeclick);
	}
	
	//Page object model for property type search
	By propertytypesearch = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-property-type/div/div[1]/div[2]/div/input");
	public WebElement getpropertytypesearch() {
		base.failedElementName = "PropertyType-Search";
		return driver.findElement(propertytypesearch);
	}
	
	//Page object model for property type search click
	By propertytypesearchclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-property-type/div/div[1]/div[2]/div/mat-icon");
	public WebElement getpropertytypesearchclick() {
		return driver.findElement(propertytypesearchclick);
	}
	
	//Page object for Active/Inactive Status
	By activestatus = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-property-type-add/"
			+ "div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");
	public WebElement getActiveStatus() {
		base.failedElementName = "PropertyType-ActiveStatus";
		return driver.findElement(activestatus);
	}
}