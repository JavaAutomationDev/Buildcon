package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Saccodepage {

	public WebDriver driver;

	public Saccodepage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Configuration form module
	By Configurationform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[12]/a/span");

	public WebElement getconfiguration() {
		base.failedElementName = "PropertyType-Configuration";
		return driver.findElement(Configurationform);
	}

	//Page object model for sac code:
	//Page object for click Configuration form module
	By saccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-configurations/div/div[2]/div/a[7]/div/mat-icon");
	public WebElement getsaccodeclick() {
		base.failedElementName = "SacCode-ClickSaccode";
		return driver.findElement(saccode);
	}

	//Page object model for add sac code click for add data
	By addsaccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-sac-code-master/div/div[1]/div[2]/button[2]");
	public WebElement getaddsaccode() {
		base.failedElementName = "SacCode-AddClick";
		return driver.findElement(addsaccode);
	}

	//Page object model for eneter a data
	By saccodeenter = By.xpath("//input[@formcontrolname='sacCode']");
	public WebElement getsaccodeenter() {
		base.failedElementName = "SacCode-code";
		return driver.findElement(saccodeenter);
	}

	//Page object model for Description
	By description = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/"
			+ "mat-dialog-content/div[1]/mat-form-field[2]/div[1]/div[2]/div[2]/textarea");
	public WebElement getdescription() {
		base.failedElementName = "SacCode-Description";
		return driver.findElement(description);
	}

	//Page object model for gst
	By gst = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-content/div"
					+ "[1]/mat-form-field[3]/div[1]/div[2]/div[2]/input");
	public WebElement getgst() {
		base.failedElementName = "SacCode-GST";
		return driver.findElement(gst);
	}

	//Page object model for save button for sac code
	By savebuttonsaccode = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getsavebuttonsaccode() {
		base.failedElementName = "SacCode-SaveClick";
		return driver.findElement(savebuttonsaccode);
	}

	//Page object model for Edit sac code
	By Editclicksaccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-sac-code-master/div/div[2]/div/table/tbody/tr[1]/td[5]/div/button[2]");
	public WebElement getEditclicksaccode() {
		base.failedElementName = "SacCode-EditClick";
		return driver.findElement(Editclicksaccode);
	}
	
	//Page object model for Edit sac
	By Editsacs = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div"
			+ "/form/mat-dialog-content/div[1]/mat-form-field[1]/div[1]/div[2]/div[2]/input");
	public WebElement getEditsacs() {
		return driver.findElement(Editsacs);
	}
	
	//Page object model for Edit sac description
	By Editsacdescription = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/"
			+ "form/mat-dialog-content/div[1]/mat-form-field[2]/div[1]/div[2]/div[2]/textarea");
	public WebElement getEditsacdescription() {
		return driver.findElement(Editsacdescription);
	}

	//Page object model for Edit Gst
	By Editgst = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-sac-code-master-add/div/form/"
			+ "mat-dialog-content/div[1]/mat-form-field[3]/div[1]/div[2]/div[2]/input");
	public WebElement getEditgst() {
		base.failedElementName = "SacCode-EditGST";
		return driver.findElement(Editgst);
	}

	//Page object model for Edit save button
	By Editsavebutton = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-sac-code-master-add/div/form/mat-dialog-actions/button[1]");
	public WebElement getEditsavebutton() {
		base.failedElementName = "SacCode-EditSave";
		return driver.findElement(Editsavebutton);
	}

	//Page object model for change status
	By changestatus = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-sac-code-master/div/div[2]/div/table/tbody/tr[1]/td[5]/div/button[1]");
	public WebElement getchangestatus() {
		base.failedElementName = "SacCode-ChangeStatus";
		return driver.findElement(changestatus);
	}

	//Page object model for change status confirm
	By changestatusconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getchangestatusconfirm() {
		base.failedElementName = "SacCode-ChangeStausConfirm";
		return driver.findElement(changestatusconfirm);
	}
	
	//Page object model for delete sac code
	By deletesaccode = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-sac-code-master/div/div[2]/div/table/tbody/tr[1]/td[5]/div/button[3]");
	public WebElement getdeletesaccode() {
		base.failedElementName = "SacCode-DeleteSaccode";
		return driver.findElement(deletesaccode);
	}

	//Page object model for delete sac code confirm
	By deletesaccodeconfirm = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getdeletesaccodeconfirm() {
		base.failedElementName = "SacCode-DeleteConfirm";
		return driver.findElement(deletesaccodeconfirm);
	}
	
	//Page object model for search sac code
	By searchsaccode = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-sac-code-master/div/div[1]/div[2]/div/input");
	public WebElement getsearchsaccode() {
		base.failedElementName = "SacCode-SearchSacCode";
		return driver.findElement(searchsaccode);
	}
	
	//Page object model for search sac code confirm click
	By searchsaccodeconfirmclick = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
			+ "main/vex-sac-code-master/div/div[1]/div[2]/div/mat-icon");
	public WebElement getsearchsaccodeconfirmclick() {
		base.failedElementName = "SacCode-Searchconfirm";
		return driver.findElement(searchsaccodeconfirmclick);
	}
	
	//Page object model for excel click sac code
	By excelclicksaccode = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-sac-code-master/div/div[1]/div[2]/button[1]");
	public WebElement getexcelclicksaccode() {
		base.failedElementName = "SacCode-ExcelClick";
		return driver.findElement(excelclicksaccode);
	}
	
	//Page object for Active Inactive status
	By activestatus = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-sac-code-master-add/div/form/mat-dialog-content/div[2]/div/mat-checkbox/div/div/input");
	public WebElement getActiveStatus() {
		return driver.findElement(activestatus);
	}
}