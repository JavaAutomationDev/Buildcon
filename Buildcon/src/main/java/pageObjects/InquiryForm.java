package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InquiryForm {
	public WebDriver driver;

	public InquiryForm(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for click Inquiry form module
	By Inquiryform = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav[1]/div/vex-sidenav/div/vex-scrollbar/"
			+ "div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[14]/a");
	public WebElement getInquiry() {
		return driver.findElement(Inquiryform);
	}

	//Page object for Visit site/project
	By siteProject = By.xpath("//mat-select[@formcontrolname='projectID']");
	public void getsiteproject(String siteproject) {
        WebElement dropdown = driver.findElement(siteProject);
        dropdown.click();
        String optionXPath = "//mat-option//span[contains(text(),'" + siteproject + "')]";
        WebElement option = driver.findElement(By.xpath(optionXPath));
        option.click();        
    }

	//Page object for Visitor Name
	By visitor = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout"
			+ "/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-form"
			+ "/div/div[2]/div/form/div[1]/div[2]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getvisitor() {
		return driver.findElement(visitor);
	}

	//Page object for Attendee
	  By Attendee =By.xpath("//mat-select[@formcontrolname='userID']");
	  public WebElement getAttendee() {
		  return driver.findElement(Attendee); }
	 

	//Page object for Contact Number
	By ContactNo = By.xpath("//input[@formcontrolname='visitorMobile']");
	public WebElement getContactNo() {
		return driver.findElement(ContactNo);
	}

	//Page object for Visitor Email
	By Email = By.xpath("//input[@formcontrolname='visitorEmail']");
	public WebElement getEmail() {
		return driver.findElement(Email);
	}

	//Page object for Source
	By source = By.xpath("//mat-select[@formcontrolname='sourceID']"); 
	public WebElement getsource() { 
		return driver.findElement(source); 
	}

	//Page object for Save Button
	By save = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-inquiry-form/div/div[2]/div/form/div[2]/button");
	public WebElement getsave() {
		return driver.findElement(save);
	}
}