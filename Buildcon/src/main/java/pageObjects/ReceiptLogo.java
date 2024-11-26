package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class ReceiptLogo {
	public WebDriver driver;

	public ReceiptLogo(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}

	//Page object for Receipt Logo
	By Receiptlogo = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[15]/div/mat-icon");
	public WebElement getReceiptlogo() {
		return driver.findElement(Receiptlogo);
	}
	
	//Page object for Receipt logo click remove
	By Receiptlogoclickremove = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipt-logo/div/div[2]/div/div[1]/div/div/label/mat-icon");
	public WebElement getReceiptlogoclickremove() {
		return driver.findElement(Receiptlogoclickremove);
	}

	//Page object for receipt logo click new
	By Receiptlogoclicknew = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipt-logo/div/div[2]/div/div[1]/div/div/label/mat-icon");
	public WebElement getReceiptlogoclicknew() {
		return driver.findElement(Receiptlogoclicknew);
	}

	//page object for Attach profile photo
	public void attachProfilePhoto() {
		WebElement a = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
				+ "mat-sidenav-content/main/vex-receipt-logo/div/div[2]/div/div[1]/div/div/label/input"));
		a.sendKeys("C:\\Image\\images.jpg");
	}

	//Page object for receipt logo save
	By Receiptlogosave = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipt-logo/div/div[2]/div/div[2]/button");
	public WebElement getReceiptlogosave() {
		return driver.findElement(Receiptlogosave);
	}
}
