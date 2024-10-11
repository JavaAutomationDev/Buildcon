package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Saccodepage {

	public WebDriver driver;

	public Saccodepage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]"
					+ "/div[2]/div/div/div/div[1]/vex-sidenav-item[11]/a/span");

	public WebElement getconfiguration() {
		return driver.findElement(Configurationform);
	}

	// page object model for sac code:

	// Page object for click Configuration form module
	By saccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[7]/div/mat-icon");

	public WebElement getsaccodeclick() {
		return driver.findElement(saccode);
	}

	// page object model for add sac code click for add data
	By addsaccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-sac-code-master/div/div"
					+ "[1]/div[2]/button[2]");

	public WebElement getaddsaccode() {
		return driver.findElement(addsaccode);
	}

	// page object model for eneter a data:
	By saccodeenter = By.xpath(
			"//input[@formcontrolname='sacCode']");

	public WebElement getsaccodeenter() {
		return driver.findElement(saccodeenter);
	}

	// page object model for Description:

	By description = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div[1]/mat-form-field[2]/div[1]/div[2]/div[2]/textarea");

	public WebElement getdescription() {
		return driver.findElement(description);
	}

	// page object model for gst:
	By gst = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div"
					+ "[1]/mat-form-field[3]/div[1]/div[2]/div[2]/input");

	public WebElement getgst() {
		return driver.findElement(gst);
	}

	// page object model for save button for sac code:
	By savebuttonsaccode = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getsavebuttonsaccode() {
		return driver.findElement(savebuttonsaccode);
	}

	// Edit for sac code:
	By Editclicksaccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-sac-code-master/div/div[2]/div/table/tbody/tr[1]/td[5]/div/button[2]");

	public WebElement getEditclicksaccode() {
		return driver.findElement(Editclicksaccode);
	}

	By Editgst = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div[1]/mat-form-field[3]/div[1]/div[2]/div[2]/input");

	public WebElement getEditgst() {
		return driver.findElement(Editgst);
	}

	By Editsavebutton = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-actions/button[1]");

	public WebElement getEditsavebutton() {
		return driver.findElement(Editsavebutton);
	}

	By changestatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-sac-code-master/div/div[2]/div/table/tbody/tr[1]/td[5]/div/button[1]");

	public WebElement getchangestatus() {
		return driver.findElement(changestatus);
	}

	By changestatusconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getchangestatusconfirm() {
		return driver.findElement(changestatusconfirm);
	}
	

	By deletesaccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-sac-code-master/div/div[2]/div/table/tbody/tr[1]/td[5]/div/button[3]");

	public WebElement getdeletesaccode() {
		return driver.findElement(deletesaccode);
	}
	

	By deletesaccodeconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getdeletesaccodeconfirm() {
		return driver.findElement(deletesaccodeconfirm);
	}
	

	By searchsaccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-sac-code-master/div/div[1]/div[2]/div/input");
	public WebElement getsearchsaccode() {
		return driver.findElement(searchsaccode);
	}
	
	By searchsaccodeconfirmclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-sac-code-master/div/div[1]/div[2]/div/mat-icon");
	public WebElement getsearchsaccodeconfirmclick() {
		return driver.findElement(searchsaccodeconfirmclick);
	}
	
	By excelclicksaccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-sac-code-master/div/div[1]/div[2]/button[1]");
	public WebElement getexcelclicksaccode() {
		return driver.findElement(excelclicksaccode);
	}
	
}

