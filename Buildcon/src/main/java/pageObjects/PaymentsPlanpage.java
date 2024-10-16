package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentsPlanpage {

	public WebDriver driver;

	public PaymentsPlanpage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// pom for addpaymentplan:
	By paymentplan = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-payment-plan-master/div/div"
					+ "[1]/div[2]/button[2]");

	public WebElement getpaymentplan() {
		return driver.findElement(paymentplan);
	}

	// pom fovr add paymentplan name in testbox:
	By addpaymentplan = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-content/div[1]/mat-form-field/div"
					+ "[1]/div[2]/div[2]/input");

	public WebElement getaddpaymentplan() {
		return driver.findElement(addpaymentplan);
	}

	// pom for add iscommercial checkboxclick:
	By checkediscommercial = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-content/div"
					+ "[2]/div/mat-checkbox/div/div/div[4]");

	public WebElement getcheckediscommercial() {
		return driver.findElement(checkediscommercial);
	}

	// pom fovr add paymentplan name in testbox:
	By paymentplansave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getpaymentplansave() {
		return driver.findElement(paymentplansave);
	}

	// pom for Edit the payment plan:
	By EditpaymentplanClick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-payment-plan-master/div/div"
					+ "[2]/div/table/tbody/tr[1]/td[3]/div/button[1]");

	public WebElement getEditpaymentplan() {
		return driver.findElement(EditpaymentplanClick);
	}

	// pom for edit save button:
	By Editpaymentplansave = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan-master-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getEditpaymentplansave() {
		return driver.findElement(Editpaymentplansave);
	}

	// pom for delete the entry :

	By Deletepaymentplanclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-payment-plan-master/div/div"
					+ "[2]/div/table/tbody/tr[1]/td[3]/div/button[2]");

	public WebElement getDeletepaymentplanclick() {
		return driver.findElement(Deletepaymentplanclick);
	}

	By Deleteconfirmation = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getDeleteconfirmation() {
		return driver.findElement(Deleteconfirmation);
	}

	// pom for searching the entry:
	By searchingpaymentplan = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-payment-plan-master/div/div[1]/div"
					+ "[2]/div/input");

	public WebElement getseaechingpaymentplan() {
		return driver.findElement(searchingpaymentplan);
	}

	// pom for searchedclick:
	By searchedclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-payment-plan-master/div/div"
					+ "[1]/div[2]/div/mat-icon");

	public WebElement getsearchedclick() {
		return driver.findElement(searchedclick);

	}

}
