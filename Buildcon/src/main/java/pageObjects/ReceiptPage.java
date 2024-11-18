package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import resources.base;

public class ReceiptPage {
	public WebDriver driver;

	public ReceiptPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page object for Receipt Module
	By receipt = By.xpath("//vex-sidenav-item[7]//a[1]");
	public WebElement getReceipt() {
		base.failedElementName = "Receipt-ClickMenu";
		return driver.findElement(receipt);
	}
	//Page object for Add Receipt
	By Addreceipt = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/button");
	public WebElement getAddReceipt() {
		base.failedElementName = "Receipt-ClickAdd";
		return driver.findElement(Addreceipt);
	}

	//Customer Details
	//Page object for Project
	By project = By.xpath("//mat-select[@formcontrolname='projectID']");
	public void getProject(String Project) {
		WebElement dropdown = driver.findElement(project);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Receipt-getproject";
		
		if(Project.trim()=="")
		{
			List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
			for(int i=0;i<a.size();i++)
			{
				String b =a.get(i).getText(); 
				if(!b.equalsIgnoreCase(Project))
				{
					Assert.assertTrue(false, "Project name is required");
				}
			}
		}
		String optionXPath = "//mat-option//span[contains(text(),'" + Project + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	
	//Page object for Customer
	By customer= By.xpath("//mat-select[@formcontrolname='memberID']");
	public void getCustormer(String CustomerName) {
		WebElement dropdown=driver.findElement(customer);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Receipt-getcustomer";
		
		String optionXpath="//mat-option//span[contains(text(),'" + CustomerName + "')]";
		WebElement option=driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	//Page object for Select Flat/Shop
	By flatshop = By.xpath("//mat-select[@formcontrolname='projectUnitBlockDetailsID']");
	public void getFlatShop(String FlatShop) {
		WebElement dropdown = driver.findElement(flatshop);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Receipt-getFlatShop";
		
		String optionXpath = "/html/body/div[4]/div[2]/div/div/mat-option/span";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for Payment Date 
	public WebElement paymentdate() {
		WebElement paymentdateElement = driver.findElement(By.xpath("//input[@formcontrolname='paymentDate']"));
		  Calendar calendar = Calendar.getInstance();
		    calendar.add(Calendar.DAY_OF_MONTH, +4);
		    Date futureDate = calendar.getTime();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    String formattedDate = formatter.format(futureDate);
		    paymentdateElement.clear();
		    paymentdateElement.sendKeys(formattedDate);
		return paymentdateElement;
	}
	
	//Page object for Calendar click
	By calendarclick=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[1]/div[3]/div/div[2]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");
	public WebElement getCalendarClick() {
		return driver.findElement(calendarclick);
	}
	//Page object for date selection
	By dateselect=By.xpath("/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-month-view/table/tbody/tr[2]/td[5]/button/span[1]");
	public WebElement getDateSelect() {
		return driver.findElement(dateselect);
	}
	//Page object for Next Btn
	By nextbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[2]/button[2]");
	public WebElement getNextBtn() {
		base.failedElementName = "Receipt-NextBtn";
		return driver.findElement(nextbtn);
	}

	//Regular Bank Details
	//Page object for Regular Bank Name
	By bankname = By.xpath("//mat-select[@formcontrolname='rBankID']");
	public void getBankName(String BankName) {
		WebElement dropdown = driver.findElement(bankname);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Receipt-getBankName";
		
		List<WebElement> options = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		for(int i=0;i<options.size();i++) {
			String text = options.get(i).getText();
			if (text.equalsIgnoreCase(BankName)) {
				int a = i+1;
				driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option["+a+"]")).click();
				break;
			}
		}
	}

	//Page object for Regular Bank Branch
	By bankbranch =By.xpath("//input[@formcontrolname='rBranchName']");
	public WebElement getBankBranch() {
		base.failedElementName = "Receipt-BankBranch";
		return driver.findElement(bankbranch);
	}
	//page object for Payment Type
	By paymenttype=By.xpath("//mat-select[@formcontrolname='paymentTypeId']");
	public void getPaymentType(String PaymentType) {
		WebElement dropdown = driver.findElement(paymenttype);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Receipt-getPaymentType";
		
		String optionXpath="//mat-option//span[contains(text(),'" + PaymentType + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	//page object for IMPS No
	By Impsno=By.xpath("//input[@formcontrolname='rChequeNo']");
	public WebElement getIMPSNO() {
		base.failedElementName = "Receipt-IMPSNo";
		return driver.findElement(Impsno);
	}
	//Page object for Regular Cheque/Tran. Date
	By regularchequetrandate =By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div/form/div[1]/div/div[3]/div[1]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");
	public WebElement getRegularChequeTranDate() {
		base.failedElementName = "Receipt-ChequeDate";
		return driver.findElement(regularchequetrandate);
	}
	//Page object for Cheque Calendar date
	By checquedate=By.xpath("/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-month-view/table/tbody/tr[2]/td[5]/button/span[1]");
	public WebElement getChecqueDate() {
		return driver.findElement(checquedate);
	}

	//Page object for Regular Amount
	By regularamount =By.xpath("//input[@formcontrolname='rAmount']");
	public WebElement getRegularAmount() {
		base.failedElementName = "Receipt-Amount";
		return driver.findElement(regularamount);
	}
	//Page object for Regular Bank Cancelled
	By regularbankcancelled =By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div/form/"
			+ "div[1]/div/div[4]/div[1]/div/mat-form-field/div[1]/div[2]/div[2]/mat-checkbox/div/div/input");
	public WebElement getRegularBankCancelled() {
		base.failedElementName = "Receipt-BankCancelled";
		return driver.findElement(regularbankcancelled);
	}
	//Page object for GST Applicable
	By gstapplicable=By.xpath("//input[@placeholder='GST Apllicable']");
	public WebElement getGSTNO() {
		base.failedElementName = "Receipt-GSTApplicable";
		return driver.findElement(gstapplicable);
	}

	//Page object for Next Btn1
	By nextbtn1=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div/form/div[2]/button[2]");
	public WebElement getNextBtn1() {
		base.failedElementName = "Receipt-NextBtn1";
		return driver.findElement(nextbtn1);
	}

	//TDS Bank Details
	//Page object for TDS Challan Number 
	By TDSchallannumber=By.xpath("//input[@formcontrolname='tChequeNo']");
	public WebElement getTDSChallanNumber() {
		base.failedElementName = "Receipt-TDSChallanNo";
		return driver.findElement(TDSchallannumber);
	}

	public WebElement challandate() {
		WebElement challandateElement = driver.findElement(By.xpath("//input[@formcontrolname='tChequeTranDate']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,0);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		challandateElement.sendKeys(formattedDate);
		base.failedElementName = "Receipt-ChallanDate";
		return challandateElement;
	}
	
	//Page object for Challan Date
//	By challandate=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div/form/div[1]/div/div[1]/div[2]/mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");
//	public WebElement challandate() {
//        return driver.findElement(challandate);		
//	}
	//Page object for date selection
	//By selectdate=By.xpath("/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-month-view/table/tbody/tr[3]/td[5]/button/span[1]");
	//public WebElement getSelectDate() {
		//return driver.findElement(selectdate);
	//}
	

	//Page object for Total Applicable TDS
	By totalapplicableTDS=By.xpath("//input[@formcontrolname='totalApplicableTDS']");
	public WebElement getTotalApplicableTDS() {
		base.failedElementName = "Receipt-TotApplicalbeTDS";
		return driver.findElement(totalapplicableTDS);
	}

	//Page object for Received TDS Amount
	By receivedTDSamount=By.xpath("//input[@formcontrolname='tAmount']");
	public WebElement getReceivedTDSAmount() {
		base.failedElementName = "Receipt-receivedTDSAmt";
		return driver.findElement(receivedTDSamount);
	}
	//Page object for TDS Type
	By TDStype=By.xpath("//mat-select[@formcontrolname='tdsType']");
	public void getTDSType(String TDSTYPE) {
		WebElement dropdown = driver.findElement(TDStype);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Receipt-getTDSType";
		
		String optionXpath="//mat-option//span[contains(text(),'" + TDSTYPE + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	//Page object for Next Btn2
	By nextbtn2=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div/form/div[2]/button[2]");
	public WebElement getNextBtn2() {
		base.failedElementName = "Receipt-NextBtn2";
		return driver.findElement(nextbtn2);
	}

	//GST Bank Details
	//Page object for GST Bank Name
	By GSTbankname=By.xpath("//mat-select[@formcontrolname='gBankID']");
	public void getGSTBankName(String GSTbankName) {
		WebElement dropdown = driver.findElement(GSTbankname);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Receipt-getGSTBankName";
		
		String optionXpath="//mat-option//span[contains(text(),'" + GSTbankName + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for GST Bank Branch
	By GSTbankbranch=By.xpath("//input[@formcontrolname='gBranchName']");
	public WebElement getGSTBankBranch() {
		base.failedElementName = "Receipt-GSTBankBranch";
		return driver.findElement(GSTbankbranch);
	}
	//Page object for Cheque No/Payment Type
	By chequeno=By.xpath("//input[@formcontrolname='gChequeNo']");
	public WebElement getChequeNo() {
		base.failedElementName = "Receipt-GSTChequeNo";
		return driver.findElement(chequeno);
	}

	//Page object for GST Cheque/Trans Date
	public WebElement chequetransdate() {
		WebElement chequetransdateElement = driver.findElement(By.xpath("//input[@formcontrolname='gChequeTranDate']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		chequetransdateElement.sendKeys(formattedDate);
		base.failedElementName = "Receipt-GSTChequeDate";
		return chequetransdateElement;
	}

	//Page object for Total Applicable GST
	By totalapplicableGST=By.xpath("//input[@formcontrolname='totalApplicableGST']");
	public WebElement getTotalApplicableGST() {
		base.failedElementName = "Receipt-TotalApplicableGST";
		return driver.findElement(totalapplicableGST);
	}
	//Page object for Received GST Amount 
	By receivedGSTamount=By.xpath("//input[@formcontrolname='gAmount']");
	public WebElement getReceivedGSTAmount() {
		base.failedElementName = "Receipt-RecdGSTAmt";
		return driver.findElement(receivedGSTamount);
	}
	//Page object for Next Btn3
	By nextbtn3=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div/form/div[2]/button[2]");
	public WebElement getNextBtn3() 
	{
		base.failedElementName = "Receipt-NextBtn3";
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", nextbtn3);
        
        WebElement element = driver.findElement(nextbtn3);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
		//return driver.findElement(nextbtn3);
	}

	//Attachment Cheque
	//Page object for Cheque Files
	By chequefiles=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[5]/div/div/div/form/div/div[1]/div[1]/"
			+ "mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement getChequeFiles() {
		base.failedElementName = "Receipt-ChequeFiles";
		return driver.findElement(chequefiles);
	}

	//Page object for Save Button
	By savebtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[5]/div/div/div/form/div/div[2]/button[2]");
	public WebElement getSavebtn() {
		base.failedElementName = "Receipt-SaveBtn";
		return driver.findElement(savebtn);
	} 
	//Page object for Search
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		base.failedElementName = "Receipt-Search";
		return driver.findElement(Search);
	}
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/div/div[3]/button");
	public WebElement getExporttoExcel() {
		base.failedElementName = "Receipt-ExportExcel";
		return driver.findElement(ExporttoExcel);
	}
	//Apply Filter
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/div/div[4]/button");
	public WebElement getapplyfilter() {
		base.failedElementName = "Receipt-Filter";
		return driver.findElement(filter);
	}
	//Page object for Apply filter Cancelled
	By cancelled = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div[3]/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement getCancelled() {
		base.failedElementName = "Receipt-CancellFilter";
		return driver.findElement(cancelled);
	}

	//Page object for Apply Filter All
	By applyfilterall = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div[3]/mat-radio-group/mat-radio-button[3]/div/div/input");
	public WebElement getApplyFilterAll() {
		base.failedElementName = "Receipt-applyFilterAll";
		return driver.findElement(applyfilterall);
	}
	//Page object for Apply Filter Date Range
	By daterange=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button");
	public WebElement getDateRange() {	
		base.failedElementName = "Receipt-daterange";
		return driver.findElement(daterange);
	}
	//Page object for select Start Date
	By startdate=By.xpath("/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/"
			+ "mat-month-view/table/tbody/tr[2]/td[2]/button/span[1]");
	public WebElement getStartDate() {	
		base.failedElementName = "Receipt-startdate";
		return driver.findElement(startdate);
	}
	//Page object for select End Date
	By enddate=By.xpath("/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/"
			+ "mat-month-view/table/tbody/tr[6]/td[5]/button/span[1]");
	public WebElement getEndDate() {	
		base.failedElementName = "Receipt-EndDate";
		return driver.findElement(enddate);
	}
	
	//Page object for Project Dropdown
	By projectdropdown=By.xpath("//mat-select[@placeholder='Select Project']");
	public void getProjectDropdown(String Project) {
		WebElement dropdown = driver.findElement(projectdropdown);
		dropdown.click();
		
		base.failedElement = dropdown;
		base.failedElementName = "Reciept-getProjectDropdown";
		
		String optionXPath = "//mat-option//span[contains(text(),'" + Project + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Apply Filter Reset
	By reset=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipts/div/div[2]/div/div[4]/button");
	public WebElement getReset() {	
		base.failedElementName = "Receipt-Reset";
		return driver.findElement(reset);
	}
	//Page object for Edit
	public WebElement getEdit() {
		WebElement Edit = driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/"
				+ "mat-sidenav-container/mat-sidenav-content/main/vex-receipts/"
				+ "div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Edit);
		js.executeScript("arguments[0].click();", Edit);
		base.failedElementName = "Receipt-Edit";
		return Edit;
	}

	//Page object for Update Btn
	By updatebtn = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[5]/div/div/div/form/div/div[2]/button[2]");
    public WebElement getUpdateBtn() {
    	base.failedElementName = "Receipt-UpdateBtn";
    	return driver.findElement(updatebtn);
    }	
	
	//Page object for Download Receipt
	By download=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[3]");
	public WebElement getDownload() {	
		base.failedElementName = "Receipt-download";
		return driver.findElement(download);
	}
	
	//Page object for Edit Next Btn
	By editnextbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[2]/button");
	public WebElement getEditNext() {
		base.failedElementName = "Receipt-EditNextBtn";
		return driver.findElement(editnextbtn);
	}
	
	//Page object for Print Receipt
	By printreceipt=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[2]");
    public WebElement getPrintReceipt() {
    	base.failedElementName = "Receipt-Print";
    	return driver.findElement(printreceipt);
    } 
    
    //Approve Cancel
    //Page object for Approve/Cancel
    By approvecancel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
    	 		+ "vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[4]");
    public WebElement getApproveCancel() {
    	base.failedElementName = "Receipt-ApproveCancelled";
   	    return driver.findElement(approvecancel);
    } 
    //Page object for Reason
    By reason=By.xpath("//input[@formcontrolname='reason']");
    public WebElement getReason() {
    	base.failedElementName = "Receipt-Reason";
	    return driver.findElement(reason);
    } 
    
    //Page object for View Receipt
    By viewreceipt=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
    		+ "vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[5]");
    public WebElement getViewReceipt() {
    	base.failedElementName = "Receipt-View";
    	return driver.findElement(viewreceipt);
    } 
    //Page object for Edit Next Button
  	By editnextbtn1 = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
  			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[2]/button");
  	public WebElement getEditNextBtn1() {
  		return driver.findElement(editnextbtn1);
  	}
  	//Page object for Edit
  	public void GetEditNext()
	{
		driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[1]")).click();
		WebElement a =driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[2]/button"));
		a.click();	
	}
  	
  	//Page object for Add Requierd Field 
  	public void AddRequierdField()
	{
  		WebElement projectname =driver.findElement(By.xpath("//mat-select[@formcontrolname='projectID']"));
  		projectname.click();
  		projectname.sendKeys(Keys.ESCAPE);
  		
		WebElement customername =driver.findElement(By.xpath("//mat-select[@formcontrolname='memberID']"));
		customername.click();
		customername.sendKeys(Keys.ESCAPE);
		
		WebElement flatshop =driver.findElement(By.xpath("//mat-select[@formcontrolname='projectUnitBlockDetailsID']"));
		flatshop.click();
	}
    
  	//Page object for Edit Requierd Field
  	public void EditNextRequierdBtn()
	{
		WebElement EditNextbtn =driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[2]/button"));
		EditNextbtn.click();	
	}
}