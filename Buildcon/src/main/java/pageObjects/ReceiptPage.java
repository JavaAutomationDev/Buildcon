package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ReceiptPage {
	public WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	public ReceiptPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page object for Receipt Module
	By receipt = By.xpath("//vex-sidenav-item[7]//a[1]");
	public WebElement getReceipt() {
		return driver.findElement(receipt);
	}
	//Page object for Add Receipt
	By Addreceipt = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/button");
	public WebElement getAddReceipt() {
		return driver.findElement(Addreceipt);
	}

	//Customer Details
	//Page object for Project
	By project = By.xpath("//mat-select[@formcontrolname='projectID']");
	public void getProject(String Project) {
		WebElement dropdown = driver.findElement(project);
		dropdown.click();
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
		String optionXpath="//mat-option//span[contains(text(),'" + CustomerName + "')]";
		WebElement option=driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	//Page object for Select Flat/Shop
	By flatshop = By.xpath("//mat-select[@formcontrolname='projectUnitBlockDetailsID']");
	public void getFlatShop(String FlatShop) {
		WebElement dropdown = driver.findElement(flatshop);
		dropdown.click();
		String optionXpath = "/html/body/div[4]/div[2]/div/div/mat-option/span";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for Next Btn
	By nextbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[2]/button[2]");
	public WebElement getNextBtn() {
		return driver.findElement(nextbtn);
	}

	//Regular Bank Details
	//Page object for Regular Bank Name
	By bankname = By.xpath("//mat-select[@formcontrolname='rBankID']");
	public void getBankName(String BankName) {
		WebElement dropdown = driver.findElement(bankname);
		dropdown.click();
		List<WebElement> options = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		for(int i=0;i<options.size();i++) {
			String text = options.get(i).getText();
			if (text.equalsIgnoreCase(BankName)) {
				int a = i+1;
				driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option["+a+"]")).click();
				break;}
		}
	}

	//Page object for Regular Bank Branch
	By bankbranch =By.xpath("//input[@formcontrolname='rBranchName']");
	public WebElement getBankBranch() {
		return driver.findElement(bankbranch);
	}
	//page object for Payment Type
	By paymenttype=By.xpath("//mat-select[@formcontrolname='paymentType']");
	public void getPaymentType(String PaymentType) {
		WebElement dropdown = driver.findElement(paymenttype);
		dropdown.click();
		String optionXpath="//mat-option//span[contains(text(),'" + PaymentType + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	//page object for IMPS No
	By Impsno=By.xpath("//input[@formcontrolname='rChequeNo']");
	public WebElement getIMPSNO() {
		return driver.findElement(Impsno);
	}
	//Page object for Regular Cheque/Tran. Date
	By regularchequetrandate =By.xpath("//input[@formcontrolname='rChequeTranDate']");
	public WebElement getRegularChequeTranDate() {
		return driver.findElement(regularchequetrandate);
	}

	//Page object for Regular Amount
	By regularamount =By.xpath("//input[@formcontrolname='rAmount']");
	public WebElement getRegularAmount() {
		return driver.findElement(regularamount);
	}
	//Page object for Regular Bank Cancelled
	By regularbankcancelled =By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div/form/"
			+ "div[1]/div/div[4]/div[1]/div/mat-form-field/div[1]/div[2]/div[2]/mat-checkbox/div/div/input");
	public WebElement getRegularBankCancelled() {
		return driver.findElement(regularbankcancelled);
	}
	//Page object for GST Applicable
	By gstapplicable=By.xpath("//input[@placeholder='GST Apllicable']");
	public WebElement getGSTNO() {
		return driver.findElement(gstapplicable);
	}

	//Page object for Next Btn1
	By nextbtn1=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[2]/div/div/div/form/div/form/div[2]/button[2]");
	public WebElement getNextBtn1() {
		return driver.findElement(nextbtn1);
	}

	//TDS Bank Details
	//Page object for TDS Challan Number 
	By TDSchallannumber=By.xpath("//input[@formcontrolname='tChequeNo']");
	public WebElement getTDSChallanNumber() {
		return driver.findElement(TDSchallannumber);
	}

	//Page object for Challan Date
	public WebElement challandate() {
		WebElement challandateElement = driver.findElement(By.xpath("//input[@formcontrolname='tChequeTranDate']"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,0);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(tomorrow);
		challandateElement.sendKeys(formattedDate);
		return challandateElement;
	}

	//Page object for Total Applicable TDS
	By totalapplicableTDS=By.xpath("//input[@formcontrolname='totalApplicableTDS']");
	public WebElement getTotalApplicableTDS() {
		return driver.findElement(totalapplicableTDS);
	}

	//Page object for Received TDS Amount
	By receivedTDSamount=By.xpath("//input[@formcontrolname='tAmount']");
	public WebElement getReceivedTDSAmount() {
		return driver.findElement(receivedTDSamount);
	}
	//Page object for TDS Type
	By TDStype=By.xpath("//mat-select[@formcontrolname='tdsType']");
	public void getTDSType(String TDSTYPE) {
		WebElement dropdown = driver.findElement(TDStype);
		dropdown.click();
		String optionXpath="//mat-option//span[contains(text(),'" + TDSTYPE + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	//Page object for Next Btn2
	By nextbtn2=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div/form/div[2]/button[2]");
	public WebElement getNextBtn2() {
		return driver.findElement(nextbtn2);
	}

	//GST Bank Details
	//Page object for GST Bank Name
	By GSTbankname=By.xpath("//mat-select[@formcontrolname='gBankID']");
	public void getGSTBankName(String GSTbankName) {
		WebElement dropdown = driver.findElement(GSTbankname);
		dropdown.click();
		String optionXpath="//mat-option//span[contains(text(),'" + GSTbankName + "')]";
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

	//Page object for GST Bank Branch
	By GSTbankbranch=By.xpath("//input[@formcontrolname='gBranchName']");
	public WebElement getGSTBankBranch() {
		return driver.findElement(GSTbankbranch);
	}
	//Page object for Cheque No/Payment Type
	By chequeno=By.xpath("//input[@formcontrolname='gChequeNo']");
	public WebElement getChequeNo() {
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
		return chequetransdateElement;
	}

	//Page object for Total Applicable GST
	By totalapplicableGST=By.xpath("//input[@formcontrolname='totalApplicableGST']");
	public WebElement getTotalApplicableGST() {
		return driver.findElement(totalapplicableGST);
	}
	//Page object for Received GST Amount 
	By receivedGSTamount=By.xpath("//input[@formcontrolname='gAmount']");
	public WebElement getReceivedGSTAmount() {
		return driver.findElement(receivedGSTamount);
	}
	//Page object for Next Btn3
	By nextbtn3=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div/form/div[2]/button[2]");
	public WebElement getNextBtn3() {
		return driver.findElement(nextbtn3);
	}

	//Attachment Cheque
	//Page object for Cheque Files
	By chequefiles=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[5]/div/div/div/form/div/div[1]/div[1]/mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement getChequeFiles() {
		return driver.findElement(chequefiles);
	}

	//Page object for Save Button
	By savebtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[5]/div/div/div/form/div/div[2]/button[2]");
	public WebElement getSavebtn() {
		return driver.findElement(savebtn);
	} 
	//Page object for Search
	By Search = By.xpath("//input[@type='search']");
	public WebElement getSearch() {
		return driver.findElement(Search);
	}
	//Page object for Export to Excel
	By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/div/div[3]/button");
	public WebElement getExporttoExcel() {
		return driver.findElement(ExporttoExcel);
	}
	//Apply Filter
	//Page object for Apply Filter
	By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container"
			+ "/mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/div/div[4]/button");
	public WebElement getapplyfilter() {
		return driver.findElement(filter);
	}
	//Page object for Apply filter Cancelled
	By cancelled = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div[3]/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement getCancelled() {
		return driver.findElement(cancelled);
	}

	//Page object for Apply Filter All
	By applyfilterall = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div[3]/mat-radio-group/mat-radio-button[3]/div/div/input");
	public WebElement getApplyFilterAll() {
		return driver.findElement(applyfilterall);
	}
	//Page object for Apply Filter Date Range
	By daterange=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button");
	public WebElement getDateRange() {	
		return driver.findElement(daterange);
	}
	//Page object for select Start Date
	By startdate=By.xpath("/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/"
			+ "mat-month-view/table/tbody/tr[2]/td[2]/button/span[1]");
	public WebElement getStartDate() {	
		return driver.findElement(startdate);
	}
	//Page object for select End Date
	By enddate=By.xpath("/html/body/div[4]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/"
			+ "mat-month-view/table/tbody/tr[6]/td[5]/button/span[1]");
	public WebElement getEndDate() {	
		return driver.findElement(enddate);
	}
	
	//Page object for Project Dropdown
	By projectdropdown=By.xpath("//mat-select[@placeholder='Select Project']");
	public void getProjectDropdown(String Project) {
		WebElement dropdown = driver.findElement(projectdropdown);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + Project + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Apply Filter Reset
	By reset=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div[4]/button");
	public WebElement getReset() {	
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
		return Edit;
	}

	//Page object for Update Btn
	By updatebtn = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[5]/div/div/div/form/div/div[2]/button[2]");
    public WebElement getUpdateBtn() {
    	return driver.findElement(updatebtn);
    }	
	
	//Page object for Download Receipt
	By download=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[3]");
	public WebElement getDownload() {	
		return driver.findElement(download);
	}
	
	//Page object for Edit Next Btn
	By editnextbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[2]/button");
	public WebElement getEditNext() {
		return driver.findElement(editnextbtn);
	}
	
	//Page object for Print Receipt
	By printreceipt=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[2]");
    public WebElement getPrintReceipt() {
    	return driver.findElement(printreceipt);
    } 
    
    //Approve Cancel
    //Page object for Approve/Cancel
    By approvecancel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
    	 		+ "vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[4]");
    public WebElement getApproveCancel() {
   	    return driver.findElement(approvecancel);
    } 
    //Page object for Reason
    By reason=By.xpath("//input[@formcontrolname='reason']");
    public WebElement getReason() {
	    return driver.findElement(reason);
    } 
    
    //Page object for View Receipt
    By viewreceipt=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
    		+ "vex-receipts/div/div[2]/div/div/table/tbody/tr[1]/td[25]/div/button[5]");
    public WebElement getViewReceipt() {
    	return driver.findElement(viewreceipt);
    } 
}