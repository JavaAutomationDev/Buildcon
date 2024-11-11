package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.BookingPage;
import pageObjects.LoginPage;
import pageObjects.ProjectPage;
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
		
		//Login process
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Booking
	@Test(dataProvider = "getAddData")
	public void Add_Booking(String projectname, String unitblock, String flatshop, String bookedby, String BookingDate,
			String paymentplan1, String CarParking, String Notes, String bookingstatus, String Reference,
			String UnitBasicCost, String DevAndOtherCharges, String Name, String profession, String PAN,
			String AadharNo, String MobileNo, String OtherNo, String Email, String PermanentAddress,
			String OfficeAddress, String Remarks, String BrokerName, String BrokerAmount, String BrokeringCompany,
			String BrokerMobileNo, String bankname, String Loanamt, String Branch, String loadnacno, String City)
					throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		booking.getProjectName(projectname);
		booking.getUnitBlock(unitblock);
		booking.getFlatShop(flatshop);
		booking.getBookedBy(bookedby);
		booking.BookingDate();
		booking.getPaymentPlan(paymentplan1);
		booking.getCarParking().sendKeys(CarParking);
		booking.getNotes().sendKeys(Notes);
		booking.BookingStatus(bookingstatus);
		booking.getReference().sendKeys(Reference);
		booking.getUnitBasicCost().sendKeys(UnitBasicCost);
		booking.getDevAndOtherCharges().sendKeys(DevAndOtherCharges);
		Thread.sleep(2000);
		booking.getNextbtn().click();
		Thread.sleep(2000);
		booking.getName().sendKeys(Name);
		booking.Profession(profession);
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
		Thread.sleep(2000);
		booking.getisBroker().click();
		Thread.sleep(2000);
		booking.getBrokerName().sendKeys(BrokerName);
		booking.getBrokerAmount().sendKeys(BrokerAmount);
		booking.getBrokeringCompany().sendKeys(BrokeringCompany);
		booking.getBrokerMobileNo().sendKeys(BrokerMobileNo);
		booking.addprofile1();
		booking.getNextbtn3().click();
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
		return new Object[][] {{ "Testing Only","A"," Unit No - A  - 111 (1st Floor) ","Dhrujal Shah"," ","Kinjal Payment Plan","2",
			"Find over 25+ 4 BHK for Sale in Shilp Shaligram, Ahmedabad. Check 4 BHK Properties available for Sale in Shilp Shaligram ",
			"Booked","Kinjal Shah","5000000","100000","Mahavir Shah","Software Engineer","ABCTY1234D","2653 8564 4663","9898005625", 
			"9999999999", "kinjal.s@shaligraminfotech.com",
			"Marigold Circle, Safal Parisar Rd, South Bopal, Bopal, Ahmedabad, Gujarat 380058",
			"B/h Dishman Corporate House,C.J Road, Ambli, Ahmedabad, Gujarat 380058",
			"PREMIUM AFFORDABLE 2 & 3 BHK HOMES AND RETAIL SPACES AT SOUTH BOPAL", "Mahavir Shah", "50000",
			"Arihant Company", "9696969696", "Testing Only Bank", "100", "Ahmedabad", "123456", "Naranpura" } };
	}

	//Edit Existing Project
	@Test(dataProvider = "getEditData")
	public void Edit_booking(String newCarParking, String NewNotes, String NewReference, String NewUnitBasicCost,
			String NewDevAndOtherCharges, String NewName, String NewPAN, String NewAadharNo, String newMobileNo,
			String NewEmail, String NewPermanentAddress, String NewOfficeAddress, String NewLoanamt, String newBranch,
			String NewCity) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getEdit().click();
		booking.getCarParking().clear();
		booking.getCarParking().sendKeys(newCarParking);
		Thread.sleep(2000);
		booking.getNotes().clear();
		booking.getNotes().sendKeys(NewNotes);
		Thread.sleep(2000);
		booking.getReference().clear();
		booking.getReference().sendKeys(NewReference);
		Thread.sleep(3000);
		//booking.getUnitBasicCost().clear();
		for (int i = 1; i <= 20; i++) {
			booking.getUnitBasicCost().sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		booking.getUnitBasicCost().sendKeys(NewUnitBasicCost);
		Thread.sleep(5000);
		//booking.getDevAndOtherCharges().clear();
		for (int i = 1; i <= 20; i++) {
			booking.getDevAndOtherCharges().sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		booking.getDevAndOtherCharges().sendKeys(NewDevAndOtherCharges);
		Thread.sleep(5000);
		booking.getNextbtn().click();
		Thread.sleep(2000);
		booking.getName().clear();
		booking.getName().sendKeys(NewName);
		Thread.sleep(2000);
		booking.getPAN().clear();
		booking.getPAN().sendKeys(NewPAN);
		booking.getMobileNo().clear();
		Thread.sleep(2000);
		booking.getAadharNo().clear();
		booking.getAadharNo().sendKeys(NewAadharNo);
		Thread.sleep(2000);
		booking.getMobileNo().sendKeys(newMobileNo);
		Thread.sleep(2000);
		booking.getEmail().clear();
		booking.getEmail().sendKeys(NewEmail);
		Thread.sleep(2000);
		booking.getPermanentAddress().clear();
		booking.getPermanentAddress().sendKeys(NewPermanentAddress);
		Thread.sleep(2000);
		booking.getOfficeAddress().clear();
		booking.getOfficeAddress().sendKeys(NewOfficeAddress);
		Thread.sleep(2000);
		booking.getNextbtn2().click();
		Thread.sleep(2000);
		booking.getNextbtn3().click();
		Thread.sleep(2000);
		//booking.getLoanamt().clear();
		for (int i = 1; i <= 20; i++) {
			booking.getLoanamt().sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		booking.getLoanamt().sendKeys(NewLoanamt);
		booking.getBranch().clear();
		booking.getBranch().sendKeys(newBranch);
		booking.getCity().clear();
		booking.getCity().sendKeys(NewCity);
		Thread.sleep(2000);
		booking.getUpdate().click();
	}

	//Edit Project Data
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] {
			{ "3", "The commonly accepted size for a 3 BHK flat can vary between 1,200 to 1,800 square feet.",
			  "Rushabh Shah","5200000","200000","SambhavNath","AFZPK7190R","2653 8564 4665","9696969696","kinjal.x@yopmail.com",
			  "Shaligram Corporates, 9th Floor, Behind Dishman Corporate House, Iscon - Ambli Rd, Ambli",
			  "B/h Dishman Corporate House,C.J Road, Ambli, Ahmedabad, Gujarat 380058","500","mumbai",
			  "Maharastra" }};
	}

	//Cancel Booking
	@Test(dataProvider = "getCancelBooking")
	public void Cancel_Booking(String Reason) throws InterruptedException {
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
	@Test(dataProvider = "getAllDocument")
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
	@Test(dataProvider = "getAllDocument")
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
	@Test(dataProvider = "getAllDocument")
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
	
	//Search Project
		@Test(dataProvider = "getSearchData")
		public void Search_Inquiry(String searchName) throws InterruptedException {
			BookingPage booking = new BookingPage(driver);
			booking.getBooking().click();
			booking.getBookingSearch().sendKeys(searchName);
			booking.getBookingSearchclick().click();
		}

	//DataProvider for Agreement Number 
	@DataProvider
	public Object[][] getAllDocument() {
		return new Object[][] { { "123456", "999999" } };
	}

	//DataProvider for Cancel Booking
	@DataProvider
	public Object[][] getCancelBooking() {
		return new Object[][] { { "Not intested now.", } };
	}

	//DataProvider for search data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] { { "Testing Only" } };
	}

	//Export to Excel Booking
	@Test()
	public void Export_to_Excel_Booking() throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getExporttoExcel().click();
	}

	//Apply Filter for Dates & Booking
	@Test(dataProvider = "getbookingfilterData")
	public void Apply_Filter_Booking(String bookedby1, String selectproject) throws InterruptedException {
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
		return new Object[][] { { "Testing Shah", " Testing Only " } };
	}

	//Add Booking Test Mandatory fields  Validation
	@Test(dataProvider = "getAddData2")
	public void Add_Booking_Test_Mandatory_Filed_Validation(String projectname, String unitblock, String flatshop,
			String bookedby, String BookingDate, String paymentplan1, String bookingstatus, String UnitBasicCost,
			String DevAndOtherCharges, String Name, String profession, String PAN, String AadharNo, String MobileNo,
			String Email, String PermanentAddress, String BrokerName, String BrokerageAmount , String BrokeringCompany , String BrokerMobileNo) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		SoftAssert softAssert = new SoftAssert();
		booking.getBooking().click();
		booking.AddBooking().click();
		booking.getNextbtn().click();

		WebElement ProjectName1 =driver.findElement(By.cssSelector("#mat-mdc-error-0"));
		String prname = ProjectName1.getText();
		softAssert.assertEquals(prname, "1Project Name is required");

		WebElement Unit1 =driver.findElement(By.cssSelector("#mat-mdc-error-1"));
		String unt = Unit1.getText();
		softAssert.assertEquals(unt, "1Unit/Block is required");

		WebElement selectflat1 =driver.findElement(By.cssSelector("#mat-mdc-error-2"));
		String flt = selectflat1.getText();
		softAssert.assertEquals(flt, "1Flat/Shop is required");

		WebElement Bookingdate2 = driver.findElement(By.xpath("//span[normalize-space()='Booking Date is required.']"));
		System.out.println(Bookingdate2.getText());
		softAssert.assertEquals(Bookingdate2.getText(), "1Booking Date is required.");

		WebElement BookingStatus2 = driver.findElement(By.xpath("//span[normalize-space()='Booking Status is required.']"));
		System.out.println(BookingStatus2.getText());
		softAssert.assertEquals(BookingStatus2.getText(), "1Booking Status is required.");

		booking.getProjectName(projectname);
		booking.getUnitBlock(unitblock);
		booking.getFlatShop(flatshop);
		booking.getBookedBy(bookedby);
		booking.BookingDate();
		booking.getPaymentPlan(paymentplan1);
		booking.BookingStatus(bookingstatus);
		Thread.sleep(2000);
		booking.getUnitBasicCost().sendKeys(UnitBasicCost);
		booking.getDevAndOtherCharges().sendKeys(DevAndOtherCharges);
		Thread.sleep(2000);
		booking.getNextbtn().click();
		Thread.sleep(2000);

		//Add Customer
		booking.getNextbtn2().click();
		Thread.sleep(2000);

		WebElement MainCustomerName =driver.findElement(By.xpath("//span[normalize-space()='Name is required.']"));
		System.out.println(MainCustomerName.getText());
		softAssert.assertEquals(MainCustomerName.getText(), "1Name is required.");

		WebElement Profession1 =driver.findElement(By.xpath("//span[normalize-space()='Profession is required.']"));
		System.out.println(Profession1.getText());
		softAssert.assertEquals(Profession1.getText(), "1Profession is required.");

		WebElement Birthdate1 =driver.findElement(By.xpath("//span[normalize-space()='Birth Date is required.']"));
		System.out.println(Birthdate1.getText());
		softAssert.assertEquals(Birthdate1.getText(), "1Birth Date is required.");

		WebElement PANNumber1 =driver.findElement(By.xpath("//span[normalize-space()='Pan Number is required.']"));
		System.out.println(PANNumber1.getText());
		softAssert.assertEquals(PANNumber1.getText(), "1Pan Number is required.");

		WebElement AdharNumber1 =driver.findElement(By.xpath("//span[normalize-space()='Aadhar Number is required.']"));
		System.out.println(AdharNumber1.getText());
		softAssert.assertEquals(AdharNumber1.getText(), "1Aadhar Number is required.");

		WebElement Mobile1 =driver.findElement(By.xpath("//span[normalize-space()='Mobile Number is required.']"));
		System.out.println(Mobile1.getText());
		softAssert.assertEquals(Mobile1.getText(), "1Mobile Number is required.");

		WebElement Email1 =driver.findElement(By.xpath("//span[normalize-space()='E-mail is required.']"));
		System.out.println(Email1.getText());
		softAssert.assertEquals(Email1.getText(), "1E-mail is required.");

		WebElement PermentAddress1 =driver.findElement(By.xpath("//span[normalize-space()='Address is required.']"));
		System.out.println(PermentAddress1.getText());
		softAssert.assertEquals(PermentAddress1.getText(), "1Address is required.");

		booking.getName().sendKeys(Name);
		Thread.sleep(2000);
		booking.Profession(profession);
		booking.Birthdate();
		booking.getPAN().sendKeys(PAN);
		booking.getAadharNo().sendKeys(AadharNo);
		booking.getMobileNo().sendKeys(MobileNo);
		booking.getEmail().sendKeys(Email);
		booking.getPermanentAddress().sendKeys(PermanentAddress);
		booking.getNextbtn2().click();
		Thread.sleep(2000);
		booking.getisBroker().click();
		Thread.sleep(2000);
		booking.getNextbtn3().click();
		Thread.sleep(2000);

		//Broker Details
		WebElement BrokerName1 =driver.findElement(By.xpath("//span[normalize-space()='Broker Name is required.']"));
		System.out.println(BrokerName1.getText());
		softAssert.assertEquals(BrokerName1.getText(), "1Broker Name is required.");

		WebElement BrokerageAmount1 =driver.findElement(By.xpath("//span[normalize-space()='Brokerage Amount is required.']"));
		System.out.println(BrokerageAmount1.getText());
		softAssert.assertEquals(BrokerageAmount1.getText(), "1Brokerage Amount is required.");

		WebElement BrokeringCompany1 =driver.findElement(By.xpath("//span[normalize-space()='Brokering company is required.']"));
		System.out.println(BrokeringCompany1.getText());
		softAssert.assertEquals(BrokeringCompany1.getText(), "1Brokering company is required.");

		WebElement BrokerMobileNo1 =driver.findElement(By.xpath("//span[normalize-space()='Broker Mobile No. is required.']"));
		System.out.println(BrokerMobileNo1.getText());
		softAssert.assertEquals(BrokerMobileNo1.getText(), "1Broker Mobile No. is required.");

		//WebElement addprofile1 =driver.findElement(By.xpath("//span[normalize-space()='Broker File is required.']"));
		//System.out.println(addprofile1.getText());
		//softAssert.assertEquals(addprofile1.getText(), "Broker File is required.");

		softAssert.assertAll();

		booking.getBrokerName().sendKeys(BrokerName);
		booking.getBrokerAmount().sendKeys(BrokerageAmount);
		booking.getBrokeringCompany().sendKeys(BrokeringCompany);
		booking.getBrokerMobileNo().sendKeys(BrokerMobileNo);
		booking.addprofile1();
		booking.getNextbtn3().click();
		Thread.sleep(2000);

	}

	//Add Booking Data Provider Test Mandatory fields.
	@DataProvider
	public Object[][] getAddData2() {
		return new Object[][] { { "Testing Only","A","Unit No - A  - 111 (1st Floor)", "Dhrujal Shah", " ",
			"Kinjal Payment Plan", "Booked", "6000000", "10000", "Mahavir Shah", "Software Engineer", "ABCTY1234D",
			"2653 8564 4663", "9898005625", "kinjal.s@shaligraminfotech.com",
			"Marigold Circle, Safal Parisar Rd, South Bopal, Bopal, Ahmedabad, Gujarat 380058", "Aarti Shah", "50000","Aarti & Company","9512365479" } };
	}

	//Edit Booking Test Mandatory Filed Validation 			
	@Test(dataProvider = "getEditData2")
	public void Edit_booking2(String UnitBasicCost, String Name, String PAN, String AadharNo, String MobileNo,
			String Email, String PermanentAddress, String BrokerName, String BrokerAmount, String BrokeringCompany,
			String BrokerMobileNo) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		SoftAssert softAssert = new SoftAssert();
		booking.getBooking().click();
		booking.getEdit().click();
		booking.getUnitBasicCost().click();

		//Booking Details
		//UnitBasicCost
		for (int i = 1; i <= 20; i++) {
			booking.getUnitBasicCost().sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		booking.getNextbtn().click();
		Thread.sleep(2000);
		WebElement UnicBasicCost1 = driver.findElement(By.xpath("//span[normalize-space()='Unit basic cost is required.']"));
		System.out.println(UnicBasicCost1.getText());
		softAssert.assertEquals(UnicBasicCost1.getText(), "Unit basic cost is required.");
		booking.getUnitBasicCost();
		Thread.sleep(6000);
		booking.getUnitBasicCost().sendKeys(UnitBasicCost);
		Thread.sleep(2000);
		
		//Next button(First)
		booking.getNextbtn().click();
		Thread.sleep(2000);


		//Add Customer
		//Name
		for (int i = 1; i <= 20; i++) {
			booking.getName().sendKeys(Keys.BACK_SPACE);
		}
		booking.getName().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		WebElement Name1 = driver.findElement(By.xpath("//span[normalize-space()='Name is required.']"));
		System.out.println(Name1.getText());
		softAssert.assertEquals(Name1.getText(), "Name is required.");
		booking.getName().sendKeys(Name);
		Thread.sleep(2000);
		
		//PAN No.
		for (int i = 1; i <= 20; i++) {
			booking.getPAN().sendKeys(Keys.BACK_SPACE);
		}
		booking.getPAN().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		WebElement PANNumber1 = driver.findElement(By.xpath("//span[normalize-space()='Pan Number is required.']"));
		System.out.println(PANNumber1.getText());
		softAssert.assertEquals(PANNumber1.getText(), "Pan Number is required.");
		booking.getPAN().sendKeys(PAN);
		Thread.sleep(2000);
		
		//AadharNo
		for (int i = 1; i <= 20; i++) {
			booking.getAadharNo().sendKeys(Keys.BACK_SPACE);
		}
		booking.getAadharNo().sendKeys(Keys.TAB);
		WebElement AdharNumber1 = driver.findElement(By.xpath("//span[normalize-space()='Aadhar Number is required.']"));
		System.out.println(AdharNumber1.getText());
		softAssert.assertEquals(AdharNumber1.getText(), "Aadhar Number is required.");
		booking.getAadharNo().sendKeys(AadharNo);
		Thread.sleep(2000);
		
		//MobileNo
		for (int i = 1; i <= 20; i++) {
			booking.getMobileNo().sendKeys(Keys.BACK_SPACE);
		}
		booking.getMobileNo().sendKeys(Keys.TAB);

		WebElement Mobile1 = driver.findElement(By.xpath("//span[normalize-space()='Mobile Number is required.']"));
		System.out.println(Mobile1.getText());
		softAssert.assertEquals(Mobile1.getText(), "Mobile Number is required.");
		booking.getMobileNo().sendKeys(MobileNo);
		Thread.sleep(2000);
		
		//Email Address
		for (int i = 1; i <= 20; i++) {
			booking.getEmail().sendKeys(Keys.BACK_SPACE);
		}
		booking.getEmail().sendKeys(Keys.TAB);
		WebElement Email1 = driver.findElement(By.xpath("//span[normalize-space()='E-mail is required.']"));
		System.out.println(Email1.getText());
		softAssert.assertEquals(Email1.getText(), "E-mail is required.");

		booking.getEmail().sendKeys(Email);
		Thread.sleep(2000);
		
		//PermanentAddress
		for (int i = 1; i <= 100; i++) {
			booking.getPermanentAddress().sendKeys(Keys.BACK_SPACE);
		}
		booking.getPermanentAddress().sendKeys(Keys.TAB);
		WebElement PermentAddress1 = driver.findElement(By.xpath("//span[normalize-space()='Address is required.']"));
		System.out.println(PermentAddress1.getText());
		softAssert.assertEquals(PermentAddress1.getText(), "Address is required.");
		booking.getPermanentAddress().sendKeys(PermanentAddress);
		Thread.sleep(2000);	
		
		//Next button(Second)
		booking.getNextbtn2().click();
		Thread.sleep(2000);
		
		//Broker Button
		booking.getisBroker().click();
		Thread.sleep(2000);
		
		//Broker Name
		for (int i = 1; i <= 20; i++) {
			booking.getBrokerName().sendKeys(Keys.BACK_SPACE);
		}
		booking.getBrokerName().sendKeys(Keys.TAB);
		WebElement BrokerName1 = driver.findElement(By.xpath("//span[normalize-space()='Broker Name is required.']"));
		System.out.println(BrokerName1.getText());
		softAssert.assertEquals(BrokerName1.getText(), "Broker Name is required.");
		booking.getBrokerName().sendKeys(BrokerName);
		
		//Brokerage Amount
		for (int i = 1; i <= 20; i++) {
			booking.getBrokerAmount().sendKeys(Keys.BACK_SPACE);

		}
		booking.getBrokerAmount().sendKeys(Keys.TAB);
		WebElement BrokerAmount1 = driver.findElement(By.xpath("//span[normalize-space()='Brokerage Amount is required.']"));
		System.out.println(BrokerAmount1.getText());
		softAssert.assertEquals(BrokerAmount1.getText(), "Brokerage Amount is required.");
		booking.getBrokerAmount().sendKeys(BrokerAmount);
		
		//Brokering Company
		for (int i = 1; i <= 20; i++) {
			booking.getBrokeringCompany().sendKeys(Keys.BACK_SPACE);
		}
		booking.getBrokeringCompany().sendKeys(Keys.TAB);
		WebElement BrokeringCompany1 = driver.findElement(By.xpath("//span[normalize-space()='Brokering company is required.']"));
		System.out.println(BrokeringCompany1.getText());
		softAssert.assertEquals(BrokeringCompany1.getText(), "Brokering company is required.");
		booking.getBrokeringCompany().sendKeys(BrokeringCompany);
		// Broker Mobile No
		for (int i = 1; i <= 20; i++) {
			booking.getBrokerMobileNo().sendKeys(Keys.BACK_SPACE);
		}
		booking.getBrokerMobileNo().sendKeys(Keys.TAB);
		WebElement BrokerMobileNo1 = driver.findElement(By.xpath("//span[normalize-space()='Broker Mobile No. is required.']"));
		System.out.println(BrokerMobileNo1.getText());
		softAssert.assertEquals(BrokerMobileNo1.getText(), "Broker Mobile No. is required.");
		booking.getBrokerMobileNo().sendKeys(BrokerMobileNo);
		//booking.addprofile1();
		//booking.getNextbtn3().click();
		//Thread.sleep(2000);
			
		//Broker File(s)
		//booking.getBrokerMobileNo().sendKeys(BrokerMobileNo);
		//booking.addprofile1();	
		softAssert.assertAll();
	}
	
	//Edit Mandatory field Project Data
	@DataProvider
	public Object[][] getEditData2() {
		return new Object[][] { { "7000000","Parshwa Shah","ABCTY1234E","2653 8564 4645","9523568922","kinjal123@yopmail.com",
			"Iskcon Cross Rd, Sanidhya, Ahmedabad, Gujarat 380015,","Dhrujal Shah","50000","Broker Company","7412589063" }};
	}
	
	//Active and Deactivate Booking
	@Test(dataProvider = "getAddData3")
	public void Deactivate_booking(String projectname) throws InterruptedException {
		ProjectPage project = new ProjectPage(driver);
		project.getproject().click();
		project.getActiveproject().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]")).click();
		Thread.sleep(2000);
		//Booking Show in dropdown
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		booking.getProjectName(projectname);
		project.getproject().click();
		Thread.sleep(2000);
		project.getActiveproject().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]")).click();
		Thread.sleep(2000);
		
		//Deactivate Project
		booking.getBooking().click();
		booking.AddBooking().click();
		booking.getProjectName(projectname);
		project.getproject().click();
		Thread.sleep(2000);
	}  
	
	//Add Booking Data Provider
	@DataProvider
	public Object[][] getAddData3() {
		return new Object[][] {{ "Kinjal Project Active"}};      		 

	}
}

