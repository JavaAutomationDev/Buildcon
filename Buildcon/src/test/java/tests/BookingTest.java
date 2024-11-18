package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import pageObjects.LoginPage;
import resources.base;

//Test2

public class BookingTest extends base {

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
	@Test(dataProvider ="getAddData")
	public void Add_Booking(String projectname,String unitblock, String flatshop,String bookedby, 
			String BookingDate, String paymentplan, String CarParking, String Notes, 
			String bookingstatus, String Reference , String UnitBasicCost, String DevAndOtherCharges,
			String Name, String Profession, String PAN, String AadharNo , String MobileNo, String OtherNo, String Email ,
			String PermanentAddress, String OfficeAddress,String Remarks, String bankname, String Loanamt, String Branch, String loadnacno,
			String City) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		booking.getProjectName(projectname);	
		booking.getUnitBlock(unitblock);
		booking.getFlatShop(flatshop);
		booking.getBookedBy(bookedby);
		booking.BookingDate();
		booking.getPaymentPlan(paymentplan);
		booking.getCarParking().sendKeys(CarParking);
		booking.getNotes().sendKeys(Notes);
		booking.BookingStatus(bookingstatus);
		booking.getReference().sendKeys(Reference);
		booking.getUnitBasicCost().sendKeys(UnitBasicCost);		
		booking.getDevAndOtherCharges().sendKeys(DevAndOtherCharges);
		booking.getNextbtn().click();
		booking.getName().sendKeys(Name);
		booking.getProfession().sendKeys(Profession);
		booking.Birthdate();
		booking.getPAN().sendKeys(PAN);
		booking.getAadharNo().sendKeys(AadharNo);
		booking.getMobileNo().sendKeys(MobileNo);
		booking.getOtherNo().sendKeys(OtherNo);
		booking.getEmail().sendKeys(Email);
		booking.getPermanentAddress().sendKeys(PermanentAddress);
		booking.getOfficeAddress().sendKeys(OfficeAddress);
		booking.getRemarks().sendKeys(Remarks);
		booking.getNextbtn2().click();
		Thread.sleep(1000);
		booking.getisBroker().click();
		booking.getNextbtn3().click();
		booking.getisBroker().click();
		booking.BankName(bankname);
		booking.getLoanamt().sendKeys(Loanamt);
		booking.getBranch().sendKeys(Branch);
		booking.getloadnacno().sendKeys(loadnacno);
		booking.getCity().sendKeys(City);
		booking.getBookbtn();

	}
	//Add Booking Data Provider
	@DataProvider
	public Object[][] getAddData() {
		return new Object[][] {
			{"Taj Mahal","A", "Unit No - 101 (1st Floor)","Dhrujal Shah"," ","Kinjal Payment Plan","2","Find over 25+ 4 BHK for Sale in Shilp Shaligram, Ahmedabad. Check 4 BHK Properties available for Sale in Shilp Shaligram ",
				"Booked","Kinjal Shah","5000000","100000","Mahavir Shah","Business", "AFZPK7190K", "2653 8564 4663", "9898005625", "9999999999", "kinjal.s@shaligraminfotech.com","Marigold Circle, Safal Parisar Rd, South Bopal, Bopal, Ahmedabad, Gujarat 380058",
				"B/h Dishman Corporate House,C.J Road, Ambli, Ahmedabad, Gujarat 380058","PREMIUM AFFORDABLE 2 & 3 BHK HOMES AND RETAIL SPACES AT SOUTH BOPAL","Testing Only Bank","100","Ahmedabad","123456","Naranpura"}};	
	}
	//Edit Existing Project
	@Test(dataProvider="getEditData")
	public void Edit_booking(String newCarParking, String newMobileNo, String newBranch ) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getEdit().click();
		booking.getCarParking().clear();
		booking.getCarParking().sendKeys(newCarParking);
		Thread.sleep(2000);
		booking.getNextbtn().click();
		Thread.sleep(2000);
		booking.getMobileNo().clear();
		booking.getMobileNo().sendKeys(newMobileNo);
		Thread.sleep(2000);
		booking.getNextbtn2().click();
		Thread.sleep(2000);
		booking.getNextbtn3().click();
		Thread.sleep(2000);
		booking.getBranch().clear();
		booking.getBranch().sendKeys(newBranch);
		booking.getUpdate().click();

	}

	//Edit Project Data
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] {
			{"3","9696969696", "Naranpura"}};
	}

	//Cancel Booking
	@Test(dataProvider="getCancelBooking")
	public void Cancel_Booking(String Reason ) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getCancelbooking().click();
		booking.getReason().sendKeys(Reason);
		Thread.sleep(1000);
		booking.getAgreementSaleRcvd().click();
		Thread.sleep(2000);
		booking.getCancelBooking2().click();
		Thread.sleep(1000);
		booking.getYesbutton().click();
	}
	//All Document
	//Documentation Details and Booking Form	
	@Test(dataProvider="getAllDocument")
	public void All_Document(String AgreementNumber, String SaleDeed) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getalldocuments().click();
		booking.getDocumentationDetails().click();
		booking.getAgreementNumber().clear();
		booking.getAgreementNumber().sendKeys(AgreementNumber);
		booking.getSaleDeed().clear();
		booking.getSaleDeed().sendKeys(SaleDeed);
		booking.getSavebutton().click();
		Thread.sleep(1000);
		booking.getalldocuments().click();
		Thread.sleep(1000);
		booking.getBookingForm().click();
		Thread.sleep(10000);
		driver.quit();

	}

	//Inquiry Form			
	@Test(dataProvider="getAllDocument")
	public void All_Document2(String AgreementNumber, String SaleDeed) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getalldocuments().click();
		booking.getDocumentationDetails().click();
		booking.getAgreementNumber().clear();
		booking.getAgreementNumber().sendKeys(AgreementNumber);
		booking.getSaleDeed().clear();
		booking.getSaleDeed().sendKeys(SaleDeed);
		booking.getSavebutton().click();
		Thread.sleep(1000);
		booking.getalldocuments().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[4]")).click();
		Thread.sleep(10000);
		driver.quit();		
	}	

	//Agreement Form
	@Test(dataProvider="getAllDocument")
	public void All_Document3(String AgreementNumber, String SaleDeed) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getalldocuments().click();
		booking.getDocumentationDetails().click();
		booking.getAgreementNumber().clear();
		booking.getAgreementNumber().sendKeys(AgreementNumber);
		booking.getSaleDeed().clear();
		booking.getSaleDeed().sendKeys(SaleDeed);
		booking.getSavebutton().click();
		Thread.sleep(1000);
		booking.getalldocuments().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[2]")).click();
		Thread.sleep(10000);
		driver.quit();
	}				
	//DataProvider for Agreement Number 
	@DataProvider
	public Object[][] getAllDocument() {
		return new Object[][] { { "123456", "999999"} };				
	}
	//DataProvider for Cancel Booking
	@DataProvider
	public Object[][] getCancelBooking() {
		return new Object[][] { { "Not intested now.",} };
	}
	//Search Project
	@Test(dataProvider="getSearchData")
	public void Search_Inquiry(String searchName) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getBookingSearch().sendKeys(searchName);
		booking.getBookingSearchclick().click();
	}

	//DataProvider for search data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"Testing Only"}};
	}
	//Export to Excel Booking
	@Test()
	public void Export_to_Excel_Booking() throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getExporttoExcel().click();
	}
	//Apply Filter for Dates & Booking
	@Test(dataProvider="getbookingfilterData")
	public void Apply_Filter_Booking(String bookedby1, String selectproject ) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getdaterange().click();
		booking.getSelectstartDate().click();
		booking.getSelectEndDate().click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		booking.getbookedby1(bookedby1);
		Thread.sleep(5000);
		Thread.sleep(5000);
		booking.getselectproject(selectproject);
		Thread.sleep(5000);
		booking.getresetfilter().click();
		Thread.sleep(5000);   
	}
	//DataProvider for Apply Filter for Booking
	@DataProvider
	public Object[][] getbookingfilterData() {
		return new Object[][] { { "Testing Shah", " Testing Only "} };
	}

}

