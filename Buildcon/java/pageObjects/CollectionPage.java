package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class CollectionPage {
	public WebDriver driver;

	public CollectionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page object for click Collection Module
	By Collection = By.xpath("//vex-sidenav-item[8]//a[1]");
	public WebElement getcollection() {
		base.failedElementName = "Collection-clickcollection";
		return driver.findElement(Collection);
	}

	//Page object for Total Collection
	By totalcollection=By.xpath("//button[@mattooltip='Total Collection']");
	public WebElement getTotalCollection() {
		base.failedElementName = "Collection-TotalCollection";
		return driver.findElement(totalcollection);
	}
	
	//Page object for Cross Button		
	By Crossbtn=By.xpath("//button[@class='popclose']");	
	public WebElement getcross() {
		base.failedElementName = "Collection-Crossbtn";
		return driver.findElement(Crossbtn);
	}
	
	//Page object for Search 
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		base.failedElementName = "Collection-Search";
		return driver.findElement(Search);
	}
	
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/vex-collections/div/div[1]/div[2]/div[2]/div[4]/button");
	public WebElement getExporttoExcel() {
		base.failedElementName = "Collection-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}
	
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-collections/div/div[1]/div[2]/div[2]/div[5]/button");
	public WebElement getapplyfilter() {
		base.failedElementName = "Collection-Filter";
		return driver.findElement(filter);
	}

	//Page object for Date Range
	By Daterange=By.xpath("//mat-date-range-input[@role='group']");
	public WebElement getdaterange() {
		base.failedElementName = "Collection-Daterange";
		return driver.findElement(Daterange);
	}

	//Page object for Select Start Date
//	By SelectstartDate=By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']");
//	public WebElement getSelectstartDate() {
//		base.failedElementName = "Collection-selectStDate";
//		return driver.findElement(SelectstartDate);
//	}

	//Page object for Select End Date
//	By SelectendDate=By.cssSelector("span.mat-calendar-body-cell-content.mat-focus-indicator.mat-calendar-body-selected");
//	public WebElement getSelectEndDate() {
//		base.failedElementName = "Collection-SelectEndDt";
//		return driver.findElement(SelectendDate);
//	}
	
	//Page object for Project Select Dropdown Button
	By projcetdropdown=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-collections/div/div[2]/div/div[2]/mat-form-field/div[1]/div[2]/div/mat-select");
	public void getProjcetdropdown(String ProjectDropdown) {
		WebElement dropdown = driver.findElement(projcetdropdown);
		dropdown.click();
		
		base.failedElementName = "Collection-Projcet Dropdown";
		 String optionXPath = "//span[@class='mdc-list-item__primary-text' and text()='" + ProjectDropdown + "']";  
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	
	//Page object for Reset Button
	By resetfilter=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-collections/div/div[2]/div/div[3]/button");
	public WebElement getresetfilter() {
		base.failedElementName = "Collection-ResetFilter";
		return driver.findElement(resetfilter);
	}
	
	//Page object for Info Button
	By infobtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
				+ "main/vex-collections/div/div[2]/div/div/div/table/tbody/tr[1]/td[4]/span/a");
	public WebElement getInfoBtn() {
		return driver.findElement(infobtn);
	}
	
	//Page object for Print Info Button
	By printinfobtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-view-receipts/form/mat-dialog-content/div/div/div/table/tbody/tr/td[8]/div/button[1]");
	public WebElement getPrintInfoBtn() {
		return driver.findElement(printinfobtn);
	}
	
	//Page object for Download Receipt Button
	By downloadreceiptbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-view-receipts/form/mat-dialog-content/div/div/div/table/tbody/tr/td[8]/div/button[2]");
	public WebElement getDownloadReceiptBtn() {
		return driver.findElement(downloadreceiptbtn);
	}

}