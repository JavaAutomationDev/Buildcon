package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormStatuspage {

	public WebDriver driver;

	public FormStatuspage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// page object model for Click on the terms and condition
	By FormStatuscick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[14]/div/mat-icon");

	public WebElement getFormStatuscick() {
		return driver.findElement(FormStatuscick);

	}

	// page object model for form status add
	By Nameofformstatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getNameofformstatus() {
		return driver.findElement(Nameofformstatus);
	}

	// page object model for save button for project types
	By usersclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[2]/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public WebElement getusersclick() {
		return driver.findElement(usersclick);
	}

	public void userselected(String userselected1) {
		driver.findElement(usersclick).click(); // Click to open dropdown
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));

		for (int i = 0; i < elements.size(); i++) {
			String text = elements.get(i).getText();
			if (text.equalsIgnoreCase(userselected1)) {
				int a = i + 1;
				driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option[" + a + "]")).click();
				break;
			}
		}
	}

	// page object model for add new data and clear existing data;
	By displayform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[3]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getdisplayform() {
		return driver.findElement(displayform);
	}

	// page object model for edit save button :
	By Clickonsavebutton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[4]/button");

	public WebElement getClickonsavebutton() {
		return driver.findElement(Clickonsavebutton);
	}

	// pom for delete click:
	By deleteclickFormstatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr[1]/td[4]/div/button[2]");

	public WebElement getdeleteclickFormstatus() {
		return driver.findElement(deleteclickFormstatus);
	}

	// pom for delete click confirmation:
	By deleteclickconfirmationFormstatus = By.xpath(
			"/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getdeleteclickconfirmationformstatus() {
		return driver.findElement(deleteclickconfirmationFormstatus);
	}

	// page object model for searching of project types:
	By searchForm = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[1]/div[2]/div/input");

	public WebElement getsearchsearchForm() {
		return driver.findElement(searchForm);
	}

	By clicksearchformstatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[1]/div[2]/div/mat-icon");

	public WebElement getclicksearchformstatus() {
		return driver.findElement(clicksearchformstatus);
	}

	By clickexportasexcelformstatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[1]/div[2]/button");

	public WebElement getclickexportasexcelformstatus() {
		return driver.findElement(clickexportasexcelformstatus);
	}

}
