package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage {
	public WebDriver driver;

	public ProjectPage(WebDriver driver) {
		this.driver=driver;
	}
	//Page object for Project Module
	By Project=By.xpath("//vex-sidenav-item[4]//a[1]");
	public WebElement getproject() {
		return driver.findElement(Project);
	}
	//Page object for Add Project
	By AddProject=By.xpath("//span[contains(text(),'add new project')]");
	public WebElement getaddproject() {
		return driver.findElement(AddProject);
	}
	//Page object for Project Name
	By ProjectName=By.xpath("//input[@formcontrolname='projectName']");
	public WebElement getProjectName() {
		return driver.findElement(ProjectName);
	}
	//Page object for Project Type
	By Projecttype=By.xpath("//mat-select[@formcontrolname='projectTypeID']");
	public void getProjecttype(String projecttype) {
		WebElement dropdown = driver.findElement(Projecttype);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + projecttype + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Project Status
	By Projectstatus=By.xpath("//mat-select[@formcontrolname='projectStatusID']");
	public void getProjectstatus(String projectstatus) {
		WebElement dropdown = driver.findElement(Projectstatus);
		dropdown.click();
		String optionXpath="//mat-option//span[contains(text(),'" + projectstatus + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	//Page object for Expected Start Date
	public WebElement getExstartdate() {
		WebElement nextExpectedUpElement = driver.findElement(By.xpath("//input[@formcontrolname='expectedStartDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextExpectedUpElement.sendKeys(formattedDate);
		return nextExpectedUpElement;
	}
	//Page object for Expected Start Date
	public WebElement getExEnddate() {
		WebElement nextExpectedUpElement = driver.findElement(By.xpath("//input[@formcontrolname='expectedEndDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 2);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextExpectedUpElement.sendKeys(formattedDate);
		return nextExpectedUpElement;
	}
	//Page object for Actual Start Date
	public WebElement getActualstartdate() {
		WebElement nextActualUpElement = driver.findElement(By.xpath("//input[@formcontrolname='actualStartDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 48);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextActualUpElement.sendKeys(formattedDate);
		return nextActualUpElement;
	}
	//Page object for Actual End Date
	public WebElement getActualenddate() {
		WebElement nextActualUpElement = driver.findElement(By.xpath("//input[@formcontrolname='actualEndDate']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 570);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextActualUpElement.sendKeys(formattedDate);
		return nextActualUpElement;
	}
	//Page object for Total Saleable Area
	By TotalsaleableArea=By.xpath("//input[@formcontrolname='totalSaleableArea']");
	public WebElement getTotalsaleableArea() {
		return driver.findElement(TotalsaleableArea);
	}
	//Page object for SPNO
	By spNo=By.xpath("//input[@formcontrolname='spNo']");
	public WebElement getspNo() {
		return driver.findElement(spNo);
	}
	//Page object for City
	By City=By.xpath("//input[@formcontrolname='city']");
	public WebElement getcity() {
		return driver.findElement(City);
	}
	//Page object for State
	By State=By.xpath("//mat-select[@formcontrolname='stateID']");
	public void getstate(String state) {
		WebElement dropdown = driver.findElement(State);
		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + state + "')]";  
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Sales Exectuive
	By SalesExectuive=By.xpath("//mat-select[@formcontrolname='salesExecutiveID']");
	public void getSalesExectuive(String salesExectuive) {
		WebElement dropdown = driver.findElement(SalesExectuive);
		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + salesExectuive + "')]";  
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
		dropdown.sendKeys(Keys.ESCAPE); 
	}
	//Page object for Description
	By Description=By.xpath("//textarea[@formcontrolname='description']");
	public WebElement getdescription() {
		return driver.findElement(Description);
	}
	//Page object for Address
	By Address=By.xpath("//textarea[@formcontrolname='address']");
	public WebElement getAddress() {
		return driver.findElement(Address);
	}
	//Page object for Next Button
	By Nextbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextbtn() {
		return driver.findElement(Nextbtn);
	}
	//Page object for East
	By East=By.xpath("//input[@formcontrolname='east']");
	public WebElement getEast() {
		return driver.findElement(East);
	}
	//Page object for West
	By west=By.xpath("//input[@formcontrolname='west']");
	public WebElement getWest() {
		return driver.findElement(west);
	}
	//Page object for South
	By south=By.xpath("//input[@formcontrolname='south']");
	public WebElement getSouth() {
		return driver.findElement(south);
	}
	//Page object for North
	By North=By.xpath("//input[@formcontrolname='north']");
	public WebElement getNorth() {
		return driver.findElement(North);
	}
	//Page object for Plot No
	By PlotNo=By.xpath("//input[@formcontrolname='plotNo']");
	public WebElement getPlotNo() {
		return driver.findElement(PlotNo);
	}
	//Page object for Scheme No
	By schemeNo=By.xpath("//input[@formcontrolname='schemeNo']");
	public WebElement getschemeNo() {
		return driver.findElement(schemeNo);
	}
	//Page object for Rera
	By Rera=By.xpath("//input[@formcontrolname='rera']");
	public WebElement getRera() {
		return driver.findElement(Rera);
	}
	//Page object for Total Land Area
	By totalLandArea=By.xpath("//input[@formcontrolname='totalLandArea']");
	public WebElement gettotalLandArea() {
		return driver.findElement(totalLandArea);
	}
	//Page object for Maintenance Charge
	By MaintenanceCharge=By.xpath("//input[@formcontrolname='maintenanceCharge']");
	public WebElement getMaintenanceCharge() {
		return driver.findElement(MaintenanceCharge);
	}
	//Page object for Maintenance Deposit
	By MaintenanceDeposit=By.xpath("//input[@formcontrolname='maintenanceDeposit']");
	public WebElement getMaintenanceDeposit() {
		return driver.findElement(MaintenanceDeposit);
	}

	//Page object for NextBtn1
	By Nextbtn1=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextbtn1() {
		return driver.findElement(Nextbtn1);
	}

	//Fields which will appear in Receipt
	//Page object for Company Name
	By companyname=By.xpath("//input[@formcontrolname='recAppearProjectName']");
	public WebElement getCompanyName() {
		return driver.findElement(companyname);
	}
	//Page object for GSTIN No
	By gstinno=By.xpath("//input[@formcontrolname='gstin']");
	public WebElement GSTIN() {
		return driver.findElement(gstinno);
	}
	//Page object for Place Of Supply
	By placeOfSupply=By.xpath("//input[@formcontrolname='placeOfSupply']");
	public WebElement PlaceofSupply() {
		return driver.findElement(placeOfSupply);
	}
	//Page object for Residential Service Society Name
	By resSocietyName=By.xpath("//input[@formcontrolname='resSocietyName']");
	public WebElement ResSocietyName() {
		return driver.findElement(resSocietyName);
	}
	//Page object for Residential Registration No
	By resRegisterNo=By.xpath("//input[@formcontrolname='resRegisterNo']");
	public WebElement ResRegisterNo() {
		return driver.findElement(resRegisterNo);
	}
	//Page object for Residential Registration Date
	public WebElement getResRegisterdate() {
		WebElement nextExpectedUpElement = driver.findElement(By.xpath("//input[@formcontrolname='resRegisterDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextExpectedUpElement.sendKeys(formattedDate);
		return nextExpectedUpElement;
	}	
	//Page object for Commercial Service Society Name
	By comSocietyName=By.xpath("//input[@formcontrolname='comSocietyName']");
	public WebElement getComSocietyName() {
		return driver.findElement(comSocietyName);
	}
	//Page object for Commercial Registration No
	By comRegistrationNo=By.xpath("//input[@formcontrolname='comRegistrationNo']");
	public WebElement getComRegistrationNo() {
		return driver.findElement(comRegistrationNo);
	}
	//Page object for Commercial Registration Date
	public WebElement getcomRegistrationDT() {
		WebElement nextExpectedUpElement = driver.findElement(By.xpath("//input[@formcontrolname='comRegistrationDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(yesterday);
		nextExpectedUpElement.sendKeys(formattedDate);
		return nextExpectedUpElement;
	}
	//Page object for Recepit Address
	By recAppearAddress=By.xpath("//textarea[@formcontrolname='recAppearAddress']");
	public WebElement getRecAddress() {
		return driver.findElement(recAppearAddress);
	}
	//Page object for Pin Code
	By pincode=By.xpath("//input[@formcontrolname='pincode']");
	public WebElement getPincode() {
		return driver.findElement(pincode);
	}

	//Page object for Project Logo File 
	By projectLogoFile = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div/div[12]/mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement uploadProjectLogoFile() {	
		return driver.findElement(projectLogoFile);
	}
	//Page object for Receipt Seal
	By receiptseal=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div"
			+ "/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div/div[13]/mat-form-field/div[1]/div[2]/div[2]/button");
	public WebElement uploadReceiptSeal() {
		return driver.findElement(receiptseal);
	}
	
	//Page object for Receipt Prefix
	By recPrefix=By.xpath("//input[@formcontrolname='recPrefix']");
	public WebElement getRecPrefix() {
		return driver.findElement(recPrefix);
	}
	
	//Page object for Receipt Postfix
	By recpostfix=By.xpath("//mat-select[@formcontrolname='recPostfix']");
	public void getRecPostfix(String recPostfix) {
		WebElement dropdown = driver.findElement(recpostfix);
		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + recPostfix + "')]";  
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Next Button
	By nextbtn2=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "app-project-save/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextbtn2() {
		return driver.findElement(nextbtn2);
	}
	//SAC Configurations
	//Page object for Property Type
	By propertyType=By.xpath("//mat-select[@formcontrolname='propertyType']");
	public void getPropertyType(String Propertytype) {
		WebElement dropdown = driver.findElement(propertyType);
		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + Propertytype + "')]";  
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	//Page object for SAC Code
	By sacCode=By.xpath("//mat-select[@formcontrolname='sacCode']");
	public void getSACcode(String Saccode) {
		WebElement dropdown = driver.findElement(sacCode);
		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + Saccode + "')]";  
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for action button
	By actionbtn=By.xpath("//button[@mattooltip='Add']");
	public WebElement getActionbtn() {
		return driver.findElement(actionbtn);
	}
	//Page object for Next Button
	By nextbtn3=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextbtn3() {
		return driver.findElement(nextbtn3);
	}

	//Terms & Conditions
	//Page object for Terms & Conditions
	By termstext=By.xpath("//input[@formcontrolname='termsText']");
	public WebElement getTermstext() {
		return driver.findElement(termstext);
	}

	//Page object for Plus Btn
	By plusbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-project-save/div/div[2]/div/"
			+ "mat-vertical-stepper/div[5]/div/div/div/div[1]/form/div[2]/div/div[2]/button");
	public WebElement getPlusbtn() {
		return driver.findElement(plusbtn);
	}
	//Page object for Save & Next
	By Savebtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[5]/div/div/div/div[2]/button[2]");
	public WebElement getSave() {
		return driver.findElement(Savebtn);
	}
	
    //Block configuration
	//Page object for Add Project Block
	By addprojectblock=By.xpath("//*[@id=\"cdk-step-content-0-5\"]/div/div[1]/vex-unit-block-list/div/button");	
	public WebElement getAddProjectBlock() {
		return driver.findElement(addprojectblock);
	}
	//Page object for Block Name
	By unitblock=By.xpath("//input[@formcontrolname='unitBlockName']");	
	public WebElement getUnitBlock() {
		return driver.findElement(unitblock);
	}
		
	//Page object for Number of Floors
	By numberOfFloors=By.xpath("//input[@formcontrolname='numberOfFloors']");	
	public WebElement getNumberOfFloors() {
		return driver.findElement(numberOfFloors);
	}
	//Page object for Basements
	By basements=By.xpath("//input[@formcontrolname='basements']");	
	public WebElement getBasements() {
		return driver.findElement(basements);
	}
	//Page object for Create
	By create=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-configure-unit-block/div/mat-dialog-actions/button[1]");	
	public WebElement getCreate() {
		return driver.findElement(create);
	}
	
	//Page object for Toster Message
	//This project name is already in use. Please choose a different name.
	By toaster=By.xpath("");	
	public WebElement getToaster() {
		return driver.findElement(toaster);
	}
	
	//Page object for Edit Button
	public WebElement getEdit() {
		WebElement Edit = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
				+ "mat-sidenav-container/mat-sidenav-content/main/"
				+ "app-projects/div/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[2]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Edit);
		js.executeScript("arguments[0].click();", Edit);
		return Edit;
	}	
	//Page object for Delete Project
	By DeleteProject=By.xpath("//button[@mattooltip='Delete Project']");	
	public WebElement getDeleteproject() {
		return driver.findElement(DeleteProject);
	}
	//Page object for click Yes
	By ClickYes = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getClickYes() {
		return driver.findElement(ClickYes);
	}
	//Page object for Active/Deactive Project
	By ActiveProject=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-projects/div/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[1]");
	public WebElement getActiveproject() {
		return driver.findElement(ActiveProject);
	}
	//Page object for Search Project
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		return driver.findElement(Search);
	}
	//Page object for Export to Excel Project
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/app-projects/div/div[1]/div[2]/div[2]/button");
	public WebElement getExporttoExcel() {
		return driver.findElement(ExporttoExcel);
	}
	
	//On edit Next Butoon Xpath object
	By editnext = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button");
	public WebElement getEditNext() {
		return driver.findElement(editnext);
	}
	
}