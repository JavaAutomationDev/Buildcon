package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class DocumentPage {

	public WebDriver driver;

	public DocumentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page object for Document Module
	By document = By.xpath("//vex-sidenav-item[10]//a[1]");
	public WebElement getDocument() {
		base.failedElementName = "Document-DocumentModule";
		return driver.findElement(document);
	}
	
	//Page object for Add Document
	By Adddocument = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[1]/div[2]/button");
	public WebElement getAddDocument() {
		base.failedElementName = "Document-AddDocument";
		return driver.findElement(Adddocument);
	}
	
	//Document Form
	//Page object for Document Title
	By documenttitle = By.xpath("//input[@formcontrolname='documentTitle']");
	public WebElement getDocumentTitle() {
		base.failedElementName = "Document-Title";
		return driver.findElement(documenttitle);
	}
	//Page object for Project
	By project = By.xpath("//mat-select[@formcontrolname='projectID']");
	public WebElement getProject() {
		base.failedElementName = "Document-Project";
		return driver.findElement(project);
	}

	//Page object for Page Layout
	By pagelayout = By.xpath("//mat-select[@formcontrolname='pageLayout']");
	public WebElement getPageLayout() {
		base.failedElementName = "Document-PageLayout";
		return driver.findElement(pagelayout);
	}
	
	//Page object for Page Size
	By pagesize = By.xpath("//mat-select[@formcontrolname='pageSize']");
	public WebElement getPageSize() {
		base.failedElementName = "Document-PageSize";
		return driver.findElement(pagesize);
	}
	
	//Page object for Margin Left
	By marginleft = By.xpath("//input[@formcontrolname='marginLeft']");
	public WebElement getMarginLeft() {
		base.failedElementName = "Document-MarginLeft";
		return driver.findElement(marginleft);
	}

	//Page object for Margin Right
	By marginright = By.xpath("//input[@formcontrolname='marginRight']");
	public WebElement getMarginRight() {
		base.failedElementName = "Document-MarginRight";
		return driver.findElement(marginright);
	}
	
	//Page object for Margin Top
	By margintop = By.xpath("//input[@formcontrolname='marginTop']");
	public WebElement getMarginTop() {
		base.failedElementName = "Document-MarginTop";
		return driver.findElement(margintop);
	}
	
	//Page object for Margin Bottom
	By marginbottom = By.xpath("//input[@formcontrolname='marginBottom']");
	public WebElement getMarginBottom() {
		base.failedElementName = "Document-MarginBottom";
		return driver.findElement(marginbottom);
	}
	
	//Page object for Search Document
	By search = By.xpath("");
	public WebElement getSearch() {
		base.failedElementName = "Document-Search";
		return driver.findElement(search);
	}
	
	//Page object for Apply Filter
	By applyfilter = By.xpath("");
	public WebElement getApplyFilter() {
		base.failedElementName = "Document-ApplyFilter";
		return driver.findElement(applyfilter);
	}

	//Page object for Apply Filter With Project
	By applyfilterproject = By.xpath("");
	public WebElement getApplyFilterProject() {
		base.failedElementName = "Document-ApplyFilterProject";
		return driver.findElement(applyfilterproject);
	}
	
	//Page object for Apply Filter Reset
	By applyfilterreset = By.xpath("");
	public WebElement getApplyFilterReset() {
		base.failedElementName = "Document-FilterReset";
		return driver.findElement(applyfilterreset);
	}

	//Page object for Edit Document
	By editDocument = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[2]/div/div/table/tbody/tr[1]/td[5]/div/a[1]");
	public WebElement getEditDocument() {
		base.failedElementName = "Document-Edit";
		return driver.findElement(editDocument);
	}
	
	//Page object for Delete Document
	By deleteDocument = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[2]/div/div/table/tbody/tr[1]/td[5]/div/a[2]");
	public WebElement getDeleteDocument() {
		base.failedElementName = "Document-Delete";
		return driver.findElement(deleteDocument);
	}
	
	//Page object for View Document
	By viewdocumnet = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-documents/div/div[2]/div/div/table/tbody/tr[1]/td[5]/div/a[3]");
	public WebElement getViewDocument() {
		base.failedElementName = "Document-View";
		return driver.findElement(viewdocumnet);
	}
	
}