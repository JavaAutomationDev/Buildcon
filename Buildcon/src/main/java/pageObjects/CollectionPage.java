package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectionPage {
	public WebDriver driver;

	public CollectionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page object for click Collection Module
	By Collection = By.xpath("//vex-sidenav-item[8]//a[1]");
	public WebElement getcollection() {
		return driver.findElement(Collection);
	}

	//Page object for Total Collection
	By totalcollection=By.xpath("//button[@mattooltip='Total Collection']");
	public WebElement getTotalCollection() {
		return driver.findElement(totalcollection);
	}
	//Page object for Cross Button		
	By Crossbtn=By.xpath("//button[@class='popclose']");	
	public WebElement getcross() {
		return driver.findElement(Crossbtn);
	}
	//Page object for Search 
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		return driver.findElement(Search);
	}
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/vex-collections/div/div[1]/div[2]/div[2]/div[4]/button");
	public WebElement getExporttoExcel() {
		return driver.findElement(ExporttoExcel);
	}
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-collections/div/div[1]/div[2]/div[2]/div[5]/button");
	public WebElement getapplyfilter() {
		return driver.findElement(filter);
	}

	//Page object for Date Range
	By Daterange=By.xpath("//mat-date-range-input[@role='group']");
	public WebElement getdaterange() {
		return driver.findElement(Daterange);
	}

	//Page object for Select Start Date
	By SelectstartDate=By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']");
	public WebElement getSelectstartDate() {
		return driver.findElement(SelectstartDate);
	}

	//Page object for Select End Date
	By SelectendDate=By.cssSelector("span.mat-calendar-body-cell-content.mat-focus-indicator.mat-calendar-body-selected");
	public WebElement getSelectEndDate() {
		return driver.findElement(SelectendDate);
	}
	//Page object for Reset Button
	By resetfilter=By.xpath("//button[@mattooltip='Reset Filters']");
	public WebElement getresetfilter() {
		return driver.findElement(resetfilter);
	}
	//Page object for Info Button
	By infobtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
				+ "main/vex-collections/div/div[2]/div/div/div/table/tbody/tr[1]/td[4]/span/a");
	public WebElement getInfoBtn() {
		return driver.findElement(infobtn);
	}
	//Page object for Print Info Button
	By printinfobtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-view-receipts/form/mat-dialog-content/div/div/div/table/tbody/tr/td[8]/div/button[1]/mat-icon");
	public WebElement getPrintInfoBtn() {
		return driver.findElement(infobtn);
	}
}