package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bankspage {

	public WebDriver driver;

	public Bankspage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	By Banksclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div"
					+ "[2]/div/a[6]/div/mat-icon");

	public WebElement getBanksclick() {
		return driver.findElement(Banksclick);

	}

	By Banksadd = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bank-master/div/div[1]/div[2]/button[2]");

	public WebElement getBanksadd() {
		return driver.findElement(Banksadd);

	}

	By Banksadddata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div"
					+ "[2]/input");

	public WebElement getBanksadddata() {
		return driver.findElement(Banksadddata);

	}

	By bankssave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getbankssave() {
		return driver.findElement(bankssave);
	}
  // pAGE Object model for edit the banks :

	By bankseditclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bank-master/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");

	public WebElement getbankseditclick() {
		return driver.findElement(bankseditclick);
	}
   

	By bankseditadddata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getbankseditadddata() {
		return driver.findElement(bankseditadddata);
	}
    

	By bankseditsave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-bank-master-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getbankseditsave() {
		return driver.findElement(bankseditsave);
	}
   
	// page object model for status changed:
	By banksstatus = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bank-master/div/div[2]/div/table/tbody/tr[1]/td"
			+ "[3]/div/button[1]");
	
	public WebElement getbanksstatus() {
		return driver.findElement(banksstatus);
	}
	
	By banksstatusconfirmation = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]");
	
	public WebElement getbanksstatusconfirmation() {
		return driver.findElement(banksstatusconfirmation);
	}
	
	By Banksdeleteclick  = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bank-master/div/div[2]/div/table/tbody/tr[1]/td"
			+ "[3]/div/button[3]");
	public WebElement getbanksdeleteclick() {
		return driver.findElement(Banksdeleteclick);
	}
	
	By Banksdeleteconfirmation = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]");
	public WebElement getBanksdeleteconfirmation() {
		return driver.findElement(Banksdeleteconfirmation);
	}
	
	//pom for searched of banks 
	By Bankssearched = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bank-master/div/div[1]/div[2]/div/input");
	public WebElement getBankssearched() {
		return driver.findElement(Bankssearched);
	}
	
	By bankssearchedclick = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bank-master/div/div[1]/div[2]/div/mat-icon");
	public WebElement getbankssearchedclick() {
		return driver.findElement(bankssearchedclick);
	}
	
	By banksExcelclick = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bank-master/div/div[1]/div[2]/button[1]");
	public WebElement getbanksExcelclick() {
		return driver.findElement(banksExcelclick);
	}
	
	
}
