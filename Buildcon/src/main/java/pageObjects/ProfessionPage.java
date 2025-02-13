package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class ProfessionPage {
	public WebDriver driver;

	public ProfessionPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// Page object for click Profession menu
	By Profession = By.xpath("//a[@routerlink='/config/profession']");

	public WebElement getProfession() {
		base.failedElementName = "Configuration-Profession";
		return driver.findElement(Profession);
	}

	// Page object for click Add New Profession
	By AddNewProfession = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-profession/div/div[1]/div[2]/button[2]");

	public WebElement getAddNewProfession() {
		base.failedElementName = "Profession-AddNewProfession";
		return driver.findElement(AddNewProfession);
	}

	// Page object for Name Of Profession
	By ProfessionName = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-profession-add/div/form/mat-dialog-content/div/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getProfessionName() {
		base.failedElementName = "Profession-ProfessionName";
		return driver.findElement(ProfessionName);
	}

	// Page object for click on the Save button
	By SaveButton = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-profession-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getSaveButton() {
		base.failedElementName = "Profession-SaveButton";
		return driver.findElement(SaveButton);
	}

	// Page object for click on the Edit button
	By EditButton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-profession/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");

	public WebElement getEditButton() {
		base.failedElementName = "Profession-EditButton";
		return driver.findElement(EditButton);
	}

	// Page object for click on the Search
	By Search = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-profession/div/div[1]/div[2]/div/input");

	public WebElement getSearch() {
		base.failedElementName = "Profession-Search";
		return driver.findElement(Search);
	}

	// Page object for click on the Export To Excel
	By ExportToExcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-profession/div/div[1]/div[2]/button[1]");

	public WebElement getExportToExcel() {
		base.failedElementName = "Profession-ExportToExcel";
		return driver.findElement(ExportToExcel);
	}

	// Page object for click on the DeleteButton
	By DeleteButton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-profession/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[3]");

	public WebElement getDeleteButton() {
		base.failedElementName = "Profession-DeleteButton";
		return driver.findElement(DeleteButton);
	}

	// Page object for click on the ChangeStatus
	By ChangeStatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-profession/div/div[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");

	public WebElement getChangeStatus() {
		base.failedElementName = "Profession-ChangeStatus";
		return driver.findElement(ChangeStatus);
	}
	
	// Page object for click on the YesButton
		By YesButton = By.xpath(
				"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

		public WebElement getYesButton() {
			base.failedElementName = "Profession-YesButton";
			return driver.findElement(YesButton);
		}

}
