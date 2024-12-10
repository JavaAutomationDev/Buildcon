package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.RoleRightsPage;
import pageObjects.LoginPage;
import resources.base;


public class RoleRightsOnlyRemoveTest extends base{

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		//Login Process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("OnlyView_user"));
		loginPage.getpass().sendKeys(prop.getProperty("OnlyView_pass"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Verify Only Remove Roles Inquiry
	@Test()
	public void Verify_OnlyRemove_Roles_Inquiry() {
		SoftAssert softAssert=new SoftAssert();
		RoleRightsPage Inquiry = new RoleRightsPage(driver);
		Inquiry.getInquiry().click();

		//Inquiry Add Button
		boolean flag = false;
		try {
			WebElement addInquiry = Inquiry.getaddInquiry();
			flag = addInquiry.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Add Inquiry visible: " + flag);
		softAssert.assertFalse(flag);

		//Inquiry Edit Button
		flag = false;
		try {
			WebElement editInquiry = Inquiry.getEdit();
			flag = editInquiry.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Edit Inquiry visible: " + flag);
		softAssert.assertFalse(flag);

		//Inquiry Delete Button
		flag = false;
		try {
			WebElement deleteInquiry = Inquiry.getInquiryDelete();
			flag = deleteInquiry.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Delete Inquiry visible: " + flag);
		softAssert.assertTrue(flag);

		//Inquiry Export Excel Button
		flag = false;
		try {
			WebElement ExportexcelInquiry = Inquiry.getInquiryExport();
			flag = ExportexcelInquiry.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Export Excel Inquiry visible: " + flag);
		softAssert.assertFalse(flag);
		softAssert.assertAll();
	}

	//Verify Only Remove Roles Prospect
	@Test()
	public void Verify_OnlyRemove_Roles_Prospect() {
		SoftAssert softAssert=new SoftAssert();
		RoleRightsPage Prospect = new RoleRightsPage(driver);
		Prospect.getprospect().click();
		//Prospect Add Button
		boolean flag = false;
		try {
			WebElement addProspect = Prospect.getAddprospect();
			//Check if the element is displayed
			flag = addProspect.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Add Prospect visible: " + flag);
		softAssert.assertFalse(flag);

		//Prospect Edit Button
		flag = false;
		try {
			WebElement editProspect = Prospect.getEditProspect();
			flag = editProspect.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Edit Prospect visible: " + flag);
		softAssert.assertFalse(flag);

		//Prospect Delete Button
		flag = false;
		try {
			WebElement deleteProspect = Prospect.getDeleteProspect();
			flag = deleteProspect.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Edit Prospect visible: " + flag);
		softAssert.assertTrue(flag);

		//Prospect Export Excel Button
		flag = false;
		try {
			WebElement ExportexcelProspect = Prospect.getExportExcelProspect();
			flag = ExportexcelProspect.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Export Excel Prospect visible: " + flag);
		softAssert.assertFalse(flag);
		softAssert.assertAll();
	}

	//Verify Only Remove Roles Project
	@Test()
	public void Verify_OnlyRemove_Roles_Project() {
		SoftAssert softAssert=new SoftAssert();
		RoleRightsPage Project = new RoleRightsPage(driver);
		Project.getproject().click();
		//Project Add Button
		boolean flag = false;
		try {
			WebElement addProject = Project.getaddproject();
			//Check if the element is displayed
			flag = addProject.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Add Project visible: " + flag);
		softAssert.assertFalse(flag);	

		//Project Edit Button
		flag = false;
		try {
			WebElement editProject = Project.getEditProject();
			flag = editProject.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Edit Project visible: " + flag);
		softAssert.assertFalse(flag);	

		//Project Delete Button
		flag = false;
		try {
			WebElement deleteProject = Project.getDeleteproject();
			flag = deleteProject.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Delete Project visible: " + flag);
		softAssert.assertTrue(flag);

		//Project Export Excel Button
		flag = false;
		try {
			WebElement ExportexcelProject = Project.getExporttoExcelProject();
			flag = ExportexcelProject.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Export Excel Project visible: " + flag);
		softAssert.assertFalse(flag);
		softAssert.assertAll();
	}

	//Verify Only Remove Roles Booking
	@Test()
	public void Verify_OnlyRemove_Roles_Booking() {
		SoftAssert softAssert=new SoftAssert();
		RoleRightsPage Booking = new RoleRightsPage(driver);
		Booking.getBooking().click();
		//Booking Add Button
		boolean flag = false;
		try {
			WebElement addBooking = Booking.getAddBooking();
			//Check if the element is displayed
			flag = addBooking.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Add Booking visible: " + flag);
		softAssert.assertFalse(flag);	

		//Booking Edit Button
		flag = false;
		try {
			WebElement editBooking = Booking.getEditBooking();
			//Check if the element is displayed
			flag = editBooking.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Edit Booking visible: " + flag);
		softAssert.assertFalse(flag);	

		//Booking export Excel Button
		flag = false;
		try {
			WebElement ExportexcelBooking = Booking.getExportExcelBooking();
			//Check if the element is displayed
			flag = ExportexcelBooking.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Export Excel Booking visible: " + flag);
		softAssert.assertFalse(flag);
		softAssert.assertAll();
	}

	//Verify Only Remove Roles Customer
	@Test()
	public void Verify_OnlyRemove_Roles_Customer() {
		SoftAssert softAssert=new SoftAssert();
		RoleRightsPage Customer = new RoleRightsPage(driver);
		Customer.getCustomer().click();
		boolean flag = false;
		try {
			WebElement ExportCustomer = Customer.getExporttoExcel();
			//Check if the element is displayed
			flag = ExportCustomer.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Export Customer visible: " + flag);
		softAssert.assertFalse(flag);	
		softAssert.assertAll();
	}

	//Verify Only Remove Roles Receipt
	@Test()
	public void Verify_OnlyRemove_Roles_Receipt() {
		SoftAssert softAssert=new SoftAssert();
		RoleRightsPage Receipt = new RoleRightsPage(driver);
		Receipt.getReceipt().click();
		//Receipt Add Button
		boolean flag = false;
		try {
			WebElement addReceipt = Receipt.getAddReceipt();
			//Check if the element is displayed
			flag = addReceipt.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Add Receipt visible: " + flag);
		softAssert.assertFalse(flag);	

		//Receipt Edit Button
		flag = false;
		try {
			WebElement editReceipt = Receipt.getEditReceipt();
			flag = editReceipt.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Edit Receipt visible: " + flag);
		softAssert.assertFalse(flag);	

		//Receipt Export Excel Button
		flag = false;
		try {
			WebElement ExportexcelReceipt = Receipt.getExportExcelreceipt();
			flag = ExportexcelReceipt.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Export Excel Receipt visible: " + flag);
		softAssert.assertFalse(flag);	
		softAssert.assertAll();
	}

	//Verify Only Remove Roles Employee
	@Test()
	public void Verify_OnlyRemove_Roles_Employee() {
		SoftAssert softAssert=new SoftAssert();
		RoleRightsPage Employee = new RoleRightsPage(driver);
		Employee.getEmployee().click();
		//Employee Add Button
		boolean flag = false;
		try {
			WebElement addEmployee = Employee.getaddemployee();
			//Check if the element is displayed
			flag = addEmployee.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Add Employee visible: " + flag);
		softAssert.assertFalse(flag);

		//Employee Edit Button
		flag = false;
		try {
			WebElement EditEmployee = Employee.getEditEmployee();
			flag = EditEmployee.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Edit Employee visible: " + flag);
		softAssert.assertFalse(flag);

		//Employee Export Excel Button
		flag = false;
		try {
			WebElement ExportExcelEmployee = Employee.ExportExcelEmployee();
			flag = ExportExcelEmployee.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Export Excel Employee visible: " + flag);
		softAssert.assertFalse(flag);

		softAssert.assertAll();
	}

	//Verify Only Remove Roles Document
	@Test()
	public void Verify_OnlyRemove_Roles_Document() {
		SoftAssert softAssert=new SoftAssert();
		RoleRightsPage Document = new RoleRightsPage(driver);
		Document.getDocument().click();
		//Document Add Button
		boolean flag = false;
		try {
			WebElement addDocument = Document.getAddDocument();
			//Check if the element is displayed
			flag = addDocument.isDisplayed();
		} catch (Exception e) {
			//Element not found, set flag to false
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Add Document visible: " + flag);
		softAssert.assertFalse(flag);

		//Document Edit Button
		flag = false;
		try {
			WebElement editDocument = Document.getEditDocument();
			flag = editDocument.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Edit Document visible: " + flag);
		softAssert.assertFalse(flag);

		//Document Delete Button
		flag = false;
		try {
			WebElement DeleteDocument = Document.getDeleteDocument();
			flag = DeleteDocument.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is Delete Document visible: " + flag);
		softAssert.assertTrue(flag);

		//Document View Button
		flag = false;
		try {
			WebElement ViewDocument = Document.getViewDocument();
			flag = ViewDocument.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not found: " + e.getMessage());
			flag = false;
		}
		System.out.println("Is View Document visible: " + flag);
		softAssert.assertFalse(flag);
		softAssert.assertAll();
	}

}
