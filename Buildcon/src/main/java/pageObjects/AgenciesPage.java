package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class AgenciesPage {
	public WebDriver driver;
	public boolean flag;

	public AgenciesPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page object for click Add Agency
	By addagencies = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-agencies/div/div[1]/div[2]/button");

	public WebElement getAddAgencies() {
		return driver.findElement(addagencies);
	}

	// Page object for Company Name
	By companyname = By.xpath("//input[@formcontrolname='agencyName']");

	public WebElement getCompanyName() {
		return driver.findElement(companyname);
	}

	// Page object for Agency Short Name
	By agencyshortname = By.xpath("//input[@formcontrolname='agencyShortName']");

	public WebElement getAgencyShortName() {
		return driver.findElement(agencyshortname);
	}

	// Page object for Account Name
	By accountname = By.xpath("//input[@formcontrolname='accountName']");

	public WebElement getAccountName() {
		return driver.findElement(accountname);
	}

	// Page object for GST Number
	By gstnumber = By.xpath("//input[@formcontrolname='gstNo']");

	public WebElement getGSTNumber() {
		return driver.findElement(gstnumber);
	}

	// Page object for CIN Number
	By cinnumber = By.xpath("//input[@formcontrolname='cin']");

	public WebElement getcinnumber() {
		return driver.findElement(cinnumber);
	}

	// Page object for Subscription Start Date ***
	By SubscriptionStartDate = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[6]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle[1]/button");

	public WebElement getSubscriptionStartDate() {
		base.failedElementName = "agencies-SubscriptionStartDate";
		return driver.findElement(SubscriptionStartDate);
	}

	// Page object for Subscription End Date ***
	By SubscriptionEndDate = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[7]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle[1]");

	public WebElement getSubscriptionEndDate() {
		base.failedElementName = "agencies-SubscriptionEndDate";
		return driver.findElement(SubscriptionEndDate);
	}

	// Page object for Subscription Start Date Reset button
	By startresetbtn = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/"
			+ "div/form/div[1]/div/div[6]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle[2]/button");

	public WebElement getStartResetBtn() {
		return driver.findElement(startresetbtn);
	}

	// Page object for Subscription End Date Reset button
	By endresetbtn = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div"
			+ "/div/form/div[1]/div/div[7]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle[2]/button");

	public WebElement getendresetbtn() {
		return driver.findElement(endresetbtn);
	}

	// Page object for Unit Allocate
	By allocatedUnits = By.xpath("//input[@formcontrolname='allocatedUnits']");

	public WebElement getAllocatedUnits() {
		return driver.findElement(allocatedUnits);
	}

	// Page object for Email
	By email = By.xpath("//input[@formcontrolname='companyEmail']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	// Page object for Address Line 1
	By addressline1 = By.xpath("//input[@formcontrolname='addressLine1']");

	public WebElement getAddressLine1() {
		return driver.findElement(addressline1);
	}

	// Page object for Address Line 2
	By addressline2 = By.xpath("//input[@formcontrolname='addressLine2']");

	public WebElement getAddressLine2() {
		return driver.findElement(addressline2);
	}

	// Page object for City
	By city = By.xpath("//input[@formcontrolname='city']");

	public WebElement getCity() {
		return driver.findElement(city);
	}

	// Page object for State
	By state = By.xpath("//mat-select[@formcontrolname='state']");

	public void getstate(String State) {
		WebElement dropdown = driver.findElement(state);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + State + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	// Page object for Pincode
	By pincode = By.xpath("//input[@formcontrolname='pinCode']");

	public WebElement getPincode() {
		return driver.findElement(pincode);
	}

	// Page object for Mobile No
	By mobileno = By.xpath("//input[@formcontrolname='companyMobileNo']");

	public WebElement getMobileNo() {
		return driver.findElement(mobileno);
	}

	// Page object for Company Logo
	By companylogo = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[17]/mat-form-field/div[1]/div[2]/div[2]/input[2]");

	public WebElement getCompanyLogo() {
		return driver.findElement(companylogo);
	}

	// Page object for Edit time Company Logo
	By Editcompanylogo = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[17]/mat-form-field/div[1]/div[2]/div[2]/span");

	public WebElement getEditcompanylogo() {
		return driver.findElement(Editcompanylogo);
	}

	// Page object for Agency Favicon
	By AgencyFavicon = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[18]/mat-form-field/div[1]/div[2]/div[2]/input[2]");

	public WebElement getAgencyFavicon() {
		return driver.findElement(AgencyFavicon);
	}

	// Page object for Next Btn
	By nextbtn = By
			.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
					+ "main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextBtn() {
		return driver.findElement(nextbtn);
	}

	// Page object for Edit Time Next Btn
	By Editnextbtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button");

	public WebElement getEditnextbtn() {
		return driver.findElement(Editnextbtn);
	}

	// Company Admin Details
	// Page object for Admin First Name
	By adminfirstname = By.xpath("//input[@formcontrolname='adminFirstName']");

	public WebElement getAdminFirstName() {
		return driver.findElement(adminfirstname);
	}

	// Page object for Admin Middle Name
	By adminmiddlename = By.xpath("//input[@formcontrolname='adminMiddleName']");

	public WebElement getAdminMiddleName() {
		return driver.findElement(adminmiddlename);
	}

	// Page object for Admin Middle Name
	By adminlastname = By.xpath("//input[@formcontrolname='adminLastName']");

	public WebElement getAdminLastName() {
		return driver.findElement(adminlastname);
	}

	// Page object for Admin Mobile No
	By adminmobile = By.xpath("//input[@formcontrolname='adminMobileNo']");

	public WebElement getAdminMobile() {
		return driver.findElement(adminmobile);
	}

	// Page object for Admin Email
	By adminemail = By.xpath("//input[@formcontrolname='adminEmail']");

	public WebElement getAdminemail() {
		return driver.findElement(adminemail);
	}

	// Page object for Admin Designation
	By admindesignation = By.xpath("//input[@formcontrolname='adminDesignation']");

	public WebElement getAdminDesignation() {
		return driver.findElement(admindesignation);
	}

	// Page object for Next Btn1
	By nextbtn1 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");

	public WebElement getNextBtn1() {
		return driver.findElement(nextbtn1);
	}

	// Module Access
	// Page object for Modules
	By SelectModules = By.xpath("//mat-select[@formcontrolname='modules']");

	public void getModules(String ModulesName) {
		try {
			WebElement dropdown = driver.findElement(SelectModules);
			dropdown.click();
			Thread.sleep(2000);
			List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("mat-option"));
			boolean found = false;
			for (WebElement option : dropdownOptions) {
				String optionText = option.getText().trim();
				if (optionText.equals(ModulesName)) {
					option.click();
					dropdown.sendKeys(Keys.ESCAPE);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + ModulesName);
			}
		} catch (Exception e) {
			System.out.println("Error selecting option: " + ModulesName);
			e.printStackTrace();
		}

	}

	// Page object for Create Btn
	By createbtn = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
					+ "vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[2]");

	public WebElement getCreateBtn() {
		return driver.findElement(createbtn);
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

	// Page object for Search Data
	By SearchAgency = By.xpath("//input[@type=\"search\"]");

	public WebElement getSearchAgency() {
		return driver.findElement(SearchAgency);
	}

	// Page object for Edit Button
	By EditButton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-agencies/div/div[2]/div/div/table/tbody/tr/td[10]/div/a[3]/span[4]");

	public WebElement getEditButton() {
		return driver.findElement(EditButton);
	}

	// Page object for Cross Icon
	By CrossIcon = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[17]/mat-form-field/div[1]/div[2]/div[2]/button/mat-icon");

	public WebElement getCrossIcon() {
		return driver.findElement(CrossIcon);
	}

	// Page object for Delete button
	By DeleteButton = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-agencies/div/div[2]/div/div/table/tbody/tr/td[10]/div/a[4]/span[4]");

	public WebElement getDeleteButton() {
		return driver.findElement(DeleteButton);
	}

	// Page object for Yes button
	By YesButton = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[1]/span[2]");

	public WebElement getYesButton() {
		return driver.findElement(YesButton);
	}

	// Page object for No button
	By NoButton = By.xpath(
			"/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up/form/mat-dialog-actions/button[2]/span[4]");

	public WebElement getNoButton() {
		return driver.findElement(NoButton);
	}

	// Page object for Change status
	By ChangeStatus = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-agencies/div/div[2]/div/div/table/tbody/tr/td[10]/div/a[2]");

	public WebElement getChangeStatus() {
		return driver.findElement(ChangeStatus);
	}

	// Page object for Change status
	By GenerateURL = By.xpath("//a[@mattooltip=\"Generate URL\"]");

	public WebElement getGenerateURL() {
		return driver.findElement(GenerateURL);
	}

	// Page object for Change status
	By AgencyURLCrossIcon = By
			.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/div/div/button/mat-icon");

	public WebElement getAgencyURLCrossIcon() {
		return driver.findElement(AgencyURLCrossIcon);
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

}