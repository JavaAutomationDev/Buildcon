package pageObjects;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import resources.base;

//Test1

public class BookingPage {
	public WebDriver driver;
	public boolean flag;

	public BookingPage(WebDriver driver) {
		this.driver = driver;
	}

	// page object for click Booking module ***
	By booking = By.xpath("//vex-sidenav-item[5]//a[1]");

	public WebElement getBooking() {
		return driver.findElement(booking);
	}

	// page object for Add New Booking ***
	By addbooking = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/button");

	public WebElement AddBooking() {
		return driver.findElement(addbooking);
	}

	// *************** Booking Details ***************

	// page object for Project Name ***
	By SelectProjectname = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[1]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public void getProjectName(String projectname) {
		try {
			WebElement dropdown = driver.findElement(SelectProjectname);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(projectname)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + projectname);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + projectname);
			e.printStackTrace();
		}
	}

	// page object for Select Unit/Block ***
//	By SelectUnitBlock = By.xpath(
//			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[2]/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	By SelectUnitBlock = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[2]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public void getUnitBlock(String unitblock) {
		try {
			WebElement dropdown = driver.findElement(SelectUnitBlock);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(unitblock)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + unitblock);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + unitblock);
			e.printStackTrace();
		}
	}

	// page object for Select Flat/Shop ***
//	By SelectFlatShop = By.xpath(
//			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[3]/div/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	By SelectFlatShop = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[3]/div/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public void getFlatShop(String flatshop) {
		try {
			WebElement dropdown = driver.findElement(SelectFlatShop);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(flatshop)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + flatshop);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + flatshop);
			e.printStackTrace();
		}
	}

	// page object for BookedBy ***
	By SelectBookedBy = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[4]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public void getBookedBy(String bookedby) {
		try {
			WebElement dropdown = driver.findElement(SelectBookedBy);
			dropdown.click();
			Thread.sleep(2000);

			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(bookedby)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + bookedby);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + bookedby);
			e.printStackTrace();
		}
	}

	// page object for Booking Date ***
	public void BookingDate() {
		Calendar currentDate = Calendar.getInstance();
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		int month = currentDate.get(Calendar.MONTH) + 1; // Months are zero-based
		int year = currentDate.get(Calendar.YEAR);
		String currentDateString = day + "/" + month + "/" + year;
		driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[5]/mat-form-field/div[1]/div[2]/div[2]/input"))
				.sendKeys(currentDateString);
		base.failedElementName = "Booking-BookingDate";
	}

	// page object for Payment Plan ***
	By SelectPaymentPlan = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[6]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public void getPaymentPlan(String paymentplan1) {
		try {
			WebElement dropdown = driver.findElement(SelectPaymentPlan);
			dropdown.click();
			Thread.sleep(2000);

			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(paymentplan1)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + paymentplan1);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + paymentplan1);
			e.printStackTrace();
		}
	}

	// page object for Car Parking ***
	By CarParking = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[7]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getCarParking() {
		base.failedElementName = "Booking-CarParking";
		return driver.findElement(CarParking);
	}

	// page object for Notes ***
	By Notes = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[12]/mat-form-field/div[1]/div[2]/div[2]/textarea");

	public WebElement getNotes() {
		base.failedElementName = "Booking-BookingDate";
		return driver.findElement(Notes);
	}

	// page object for Booking Status ***
	By SelectBookingStatus1 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[13]/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public void BookingStatus(String bookingstatus) {
		try {
			WebElement dropdown = driver.findElement(SelectBookingStatus1);
			dropdown.click();
			Thread.sleep(2000);

			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(bookingstatus)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + bookingstatus);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + bookingstatus);
			e.printStackTrace();
		}
	}

	// page object for Reference ***
	By Reference = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[14]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getReference() {
		base.failedElementName = "Booking-Referance";
		return driver.findElement(Reference);
	}

	// page object for Unit Basic Cost ***
	By UnitBasicCost = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[15]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getUnitBasicCost() {
		base.failedElementName = "Booking-UnitBasicCost";
		return driver.findElement(UnitBasicCost);
	}

	// page object for Development And Other Charges ***
	By DevAndOtherCharges = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[16]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getDevAndOtherCharges() {
		base.failedElementName = "Booking-DevAndOtherCharges";
		return driver.findElement(DevAndOtherCharges);
	}

	// page object for Sale Value ***
	By SaleValue = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[17]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement SaleValue() {
		base.failedElementName = "Booking-SaleValue";
		return driver.findElement(SaleValue);
	}

	// ************ Add Customer **************
	// Page object for Next button(First Button)
	By Nextbtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextbtn() {
		return driver.findElement(Nextbtn);
	}

	// Page object for Next button(Edit Time)
	By NextbtnEditTime = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button");

	public WebElement GetNextbtnEditTime() {
		return driver.findElement(NextbtnEditTime);
	}

	// Page object for Next button(Edit Time 1)
	By NextbtnEditTime1 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");

	public WebElement GetNextbtnEditTime1() {
		return driver.findElement(NextbtnEditTime1);
	}

	// Page object for Next button(Edit Time) Broker Details
	By NextbtnEditTime2 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[2]");

	public WebElement GetNextbtnEditTime2() {
		return driver.findElement(NextbtnEditTime2);
	}

	// Page object for Previous button(Edit Time)
	By PreviousButton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[1]");

	public WebElement GetPreviousButton() {
		return driver.findElement(PreviousButton);
	}

	// Page object for Previous button(Edit Time)
	By PreviousButton1 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[1]");

	public WebElement GetPreviousButton1() {
		return driver.findElement(PreviousButton1);
	}

	// Page object for Previous Button(Edit Time) Add Customer
	By PreviousButton2 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[1]");

	public WebElement GetPreviousButton2() {
		return driver.findElement(PreviousButton2);
	}

	// ************* Add Customer *************
	// page object for Name ***
	By Name = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getName() {
		base.failedElementName = "Booking-CustomerName";
		return driver.findElement(Name);
	}

	// page object for Profession ***
//	By SelectProfession = By.xpath(
//			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[2]/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	By SelectProfession = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[2]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public void getProfession(String profession) {
		try {
			WebElement dropdown = driver.findElement(SelectProfession);
			dropdown.click();
			Thread.sleep(2000);

			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(profession)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + profession);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + profession);
			e.printStackTrace();
		}
	}

	// Page object for Birth date ***
	By BirthDate1 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[3]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");

	public WebElement getBirthDate1() {
		base.failedElementName = "Booking-BirthDate";
		return driver.findElement(BirthDate1);
	}

	// Page object for select Start Date and End Date ***
	public WebElement getSelectSingleDate(String startdate) throws InterruptedException {
		String btn1 = "/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]";
		driver.findElement(By.xpath(btn1)).click();
		Thread.sleep(2000);

		// Start Year Select
		String[] YearParts = startdate.split("/");
		String Year = YearParts[2];
		String Yearxpath = "//span[normalize-space()='" + Year + "']";
		WebElement YearField = driver.findElement(By.xpath(Yearxpath));
		YearField.click();

		// Start Date
		String[] MonthParts = startdate.split("/");
		String Month = MonthParts[1];
		String Monthxpath = "//span[normalize-space()='" + Month + "']";
		driver.findElement(By.xpath(Monthxpath)).click();

		// Open Start Date Picker
		String[] DayParts = startdate.split("/");
		String Day = DayParts[0];
		String Dayxpath = "//span[normalize-space()='" + Day + "']";
		WebElement startDateField = driver.findElement(By.xpath(Dayxpath));
		startDateField.click();
		return startDateField;
	}

	// Page object for PAN No. ***
	By PAN = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[5]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getPAN() {
		base.failedElementName = "Booking-PanNo";
		return driver.findElement(PAN);
	}

	// Page object for Aadhar card Number No ***
	By AadharNo = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[6]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getAadharNo() {
		base.failedElementName = "Booking-AadharNo";
		return driver.findElement(AadharNo);
	}

	// Page object for Mobile No ***
	By MobileNo = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[8]/mat-form-field/div[1]/div[2]/div/ngx-intl-tel-input/div/input");

	public WebElement getMobileNo() {
		base.failedElementName = "Booking-MobileNo";
		return driver.findElement(MobileNo);
	}

	// Page object for Other No ***
	By OtherNo = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[9]/mat-form-field/div[1]/div[2]/div/ngx-intl-tel-input/div/input");

	public WebElement getOtherNo() {
		base.failedElementName = "Booking-OtherNo";
		return driver.findElement(OtherNo);
	}

	// Page object for Email ***
	By Email = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[10]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getEmail() {
		base.failedElementName = "Booking-EMail";
		return driver.findElement(Email);
	}

	// Page object Address Permanent Address ***
	By PermanentAddress = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[11]/mat-form-field/div[1]/div[2]/div[2]/textarea");

	public WebElement getPermanentAddress() {
		base.failedElementName = "Booking-PermanentAddress";
		return driver.findElement(PermanentAddress);
	}

	// Page object Address Office Address ***
	By OfficeAddress = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[12]/mat-form-field/div[1]/div[2]/div[2]/textarea");

	public WebElement getOfficeAddress() {
		base.failedElementName = "Booking-OfficeAddress";
		return driver.findElement(OfficeAddress);
	}

	// Page object Address Remarks ***
	By Remarks = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[13]/mat-form-field/div[1]/div[2]/div[2]/textarea");

	public WebElement getRemarks() {
		base.failedElementName = "Booking-Remark";
		return driver.findElement(Remarks);

	}

	// Page object for Anniversary Date ***
	By AnniversaryDate = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[14]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");

	public WebElement getAnniversarydate1() {
		base.failedElementName = "Booking-AnniversaryDate";
		return driver.findElement(AnniversaryDate);
	}

	// Page object Customer Files ***
	By custfile = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[15]/mat-form-field/div[1]/div[2]/div[2]/input[2]");

	public WebElement getcustfile() {
		return driver.findElement(custfile);
	}

	// Page object Next button(Second Button) ***
	By Nextbtn2 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextbtn2() {
		return driver.findElement(Nextbtn2);
	}

	// ***************** Broker Details *****************
	// Page Object IS Broker button ***
	By isBroker = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[1]/"
					+ "mat-form-field/div[1]/div[2]/div[2]/mat-checkbox/div/div/input");

	public WebElement getisBroker() {
		base.failedElementName = "Booking-isBroker";
		return driver.findElement(isBroker);
	}

	// Page object Broker Name ***
	By BrokerName = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getBrokerName() {
		return driver.findElement(BrokerName);
	}

	// Page object Broker Amount ***
	By BrokerAmount = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[2]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getBrokerAmount() {
		return driver.findElement(BrokerAmount);
	}

	// Page object Brokering Company ***
	By BrokeringCompany = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[3]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getBrokeringCompany() {
		return driver.findElement(BrokeringCompany);
	}

	// Page object Broker Mobile No ***
	By BrokerMobileNo = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[4]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getBrokerMobileNo() {
		return driver.findElement(BrokerMobileNo);
	}

	// Page object Broker File(s) ***
	By brokeruplaodfile = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[5]/mat-form-field/div[1]/div[2]/div[2]/input[2]");

	public WebElement getbrokeruplaodfile() {
		return driver.findElement(brokeruplaodfile);
	}

	// Page object Next button (Third Button) ***

	By getNextbtn3 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]"
					+ "/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextbtn3() {
		return driver.findElement(getNextbtn3);
	}

	// **************** Bank Loan Details ****************
	// Page object Bank Loan Details ***
//	By SelectBankName = By.xpath(
//			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[1]/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	By SelectBankName = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[1]/div/div[1]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public void BankName(String bankname) {
		try {
			WebElement dropdown = driver.findElement(SelectBankName);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(bankname)) {
					option.click();
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Option not found: " + bankname);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + bankname);
			e.printStackTrace();
		}
	}

	// Page object Loan Amount Details ***
	By Loanamt = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[1]/div/div[2]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getLoanamt() {
		base.failedElementName = "Booking-LoanAmt";
		return driver.findElement(Loanamt);
	}

	// Page object Branch Details ***
	By Branch = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[1]/div/div[3]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getBranch() {
		base.failedElementName = "Booking-LoanBranch";
		return driver.findElement(Branch);
	}

	// Page object Loan Account Number Details ***
	By loadnacno = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[1]/div/div[4]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getloadnacno() {
		base.failedElementName = "Booking-LoanAcNo";
		return driver.findElement(loadnacno);
	}

	// Page object City Details ***
	By City = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[1]/div/div[5]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getCity() {
		base.failedElementName = "Booking-LoanCity";
		return driver.findElement(City);
	}

	// Click on Book/HOLD
	public void getBookbtn() {
		driver.findElement(By.xpath(
				"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]"
						+ "/div/mat-vertical-stepper/div[4]/div/div/div/form/div[2]/button[2]"))
				.click();
	}

	// Page object for Edit button ***
	By Edit = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[3]/div/div/table/tbody/tr/td[12]/div/a[1]");

	public WebElement getEdit() {
		return driver.findElement(Edit);
	}

	// Click on Update button ***
	By Update = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[2]/button[2]");

	public WebElement getUpdate() {
		return driver.findElement(Update);
	}

	// Page object for Cancel booking button from grid ***
	By Cancelbooking = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[3]/div/div/table/tbody/tr/td[12]/div/a[2]");

	public WebElement getCancelbooking() {
		base.failedElementName = "Booking-CancelBooking";
		return driver.findElement(Cancelbooking);
	}

	// Page object for Reason ***
	By Reason = By.xpath("//input[@formcontrolname='reason']");

	public WebElement getReason() {
		base.failedElementName = "Booking-CancelBookingReason";
		return driver.findElement(Reason);
	}

	// Click on Agreement to Sale Received checkbox ***
	By AgreementSaleRcvd = By.xpath("//input[@class='mdc-checkbox__native-control']");

	public WebElement getAgreementSaleRcvd() {
		base.failedElementName = "Booking-AgreementSaleRecd";
		return driver.findElement(AgreementSaleRcvd);
	}

	// Click on Cancel Booking button Inisde in popup ***
	By CancelBooking2 = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-confirm-modal/form/mat-dialog-actions/button");

	public WebElement getCancelBooking2() {
		return driver.findElement(CancelBooking2);
	}

	// Click on the Yes/No button Inisde in popup ***
	By Yesbutton = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]");

	public WebElement getYesbutton() {
		return driver.findElement(Yesbutton);
	}

	// Page object for all documents/Option button ***
	By BookingOption = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[3]/div/div/table/tbody/tr/td[12]/div/button");

	public WebElement getBookingOption() {
		base.failedElementName = "Booking-BookingOption";
		return driver.findElement(BookingOption);
	}

	// Click on the Documentation Details ***
	By DocumentationDetails = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[1]");

	public WebElement getDocumentationDetails() {
		base.failedElementName = "Booking-DocumentationDetails";
		return driver.findElement(DocumentationDetails);
	}

	// Page object for Agreement Number ***
	By AgreementNumber = By.xpath("//input[@formcontrolname='agreementNumber']");

	public WebElement getAgreementNumber() {
		base.failedElementName = "Booking-AgreementNo";
		return driver.findElement(AgreementNumber);
	}

	// Page object for Agreement Date ***
	By AgreementDate = By.xpath(
			"/html/body/div[4]/div[4]/div/mat-dialog-container/div/div/vex-legal-entry-popup/form/mat-dialog-content/form/div/mat-form-field[2]/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");

	public WebElement getAgreementDate() {
		base.failedElementName = "Booking-AgreementDate";
		return driver.findElement(AgreementDate);
	}

	// Page object for Sale Deed Number ***
	By SaleDeed = By.xpath("//input[@formcontrolname='saleDeedNumber']");

	public WebElement getSaleDeed() {
		base.failedElementName = "Booking-SaleDeedNo";
		return driver.findElement(SaleDeed);
	}

	// Page object for Sale Deed Date ***
	By SaleDeedDate = By.xpath(
			"/html/body/div[4]/div[4]/div/mat-dialog-container/div/div/vex-legal-entry-popup/form/mat-dialog-content/form/div/mat-form-field[4]/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");

	public WebElement getSaleDeedDate() {
		base.failedElementName = "Booking-SaleDeedDate";
		return driver.findElement(SaleDeedDate);
	}

	// Page object for Save button ***
	By Savebutton = By.xpath(
			"/html/body/div[4]/div[4]/div/mat-dialog-container/div/div/vex-legal-entry-popup/form/mat-dialog-actions/button[2]");

	public WebElement getSavebutton() {
		return driver.findElement(Savebutton);
	}

	// Page object for Agreement Form ***
	By AgreementForm = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[2]");

	public WebElement getAgreementForm() {
		base.failedElementName = "Booking-AgreementForm";
		return driver.findElement(AgreementForm);
	}

	// Page object for Booking Form ***
	By BookingForm = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[3]");

	public WebElement getBookingForm() {
		base.failedElementName = "Booking-BookingForm";
		return driver.findElement(BookingForm);
	}

	// Page object for Inquiry Form ***
	By InquiryForm = By.xpath("/html/body/div[4]/div[2]/div/div/div/div/button[4]");

	public WebElement getInquiryForm() {
		base.failedElementName = "Booking-InquiryForm";
		return driver.findElement(InquiryForm);
	}

	// Page object for Search Booking ***
	By BookingSearch = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/div[1]/input");

	public WebElement getBookingSearch() {
		return driver.findElement(BookingSearch);
	}

	By BookingSearchclick = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main"
					+ "/vex-bookings/div/div[1]/div[2]/div[1]/mat-icon");

	public WebElement getBookingSearchclick() {
		base.failedElementName = "Booking-SearchClick";
		return driver.findElement(BookingSearchclick);
	}

	// Page object for Export to Excel ***
	By ExporttoExcel = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "vex-bookings/div/div[1]/div[2]/div[2]/button");

	public WebElement getExporttoExcel() {
		base.failedElementName = "Booking-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}

	// Page object for Apply Filter ***
	By filter = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[1]/div[2]/div[3]/button");

	public WebElement getapplyfilter() {
		return driver.findElement(filter);
	}

	// Page object for Date Range ***
	By Daterange = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button");

	public WebElement getdaterange() {
		return driver.findElement(Daterange);
	}

	// Page object for Select start Date ***
	By SelectstartDate = By
			.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']");

	public WebElement getSelectstartDate() {
		return driver.findElement(SelectstartDate);
	}

	// Page object for Select Start Date ***
	By SelectstartDate(String startDate1) {
		return By.xpath("//mat-calendar//td//span[contains(text(),'" + startDate1 + "')]");
	}

	// Page object for Select End Date ***
	By selectendDate(String endDate1) {
		return By.xpath("//mat-calendar//td//span[contains(text(),'" + endDate1 + "')]");
	}

	public void getSelectDateRange() {
		Scanner scanner = new Scanner(System.in);
		WebElement startElement = driver.findElement(SelectstartDate(""));
		startElement.click();
		WebElement endElement = driver.findElement(selectendDate(""));
		endElement.click();
	}

	public WebElement getSelectstartDate1(String startDate) {
		return driver.findElement(userstartdate(startDate));
	}

	private By userstartdate(String startDate) {
		return By.xpath("//mat-calendar//td//span[normalize-space(text())='" + startDate + "']");
	}

	// Page object for Select End Date ***
	By selectendDate = By.xpath("//span[normalize-space()='30']");

	public WebElement getSelectEndDate() {
		return driver.findElement(selectendDate);
	}

	// Page object for Select Booked By ***
	By SelectBookedBy1 = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[2]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div/mat-select");

	public void getBookedBy1(String BookedBy) throws InterruptedException {
		try {
			WebElement dropdown = driver.findElement(SelectBookedBy1);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(BookedBy)) {
					option.click();
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Option not found: " + BookedBy);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + BookedBy);
			e.printStackTrace();
		}
	}

	// Page object for Select Project ***
	By SelectProject = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[3]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div/mat-select");

	public void getselectproject(String ProjectName) {
		try {
			WebElement dropdown = driver.findElement(SelectProject);
			dropdown.click();
			Thread.sleep(2000);

			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(ProjectName)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + ProjectName);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + ProjectName);
			e.printStackTrace();
		}
	}

	// Page object for Select Booking Status ***
	By SelectBookingStatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[4]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div/mat-select");

	public void getSelectBookingStatus(String BookingStatus) throws InterruptedException {
		try {
			WebElement dropdown = driver.findElement(SelectBookingStatus);
			dropdown.click();
			Thread.sleep(2000);

			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(BookingStatus)) {
					option.click();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + BookingStatus);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + BookingStatus);
			e.printStackTrace();
		}
	}

	// Page object for Reset button ***
	By resetfilter = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-bookings/div/div[2]/div/div[5]/button");

	public WebElement getresetfilter() {
		return driver.findElement(resetfilter);
	}

	// ****************** In Edit - Mandatory Field ******************
	// Page object for Unit Basic Cost ***
	By EditUnitBasicCost = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[15]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditUnitBasicCost() {
		return driver.findElement(EditUnitBasicCost);
	}

	// Page object for Development And Other Charges ***
	By EditDevelopmentAndOtherCharges = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[16]/mat-form-field");

	public WebElement EditDevelopmentAndOtherCharges() {
		return driver.findElement(EditDevelopmentAndOtherCharges);
	}

	// Page object for BookingDate ***
	By EditBookingDate = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[5]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditBookingDate() {
		return driver.findElement(EditBookingDate);
	}

	// Page object for Customer Name ***
	By EditCustName = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditCustName() {
		return driver.findElement(EditCustName);
	}

	// Page object for Birth Date ***
	By EditBirthDate = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[3]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditBirthDate() {
		return driver.findElement(EditBirthDate);
	}

	// Page object for PAN Number ***
	By EditPANNumber = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[5]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditPANNumber() {
		return driver.findElement(EditPANNumber);
	}

	// Page object for Aadhar Number ***
	By EditAadharNumber = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[6]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditAadharNumber() {
		return driver.findElement(EditAadharNumber);
	}

	// Page object for Mobile Number ***
	By EditMobileNumber = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[8]/mat-form-field/div[1]/div[2]/div/ngx-intl-tel-input/div/input");

	public WebElement GetEditMobileNumber() {
		return driver.findElement(EditMobileNumber);
	}

	// Page object for Email ***
	By EditEmail = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[10]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditEmail() {
		return driver.findElement(EditEmail);
	}

	// Page object for Permanent Address ***
	By EditPermanentAddress = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[11]/mat-form-field/div[1]/div[2]/div[2]/textarea");

	public WebElement GetEditPermanentAddress() {
		return driver.findElement(EditPermanentAddress);
	}

	// Page object for Is Broker ***
	By EditIsBroker = By.xpath("//mat-checkbox[@formcontrolname='isAllowBrokerEntry']");

	public WebElement GetEditIsBroker() {
		return driver.findElement(EditIsBroker);
	}

	// Page object for Broker Name ***
	By EditBrokerName = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[1]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditBrokerName() {
		return driver.findElement(EditBrokerName);
	}

	// Page object for Brokerage Amount ***
	By EditBrokerageAmount = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[2]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditBrokerageAmount() {
		return driver.findElement(EditBrokerageAmount);
	}

	// Page object for Brokering Company ***
	By EditBrokeringCompany = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[3]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditBrokeringCompany() {
		return driver.findElement(EditBrokeringCompany);
	}

	// Page object for Broker Mobile No ***
	By EditBrokerMobileNo = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[1]/div[2]/div[4]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement GetEditBrokerMobileNo() {
		return driver.findElement(EditBrokerMobileNo);
	}

	// Page obejct for click tab ***
	By clicktab = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[2]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select");

	public WebElement Getclicktab() {
		return driver.findElement(clicktab);
	}

	// Edit Active/Inactive Profession ***
	// Page Object for Verify Edit InActive Profession
	public void EditInActiveProfession(String Name) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[2]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select")).click();
		Thread.sleep(1000);
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase(Name.trim())) {
				Assert.assertFalse(false, "Profession is InActive.");
				// System.out.println("Test failed");
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

	// Page Object for Verify Edit Active Profession ***
	public void EditActiveProfession(String Name) {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[1]/div/mat-card/mat-card-content/div[1]/div[2]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase(Name.trim())) {
				Assert.assertFalse(false, "Profession is InActive.");
				// System.out.println("Test failed");
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

	// Page Object for Verify Edit InActive Bank ***
	public void EditInActiveBank(String BankName) {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[1]/div/div[1]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase(BankName.trim())) {
				Assert.assertFalse(false, "Bank is InActive.");
				// System.out.println("Test failed");
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

	// Page Object for Verify Edit Active Bank ***
	public void EditActiveBank(String BankName) {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div[1]/div/div[1]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase(BankName.trim())) {
				Assert.assertFalse(false, "Bank is InActive.");
				// System.out.println("Test failed");
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

	// Page Object for Verify Edit Active Bank ***
	public void AddInActiveProject(String ProjectName) {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[1]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase(ProjectName.trim())) {
				Assert.assertFalse(false, "Project is InActive.");
				// System.out.println("Test failed");
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

	// Page Object for Verify Edit Active Bank ***
	public void AddActiveProject(String ProjectName) {
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[1]/vex-searchable-dropdown/mat-form-field/div[1]/div[2]/div[2]/mat-select")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter = 0;
		for (int i = 0; i < a.size(); i++) {
			String b = a.get(i).getText();
			if (!b.equalsIgnoreCase(ProjectName.trim())) {
				Assert.assertFalse(false, "Project is Active.");
				// System.out.println("Test failed");
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

	// Page object for Page not found
	public boolean NoPageFound() {
		try {
			int t = driver.findElements(By.cssSelector("img[src='../../../../assets/img/no-data-found.png']")).size();

			if (t == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (NoSuchElementException e) {
		}
		return flag;
	}

	// Page object for select Start Date and End Date ***
	public WebElement getSelectAgreementAndSaleDeedDate(String date) throws InterruptedException {
		String btn1 = "/html/body/div[4]/div[6]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]";
		driver.findElement(By.xpath(btn1)).click();
		Thread.sleep(2000);

		// Start Year Select
		String[] YearParts = date.split("/");
		String Year = YearParts[2];
		String Yearxpath = "//span[normalize-space()='" + Year + "']";
		WebElement YearField = driver.findElement(By.xpath(Yearxpath));
		YearField.click();

		// Start Date
		String[] MonthParts = date.split("/");
		String Month = MonthParts[1];
		String Monthxpath = "//span[normalize-space()='" + Month + "']";
		driver.findElement(By.xpath(Monthxpath)).click();

		// Open Start Date Picker
		String[] DayParts = date.split("/");
		String Day = DayParts[0];
		String Dayxpath = "//span[normalize-space()='" + Day + "']";
		WebElement startDateField = driver.findElement(By.xpath(Dayxpath));
		startDateField.click();
		return startDateField;
	}

	// Page object for Back Button Booking***
	By BackButtonBooking = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-booking/div/div[1]/div[2]/button/span[1]");

	public WebElement GetBackButtonBooking() {
		return driver.findElement(BackButtonBooking);
	}

}