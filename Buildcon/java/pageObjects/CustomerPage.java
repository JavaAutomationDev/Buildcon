package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class CustomerPage {

	public WebDriver driver;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page object for click Customer module
	By Customer = By.xpath("//vex-sidenav-item[6]//a[1]");
	public WebElement getCustomer() {
		base.failedElementName = "Customer-CustomerModule";
		return driver.findElement(Customer);
	}

	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-members/div/div[1]/div[2]/div[2]/button");
	public WebElement getExporttoExcel() {
		base.failedElementName = "Customer-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}
	
	//Page object for Search Customer
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		base.failedElementName = "Customer-Search";
		return driver.findElement(Search);
	}
	
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/vex-members/div/div[1]/div[2]/div[3]/button");
	public WebElement getapplyfilter() {
		base.failedElementName = "Customer-Filter";
		return driver.findElement(filter);
	}
	
	//Page object for Select Project Dropdown
	By selectproject=By.xpath("//mat-select[@placeholder='Select Project']");
	public void getselectproject(String project) {
		WebElement dropdown = driver.findElement(selectproject);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Customer-getselectproject";
		
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + project + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	
	//Page object for Reset Button
	By resetfilter=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-members/div/div[2]/div/div[3]/button");
	public WebElement getresetfilter() {
		base.failedElementName = "Customer-ResetFilter";
		return driver.findElement(resetfilter);
	}
	
	//Page object for Cancel Radio Button
	By cancelRadiobtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-members/div/div[2]/div/div[2]/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement getCancelRadioBtn() {
		base.failedElementName = "Customer-RadioBtn";
		return driver.findElement(cancelRadiobtn);
	}
	
	//Page object for Document Click
	By Documentview=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-members/div/div[3]/div/div/table/tbody/tr[1]/td[12]/div/a");
	public WebElement getDocumentview() {
		base.failedElementName = "Customer-DocumentView";
		return driver.findElement(Documentview);
	}
	
	//Page object for Files 
	By Files=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-member-info/div/mat-dialog-content/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span[2]");
	public WebElement getFiles() {
		base.failedElementName = "Customer-Files";
		return driver.findElement(Files);
	}
	
	//Page object for Document View		
	By Document=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-member-info/div/mat-dialog-content/mat-accordion/mat-expansion-panel[2]/mat-expansion-panel-header/span[2]");	
	public WebElement getdocument() {
		base.failedElementName = "Customer-Document";
		return driver.findElement(Document);
	}
	
	//Page object for Cross Button		
	By Crossbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-member-info/div/div/div/button");	
	public WebElement getcross() {
		base.failedElementName = "Customer-CrossBtn";
		return driver.findElement(Crossbtn);
	}
	
	//Method for Customer Listing
	By CstList = By.xpath("//tr");	
	public boolean webElementList()
	{	
		for (int i = 1; i <= 10; i++) 
		{
			for (int j = 1; j <= 10; j++) 
			{
				String cellXpath = "/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
						+ "/mat-sidenav-content/main/vex-members/div/div[2]/div/div/table/tbody/tr[" + i + "]/td[" + j + "]";
				WebElement cell = driver.findElement(By.xpath(cellXpath));
				if(cell.getText().equalsIgnoreCase("Abhishek"))
				{

				}
				System.out.println(cell.getText());
			}
	    }
		return false;
	}
}