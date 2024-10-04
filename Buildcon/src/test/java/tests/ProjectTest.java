package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProjectPage;
import resources.base;

public class ProjectTest extends base {
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver=initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));  
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));  
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Project
	@Test(dataProvider="getAddData")
	public void Add_Project(String projectname,String projecttype,String Projectstatus,
			String Expectedstartdate,String ExpectedEnddate,String ActualStartdate,String ActualEnddate,
			String totalSaleableArea,String city,String State,String Spno,String SalesExectuive,
			String Description,String Address,String East,String west,String South,String north,String Plotno,
			String Schemeno,String Rera,String totalLandArea,String MaintenanceCharge,String MaintenanceDeposit,
			String companyname,String gstin,String plcofsupplu,String RecAddress,String pincode,String projectlogo,String receiptlogo,String RecPrefix,String FinancialYear,
			String Propertytype,String Saccode,String termstext,String Unit,String Floors,String Basements) throws InterruptedException {
		
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();
		
		project.getProjectName().sendKeys(projectname);
		project.getProjecttype(projecttype);
		project.getProjectstatus(Projectstatus);
		project.getExstartdate().sendKeys(Expectedstartdate);
		project.getExEnddate().sendKeys(ExpectedEnddate);
		project.getActualstartdate().sendKeys(ActualStartdate);
		project.getActualenddate().sendKeys(ActualEnddate);
		project.getTotalsaleableArea().sendKeys(totalSaleableArea);
		project.getcity().sendKeys(city);
		project.getstate(State);
		project.getspNo().sendKeys(Spno);
		project.getSalesExectuive(SalesExectuive);
		project.getdescription().sendKeys(Description);
		project.getAddress().sendKeys(Address);

		Thread.sleep(2000);
		project.getNextbtn().click();
		project.getEast().sendKeys(East);
		project.getWest().sendKeys(west);
		project.getSouth().sendKeys(South);
		project.getNorth().sendKeys(north);
		project.getPlotNo().sendKeys(Plotno);
		project.getschemeNo().sendKeys(Schemeno);
		project.getRera().sendKeys(Rera);
		project.gettotalLandArea().sendKeys(totalLandArea);
		project.getMaintenanceCharge().sendKeys(MaintenanceCharge);
		project.getMaintenanceDeposit().sendKeys(MaintenanceDeposit);

		Thread.sleep(2000);
		project.getNextbtn1().click();
		project.getCompanyName().sendKeys(companyname);
		project.GSTIN().sendKeys(gstin);
		project.PlaceofSupply().sendKeys(plcofsupplu);
		project.getRecAddress().sendKeys(RecAddress);
		project.getPincode().sendKeys(pincode);
		project.uploadProjectLogoFile().sendKeys(projectlogo);
		project.uploadReceiptSeal().sendKeys(receiptlogo);
		project.getRecPrefix().sendKeys(RecPrefix);
		project.getFinancialYear(FinancialYear);

		Thread.sleep(2000);
		project.getNextbtn2().click();
		project.getPropertyType(Propertytype);
		project.getSACcode(Saccode);
		project.getActionbtn().click();
		project.getNextbtn3().click();
		project.getTermstext().sendKeys(termstext);
		project.getPlusbtn().click();

		Thread.sleep(2000);
		project.getSave().click();
		project.getAddProjectBlock().click();
		project.getUnitBlock().sendKeys(Unit);
		project.getNumberOfFloors().sendKeys(Floors);
		project.getBasements().sendKeys(Basements);

		Thread.sleep(2000);
		project.getCreate().click();
	}

	//Edit Existing Project
	@Test(dataProvider="getEditData")
	public void Edit_Project(String newtotalSaleableArea,String newtotalLandArea) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit();
		project.getTotalsaleableArea().clear();
		project.getTotalsaleableArea().sendKeys(newtotalSaleableArea);
		project.getNextbtn().click();
		project.gettotalLandArea().clear();
		project.gettotalLandArea().sendKeys(newtotalLandArea);
		project.getNextbtn1().click();
		project.getNextbtn2().click();
		project.getNextbtn3().click();
		
		Thread.sleep(2000);
		project.getSave().click();
	}

	//Delete Project
	@Test() 
	public void Delete_Project() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver); 
		project.getproject().click();
		project.getEdit(); 
		project.getDeleteproject().click(); 

		Thread.sleep(2000);
		project.getClickYes().click();
	}

	//Export to Excel 
	@Test()
	public void Export_to_Excel_Project() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getExporttoExcel().click();
	}

	//Search Project
	@Test(dataProvider="getSearchData")
	public void Search_Inquiry(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		
		Thread.sleep(2000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		
		WebElement searchResult = project.getSearch();  
		String resultText = searchResult.getText();
		Assert.assertFalse(resultText.contains(projectname));
	}

	//ActiveDeactive Project 
	@Test()
	public void Active_Deactive_Project() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		
		Thread.sleep(2000);
		project.getActiveproject().click();
	}

	//Close the Driver
	@AfterMethod() 
	public void teardown() {
		//driver.close(); 
	}

	//Add Project Data
	@DataProvider
	public Object[][] getAddData() {
		return new Object[][] {
			{"Automation Project1","Commercial","Planning","","","","","10000","Goa","Goa","215"," Abhimanyu Sigh ","Execute the building and infrastructure work","3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058",
				"30 MTRS. ROAD","Play Ground","F.P. NO. 954","Neighbourhood Auda Garden","964","210","Approved","65475","5600","254000","SHALIGRAM SPACE LLP","29GGGGG1314R9Z6","Ahmedabad","SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD","380058",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\125ktm.jpg","RecPrefix"," Financial Year "," FLAT "," 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ","A legal agreement between a service provider and its user that outline the rights and responsibilities of both parties",
				"B","15","Basement"}};
	}

	//Edit Project Data
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] {
			{"20000","1000"}};
	}

	//Search Data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"Taj Mahal"}};
	}
}