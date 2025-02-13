package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base;

public class FormStatuspage {

	public WebDriver driver;

	public FormStatuspage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}

	// Page object model for Form Status click
	By FormStatuscick = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[14]/div/mat-icon");

	public WebElement getFormStatuscick() {
		base.failedElementName = "FormSatus-FormStatusClick";
		return driver.findElement(FormStatuscick);
	}

	// Page object model for Name of form status
	By Nameofformstatus = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-form-status/div/div[2]/div/form/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getNameofformstatus() {
		base.failedElementName = "FormSatus-NameofFormStatus";
		return driver.findElement(Nameofformstatus);
	}

	// Page object model for user click
	By usersclick2 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[2]/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public WebElement getusersclick2() {
		base.failedElementName = "FormSatus-Usersclick";
		return driver.findElement(usersclick2);
	}

	By usersclickDESELECT = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr/td[2]/div/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public WebElement GETusersclickDESELECT() {
		base.failedElementName = "FormSatus-Usersclick";
		return driver.findElement(usersclickDESELECT);
	}

	// pom for deselect the dropdown value:
	By usersclickdeselectclick = By.xpath("/html/body/div[4]/div[2]/div/div/mat-option");

	public WebElement getusersclickdeselectclick() {
		base.failedElementName = "FormSatus-usersclickdeselect";
		return driver.findElement(usersclickdeselectclick);
	}

	// Page object for user selected
	public void userSelected(String userSelected1) {
		// Find all dropdown options
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));

		// Loop through the options to find the matching one
		boolean found = false;
		for (WebElement element : elements) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			String text = element.getText();
			if (text.equalsIgnoreCase(userSelected1)) {
				element.click(); // Click on the matched option
				getusersclick2().sendKeys(Keys.ESCAPE);
				found = true;
				break;
			}
		}

		// Optional: Handle case where the desired user was not found
		if (!found) {
			System.out.println("User not found: " + userSelected1);

		}
		base.failedElementName = "FormSatus-UserSelected";
	}

	// Page object model for display form
	By displayform = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-form-status/div/div[2]/div/form/div[3]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getdisplayform() {
		base.failedElementName = "FormSatus-Displayform";
		return driver.findElement(displayform);
	}

	// Page object model for display form individual
	By displayformindividual = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "vex-form-status/div/div[2]/div/table/tbody/tr/td[3]/div/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getdisplayformindividual() {
		return driver.findElement(displayformindividual);
	}

	// Page object model for Click on save button individual
	By Clickonsavebuttonindividual = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-form-status/div/div[2]/div/table/tbody/tr/td[4]/div/button[1]");

	public WebElement getClickonsavebuttonindividual() {
		return driver.findElement(Clickonsavebuttonindividual);
	}

	// Page object model for Click on save button
	By Clickonsavebutton = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-form-status/div/div[2]/div/form/div[4]/button");

	public WebElement getClickonsavebutton() {
		base.failedElementName = "FormSatus-ClickSave";
		return driver.findElement(Clickonsavebutton);
	}

	// Page object model for edit click form status
	By editclickformstatus = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-form-status/div/div[2]/div/table/tbody/tr[1]/td[4]/div/button[1]");

	public WebElement geteditclickformstatus() {
		return driver.findElement(editclickformstatus);
	}

	// Page object model for edit click enter data
	By editclickenterdata = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "vex-form-status/div/div[2]/div/table/tbody/tr[1]/td[1]/div/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement geteditclickenterdata() {
		return driver.findElement(editclickenterdata);
	}

	// Page object model for edit click save form status
	By editclicksaveformstatus = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-form-status/div/div[2]/div/table/tbody/tr[1]/td[4]/div/button[1]");

	public WebElement geteditclicksaveformstatus() {
		return driver.findElement(editclicksaveformstatus);
	}

	// Page objec model for delete click Form status
	//By deleteclickFormstatus = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
	//		+ "mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr[1]/td[4]/div/button[2]");
	
	By deleteclickFormstatus = By.xpath("//tbody//button[2]//span[3]");
	
	
	public WebElement getdeleteclickFormstatus() {
		base.failedElementName = "FormSatus-ClickDelete";
		return driver.findElement(deleteclickFormstatus);
	}

	// Page object for delete click confirmation Form status
	By deleteclickconfirmationFormstatus = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getdeleteclickconfirmationformstatus() {
		base.failedElementName = "FormSatus-DeleteConfirm";
		return driver.findElement(deleteclickconfirmationFormstatus);
	}

	// Page object model for search Form
	By searchForm = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-form-status/div/div[1]/div[2]/div/input");

	public WebElement getsearchsearchForm() {
		base.failedElementName = "FormSatus-Search";
		return driver.findElement(searchForm);
	}

	// Page object model for click search form status
	By clicksearchformstatus = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-form-status/div/div[1]/div[2]/div/mat-icon");

	public WebElement getclicksearchformstatus() {
		base.failedElementName = "FormSatus-ClickSearchFormStatus";
		return driver.findElement(clicksearchformstatus);
	}

	// Page object model for click export as excel form status
	By clickexportasexcelformstatus = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
					+ "mat-sidenav-content/main/vex-form-status/div/div[1]/div[2]/button");

	public WebElement getclickexportasexcelformstatus() {
		base.failedElementName = "FormSatus-ExportExcel";
		return driver.findElement(clickexportasexcelformstatus);
	}

	By userdropdownopen = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-form-status/div/div[2]/div/table/tbody/tr/td[2]/div/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public WebElement getuserdropdownopen() {
		base.failedElementName = "FormSatus-ExportExcel";
		return driver.findElement(userdropdownopen);
	}
	
	// page object model for formstatus
	public void getuserdropdownselect(String [] desiredValues) throws InterruptedException {
	// Get all dropdown options only once
	List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));

	// Loop through desired values and select matching options
	for (String desiredValue : desiredValues) {
	    boolean optionFound = false; // Flag to check if the option is found
	    for (WebElement element : elements) {
	        String optionText = element.getText();  // Get the text of the current dropdown option

	        // Check if the current option matches the desired value
	        if (optionText.equals(desiredValue)) {
	            element.click();  // Click to select the matching option
	            optionFound = true;  // Mark as found
	            break;  // Exit the loop once the value is found and clicked
	        }
	        Thread.sleep(1000);  // Small delay to prevent rapid clicks (optional)
	    }

	    // If the option is not found, print a warning (optional)
	    if (!optionFound) {
	        System.out.println("Desired value: " + desiredValue + " not found in the dropdown");
	    }
	}
	
	}

}