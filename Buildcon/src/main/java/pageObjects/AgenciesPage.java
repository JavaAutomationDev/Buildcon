package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgenciesPage {
	public WebDriver driver;

	public AgenciesPage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Add Agency
	By addagencies = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
			+ "main/vex-agencies/div/div[1]/div[2]/button");
	public WebElement getAddAgencies() {
		return driver.findElement(addagencies);
	}

	//Page object for Company Name
	By companyname=By.xpath("//input[@formcontrolname='agencyName']");
	public WebElement getCompanyName() {
		return driver.findElement(companyname);
	}

	//Page object for Agency Short Name
	By agencyshortname=By.xpath("//input[@formcontrolname='agencyShortName']");
	public WebElement getAgencyShortName() {
		return driver.findElement(agencyshortname);
	}
	//Page object for Account Name
	By accountname=By.xpath("//input[@formcontrolname='accountName']");
	public WebElement getAccountName() {
		return driver.findElement(accountname);
	}
	//Page object for GST Number
	By gstnumber=By.xpath("//input[@formcontrolname='gstNo']");
	public WebElement getGSTNumber() {
		return driver.findElement(gstnumber);
	}
	//Page object for CIN Number
	By cinnumber=By.xpath("//input[@formcontrolname='cin']");
	public WebElement getcinnumber() {
		return driver.findElement(cinnumber);
	}
	//Page object for Subscription Start Date
	public WebElement getSubscriptionStartDate() {
		WebElement nextstartdate = driver.findElement(By.xpath("//input[@formcontrolname='subscriptionStartDate']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		Date today = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(today);
		nextstartdate.sendKeys(formattedDate);
		return nextstartdate;
	}	
	//Page object for Subscription End Date
	public WebElement getSubscriptionEndDate() {
		WebElement nextenddate = driver.findElement(By.xpath("//input[@formcontrolname='subscriptionEndDate']"));
		Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.DAY_OF_MONTH, 12);
	    Date tommorow = calendar.getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/Mm/yyyy");
	    String formattedDate =  formatter.format(tommorow);
	    nextenddate.sendKeys(formattedDate);
	    return nextenddate;
	}
	//Page object for Subscription Start Date Reset button
	By startresetbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/"
			+ "mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[6]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle[2]/button");
	public WebElement getStartResetBtn() {
		return driver.findElement(startresetbtn);
	}
	//Page object for Subscription End Date Reset button
	By endresetbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-agency/div/div[2]/div/"
			+ "mat-vertical-stepper/div[1]/div/div/div/form/div[1]/div/div[7]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle[2]/button");
	public WebElement getendresetbtn() {
		return driver.findElement(endresetbtn);
	}
	//Page object for Unit Allocate
	By allocatedUnits=By.xpath("//input[@formcontrolname='allocatedUnits']");
	public WebElement getAllocatedUnits() {
		return driver.findElement(allocatedUnits);
	}
	//Page object for Email
	By email=By.xpath("//input[@formcontrolname='companyEmail']");
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	//Page object for Address Line 1
	By addressline1=By.xpath("//input[@formcontrolname='addressLine1']");
	public WebElement getAddressLine1() {
		return driver.findElement(addressline1);
	}
	//Page object for Address Line 2
	By addressline2=By.xpath("//input[@formcontrolname='addressLine2']");
	public WebElement getAddressLine2() {
		return driver.findElement(addressline2);
	}
	//Page object for City
	By city=By.xpath("//input[@formcontrolname='city']");
	public WebElement getCity() {
		return driver.findElement(city);
	}
	//Page object for State
	By state= By.xpath("//mat-select[@formcontrolname='state']");
	public void getstate(String State) {
		WebElement dropdown = driver.findElement(state);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + State + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}

	//Page object for Pincode
	By pincode=By.xpath("//input[@formcontrolname='pinCode']");
	public WebElement getPincode() {
		return driver.findElement(pincode);
	}
	//Page object for Mobile No
	By mobileno=By.xpath("//input[@formcontrolname='companyMobileNo']");
	public WebElement getMobileNo() {
		return driver.findElement(mobileno);
	}
	//Page object for Company Logo
	By companylogo=By.xpath("//button[@id='undefined']");
	public WebElement getCompanyLogo() {
		return driver.findElement(companylogo);
	}
	//Page object for Next Btn
	By nextbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/"
				+ "main/vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div[2]/button[2]");
	public WebElement getNextBtn() {
		return driver.findElement(nextbtn);
	}
	
	//Company Admin Details
	//Page object for Admin First Name
	By adminfirstname=By.xpath("//input[@formcontrolname='adminFirstName']");
    public WebElement getAdminFirstName() {
	    return driver.findElement(adminfirstname);
    }
    //Page object for Admin Middle Name
  	By adminmiddlename=By.xpath("//input[@formcontrolname='adminMiddleName']");
    public WebElement getAdminMiddleName() {
  	    return driver.findElement(adminmiddlename);
    }
    //Page object for Admin Middle Name
    By adminlastname=By.xpath("//input[@formcontrolname='adminLastName']");
    public WebElement getAdminLastName() {
        return driver.findElement(adminlastname);
    }
    //Page object for Admin Mobile No
    By adminmobile=By.xpath("//input[@formcontrolname='adminMobileNo']");
    public WebElement getAdminMobile() {
        return driver.findElement(adminmobile);
    }
    //Page object for Admin Email
    By adminemail=By.xpath("//input[@formcontrolname='adminEmail']");
    public WebElement getAdminemail() {
        return driver.findElement(adminemail);
    }
    //Page object for Admin Designation
    By admindesignation=By.xpath("//input[@formcontrolname='adminDesignation']");
    public WebElement getAdminDesignation() {
        return driver.findElement(admindesignation);
    }
    //Page object for Next Btn1
    By nextbtn1=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
    		+ "vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div[2]/button[2]");
    public WebElement getNextBtn1() {
	    return driver.findElement(nextbtn1);
    }
    
    //Module Access
    //Page object for Modules 
    By modules=By.xpath("//mat-select[@formcontrolname='modules']");
    public void getModules(String Modules) {
        WebElement dropdown=driver.findElement(modules);
        dropdown.click();
        
        String optionXPath = "//mat-option//span[contains(text(),'" + Modules + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
		dropdown.sendKeys(Keys.ESCAPE);
    }
    //Page object for Create Btn
    By createbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
    		+ "vex-add-agency/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div[2]/button[2]");
    public WebElement getCreateBtn() {
        return driver.findElement(createbtn);
    }
}