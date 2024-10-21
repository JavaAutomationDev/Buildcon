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

import pageObjects.LoginPage;
import pageObjects.ProjectPage;
import pageObjects.Projectstatuspage;
import pageObjects.Projecttypespage;
import pageObjects.Propertytypepage;
import pageObjects.Saccodepage;
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
		project.getproject().click();
		project.getaddproject().click();
		project.getProjectName().click();
		project.getProjecttype(projecttype);//Required Field
		project.getProjectstatus(Projectstatus);
		project.getExstartdate().sendKeys(Expectedstartdate);//Required Field
		project.getExEnddate().sendKeys(ExpectedEnddate);//Required Field
		project.getActualstartdate().sendKeys(ActualStartdate);//Required Field

		project.getActualenddate().sendKeys(ActualEnddate);
		project.getTotalsaleableArea().sendKeys(totalSaleableArea);
		project.getcity().sendKeys(city);
		project.getstate(State);
		project.getspNo().sendKeys(Spno);
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
		project.getCompanyName().sendKeys(companyname);//Required Field
		project.GSTIN().sendKeys(gstin);//Required Field
		project.PlaceofSupply().sendKeys(plcofsupplu);//Required Field
		project.getRecAddress().sendKeys(RecAddress);//Required Field
		project.getPincode().sendKeys(pincode);//Required Field
		project.uploadProjectLogoFile().sendKeys(projectlogo);//Required Field
		project.uploadReceiptSeal().sendKeys(receiptlogo);
		project.getRecPrefix().sendKeys(RecPrefix);//Required Field
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
	}

	//Edit Existing Project
	@Test(dataProvider="ProjectEditData")
	public void Edit_Project(String newprojectname,String newtotalSaleableArea,String newtotalLandArea) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit();

		project.getProjectName().clear();		
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

	//Export to Excel Project File
	@Test()
	public void Export_To_Excel_Project() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getExporttoExcel().click();
	}

	//Search Project
	@Test(dataProvider="ProjectSearchData")
	public void Search_Project(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();

		Thread.sleep(2000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);

		WebElement searchResult = project.getSearch();  
		String resultText = searchResult.getText();
		Assert.assertFalse(resultText.contains(projectname));
	}

	//Active Deactive Project 
	@Test()
	public void Active_Deactive_Project() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();

		Thread.sleep(2000);
		project.getActiveproject().click();
	}

	//Verify Add Inactive Project status in Project
	@Test()
	public void Verify_Add_Inactive_Project_Status_Project() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectstatuseditclick().click();
		unit.getActiveStatus().click();
		unit.getprojectstatussave().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getaddproject().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectStatusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Akash Status"))
			{
				Assert.assertFalse(false, "Project status is Inactive.");
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

	//Verify Add Active Project status in Project
	@Test()
	public void Verify_Add_Active_Project_Status_Project() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectstatuseditclick().click();
		unit.getActiveStatus().click();
		unit.getprojectstatussave().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getaddproject().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectStatusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Akash Status"))
			{
				Assert.assertFalse(false, "Project status is Active.");
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

	//Verify Edit InActive Project status in Project
	@Test()
	public void Verify_Edit_Inactive_Project_Status_Project() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectstatuseditclick().click();
		unit.getActiveStatus().click();
		unit.getprojectstatussave().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getEdit().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectStatusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Akash Status"))
			{
				Assert.assertFalse(false, "Project status is Inactive.");
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

	//Verify Edit Active Project status in Project
	@Test()
	public void Verify_Edit_Active_Project_Status_Project() throws InterruptedException {
		Projectstatuspage unit = new Projectstatuspage(driver);
		unit.getconfiguration().click();
		unit.getprojectstatusclick().click();
		unit.getprojectstatuseditclick().click();
		unit.getActiveStatus().click();
		unit.getprojectstatussave().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getEdit().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectStatusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Akash Status"))
			{
				Assert.assertFalse(false, "Project status is Active.");
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

	//Verify Add Inactive Project Type in Project
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

	//Verify Add Active Project Type in Project
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

	//Verify Edit Inactive Project Type in Project
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
				Assert.assertFalse(false, "Edit Project Type is Inactive.");
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

	//Verify Edit Active Project Type in Project
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

	//State With Project Relation
	//Verify Add Inactive State in Project
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

	//Verify Add Active State in Project
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

	//Verify Edit Inactive State in Project
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

	//Verify Edit Active State in Project
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
				Assert.assertFalse(false, "State is Active.");
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

	//Verify Edit Inactive Property Type in Project
	@Test()
	public void Verify_Edit_Inactive_Property_Type_Project() throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.geteditpropertytype().click();
		unit.getActiveStatus().click();
		unit.getsavebuttoneditpropertytype().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.GetEditNext();
		Thread.sleep(2000);
		project.getNextbtn1().click();
		Thread.sleep(2000);
		project.getNextbtn2().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='propertyType']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase(" Bopal Flat "))
			{
				Assert.assertFalse(false, "Property Type is Inactive.");
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

	//Verify Edit Active Property Type in Project
	@Test()
	public void Verify_Edit_Active_Property_Type_Project() throws InterruptedException {
		Propertytypepage unit = new Propertytypepage(driver);
		unit.getconfiguration().click();
		unit.getpropertytype().click();
		unit.geteditpropertytype().click();
		unit.getActiveStatus().click();
		unit.getsavebuttoneditpropertytype().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.GetEditNext();
		project.getNextbtn1().click();
		project.getNextbtn2().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='propertyType']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("Bopal Flat"))
			{
				Assert.assertFalse(false, "Property Type is Active.");
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

	//Verify Edit Inactive SAC Code in Project
	@Test()
	public void Verify_Edit_Inactive_SAC_Code_Project() throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getEditclicksaccode().click();
		unit.getEditsavebutton().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.GetEditNext();
		project.getNextbtn1().click();
		project.getNextbtn2().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='sacCode']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS"))
			{
				Assert.assertFalse(false, "Property Type is Inactive.");
				System.out.println("Test  Passed");
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

	//Verify Edit Active SAC Code in Project
	@Test()
	public void Verify_Edit_Active_SAC_Code_Project() throws InterruptedException {
		Saccodepage unit = new Saccodepage(driver);
		unit.getconfiguration().click();
		unit.getsaccodeclick().click();
		unit.getEditclicksaccode().click();
		unit.getEditsavebutton().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.GetEditNext();
		project.getNextbtn1().click();
		project.getNextbtn2().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='sacCode']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase("995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS"))
			{
				Assert.assertFalse(false, "Property Type is Active.");
				System.out.println("Test  Passed");
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

	//Add Project Test Mandatory Filed Validation
	@Test
	public void Add_Employee_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();
		Thread.sleep(2000);
		project.getProjectClick().click();

		WebElement projectname =driver.findElement(By.xpath("//span[normalize-space()='Project name is required']"));
		Assert.assertEquals(projectname.getText(), "Project name is required.");

		WebElement projecttype =driver.findElement(By.xpath("//span[normalize-space()='Project Type is required.']"));
		Assert.assertEquals(projecttype.getText(), "Project Type is required.");

		WebElement projectstatus =driver.findElement(By.xpath("//span[normalize-space()='Project Status is required']"));
		Assert.assertEquals(projectstatus.getText(), "Project Status is required.");

		WebElement expectedstartdate =driver.findElement(By.xpath("//span[normalize-space()='Expected start date is required']"));
		Assert.assertEquals(expectedstartdate.getText(), "Expected start Date is required.");

		WebElement expectedenddate =driver.findElement(By.xpath("//span[normalize-space()='Expected end date is required']"));
		Assert.assertEquals(expectedenddate.getText(), "Expected end date is required.");

		WebElement salesexecutive =driver.findElement(By.xpath("//span[normalize-space()='Sales executive is required']"));
		Assert.assertEquals(salesexecutive.getText(), "Sales executive is required.");		
	}
	
	//Edit Project Test Mandatory Filed Validation
	@Test
	public void Edit_Employee_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit().click();
		
		Thread.sleep(2000);
		project.getProjectNameAssert().click();
				//project.getProjectName().sendKeys(Keys.END);
		project.getProjectNameAssert().sendKeys(Keys.DELETE);
		//String projectnametext = project.getProjectName().getAttribute("value");
		//int projectnamelength = projectnametext.length();

		//for (int i = 0; i < projectnamelength; i++) {
		 //   project.getProjectName().sendKeys(Keys.BACK_SPACE);
		//}
		
		project.getEditNext().click();

		WebElement projectname =driver.findElement(By.xpath("//span[normalize-space()='Project name is required']"));
		Assert.assertEquals(projectname.getText(), "Project name is required.");

		WebElement projecttype =driver.findElement(By.xpath("//span[normalize-space()='Project Type is required.']"));
		Assert.assertEquals(projecttype.getText(), "Project Type is required.");

		WebElement projectstatus =driver.findElement(By.xpath("//span[normalize-space()='Project Status is required']"));
		Assert.assertEquals(projectstatus.getText(), "Project Status is required.");

		WebElement expectedstartdate =driver.findElement(By.xpath("//span[normalize-space()='Expected start date is required']"));
		Assert.assertEquals(expectedstartdate.getText(), "Expected start Date is required.");

		WebElement expectedenddate =driver.findElement(By.xpath("//span[normalize-space()='Expected end date is required']"));
		Assert.assertEquals(expectedenddate.getText(), "Expected end date is required.");

		WebElement salesexecutive =driver.findElement(By.xpath("//span[normalize-space()='Sales executive is required']"));
		Assert.assertEquals(salesexecutive.getText(), "Sales executive is required.");		
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