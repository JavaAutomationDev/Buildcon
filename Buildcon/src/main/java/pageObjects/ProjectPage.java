package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import resources.base;

public class ProjectPage {
	public WebDriver driver;
	public boolean flag;

	public ProjectPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for Project Module
	By Project = By.xpath("//vex-sidenav-item[4]//a[1]");

	public WebElement getproject() {
		base.failedElementName = "Project-ProjectMenu";
		return driver.findElement(Project);
	}

	// Page object for Add Project
	By AddProject = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-projects/div/div[1]/div[2]/button");

	public WebElement getaddproject() {
		base.failedElementName = "Project-AddProject";
		return driver.findElement(AddProject);
	}
	
	// Page object for Project Name
	By ProjectName = By.xpath("//input[@formcontrolname='projectName']");

	public WebElement getProjectName() {
		base.failedElementName = "Project-ProjectName";
		return driver.findElement(ProjectName);
	}

	// Page object for Project Type
	By Projecttype = By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Type\"]");

	public void getProjecttype(String projecttype) {
		try {
			WebElement dropdown = driver.findElement(Projecttype);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(projecttype)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + projecttype);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + projecttype);
			e.printStackTrace();
		}
	}

	// Page object for Project Status
	By Projectstatus = By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Status\"]");

	public void getProjectstatus(String projectstatus) {
		try {
			WebElement dropdown = driver.findElement(Projectstatus);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(projectstatus)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + projectstatus);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + projectstatus);
			e.printStackTrace();
		}
	}

	// Page object for Total Saleable Area
	By ExpectedStartDate = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[4]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");

	public WebElement getExpectedStartDate() {
		base.failedElementName = "Project-ExpectedStartDate";
		return driver.findElement(ExpectedStartDate);
	}

	// Page object for Expected Start Date
	public WebElement getExstartdate() {
		WebElement nextExpectedUpElement = driver.findElement(By.xpath("//input[@formcontrolname='expectedStartDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextExpectedUpElement.sendKeys(formattedDate);
		base.failedElementName = "Project-ExstartDate";
		return nextExpectedUpElement;
	}

	// Page object for Expected Start Date
	public WebElement getExEnddate() {
		WebElement nextExpectedUpElement = driver.findElement(By.xpath("//input[@formcontrolname='expectedEndDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 2);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextExpectedUpElement.sendKeys(formattedDate);
		base.failedElementName = "Project-ExpEndDate";
		return nextExpectedUpElement;
	}

	// Page object for Actual Start Date
	public WebElement getActualstartdate() {
		WebElement nextActualUpElement = driver.findElement(By.xpath("//input[@formcontrolname='actualStartDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 48);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextActualUpElement.sendKeys(formattedDate);
		base.failedElementName = "Project-ActStartDate";
		return nextActualUpElement;
	}

	// Page object for Actual End Date
	public WebElement getActualenddate() {
		WebElement nextActualUpElement = driver.findElement(By.xpath("//input[@formcontrolname='actualEndDate']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 570);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextActualUpElement.sendKeys(formattedDate);
		base.failedElementName = "Project-ActEndDate";
		return nextActualUpElement;
	}

	// Page object for Total Saleable Area
	By TotalsaleableArea = By.xpath("//input[@formcontrolname='totalSaleableArea']");

	public WebElement getTotalsaleableArea() {
		base.failedElementName = "Project-SalableArea";
		return driver.findElement(TotalsaleableArea);
	}

	// Page object for SPNO
	By spNo = By.xpath("//input[@formcontrolname='spNo']");

	public WebElement getspNo() {
		base.failedElementName = "Project-SPNo";
		return driver.findElement(spNo);
	}

	// Page object for City
	By City = By.xpath("//input[@formcontrolname='city']");

	public WebElement getcity() {
		base.failedElementName = "Project-City";
		return driver.findElement(City);
	}

	// Page object for State
	By State = By.xpath("//vex-searchable-dropdown[@placeholder=\"State\"]");

	public void getstate(String state) {
		try {
			WebElement dropdown = driver.findElement(State);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(state)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + state);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + state);
			e.printStackTrace();
		}
	}

	// Page object for Sales Exectuive
	By SalesExectuive = By.xpath("//vex-searchable-dropdown[@placeholder=\"Sales Executive\"]");

	public void getSalesExectuive(String salesExectuive) {
		try {
			WebElement dropdown = driver.findElement(SalesExectuive);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(salesExectuive)) {
					option.click();
					Thread.sleep(2000);
					WebElement body = driver.findElement(By.tagName("body"));
					body.click(); // Clicking on the body should close the dropdown
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + salesExectuive);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + salesExectuive);
			e.printStackTrace();
		}
	}

	// Page object for Sales Exectuive
	By SalesExectuive1 = By.xpath("//vex-searchable-dropdown[@placeholder=\"Sales Executive\"]");

	public WebElement getSalesExectuive1() {
		base.failedElementName = "Project-SalesExectuive1";
		return driver.findElement(SalesExectuive1);
	}

	// Page object for Description
	By Description = By.xpath("//textarea[@formcontrolname='description']");

	public WebElement getdescription() {
		base.failedElementName = "Project-Description";
		return driver.findElement(Description);
	}

	// Page object for Address
	By Address = By.xpath("//textarea[@formcontrolname='address']");

	public WebElement getAddress() {
		base.failedElementName = "Project-Address";
		return driver.findElement(Address);
	}

	// Page object for Next Button
	By Nextbtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextbtn() {
		base.failedElementName = "Project-Nextbtn";
		return driver.findElement(Nextbtn);
	}

	// Page object for East
	By East = By.xpath("//input[@formcontrolname='east']");

	public WebElement getEast() {
		base.failedElementName = "Project-East";
		return driver.findElement(East);
	}

	// Page object for West
	By west = By.xpath("//input[@formcontrolname='west']");

	public WebElement getWest() {
		base.failedElementName = "Project-West";
		return driver.findElement(west);
	}

	// Page object for South
	By south = By.xpath("//input[@formcontrolname='south']");

	public WebElement getSouth() {
		base.failedElementName = "Project-South";
		return driver.findElement(south);
	}

	// Page object for North
	By North = By.xpath("//input[@formcontrolname='north']");

	public WebElement getNorth() {
		base.failedElementName = "Project-North";
		return driver.findElement(North);
	}

	// Page object for Plot No
	By PlotNo = By.xpath("//input[@formcontrolname='plotNo']");

	public WebElement getPlotNo() {
		base.failedElementName = "Project-PlotNo";
		return driver.findElement(PlotNo);
	}

	// Page object for Scheme No
	By schemeNo = By.xpath("//input[@formcontrolname='schemeNo']");

	public WebElement getschemeNo() {
		base.failedElementName = "Project-SchemeNo";
		return driver.findElement(schemeNo);
	}

	// Page object for Rera
	By Rera = By.xpath("//input[@formcontrolname='rera']");

	public WebElement getRera() {
		base.failedElementName = "Project-Rera";
		return driver.findElement(Rera);
	}

	// Page object for Total Land Area
	By totalLandArea = By.xpath("//input[@formcontrolname='totalLandArea']");

	public WebElement gettotalLandArea() {
		base.failedElementName = "Project-TotalLandArea";
		return driver.findElement(totalLandArea);
	}

	// Page object for Maintenance Charge
	By MaintenanceCharge = By.xpath("//input[@formcontrolname='maintenanceCharge']");

	public WebElement getMaintenanceCharge() {
		base.failedElementName = "Project-MaintanceCharge";
		return driver.findElement(MaintenanceCharge);
	}

	// Page object for Maintenance Deposit
	By MaintenanceDeposit = By.xpath("//input[@formcontrolname='maintenanceDeposit']");

	public WebElement getMaintenanceDeposit() {
		base.failedElementName = "Project-MaintenanceDeposit";
		return driver.findElement(MaintenanceDeposit);
	}

	// Page object for NextBtn1
	By Nextbtn1 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextbtn1() {
		base.failedElementName = "Project-NextBtn1";
		return driver.findElement(Nextbtn1);
	}

	// Fields which will appear in Receipt
	// Page object for Company Name
	By companyname = By.xpath("//input[@formcontrolname='recAppearProjectName']");

	public WebElement getCompanyName() {
		base.failedElementName = "Project-CompanyName";
		return driver.findElement(companyname);
	}

	// Page object for GSTIN No
	By gstinno = By.xpath("//input[@formcontrolname='gstin']");

	public WebElement GSTIN() {
		base.failedElementName = "Project-GSTNo";
		return driver.findElement(gstinno);
	}

	// Page object for Place Of Supply
	By placeOfSupply = By.xpath("//input[@formcontrolname='placeOfSupply']");

	public WebElement PlaceofSupply() {
		base.failedElementName = "Project-PlaceofSupply";
		return driver.findElement(placeOfSupply);
	}

	// Page object for Residential Service Society Name
	By resSocietyName = By.xpath("//input[@formcontrolname='resSocietyName']");

	public WebElement ResSocietyName() {
		base.failedElementName = "Project-ResSocietyName";
		return driver.findElement(resSocietyName);
	}

	// Page object for Residential Registration No
	By resRegisterNo = By.xpath("//input[@formcontrolname='resRegisterNo']");

	public WebElement ResRegisterNo() {
		base.failedElementName = "Project-ResRegisterNo";
		return driver.findElement(resRegisterNo);
	}

	// Page object for Residential Registration Date
	public WebElement getResRegisterdate() {
		WebElement nextExpectedUpElement = driver.findElement(By.xpath("//input[@formcontrolname='resRegisterDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		nextExpectedUpElement.sendKeys(formattedDate);
		base.failedElementName = "Project-getRegisterDate";
		return nextExpectedUpElement;
	}

	// Page object for Commercial Service Society Name
	By comSocietyName = By.xpath("//input[@formcontrolname='comSocietyName']");

	public WebElement getComSocietyName() {
		base.failedElementName = "Project-ComSocietyName";
		return driver.findElement(comSocietyName);
	}

	// Page object for Commercial Registration No
	By comRegistrationNo = By.xpath("//input[@formcontrolname='comRegistrationNo']");

	public WebElement getComRegistrationNo() {
		base.failedElementName = "Project-ComRegistrationNo";
		return driver.findElement(comRegistrationNo);
	}

	// Page object for Commercial Registration Date
	public WebElement getcomRegistrationDT() {
		WebElement nextExpectedUpElement = driver
				.findElement(By.xpath("//input[@formcontrolname='comRegistrationDT']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(yesterday);
		nextExpectedUpElement.sendKeys(formattedDate);
		base.failedElementName = "Project-ComRegistrationDate";
		return nextExpectedUpElement;
	}

	// Page object for Recepit Address
	By recAppearAddress = By.xpath("//textarea[@formcontrolname='recAppearAddress']");

	public WebElement getRecAddress() {
		base.failedElementName = "Project-RecAppearAddress";
		return driver.findElement(recAppearAddress);
	}

	// Page object for Pin Code
	By pincode = By.xpath("//input[@formcontrolname='pincode']");

	public WebElement getPincode() {
		base.failedElementName = "Project-PinCode";
		return driver.findElement(pincode);
	}

	// Page object for Project Logo File
	By projectLogoFile = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div/div[12]"
					+ "/mat-form-field/div[1]/div[2]/div[2]/input[2]");

	public WebElement uploadProjectLogoFile() {
		base.failedElementName = "Project-ProjectLogofile";
		return driver.findElement(projectLogoFile);
	}

	// Page object for Receipt Seal
	By receiptseal = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "app-project-save/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div/div[13]"
					+ "/mat-form-field/div[1]/div[2]/div[2]/button");

	public WebElement uploadReceiptSeal() {
		base.failedElementName = "Project-ReceiptSeal";
		return driver.findElement(receiptseal);
	}

	// Page object for Receipt Prefix
	By recPrefix = By.xpath("//input[@formcontrolname='recPrefix']");

	public WebElement getRecPrefix() {
		base.failedElementName = "Project-RecPrefix";
		return driver.findElement(recPrefix);
	}

	// Page object for Receipt Postfix
	By recpostfix = By.xpath("//mat-select[@formcontrolname='recPostfix']");

	public void getRecPostfix(String recPostfix) {
		try {
			WebElement dropdown = driver.findElement(recpostfix);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(recPostfix)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + recPostfix);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + recPostfix);
			e.printStackTrace();
		}
	}

	// Page object for Next Button
	By nextbtn2 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "app-project-save/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextbtn2() {
		base.failedElementName = "Project-Nextbtn2";
		return driver.findElement(nextbtn2);
	}

	// SAC Configurations
	// Page object for Property Type
	By propertyType = By.xpath("//vex-searchable-dropdown[@placeholder=\"Property Type\"]");

	public void getPropertyType(String Propertytype) {
		try {
			WebElement dropdown = driver.findElement(propertyType);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Propertytype)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Propertytype);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Propertytype);
			e.printStackTrace();
		}
	}

	// Page object for SAC Code
	By sacCode = By.xpath("//vex-searchable-dropdown[@placeholder=\"SAC Code\"]");

	public void getSACcode(String Saccode) {
		try {
			WebElement dropdown = driver.findElement(sacCode);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Saccode)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Saccode);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Saccode);
			e.printStackTrace();
		}
	}

	// Page object for action button
	By actionbtn = By.xpath("//button[@mattooltip='Add']");

	public WebElement getActionbtn() {
		base.failedElementName = "Project-ActionBtn";
		return driver.findElement(actionbtn);
	}

	// Page object for Next Button
	By nextbtn3 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextbtn3() {
		base.failedElementName = "Project-NextBtn3";
		return driver.findElement(nextbtn3);
	}

	// Terms & Conditions
	// Page object for Terms & Conditions
	By termstext = By.xpath("//input[@formcontrolname='termsText']");

	public WebElement getTermstext() {
		base.failedElementName = "Project-RermText";
		return driver.findElement(termstext);
	}

	// Page object for Plus Btn
	By plusbtn = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-project-save/div/div[2]/div/"
			+ "mat-vertical-stepper/div[5]/div/div/div/div[1]/form/div[2]/div/div[2]/button");

	public WebElement getPlusbtn() {
		base.failedElementName = "Project-PlusBtn";
		return driver.findElement(plusbtn);
	}

	// Page object for Save & Next
	By Savebtn = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[5]/div/div/div/div[2]/button[2]");

	public WebElement getSave() {
		base.failedElementName = "Project-SaveBtn";
		return driver.findElement(Savebtn);
	}

	// Block Configuration
	// Page object for Add Project Block
	By addprojectblock = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[6]/div/div/div/div[1]/vex-unit-block-list/div/button");

	public WebElement getAddProjectBlock() {
		base.failedElementName = "Project-AddProjectBlock";
		return driver.findElement(addprojectblock);
	}

	// Page object for Block Name
	By unitblock = By.xpath("//input[@formcontrolname='unitBlockName']");

	public WebElement getUnitBlock() {
		base.failedElementName = "Project-UnitBlock";
		return driver.findElement(unitblock);
	}

	// Page object for Number of Floors
	By numberOfFloors = By.xpath("//input[@formcontrolname='numberOfFloors']");

	public WebElement getNumberOfFloors() {
		base.failedElementName = "Project-NoofFloors";
		return driver.findElement(numberOfFloors);
	}

	// Page object for Basements
	By basements = By.xpath("//input[@formcontrolname='basements']");

	public WebElement getBasements() {
		base.failedElementName = "Project-Basements";
		return driver.findElement(basements);
	}

	// Page object for Project Block Create btn
	By ProjectBlockCreatebtn = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-configure-unit-block/div/mat-dialog-actions/button[2]");

	public WebElement getProjectBlockCreatebtn() {
		base.failedElementName = "Project-ProjectBlockCreatebtn";
		return driver.findElement(ProjectBlockCreatebtn);
	}

	// Page object for Block configuration Next btn
	By BlockconfigurationNextbtn = By.xpath(
			" /html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[6]/div/div/div/div[2]/button[2]");

	public WebElement getBlockconfigurationNextbtn() {
		base.failedElementName = "Project-BlockconfigurationNextbtn";
		return driver.findElement(BlockconfigurationNextbtn);
	}

	// View Block Details
	// Page object for View Block Details
	By viewblock = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/"
					+ "div/div[2]/div/mat-vertical-stepper/div[6]/div/div/div/div[1]/vex-unit-block-list/mat-dialog-content/div/div/div[3]/button[1]");

	public WebElement getViewBlock() {
		return driver.findElement(viewblock);
	}

	// Page object for Add Unit
	By addunit = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-block-details-list/div/div[1]/div[2]/button[1]");

	public WebElement getAddUnit() {
		return driver.findElement(addunit);
	}

	// Page object for Unit Type
	By unittype = By.xpath("//input[@formcontrolname='unitType']");

	public WebElement getUnitType() {
		return driver.findElement(unittype);
	}

	// Page object for Saleable Area
	By saleablearea = By.xpath("//input[@formcontrolname='saleableArea']");

	public WebElement getSaleableArea() {
		return driver.findElement(saleablearea);
	}

	// Page object for Unit Saleable Area
	By unitTypeOfSaleableArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfSaleableArea']");

	public void getunitTypeOfSaleableArea(String UnitsaleableArea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfSaleableArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(UnitsaleableArea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + UnitsaleableArea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + UnitsaleableArea);
			e.printStackTrace();
		}
	}

	// Page object for Construction Built Up Area
	By builtuparea = By.xpath("//input[@formcontrolname='builtupArea']");

	public WebElement getBuiltUpArea() {
		return driver.findElement(builtuparea);
	}

	// Page object for Unit Construction Built Up Area
	By unitTypeOfBuildUpArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfBuildUpArea']");

	public void getunitTypeOfBuildUpArea(String UnitbuildArea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfBuildUpArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(UnitbuildArea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + UnitbuildArea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + UnitbuildArea);
			e.printStackTrace();
		}
	}

	// Page object for Inside Carpet Area
	By insidecarpetarea = By.xpath("//input[@formcontrolname='insiteCarpetArea']");

	public WebElement getInsideCarpetArea() {
		return driver.findElement(insidecarpetarea);
	}

	// Page object for Unit Inside Carpet Area
	By unitTypeOfInsiteCarpetArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfInsiteCarpetArea']");

	public void getunitTypeOfInsiteCarpetArea(String Unitcarpetarea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfInsiteCarpetArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitcarpetarea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitcarpetarea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitcarpetarea);
			e.printStackTrace();
		}
	}

	// Page object for Balcony Area
	By balconyarea = By.xpath("//input[@formcontrolname='balconyArea']");

	public WebElement getBalconyArea() {
		return driver.findElement(balconyarea);
	}

	// Page object for Unit Balcony Area
	By unitTypeOfBalconyArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfBalconyArea']");

	public void getunitTypeOfBalconyArea(String UnitbalconyArea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfBalconyArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(UnitbalconyArea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + UnitbalconyArea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + UnitbalconyArea);
			e.printStackTrace();
		}
	}

	// Page object for Wash Area
	By washarea = By.xpath("//input[@formcontrolname='balconyArea']");

	public WebElement getWashArea() {
		return driver.findElement(washarea);
	}

	// Page object for Unit Wash Area
	By unitTypeOfWashArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfWashArea']");

	public void getunitTypeOfWashArea(String UnitwashArea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfWashArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(UnitwashArea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + UnitwashArea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + UnitwashArea);
			e.printStackTrace();
		}
	}

	// Page object for Veranda Area
	By Verandaarea = By.xpath("//input[@formcontrolname='verandaArea']");

	public WebElement getVerandaarea() {
		return driver.findElement(Verandaarea);
	}

	// Page object for Unit Veranda Area
	By unitTypeOfVerandaArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfVerandaArea']");

	public void getVerandaarea(String Unitverandaarea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfVerandaArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitverandaarea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitverandaarea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitverandaarea);
			e.printStackTrace();
		}
	}

	// Page object for Total Carpet Area
	By totalCarpetArea = By.xpath("//input[@formcontrolname='totalCarpetArea']");

	public WebElement getTotalCarpetArea() {
		return driver.findElement(totalCarpetArea);
	}

	// Page object for Unit Total Carpet Area
	By unitTypeOfTotalCarpetArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfTotalCarpetArea']");

	public void getunitTypeOfTotalCarpetArea(String Unitcarpetarea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfTotalCarpetArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitcarpetarea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitcarpetarea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitcarpetarea);
			e.printStackTrace();
		}
	}

	// Page object for Plot Saleable Area
	By plotSaleableArea = By.xpath("//input[@formcontrolname='plotSaleableArea']");

	public WebElement getPlotSaleableArea() {
		return driver.findElement(plotSaleableArea);
	}

	// Page object for Unit Plot Saleable Area
	By unitTypeOfPlotSaleableArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfPlotSaleableArea']");

	public void getunitTypeOfPlotSaleableArea(String Unitplotarea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfPlotSaleableArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitplotarea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitplotarea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitplotarea);
			e.printStackTrace();
		}
	}

	// Page object for Open Terrace BuiltUp Area
	By openterracebuiltupArea = By.xpath("//input[@formcontrolname='openTerraceBuildupArea']");

	public WebElement getopenterracebuiltupArea() {
		return driver.findElement(openterracebuiltupArea);
	}

	// Page object for Unit Terrace BuildUp Area
	By unitTypeOfOpenTerraceBuildupArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfOpenTerraceBuildupArea']");

	public void getunitTypeOfOpenTerraceBuildupArea(String Unitterracearea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfOpenTerraceBuildupArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitterracearea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitterracearea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitterracearea);
			e.printStackTrace();
		}
	}

	// Page object for Construction Saleable Area
	By consaleableArea = By.xpath("//input[@formcontrolname='conSaleableArea']");

	public WebElement getConSaleableArea() {
		return driver.findElement(consaleableArea);
	}

	// Page object for Unit Construction Saleable Area
	By unittypeofconsaleableArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfConSaleableArea']");

	public void getunitTypeOfConSaleableArea(String Unitconstructionarea) {
		try {
			WebElement dropdown = driver.findElement(unittypeofconsaleableArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitconstructionarea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitconstructionarea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitconstructionarea);
			e.printStackTrace();
		}
	}

	// Page object for Plot Carpet Area
	By plotcarpetarea = By.xpath("//input[@formcontrolname='plotCarpetArea']");

	public WebElement getPlotCarpetArea() {
		return driver.findElement(plotcarpetarea);
	}

	// Page object for Unit Type Plot Carpet Area
	By unitTypeOfplotCarpetArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfplotCarpetArea']");

	public void getunitTypeOfplotCarpetArea(String Unitplotcarpetarea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfplotCarpetArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitplotcarpetarea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitplotcarpetarea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitplotcarpetarea);
			e.printStackTrace();
		}
	}

	// Page object for Extra Plot Carpet Area
	By extraPlotCarpetArea = By.xpath("//input[@formcontrolname='extraPlotCarpetArea']");

	public WebElement getextraPlotCarpetArea() {
		return driver.findElement(extraPlotCarpetArea);
	}

	// Page object for Unit Type Of Extra Plot Carpet Area
	By unitTypeOfExtraPlotCarpetArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfExtraPlotCarpetArea']");

	public void getunitTypeOfExtraPlotCarpetArea(String Unitextraplotcarpetarea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfExtraPlotCarpetArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitextraplotcarpetarea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitextraplotcarpetarea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitextraplotcarpetarea);
			e.printStackTrace();
		}
	}

	// Page object for Undevided Land Area
	By undevidedLandArea = By.xpath("//input[@formcontrolname='undevidedLandArea']");

	public WebElement getundevidedLandArea() {
		return driver.findElement(undevidedLandArea);
	}

	// Page object for Unit Type Of Extra Plot Carpet Area
	By unitTypeOfUndevidedLandArea = By.xpath("//mat-select[@formcontrolname='unitTypeOfUndevidedLandArea']");

	public void getunitTypeOfUndevidedLandArea(String unitUndevidedLandArea) {
		try {
			WebElement dropdown = driver.findElement(unitTypeOfUndevidedLandArea);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(unitUndevidedLandArea)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + unitUndevidedLandArea);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + unitUndevidedLandArea);
			e.printStackTrace();
		}
	}

	// Page object for Floor Number
	By floorNumber = By.xpath("//vex-searchable-dropdown[@placeholder=\"Floor No.\"]");

	public void getFloorNumber(String floorno) {
		try {
			WebElement dropdown = driver.findElement(floorNumber);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(floorno)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + floorno);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + floorno);
			e.printStackTrace();
		}
	}

	// Page object for Unit Block Number
	By unitBlockNumber = By.xpath("//input[@formcontrolname='unitBlockNumber']");

	public WebElement getunitBlockNumber() {
		return driver.findElement(unitBlockNumber);
	}

	// Page object for Unit Type Of Extra Plot Carpet Area
	By unitBlockType = By.xpath("//vex-searchable-dropdown[@placeholder=\"Unit Block Type\"]");

	public void getunitBlockType(String Unitblocktype) {
		try {
			WebElement dropdown = driver.findElement(unitBlockType);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(Unitblocktype)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + Unitblocktype);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + Unitblocktype);
			e.printStackTrace();
		}
	}

	// Page object for Unit Price As Per RERA
	By unitPriceAsRERA = By.xpath("//input[@formcontrolname='unitPriceAsRERA']");

	public WebElement getunitPriceAsRERA() {
		return driver.findElement(unitPriceAsRERA);
	}

	// Page object for East1
	By east1 = By.xpath(
			"/html[1]/body[1]/div[4]/div[4]/div[1]/mat-dialog-container[1]/div[1]/div[1]/vex-unit-block-details[1]/"
					+ "div[1]/mat-dialog-content[1]/form[1]/div[3]/div[1]/div[1]/div[5]/mat-form-field[1]/div[1]/div[2]/div[1]/input[1]");

	public WebElement getEast1() {
		return driver.findElement(east1);
	}

	// Page object for West1
	By west1 = By.xpath(
			"/html/body/div[4]/div[4]/div/mat-dialog-container/div/div/vex-unit-block-details/div/mat-dialog-content/form/div[3]/div/div/div[6]/mat-form-field/div[1]/div[2]/div/input");

	public WebElement getWest1() {
		return driver.findElement(west1);
	}

	// Page object for North1
	By north1 = By.xpath(
			"/html/body/div[4]/div[4]/div/mat-dialog-container/div/div/vex-unit-block-details/div/mat-dialog-content/form/div[3]/div/div/div[7]/mat-form-field/div[1]/div[2]/div/input");

	public WebElement getNorth1() {
		return driver.findElement(north1);
	}

	// Page object for South1
	By south1 = By.xpath(
			"/html/body/div[4]/div[4]/div/mat-dialog-container/div/div/vex-unit-block-details/div/mat-dialog-content/form/div[3]/div/div/div[8]/mat-form-field/div[1]/div[2]/div/input");

	public WebElement getSouth1() {
		return driver.findElement(south1);
	}

	// Page objet for Survey Number
	By surveyNumber = By.xpath("//input[@formcontrolname='surveyNumber1']");

	public WebElement getsurveyNumber() {
		return driver.findElement(surveyNumber);
	}

	// Page object for Undivided Land Area
	By surveyNumber2 = By.xpath("//input[@formcontrolname='surveyNumber2']");

	public WebElement getsurveyNumber2() {
		return driver.findElement(surveyNumber2);
	}

	// Page object for Unit
	By surveyNoUnitTypeID = By.xpath(
			"/html/body/div[4]/div[4]/div/mat-dialog-container/div/div/vex-unit-block-details/div/mat-dialog-content/form/div[3]/div/div/div[11]");

	public void getsurveyNoUnitTypeID(String SurveyNoUnitTypeID) {
		try {
			WebElement dropdown = driver.findElement(surveyNoUnitTypeID);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(SurveyNoUnitTypeID)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + SurveyNoUnitTypeID);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + SurveyNoUnitTypeID);
			e.printStackTrace();
		}
	}

	// Page objcet for Unit Create Button
	By createbtn = By.xpath(
			"/html/body/div[4]/div[4]/div/mat-dialog-container/div/div/vex-unit-block-details/div/mat-dialog-actions/button[2]");

	public WebElement getunitCreateBtn() {
		return driver.findElement(createbtn);
	}

	// Page object for Cross Button for unit Blocks close
	By crossbtn = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-block-details-list/div/div[1]/div[2]/a");

	public WebElement getUnitCrossBtn() {
		return driver.findElement(crossbtn);
	}

	// Page object for Upload From Excel
	By uploadfromexcel = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-block-details-list/div/div[1]/div[2]/button[2]");

	public WebElement getUploadFromExcel() {
		return driver.findElement(uploadfromexcel);
	}

	// Page object for Search Unit
	By searchunit = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-block-details-list/div/div[2]/div");

	public WebElement getSearchUnit() {
		return driver.findElement(searchunit);
	}

	// Page object for Export To Excel
	By excelexport = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-block-details-list/div/div[1]/div[2]/div/button");

	public WebElement getExcelExport() {
		return driver.findElement(excelexport);
	}

	// Page object for Edit Unit
	By editunit = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-block-details-list/div/div[2]/mat-dialog-content/div/div/div/table/tbody/tr/td[35]/div/a[1]");

	public WebElement getEditUnit() {
		return driver.findElement(editunit);
	}

	// Page object for Delete Unit
	By deleteunit = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-unit-block-details-list/div/div[2]/mat-dialog-content/div/div/div/table/tbody/tr/td[35]/div/a[2]");

	public WebElement getDeleteUnit() {
		return driver.findElement(deleteunit);
	}

	// Export To Excel
	// Page object for Export To Excel
	By exporttoexcel = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[6]/div/div/div/div[1]/vex-unit-block-list/div/div/button");

	public WebElement getExportToExcel() {
		return driver.findElement(exporttoexcel);
	}

	// Payment Plan
	// Page object for Add Payment Plan
	By addpaymentplan = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[7]/div/div/div/div[1]/vex-paymet-plan-list/div/button");

	public WebElement getAddPaymentPlan() {
		return driver.findElement(addpaymentplan);
	}

	// Page object for Payment Plan
	By paymentpaln = By.xpath("//vex-searchable-dropdown[@placeholder=\"Payment Plan\"]");

	public void getPaymentPaln(String paymentPlan) {
		try {
			WebElement dropdown = driver.findElement(paymentpaln);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(paymentPlan)) {
					option.click();
					Thread.sleep(2000);
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + paymentPlan);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + paymentPlan);
			e.printStackTrace();
		}
	}

	// Page object for Phase Name
	By phasename = By.xpath("//input[@formcontrolname='phase']");

	public WebElement getphasename() {
		return driver.findElement(phasename);
	}

	// Page object for Completion Percentage
	By completionpercentage = By.xpath("//input[@formcontrolname='completionPercentage']");

	public WebElement getCompletionPercentage() {
		return driver.findElement(completionpercentage);
	}

	// Page object for Payment Percentage
	By paymentpercentage = By.xpath("//input[@formcontrolname='paymentPercentage']");

	public WebElement getPaymentPercentage() {
		return driver.findElement(paymentpercentage);
	}

	// Page object for Payment Plan Create Btn
	By PaymentPlanCreateBtn = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-payment-plan/div/mat-dialog-actions/button[2]");

	public WebElement getPaymentPlanCreateBtn() {
		base.failedElementName = "Project-PaymentPlanCreateBtn";
		return driver.findElement(PaymentPlanCreateBtn);
	}

	// Page object for Edit Button
	public WebElement getEdit() {
		
		WebElement Edit = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-projects/div/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[2]"));
		base.failedElementName = "Project-Edit";

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", Edit);
//		js.executeScript("arguments[0].click();", Edit);
		return Edit;
	}
	
	// Page object for Edit Button
	public WebElement getEdit1() {

		WebElement Edit = driver.findElement(By.xpath("//a[@mattooltip=\"Edit Project\"]"));
		base.failedElementName = "Project-Edit1";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Edit);
		js.executeScript("arguments[0].click();", Edit);
		return Edit;
	}
	
	// Page object for Update Next button
	By UpdateNextbutton = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[6]/div/div/div/div[2]/button[2]");

	public WebElement getUpdateNextbutton() {
		base.failedElementName = "Project-UpdateNextbutton";
		return driver.findElement(UpdateNextbutton);
	}

	// Page object for Update submit  button
	By UpdateSubmitbutton = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[7]/div/div/div/div[2]/button[2]");

	public WebElement getUpdateSubmitbutton() {
		base.failedElementName = "Project-UpdateSubmitbutton";
		return driver.findElement(UpdateSubmitbutton);
	}
	
	// Page object for Update Edit Button
	By UpdateEditButton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button");

	public WebElement getUpdateEditButton() {
		base.failedElementName = "Project-Edite";
		return driver.findElement(UpdateEditButton);
	}

	// Page object for Delete Project
	By DeleteProject = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[1]/div[2]/div[1]/button/span[3]");
	
	public WebElement getDeleteproject() {
		base.failedElementName = "Project-Delete";
		return driver.findElement(DeleteProject);
	}

	// Page object for click Yes
	By ClickYes = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getClickYes() {
		base.failedElementName = "Project-DeleteYes";
		return driver.findElement(ClickYes);
	}

	// Page object for Active/Deactive Project
	By ActiveProject = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/app-projects/div/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[1]");

	public WebElement getActiveproject() {
		base.failedElementName = "Project-ActiveProject";
		return driver.findElement(ActiveProject);
	}

	// Page object for Search Project
	By Search = By.xpath("//input[@type='search']");

	public WebElement getSearch() {
		base.failedElementName = "Project-Search";
		return driver.findElement(Search);
	}

	// Page object for Export to Excel Project
	By ExporttoExcel = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
			+ "mat-sidenav-container/mat-sidenav-content/main/app-projects/div/div[1]/div[2]/div[2]/button");

	public WebElement getExporttoExcel() {
		base.failedElementName = "Project-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}

	// On edit Next Butoon Xpath object
	By editnext = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button");

	public WebElement getEditNext() {
		base.failedElementName = "Project-EditNext";
		return driver.findElement(editnext);
	}

	// Page object for Get Edit Next
	public void GetEditNext() {
		driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-projects/div/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[2]/span[4]"))
				.click();
		WebElement a = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button"));
		a.click();
	}

	// Page object for Add new Project click for assert
	By projectclick = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/mat-step-header");

	public WebElement getProjectClick() {
		return driver.findElement(projectclick);
	}

	// Page object for Project name for assert
	By projectnameassert = By.xpath("//input[@formcontrolname='projectName']");

	public WebElement getProjectNameAssert() {
		return driver.findElement(projectnameassert);
	}

	// Page object for Edit Button
	By Editbtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-projects/div/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[2]");

	public WebElement getEditbtn() {
		return driver.findElement(Editbtn);
	}

	// Page object for Submit Button
	By Submitbtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[7]/div/div/div/div[2]/button[2]");

	public WebElement getSubmitBtn() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", Submitbtn);
		return driver.findElement(Submitbtn);
	}

	// Page object for Edit Expeceted Start Date
	By editexpecetedstartdate = By.xpath("//input[@formcontrolname='expectedStartDT']");

	public WebElement getEditExpecetedStartDate() {
		return driver.findElement(editexpecetedstartdate);
	}

	// Page object for Edit Expeceted End Date
	By editexpecetedenddate = By.xpath("//input[@formcontrolname='expectedEndDT']");

	public WebElement getEditExpecetedEndDate() {
		return driver.findElement(editexpecetedenddate);
	}

	// Page object for Edit Actual Start Date
	By editactualstartdate = By.xpath("//input[@formcontrolname='actualStartDT']");

	public WebElement getEditActualStartDate() {
		return driver.findElement(editactualstartdate);
	}

	// Verify Add Inactive Project status in Project
	// Page object for Verify Add Inactive Project status in Project
	public void AddInactiveProjectStatusProject(String statusname) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Status\"]")).click();
		
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(statusname)) {
				Assert.assertFalse(false, "Project status is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Add Active Project Status in Project
	// Verify Add Active Project Status in Project
	// Page object for Verify Add Active Project Status in Project
	public void AddActiveProjectStatusProject(String statusname) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Status\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(statusname)) {
				Assert.assertFalse(false, "Project status is Active.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Edit InActive Project Status in Project
	// Verify Edit InActive Project Status in Project
	// Page object for Verify Edit InActive Project Status in Project
	public void EditInactiveProjectStatusProject(String statusname) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Status\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(statusname)) {
				Assert.assertFalse(false, "Project status is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active Project Status in Project
	// Page object for Verify Edit Active Project Status in Project
	public void EditActiveProjectStatusProject(String statusname) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Status\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(statusname)) {
				Assert.assertFalse(false, "Project status is Active.");
				System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Add Inactive Project Type in Project
	// Page object for Verify Add Inactive Project Type in Project
	public void AddInactiveProjectTypeData(String typename) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(typename)) {
				Assert.assertFalse(false, "Project Type is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Add Active Project Type in Project
	// Page object for Verify Add Active Project Type in Project
	public void AddActiveProjectTypeData(String typename) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(typename)) {
				Assert.assertFalse(false, "Project Type is active.");
				System.out.println("Test  failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Inactive Project Type in Project
	// Page object for Verify Edit Inactive Project Type in Project
	public void EditInActiveProjectTypeData(String typename) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(typename)) {
				Assert.assertFalse(false, "Edit Project Type is Inactive.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active Project Type in Project
	// Page object for Verify Edit Active Project Type in Project
	public void EditActiveProjectType(String typename) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Project Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(typename)) {
				Assert.assertFalse(false, "Project Type is active.");
				// System.out.println("Test failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// State With Project Relation
	// Verify Add Inactive State in Project
	// Page object for Verify Add Inactive State in Project
	public void AddInactiveStateData(String name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"State\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(name)) {
				Assert.assertFalse(false, "State is inactive.");
				System.out.println("Test  failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Add Active State in Project
	// Page object for Verify Add Active State in Project
	public void AddActiveStateData(String name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"State\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (b.equalsIgnoreCase(name)) {
				Assert.assertFalse(false, "State is Active.");
				// System.out.println("Test Pass State is Active ");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Inactive State in Project
	// Page object for Verify Edit Inactive State in Project
	public void EditInActiveStateData(String name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"State\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(name)) {
				Assert.assertFalse(false, "State is inactive.");
				System.out.println("Test  failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active State in Project
	// Page object for Verify Edit Active State in Project
	public void EditActiveStateData(String name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"State\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (b.equalsIgnoreCase(name)) {
				Assert.assertFalse(false, "State is Active.");
				System.out.println("Test  failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Property Type
	// Verify Edit Inactive Property Type in Project
	// Page obejct for Verify Edit Inactive Property Type in Project
	public void EditInactivePropertyTypeData(String name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Property Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(name)) {
				Assert.assertFalse(false, "Property Type is Inactive.");
				System.out.println("Test  failed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active Property Type in Project
	// Page object for Verify Edit Active Property Type in Project
	public void EditActivePropertyTypeData(String name) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"Property Type\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(name)) {
				Assert.assertFalse(false, "Property Type is Active.");
				System.out.println("Test Pass");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// SAC Code
	// Verify Edit Inactive SAC Code in Project
	// Page object for Verify Edit Inactive SAC Code in Project
	public void EditInactiveSACCodeData(String sacname) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"SAC Code\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(sacname)) {
				Assert.assertFalse(false, "Property Type is Inactive.");
				// System.out.println("Test Passed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Verify Edit Active SAC Code in Project
	// Page object for Verify Edit Active SAC Code in Project
	public void EditActiveSACCodeData(String sacname) {
		driver.findElement(By.xpath("//vex-searchable-dropdown[@placeholder=\"SAC Code\"]")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText().trim();
			if (!b.equalsIgnoreCase(sacname)) {
				Assert.assertFalse(false, "Property Type is Active.");
				// System.out.println("Test Passed");
				break;
			} else {
				Counter = Counter + 1;
				if (Counter > a.size()) {
					System.out.println("Test");
					break;
				}
			}
		}
	}

	// Page object for select Start Date and End Date ***
	public WebElement getSelectSingleDate(String startdate) throws InterruptedException {
		String btn1 = "/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]";
		driver.findElement(By.xpath(btn1)).click();
		Thread.sleep(2000);

		// Start Year Select
		String[] YearParts = startdate.split("/");
		String Year = YearParts[2];
		String Yearxpath = "//span[normalize-space()='" + Year + "']";
		WebElement YearField = driver.findElement(By.xpath(Yearxpath));
		YearField.click();
		Thread.sleep(2000);

		// Start Date
		String[] MonthParts = startdate.split("/");
		String Month = MonthParts[1];
		String Monthxpath = "//span[normalize-space()='" + Month + "']";
		driver.findElement(By.xpath(Monthxpath)).click();
		Thread.sleep(2000);

		// Open Start Date Picker
		String[] DayParts = startdate.trim().split("/");
		String Day = DayParts[0];
		Thread.sleep(2000);
		String Dayxpath = "//span[normalize-space()='" + Day + "']";
		Thread.sleep(2000);
		WebElement startDateField = driver.findElement(By.xpath(Dayxpath));
		Thread.sleep(2000);
		startDateField.click();
		Thread.sleep(2000);
		return startDateField;

	}
	// Page object for Page not found
		public boolean NoPageFound() {
			try {
				int t = driver.findElements(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']")).size();

				if (t == 0) {
					flag = false;
				} else {
					flag = true;
				}
			} catch (NoSuchElementException e) {
			}
			return flag;
		}
}