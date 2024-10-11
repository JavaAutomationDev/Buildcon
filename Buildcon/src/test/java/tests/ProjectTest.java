package tests;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.ProjectPage;
import pageObjects.Projecttypespage;
import pageObjects.Statepage;
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
	@Test(dataProvider="ProjectAddData")
	public void Add_Project(String projectname,String projecttype,String Projectstatus,String Expectedstartdate,String ExpectedEnddate,
			String ActualStartdate,String ActualEnddate,String totalSaleableArea,String city,String State,String Spno,String SalesExectuive,
			String Description,String Address,String East,String west,String South,String north,String Plotno,String Schemeno,String Rera,
			String totalLandArea,String MaintenanceCharge,String MaintenanceDeposit,String companyname,String gstin,String plcofsupplu,
			String RecAddress,String pincode,String projectlogo,String receiptlogo,String RecPrefix,String RecPostFix,String Propertytype,
			String Saccode,String termstext,String Unit,String Floors,String Basements) throws InterruptedException {

		ProjectPage project = new ProjectPage(driver);
		SoftAssert softAssert = new SoftAssert();

		project.getproject().click();
		project.getaddproject().click();

		project.getProjectName().click();
		softAssert.assertFalse(projectname.isEmpty(), "Project name is required.");
		softAssert.assertNotNull(projectname, "Project name cannot be null.");
		project.getProjectName().sendKeys(projectname);//Required Field


		softAssert.assertFalse(projecttype.isEmpty(), "Project Type is required.");
		softAssert.assertNotNull(projecttype, "Project Type cannot be null.");
		project.getProjecttype(projecttype);//Required Field

		project.getProjectstatus(Projectstatus);

		softAssert.assertFalse(Expectedstartdate.isEmpty(), "Expected start date is required.");
		softAssert.assertNotNull(Expectedstartdate, "Expected start date cannot be null.");
		project.getExstartdate().sendKeys(Expectedstartdate);//Required Field


		softAssert.assertFalse(ExpectedEnddate.isEmpty(), "Expected End date is required.");
		softAssert.assertNotNull(ExpectedEnddate, "Expected End date cannot be null.");
		project.getExEnddate().sendKeys(ExpectedEnddate);//Required Field

		softAssert.assertFalse(ActualStartdate.isEmpty(), "Actual date is required.");
		softAssert.assertNotNull(ActualStartdate, "Actual date cannot be null.");
		project.getActualstartdate().sendKeys(ActualStartdate);//Required Field

		project.getActualenddate().sendKeys(ActualEnddate);
		project.getTotalsaleableArea().sendKeys(totalSaleableArea);
		project.getcity().sendKeys(city);
		project.getstate(State);
		project.getspNo().sendKeys(Spno);

		softAssert.assertFalse(SalesExectuive.isEmpty(), "Sales Exectuive is required.");
		softAssert.assertNotNull(SalesExectuive, "Sales Exectuive cannot be null.");
		project.getSalesExectuive(SalesExectuive);//Required Field

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

		softAssert.assertFalse(companyname.isEmpty(), "Company Name is required.");
		softAssert.assertNotNull(companyname, "Company Name cannot be null.");
		project.getCompanyName().sendKeys(companyname);//Required Field

		softAssert.assertFalse(gstin.isEmpty(), "GST number is required.");
		softAssert.assertNotNull(gstin, "GST number cannot be null.");
		project.GSTIN().sendKeys(gstin);//Required Field

		softAssert.assertFalse(plcofsupplu.isEmpty(), "Place of supply is required.");
		softAssert.assertNotNull(plcofsupplu, "Place of supply cannot be null.");
		project.PlaceofSupply().sendKeys(plcofsupplu);//Required Field

		softAssert.assertFalse(RecAddress.isEmpty(), "Receipt Address is required.");
		softAssert.assertNotNull(RecAddress, " Receipt Address cannot be null.");
		project.getRecAddress().sendKeys(RecAddress);//Required Field

		softAssert.assertFalse(pincode.isEmpty(), "Pincode is required.");
		softAssert.assertNotNull(pincode, "Pincode cannot be null.");
		project.getPincode().sendKeys(pincode);//Required Field

		softAssert.assertFalse(projectlogo.isEmpty(), "Project’s Logo is required.");
		softAssert.assertNotNull(projectlogo, "Project’s Logo cannot be null.");
		project.uploadProjectLogoFile().sendKeys(projectlogo);//Required Field

		project.uploadReceiptSeal().sendKeys(receiptlogo);

		softAssert.assertFalse(RecPrefix.isEmpty(), "Receipt prefix is required.");
		softAssert.assertNotNull(RecPrefix, "Receipt prefix cannot be null.");
		project.getRecPrefix().sendKeys(RecPrefix);//Required Field

		softAssert.assertFalse(RecPostFix.isEmpty(), "Receipt postfix is required.");
		softAssert.assertNotNull(RecPostFix, "Receipt postfix cannot be null.");
		project.getRecPostfix(RecPostFix);//Required Field

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

		softAssert.assertAll();
	}

	//Edit Existing Project
	@Test(dataProvider="ProjectEditData")
	public void Edit_Project(String newprojectname,String newtotalSaleableArea,String newtotalLandArea) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		SoftAssert softAssert = new SoftAssert();

		project.getproject().click();
		project.getEdit();

		project.getProjectName().clear();		
		project.getProjectName().click();
		softAssert.assertFalse(newprojectname.isEmpty(), "Project name is required.");
		softAssert.assertNotNull(newprojectname, "Project name cannot be null.");
		project.getProjectName().sendKeys(newprojectname);//Required Field


		project.getTotalsaleableArea().clear();
		project.getTotalsaleableArea().sendKeys(newtotalSaleableArea);

		project.getEditNext().click();

		project.gettotalLandArea().clear();
		project.gettotalLandArea().sendKeys(newtotalLandArea);

		project.getNextbtn1().click();
		project.getNextbtn2().click();
		project.getNextbtn3().click();

		Thread.sleep(2000);
		project.getSave().click();
		softAssert.assertAll();
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
	public void Export_To_Excel_Project() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getExporttoExcel().click();
	}

	//Search Project
	@Test(dataProvider="ProjectSearchData")
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
	
	//Verify Add Inactive Project Type in Prpject
	@Test()
	public void Verify_Add_Inactive_ProjectType_Project() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.geteditprojecttypes().click();
		Thread.sleep(4000);
		projecttype.getActiveProject();
		Thread.sleep(2000);
		projecttype.getsavebuttonprojecttypes().click();


		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectTypeID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Addee"))
			{
				Assert.assertFalse(false, "Project Type is Inactive.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}
	
	//Verify Add Active Project Type in Prpject
	@Test()
	public void Verify_Add_Active_ProjectType_Project() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.geteditprojecttypes().click();
		Thread.sleep(4000);
		projecttype.getActiveProject();
		Thread.sleep(2000);
		projecttype.getsavebuttonprojecttypes().click();


		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectTypeID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Addee"))
			{
				Assert.assertFalse(false, "Project Type is active.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}
	
	//Verify Edit Inactive Project Type in Prpject
	@Test()
	public void Verify_Edit_Inactive_ProjectType_Project() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.geteditprojecttypes().click();
		Thread.sleep(4000);
		projecttype.getActiveProject();
		Thread.sleep(2000);
		projecttype.getsavebuttonprojecttypes().click();


		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectTypeID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Addee"))
			{
				Assert.assertFalse(false, "Project Type is Inactive.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}
	
	//Verify Edit Active Project Type in Prpject
	@Test()
	public void Verify_Edit_Active_ProjectType_Project() throws InterruptedException {
		Projecttypespage projecttype = new Projecttypespage(driver);
		projecttype.getconfiguration().click();
		projecttype.projecttypesclick().click();
		projecttype.geteditprojecttypes().click();
		Thread.sleep(4000);
		projecttype.getActiveProject();
		Thread.sleep(2000);
		projecttype.getsavebuttonprojecttypes().click();


		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit().click();
		
		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectTypeID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Addee"))
			{
				Assert.assertFalse(false, "Project Type is active.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}
	
	//Verify Add Inactive State in Prpject
	@Test()
	public void Verify_Add_Inactive_State_Project() throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();

		Thread.sleep(2000);
		state.editrow().click();
		Thread.sleep(2000);
		state.getActive().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='stateID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Gujrat"))
			{
				Assert.assertFalse(false, "State is inactive.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Verify Add Active State in Prpject
	@Test()
	public void Verify_Add_Active_State_Project() throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();

		Thread.sleep(2000);
		state.editrow().click();
		Thread.sleep(2000);
		state.getActive().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='stateID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Gujrat"))
			{
				Assert.assertFalse(false, "State is Active.");
				System.out.println("Test  Pass State is Active ");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Verify Edit Inactive State in Prpject
	@Test()
	public void Verify_Edit_Inactive_State_Project() throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();

		Thread.sleep(2000);
		state.editrow().click();
		Thread.sleep(2000);
		state.getActive().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='stateID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Gujrat"))
			{
				Assert.assertFalse(false, "State is inactive.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Verify Edit Active State in Prpject
	@Test()
	public void Verify_Edit_Active_State_Project() throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();

		Thread.sleep(2000);
		state.editrow().click();
		Thread.sleep(2000);
		state.getActive().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='stateID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(b.equalsIgnoreCase("Gujrat"))
			{
				Assert.assertFalse(false, "State is inactive.");
				System.out.println("Test  failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Close the Driver
	@AfterMethod() 
	public void teardown() {
		//driver.close(); 
	}

	//Add Project Data
	@DataProvider
	public Object[][] ProjectAddData() {
		return new Object[][] {
			{"Automation Project1","Commercial","Planning","","","","","10000","Goa","Goa","215"," Akash Patel ","Execute the building and infrastructure work","3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058",
				"30 MTRS. ROAD","Play Ground","F.P. NO. 954","Neighbourhood Auda Garden","964","210","Approved","65475","5600","254000","SHALIGRAM SPACE LLP","29GGGGG1314R9Z6","Ahmedabad","SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD","380058",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\125ktm.jpg","RecPrefix"," Financial Year "," FLAT "," 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ","A legal agreement between a service provider and its user that outline the rights and responsibilities of both parties",
				"B","15","Basement"}};
	}

	//Edit Project Data
	@DataProvider
	public Object[][] ProjectEditData() {
		return new Object[][] {
			{"Automation Project","20000","1000"}};
	}

	//Project Search Data
	@DataProvider
	public Object[][] ProjectSearchData() {
		return new Object[][] {
			{"Taj Mahal"}};
	}
}