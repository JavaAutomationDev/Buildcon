package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class inquiryformnew {

	public WebDriver driver;

	public inquiryformnew(WebDriver driver) {
		this.driver = driver;
	}
	
	//page object model for inquiry click
	By inquirys = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav[1]"
			+ "/div/vex-sidenav/div/vex-scrollbar/div[1]/div[2]/div/div/div/div[1]/vex-sidenav-item[14]/a/span");
	public WebElement getinquirynewform() {
		return driver.findElement(inquirys);
	}

	// page object model for visitor name
	By visitorname = By.xpath(
			"/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-inquiry-form"
					+ "/div/div[2]/div/form/div[1]/div[2]/mat-form-field/div[1]/div[2]/div[2]/input");

	public WebElement getvisitor() {
		return driver.findElement(visitorname);
	}

	
	// page object model for visite/site project
	By visitesiteproject = By.xpath("//mat-select[@formcontrolname='projectID']");

	// Method to select an option from the dropdown
	public void selectSiteProject(String siteProjectName) {
		driver.findElement(visitesiteproject).click(); // Click to open dropdown
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/div/mat-option"));
		
		for(int i=0;i<elements.size();i++) {
			String text = elements.get(i).getText();
			if (text.equalsIgnoreCase(siteProjectName)) {
				int a = i+1;
				driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/mat-option["+a+"]")).click();
				break;
			}
		}
	}
}
