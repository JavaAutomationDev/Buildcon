package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectfilterDatesPage {
	public WebDriver driver;

	public SelectfilterDatesPage(WebDriver driver) {
		this.driver = driver;
	}

	//Page object for select Start Date and End Date
	public WebElement getSelectDateRange(String startdate, String Enddate) throws InterruptedException {
		String btn1="/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]";
		driver.findElement(By.xpath(btn1)).click();
		Thread.sleep(2000);

		//Start Year Select
		String[] YearParts = startdate.split("/");
		String Year = YearParts[2];
		String Yearxpath="//span[normalize-space()='"+Year+"']";
		WebElement YearField = driver.findElement(By.xpath(Yearxpath));
		YearField.click();

		//Start Date
		String[] MonthParts = startdate.split("/");
		String Month = MonthParts[1];
		String Monthxpath="//span[normalize-space()='"+Month+"']";
		driver.findElement(By.xpath(Monthxpath)).click();		

		//Open Start Date Picker
		String[] DayParts = startdate.split("/");
		String Day = DayParts[0];
		String Dayxpath="//span[normalize-space()='"+Day+"']";
		WebElement startDateField = driver.findElement(By.xpath(Dayxpath));
		startDateField.click();

		//End Date
		String btn3="/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]";
		driver.findElement(By.xpath(btn3)).click();
		Thread.sleep(2000);

		//End Year Select
		String[] YearParts2 = Enddate.split("/");
		String Year2 = YearParts2[2];
		String Yearxpath2="//span[normalize-space()='"+Year2+"']";
		WebElement YearField2 = driver.findElement(By.xpath(Yearxpath2));
		YearField2.click();

		String[] MonthParts2 = Enddate.split("/");
		String Month2 = MonthParts2[1];
		String Monthxpath2="//span[normalize-space()='"+Month2+"']";
		driver.findElement(By.xpath(Monthxpath2)).click();

		//Open End Date Picker
		String[] DayParts2 = Enddate.split("/");
		String Day2 = DayParts2[0];
		String Dayxpath2="//span[normalize-space()='"+Day2+"']";
		WebElement endDateField = driver.findElement(By.xpath(Dayxpath2));
		endDateField.click();
		return endDateField;
	}
}