package tests;

import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.Bankspage;
import pageObjects.BookingPage;
import pageObjects.ProfessionPage;
import pageObjects.ProjectPage;
import resources.base;
import pageObjects.SelectfilterDatesPage;

public class BookingTest extends base {

	@Test(dataProvider = "getAddBooking", priority = 1)
	public void Add_Booking(
			// Booking Details
			String projectname, String unitblock, String flatshop, String bookedby, String BookingDate,
			String paymentplan1, String CarParking, String Notes, String bookingstatus, String Reference,
			String UnitBasicCost, String DevAndOtherCharges,
			// Add Customer
			String CustName, String profession, String Birthdate, String PAN, String AadharNo, String MobileNo,
			String OtherNo, String Email, String PermanentAddress, String OfficeAddress, String Remarks,
			String Anniversarydate, String Custfile,
			// Broker Details
			String BrokerName, String BrokerAmount, String BrokeringCompany, String BrokerMobileNo, String BrokerFiles,
			// Bank Loan Details
			String bankname, String Loanamt, String Branch, String loadnacno, String City)
			throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(2000);
		booking.AddBooking().click();
		Thread.sleep(2000);

		// Booking Details
		booking.getProjectName(projectname.trim());
		Thread.sleep(1000);
		booking.getUnitBlock(unitblock.trim());
		Thread.sleep(1000);
		booking.getFlatShop(flatshop.trim());
		Thread.sleep(1000);
		booking.getBookedBy(bookedby.trim());
		Thread.sleep(1000);
		booking.BookingDate();
		Thread.sleep(1000);
		booking.getPaymentPlan(paymentplan1.trim());
		Thread.sleep(1000);
		booking.getCarParking().sendKeys(CarParking);
		String valid_string1 = valid_number(CarParking, "Car Parking Number");
		String valid_CarParking = valid_string1;
		System.out.println(valid_CarParking);
		Thread.sleep(1000);
		booking.getNotes().sendKeys(Notes.trim());
		String valid_string2 = valid_alphanum(Notes, "Notes", 1000);
		String valid_Notes = valid_string2;
		System.out.println(valid_Notes);
		booking.BookingStatus(bookingstatus.trim());
		Thread.sleep(1000);
		booking.getReference().sendKeys(Reference.trim());
		String valid_string3 = validateText(Reference, "Reference", 5, 30);
		String valid_Reference = valid_string3;
		System.out.println(valid_Reference);
		// Valid Unit Basic Cost
		booking.getUnitBasicCost().sendKeys(UnitBasicCost.trim());
		String valid_string4 = valid_number(UnitBasicCost, "Unit Basic Cost Number");
		String valid_unitbasiccost = valid_string4;
		System.out.println(valid_unitbasiccost);
		Thread.sleep(1000);
		booking.getDevAndOtherCharges().sendKeys(DevAndOtherCharges.trim());
		String valid_string5 = valid_number(DevAndOtherCharges, "Dev And Other Charges Number");
		String valid_DevAndOtherCharges = valid_string5;
		System.out.println(valid_DevAndOtherCharges);
		Thread.sleep(5000);
		booking.getNextbtn().click();
		Thread.sleep(5000);

		// Add Customer
		booking.getName().sendKeys(CustName.trim());
		String valid_string6 = validateText(CustName, "Customer name", 5, 20);
		String valid_CustName = valid_string6;
		System.out.println(valid_CustName);
		Thread.sleep(1000);
		booking.getProfession(profession.trim());
		Thread.sleep(1000);
		booking.getBirthDate1().click();
		Thread.sleep(1000);
		booking.getSelectSingleDate(Birthdate);
		Thread.sleep(1000);
		booking.getPAN().sendKeys(PAN.trim());
		String valid_string7 = valid_pan(PAN, "Pan Number");
		String valid_PanNumber = valid_string7;
		System.out.println(valid_PanNumber);
		Thread.sleep(1000);
		booking.getAadharNo().sendKeys(AadharNo.trim());
		String valid_string8 = valid_aadhar(AadharNo, "Aadhar Number ");
		String valid_AadharNumber = valid_string8;
		System.out.println(valid_AadharNumber);
		Thread.sleep(1000);
		booking.getMobileNo().sendKeys(MobileNo.trim());
		String valid_string9 = valid_number(MobileNo, "Mobile Number");
		String valid_MobileNumber = valid_string9;
		System.out.println(valid_MobileNumber);
		Thread.sleep(1000);
		booking.getOtherNo().sendKeys(OtherNo.trim());
		String valid_string10 = valid_number(OtherNo, "Other Number");
		String valid_OtherNumber = valid_string10;
		System.out.println(valid_OtherNumber);
		Thread.sleep(1000);
		booking.getEmail().sendKeys(Email.trim());
		String valid_string11 = valid_EMail(Email, "Email ID");
		String valid_EmailAddress = valid_string11;
		System.out.println(valid_EmailAddress);
		Thread.sleep(1000);
		booking.getPermanentAddress().sendKeys(PermanentAddress.trim());
		String valid_string12 = valid_alphanum(PermanentAddress, "Permanent Address", 500);
		String valid_PermanentAddress = valid_string12;
		System.out.println(valid_PermanentAddress);
		Thread.sleep(1000);
		booking.getOfficeAddress().sendKeys(OfficeAddress.trim());
		String valid_string13 = valid_alphanum(OfficeAddress, "Office Address", 500);
		String valid_OfficeAddress = valid_string13;
		System.out.println(valid_OfficeAddress);
		Thread.sleep(1000);
		booking.getRemarks().sendKeys(Remarks.trim());
		String valid_string14 = valid_alphanum(Remarks, "Remarks", 1000);
		String valid_Remarks = valid_string14;
		System.out.println(valid_Remarks);
		Thread.sleep(1000);
		booking.getAnniversarydate1().click();
		Thread.sleep(1000);
		booking.getSelectSingleDate(Anniversarydate);
		Thread.sleep(1000);
		booking.getcustfile().sendKeys(Custfile);
		Thread.sleep(1000);
		booking.getNextbtn2().click();
		Thread.sleep(2000);

		// Broker Details
		booking.getisBroker().click();
		Thread.sleep(1000);
		booking.getBrokerName().sendKeys(BrokerName.trim());
		String valid_string15 = validateText(BrokerName, "Broker Name", 5, 50);
		String valid_BrokerName = valid_string15;
		System.out.println(valid_BrokerName);
		Thread.sleep(1000);
		booking.getBrokerAmount().sendKeys(BrokerAmount.trim());
		String valid_string16 = valid_number(BrokerAmount, "Broker Amount");
		String valid_BrokerAmount = valid_string16;
		System.out.println(valid_BrokerAmount);
		Thread.sleep(1000);
		booking.getBrokeringCompany().sendKeys(BrokeringCompany.trim());
		String valid_string17 = valid_alphanum(BrokeringCompany, "Brokering Company", 50);
		String valid_BrokeringCompany = valid_string17;
		System.out.println(valid_BrokeringCompany);
		Thread.sleep(1000);
		booking.getBrokerMobileNo().sendKeys(BrokerMobileNo.trim());
		String valid_string18 = valid_number(BrokerMobileNo, "Broker Mobile Number");
		String valid_BrokerMobileNo = valid_string18;
		System.out.println(valid_BrokerMobileNo);
		Thread.sleep(1000);
		booking.getbrokeruplaodfile().sendKeys(BrokerFiles);
		booking.getNextbtn3().click();
		Thread.sleep(2000);

		// Bank Loan Details
		booking.BankName(bankname.trim());
		Thread.sleep(1000);
		booking.getLoanamt().sendKeys(Loanamt.trim());
		String valid_string19 = valid_number(Loanamt, "Loan Amount");
		String valid_Loanamt = valid_string19;
		System.out.println(valid_Loanamt);
		booking.getBranch().sendKeys(Branch.trim());
		String valid_string20 = valid_alphanum(Branch, "Branch", 50);
		String valid_Branch = valid_string20;
		System.out.println(valid_Branch);
		booking.getloadnacno().sendKeys(loadnacno.trim());
		String valid_string21 = valid_number(loadnacno, "Loan Account Number");
		String valid_loadnacno = valid_string21;
		System.out.println(valid_loadnacno);
		booking.getCity().sendKeys(City.trim());
		String valid_string22 = validateText(City, "City", 5, 30);
		String valid_City = valid_string22;
		System.out.println(valid_City);
		Thread.sleep(5000);
		booking.getBookbtn();
		Thread.sleep(5000);

		softAssert.assertEquals(valid_CarParking, "Car Parking Number is a Valid Number");
		softAssert.assertEquals(valid_Notes, "Notes is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Reference,
				"Reference is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_unitbasiccost, "Unit Basic Cost Number is a Valid Number");
		softAssert.assertEquals(valid_DevAndOtherCharges, "Dev And Other Charges Number is a Valid Number");

		softAssert.assertEquals(valid_CustName,
				"Customer name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_PanNumber, "Pan Number is a Valid PAN");
		softAssert.assertEquals(valid_AadharNumber, "Aadhar Number  is a Valid Assdhar");
		softAssert.assertEquals(valid_MobileNumber, "Mobile Number is a Valid Number");
		softAssert.assertEquals(valid_OtherNumber, "Other Number is a Valid Number");
		softAssert.assertEquals(valid_EmailAddress, "Email ID is a Valid EMail");
		softAssert.assertEquals(valid_PermanentAddress,
				"Permanent Address is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_OfficeAddress,
				"Office Address is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Remarks, "Remarks is not a Valid Alpha-Numeric is a valid Maxlenght");

		softAssert.assertEquals(valid_BrokerName,
				"Broker Name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_BrokerAmount, "Broker Amount is a Valid Number");
		softAssert.assertEquals(valid_BrokeringCompany,
				"Brokering Company is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_BrokerMobileNo, "Broker Mobile Number is a Valid Number");

		softAssert.assertEquals(valid_Loanamt, "Loan Amount is a Valid Number");
		softAssert.assertEquals(valid_Branch, "Branch is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_loadnacno, "Loan Account Number is a Valid Number");
		softAssert.assertEquals(valid_City, "City is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertAll();
		Thread.sleep(5000);
	}

	// Edit Existing Project
	@Test(dataProvider = "getEditBooking", priority = 2)
	public void Edit_Booking(String searchName,
			// Booking Details
			String newunitblock, String newflatshop, String newbookedby, String newBookingDate, String newpaymentplan1,
			String newCarParking, String newNotes, String newReference, String newUnitBasicCost,
			String newDevAndOtherCharges,
			// Add Customer
			String newName, String newprofession, String newBirthdate, String newPAN, String newAadharNo,
			String newMobileNo, String newOtherNo, String newEmail, String newPermanentAddress, String newOfficeAddress,
			String newRemarks, String newAnniversarydate, String newCustfile,
			// Broker Details
			String newBrokerName, String newBrokerAmount, String newBrokeringCompany, String newBrokerMobileNo,
			String newBrokerFiles,
			// Bank Loan Details
			String newbankname, String newLoanamt, String newBranch, String newloadnacno, String newCity)
			throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(2000);
		booking.getBookingSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(2000);
		booking.getEdit().click();
		Thread.sleep(2000);
		booking.getUnitBlock(newunitblock.trim());
		Thread.sleep(2000);
		booking.getFlatShop(newflatshop.trim());
		Thread.sleep(2000);
		booking.getBookedBy(newbookedby.trim());
		Thread.sleep(1000);
		booking.getPaymentPlan(newpaymentplan1.trim());
		Thread.sleep(1000);
		booking.getCarParking().clear();
		booking.getCarParking().sendKeys(newCarParking.trim());
		String valid_string23 = valid_number(newCarParking, "Car Parking Number");
		String valid_newCarParking = valid_string23;
		System.out.println(valid_newCarParking);
		Thread.sleep(2000);
		booking.getNotes().clear();
		booking.getNotes().sendKeys(newNotes.trim());
		String valid_string24 = valid_alphanum(newNotes, "Notes", 1000);
		String valid_newNotes = valid_string24;
		System.out.println(valid_newNotes);
		Thread.sleep(1000);
		booking.getReference().clear();
		booking.getReference().sendKeys(newReference.trim());
		String valid_string25 = validateText(newReference, "Reference", 5, 30);
		String valid_newReference = valid_string25;
		System.out.println(valid_newReference);
		Thread.sleep(1000);
		booking.GetEditUnitBasicCost().click();
		int g = booking.GetEditUnitBasicCost().getAttribute("value").length();
		for (int i = 0; i < g; i++) {
			booking.GetEditUnitBasicCost().sendKeys(Keys.BACK_SPACE);
		}
		booking.getUnitBasicCost().sendKeys(newUnitBasicCost.trim());
		String valid_string26 = valid_number(newUnitBasicCost, "New Unit Basic Cost");
		String valid_newUnitBasicCost = valid_string26;
		System.out.println(valid_newUnitBasicCost);
		Thread.sleep(1000);
		booking.getDevAndOtherCharges().click();
		int h = booking.getDevAndOtherCharges().getAttribute("value").length();
		for (int i = 0; i < h; i++) {
			booking.getDevAndOtherCharges().sendKeys(Keys.BACK_SPACE);
		}
		booking.getDevAndOtherCharges().sendKeys(newDevAndOtherCharges.trim());
		String valid_string27 = valid_number(newDevAndOtherCharges, "New Dev And Other Charges");
		String valid_newDevAndOtherCharges = valid_string27;
		System.out.println(valid_newDevAndOtherCharges);
		Thread.sleep(2000);
		booking.GetNextbtnEditTime().click();
		Thread.sleep(2000);
		// Add Customer
		booking.getName().clear();
		booking.getName().sendKeys(newName.trim());
		String valid_string28 = validateText(newName, "New Name", 5, 100);
		String valid_newName = valid_string28;
		System.out.println(valid_newName);
		Thread.sleep(2000);
		booking.getProfession(newprofession.trim());
		Thread.sleep(1000);
		booking.getBirthDate1().click();
		Thread.sleep(1000);
		booking.getSelectSingleDate(newBirthdate);
		Thread.sleep(1000);
		booking.getPAN().clear();
		booking.getPAN().sendKeys(newPAN.trim());
		String valid_string29 = valid_pan(newPAN, "New PAN Number");
		String valid_newPAN = valid_string29;
		System.out.println(valid_newPAN);
		Thread.sleep(1000);
		booking.getAadharNo().clear();
		booking.getAadharNo().sendKeys(newAadharNo.trim());
		String valid_string30 = valid_aadhar(newAadharNo, "New Aadhar Number");
		String valid_newAadharNo = valid_string30;
		System.out.println(valid_newAadharNo);
		Thread.sleep(1000);
		booking.getMobileNo().clear();
		booking.getMobileNo().sendKeys(newMobileNo.trim());
		String valid_string31 = valid_number(newMobileNo, "New Mobile Number");
		String valid_newMobileNo = valid_string31;
		System.out.println(valid_newMobileNo);
		Thread.sleep(2000);
		booking.getOtherNo().clear();
		booking.getOtherNo().sendKeys(newOtherNo.trim());
		String valid_string32 = valid_number(newOtherNo, "New Other Number");
		String valid_newOtherNo = valid_string32;
		System.out.println(valid_newOtherNo);
		Thread.sleep(1000);
		booking.getEmail().clear();
		booking.getEmail().sendKeys(newEmail.trim());
		String valid_string33 = valid_EMail(newEmail, "New Email Address");
		String valid_newEmail = valid_string33;
		System.out.println(valid_newEmail);
		Thread.sleep(1000);
		booking.getPermanentAddress().clear();
		booking.getPermanentAddress().sendKeys(newPermanentAddress.trim());
		String valid_string34 = valid_alphanum(newPermanentAddress, "New Permanent Address", 1000);
		String valid_newPermanentAddress = valid_string34;
		System.out.println(valid_newPermanentAddress);
		Thread.sleep(1000);
		booking.getOfficeAddress().clear();
		booking.getOfficeAddress().sendKeys(newOfficeAddress.trim());
		String valid_string35 = valid_alphanum(newOfficeAddress, "New Office Address", 1000);
		String valid_newOfficeAddress = valid_string35;
		System.out.println(valid_newOfficeAddress);
		Thread.sleep(1000);
		booking.getRemarks().clear();
		booking.getRemarks().sendKeys(newRemarks.trim());
		String valid_string36 = validateText(newRemarks, "New Remarks", 5, 100);
		String valid_newRemarks = valid_string36;
		System.out.println(valid_newRemarks);
		Thread.sleep(2000);
		booking.getAnniversarydate1().click();
		Thread.sleep(1000);
		booking.getSelectSingleDate(newAnniversarydate);
		Thread.sleep(1000);
		booking.getcustfile().sendKeys(newCustfile);
		Thread.sleep(1000);
		booking.getNextbtn2().click();
		Thread.sleep(3000);
		// Broker Details
		int m = booking.getBrokerName().getAttribute("value").length();
		for (int i = 0; i < m; i++) {
			booking.getBrokerName().sendKeys(Keys.BACK_SPACE);
		}
		booking.getBrokerName().sendKeys(newBrokerName.trim());
		String valid_string37 = validateText(newBrokerName, "New Broker Name", 5, 20);
		String valid_newBrokerName = valid_string37;
		System.out.println(valid_newBrokerName);
		Thread.sleep(1000);
		int j = booking.getBrokerAmount().getAttribute("value").length();
		for (int i = 0; i < j; i++) {
			booking.getBrokerAmount().sendKeys(Keys.BACK_SPACE);
		}
		booking.getBrokerAmount().sendKeys(newBrokerAmount.trim());
		String valid_string38 = valid_number(newBrokerAmount, "New Broker Amount");
		String valid_newBrokerAmount = valid_string38;
		System.out.println(valid_newBrokerAmount);
		Thread.sleep(1000);
		int k = booking.getBrokeringCompany().getAttribute("value").length();
		for (int i = 0; i < k; i++) {
			booking.getBrokeringCompany().sendKeys(Keys.BACK_SPACE);
		}
		booking.getBrokeringCompany().sendKeys(newBrokeringCompany.trim());
		String valid_string39 = valid_alphanum(newBrokeringCompany, "Brokering Company", 50);
		String valid_newBrokeringCompany = valid_string39;
		System.out.println(valid_newBrokeringCompany);
		Thread.sleep(1000);
		int l = booking.getBrokerMobileNo().getAttribute("value").length();
		for (int i = 0; i < l; i++) {
			booking.getBrokerMobileNo().sendKeys(Keys.BACK_SPACE);
		}
		booking.getBrokerMobileNo().sendKeys(newBrokerMobileNo.trim());
		String valid_string40 = valid_number(newBrokerMobileNo, "new Broker Mobile Numbers");
		String valid_newBrokerMobileNo = valid_string40;
		System.out.println(valid_newBrokerMobileNo);
		Thread.sleep(1000);
		booking.getcustfile().sendKeys(newCustfile);
		Thread.sleep(1000);
		booking.getNextbtn3().click();
		Thread.sleep(2000);

		// Bank Loan Details
		booking.BankName(newbankname.trim());
		Thread.sleep(5000);
		int n = booking.getBranch().getAttribute("value").length();
		for (int i = 0; i < n; i++) {
			booking.getBranch().sendKeys(Keys.BACK_SPACE);
		}
		booking.getBranch().sendKeys(newBranch.trim());
		String valid_string41 = valid_alphanum(newBranch, "Branch", 50);
		String valid_newBranch = valid_string41;
		System.out.println(valid_newBranch);
		int o = booking.getLoanamt().getAttribute("value").length();
		for (int i = 0; i < o; i++) {
			booking.getLoanamt().sendKeys(Keys.BACK_SPACE);
		}
		booking.getLoanamt().sendKeys(newLoanamt.trim());
		String valid_string42 = valid_number(newLoanamt, "New Loan amountt");
		String valid_newLoanamt = valid_string42;
		System.out.println(valid_newLoanamt);
		Thread.sleep(500);
		int p = booking.getloadnacno().getAttribute("value").length();
		for (int i = 0; i < p; i++) {
			booking.getloadnacno().sendKeys(Keys.BACK_SPACE);
		}
		booking.getloadnacno().sendKeys(newloadnacno.trim());
		String valid_string43 = valid_number(newloadnacno, "New load nacno");
		String valid_newloadnacno = valid_string43;
		System.out.println(valid_newloadnacno);
		Thread.sleep(500);
		int q = booking.getCity().getAttribute("value").length();
		for (int i = 0; i < q; i++) {
			booking.getCity().sendKeys(Keys.BACK_SPACE);
		}
		booking.getCity().sendKeys(newCity.trim());
		String valid_string44 = validateText(newCity, "New City", 5, 100);
		String valid_newCity = valid_string44;
		System.out.println(valid_newCity);
		Thread.sleep(2000);
		booking.getUpdate().click();
		Thread.sleep(5000);

		softAssert.assertEquals(valid_newCarParking, "Car Parking Number is a Valid Number");
		softAssert.assertEquals(valid_newNotes, "Notes is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_newReference,
				"Reference is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_newUnitBasicCost, "New Unit Basic Cost is a Valid Number");
		softAssert.assertEquals(valid_newDevAndOtherCharges, "New Dev And Other Charges is a Valid Number");

		softAssert.assertEquals(valid_newName,
				"New Name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_newPAN, "New PAN Number is a Valid PAN");
		softAssert.assertEquals(valid_newAadharNo, "New Aadhar Number is a Valid Assdhar");
		softAssert.assertEquals(valid_newMobileNo, "New Mobile Number is a Valid Number");
		softAssert.assertEquals(valid_newOtherNo, "New Other Number is a Valid Number");
		softAssert.assertEquals(valid_newEmail, "New Email Address is a Valid EMail");
		softAssert.assertEquals(valid_newPermanentAddress,
				"New Permanent Address is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_newOfficeAddress,
				"New Office Address is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_newRemarks,
				"New Remarks is a Valid text - is a valid Minlenght - is a valid Maxlenght");

		softAssert.assertEquals(valid_newBrokerName,
				"New Broker Name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_newBrokerAmount, "New Broker Amount is a Valid Number");
		softAssert.assertEquals(valid_newBrokeringCompany,
				"Brokering Company is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_newBrokerMobileNo, "new Broker Mobile Numbers is a Valid Number");

		softAssert.assertEquals(valid_newLoanamt, "New Loan amountt is a Valid Number");
		softAssert.assertEquals(valid_newBranch, "Branch is not a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_newloadnacno, "New load nacno is a Valid Number");
		softAssert.assertEquals(valid_newCity,
				"New City is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertAll();
	}

	// Search Project Name, Flat/Shop(s), Customer and etc...
	@Test(dataProvider = "getSearchData", priority = 3)
	public void Search_Booking(String searchName) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getBookingSearch().sendKeys(searchName);
		booking.getBookingSearchclick().click();
		boolean flag = booking.NoPageFound();
		if (flag == false) {
		}
		Thread.sleep(5000);
	}

	// Export to Excel Booking
	@Test(priority = 4)
	public void Export_to_Excel_Booking() throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getExporttoExcel().click();
		Thread.sleep(5000);
	}

	// All Document Option menu
	// Add Documentation Details
	@Test(dataProvider = "getDocumentationDetailsForm", priority = 5)
	public void Documentation_Details(String searchName, String AgreementNumber, String AgreementDate,
			String SaleDeedNumber, String SaleDeedDate) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getBookingSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1500);
		booking.getBookingOption().click();
		Thread.sleep(1500);
		booking.getDocumentationDetails().click();
		Thread.sleep(1500);
		booking.getAgreementNumber().clear();
		booking.getAgreementNumber().sendKeys(AgreementNumber);
		booking.getAgreementDate().click();
		Thread.sleep(1000);
		booking.getSelectAgreementAndSaleDeedDate(AgreementDate);
		Thread.sleep(1000);
		booking.getSaleDeed().clear();
		booking.getSaleDeed().sendKeys(SaleDeedNumber);
		booking.getSaleDeedDate().click();
		Thread.sleep(2000);
		booking.getSelectAgreementAndSaleDeedDate(SaleDeedDate);
		Thread.sleep(2000);
		booking.getSavebutton().click();
		Thread.sleep(1000);
	}

	// Agreement Form
	@Test(dataProvider = "getAgreementForm", priority = 6)
	public void Agreement_Form(String searchName) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getBookingSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1000);
		booking.getBookingOption().click();
		Thread.sleep(1000);
		booking.getAgreementForm().click();
		Thread.sleep(1000);
	}

	// Booking Form
	@Test(dataProvider = "getBookingForm", priority = 7)
	public void Booking_Form(String searchName) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getBookingSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1000);
		booking.getBookingOption().click();
		Thread.sleep(1000);
		booking.getBookingForm().click();
		Thread.sleep(1000);
	}

	// Inquiry Form
	@Test(dataProvider = "getInquiryForm", priority = 8)
	public void Inquiry_Form(String searchName) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getBookingSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1000);
		booking.getBookingOption().click();
		booking.getInquiryForm().click();
		Thread.sleep(1000);
	}

	// **************** Apply Filters *******************
	// Apply Filter for Booking Date
	@Test(dataProvider = "getBookingDateFilter", priority = 9)
	public void ApplyFilter_Booking_Date(String Satrtdate, String Enddate) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		SelectfilterDatesPage BookigDate = new SelectfilterDatesPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getdaterange().click();
		Thread.sleep(1000);
		BookigDate.getSelectDateRange(Satrtdate, Enddate);
		Thread.sleep(1000);
		boolean flag = booking.NoPageFound();
		if (flag == false) {
		}
		booking.getresetfilter().click();
		Thread.sleep(1000);
	}

	// Apply Filter for Booked By
	@Test(dataProvider = "getBookedbyFilter", priority = 10)
	public void ApplyFilter_Booked_By(String bookedby) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(2000);
		booking.getBookedBy1(bookedby.trim());
		Thread.sleep(1000);
		boolean flag = booking.NoPageFound();
		if (flag == false) {
		}
		booking.getresetfilter().click();
		Thread.sleep(1000);
	}

	// Apply Filter for Project
	@Test(dataProvider = "getProjectFilter", priority = 11)
	public void ApplyFilter_Project(String selectproject) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getselectproject(selectproject.trim());
		Thread.sleep(1000);
		boolean flag = booking.NoPageFound();
		if (flag == false) {
		}
		booking.getresetfilter().click();
		Thread.sleep(1000);
	}

	// Apply Filter for Status
	@Test(dataProvider = "getBookingStatusFilter", priority = 12)
	public void ApplyFilter_Booking_Status(String selectstatus) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(2000);
		booking.getSelectBookingStatus(selectstatus.trim());
		Thread.sleep(1000);
		boolean flag = booking.NoPageFound();
		if (flag == false) {
		}
		booking.getresetfilter().click();
		Thread.sleep(1000);
	}

	// Apply Filter for Dates With All
	@Test(dataProvider = "getBookingfilterWithAllData", priority = 13)
	public void ApplyFilter_BookingWithAll(String Satrtdate, String Enddate, String bookedby, String selectproject,
			String selectstatus) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		SelectfilterDatesPage BookigDate = new SelectfilterDatesPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getdaterange().click();
		BookigDate.getSelectDateRange(Satrtdate, Enddate);
		Thread.sleep(1000);
		booking.getBookedBy1(bookedby.trim());
		Thread.sleep(1000);
		booking.getselectproject(selectproject.trim());
		Thread.sleep(1000);
		booking.getSelectBookingStatus(selectstatus.trim());
		Thread.sleep(1000);
		boolean flag = booking.NoPageFound();
		if (flag == false) {
		}
		booking.getresetfilter().click();
		Thread.sleep(1000);
	}

	// Rest All Filters
	@Test(dataProvider = "getRestAllFilters", priority = 14)
	public void ResetAllFiltes(String xyz, String bookedby) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getBookedBy1(bookedby.trim());
		Thread.sleep(1000);
		boolean flag = booking.NoPageFound();
		if (flag == false) {
		}
		booking.getresetfilter().click();
		Thread.sleep(1000);
	}

	// Add Booking Test Mandatory Field Validation
	@Test(priority = 15)
	public void Add_Booking_Test_Mandatory_Field_Validation() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.AddBooking().click();
		Thread.sleep(2000);
		booking.getNextbtn().click();
		Thread.sleep(2000);
		WebElement ProjectName = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[1]/vex-searchable-dropdown/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(ProjectName.getText().trim(), "Project Name is required.");
		WebElement UnitBlok = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[2]/vex-searchable-dropdown/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(UnitBlok.getText().trim(), "Unit/Block is required.");
		WebElement SelectFlat = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[3]/div/vex-searchable-dropdown/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(SelectFlat.getText().trim(), "Flat/Shop is required.");
		WebElement BookingDate = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[5]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(BookingDate.getText().trim(), "Booking Date is required.");
		WebElement BookingStatus = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[13]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(BookingStatus.getText().trim(), "Booking Status is required.");
		softAssert.assertAll();
		Thread.sleep(5000);
	}

	// Edit Booking Test Mandatory Field Validation
	@Test(dataProvider = "EditBooking", priority = 16)
	public void Edit_Booking_Test_Mandatory_Field_Validation(String searchName) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		Thread.sleep(1000);
		booking.getBookingSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(1000);
		booking.getEdit().click();
		Thread.sleep(1000);
		booking.GetNextbtnEditTime().click();
		Thread.sleep(1000);
		booking.GetNextbtnEditTime1().click();
		Thread.sleep(1000);
		WebElement brokerCheckbox = booking.GetEditIsBroker();
		String checkboxClass = brokerCheckbox.getAttribute("class");
		// Check selected state
		if ((checkboxClass.contains("mat-checkbox-checked")
				|| brokerCheckbox.findElement(By.tagName("input")).isSelected())
				&& checkboxClass.contains("mat-checkbox-disabled")
				|| !brokerCheckbox.findElement(By.tagName("input")).isEnabled()) {
			System.out.println("Broker option is selected.");
			System.out.println("Broker option is disabled.");

			booking.GetEditBrokerName().click();
			booking.GetEditBrokerName().sendKeys(Keys.END);
			int a = booking.GetEditBrokerName().getAttribute("value").length();
			for (int i = 0; i < a; i++) {
				booking.GetEditBrokerName().sendKeys(Keys.BACK_SPACE);
			}
			booking.GetEditBrokerageAmount().click();
			booking.GetEditBrokerageAmount().sendKeys(Keys.END);
			int b = booking.GetEditBrokerageAmount().getAttribute("value").length();
			for (int i = 0; i < b; i++) {
				booking.GetEditBrokerageAmount().sendKeys(Keys.BACK_SPACE);
			}
			booking.GetEditBrokeringCompany().click();
			booking.GetEditBrokeringCompany().sendKeys(Keys.END);
			int c = booking.GetEditBrokeringCompany().getAttribute("value").length();
			for (int i = 0; i < c; i++) {
				booking.GetEditBrokeringCompany().sendKeys(Keys.BACK_SPACE);
			}
			booking.GetEditBrokerMobileNo().click();
			booking.GetEditBrokerMobileNo().sendKeys(Keys.END);
			int d = booking.GetEditBrokerMobileNo().getAttribute("value").length();
			for (int i = 0; i < d; i++) {
				booking.GetEditBrokerMobileNo().sendKeys(Keys.BACK_SPACE);
			}
			booking.GetEditBrokerMobileNo().sendKeys(Keys.TAB);
			Thread.sleep(2000);
			WebElement BrokerName = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[1]/mat-form-field/div[2]/div/mat-error/span"));
			softAssert.assertEquals(BrokerName.getText().trim(), "Broker Name is required.");

			WebElement BrokerageAmount = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[2]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(BrokerageAmount.getText().trim(), " Brokerage Amount is required.");

			WebElement Brokeringcompany = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[3]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(Brokeringcompany.getText().trim(), " Brokering company is required.");

			WebElement BrokerMobileNo = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[4]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(BrokerMobileNo.getText().trim(), " Broker Mobile No. is required. ");
			booking.GetPreviousButton1().click();

		} else {
			System.out.println("Broker option is not selected.");
			System.out.println("Broker option is enabled.");
			brokerCheckbox.click();
			booking.GetNextbtnEditTime2().click();
			Thread.sleep(500);
			WebElement BrokerName = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[1]/mat-form-field/div[2]/div/mat-error/span"));
			softAssert.assertEquals(BrokerName.getText().trim(), "Broker Name is required.");

			WebElement BrokerageAmount = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[2]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(BrokerageAmount.getText().trim(), " Brokerage Amount is required.");

			WebElement Brokeringcompany = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[3]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(Brokeringcompany.getText().trim(), " Brokering company is required.");

			WebElement BrokerMobileNo = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[4]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(BrokerMobileNo.getText().trim(), "Broker Mobile No. is required.");

			WebElement BrokerFile = driver.findElement(By.xpath(
					"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[5]/mat-form-field/div[2]/div/mat-error"));
			softAssert.assertEquals(BrokerFile.getText().trim(), "Broker File is required.");
			booking.GetPreviousButton2().click();
			Thread.sleep(500);
		}
		booking.GetEditCustName().click();
		booking.GetEditCustName().sendKeys(Keys.END);
		int a = booking.GetEditCustName().getAttribute("value").length();
		for (int i = 0; i < a; i++) {
			booking.GetEditCustName().sendKeys(Keys.BACK_SPACE);
		}
		booking.GetEditBirthDate().click();
		booking.GetEditBirthDate().sendKeys(Keys.END);
		int b = booking.GetEditBirthDate().getAttribute("value").length();
		for (int i = 0; i < b; i++) {
			booking.GetEditBirthDate().sendKeys(Keys.BACK_SPACE);
		}
		booking.GetEditPANNumber().click();
		booking.GetEditPANNumber().sendKeys(Keys.END);
		int c = booking.GetEditPANNumber().getAttribute("value").length();
		for (int i = 0; i < c; i++) {
			booking.GetEditPANNumber().sendKeys(Keys.BACK_SPACE);
		}
		booking.GetEditAadharNumber().click();
		booking.GetEditAadharNumber().sendKeys(Keys.END);
		int d = booking.GetEditAadharNumber().getAttribute("value").length();
		for (int i = 0; i < d; i++) {
			booking.GetEditAadharNumber().sendKeys(Keys.BACK_SPACE);
		}
		booking.GetEditMobileNumber().click();
		booking.GetEditMobileNumber().sendKeys(Keys.END);
		int e = booking.GetEditMobileNumber().getAttribute("value").length();
		for (int i = 0; i < e; i++) {
			booking.GetEditMobileNumber().sendKeys(Keys.BACK_SPACE);
		}
		booking.GetEditEmail().click();
		booking.GetEditEmail().sendKeys(Keys.END);
		int f = booking.GetEditEmail().getAttribute("value").length();
		for (int i = 0; i < f; i++) {
			booking.GetEditEmail().sendKeys(Keys.BACK_SPACE);
		}
		booking.GetEditPermanentAddress().click();
		booking.GetEditPermanentAddress().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		booking.GetEditPermanentAddress().sendKeys(Keys.BACK_SPACE);
		booking.GetEditPermanentAddress().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		WebElement CustName = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[1]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(CustName.getText().trim(), "Name is required.");

		WebElement BirthDate = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[3]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(BirthDate.getText().trim(), "Birth Date is required.");

		WebElement PANNumber = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[5]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(PANNumber.getText().trim(), "Pan Number is required.");

		WebElement AadharNumber = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[6]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(AadharNumber.getText().trim(), "Aadhar Number is required.");

		WebElement MobileNum = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[8]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(MobileNum.getText().trim(), "Mobile Number is required.");

		WebElement Email = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[10]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(Email.getText(), "Email is required.");

		WebElement PermanentAddress = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[11]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(PermanentAddress.getText().trim(), "Address is required.");
		booking.GetPreviousButton2().click();

		booking.GetEditUnitBasicCost().click();
		booking.GetEditUnitBasicCost().sendKeys(Keys.END);
		int aa = booking.GetEditUnitBasicCost().getAttribute("value").length();
		for (int i = 0; i < aa; i++) {
			booking.GetEditUnitBasicCost().sendKeys(Keys.BACK_SPACE);
		}
		WebElement UnitBasicCost = driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[15]/mat-form-field/div[2]/div/mat-error"));
		softAssert.assertEquals(UnitBasicCost.getText(), "Unit basic cost is required.");
		Thread.sleep(5000);
	}

	// Verify Add InActive Project
	@Test(dataProvider = "AddInActiveProject", priority = 17)
	public void Verify_Add_InActive_Project(String searchProjectName, String ProjectName) throws InterruptedException {

		ProjectPage Project = new ProjectPage(driver);
		Project.getproject().click();
		Thread.sleep(1000);
		Project.getSearch().sendKeys(searchProjectName + Keys.ENTER);
		Thread.sleep(1000);
		Project.getActiveproject().click();
		Thread.sleep(1000);
		Project.getClickYes().click();
		Thread.sleep(1000);
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		Thread.sleep(1000);
		booking.AddInActiveProject(ProjectName);
		Thread.sleep(2000);
	}

	// Verify Add Active Project
	@Test(dataProvider = "AddActiveProject", priority = 18)
	public void Verify_Add_Active_Project(String searchProjectName, String ProjectName) throws InterruptedException {

		ProjectPage Project = new ProjectPage(driver);
		Project.getproject().click();
		Thread.sleep(1000);
		Project.getSearch().sendKeys(searchProjectName + Keys.ENTER);
		Thread.sleep(1000);
		Project.getActiveproject().click();
		Thread.sleep(1000);
		Project.getClickYes().click();
		Thread.sleep(1000);
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		Thread.sleep(1000);
		booking.AddActiveProject(ProjectName);
		Thread.sleep(1000);
	}

	// Verify Add InActive Profession
	@Test(dataProvider = "AddInActiveProfession", priority = 19)
	public void Verify_Add_InActive_Profession(String searchProfessionName, String projectname, String unitblock,
			String flatshop, String bookedby, String BookingDate, String paymentplan1, String CarParking, String Notes,
			String bookingstatus, String Reference, String UnitBasicCost, String DevAndOtherCharges,
			// Add Customer
			String CustName, String ProfessionName) throws InterruptedException, IOException {

		SoftAssert softAssert = new SoftAssert();
		ProfessionPage Profession = new ProfessionPage(driver);
		Profession.getconfiguration().click();
		Profession.getProfession().click();
		Profession.getSearch().sendKeys(searchProfessionName + Keys.ENTER);
		Thread.sleep(2000);
		Profession.getChangeStatus().click();
		Thread.sleep(1000);
		Profession.getYesButton().click();
		Thread.sleep(1000);
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		Thread.sleep(2000);

		// Booking Details
		booking.getProjectName(projectname.trim());
		Thread.sleep(1000);
		booking.getUnitBlock(unitblock.trim());
		Thread.sleep(1000);
		booking.getFlatShop(flatshop.trim());
		Thread.sleep(1000);
		booking.getBookedBy(bookedby.trim());
		Thread.sleep(1000);
		booking.BookingDate();
		Thread.sleep(1000);
		booking.getPaymentPlan(paymentplan1.trim());
		Thread.sleep(1000);
		booking.getCarParking().sendKeys(CarParking);
		String valid_string1 = valid_number(CarParking, "Car Parking Number");
		String valid_CarParking = valid_string1;
		System.out.println(valid_CarParking);
		Thread.sleep(1000);
		booking.getNotes().sendKeys(Notes.trim());
		String valid_string2 = valid_alphanum(Notes, "Notes", 1000);
		String valid_Notes = valid_string2;
		System.out.println(valid_Notes);
		booking.BookingStatus(bookingstatus.trim());
		Thread.sleep(1000);
		booking.getReference().sendKeys(Reference.trim());
		String valid_string3 = validateText(Reference, "Reference", 5, 30);
		String valid_Reference = valid_string3;
		System.out.println(valid_Reference);
		// Valid Unit Basic Cost
		booking.getUnitBasicCost().sendKeys(UnitBasicCost.trim());
		String valid_string4 = valid_number(UnitBasicCost, "Unit Basic Cost Number");
		String valid_unitbasiccost = valid_string4;
		System.out.println(valid_unitbasiccost);
		Thread.sleep(1000);
		booking.getDevAndOtherCharges().sendKeys(DevAndOtherCharges.trim());
		String valid_string5 = valid_number(DevAndOtherCharges, "Dev And Other Charges Number");
		String valid_DevAndOtherCharges = valid_string5;
		System.out.println(valid_DevAndOtherCharges);
		Thread.sleep(1000);
		booking.getNextbtn().click();
		Thread.sleep(2000);

		// Add Customer
		booking.getName().sendKeys(CustName.trim());
		String valid_string6 = validateText(CustName, "Customer name", 5, 20);
		String valid_CustName = valid_string6;
		System.out.println(valid_CustName);
		Thread.sleep(1000);
		booking.EditInActiveProfession(ProfessionName + Keys.TAB);
		Thread.sleep(1000);

		softAssert.assertEquals(valid_Reference,
				"Reference is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_CustName,
				"Customer name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
	}

	// Verify Add Active Profession
	@Test(dataProvider = "AddActiveProfession", priority = 20)
	public void Verify_Add_Active_Profession(String searchProfessionName, String projectname, String unitblock,
			String flatshop, String bookedby, String BookingDate, String paymentplan1, String CarParking, String Notes,
			String bookingstatus, String Reference, String UnitBasicCost, String DevAndOtherCharges,
			// Add Customer
			String CustName, String ProfessionName) throws InterruptedException, IOException {

		SoftAssert softAssert = new SoftAssert();
		ProfessionPage Profession = new ProfessionPage(driver);
		Profession.getconfiguration().click();
		Profession.getProfession().click();
		Profession.getSearch().sendKeys(searchProfessionName + Keys.ENTER);
		Thread.sleep(2000);
		Profession.getChangeStatus().click();
		Thread.sleep(2000);
		Profession.getYesButton().click();
		Thread.sleep(1000);
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		Thread.sleep(2000);

		// Booking Details
		booking.getProjectName(projectname.trim());
		Thread.sleep(1000);
		booking.getUnitBlock(unitblock.trim());
		Thread.sleep(1000);
		booking.getFlatShop(flatshop.trim());
		Thread.sleep(1000);
		booking.getBookedBy(bookedby.trim());
		Thread.sleep(1000);
		booking.BookingDate();
		Thread.sleep(1000);
		booking.getPaymentPlan(paymentplan1.trim());
		Thread.sleep(1000);
		booking.getCarParking().sendKeys(CarParking);
		String valid_string1 = valid_number(CarParking, "Car Parking Number");
		String valid_CarParking = valid_string1;
		System.out.println(valid_CarParking);
		Thread.sleep(1000);
		booking.getNotes().sendKeys(Notes.trim());
		String valid_string2 = valid_alphanum(Notes, "Notes", 1000);
		String valid_Notes = valid_string2;
		System.out.println(valid_Notes);
		booking.BookingStatus(bookingstatus.trim());
		Thread.sleep(1000);
		booking.getReference().sendKeys(Reference.trim());
		String valid_string3 = validateText(Reference, "Reference", 5, 30);
		String valid_Reference = valid_string3;
		System.out.println(valid_Reference);
		// Valid Unit Basic Cost
		booking.getUnitBasicCost().sendKeys(UnitBasicCost.trim());
		String valid_string4 = valid_number(UnitBasicCost, "Unit Basic Cost Number");
		String valid_unitbasiccost = valid_string4;
		System.out.println(valid_unitbasiccost);
		Thread.sleep(1000);
		booking.getDevAndOtherCharges().sendKeys(DevAndOtherCharges.trim());
		String valid_string5 = valid_number(DevAndOtherCharges, "Dev And Other Charges Number");
		String valid_DevAndOtherCharges = valid_string5;
		System.out.println(valid_DevAndOtherCharges);
		Thread.sleep(1000);
		booking.getNextbtn().click();
		Thread.sleep(2000);

		// Add Customer
		booking.getName().sendKeys(CustName.trim());
		String valid_string6 = validateText(CustName, "Customer name", 5, 20);
		String valid_CustName = valid_string6;
		System.out.println(valid_CustName);
		Thread.sleep(1000);
		booking.EditInActiveProfession(ProfessionName + Keys.TAB);
		Thread.sleep(1000);

		softAssert.assertEquals(valid_Reference,
				"Reference is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_CustName,
				"Customer name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
	}

	// Verify Add InActive Bank
	@Test(dataProvider = "AddInActiveBank", priority = 21)
	public void Verify_Add_InActive_Bank(String searchBankName, String projectname, String unitblock, String flatshop,
			String bookedby, String BookingDate, String paymentplan1, String CarParking, String Notes,
			String bookingstatus, String Reference, String UnitBasicCost, String DevAndOtherCharges,
			// Add Customer
			String CustName, String profession, String Birthdate, String PAN, String AadharNo, String MobileNo,
			String OtherNo, String Email, String PermanentAddress, String OfficeAddress, String Remarks,
			String Anniversarydate, String Custfile,
			// Broker Details
			String BrokerName, String BrokerAmount, String BrokeringCompany, String BrokerMobileNo, String BrokerFiles,
			// Bank Loan Details
			String BankName) throws InterruptedException, IOException {

		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Thread.sleep(1000);
		Bank.getBankssearched().sendKeys(searchBankName + Keys.ENTER);
		Thread.sleep(1000);
		Bank.getbanksstatus().click();
		Thread.sleep(1000);
		Bank.getbanksstatusconfirmation().click();
		Thread.sleep(1000);

		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		Thread.sleep(2000);

		// Booking Details
		booking.getProjectName(projectname.trim());
		Thread.sleep(1000);
		booking.getUnitBlock(unitblock.trim());
		Thread.sleep(1000);
		booking.getFlatShop(flatshop.trim());
		Thread.sleep(1000);
		booking.getBookedBy(bookedby.trim());
		Thread.sleep(1000);
		booking.BookingDate();
		Thread.sleep(1000);
		booking.getPaymentPlan(paymentplan1.trim());
		Thread.sleep(1000);
		booking.getCarParking().sendKeys(CarParking);
		String valid_string1 = valid_number(CarParking, "Car Parking Number");
		String valid_CarParking = valid_string1;
		System.out.println(valid_CarParking);
		Thread.sleep(1000);
		booking.getNotes().sendKeys(Notes.trim());
		String valid_string2 = valid_alphanum(Notes, "Notes", 1000);
		String valid_Notes = valid_string2;
		System.out.println(valid_Notes);
		booking.BookingStatus(bookingstatus.trim());
		Thread.sleep(1000);
		booking.getReference().sendKeys(Reference.trim());
		String valid_string3 = validateText(Reference, "Reference", 5, 30);
		String valid_Reference = valid_string3;
		System.out.println(valid_Reference);
		// Valid Unit Basic Cost
		booking.getUnitBasicCost().sendKeys(UnitBasicCost.trim());
		String valid_string4 = valid_number(UnitBasicCost, "Unit Basic Cost Number");
		String valid_unitbasiccost = valid_string4;
		System.out.println(valid_unitbasiccost);
		Thread.sleep(1000);
		booking.getDevAndOtherCharges().sendKeys(DevAndOtherCharges.trim());
		String valid_string5 = valid_number(DevAndOtherCharges, "Dev And Other Charges Number");
		String valid_DevAndOtherCharges = valid_string5;
		System.out.println(valid_DevAndOtherCharges);
		Thread.sleep(1000);
		booking.getNextbtn().click();
		Thread.sleep(2000);

		// Add Customer
		booking.getName().sendKeys(CustName.trim());
		String valid_string6 = validateText(CustName, "Customer name", 5, 20);
		String valid_CustName = valid_string6;
		System.out.println(valid_CustName);
		Thread.sleep(1000);
		booking.getProfession(profession.trim());
		Thread.sleep(1000);
		booking.getBirthDate1().click();
		Thread.sleep(1000);
		booking.getSelectSingleDate(Birthdate);
		Thread.sleep(1000);
		booking.getPAN().sendKeys(PAN.trim());
		String valid_string7 = valid_pan(PAN, "Pan Number");
		String valid_PanNumber = valid_string7;
		System.out.println(valid_PanNumber);
		Thread.sleep(1000);
		booking.getAadharNo().sendKeys(AadharNo.trim());
		String valid_string8 = valid_aadhar(AadharNo, "Aadhar Number ");
		String valid_AadharNumber = valid_string8;
		System.out.println(valid_AadharNumber);
		Thread.sleep(1000);
		booking.getMobileNo().sendKeys(MobileNo.trim());
		String valid_string9 = valid_number(MobileNo, "Mobile Number");
		String valid_MobileNumber = valid_string9;
		System.out.println(valid_MobileNumber);
		Thread.sleep(1000);
		booking.getOtherNo().sendKeys(OtherNo.trim());
		String valid_string10 = valid_number(OtherNo, "Other Number");
		String valid_OtherNumber = valid_string10;
		System.out.println(valid_OtherNumber);
		Thread.sleep(1000);
		booking.getEmail().sendKeys(Email.trim());
		String valid_string11 = valid_EMail(Email, "Email ID");
		String valid_EmailAddress = valid_string11;
		System.out.println(valid_EmailAddress);
		Thread.sleep(1000);
		booking.getPermanentAddress().sendKeys(PermanentAddress.trim());
		String valid_string12 = valid_alphanum(PermanentAddress, "Permanent Address", 500);
		String valid_PermanentAddress = valid_string12;
		System.out.println(valid_PermanentAddress);
		Thread.sleep(1000);
		booking.getOfficeAddress().sendKeys(OfficeAddress.trim());
		String valid_string13 = valid_alphanum(OfficeAddress, "Office Address", 500);
		String valid_OfficeAddress = valid_string13;
		System.out.println(valid_OfficeAddress);
		Thread.sleep(1000);
		booking.getRemarks().sendKeys(Remarks.trim());
		String valid_string14 = valid_alphanum(Remarks, "Remarks", 1000);
		String valid_Remarks = valid_string14;
		System.out.println(valid_Remarks);
		Thread.sleep(1000);
		booking.getAnniversarydate1().click();
		Thread.sleep(1000);
		booking.getSelectSingleDate(Anniversarydate);
		Thread.sleep(1000);
		booking.getcustfile().sendKeys(Custfile);
		Thread.sleep(1000);
		booking.getNextbtn2().click();
		Thread.sleep(2000);

		// Broker Details
		booking.getisBroker().click();
		Thread.sleep(1000);
		booking.getBrokerName().sendKeys(BrokerName.trim());
		String valid_string15 = validateText(BrokerName, "Broker Name", 5, 50);
		String valid_BrokerName = valid_string15;
		System.out.println(valid_BrokerName);
		Thread.sleep(1000);
		booking.getBrokerAmount().sendKeys(BrokerAmount.trim());
		String valid_string16 = valid_number(BrokerAmount, "Broker Amount");
		String valid_BrokerAmount = valid_string16;
		System.out.println(valid_BrokerAmount);
		Thread.sleep(1000);
		booking.getBrokeringCompany().sendKeys(BrokeringCompany.trim());
		String valid_string17 = valid_alphanum(BrokeringCompany, "Brokering Company", 50);
		String valid_BrokeringCompany = valid_string17;
		System.out.println(valid_BrokeringCompany);
		Thread.sleep(1000);
		booking.getBrokerMobileNo().sendKeys(BrokerMobileNo.trim());
		String valid_string18 = valid_number(BrokerMobileNo, "Broker Mobile Number");
		String valid_BrokerMobileNo = valid_string18;
		System.out.println(valid_BrokerMobileNo);
		Thread.sleep(1000);
		booking.getbrokeruplaodfile().sendKeys(BrokerFiles);
		booking.getNextbtn3().click();
		Thread.sleep(2000);
		booking.EditInActiveBank(BankName + Keys.TAB);

		softAssert.assertEquals(valid_CarParking, "Car Parking Number is a Valid Number");
		softAssert.assertEquals(valid_Notes, "Notes is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Reference,
				"Reference is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_unitbasiccost, "Unit Basic Cost Number is a Valid Number");
		softAssert.assertEquals(valid_DevAndOtherCharges, "Dev And Other Charges Number is a Valid Number");

		softAssert.assertEquals(valid_CustName,
				"Customer name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_PanNumber, "Pan Number is a Valid PAN");
		softAssert.assertEquals(valid_AadharNumber, "Aadhar Number  is a Valid Assdhar");
		softAssert.assertEquals(valid_MobileNumber, "Mobile Number is a Valid Number");
		softAssert.assertEquals(valid_OtherNumber, "Other Number is a Valid Number");
		softAssert.assertEquals(valid_EmailAddress, "Email ID is a Valid EMail");
		softAssert.assertEquals(valid_PermanentAddress,
				"Permanent Address is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_OfficeAddress, "Office Address is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Remarks, "Remarks is not a Valid Alpha-Numeric is a valid Maxlenght");

		softAssert.assertEquals(valid_BrokerName,
				"Broker Name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_BrokerAmount, "Broker Amount is a Valid Number");
		softAssert.assertEquals(valid_BrokeringCompany,
				"Brokering Company is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_BrokerMobileNo, "Broker Mobile Number is a Valid Number");
		softAssert.assertAll();
	}

	// Verify Add InActive Bank
	@Test(dataProvider = "AddActiveBank", priority = 22)
	public void Verify_Add_Active_Bank(String searchBankName, String projectname, String unitblock, String flatshop,
			String bookedby, String BookingDate, String paymentplan1, String CarParking, String Notes,
			String bookingstatus, String Reference, String UnitBasicCost, String DevAndOtherCharges,
			// Add Customer
			String CustName, String profession, String Birthdate, String PAN, String AadharNo, String MobileNo,
			String OtherNo, String Email, String PermanentAddress, String OfficeAddress, String Remarks,
			String Anniversarydate, String Custfile,
			// Broker Details
			String BrokerName, String BrokerAmount, String BrokeringCompany, String BrokerMobileNo, String BrokerFiles,
			// Bank Loan Details
			String BankName) throws InterruptedException, IOException {

		SoftAssert softAssert = new SoftAssert();
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Thread.sleep(1000);
		Bank.getBankssearched().sendKeys(searchBankName + Keys.ENTER);
		Thread.sleep(1000);
		Bank.getbanksstatus().click();
		Thread.sleep(1000);
		Bank.getbanksstatusconfirmation().click();
		Thread.sleep(1000);

		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.AddBooking().click();
		Thread.sleep(2000);

		// Booking Details
		booking.getProjectName(projectname.trim());
		Thread.sleep(1000);
		booking.getUnitBlock(unitblock.trim());
		Thread.sleep(1000);
		booking.getFlatShop(flatshop.trim());
		Thread.sleep(1000);
		booking.getBookedBy(bookedby.trim());
		Thread.sleep(1000);
		booking.BookingDate();
		Thread.sleep(1000);
		booking.getPaymentPlan(paymentplan1.trim());
		Thread.sleep(1000);
		booking.getCarParking().sendKeys(CarParking);
		String valid_string1 = valid_number(CarParking, "Car Parking Number");
		String valid_CarParking = valid_string1;
		System.out.println(valid_CarParking);
		Thread.sleep(1000);
		booking.getNotes().sendKeys(Notes.trim());
		String valid_string2 = valid_alphanum(Notes, "Notes", 1000);
		String valid_Notes = valid_string2;
		System.out.println(valid_Notes);
		booking.BookingStatus(bookingstatus.trim());
		Thread.sleep(1000);
		booking.getReference().sendKeys(Reference.trim());
		String valid_string3 = validateText(Reference, "Reference", 5, 30);
		String valid_Reference = valid_string3;
		System.out.println(valid_Reference);
		// Valid Unit Basic Cost
		booking.getUnitBasicCost().sendKeys(UnitBasicCost.trim());
		String valid_string4 = valid_number(UnitBasicCost, "Unit Basic Cost Number");
		String valid_unitbasiccost = valid_string4;
		System.out.println(valid_unitbasiccost);
		Thread.sleep(1000);
		booking.getDevAndOtherCharges().sendKeys(DevAndOtherCharges.trim());
		String valid_string5 = valid_number(DevAndOtherCharges, "Dev And Other Charges Number");
		String valid_DevAndOtherCharges = valid_string5;
		System.out.println(valid_DevAndOtherCharges);
		Thread.sleep(1000);
		booking.getNextbtn().click();
		Thread.sleep(2000);

		// Add Customer
		booking.getName().sendKeys(CustName.trim());
		String valid_string6 = validateText(CustName, "Customer name", 5, 20);
		String valid_CustName = valid_string6;
		System.out.println(valid_CustName);
		Thread.sleep(1000);
		booking.getProfession(profession.trim());
		Thread.sleep(1000);
		booking.getBirthDate1().click();
		Thread.sleep(1000);
		booking.getSelectSingleDate(Birthdate);
		Thread.sleep(1000);
		booking.getPAN().sendKeys(PAN.trim());
		String valid_string7 = valid_pan(PAN, "Pan Number");
		String valid_PanNumber = valid_string7;
		System.out.println(valid_PanNumber);
		Thread.sleep(1000);
		booking.getAadharNo().sendKeys(AadharNo.trim());
		String valid_string8 = valid_aadhar(AadharNo, "Aadhar Number ");
		String valid_AadharNumber = valid_string8;
		System.out.println(valid_AadharNumber);
		Thread.sleep(1000);
		booking.getMobileNo().sendKeys(MobileNo.trim());
		String valid_string9 = valid_number(MobileNo, "Mobile Number");
		String valid_MobileNumber = valid_string9;
		System.out.println(valid_MobileNumber);
		Thread.sleep(1000);
		booking.getOtherNo().sendKeys(OtherNo.trim());
		String valid_string10 = valid_number(OtherNo, "Other Number");
		String valid_OtherNumber = valid_string10;
		System.out.println(valid_OtherNumber);
		Thread.sleep(1000);
		booking.getEmail().sendKeys(Email.trim());
		String valid_string11 = valid_EMail(Email, "Email ID");
		String valid_EmailAddress = valid_string11;
		System.out.println(valid_EmailAddress);
		Thread.sleep(1000);
		booking.getPermanentAddress().sendKeys(PermanentAddress.trim());
		String valid_string12 = valid_alphanum(PermanentAddress, "Permanent Address", 500);
		String valid_PermanentAddress = valid_string12;
		System.out.println(valid_PermanentAddress);
		Thread.sleep(1000);
		booking.getOfficeAddress().sendKeys(OfficeAddress.trim());
		String valid_string13 = valid_alphanum(OfficeAddress, "Office Address", 500);
		String valid_OfficeAddress = valid_string13;
		System.out.println(valid_OfficeAddress);
		Thread.sleep(1000);
		booking.getRemarks().sendKeys(Remarks.trim());
		String valid_string14 = valid_alphanum(Remarks, "Remarks", 1000);
		String valid_Remarks = valid_string14;
		System.out.println(valid_Remarks);
		Thread.sleep(1000);
		booking.getAnniversarydate1().click();
		Thread.sleep(1000);
		booking.getSelectSingleDate(Anniversarydate);
		Thread.sleep(1000);
		booking.getcustfile().sendKeys(Custfile);
		Thread.sleep(1000);
		booking.getNextbtn2().click();
		Thread.sleep(2000);

		// Broker Details
		booking.getisBroker().click();
		Thread.sleep(1000);
		booking.getBrokerName().sendKeys(BrokerName.trim());
		String valid_string15 = validateText(BrokerName, "Broker Name", 5, 50);
		String valid_BrokerName = valid_string15;
		System.out.println(valid_BrokerName);
		Thread.sleep(1000);
		booking.getBrokerAmount().sendKeys(BrokerAmount.trim());
		String valid_string16 = valid_number(BrokerAmount, "Broker Amount");
		String valid_BrokerAmount = valid_string16;
		System.out.println(valid_BrokerAmount);
		Thread.sleep(1000);
		booking.getBrokeringCompany().sendKeys(BrokeringCompany.trim());
		String valid_string17 = valid_alphanum(BrokeringCompany, "Brokering Company", 50);
		String valid_BrokeringCompany = valid_string17;
		System.out.println(valid_BrokeringCompany);
		Thread.sleep(1000);
		booking.getBrokerMobileNo().sendKeys(BrokerMobileNo.trim());
		String valid_string18 = valid_number(BrokerMobileNo, "Broker Mobile Number");
		String valid_BrokerMobileNo = valid_string18;
		System.out.println(valid_BrokerMobileNo);
		Thread.sleep(1000);
		booking.getbrokeruplaodfile().sendKeys(BrokerFiles);
		booking.getNextbtn3().click();
		Thread.sleep(2000);
		booking.EditInActiveBank(BankName + Keys.TAB);

		softAssert.assertEquals(valid_CarParking, "Car Parking Number is a Valid Number");
		softAssert.assertEquals(valid_Notes, "Notes is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Reference,
				"Reference is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_unitbasiccost, "Unit Basic Cost Number is a Valid Number");
		softAssert.assertEquals(valid_DevAndOtherCharges, "Dev And Other Charges Number is a Valid Number");

		softAssert.assertEquals(valid_CustName,
				"Customer name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_PanNumber, "Pan Number is a Valid PAN");
		softAssert.assertEquals(valid_AadharNumber, "Aadhar Number  is a Valid Assdhar");
		softAssert.assertEquals(valid_MobileNumber, "Mobile Number is a Valid Number");
		softAssert.assertEquals(valid_OtherNumber, "Other Number is a Valid Number");
		softAssert.assertEquals(valid_EmailAddress, "Email ID is a Valid EMail");
		softAssert.assertEquals(valid_PermanentAddress,
				"Permanent Address is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_OfficeAddress, "Office Address is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_Remarks, "Remarks is not a Valid Alpha-Numeric is a valid Maxlenght");

		softAssert.assertEquals(valid_BrokerName,
				"Broker Name is a Valid text - is a valid Minlenght - is a valid Maxlenght");
		softAssert.assertEquals(valid_BrokerAmount, "Broker Amount is a Valid Number");
		softAssert.assertEquals(valid_BrokeringCompany,
				"Brokering Company is a Valid Alpha-Numeric is a valid Maxlenght");
		softAssert.assertEquals(valid_BrokerMobileNo, "Broker Mobile Number is a Valid Number");
		softAssert.assertAll();
	}

	// Verify Edit InActive
	@Test(dataProvider = "EditInActive", priority = 23)
	public void Verify_Edit_InActive_ProfessionAndBank(String searchProfessionName, String searchBankName,
			String searchbookingdetails, String ProfessionName, String BankName) throws InterruptedException {

		ProfessionPage Profession = new ProfessionPage(driver);
		Bankspage Bank = new Bankspage(driver);
		Profession.getconfiguration().click();
		Profession.getProfession().click();
		Profession.getSearch().sendKeys(searchProfessionName + Keys.ENTER);
		Thread.sleep(1000);
		Profession.getChangeStatus().click();
		Thread.sleep(1000);
		Profession.getYesButton().click();
		Thread.sleep(1000);
		Profession.getconfiguration().click();
		Thread.sleep(1000);
		Bank.getBanksclick().click();
		Thread.sleep(1000);
		Bank.getBankssearched().sendKeys(searchBankName + Keys.ENTER);
		Thread.sleep(1000);
		Bank.getbanksstatus().click();
		Thread.sleep(1000);
		Bank.getbanksstatusconfirmation().click();
		Thread.sleep(1000);

		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getBookingSearch().sendKeys(searchbookingdetails + Keys.ENTER);
		Thread.sleep(1000);
		booking.getEdit().click();
		booking.GetNextbtnEditTime().click();
		Thread.sleep(1000);
		booking.EditInActiveProfession(ProfessionName + Keys.TAB);
		Thread.sleep(1000);
		booking.Getclicktab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		booking.GetNextbtnEditTime1().click();
		Thread.sleep(1000);
		booking.GetNextbtnEditTime2().click();
		Thread.sleep(1000);
		booking.EditInActiveBank(BankName + Keys.TAB);
	}

	// Verify Edit Active
	@Test(dataProvider = "EditActive", priority = 24)
	public void Verify_Edit_Active_Profession(String searchProfessionName, String searchBankName,
			String searchbookingdetails, String ProfessionName, String BankName) throws InterruptedException {

		ProfessionPage Profession = new ProfessionPage(driver);
		Bankspage Bank = new Bankspage(driver);
		Profession.getconfiguration().click();
		Profession.getProfession().click();
		Profession.getSearch().sendKeys(searchProfessionName + Keys.ENTER);
		Thread.sleep(1000);
		Profession.getChangeStatus().click();
		Thread.sleep(1000);
		Profession.getYesButton().click();
		Thread.sleep(1000);
		Profession.getconfiguration().click();
		Thread.sleep(1000);
		Bank.getBanksclick().click();
		Thread.sleep(1000);
		Bank.getBankssearched().sendKeys(searchBankName + Keys.ENTER);
		Thread.sleep(1000);
		Bank.getbanksstatus().click();
		Thread.sleep(1000);
		Bank.getbanksstatusconfirmation().click();
		Thread.sleep(1000);

		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getBookingSearch().sendKeys(searchbookingdetails + Keys.ENTER);
		Thread.sleep(1000);
		booking.getEdit().click();
		booking.GetNextbtnEditTime().click();
		Thread.sleep(1000);
		booking.EditInActiveProfession(ProfessionName + Keys.TAB);
		Thread.sleep(1000);
		booking.Getclicktab().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		booking.GetNextbtnEditTime1().click();
		Thread.sleep(1000);
		booking.GetNextbtnEditTime2().click();
		Thread.sleep(1000);
		booking.EditInActiveBank(BankName + Keys.TAB);
	}

	// Cancel Booking
	@Test(dataProvider = "getCancelBooking", priority = 25)
	public void Cancel_Booking(String searchName, String Reason) throws InterruptedException {
		BookingPage booking = new BookingPage(driver);
		booking.getBooking().click();
		booking.getBookingSearch().sendKeys(searchName + Keys.ENTER);
		Thread.sleep(2000);
		booking.getCancelbooking().click();
		Thread.sleep(1000);
		booking.getReason().sendKeys(Reason);
		Thread.sleep(1000);
		booking.getAgreementSaleRcvd().click();
		Thread.sleep(2000);
		booking.getCancelBooking2().click();
		Thread.sleep(2000);
		booking.getYesbutton().click();
		Thread.sleep(1000);
	}

	// Close the driver
	@AfterMethod
	public void teaddown() {
		driver.close();
		driver.quit();

	}

	// Add Booking Data Provider
	@DataProvider
	public Object[][] getAddBooking() {
		return new Object[][] { { "Automation Project1", "B", "Unit No - B - 128 (14th Floor)", "Nilesh Panchal", "",
				"Goff5foooooooooooooooooooooo", "11", "Notes 11", "Booked", "Mohit Vyas Reference", "6100000", "250000",
				"Pulkit Kulkarni", "SIT Profession", "1/DEC/1990", "AFZPK7190K", "2653 8564 4663", "9898005625",
				"9999999999", "vimal.v@shaligraminfotech.com", "South Bopal, Ahmedabad, Gujarat 380058",
				"Shaligram Corporate house, Ambli, Ahmedabad, Gujarat 380058", "Remark", "1/JAN/2021",
				"C:\\1LogoShaligram.png", "Parth Modi", "50000", "Delta Property11", "9898569865",
				"C:\\1LogoShaligram.png", "BOI123", "2500000", "Ahmedabad11", "123456", "Ahmedabad" },

				{ "Automation Project1", "B", "Unit No - B - 127 (14th Floor)", "Nilesh Panchal", "",
						"Goff5foooooooooooooooooooooo", "11", "Notes 11", "Booked", "Mohit Vyas Reference", "6100000",
						"250000", "Joseph mikel", "SIT Profession", "1/DEC/1990", "AFZPK7190K", "2653 8564 4663",
						"9898005625", "9999999999", "vimal.v@shaligraminfotech.com",
						"South Bopal, Ahmedabad, Gujarat 380058",
						"Shaligram Corporate house, Ambli, Ahmedabad, Gujarat 380058", "Remark", "1/JAN/2021",
						"C:\\1LogoShaligram.png", "Parth Modi", "50000", "Delta Property11", "9898569865",
						"C:\\1LogoShaligram.png", "BOI123", "2500000", "Ahmedabad11", "123456", "Ahmedabad" },

				{ "Automation Project1", "B", "Unit No - B - 126 (13th Floor)", "Nilesh Panchal", "",
						"Goff5foooooooooooooooooooooo", "11", "Notes 11", "Booked", "Mohit Vyas Reference", "6100000",
						"250000", "Mark joan", "SIT Profession", "1/DEC/1990", "AFZPK7190K", "2653 8564 4663",
						"9898005625", "9999999999", "vimal.v@shaligraminfotech.com",
						"South Bopal, Ahmedabad, Gujarat 380058",
						"Shaligram Corporate house, Ambli, Ahmedabad, Gujarat 380058", "Remark", "1/JAN/2021",
						"C:\\1LogoShaligram.png", "Parth Modi", "50000", "Delta Property11", "9898569865",
						"C:\\1LogoShaligram.png", "BOI123", "2500000", "Ahmedabad11", "123456", "Ahmedabad" },

				{ "Automation Project1", "B", "Unit No - B - 125 (13th Floor)", "Nilesh Panchal", "",
						"Goff5foooooooooooooooooooooo", "11", "Notes 11", "Booked", "Mohit Vyas Reference", "6100000",
						"250000", "Nike jordan", "SIT Profession", "1/DEC/1990", "AFZPK7190K", "2653 8564 4663",
						"9898005625", "9999999999", "vimal.v@shaligraminfotech.com",
						"South Bopal, Ahmedabad, Gujarat 380058",
						"Shaligram Corporate house, Ambli, Ahmedabad, Gujarat 380058", "Remark", "1/JAN/2021",
						"C:\\1LogoShaligram.png", "Parth Modi", "50000", "Delta Property11", "9898569865",
						"C:\\1LogoShaligram.png", "BOI123", "2500000", "Ahmedabad11", "123456", "Ahmedabad" },
		};
	}

	// Edit Booking Data
	@DataProvider
	public Object[][] getEditBooking() {
		return new Object[][] { { "Pulkit Kulkarni", "B", "Unit No - B - 128 (14th Floor) (Booked)", "Nilesh Panchal", " ",
				"Zoy Payment Plan", "3", "Notes Test 1234", "Bhim Ahir", "6500000", "250000", "Pulkit Kulkarni update",
				"Software Engineer", "1/DEC/1990", "AFZPK7190K", "2653 8564 4663", "9898005625", "9999999999",
				"vimal.v@shaligraminfotech.com", "Permanent Address TEst 1234", "Office Address Test 5634",
				"Updated Remark", "1/JAN/2021", "C:\\1LogoShaligram.png", "Parth Modi Test", "50050",
				"Delta Property Test", "6565969656", "C:\\1LogoShaligram.png", "SIT Bank", "1500000",
				"New Branch Shela", "899889", "Ahmedabad" } };
	}

	// DataProvider for Cancel Booking
	@DataProvider
	public Object[][] getCancelBooking() {
		return new Object[][] { { "Pulkit Kulkarni update", "Not intested now.", }, { "Joseph mikel", "Not intested now.", },
				{ "Mark joan", "Not intested now.", }, { "Nike jordan", "Not intested now.", }, };
	}

	// DataProvider for Documentation Details
	@DataProvider
	public Object[][] getDocumentationDetailsForm() {
		return new Object[][] { { "Pulkit Kulkarni update", "123456", "30/JAN/2025", "999999", "30/JAN/2025" } };
	}

	// DataProvider for Agreement Form
	@DataProvider
	public Object[][] getAgreementForm() {
		return new Object[][] { { "Pulkit Kulkarni update" } };
	}

	// DataProvider for Inquiry Form
	@DataProvider
	public Object[][] getInquiryForm() {
		return new Object[][] { { "Pulkit Kulkarni update" } };
	}

	// DataProvider for Agreement Number
	@DataProvider
	public Object[][] getAllDocument() {
		return new Object[][] { { "Pulkit Kulkarni update", "123456", "999999" } };
	}

	// DataProvider for Booking Form
	@DataProvider
	public Object[][] getBookingForm() {
		return new Object[][] { { "Pulkit Kulkarni update" } };
	}

	// DataProvider for search data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] { { "Manish Modi" } };
	}

	// DataProvider for Apply Filter for Booking with Booking Date
	@DataProvider
	public Object[][] getBookingDateFilter() {
		return new Object[][] { { "1/SEP/2022", "1/SEP/2025" } };
	}

	// DataProvider for Apply Filter for Booking with Bookd By
	@DataProvider
	public Object[][] getBookedbyFilter() {
		return new Object[][] { { "Nilesh Panchal" } };
	}

	// DataProvider for Apply Filter for Booking with Project Name
	@DataProvider
	public Object[][] getProjectFilter() {
		return new Object[][] { { "Automation Project5" } };
	}

	// DataProvider for Apply Filter for Booking with Booking Status
	@DataProvider
	public Object[][] getBookingStatusFilter() {
		return new Object[][] { { "Waiting For Cancellation" } };
	}

	// DataProvider for Apply Filter for Booking with all filters
	@DataProvider
	public Object[][] getBookingfilterWithAllData() {
		return new Object[][] {
				{ "1/SEP/2022", "1/SEP/2025", " Nilesh Panchal", " Automation Project1", " Cancelled" } };
	}

	// DataProvider for Rest All Filters button
	@DataProvider
	public Object[][] getRestAllFilters() {
		return new Object[][] { { " ", "Nishant Pranav" } };
	}

	// DataProvider for Edit record
	@DataProvider
	public Object[][] EditBooking() {
		return new Object[][] { { "Pulkit Kulkarni update" } };
	}

	// DataProvider for Edit InActive Profession
	@DataProvider
	public Object[][] EditInActive() {
		return new Object[][] { { "Test_Vimal", "Sbi1", "Mark joan", "Test_Vimal", "Sbi1" } };
	}

	// DataProvider for Edit Active Profession
	@DataProvider
	public Object[][] EditActive() {
		return new Object[][] { { "Test_Vimal", "Sbi1", "Mark joan", "Test_Vimal", "Sbi1" } };
	}

	// DataProvider for Add InActive Project
	@DataProvider
	public Object[][] AddInActiveProject() {
		return new Object[][] { { "Automation Project5", "Automation Project5" } };
	}

	// DataProvider for Add Active Project
	@DataProvider
	public Object[][] AddActiveProject() {
		return new Object[][] { { "Automation Project5", "Automation Project5" } };
	}

	// DataProvider for Add InActive Profession
	@DataProvider
	public Object[][] AddInActiveProfession() {
		return new Object[][] { { "Test Prof", "Automation Project1", "A", "Unit No - 101 (1st Floor)",
				"Nilesh Panchal", "", "Goff5foooooooooooooooooooooo", "11", "Notes 11", "Booked", "Mohit Vyas",
				"6100000", "250000", "Pulkit Kulkarni", "Test Prof" } };
	}

	// DataProvider for Add Active Profession
	@DataProvider
	public Object[][] AddActiveProfession() {
		return new Object[][] { { "Test Prof", "Automation Project1", "A", "Unit No - 101 (1st Floor)",
				"Nilesh Panchal", "", "Goff5foooooooooooooooooooooo", "11", "Notes 11", "Booked", "Mohit Vyas",
				"6100000", "250000", "Pulkit Kulkarni", "Test Prof" } };
	}

	// DataProvider for Add InActive Bank
	@DataProvider
	public Object[][] AddInActiveBank() {
		return new Object[][] { { "HDFC", "Automation Project1", "A", "Unit No - 101 (1st Floor)", "Nilesh Panchal", "",
				"Goff5foooooooooooooooooooooo", "11", "Notes 11", "Booked", "Mohit Vyas", "6100000", "250000",
				"Pulkit Kulkarni", "Software Engineer", "1/DEC/1990", "AFZPK7190K", "2653 8564 4663", "9898005625",
				"9999999999", "vimal.v@shaligraminfotech.com", "Permanent Address TEst 1234",
				"Office Address Test 5634", "Updated Remark", "1/JAN/2021", "C:\\1LogoShaligram.png", "Parth Modi Test",
				"50050", "Delta Property Test 1345", "6565969656", "C:\\1LogoShaligram.png", "HDFC" } };
	}

	// DataProvider for Add Active Bank
	@DataProvider
	public Object[][] AddActiveBank() {
		return new Object[][] { { "HDFC", "Automation Project1", "A", "Unit No - 101 (1st Floor)", "Nilesh Panchal", "",
				"Goff5foooooooooooooooooooooo", "11", "Notes 11", "Booked", "Mohit Vyas", "6100000", "250000",
				"Pulkit Kulkarni", "Software Engineer", "1/DEC/1990", "AFZPK7190K", "2653 8564 4663", "9898005625",
				"9999999999", "vimal.v@shaligraminfotech.com", "Permanent Address TEst 1234",
				"Office Address Test 5634", "Updated Remark", "1/JAN/2021", "C:\\1LogoShaligram.png", "Parth Modi Test",
				"50050", "Delta Property Test 1345", "6565969656", "C:\\1LogoShaligram.png", "HDFC" } };
	}

	// Method to close all open browser windows
	public void closeAllWindows() {
		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			//driver.close();
		}
	}
}
