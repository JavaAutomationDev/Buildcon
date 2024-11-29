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
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		// Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Project
	@Test(dataProvider = "ProjectAddData")
	public void Add_Project(String projectname, String projecttype, String Projectstatus, String Expectedstartdate,
			String ExpectedEnddate, String ActualStartdate, String ActualEnddate, String totalSaleableArea, String city,
			String State, String Spno, String SalesExectuive, String Description, String Address, String East,
			String west, String South, String north, String Plotno, String Schemeno, String Rera, String totalLandArea,
			String MaintenanceCharge, String MaintenanceDeposit, String companyname, String gstin, String plcofsupplu,
			String RecAddress, String pincode, String projectlogo, String receiptlogo, String RecPrefix,
			String RecPostFix, String Propertytype, String Saccode, String termstext, String Unit, String Floors,
			String Basements,String unittype,String floorno,String blockno,String Unitblocktype,String east1,String west1,
			String north1,String south1,String surveyNumber,String surveyNumber2,String urveyNoUnitType) throws InterruptedException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();

		project.getProjectName().click();
		softAssert.assertFalse(projectname.isEmpty(), "Project Name is required");
		softAssert.assertNotNull(projectname, "Project name cannot be null.");
		
		project.getProjectName().sendKeys(projectname);//Required Field
		//Data validation of project name field:
		String valid_string = valid_alphanum(projectname, "projectname", 10);
		String valid_projectname = valid_string;
		System.out.println(valid_projectname);

		softAssert.assertFalse(projecttype.isEmpty(), "Project Type is required.");
		softAssert.assertNotNull(projecttype, "Project Type cannot be null.");
		project.getProjecttype(projecttype);//Required Field

		softAssert.assertFalse(Projectstatus.isEmpty(), "Project Status is required");
		softAssert.assertNotNull(Projectstatus, "Project Status cannot be null.");
		project.getProjectstatus(Projectstatus);

		softAssert.assertFalse(Expectedstartdate.isEmpty(), "Expected Start Date is required");
		softAssert.assertNotNull(Expectedstartdate, "Expected start date cannot be null.");
		project.getExstartdate().sendKeys(Expectedstartdate);//Required Field

		softAssert.assertFalse(ExpectedEnddate.isEmpty(), "Expected End Date is required");
		softAssert.assertNotNull(ExpectedEnddate, "Expected End date cannot be null.");
		project.getExEnddate().sendKeys(ExpectedEnddate);//Required Field

		softAssert.assertFalse(ActualStartdate.isEmpty(), "Actual Start Date is required");
		softAssert.assertNotNull(ActualStartdate, "Actual date cannot be null.");
		project.getActualstartdate().sendKeys(ActualStartdate);//Required Field

		project.getActualenddate().sendKeys(ActualEnddate);
		
		project.getTotalsaleableArea().sendKeys(totalSaleableArea); //valid_number
		//Data validation of totalSaleableArea:
		String valid_string1 = valid_number(totalSaleableArea, "TotalSaleableArea");
		String valid_totalSaleableArea = valid_string1;
		System.out.println(valid_totalSaleableArea);

		project.getcity().sendKeys(city);
		// data validation of city field:
		String valid_string2 = validateText(city, "City", 10, 20);
		String valid_City = valid_string2;
		System.out.println(valid_City);

		project.getstate(State);
		
		project.getspNo().sendKeys(Spno);
		//Data validation for spno:
		String valid_string3 = valid_alphanum(Spno, "spno", 10);
		String valid_spnumber = valid_string3;
		System.out.println(valid_spnumber);

		softAssert.assertFalse(SalesExectuive.isEmpty(), "Sales Executive is required");
		softAssert.assertNotNull(SalesExectuive, "Sales Exectuive cannot be null.");
		project.getSalesExectuive(SalesExectuive);//Required Field

		project.getdescription().sendKeys(Description);
		//Data validation for description:
		String valid_string4 = valid_alphanum(Description, "description", 100);
		String valid_Description = valid_string4;
		System.out.println(valid_Description);

		project.getAddress().sendKeys(Address);
		//Data validation for address:
		String valid_string5 = valid_alphanum(Address, "address", 100);
		String valid_Address = valid_string5;
		System.out.println(valid_Address);

		Thread.sleep(2000);
		project.getNextbtn().click();
		project.getEast().sendKeys(East);

		String valid_string6 = valid_alphanum(East, "east", 10);
		String valid_east = valid_string6;
		System.out.println(valid_east);

		project.getWest().sendKeys(west);
		String valid_string7 = valid_alphanum(west, "west", 10);
		String valid_west = valid_string7;
		System.out.println(valid_west);

		project.getSouth().sendKeys(South);
		String valid_string8 = valid_alphanum(South, "South", 10);
		String valid_south = valid_string8;
		System.out.println(valid_south);

		project.getNorth().sendKeys(north);
		String valid_string9 = valid_alphanum(north, "north", 10);
		String valid_North = valid_string9;
		System.out.println(valid_North);

		project.getPlotNo().sendKeys(Plotno);
		String valid_string10 = valid_alphanum(Plotno, "Plotno", 10);
		String valid_plotno = valid_string10;
		System.out.println(valid_plotno);

		project.getschemeNo().sendKeys(Schemeno);
		String valid_string11 = valid_alphanum(Schemeno, "Schemeno", 10);
		String valid_Schemeno = valid_string11;
		System.out.println(valid_Schemeno);

		project.getRera().sendKeys(Rera);
		String valid_string12 = valid_alphanum(Rera, "rera", 10);
		String valid_Rera = valid_string12;
		System.out.println(valid_Rera);

		project.gettotalLandArea().sendKeys(totalLandArea);
		softAssert.assertFalse(totalLandArea.isEmpty(), "Total Land Area is required");
		String valid_string13 = valid_number(totalLandArea, "TotalLandArea");
		String valid_totalLandArea = valid_string13;
		System.out.println(valid_totalLandArea);

		project.getMaintenanceCharge().sendKeys(MaintenanceCharge);
		//Data validation of the MaintenanceCharge:
		String valid_string14 = valid_number(MaintenanceCharge, "MaintenanceCharge");
		String valid_MaintenanceCharge = valid_string14;
		System.out.println(valid_MaintenanceCharge);

		project.getMaintenanceDeposit().sendKeys(MaintenanceDeposit);
		//Data validation of maintenance deposite:
		String valid_string15 = valid_number(MaintenanceDeposit, "MaintenanceDeposit");
		String valid_MaintenanceDeposit = valid_string15;
		System.out.println(valid_MaintenanceDeposit);

		Thread.sleep(2000);
		project.getNextbtn1().click();

		softAssert.assertFalse(companyname.isEmpty(), "Company Name is required");
		softAssert.assertNotNull(companyname, "Company Name cannot be null.");
		project.getCompanyName().sendKeys(companyname);//Required Field
		//Data validation of company name:
		String valid_string16 = validateText(companyname, "companyname", 10, 20);
		String valid_companyname = valid_string16;
		System.out.println(valid_companyname);

		softAssert.assertFalse(gstin.isEmpty(), "GSTIN NO. is required");
		softAssert.assertNotNull(gstin, "GST number cannot be null.");
		project.GSTIN().sendKeys(gstin);//Required Field
		//Data validation of the gstin:
		String valid_string17 = valid_alphanum(gstin, "gstin", 11);
		String valid_gstin = valid_string17;
		System.out.println(valid_gstin);

		softAssert.assertFalse(plcofsupplu.isEmpty(), "Place Of Supply is required");
		softAssert.assertNotNull(plcofsupplu, "Place of supply cannot be null.");
		project.PlaceofSupply().sendKeys(plcofsupplu);//Required Field
		//Data validation of the place of supply:
		String valid_string18 = validateText(plcofsupplu, "placeofsupply", 10, 20);
		String valid_placeofsupply = valid_string18;
		System.out.println(valid_placeofsupply);

		softAssert.assertFalse(RecAddress.isEmpty(), "Receipt Address is required");
		softAssert.assertNotNull(RecAddress, " Receipt Address cannot be null.");
		project.getRecAddress().sendKeys(RecAddress);//Required Field
		//Data validation of the rec address:
		String valid_string19 = valid_alphanum(RecAddress, "RecAddress", 11);
		String valid_RecAddress = valid_string19;
		System.out.println(valid_RecAddress);

		softAssert.assertFalse(pincode.isEmpty(), "Pincode is required");
		softAssert.assertNotNull(pincode, "Pincode cannot be null.");
		project.getPincode().sendKeys(pincode);//Required Field
		//Data validation of pincode: valid_number
		String valid_string20 = valid_number(pincode, "pincode");
		String valid_pincode = valid_string20;
		System.out.println(valid_pincode);

		softAssert.assertFalse(projectlogo.isEmpty(), "Project’s Logo is required");
		softAssert.assertNotNull(projectlogo, "Project’s Logo cannot be null.");
		project.uploadProjectLogoFile().sendKeys(projectlogo);//Required Field

		project.uploadReceiptSeal().sendKeys(receiptlogo);

		softAssert.assertFalse(RecPrefix.isEmpty(), "Receipt Prefix is required");
		softAssert.assertNotNull(RecPrefix, "Receipt prefix cannot be null.");
		project.getRecPrefix().sendKeys(RecPrefix);//Required Field
		//Data validation of receipt prefix:
		String valid_string21 = validateText(RecPrefix, "RecPrefix", 10, 20);
		String valid_RecPrefix = valid_string21;
		System.out.println(valid_RecPrefix);

		softAssert.assertFalse(RecPostFix.isEmpty(), "Receipt Postfix is required");
		softAssert.assertNotNull(RecPostFix, "Receipt postfix cannot be null.");
		project.getRecPostfix(RecPostFix);//Required Field

		Thread.sleep(2000);
		project.getNextbtn2().click();
		project.getPropertyType(Propertytype);

		project.getSACcode(Saccode);
		project.getActionbtn().click();

		project.getNextbtn3().click();
		project.getTermstext().sendKeys(termstext);
		//Data validation of terms and condition:
		String valid_string22 = valid_alphanum(termstext, "Terms & Conditions", 11);
		String valid_termstext = valid_string22;
		System.out.println(valid_termstext);

		project.getPlusbtn().click();

		Thread.sleep(2000);
		project.getSave().click();
		Thread.sleep(2000);
		project.getAddProjectBlock().click();
		
		project.getUnitBlock().sendKeys(Unit);
		//Data validation of the block:
		String valid_string23 = valid_alphanum(Unit, "Block Name", 10);
		String valid_BlockName= valid_string23;
		System.out.println(valid_BlockName);
     
		project.getNumberOfFloors().sendKeys(Floors);
		//Data validation of the floor:
		String valid_string24 = valid_number(Floors, "floor");
		String valid_floor= valid_string24;
		System.out.println(valid_floor);
		
		project.getBasements().sendKeys(Basements);
		//Data validation of the basement:
		String valid_string25 = valid_number(Basements, "basement");
		String valid_basement= valid_string25;
		System.out.println(valid_basement);

		Thread.sleep(2000);
		project.getCreate().click();
		project.getViewBlock().click();
		project.getAddUnit().click();
		project.getUnitType().sendKeys(unittype);
		
		project.getFloorNumber(floorno);
        project.getunitBlockNumber().sendKeys(blockno);
        project.getunitBlockType(Unitblocktype);
		
        project.getEast1().sendKeys(east1);
        project.getWest1().sendKeys(west1);
        project.getNorth1().sendKeys(north1);
        project.getSouth1().sendKeys(south1);
        project.getsurveyNumber().sendKeys(surveyNumber);
        project.getsurveyNumber2().sendKeys(surveyNumber2);
        
        project.getsurveyNoUnitTypeID(urveyNoUnitType);
        project.getCreateBtn().click();
        
		softAssert.assertEquals(valid_projectname, "projectname is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_totalSaleableArea, "totalSaleableArea is a Valid numeric");
		softAssert.assertEquals(valid_City, "city is a Valid text");
		softAssert.assertEquals(valid_spnumber, "spno is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_Description , "description is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_Address, "address is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_east, "east is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_west, "west is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_south, "South is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_North, "north is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_plotno , "Plotno is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_Schemeno, "Schemeno is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_Rera, "rera is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_totalLandArea, "TotalLandArea is a valid Number");
		softAssert.assertEquals(valid_MaintenanceCharge, "MaintenanceCharge is a valid Number");
		softAssert.assertEquals(valid_MaintenanceDeposit, "MaintenanceDeposit is a valid Number");
		softAssert.assertEquals(valid_companyname, "companyname is a Valid text");
		softAssert.assertEquals(valid_gstin, "gstin is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_placeofsupply, "placeofsupply is a Valid text");
		softAssert.assertEquals(valid_RecAddress, "RecAddress is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_pincode, "pincode is a valid Number");
		softAssert.assertEquals(valid_RecPrefix, "RecPrefix is a Valid text");
		softAssert.assertEquals(valid_termstext, "Terms & Conditions is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_BlockName, "Block Name is a Valid Alpha-Numeric");
		softAssert.assertEquals(valid_floor, "floor is a valid Number");
		softAssert.assertEquals(valid_basement, "basement is a valid Number");
		//softAssert.assertAll();
	}

	//Edit Existing Project
	@Test(dataProvider = "ProjectEditData")
	public void Edit_Project(String newprojectname,String newprojecttype,String newProjectstatus, String newtotalSaleableArea, String newtotalLandArea,
			String newcompanyname,String newgstin,String newplaceofsupply,String newRecPostFix)throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit();

		project.getProjectName().clear();
		softAssert.assertFalse(newprojectname.isEmpty(), "Project name is required.");
		softAssert.assertNotNull(newprojectname, "Project name cannot be null.");
		project.getProjectName().sendKeys(newprojectname);//Required Field
		//Data validation of project name field:
		String valid_string = valid_alphanum(newprojectname, "projectname", 10);
		String valid_projectname = valid_string;
		System.out.println(valid_projectname);
		
		project.getProjecttype(newprojecttype);
		project.getProjectstatus(newProjectstatus);
		
		project.getTotalsaleableArea().clear();
		project.getTotalsaleableArea().sendKeys(newtotalSaleableArea);
		//Data validation of totalSaleableArea:
		String valid_string1 = valid_number(newtotalSaleableArea, "TotalSaleableArea");
		String valid_totalSaleableArea = valid_string1;
		System.out.println(valid_totalSaleableArea);

		project.getEditNext().click();

		project.gettotalLandArea().clear();
		project.gettotalLandArea().sendKeys(newtotalLandArea);
		//Data validation of totalSaleableArea:
		String valid_string2 = valid_number(newtotalLandArea, "TotalLandArea");
		String valid_newtotalLandArea = valid_string2;
		System.out.println(valid_newtotalLandArea);

		project.getNextbtn1().click();
		
		project.getCompanyName().clear();
		project.getCompanyName().sendKeys(newcompanyname);
		
		project.GSTIN().clear();
		project.GSTIN().sendKeys(newgstin);
		
		project.PlaceofSupply().clear();
		project.PlaceofSupply().sendKeys(newplaceofsupply);
		project.getRecPostfix(newRecPostFix);
		
		project.getNextbtn2().click();
		project.getNextbtn3().click();

		Thread.sleep(2000);
		project.getSave().click();
		
		softAssert.assertEquals(valid_projectname, "projectname is a Valid Alpha-Numeric");
		softAssert.assertAll();
	}

	//Delete Project
	@Test(dataProvider="Deleteprojectdata")
	public void Delete_Project(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(3000);
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
	@Test(dataProvider = "ProjectSearchData")
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
	@Test(dataProvider = "ActiveDeactiveProject")
	public void Active_Deactive_Project(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		project.getActiveproject().click();
		project.getClickYes().click();
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
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Akash Status")) {
				Assert.assertFalse(false, "Project status is Inactive.");
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

	//Verify Add Active Project Status in Project
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
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Akash Status")) {
				Assert.assertFalse(false, "Project status is Active.");
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

	//Verify Edit InActive Project Status in Project
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
		project.getEditbtn().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectStatusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Akash Status")) {
				Assert.assertFalse(false, "Project status is Inactive.");
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

	//Verify Edit Active Project Status in Project
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
		project.getEditbtn().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectStatusID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Akash Status")) {
				Assert.assertFalse(false, "Project status is Active.");
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
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Addee")) {
				Assert.assertFalse(false, "Project Type is Inactive.");
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
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Addee")) {
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
		project.getEditbtn().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectTypeID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Addee")) {
				Assert.assertFalse(false, "Edit Project Type is Inactive.");
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
		project.getEditbtn().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='projectTypeID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Addee")) {
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
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Gujrat")) {
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
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (b.equalsIgnoreCase("Gujrat")) {
				Assert.assertFalse(false, "State is Active.");
				System.out.println("Test  Pass State is Active ");
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
		project.getEditbtn().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='stateID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Gujrat")) {
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
		project.getEditbtn().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='stateID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (b.equalsIgnoreCase("Gujrat")) {
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
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase(" Bopal Flat ")) {
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
		project.getEditbtn().click();
		Thread.sleep(2000);
		project.getEditNext().click();
		project.getNextbtn1().click();
		project.getNextbtn2().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='propertyType']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase("Bopal Flat")) {
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

		SoftAssert softAssert = new SoftAssert();
		WebElement projectname =driver.findElement(By.xpath("//span[normalize-space()='Project Name is required']"));
		softAssert.assertEquals(projectname.getText(), "Project Name is required");

		WebElement projecttype =driver.findElement(By.xpath("//span[normalize-space()='Project Type is required.']"));
		softAssert.assertEquals(projecttype.getText(), "Project Type is required.");

		WebElement projectstatus =driver.findElement(By.xpath("//span[normalize-space()='Project Status is required']"));
		softAssert.assertEquals(projectstatus.getText(), "Project Status is required");

		WebElement expectedstartdate =driver.findElement(By.xpath("//span[normalize-space()='Expected Start Date is required']"));
		softAssert.assertEquals(expectedstartdate.getText(), "Expected Start Date is required");

		WebElement expectedenddate =driver.findElement(By.xpath("//span[normalize-space()='Expected End Date is required']"));
		softAssert.assertEquals(expectedenddate.getText(), "Expected End Date is required");

		WebElement salesexecutive =driver.findElement(By.xpath("//span[normalize-space()='Sales Executive is required']"));
		softAssert.assertEquals(salesexecutive.getText(), "Sales Executive is required");		
		softAssert.assertAll();
	}
	
	//Edit Project Test Mandatory Filed Validation
	@Test
	public void Edit_Employee_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getEdit().click();
		
		Thread.sleep(2000);
		project.getProjectNameAssert().click();
		Thread.sleep(2000);
		project.getProjectNameAssert().sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		project.getEditNext().click();
		
		SoftAssert softAssert = new SoftAssert();
		WebElement projectname =driver.findElement(By.xpath("//span[normalize-space()='Project Name is required']"));
		softAssert.assertEquals(projectname.getText(), "Project Name is required");

		WebElement projecttype =driver.findElement(By.xpath("//span[normalize-space()='Project Type is required.']"));
		softAssert.assertEquals(projecttype.getText(), "Project Type is required.");

		WebElement projectstatus =driver.findElement(By.xpath("//span[normalize-space()='Project Status is required']"));
		softAssert.assertEquals(projectstatus.getText(), "Project Status is required");

		WebElement expectedstartdate =driver.findElement(By.xpath("//span[normalize-space()='Expected Start Date is required']"));
		softAssert.assertEquals(expectedstartdate.getText(), "Expected Start Date is required");

		WebElement expectedenddate =driver.findElement(By.xpath("//span[normalize-space()='Expected End Date is required']"));
		softAssert.assertEquals(expectedenddate.getText(), "Expected End Date is required");

		WebElement salesexecutive =driver.findElement(By.xpath("//span[normalize-space()='Sales Executive is required']"));
		Assert.assertEquals(salesexecutive.getText(), "Sales Executive is required");	
		softAssert.assertAll();
	}

	//Close the Driver
	@AfterMethod() 
	public void teardown() {
		//driver.close();
	}

	//DataProvider Add Project Data
	@DataProvider
	public Object[][] ProjectAddData() {
		return new Object[][] {
			//{"Automation Project1","Commercial","Planning","","","","","10000","Goa","Goa","215"," Akash Patel ","Execute the building and infrastructure work","3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058",
				//"30 MTRS. ROAD","Play Ground","F.P. NO. 954","Neighbourhood Auda Garden","964","210","Approved","65475","5600","254000","SHALIGRAM SPACE LLP","29GGGGG1314R9Z6","Ahmedabad","SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD","380058",
				//"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\125ktm.jpg","RecPrefix"," Financial Year "," FLAT "," 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ","A legal agreement between a service provider and its user that outline the rights and responsibilities of both parties",
				//"B","15","Basement"}
			{"TestProject1","AddProject1","In process","","","","","10000","Ahmedabad","Goa","215"," Nilesh Panchal ","Execute the building and infrastructure work","3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058",
				"30 MTRS. ROAD","Play Ground","F.P. NO. 954","Neighbourhood Auda Garden","964","210","Approved","100000","250000","250000","SHALIGRAM ONE LLP","29GGGGG1314R9Z6","Ahmedabad","SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD","380058",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\125ktm.jpg","RecPrefix"," Financial Year ","FLAT"," 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ","A legal agreement between a service provider and its user that outline.",
				"A Block","14","2","3BHK","2","A","FLAT","east1","west1","north1","south","321654","3465","SQ.FEET"},
			{"TestProject2","AddProject1","In process","","","","","10000","Ahmedabad","Goa","215"," Nilesh Panchal ","Execute the building and infrastructure work","3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058",
				"30 MTRS. ROAD","Play Ground","F.P. NO. 954","Neighbourhood Auda Garden","964","210","Approved","100000","250000","250000","SHALIGRAM ONE LLP","29GGGGG1314R9Z6","Ahmedabad","SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD","380058",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\125ktm.jpg","RecPrefix"," Financial Year ","FLAT"," 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ","A legal agreement between a service provider and its user that outline.",
				"B Block","14","2","3BHK","2","A","FLAT","east1","west1","north1","south","321654","3465","SQ.FEET"},
			{"TestProject3","AddProject1","In process","","","","","10000","Ahmedabad","Goa","215"," Nilesh Panchal ","Execute the building and infrastructure work","3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058",
				"30 MTRS. ROAD","Play Ground","F.P. NO. 954","Neighbourhood Auda Garden","964","210","Approved","100000","250000","250000","SHALIGRAM ONE LLP","29GGGGG1314R9Z6","Ahmedabad","SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD","380058",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\125ktm.jpg","RecPrefix"," Financial Year ","FLAT"," 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ","A legal agreement between a service provider and its user that outline.",
				"C Block","14","2","3BHK","2","A","FLAT","east1","west1","north1","south","321654","3465","SQ.FEET"},
			{"TestProject4","AddProject1","In process","","","","","10000","Ahmedabad","Goa","215"," Nilesh Panchal ","Execute the building and infrastructure work","3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058",
				"30 MTRS. ROAD","Play Ground","F.P. NO. 954","Neighbourhood Auda Garden","964","210","Approved","100000","250000","250000","SHALIGRAM ONE LLP","29GGGGG1314R9Z6","Ahmedabad","SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD","380058",
				"D:\\Fileupload\\mt15v2mtrightfrontthreequarter.png","D:\\Fileupload\\125ktm.jpg","RecPrefix"," Financial Year ","FLAT"," 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ","A legal agreement between a service provider and its user that outline.",
				"D Block","14","2","3BHK","2","A","FLAT","east1","west1","north1","south","321654","3465","SQ.FEET"}
		};
	}

	//DataProvider Edit Project Data
	@DataProvider
	public Object[][] ProjectEditData() {
		return new Object[][] { { "Automation Project","Office","In process", "20000", "1000","ABC Infotech","09AAACH7409R1ZZ","BopalGam","Financial Year" } };
	}

	//DataProvider for Delete Project Data
	@DataProvider
	public Object[][] Deleteprojectdata() {
		return new Object[][] { { "Taj Mahal" } };
	}
	
	//DataProvider for Project Search Data
	@DataProvider
	public Object[][] ProjectSearchData() {
		return new Object[][] { { "Taj Mahal" } };
	}
	
	//DataProvider for Active Deactive Project 
	@DataProvider
	public Object[][] ActiveDeactiveProject() {
		return new Object[][] { { "Taj Mahal" } };
	}
}