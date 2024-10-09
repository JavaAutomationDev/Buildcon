package pageObjects;

import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	By addbooking = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/button");
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
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
				+ "vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[5]/"
				+ "mat-form-field/div[1]/div[2]/div[2]/input"))
		.sendKeys(currentDateString);
	}

	//Page object for Payment Plan
	By PaymentPlan = By.xpath("//mat-select[@formcontrolname='paymentPlanID']");

	public void getPaymentPlan(String paymentplan) {
		WebElement dropdown = driver.findElement(PaymentPlan);
		dropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + paymentplan + "')]";
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

	//Page object for Next button
	By Nextbtn = By.xpath("//*[@id=\"cdk-step-content-0-0\"]/div/form/div[2]/button[2]");
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
	By Profession = By.xpath("//input[@formcontrolname='profession']");
	public WebElement getProfession() {
		return driver.findElement(Profession);
	}

	//Page object for Birthdate
	public void Birthdate() {
	driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/"
			+ "mat-card/mat-card-content/div[1]/div[3]/mat-form-field/div[1]/div[2]/div[2]/input"))
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
	
	//Page objectAnniversary Date
	//Page object Next button(Second Button)
	By Nextbtn2 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextbtn2() {
		return driver.findElement(Nextbtn2);
	}
	
	//Broker Details
	//Page Object IS Broker button
	By isBroker = By.xpath("//*[@id=\"mat-mdc-checkbox-2\"]");
	public WebElement getisBroker() {
		return driver.findElement(isBroker);
	}
	
	// Page object Next button (Third Button)
    public void getNextbtn3() {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
				+ "mat-sidenav-content/main/vex-add-booking/div/div[2]"
						+ "/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[2]")).click();
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
	
	//Page object Branch Details
	By Branch = By.xpath("//input[@formcontrolname='branch']");
	public WebElement getBranch() {
		return driver.findElement(Branch);
	}

	//Page object Loan Account Number Details
	By loanacno = By.xpath("//input[@formcontrolname='loanAccountNumber']");
	public WebElement getLoanAcNo() {
		return driver.findElement(loanacno);
	}

	//Page object City Details
	By City = By.xpath("//input[@formcontrolname='city']");
	public WebElement getCity() {
		return driver.findElement(City);
	}
	
	//Click on Book
	public void getBookbtn() {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
				+ "mat-sidenav-content/main/vex-add-booking/div/div[2]"
				+ "/div/mat-vertical-stepper/div[4]/div/div/div/form/div[2]/button[2]")).click();
	}
	
	//Page object for Edit button
	By editbooking = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
			+ "main/vex-bookings/div/div[1]/div[2]/button");
	public WebElement EditBooking() {
		return driver.findElement(editbooking);
	}	
	////Page object for Edit Car Parking
	//      By CarParking1 = By.xpath("//input[@formcontrolname='carParking']");
	//     public WebElement getcarparking1() {
	//   return driver.findElement(CarParking1);	

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
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
			+ "/vex-inquires/div/div[1]/div[2]/div[3]/button/mat-icon");
	public WebElement getapplyfilter() {
		return driver.findElement(filter);
	}
	
	//Page object for Date Range
	By Daterange=By.xpath("//mat-date-range-input[@role='group']");
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
	//		//Page object for Select Booking
	//		By BookedBy1=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[2]/mat-form-field/div[1]/div[2]/div/mat-select/div/div[2]");
	//		
	//
	//			public WebElement getSelectBookingBy() {
	//				return driver.findElement(BookedBy1);
	//			}
	//			WebElement dropdown = driver.findElement(BookedBy1);
	//			dropdown.click();
	//			String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + bookedby1 + "')]";
	//		WebElement option = driver.findElement(By.xpath(optionXPath));
	//			option.click();
	//Page object for Select Project Filter
	By selectprojectfilter=By.xpath("//mat-select[@placeholder='Select Project']");
	public void getselectproject(String ProjectFilter) {
		WebElement dropdown = driver.findElement(selectprojectfilter);
		dropdown.click();
		String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + ProjectFilter + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
}