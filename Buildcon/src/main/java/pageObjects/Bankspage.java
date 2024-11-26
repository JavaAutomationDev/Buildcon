package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Bankspage {

	public WebDriver driver;

	public Bankspage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}
	
	//Page object for banks click
	By Banksclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[6]/div/mat-icon");
	public WebElement getBanksclick() {
		base.failedElementName = "Banks-Banksclick";
		return driver.findElement(Banksclick);

	}

	//Page object for banks Add
	By Banksadd = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-bank-master/div/div[1]/div[2]/button[2]");
	public WebElement getBanksadd() {
		base.failedElementName = "Banks-Banksadd";
		return driver.findElement(Banksadd);
	}

	//Page object for banks Add Data
	By Banksadddata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/"
			+ "mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getBanksadddata() {
		base.failedElementName = "Banks-BankName";
		return driver.findElement(Banksadddata);
	}

	//Page object for banks Save
	By bankssave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getbankssave() {
		base.failedElementName = "Banks-Banksave";
		return driver.findElement(bankssave);
	}
	
    //Page Object model for banks edit click 
	By bankseditclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-bank-master/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");
	public WebElement getbankseditclick() {
		base.failedElementName = "Banks-bankseditclick";
		return driver.findElement(bankseditclick);
	}
   
	//Page Object model for banks edit add data
	By bankseditadddata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/"
			+ "mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getbankseditadddata() {
		base.failedElementName = "Banks-bankseditadddata";
		return driver.findElement(bankseditadddata);
	}
    
	//Page Object model for banks edit save
	By bankseditsave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getbankseditsave() {
		base.failedElementName = "Banks-bankseditsave";
		return driver.findElement(bankseditsave);
	}
   
	//Page object model for bank status
	By banksstatus = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-bank-master/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");
	public WebElement getbanksstatus() {
		base.failedElementName = "Banks-Banksstatus";
		return driver.findElement(banksstatus);
	}
	
	//Page object model for banks status confirmation
	By banksstatusconfirmation = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-delete-pop-up/form/mat-dialog-actions/button[2]");
	public WebElement getbanksstatusconfirmation() {
		base.failedElementName = "Banks-Bankstatusconfirmation";
		return driver.findElement(banksstatusconfirmation);
	}
	
	//Page object model for Banks delete click
	By Banksdeleteclick  = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-bank-master/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[3]");
	public WebElement getbanksdeleteclick() {
		base.failedElementName = "Banks-Banksdeleteclick";
		return driver.findElement(Banksdeleteclick);
	}
	
	//Page object model for Banks delete confirmation
	By Banksdeleteconfirmation = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-delete-pop-up/form/mat-dialog-actions/button[2]");
	public WebElement getBanksdeleteconfirmation() {
		base.failedElementName = "Banks-Banksdeleteconfirmation";
		return driver.findElement(Banksdeleteconfirmation);
	}
	
	//Page object for searched of banks 
	By Bankssearched = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-bank-master/div/div[1]/div[2]/div/input");
	public WebElement getBankssearched() {
		base.failedElementName = "Banks-BanksSearched";
		return driver.findElement(Bankssearched);
	}
	
	//Page object for banks searched click
	By bankssearchedclick = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-bank-master/div/div[1]/div[2]/div/mat-icon");
	public WebElement getbankssearchedclick() {
		base.failedElementName = "Banks-bankssearchedclick";
		return driver.findElement(bankssearchedclick);
	}
	
	//Page object for banks Excel click
	By banksExcelclick = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-bank-master/div/div[1]/div[2]/button[1]");
	public WebElement getbanksExcelclick() {
		base.failedElementName = "Banks-banksexcelclick";
		return driver.findElement(banksExcelclick);
	}
	
	//Page object for Active Inactive status 
	By activestatus = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/"
			+ "form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");
	public WebElement getActiveStatus() {
		return driver.findElement(activestatus);
	}
}