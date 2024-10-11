package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Projecttypespage {

	public WebDriver driver;

	public Projecttypespage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// page object model for Click on the project types
	By projecttypes = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div"
					+ "[2]/div/a[3]/div/mat-icon");

	public WebElement projecttypesclick() {
		return driver.findElement(projecttypes);

	}

	// page object model for add project types
	By addprojecttypes = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-type/div/div[1]"
					+ "/div[2]/button");

	public WebElement Clickaddprojecttypes() {
		return driver.findElement(addprojecttypes);
	}

	// page object model for enter test for add project types
	By Entertestaddprojecttypes = By.xpath(
			"//input[@formcontrolname='typeName']");

	public WebElement getaddprojecttypesdata() {
		return driver.findElement(Entertestaddprojecttypes);
	}

	// page object model for save button for project types
	By savebuttonprojecttypes = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-type-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getsavebuttonprojecttypes() {
		return driver.findElement(savebuttonprojecttypes);
	}

	// page object model for edit project types
	By Editprojecttypesrow = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-type/div/div"
					+ "[2]/div/table/tbody/tr/td[3]/div/button[2]");

	public WebElement geteditprojecttypes() {
		return driver.findElement(Editprojecttypesrow);
	}

	// page object model for add new data and clear existing data;
	By Editprojecttypedata = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-type-add/div/form/mat-dialog-content/"
					+ "div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement geteditexistingdata() {
		return driver.findElement(Editprojecttypedata);
	}

	// page object model for edit save button :
	By editsavebutton = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-type-add/div/form/mat-dialog-actions/button[1]");

	public WebElement geteditsave() {
		return driver.findElement(editsavebutton);
	}

	// page object model for change status
	By changestatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-type/div/div[2]"
					+ "/div/table/tbody/tr/td[3]/div/button[1]");

	public WebElement getclickchangestatus() {
		return driver.findElement(changestatus);
	}

	// pom for changestatus confirmation dialog box:
	By changestatusconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getconfirmationchangestatus() {
		return driver.findElement(changestatusconfirmation);
	}

	// pom for delete click:
	By deleteclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-type/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[3]");

	public WebElement getdeleteclick() {
		return driver.findElement(deleteclick);
	}

	// pom for delete click confirmation:
	By deleteclickconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getdeleteclickconfirmation() {
		return driver.findElement(deleteclickconfirmation);
	}

	// page object model for searching of project types:
	By searchingprojecttypes = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-type/div/div"
					+ "[1]/div[2]/div[1]/input");

	public WebElement getsearchprojecttypes() {
		return driver.findElement(searchingprojecttypes);
	}

	By clicksearchedbutton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-type/div/div[1]/div"
					+ "[2]/div[1]/mat-icon");

	public WebElement getclicksearchedbutton() {
		return driver.findElement(clicksearchedbutton);
	}
	
	
	By clickexcelbuttonproject = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-project-type/div/div[1]/div[2]/div[2]/button");

	public WebElement getclickexcelbuttonproject() {
		return driver.findElement(clickexcelbuttonproject);
	}
	
	//Page object for Active/Inactive Project
	//By activeproject = By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/vex-project-type-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");	
	public void getActiveProject() {
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-project-type-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input")).click();
	}
}