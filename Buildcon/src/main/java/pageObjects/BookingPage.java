package pageObjects;

import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Test1
public class BookingPage {
	public WebDriver driver;

	public BookingPage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Booking module
	By booking = By.xpath("//vex-sidenav-item[5]//a[1]");

	public WebElement getBooking() {
		return driver.findElement(booking);
	}

	//Page object for Add Booking Module
	By addbooking = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/button");
	public WebElement AddBooking() {
		return driver.findElement(addbooking);
	}

	//Booking Details
	//Page object for Project Name
	By Projectname = By.xpath("//mat-select[@formcontrolname='projectID']");
	public void getProjectName(String projectname) {
		WebElement dropdown = driver.findElement(Projectname);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + projectname + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for Unit/Block
	By UnitBlock = By.xpath("//mat-select[@formcontrolname='unitBlockID']");

	public void getUnitBlock(String unitblock) {
		WebElement dropdown = driver.findElement(UnitBlock);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + unitblock + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for Select Flat/Shop
	By FlatShop = By.xpath("//mat-select[@formcontrolname='flatShopID']");
	public void getFlatShop(String flatshop) {
		WebElement dropdown = driver.findElement(FlatShop);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + flatshop + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for BookedBy
	By BookedBy = By.xpath("//mat-select[@formcontrolname='bookedByID']");
	public void getBookedBy(String bookedby) {
		WebElement dropdown = driver.findElement(BookedBy);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + bookedby + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for Booking Date
	public void BookingDate() {
		Calendar currentDate = Calendar.getInstance();
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		int month = currentDate.get(Calendar.MONTH) + 1; // Months are zero-based
		int year = currentDate.get(Calendar.YEAR);
		String currentDateString = day + "/" + month + "/" + year;
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[5]/mat-form-field/div[1]/div[2]/div[2]/input"))
		.sendKeys(currentDateString);
	}

	//Page object for Payment Plan
	By PaymentPlan = By.xpath("//mat-select[@formcontrolname='paymentPlanID']");
	public void getPaymentPlan(String paymentplan1) {
		WebElement dropdown = driver.findElement(PaymentPlan);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + paymentplan1 + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for Car Parking
	By CarParking = By.xpath("//input[@formcontrolname='carParking']");
	public WebElement getCarParking() {
		return driver.findElement(CarParking);
	}

	//Page object for Notes
	By Notes = By.xpath("//textarea[@formcontrolname='notes']");
	public WebElement getNotes() {
		return driver.findElement(Notes);
	}

	//Page object for Booking Status
	By BookingStatus = By.xpath("//mat-select[@formcontrolname='bookingStatusID']");
	public void BookingStatus(String bookingstatus) {
		WebElement dropdown = driver.findElement(BookingStatus);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + bookingstatus + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for Reference
	By Reference = By.xpath("//input[@formcontrolname='reference']");
	public WebElement getReference() {
		return driver.findElement(Reference);
	}

	//Page object for Unit Basic Cost
	By UnitBasicCost = By.xpath("//input[@formcontrolname='unitBasicCost']");
	public WebElement getUnitBasicCost() {
		return driver.findElement(UnitBasicCost);
	}

	//Page object for Development And Other Charges
	By DevAndOtherCharges = By.xpath("//input[@formcontrolname='devCharges']");
	public WebElement getDevAndOtherCharges() {
		return driver.findElement(DevAndOtherCharges);
	}

	//Page object for Sale Value
	By SaleValue = By.xpath("//input[@formcontrolname='saleValue']");
	public WebElement SaleValue() {
		return driver.findElement(SaleValue);
	}

	//Page object for Next button(First Button)
	By Nextbtn = By.xpath("(//button[@type='button'])[7]");
	public WebElement getNextbtn() {
		return driver.findElement(Nextbtn);
	}

	//Add Customer
	//Page object for Name
	By Name = By.xpath("//input[@formcontrolname='memberName']");
	public WebElement getName() {
		return driver.findElement(Name);
	}

	//Page object for Profession
	By Profession = By.xpath("//mat-select[@formcontrolname='professionId']");
	public void Profession(String profession) {
		WebElement dropdown = driver.findElement(Profession);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + profession + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for Birthdate
	public void Birthdate() {
		driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
						+ "/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[3]/mat-form-field/div[1]/div[2]/div[2]/input"))
		.sendKeys("13/09/2006");
	}

	//Page object for PAN No.
	By PAN = By.xpath("//input[@formcontrolname='panNo']");
	public WebElement getPAN() {
		return driver.findElement(PAN);
	}

	//Page object for Aadhar Number No
	By AadharNo = By.xpath("//input[@formcontrolname='aadharNo']");
	public WebElement getAadharNo() {
		return driver.findElement(AadharNo);
	}

	//Page object for Mobile No
	By MobileNo = By.xpath("//input[@formcontrolname='mobile']");

	public WebElement getMobileNo() {
		return driver.findElement(MobileNo);
	}

	//Page object for Other No
	By OtherNo = By.xpath("//input[@formcontrolname='alternativeNo']");
	public WebElement getOtherNo() {
		return driver.findElement(OtherNo);
	}

	//Page object for Email
	By Email = By.xpath("//input[@formcontrolname='email']");
	public WebElement getEmail() {
		return driver.findElement(Email);
	}

	//Page object Address Permanent Address
	By PermanentAddress = By.xpath("//textarea[@formcontrolname='permanentAddress']");

	public WebElement getPermanentAddress() {
		return driver.findElement(PermanentAddress);
	}
	
	//Page object Address Office Address
	By OfficeAddress = By.xpath("//textarea[@formcontrolname='officeAddress']");
	public WebElement getOfficeAddress() {
		return driver.findElement(OfficeAddress);
	}
	
	//Page object Address Remarks
	By Remarks = By.xpath("//textarea[@formcontrolname='remarks']");
	public WebElement getRemarks() {
		return driver.findElement(Remarks);

	}

	//Page object Next button(Second Button)
	By Nextbtn2 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextbtn2() {
		return driver.findElement(Nextbtn2);
	}
	//Broker Details
	//Page Object IS Broker button
	By isBroker = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[1]/"
			+ "mat-form-field/div[1]/div[2]/div[2]/mat-checkbox/div/div/input");
	public WebElement getisBroker() {
		return driver.findElement(isBroker);
	}

	//Page object Broker Name
	By BrokerName = By.xpath("//input[@formcontrolname='brokerName']");
	public WebElement getBrokerName() {
		return driver.findElement(BrokerName);
	}
	
	//Page object Broker Amount
	By BrokerAmount = By.xpath("//input[@formcontrolname='brokerage']");
	public WebElement getBrokerAmount() {
		return driver.findElement(BrokerAmount);
	}
	
	//Page object Brokering Company
	By BrokeringCompany = By.xpath("//input[@formcontrolname='brokerCompany']");
	public WebElement getBrokeringCompany() {
		return driver.findElement(BrokeringCompany);
	}
	
	//Page object Broker Mobile No
	By BrokerMobileNo = By.xpath("//input[@formcontrolname='brokerMobileNo']");
	public WebElement getBrokerMobileNo() {
		return driver.findElement(BrokerMobileNo);
	}
	
	//Page object Broker File(s)
	public void addprofile1() {
		WebElement a = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
				+ "/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[5]/mat-form-field/div[1]/div[2]/div[2]/input[2]"));
		a.sendKeys("C:\\Users\\sit87\\Desktop\\Buidcone_New\\Logo.jpg");
	}
	
	//Page object Next button (Third Button)
	By getNextbtn3 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]"
			+ "/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextbtn3() {
		return driver.findElement(getNextbtn3);
	}

	//Bank Loan Details
	//Page object Bank Loan Details
	By BankName = By.xpath("//mat-select[@formcontrolname='bankID']");
	public void BankName(String bankname) {
		WebElement dropdown = driver.findElement(BankName);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + bankname + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object Loan Amount Details
	By Loanamt = By.xpath("//input[@formcontrolname='loanAmount']");
	public WebElement getLoanamt() {
		return driver.findElement(Loanamt);
	}
	// Page object Branch Details
	By Branch = By.xpath("//input[@formcontrolname='branch']");
	public WebElement getBranch() {
		return driver.findElement(Branch);
	}

	//Page object Loan Account Number Details
	By loadnacno = By.xpath("//input[@formcontrolname='loanAccountNumber']");
	public WebElement getloadnacno() {
		return driver.findElement(loadnacno);
	}

	//Page object City Details
	By City = By.xpath("//input[@formcontrolname='city']");
	public WebElement getCity() {
		return driver.findElement(City);
	}
	//Click on Book
	public void getBookbtn() {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]"
				+ "/div/mat-vertical-stepper/div[4]/div/div/div/form/div[2]/button[2]")).click();
	}
	//Page object for Edit button
	By Edit = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-bookings/div/div[3]/div/div/table/tbody/tr[1]/td[10]/div/a[1]");
	public WebElement getEdit() {
		return driver.findElement(Edit);
	}		

	//Click on Update button
	By Update = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content"
			+ "/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[2]/button[2]");
	public WebElement getUpdate() {
		return driver.findElement(Update);
	}
	
	//Page object for Cancel booking button from grid
	By Cancelbooking = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
			+ "/vex-bookings/div/div[3]/div/div/table/tbody/tr[1]/td[10]/div/a[2]");
	public WebElement getCancelbooking() {
		return driver.findElement(Cancelbooking);
	}
	//Page object for Reason
	By Reason = By.xpath("//input[@formcontrolname='reason']");
	public WebElement getReason() {
		return driver.findElement(Reason);
	}

	//Click on Agreement to Sale Received checkbox
	By AgreementSaleRcvd = By.xpath("//input[@class='mdc-checkbox__native-control']");
	public WebElement getAgreementSaleRcvd() {
		return driver.findElement(AgreementSaleRcvd);
	}

	//Click on Cancel Booking button popup
	By CancelBooking2 = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-confirm-modal/form/mat-dialog-actions/button");
	public WebElement getCancelBooking2() {
		return driver.findElement(CancelBooking2);
	}
	//Click on the Yes button
	By Yesbutton = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getYesbutton() {
		return driver.findElement(Yesbutton);
	}

	//Page object for all documents button
	By alldocuments = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content"
			+ "/main/vex-bookings/div/div[3]/div/div/table/tbody/tr[1]/td[10]/div/button");
	public WebElement getalldocuments() {
		return driver.findElement(alldocuments);
	}
	
	//Click on the Documentation Details
	By DocumentationDetails = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[1]");
	public WebElement getDocumentationDetails() {
		return driver.findElement(DocumentationDetails);
	}
	//Page object for Agreement Number
	By AgreementNumber = By.xpath("//input[@formcontrolname='agreementNumber']");
	public WebElement getAgreementNumber() {
		return driver.findElement(AgreementNumber);
	}	
	
	//Page object for Sale Deed Number
	By SaleDeed = By.xpath("//input[@formcontrolname='saleDeedNumber']");
	public WebElement getSaleDeed() {
		return driver.findElement(SaleDeed);
	}
	
	//Page object for Save button
	By Savebutton = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-legal-entry-popup/form/mat-dialog-actions/button[1]");
	public WebElement getSavebutton() {
		return driver.findElement(Savebutton);
	}
	
	//Page object for Agreement Form
	By AgreementForm = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[2]");
	public WebElement getAgreementForm() {
		return driver.findElement(AgreementForm);
	}	

	//Page object for Booking Form
	By  BookingForm = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[3]");
	public WebElement getBookingForm() {
		return driver.findElement(BookingForm);
	}

	//Page object for Search Booking
	By BookingSearch = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/div[1]/input");
	public WebElement getBookingSearch() {
		return driver.findElement(BookingSearch);
	}
	By BookingSearchclick = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
			+ "/vex-bookings/div/div[1]/div[2]/div[1]/mat-icon");
	public WebElement getBookingSearchclick() {
		return driver.findElement(BookingSearchclick);
	}
	
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-bookings/div/div[1]/div[2]/div[2]/button");
	public WebElement getExporttoExcel() {
		return driver.findElement(ExporttoExcel);	
	}
	
	//Page object for Apply Filter
	//By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/div[3]/button");
	//public WebElement getapplyfilter() {
	//return driver.findElement(filter);
	// }
	
	//Page object for Date Range
	By Daterange=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button");
	public WebElement getdaterange() {
		return driver.findElement(Daterange);
	}
	
	//Page object for Select start Date
	By SelectstartDate=By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']");
	public WebElement getSelectstartDate() {
		return driver.findElement(SelectstartDate);
	}
	
	//Page object for Select End Date
	By selectendDate=By.xpath("//span[normalize-space()='30']");
	public WebElement getSelectEndDate() {
		return driver.findElement(selectendDate);		
	}     
	
	//Page object for Select Booked By dropdown
	By BookedBy1 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[2]/mat-form-field");
	public void getbookedby1(String bookedby1) throws InterruptedException {
		WebElement dropdown = driver.findElement(BookedBy1);
		dropdown.click();
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option[4]")).click();
		//String optionXpath = "" + bookedby1 + "')]";
		//WebElement option = driver.findElement(By.xpath(optionXpath));
		//option.click();
	}		
	
	//Page object for Select Project dropdown
	public void getselectproject(String selectproject) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[3]/mat-form-field/div[1]/div[2]/div/mat-select")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option[5]")).click();
	}
	
	//Page object for Reset button
	By resetfilter=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[5]/button");
	public WebElement getresetfilter() {
		return driver.findElement(resetfilter);	
	}
	
	//Active & Deactivate Project
	//Page object for click Booking module
	By project = By.xpath("//vex-sidenav-item[4]//a[1]");
	public WebElement getProject() {
		return driver.findElement(project);
	}

	//Click on the Active/Deactive Project
	By getActiveYes =By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");
	public WebElement getActiveYes() {
		return driver.findElement(getActiveYes);	
	}

}	
