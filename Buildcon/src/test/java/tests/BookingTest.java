package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import pageObjects.LoginPage;
import resources.base;

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
	//Add Booking
	@Test(dataProvider ="getAddData")
	public void Add_Booking(String projectname,String unitblock, String flatshop,String bookedby, 
			String BookingDate, String paymentplan, String CarParking, String Notes, 
			String bookingstatus, String Reference , String UnitBasicCost, String DevAndOtherCharges,
			String Name, String Profession, String PAN, String AadharNo , String MobileNo, String OtherNo, String Email ,
			String PermanentAddress, String OfficeAddress,String Remarks, String bankname, String Loanamt, String Branch, String Loanaccno,
			String City) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		booking.getProjectName(projectname);//Requierd Field

		booking.getUnitBlock(unitblock);//Requierd Field

		booking.getFlatShop(flatshop);//Requierd Field

		booking.getBookedBy(bookedby);//Requierd Field

		booking.BookingDate();//Requierd Field

		booking.getPaymentPlan(paymentplan);
		booking.getCarParking().sendKeys(CarParking);
		booking.getNotes().sendKeys(Notes);

		booking.BookingStatus(bookingstatus);//Requierd Field

		booking.getReference().sendKeys(Reference);

		booking.getUnitBasicCost().sendKeys(UnitBasicCost);//Requierd Field

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
		booking.getisBroker().click();
		booking.getNextbtn3();
		booking.BankName(bankname);
		booking.getLoanamt().sendKeys(Loanamt);
		booking.getBranch().sendKeys(Branch);
		booking.getLoanAcNo().sendKeys(Loanaccno);
		booking.getCity().sendKeys(City);
		booking.getBookbtn();

	}

	//Edit Existing Project
	@Test(dataProvider="getEditData")
	public void Edit_booking(String EditCar) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.EditBooking().click();
		//booking.getcarparking1().clear();
		//booking.getcarparking1().sendKeys(EditCar);
		booking.getNextbtn().click();

	}

	//Export to Excel Booking
	@Test()
	public void Export_to_Excel_Booking() throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getExporttoExcel().click();
	}
	////Apply Filter for Dates & Booking
	@Test
	public void Apply_Filter_Booking() throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getapplyfilter().click();
		//			booking.getdaterange().click();
		//			booking.getSelectstartDate().click();
		//			booking.getSelectEndDate().click();
		//          booking.getSelectBookingBy().click();

		//			booking.getresetfilter().click();
	}

	//Search Project
	@Test(dataProvider="getSearchData")
	public void Search_Inquiry(String searchName) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getBookingSearch().sendKeys(searchName);
		booking.getBookingSearchclick().click();
	}

	//Add Booking Data Provider
	@DataProvider
	public Object[][] getAddData() {
		return new Object[][] {
			{"Testing Only","A", "Unit No - A - 106 (1st Floor) ","Dhrujal Shah"," ","Kinjal Payment Plan","2","Find over 25+ 4 BHK for Sale in Shilp Shaligram, Ahmedabad. Check 4 BHK Properties available for Sale in Shilp Shaligram ",
				"Booked","Kinjal Shah","5000000","100000","Mahavir Shah","Business", "AFZPK7190K", "2653 8564 4663", "9898005625", "9999999999", "kinjal.s@shaligraminfotech.com","Marigold Circle, Safal Parisar Rd, South Bopal, Bopal, Ahmedabad, Gujarat 380058",
				"B/h Dishman Corporate House,C.J Road, Ambli, Ahmedabad, Gujarat 380058","PREMIUM AFFORDABLE 2 & 3 BHK HOMES AND RETAIL SPACES AT SOUTH BOPAL","Testing Only Bank","100","Ahmedabad","123456","Naranpura"}};	
	}

	//Edit Booking Data Provider
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] {
			{"3,"}};	

	}
	
	//DataProvider for search data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"Testing Only"}};
	}
	
	//DataProvider for Apply Filter for Booking
	@DataProvider
	public Object[][] getbookingfilterData() {
		return new Object[][] { { "Dhrujal Shah" } };
	}
}
