package tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ProjectPage;
import pageObjects.Projectstatuspage;
import pageObjects.Projecttypespage;
import pageObjects.Propertytypepage;
import pageObjects.Saccodepage;
import pageObjects.Statepage;
import resources.base;

public class ProjectTest extends base {

	//Add Project
	@Test(dataProvider = "ProjectAddData", priority = 1)
	public void Add_Project(String projectname, String projecttype, String Projectstatus, String Expectedstartdate,
			String ExpectedEnddate, String ActualStartdate, String ActualEnddate, String totalSaleableArea, String city,
			String State, String Spno, String SalesExectuive, String Description, String Address, String East,
			String west, String South, String north, String Plotno, String Schemeno, String Rera, String totalLandArea,
			String MaintenanceCharge, String MaintenanceDeposit, String companyname, String gstin, String plcofsupplu,
			String RecAddress, String pincode, String projectlogo, String receiptlogo, String RecPrefix,
			String RecPostFix, String Propertytype, String Saccode, String termstext, String Unit, String Floors,
			String Basements, String unittype, String floorno, String blockno, String Unitblocktype, String east1,
			String west1, String north1, String south1, String surveyNumber, String surveyNumber2,
			String surveyNoUnitType, String paymentplan, String Paymnetphase, String completepercentage,
			String paymentpercentage) throws InterruptedException, IOException {

		SoftAssert softAssert = new SoftAssert();
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();
		Thread.sleep(1000);

		project.getProjectName().click();
		softAssert.assertFalse(projectname.isEmpty(), "Project Name is required");
		softAssert.assertNotNull(projectname, "Project name cannot be null.");
		Thread.sleep(1000);

		project.getProjectName().sendKeys(projectname);// Required Field
		// Data validation of project name field:
		String valid_string = valid_alphanum(projectname, "projectname", 100);
		String valid_projectname = valid_string;
		Thread.sleep(1000);
		System.out.println(valid_projectname);

		softAssert.assertFalse(projecttype.isEmpty(), "Project Type is required.");
		softAssert.assertNotNull(projecttype, "Project Type cannot be null.");
		project.getProjecttype(projecttype.trim());// Required Field
		Thread.sleep(1000);

		softAssert.assertFalse(Projectstatus.isEmpty(), "Project Status is required");
		softAssert.assertNotNull(Projectstatus, "Project Status cannot be null.");
		project.getProjectstatus(Projectstatus.trim());
		Thread.sleep(1000);

		// softAssert.assertFalse(Expectedstartdate.isEmpty(), "Expected Start Date is
		// required");
		// softAssert.assertNotNull(Expectedstartdate, "Expected start date cannot be
		// null.");

//		project.getExstartdate().sendKeys(Expectedstartdate);//Required Field
//		Thread.sleep(1000);

		project.getExpectedStartDate().click();
		Thread.sleep(1000);
		project.getSelectSingleDate(Expectedstartdate);

		// softAssert.assertFalse(ExpectedEnddate.isEmpty(), "Expected End Date is
		// required");
		// softAssert.assertNotNull(ExpectedEnddate, "Expected End date cannot be
		// null.");
		project.getExEnddate().sendKeys(ExpectedEnddate);// Required Field
		Thread.sleep(1000);

		// softAssert.assertFalse(ActualStartdate.isEmpty(), "Actual Start Date is
		// required");
		// softAssert.assertNotNull(ActualStartdate, "Actual date cannot be null.");
		project.getActualstartdate().sendKeys(ActualStartdate);// Required Field
		Thread.sleep(1000);

		project.getActualenddate().sendKeys(ActualEnddate);
		Thread.sleep(1000);

		project.getTotalsaleableArea().sendKeys(totalSaleableArea); // valid_number
		// Data validation of totalSaleableArea:
		String valid_string1 = valid_number(totalSaleableArea, "TotalSaleableArea");
		String valid_totalSaleableArea = valid_string1;
		System.out.println(valid_totalSaleableArea);
		Thread.sleep(1000);

		project.getcity().sendKeys(city);
		// data validation of city field:
		String valid_string2 = validateText(city, "City", 10, 30);
		String valid_City = valid_string2;
		System.out.println(valid_City);
		Thread.sleep(1000);

		project.getstate(State.trim());
		Thread.sleep(1000);

		project.getspNo().sendKeys(Spno);
		// Data validation for spno:
		String valid_string3 = valid_alphanum(Spno, "spno", 30);
		String valid_spnumber = valid_string3;
		System.out.println(valid_spnumber);
		Thread.sleep(1000);

		softAssert.assertFalse(SalesExectuive.isEmpty(), "Sales Executive is required");
		softAssert.assertNotNull(SalesExectuive, "Sales Exectuive cannot be null.");
		project.getSalesExectuive(SalesExectuive.trim());// Required Field
		Thread.sleep(2000);

		project.getdescription().sendKeys(Description);
		// Data validation for description:
		String valid_string4 = valid_alphanum(Description, "description", 500);
		String valid_Description = valid_string4;
		System.out.println(valid_Description);
		Thread.sleep(1000);

		project.getAddress().sendKeys(Address);
		// Data validation for address:
		String valid_string5 = valid_alphanum(Address, "address", 500);
		String valid_Address = valid_string5;
		System.out.println(valid_Address);

		Thread.sleep(2000);
		project.getNextbtn().click();

		project.getEast().sendKeys(East);
		String valid_string6 = valid_alphanum(East, "east", 100);
		String valid_east = valid_string6;
		System.out.println(valid_east);

		project.getWest().sendKeys(west);
		String valid_string7 = valid_alphanum(west, "west", 100);
		String valid_west = valid_string7;
		System.out.println(valid_west);

		project.getSouth().sendKeys(South);
		String valid_string8 = valid_alphanum(South, "South", 100);
		String valid_south = valid_string8;
		System.out.println(valid_south);

		project.getNorth().sendKeys(north);
		String valid_string9 = valid_alphanum(north, "north", 100);
		String valid_North = valid_string9;
		System.out.println(valid_North);

		project.getPlotNo().sendKeys(Plotno);
		String valid_string10 = valid_alphanum(Plotno, "Plotno", 40);
		String valid_plotno = valid_string10;
		System.out.println(valid_plotno);

		project.getschemeNo().sendKeys(Schemeno);
		String valid_string11 = valid_alphanum(Schemeno, "Schemeno", 40);
		String valid_Schemeno = valid_string11;
		System.out.println(valid_Schemeno);

		project.getRera().sendKeys(Rera);
		String valid_string12 = valid_alphanum(Rera, "rera", 100);
		String valid_Rera = valid_string12;
		System.out.println(valid_Rera);

		project.gettotalLandArea().sendKeys(totalLandArea);
		softAssert.assertFalse(totalLandArea.isEmpty(), "Total Land Area is required");
		String valid_string13 = valid_number(totalLandArea, "TotalLandArea");
		String valid_totalLandArea = valid_string13;
		System.out.println(valid_totalLandArea);

		project.getMaintenanceCharge().sendKeys(MaintenanceCharge);
		// Data validation of the MaintenanceCharge:
		String valid_string14 = valid_number(MaintenanceCharge, "MaintenanceCharge");
		String valid_MaintenanceCharge = valid_string14;
		System.out.println(valid_MaintenanceCharge);

		project.getMaintenanceDeposit().sendKeys(MaintenanceDeposit);
		// Data validation of maintenance deposite:
		String valid_string15 = valid_number(MaintenanceDeposit, "MaintenanceDeposit");
		String valid_MaintenanceDeposit = valid_string15;
		System.out.println(valid_MaintenanceDeposit);

		Thread.sleep(2000);
		project.getNextbtn1().click();

		softAssert.assertFalse(companyname.isEmpty(), "Company Name is required");
		softAssert.assertNotNull(companyname, "Company Name cannot be null.");
		project.getCompanyName().sendKeys(companyname);// Required Field
		// Data validation of company name:
		String valid_string16 = validateText(companyname, "companyname", 10, 100);
		String valid_companyname = valid_string16;
		System.out.println(valid_companyname);

		softAssert.assertFalse(gstin.isEmpty(), "GSTIN NO. is required");
		softAssert.assertNotNull(gstin, "GST number cannot be null.");
		project.GSTIN().sendKeys(gstin);// Required Field
		// Data validation of the gstin:
		String valid_string17 = valid_alphanum(gstin, "gstin", 11);
		String valid_gstin = valid_string17;
		System.out.println(valid_gstin);

		softAssert.assertFalse(plcofsupplu.isEmpty(), "Place Of Supply is required");
		softAssert.assertNotNull(plcofsupplu, "Place of supply cannot be null.");
		project.PlaceofSupply().sendKeys(plcofsupplu);// Required Field
		// Data validation of the place of supply:
		String valid_string18 = validateText(plcofsupplu, "placeofsupply", 10, 100);
		String valid_placeofsupply = valid_string18;
		System.out.println(valid_placeofsupply);

		softAssert.assertFalse(RecAddress.isEmpty(), "Receipt Address is required");
		softAssert.assertNotNull(RecAddress, " Receipt Address cannot be null.");
		project.getRecAddress().sendKeys(RecAddress);// Required Field
		// Data validation of the rec address:
		String valid_string19 = valid_alphanum(RecAddress, "RecAddress", 500);
		String valid_RecAddress = valid_string19;
		System.out.println(valid_RecAddress);

		softAssert.assertFalse(pincode.isEmpty(), "Pincode is required");
		softAssert.assertNotNull(pincode, "Pincode cannot be null.");
		project.getPincode().sendKeys(pincode);// Required Field
		// Data validation of pincode: valid_number
		String valid_string20 = valid_number(pincode, "pincode");
		String valid_pincode = valid_string20;
		System.out.println(valid_pincode);

		softAssert.assertFalse(projectlogo.isEmpty(), "Project’s Logo is required");
		softAssert.assertNotNull(projectlogo, "Project’s Logo cannot be null.");
		project.uploadProjectLogoFile().sendKeys(projectlogo);// Required Field
		project.uploadReceiptSeal().sendKeys(receiptlogo);

		softAssert.assertFalse(RecPrefix.isEmpty(), "Receipt Prefix is required");
		softAssert.assertNotNull(RecPrefix, "Receipt prefix cannot be null.");
		project.getRecPrefix().sendKeys(RecPrefix);// Required Field
		// Data validation of receipt prefix:
		String valid_string21 = validateText(RecPrefix, "RecPrefix", 5, 20);
		String valid_RecPrefix = valid_string21;
		System.out.println(valid_RecPrefix);

		softAssert.assertFalse(RecPostFix.isEmpty(), "Receipt Postfix is required");
		softAssert.assertNotNull(RecPostFix, "Receipt postfix cannot be null.");
		project.getRecPostfix(RecPostFix.trim());// Required Field

		Thread.sleep(4000);
		project.getNextbtn2().click();
		Thread.sleep(2000);
		project.getPropertyType(Propertytype);

		project.getSACcode(Saccode.trim());
		project.getActionbtn().click();

		project.getNextbtn3().click();
		Thread.sleep(1000);

		project.getTermstext().sendKeys(termstext);
		// Data validation of terms and condition:
		String valid_string22 = valid_alphanum(termstext, "Terms & Conditions", 1000);
		String valid_termstext = valid_string22;
		System.out.println(valid_termstext);
		project.getPlusbtn().click();
		Thread.sleep(2000);

		project.getSave().click();
		Thread.sleep(2000);

		project.getAddProjectBlock().click();
		Thread.sleep(2000);

		project.getUnitBlock().sendKeys(Unit);
		// Data validation of the block:
		String valid_string23 = valid_alphanum(Unit, "Block Name", 20);
		String valid_BlockName = valid_string23;
		System.out.println(valid_BlockName);

		Thread.sleep(1000);
		project.getNumberOfFloors().sendKeys(Floors);
		// Data validation of the floor:
		String valid_string24 = valid_number(Floors, "floor");
		String valid_floor = valid_string24;
		System.out.println(valid_floor);

		Thread.sleep(1000);
		project.getBasements().sendKeys(Basements);
		// Data validation of the basement:
		String valid_string25 = valid_number(Basements, "basement");
		String valid_basement = valid_string25;
		System.out.println(valid_basement);
		Thread.sleep(1000);

		project.getProjectBlockCreatebtn().click();
		Thread.sleep(2000);

		project.getViewBlock().click();
		Thread.sleep(1000);
		project.getAddUnit().click();
		Thread.sleep(1000);
		project.getUnitType().sendKeys(unittype);
		Thread.sleep(1000);

		project.getFloorNumber(floorno.trim());
		project.getunitBlockNumber().sendKeys(blockno);
		project.getunitBlockType(Unitblocktype.trim());

		Thread.sleep(2000);
		project.getEast1().sendKeys(east1);
		Thread.sleep(2000);
		project.getWest1().sendKeys(west1);
		Thread.sleep(2000);
		project.getNorth1().sendKeys(north1);
		Thread.sleep(2000);
		project.getSouth1().sendKeys(south1);
		Thread.sleep(2000);
		project.getsurveyNumber().sendKeys(surveyNumber);
		Thread.sleep(2000);
		project.getsurveyNumber2().sendKeys(surveyNumber2);
		Thread.sleep(2000);
		project.getsurveyNoUnitTypeID(surveyNoUnitType);
		Thread.sleep(2000);
		project.getunitCreateBtn().click();
		Thread.sleep(2000);
		project.getUnitCrossBtn().click();
		Thread.sleep(2000);
		project.getBlockconfigurationNextbtn().click();

		Thread.sleep(2000);
		project.getAddPaymentPlan().click();
		Thread.sleep(2000);
		project.getPaymentPaln(paymentplan);
		Thread.sleep(2000);
		
		project.getphasename().sendKeys(Paymnetphase);
		project.getCompletionPercentage().sendKeys(completepercentage);
		Thread.sleep(2000);
		project.getPaymentPercentage().sendKeys(paymentpercentage);
		Thread.sleep(2000);
		project.getPaymentPlanCreateBtn().click();
		Thread.sleep(2000);
		project.getSubmitBtn().click();
		Thread.sleep(2000);

		softAssert.assertEquals(valid_projectname, "projectname is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_totalSaleableArea, "TotalSaleableArea is a Valid Number");
		softAssert.assertEquals(valid_City, "City is a Valid text - is not a valid minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_spnumber, "spno is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Description, "description is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Address, "address is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_east, "east is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_west, "west is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_south, "South is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_North, "north is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_plotno, "Plotno is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Schemeno, "Schemeno is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Rera, "rera is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_totalLandArea, "TotalLandArea is a Valid Number");
		softAssert.assertEquals(valid_MaintenanceCharge, "MaintenanceCharge is a Valid Number");
		softAssert.assertEquals(valid_MaintenanceDeposit, "MaintenanceDeposit is a Valid Number");
		softAssert.assertEquals(valid_companyname,
				"companyname is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_gstin, "gstin is a Valid Alpha-Numeric is not a valid Maxlenght");
		softAssert.assertEquals(valid_placeofsupply,
				"placeofsupply is a Valid text - is not a valid minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_RecAddress, "RecAddress is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_pincode, "pincode is a Valid Number");
		softAssert.assertEquals(valid_RecPrefix,
				"RecPrefix is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_termstext,
				"Terms & Conditions is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_BlockName, "Block Name is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_floor, "floor is a Valid Number");
		softAssert.assertEquals(valid_basement, "basement is a Valid Number");
		softAssert.assertAll();
	}

	// Edit Existing Project
	@Test(dataProvider = "ProjectEditData", priority = 2)
	public void Edit_Project(String projectname, String newprojectname, String newprojecttype, String newProjectstatus,
			String newtotalSaleableArea, String newtotalLandArea, String newcompanyname, String newgstin,
			String newplaceofsupply, String newRecPostFix) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		ProjectPage project = new ProjectPage(driver);
		Thread.sleep(2000);
		project.getproject().click();
		Thread.sleep(1000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);
		project.getEdit().click();
		Thread.sleep(1000);

		project.getProjectName().clear();
		softAssert.assertFalse(newprojectname.isEmpty(), "Project name is required.");
		softAssert.assertNotNull(newprojectname, "Project name cannot be null.");
		project.getProjectName().sendKeys(newprojectname);// Required Field
		// Data validation of project name field:
		String valid_string = valid_alphanum(newprojectname, "projectname", 50);
		String valid_projectname = valid_string;
		System.out.println(valid_projectname);
		Thread.sleep(1000);

		project.getProjecttype(newprojecttype.trim());
		Thread.sleep(1000);

		project.getProjectstatus(newProjectstatus.trim());
		Thread.sleep(1000);

		project.getTotalsaleableArea().clear();
		project.getTotalsaleableArea().sendKeys(newtotalSaleableArea);
		// Data validation of totalSaleableArea:
		String valid_string1 = valid_number(newtotalSaleableArea, "TotalSaleableArea");
		String valid_totalSaleableArea = valid_string1;
		System.out.println(valid_totalSaleableArea);
		Thread.sleep(1000);

		project.getUpdateEditButton().click();
//		project.getEditNext().click();

		project.gettotalLandArea().clear();
		project.gettotalLandArea().sendKeys(newtotalLandArea);
		// Data validation of totalSaleableArea:
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
		project.getRecPostfix(newRecPostFix.trim());

		project.getNextbtn2().click();
		Thread.sleep(1000);

		project.getNextbtn3().click();
		Thread.sleep(1000);

		project.getSave().click();
		Thread.sleep(1000);

		project.getUpdateNextbutton().click();
		Thread.sleep(1000);

		project.getUpdateSubmitbutton().click();
		Thread.sleep(1000);

		softAssert.assertEquals(valid_projectname, "projectname is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertAll();
	}

	// Delete Project
	@Test(dataProvider = "Deleteprojectdata", priority = 24)
	public void Delete_Project(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(1000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(3000);
		project.getEdit1();
		Thread.sleep(1000);
		project.getDeleteproject().click();
		Thread.sleep(1000);

		Thread.sleep(2000);
		project.getClickYes().click();
		Thread.sleep(2000);
	}

	// Export to Excel
	@Test(priority = 3)
	public void Export_To_Excel_Project() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getExporttoExcel().click();
	}

	// Search Project
	@Test(dataProvider = "ProjectSearchData", priority = 4)
	public void Search_Project(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();

		Thread.sleep(2000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		boolean flag = project.NoPageFound();
		if (flag == false) {
		}
		Thread.sleep(5000);

	}

	// Active Deactive Project
	@Test(dataProvider = "ActiveDeactiveProject", priority = 5)
	public void Active_Deactive_Project(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		project.getActiveproject().click();
		Thread.sleep(2000);
		project.getClickYes().click();
		Thread.sleep(2000);
		project.getActiveproject().click();
		Thread.sleep(2000);
		project.getClickYes().click();
		Thread.sleep(2000);
	}

	// Verify Add Inactive Project status in Project
	@Test(dataProvider = "AddInactiveProjectStatusProject", priority = 6)
	public void Verify_Add_Inactive_Project_Status_Project(String projectstatus, String statusname)
			throws InterruptedException {
		Projectstatuspage Projectstatus = new Projectstatuspage(driver);
		Projectstatus.getconfiguration().click();
		Projectstatus.getprojectstatusclick().click();
		Projectstatus.getprojectStatussearchedchecked().sendKeys(projectstatus.trim() + Keys.ENTER);
		Projectstatus.getprojectstatuseditclick().click();
		Projectstatus.getActiveStatus().click();
		Projectstatus.getprojectstatussave().click();
		Thread.sleep(2000);

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getaddproject().click();
		Thread.sleep(2000);

		project.AddInactiveProjectStatusProject(statusname.trim());
		Thread.sleep(2000);
	}

	// Verify Add Active Project Status in Project
	@Test(dataProvider = "AddActiveProjectStatusProject", priority = 7)
	public void Verify_Add_Active_Project_Status_Project(String projectstatus, String statusname)
			throws InterruptedException {
		Projectstatuspage Projectstatus = new Projectstatuspage(driver);
		Projectstatus.getconfiguration().click();
		Projectstatus.getprojectstatusclick().click();
		Projectstatus.getprojectStatussearchedchecked().sendKeys(projectstatus + Keys.ENTER);
		Projectstatus.getprojectstatuseditclick().click();
		Projectstatus.getActiveStatus().click();
		Projectstatus.getprojectstatussave().click();
		Thread.sleep(2000);

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getaddproject().click();
		Thread.sleep(2000);

		project.AddActiveProjectStatusProject(statusname.trim());
		Thread.sleep(2000);
	}

	// Verify Edit InActive Project Status in Project
	@Test(dataProvider = "EditInactiveProjectStatusProject", priority = 8)
	public void Verify_Edit_Inactive_Project_Status_Project(String projectstatus, String projectname, String statusname)
			throws InterruptedException {
		Projectstatuspage Projectstatus = new Projectstatuspage(driver);
		Projectstatus.getconfiguration().click();
		Projectstatus.getprojectstatusclick().click();
		Projectstatus.getprojectStatussearchedchecked().sendKeys(projectstatus + Keys.ENTER);
		Projectstatus.getprojectstatuseditclick().click();
		Projectstatus.getActiveStatus().click();
		Projectstatus.getprojectstatussave().click();
		Thread.sleep(2000);

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.getEditbtn().click();
		Thread.sleep(2000);

		project.EditInactiveProjectStatusProject(statusname.trim());
		Thread.sleep(2000);
	}

	// Verify Edit Active Project Status in Project
	@Test(dataProvider = "EditActiveProjectStatusProject", priority = 9)
	public void Verify_Edit_Active_Project_Status_Project(String projectstatus, String projectname, String statusname)
			throws InterruptedException {
		Projectstatuspage Projectstatus = new Projectstatuspage(driver);
		Projectstatus.getconfiguration().click();
		Projectstatus.getprojectstatusclick().click();
		Projectstatus.getprojectStatussearchedchecked().sendKeys(projectstatus + Keys.ENTER);
		Projectstatus.getprojectstatuseditclick().click();
		Projectstatus.getActiveStatus().click();
		Projectstatus.getprojectstatussave().click();
		Thread.sleep(2000);

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.getEditbtn().click();
		Thread.sleep(2000);
		project.EditActiveProjectStatusProject(statusname.trim());
		Thread.sleep(2000);
	}

	// Verify Add Inactive Project Type in Project
	@Test(dataProvider = "AddInactiveProjectTypeData", priority = 10)
	public void Verify_Add_Inactive_ProjectType_Project(String projecttype, String typename)
			throws InterruptedException {
		Projecttypespage Projecttype = new Projecttypespage(driver);
		Projecttype.getconfiguration().click();
		Projecttype.projecttypesclick().click();
		Projecttype.getsearchprojecttypes().sendKeys(projecttype + Keys.ENTER);
		Projecttype.geteditprojecttypes().click();
		Thread.sleep(4000);
		Projecttype.getActiveProject();
		Thread.sleep(2000);
		Projecttype.getsavebuttonprojecttypes().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getaddproject().click();
		Thread.sleep(2000);

		project.AddInactiveProjectTypeData(typename.trim());
		Thread.sleep(2000);
	}

	// Verify Add Active Project Type in Project
	@Test(dataProvider = "AddActiveProjectTypeData", priority = 11)
	public void Verify_Add_Active_ProjectType_Project(String projecttype, String typename) throws InterruptedException {
		Projecttypespage Projecttype = new Projecttypespage(driver);
		Projecttype.getconfiguration().click();
		Projecttype.projecttypesclick().click();
		Projecttype.getsearchprojecttypes().sendKeys(projecttype + Keys.ENTER);
		Projecttype.geteditprojecttypes().click();
		Thread.sleep(4000);
		Projecttype.getActiveProject();
		Thread.sleep(2000);
		Projecttype.getsavebuttonprojecttypes().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);
		project.getaddproject().click();
		Thread.sleep(2000);
		project.AddActiveProjectTypeData(typename.trim());
		Thread.sleep(2000);
	}

	// Verify Edit Inactive Project Type in Project
	@Test(dataProvider = "EditInActiveProjectTypeData", priority = 12)
	public void Verify_Edit_Inactive_ProjectType_Project(String projecttype, String projectname, String typename)
			throws InterruptedException {
		Projecttypespage Projecttype = new Projecttypespage(driver);
		Projecttype.getconfiguration().click();
		Projecttype.projecttypesclick().click();
		Projecttype.getsearchprojecttypes().sendKeys(projecttype + Keys.ENTER);
		Projecttype.geteditprojecttypes().click();
		Thread.sleep(4000);
		Projecttype.getActiveProject();
		Thread.sleep(2000);
		Projecttype.getsavebuttonprojecttypes().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.getEditbtn().click();
		project.EditInActiveProjectTypeData(typename.trim());
	}

	// Verify Edit Active Project Type in Project
	@Test(dataProvider = "EditActiveProjectTypeData", priority = 13)
	public void Verify_Edit_Active_ProjectType_Project(String projecttype, String projectname, String typename)
			throws InterruptedException {
		Projecttypespage Projecttype = new Projecttypespage(driver);
		Projecttype.getconfiguration().click();
		Projecttype.projecttypesclick().click();
		Projecttype.getsearchprojecttypes().sendKeys(projecttype + Keys.ENTER);
		Projecttype.geteditprojecttypes().click();
		Thread.sleep(4000);
		Projecttype.getActiveProject();
		Thread.sleep(2000);
		Projecttype.getsavebuttonprojecttypes().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.getEditbtn().click();
		Thread.sleep(2000);
		project.EditActiveProjectType(typename.trim());
		Thread.sleep(2000);
	}

	// State With Project Relation
	// Verify Add Inactive State in Project
	@Test(dataProvider = "AddInactiveStateData", priority = 14)
	public void Verify_Add_Inactive_State_Project(String Statename, String name) throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatesearching().sendKeys(Statename + Keys.ENTER);

		Thread.sleep(2000);
		state.editrow().click();
		Thread.sleep(2000);
		state.getActive().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getaddproject().click();
		Thread.sleep(2000);
		project.AddInactiveStateData(name.trim());
		Thread.sleep(2000);
	}

	// Verify Add Active State in Project
	@Test(dataProvider = "AddActiveStateData", priority = 15)
	public void Verify_Add_Active_State_Project(String Statename, String name) throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatesearching().sendKeys(Statename + Keys.ENTER);
		Thread.sleep(2000);
		state.editrow().click();
		Thread.sleep(2000);
		state.getActive().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getaddproject().click();
		Thread.sleep(2000);
		project.AddActiveStateData(name.trim());
		Thread.sleep(2000);
	}

	// Verify Edit Inactive State in Project
	@Test(dataProvider = "EditInActiveStateData", priority = 16)
	public void Verify_Edit_Inactive_State_Project(String Statename, String projectname, String name)
			throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatesearching().sendKeys(Statename + Keys.ENTER);
		Thread.sleep(2000);
		state.editrow().click();
		Thread.sleep(2000);
		state.getActive().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.getEditbtn().click();
		Thread.sleep(2000);
		project.EditInActiveStateData(name.trim());
		Thread.sleep(2000);
	}

	// Verify Edit Active State in Project
	@Test(dataProvider = "EditActiveStateData", priority = 17)
	public void Verify_Edit_Active_State_Project(String Statename, String projectname, String name)
			throws InterruptedException {
		Statepage state = new Statepage(driver);
		state.getconfiguration().click();
		state.getclickstate().click();
		state.getstatesearching().sendKeys(Statename + Keys.ENTER);
		Thread.sleep(2000);
		state.editrow().click();
		Thread.sleep(2000);
		state.getActive().click();
		Thread.sleep(2000);
		state.getsavestate().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.getEditbtn().click();
		Thread.sleep(2000);
		project.EditActiveStateData(name.trim());
		Thread.sleep(2000);
	}

	// Property Type
	// Verify Edit Inactive Property Type in Project
	@Test(dataProvider = "EditInactivePropertyTypeData", priority = 18)
	public void Verify_Edit_Inactive_Property_Type_Project(String propertyname, String projectname, String name)
			throws InterruptedException {
		Propertytypepage PropertyType = new Propertytypepage(driver);
		PropertyType.getconfiguration().click();
		PropertyType.getpropertytype().click();
		PropertyType.getpropertytypesearch().sendKeys(propertyname + Keys.ENTER);
		PropertyType.geteditpropertytype().click();
		PropertyType.getActiveStatus().click();
		PropertyType.getsavebuttoneditpropertytype().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.GetEditNext();
		Thread.sleep(2000);
		project.getNextbtn1().click();
		Thread.sleep(2000);
		project.getNextbtn2().click();
		Thread.sleep(2000);
		project.EditInactivePropertyTypeData(name.trim());
		Thread.sleep(2000);
	}

	// Verify Edit Active Property Type in Project
	@Test(dataProvider = "EditActivePropertyTypeData", priority = 19)
	public void Verify_Edit_Active_Property_Type_Project(String propertyname, String projectname, String name)
			throws InterruptedException {
		Propertytypepage PropertyType = new Propertytypepage(driver);
		PropertyType.getconfiguration().click();
		PropertyType.getpropertytype().click();
		PropertyType.getpropertytypesearch().sendKeys(propertyname + Keys.ENTER);
		PropertyType.geteditpropertytype().click();
		PropertyType.getActiveStatus().click();
		PropertyType.getsavebuttoneditpropertytype().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(5000);

		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.getEditbtn().click();
		Thread.sleep(2000);
		project.getEditNext().click();
		project.getNextbtn1().click();
		project.getNextbtn2().click();
		Thread.sleep(2000);
		project.EditActivePropertyTypeData(name.trim());
		Thread.sleep(2000);
	}

	// SAC Code
	// Verify Edit Inactive SAC Code in Project
	@Test(dataProvider = "EditInactiveSACCodeData", priority = 20)
	public void Verify_Edit_Inactive_SAC_Code_Project(String saccode, String projectname, String sacname)
			throws InterruptedException {
		Saccodepage Saccode = new Saccodepage(driver);
		Saccode.getconfiguration().click();
		Saccode.getsaccodeclick().click();
		Saccode.getsearchsaccode().sendKeys(saccode + Keys.ENTER);
		Saccode.getEditclicksaccode().click();
		Saccode.getEditsavebutton().click();

		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		Thread.sleep(2000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.GetEditNext();
		project.getNextbtn1().click();
		project.getNextbtn2().click();
		Thread.sleep(2000);
		project.EditInactiveSACCodeData(sacname.trim());
		Thread.sleep(2000);
	}

	// Verify Edit Active SAC Code in Project
	@Test(dataProvider = "EditActiveSACCodeData", priority = 21)
	public void Verify_Edit_Active_SAC_Code_Project(String saccode, String projectname, String sacname)
			throws InterruptedException {
		Saccodepage Saccode = new Saccodepage(driver);
		Saccode.getconfiguration().click();
		Saccode.getsaccodeclick().click();
		Saccode.getsearchsaccode().sendKeys(saccode + Keys.ENTER);
		Saccode.getEditclicksaccode().click();
		Saccode.getEditsavebutton().click();
		Thread.sleep(2000);
		ProjectPage project = new ProjectPage(driver);
		Thread.sleep(2000);
		project.getproject().click();
		Thread.sleep(2000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(1000);

		project.GetEditNext();
		project.getNextbtn1().click();
		project.getNextbtn2().click();
		Thread.sleep(2000);
		project.EditActiveSACCodeData(sacname.trim());
		Thread.sleep(2000);
	}

	// Add Project Test Mandatory Filed Validation
	@Test(priority = 22)
	public void Add_Employee_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getaddproject().click();
		Thread.sleep(2000);
		project.getProjectClick().click();

		SoftAssert softAssert = new SoftAssert();
		WebElement projectname = driver.findElement(By.xpath("//span[normalize-space()='Project Name is required']"));
		softAssert.assertEquals(projectname.getText(), "Project Name is required");

		WebElement projecttype = driver.findElement(By.xpath("//span[normalize-space()='Project Type is required.']"));
		softAssert.assertEquals(projecttype.getText(), "Project Type is required.");

		WebElement projectstatus = driver
				.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[3]/vex-searchable-dropdown/mat-form-field/div[2]/div/mat-error/span"));
		softAssert.assertEquals(projectstatus.getText(), "Project Status is required.");

		WebElement expectedstartdate = driver
				.findElement(By.xpath("//span[normalize-space()='Expected Start Date is required']"));
		softAssert.assertEquals(expectedstartdate.getText(), "Expected Start Date is required");

		WebElement expectedenddate = driver
				.findElement(By.xpath("//span[normalize-space()='Expected End Date is required']"));
		softAssert.assertEquals(expectedenddate.getText(), "Expected End Date is required");

		WebElement salesexecutive = driver
				.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[12]/vex-searchable-dropdown/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(salesexecutive.getText(), "Sales Executive is required.");
		softAssert.assertAll();
	}

	// Edit Project Test Mandatory Filed Validation
	@Test(dataProvider = "EditEmployeeTestMandatoryData", priority = 23)
	public void Edit_Employee_Test_Mandatory_Filed_Validation(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		Thread.sleep(2000);
		project.getproject().click();
		Thread.sleep(2000);
		project.getSearch().sendKeys(projectname + Keys.ENTER);
		Thread.sleep(2000);
		project.getEditbtn().click();
		Thread.sleep(2000);
		project.getProjectNameAssert().click();
		int Projname = project.getProjectNameAssert().getAttribute("value").length();
		for (int i = 0; i < Projname; i++) {
			project.getProjectNameAssert().sendKeys(Keys.CONTROL, "a");
			project.getProjectNameAssert().sendKeys(Keys.BACK_SPACE);
		}
		project.getProjectNameAssert().sendKeys(Keys.TAB);

		project.getEditExpecetedStartDate().click();
		int Expecetedstartdate = project.getEditExpecetedStartDate().getAttribute("value").length();
		for (int i = 0; i < Expecetedstartdate; i++) {
			project.getEditExpecetedStartDate().sendKeys(Keys.CONTROL, "a");
			project.getEditExpecetedStartDate().sendKeys(Keys.BACK_SPACE);
		}
		project.getEditExpecetedStartDate().sendKeys(Keys.TAB);

		project.getEditExpecetedEndDate().click();
		int Expecetedenddate = project.getEditExpecetedEndDate().getAttribute("value").length();
		for (int i = 0; i < Expecetedenddate; i++) {
			project.getEditExpecetedEndDate().sendKeys(Keys.CONTROL, "a");
			project.getEditExpecetedEndDate().sendKeys(Keys.BACK_SPACE);
		}
		project.getEditExpecetedEndDate().sendKeys(Keys.TAB);

		project.getEditActualStartDate().click();
		int Actualstartdate = project.getEditActualStartDate().getAttribute("value").length();
		for (int i = 0; i < Actualstartdate; i++) {
			project.getEditActualStartDate().sendKeys(Keys.CONTROL, "a");
			project.getEditActualStartDate().sendKeys(Keys.BACK_SPACE);
		}
		project.getEditActualStartDate().sendKeys(Keys.TAB);

		SoftAssert softAssert = new SoftAssert();
		WebElement Projectname = driver.findElement(By.xpath("//span[normalize-space()='Project Name is required']"));
		softAssert.assertEquals(Projectname.getText(), "Project Name is required");

		WebElement expectedstartdate = driver
				.findElement(By.xpath("//span[normalize-space()='Expected Start Date is required']"));
		softAssert.assertEquals(expectedstartdate.getText(), "Expected Start Date is required");

		WebElement expectedenddate = driver
				.findElement(By.xpath("//span[normalize-space()='Expected End Date is required']"));
		softAssert.assertEquals(expectedenddate.getText(), "Expected End Date is required");

		WebElement actualstartdate = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/app-project-save/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[6]/mat-form-field/div[2]/div"));
		softAssert.assertEquals(actualstartdate.getText(), "Actual Start Date is required");
		softAssert.assertAll();
	}

	// Close the Driver
	@AfterMethod()
	public void teardown() {
		driver.close();
	}

	// DataProvider Add Project Data
	@DataProvider
	public Object[][] ProjectAddData() {
		return new Object[][] { 
			{ "Automation Project16", "AddProject1", "In process", "11/JAN/2025", "", "", "",
				"10000", "Ahmedabad", "Goa", "215", " Nilesh Panchal ", "Execute the building and infrastructure work",
				"3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058", "30 MTRS. ROAD",
				"Play Ground", "F.P. NO. 954", "Neighbourhood Auda Garden", "964", "210", "Approved", "100000",
				"250000", "250000", "SHALIGRAM ONE LLP", "29GGGGG1314R9Z6", "Ahmedabad",
				"SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD",
				"380058", "C:\\mt15v2mtrightfrontthreequarter.png",
				"C:\\mt15v2mtrightfrontthreequarter.png", "RecPrefix", " Financial Year ",
				"FLAT", " 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ",
				"A legal agreement between a service provider and its user that outline.", "A Block", "14", "2", "3BHK",
				"2", "A", "FLAT", "east1", "west1", "north1", "south", "321654", "3465", "SQ.FEET", "SIT PaymentPlan",
				"1", "10", "100" },

				{ "Automation Project17", "AddProject1", "In process", "11/JAN/2025", "", "", "", "10000", "Ahmedabad", "Goa",
						"215", " Nilesh Panchal ", "Execute the building and infrastructure work",
						"3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058", "30 MTRS. ROAD",
						"Play Ground", "F.P. NO. 954", "Neighbourhood Auda Garden", "964", "210", "Approved", "100000",
						"250000", "250000", "SHALIGRAM ONE LLP", "29GGGGG1314R9Z6", "Ahmedabad",
						"SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD",
						"380058", "C:\\mt15v2mtrightfrontthreequarter.png",
						"C:\\mt15v2mtrightfrontthreequarter.png",
						"RecPrefix", " Financial Year ", "FLAT",
						" 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ",
						"A legal agreement between a service provider and its user that outline.", "B Block", "14", "2",
						"3BHK", "2", "A", "FLAT", "east1", "west1", "north1", "south", "321654", "3465", "SQ.FEET",
						"SIT PaymentPlan", "2", "10", "100" },

				{ "Automation Project18", "AddProject1", "In process", "11/JAN/2025", "", "", "", "10000", "Ahmedabad", "Goa",
						"215", " Nilesh Panchal ", "Execute the building and infrastructure work",
						"3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058", "30 MTRS. ROAD",
						"Play Ground", "F.P. NO. 954", "Neighbourhood Auda Garden", "964", "210", "Approved", "100000",
						"250000", "250000", "SHALIGRAM ONE LLP", "29GGGGG1314R9Z6", "Ahmedabad",
						"SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD",
						"380058", "C:\\mt15v2mtrightfrontthreequarter.png",
						"C:\\mt15v2mtrightfrontthreequarter.png",
						"RecPrefix", " Financial Year ", "FLAT",
						" 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ",
						"A legal agreement between a service provider and its user that outline.", "C Block", "14", "2",
						"3BHK", "2", "A", "FLAT", "east1", "west1", "north1", "south", "321654", "3465", "SQ.FEET",
						"SIT PaymentPlan", "3", "10", "100" },

				{ "Automation Project19", "AddProject1", "In process", "11/JAN/2025", "", "", "", "10000", "Ahmedabad", "Goa",
						"215", " Nilesh Panchal ", "Execute the building and infrastructure work",
						"3rd Floor, Shaligram Corporates, C.J Road, Ambli, Ahmedabad, Gujarat 380058", "30 MTRS. ROAD",
						"Play Ground", "F.P. NO. 954", "Neighbourhood Auda Garden", "964", "210", "Approved", "100000",
						"250000", "250000", "SHALIGRAM ONE LLP", "29GGGGG1314R9Z6", "Ahmedabad",
						"SHALIGRAM CORPORATES, 9TH FLOOR, B/H. DISHMAN HOUSE, OPP. SANKALP GRACE-II, ISCON-AMBLI ROAD, AHMEDABAD",
						"380058", "C:\\mt15v2mtrightfrontthreequarter.png",
						"C:\\mt15v2mtrightfrontthreequarter.png",
						"RecPrefix", " Financial Year ", "FLAT",
						" 995411 - CONSTRUCTION SERVICES OF RESIDENTIAL BUILDINGS ",
						"A legal agreement between a service provider and its user that outline.", "D Block", "14", "2",
						"3BHK", "2", "A", "FLAT", "east1", "west1", "north1", "south", "321654", "3465", "SQ.FEET",
						"SIT PaymentPlan", "4", "10", "100" } 
						};
	}

	// DataProvider Edit Project Data
	@DataProvider
	public Object[][] ProjectEditData() {
		return new Object[][] { { "Automation Project6", "Automation Project12", "ProjecttypesTest2", "In process",
				"20000", "1000", "ABC Infotech", "09AAACH7409R1ZZ", "BopalGam", "Financial Year" } };
	}

	// DataProvider for Delete Project Data
	@DataProvider
	public Object[][] Deleteprojectdata() {
		return new Object[][] { { "Automation Project16" },{"Automation Project17"},{"Automation Project18"},{"Automation Project19"},
		};
	}

	// DataProvider for Project Search Data
	@DataProvider
	public Object[][] ProjectSearchData() {
		return new Object[][] { { "Automation Project22" } };
	}

	// DataProvider for Active Deactive Project
	@DataProvider
	public Object[][] ActiveDeactiveProject() {
		return new Object[][] { { "Automation Project5" } };
	}

	// DataProvider for Add Inactive Project Status Project
	@DataProvider
	public Object[][] AddInactiveProjectStatusProject() {
		return new Object[][] { { "InActive", "InActive" } };
	}

	// DataProvider for Add Active Project Status Project
	@DataProvider
	public Object[][] AddActiveProjectStatusProject() {
		return new Object[][] { { "InActive", "InActive" } };
	}

	// DataProvider for Edit Inactive Project Status Project
	@DataProvider
	public Object[][] EditInactiveProjectStatusProject() {
		return new Object[][] { { "InActive", "Automation Project4", "InActive" } };
	}

	// DataProvider for Edit Active Project Status Project
	@DataProvider
	public Object[][] EditActiveProjectStatusProject() {
		return new Object[][] { { "InActive", "Automation Project4", "InActive" } };
	}

	// DataProvider for Add Inactive Project Type Data
	@DataProvider
	public Object[][] AddInactiveProjectTypeData() {
		return new Object[][] { { "SIT ProjectType", "SIT ProjectType" } };
	}

	// DataProvider for Add Active Project Type Data
	@DataProvider
	public Object[][] AddActiveProjectTypeData() {
		return new Object[][] { { "SIT ProjectType", "SIT ProjectType" } };
	}

	// DataProvider for Edit InActive Project Type Data
	@DataProvider
	public Object[][] EditInActiveProjectTypeData() {
		return new Object[][] { { "SIT ProjectType", "Automation Project4", "SIT ProjectType" } };
	}

	// DataProvider for Edit Active Project Type Data
	@DataProvider
	public Object[][] EditActiveProjectTypeData() {
		return new Object[][] { { "SIT ProjectType", "Automation Project4", "SIT ProjectType" } };
	}

	// DataProvider for Add Inactive State Data
	@DataProvider
	public Object[][] AddInactiveStateData() {
		return new Object[][] { { "SIT State", "SIT State" } };
	}

	// DataProvider for Add Active State Data
	@DataProvider
	public Object[][] AddActiveStateData() {
		return new Object[][] { { "SIT State", "SIT State" } };
	}

	// DataProvider for Edit InActive State Data
	@DataProvider
	public Object[][] EditInActiveStateData() {
		return new Object[][] { { "SIT State", "Automation Project4", "SIT State" } };
	}

	// DataProvider for Edit Active State Data
	@DataProvider
	public Object[][] EditActiveStateData() {
		return new Object[][] { { "SIT State", "Automation Project4", "SIT State" } };
	}

	// DataProvider for Edit Inactive Property Type Data
	@DataProvider
	public Object[][] EditInactivePropertyTypeData() {
		return new Object[][] { { "SIT PropertyType", "Automation Project4", "SIT PropertyType" } };
	}

	// DataProvider for Edit Active Property Type Data
	@DataProvider
	public Object[][] EditActivePropertyTypeData() {
		return new Object[][] { { "SIT PropertyType", "Automation Project4", "SIT PropertyType" } };
	}

	// DataProvider for Edit Inactive SAC Code Data
	@DataProvider
	public Object[][] EditInactiveSACCodeData() {
		return new Object[][] { { "555555", "Automation Project4", "555555" } };
	}

	// DataProvider for Edit Active SAC Code Data
	@DataProvider
	public Object[][] EditActiveSACCodeData() {
		return new Object[][] { { "555555", "Automation Project4", "555555" } };
	}

	// DataProvider for Edit Employee Test Mandatory Data
	@DataProvider
	public Object[][] EditEmployeeTestMandatoryData() {
		return new Object[][] { { "Automation Project10" } };
	}
}