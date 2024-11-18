package pageObjects;

import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;


//Test1

public class BookingPage {
	public WebDriver driver;

	public BookingPage(WebDriver driver) {
		this.driver = driver;
	}

	// page object for click Booking module
	By booking = By.xpath("//vex-sidenav-item[5]//a[1]");

	public WebElement getBooking() {
		return driver.findElement(booking);
	}

	// page object for Add Booking Module
	By addbooking = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/button");

	public WebElement AddBooking() {
		return driver.findElement(addbooking);
	}

//Booking Details
	// page object for Project Name
	By Projectname = By.xpath("//mat-select[@formcontrolname='projectID']");

	public void getProjectName(String projectname) {
		WebElement dropdown = driver.findElement(Projectname);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Booking-getProjectName";
		
		String optionXpath = "//mat-option//span[contains(text(),'" + projectname + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	// page object for Unit/Block
	By UnitBlock = By.xpath("//mat-select[@formcontrolname='unitBlockID']");

	public void getUnitBlock(String unitblock) {
		WebElement dropdown = driver.findElement(UnitBlock);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Booking-getSelectFlat";
		
		String optionXpath = "//mat-option//span[contains(text(),'" + unitblock + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	// page object for Select Flat/Shop
	By FlatShop = By.xpath("//mat-select[@formcontrolname='flatShopID']");

	public void getFlatShop(String flatshop) {
		WebElement dropdown = driver.findElement(FlatShop);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Booking-getFlatShop";
		
		String optionXpath = "//mat-option//span[contains(text(),'" + flatshop + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	// page object for BookedBy
	By BookedBy = By.xpath("//mat-select[@formcontrolname='bookedByID']");

	public void getBookedBy(String bookedby) {
		WebElement dropdown = driver.findElement(BookedBy);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Booking-getBookedBy";
		
		String optionXpath = "//mat-option//span[contains(text(),'" + bookedby + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	// page object for Booking Date
	public void BookingDate() {
		Calendar currentDate = Calendar.getInstance();
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		int month = currentDate.get(Calendar.MONTH) + 1; // Months are zero-based
		int year = currentDate.get(Calendar.YEAR);
		String currentDateString = day + "/" + month + "/" + year;
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[5]/mat-form-field/div[1]/div[2]/div[2]/input"))
				.sendKeys(currentDateString);
		base.failedElementName = "Booking-BookingDate";
	}

	// page object for Payment Plan
	By PaymentPlan = By.xpath("//mat-select[@formcontrolname='paymentPlanID']");

	public void getPaymentPlan(String paymentplan) {
		WebElement dropdown = driver.findElement(PaymentPlan);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Booking-getPaymentPlan";
		
		String optionXpath = "//mat-option//span[contains(text(),'" + paymentplan + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	// page object for Car Parking
	By CarParking = By.xpath("//input[@formcontrolname='carParking']");

	public WebElement getCarParking() {
		base.failedElementName = "Booking-CarParking";
		return driver.findElement(CarParking);
	}

	// page object for Notes
	By Notes = By.xpath("//textarea[@formcontrolname='notes']");

	public WebElement getNotes() {
		base.failedElementName = "Booking-BookingDate";
		return driver.findElement(Notes);
	}

	// page object for Booking Status
	By BookingStatus = By.xpath("//mat-select[@formcontrolname='bookingStatusID']");

	public void BookingStatus(String bookingstatus) {
		WebElement dropdown = driver.findElement(BookingStatus);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Booking-BookingStatus";
		
		String optionXpath = "//mat-option//span[contains(text(),'" + bookingstatus + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	// page object for Reference
	By Reference = By.xpath("//input[@formcontrolname='reference']");

	public WebElement getReference() {
		base.failedElementName = "Booking-Referance";
		return driver.findElement(Reference);
	}

	// page object for Unit Basic Cost
	By UnitBasicCost = By.xpath("//input[@formcontrolname='unitBasicCost']");

	public WebElement getUnitBasicCost() {
		base.failedElementName = "Booking-UnitBasicCost";
		return driver.findElement(UnitBasicCost);
	}

	// page object for Development And Other Charges
	By DevAndOtherCharges = By.xpath("//input[@formcontrolname='devCharges']");

	public WebElement getDevAndOtherCharges() {
		base.failedElementName = "Booking-DevAndOtherCharges";
		return driver.findElement(DevAndOtherCharges);
	}

	// page object for Sale Value
	By SaleValue = By.xpath("//input[@formcontrolname='saleValue']");

	public WebElement SaleValue() {
		base.failedElementName = "Booking-SaleValue";
		return driver.findElement(SaleValue);
	}

	// Page object for Next button
	By Nextbtn = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]"
			+ "/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextbtn() {
		return driver.findElement(Nextbtn);
	}

//Add Customer
	// page object for Name
	By Name = By.xpath("//input[@formcontrolname='memberName']");

	public WebElement getName() {
		base.failedElementName = "Booking-CustomerName";
		return driver.findElement(Name);
	}

	// page object for Profession
	By Profession = By.xpath("//input[@formcontrolname='profession']");

	public WebElement getProfession() {
		base.failedElementName = "Booking-Profession";
		return driver.findElement(Profession);
	}

	// Page object for Birthdate
	public void Birthdate() {
		driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
				+ "/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[3]/mat-form-field/div[1]/div[2]/div[2]/input"))
				.sendKeys("13/09/2006");
		base.failedElementName = "Booking-BirthDate";
	}

	// Page object for PAN No.
	By PAN = By.xpath("//input[@formcontrolname='panNo']");

	public WebElement getPAN() {
		base.failedElementName = "Booking-PanNo";
		return driver.findElement(PAN);
	}

	// Page object for Aadhar Number No
	By AadharNo = By.xpath("//input[@formcontrolname='aadharNo']");

	public WebElement getAadharNo() {
		base.failedElementName = "Booking-AadharNo";
		return driver.findElement(AadharNo);
	}

	// Page object for Mobile No
	By MobileNo = By.xpath("//input[@formcontrolname='mobile']");

	public WebElement getMobileNo() {
		base.failedElementName = "Booking-MobileNo";
		return driver.findElement(MobileNo);
	}

	// Page object for Other No
	By OtherNo = By.xpath("//input[@formcontrolname='alternativeNo']");

	public WebElement getOtherNo() {
		base.failedElementName = "Booking-OtherNo";
		return driver.findElement(OtherNo);
	}

	// Page object for Email
	By Email = By.xpath("//input[@formcontrolname='email']");

	public WebElement getEmail() {
		base.failedElementName = "Booking-EMail";
		return driver.findElement(Email);
	}

	// Page object Address Permanent Address
	By PermanentAddress = By.xpath("//textarea[@formcontrolname='permanentAddress']");

	public WebElement getPermanentAddress() {
		base.failedElementName = "Booking-PermanentAddress";
		return driver.findElement(PermanentAddress);
	}
	// Page object Address Office Address
	By OfficeAddress = By.xpath("//textarea[@formcontrolname='officeAddress']");

	public WebElement getOfficeAddress() {
		base.failedElementName = "Booking-OfficeAddress";
		return driver.findElement(OfficeAddress);
	}
	// Page object Address Remarks
	By Remarks = By.xpath("//textarea[@formcontrolname='remarks']");

	public WebElement getRemarks() {
		base.failedElementName = "Booking-Remark";
		return driver.findElement(Remarks);

	}

	// Page object Next button(Second Button)
	By Nextbtn2 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextbtn2() {
		return driver.findElement(Nextbtn2);
	}
//Broker Details
	// Page Object IS Broker button
	By isBroker = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]"
			+ "/div/div/div/form/div[1]/div/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getisBroker() {
		base.failedElementName = "Booking-isBroker";
		return driver.findElement(isBroker);
	}
	// Page object Next button (Third Button)

		By getNextbtn3 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div"
				+ "[1]/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-checkbox");
		public WebElement getNextbtn3() {
			return driver.findElement(getNextbtn3);
		}
		
//Bank Loan Details
	// Page object Bank Loan Details
	By BankName = By.xpath("//mat-select[@formcontrolname='bankID']");

	public void BankName(String bankname) {
		WebElement dropdown = driver.findElement(BankName);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Booking-BankName";
		
		String optionXpath = "//mat-option//span[contains(text(),'" + bankname + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	
	// Page object Loan Amount Details
	By Loanamt = By.xpath("//input[@formcontrolname='loanAmount']");
	public WebElement getLoanamt() {
		base.failedElementName = "Booking-LoanAmt";
		return driver.findElement(Loanamt);
	}
	// Page object Branch Details
	By Branch = By.xpath("//input[@formcontrolname='branch']");

	public WebElement getBranch() {
		base.failedElementName = "Booking-LoanBranch";
		return driver.findElement(Branch);
	}

	// Page object Loan Account Number Details
	By loadnacno = By.xpath("//input[@formcontrolname='loanAccountNumber']");

	public WebElement getloadnacno() {
		base.failedElementName = "Booking-LoanAcNo";
		return driver.findElement(loadnacno);
	}

	// Page object City Details
	By City = By.xpath("//input[@formcontrolname='city']");

	public WebElement getCity() {
		base.failedElementName = "Booking-LoanCity";
		return driver.findElement(City);
	}
	// Click on Book
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
		base.failedElementName = "Booking-CancelBooking";
		return driver.findElement(Cancelbooking);
	}
	//Page object for Reason
	By Reason = By.xpath("//input[@formcontrolname='reason']");
	public WebElement getReason() {
		base.failedElementName = "Booking-CancelBookingReason";
		return driver.findElement(Reason);
	}
	
	//Click on Agreement to Sale Received checkbox
	By AgreementSaleRcvd = By.xpath("//input[@class='mdc-checkbox__native-control']");
	public WebElement getAgreementSaleRcvd() {
		base.failedElementName = "Booking-AgreementSaleRecd";
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
			base.failedElementName = "Booking-allDocuments";
			return driver.findElement(alldocuments);
		}
		//Click on the Documentation Details
				By DocumentationDetails = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[1]");
				public WebElement getDocumentationDetails() {
					base.failedElementName = "Booking-DocumentationDetails";
					return driver.findElement(DocumentationDetails);
				}
		//Page object for Agreement Number
				By AgreementNumber = By.xpath("//input[@formcontrolname='agreementNumber']");
				public WebElement getAgreementNumber() {
					base.failedElementName = "Booking-AgreementNo";
					return driver.findElement(AgreementNumber);
				}		
		//Page object for Sale Deed Number
				By SaleDeed = By.xpath("//input[@formcontrolname='saleDeedNumber']");
				public WebElement getSaleDeed() {
					base.failedElementName = "Booking-SaleDeedNo";
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
					base.failedElementName = "Booking-AgreementForm";
					return driver.findElement(AgreementForm);
				}	
		
        //Page object for Booking Form
				By  BookingForm = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[3]");
				public WebElement getBookingForm() {
					base.failedElementName = "Booking-BookingForm";
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
			base.failedElementName = "Booking-SearchClick";
			return driver.findElement(BookingSearchclick);
     }
//Page object for Export to Excel
		By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
				+ "vex-bookings/div/div[1]/div[2]/div[2]/button");
		public WebElement getExporttoExcel() {
			base.failedElementName = "Booking-ExportExcel";
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
			base.failedElementName = "Booking-BookedBy2";
//			String optionXpath = "" + bookedby1 + "')]";
//			WebElement option = driver.findElement(By.xpath(optionXpath));
//			option.click();
		}		
//Page object for Select Project dropdown
		

		public void getselectproject(String selectproject) throws InterruptedException {
			driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[3]/mat-form-field/div[1]/div[2]/div/mat-select")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option[5]")).click();
			base.failedElementName = "Booking-SelectProject2";
		}
//Page object for Reset button
		By resetfilter=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[5]/button");
		public WebElement getresetfilter() {
			return driver.findElement(resetfilter);
		
}
}