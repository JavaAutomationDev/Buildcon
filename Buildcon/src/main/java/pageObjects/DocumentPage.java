package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocumentPage {

	public WebDriver driver;

	public DocumentPage(WebDriver driver) {
		this.driver = driver;
	}
	//Page object for Document module
	By document = By.xpath("//vex-sidenav-item[10]//a[1]");
	public WebElement getDocument() {
		return driver.findElement(document);
	}
	//Page object for Add Document module
	By Adddocument = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[1]/div[2]/button");
	public WebElement getAddDocument() {
		return driver.findElement(Adddocument);
	}
	//Document Form
	//Page object for Document Title
	By documenttitle = By.xpath("//input[@formcontrolname='documentTitle']");
	public WebElement getDocumentTitle() {
		return driver.findElement(documenttitle);
	}
	//Page object for Project
	By project = By.xpath("//mat-select[@formcontrolname='projectID']");
	public WebElement getProject() {
		return driver.findElement(project);
	}

	//Page object for Page Layout
	By pagelayout = By.xpath("//mat-select[@formcontrolname='pageLayout']");
	public WebElement getPageLayout() {
		return driver.findElement(pagelayout);
	}
	//Page object for Page Size
	By pagesize = By.xpath("//mat-select[@formcontrolname='pageSize']");
	public WebElement getPageSize() {
		return driver.findElement(pagesize);
	}
	//Page object for Margin Left
	By marginleft = By.xpath("//input[@formcontrolname='marginLeft']");
	public WebElement getMarginLeft() {
		return driver.findElement(marginleft);
	}

	//Page object for Margin Right
	By marginright = By.xpath("//input[@formcontrolname='marginRight']");
	public WebElement getMarginRight() {
		return driver.findElement(marginright);
	}
	//Page object for Margin Top
	By margintop = By.xpath("//input[@formcontrolname='marginTop']");
	public WebElement getMarginTop() {
		return driver.findElement(margintop);
	}
	//Page object for Margin Bottom
	By marginbottom = By.xpath("//input[@formcontrolname='marginBottom']");
	public WebElement getMarginBottom() {
		return driver.findElement(marginbottom);
	}
	//Page object for search Document
	By search = By.xpath("");
	public WebElement getSearch() {
		return driver.findElement(search);
	}
	//Page object for Apply Filter
	By applyfilter = By.xpath("");
	public WebElement getApplyFilter() {
		return driver.findElement(applyfilter);
	}

	//Page object for Apply Filter With Project
	By applyfilterproject = By.xpath("");
	public WebElement getApplyFilterProject() {
		return driver.findElement(applyfilterproject);
	}
	//Page object for Apply Filter Reset
	By applyfilterreset = By.xpath("");
	public WebElement getApplyFilterReset() {
		return driver.findElement(applyfilterreset);
	}

	//Page object for Edit Document
	By edit = By.xpath("");
	public WebElement getEdit() {
		return driver.findElement(edit);
	}	
	//Page object for Delete Document
	By delete = By.xpath("");
	public WebElement getdelete() {
		return driver.findElement(delete);
	}
	//Page object for View Document
	By view = By.xpath("");
	public WebElement getView() {
		return driver.findElement(view);
	}
}