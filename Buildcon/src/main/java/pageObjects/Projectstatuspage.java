package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Projectstatuspage {

	public WebDriver driver;

	public Projectstatuspage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/"
					+ "vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");
	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	//Page object for project status click:
	By projectStatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div"
					+ "[2]/div/a[4]/div/img");
	public WebElement getprojectstatusclick() {
		return driver.findElement(projectStatusclick);
	}

	//Page object for project status click:
	By addprojectStatusclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-project-status/div/div[1]/div[2]/button[2]");
	public WebElement getaddprojectstatusclick() {
		return driver.findElement(addprojectStatusclick);
	}

	//Page object for project status click:
	By projectStatusdataadd = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-status-add/div/form/"
					+ "mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getprojectstatusadddata() {
		return driver.findElement(projectStatusdataadd);
	}

	//Page object for project status click:
	By projectStatussave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-status-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getprojectstatussave() {
		return driver.findElement(projectStatussave);
	}

	//Page object for project status click:
	By projectStatusEditclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "vex-project-status/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");
	public WebElement getprojectstatuseditclick() {
		return driver.findElement(projectStatusEditclick);
	}

	//Page object for project status click:
	By projectStatuseditnewdataadd = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-status-add/div/form/"
					+ "mat-dialog-content/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getprojectStatuseditnewdataadd() {
		return driver.findElement(projectStatuseditnewdataadd);
	}

	//Page object for project status click:
	By projectStatuscheckedclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "vex-project-status/div/div[2]/div/table/tbody/tr[2]/td[3]/div/button[1]");
	public WebElement getprojectStatuschecked() {
		return driver.findElement(projectStatuscheckedclick);
	}

	//Page object for project status click:
	By projectStatuscheckedconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]");
	public WebElement getprojectStatuscheckedconfirmation() {
		return driver.findElement(projectStatuscheckedconfirmation);
	}

	//Page object for project status click:
	By projectStatusexcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
					+ "mat-sidenav-content/main/vex-project-status/div/div[1]/div[2]/button[1]");
	public WebElement getprojectStatusexcel() {
		return driver.findElement(projectStatusexcel);
	}

	//Page object for project status click:
	By projectStatussearchedchecked = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
					+ "mat-sidenav-content/main/vex-project-status/div/div[1]/div[2]/div/input");
	public WebElement getprojectStatussearchedchecked() {
		return driver.findElement(projectStatussearchedchecked);
	}

	By projectstatussearchediteam = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-status/div/div"
					+ "[1]/div[2]/div/mat-icon");
	public WebElement getprojectstatussearchediteam() {
		return driver.findElement(projectstatussearchediteam);
	}

	By projectstatusdeleteclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-status/div/div"
					+ "[2]/div/table/tbody/tr[2]/td[3]/div/button[3]");
	public WebElement getprojectstatusdeleteclick() {
		return driver.findElement(projectstatusdeleteclick);
	}

	By projectstatusdeleteconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getprojectstatusdeleteconfirmation() {
		return driver.findElement(projectstatusdeleteconfirmation);
	}
	
	//Page object for Active/Inactive
	By activestatus= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-project-status-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");
	public WebElement getActiveStatus() {
		return driver.findElement(activestatus);
	}
}
