package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReceiptPage {
	public WebDriver driver;

	public ReceiptPage(WebDriver driver) {
		this.driver = driver;
	}
	// Page object for Receipt module
	By receipt = By.xpath("//vex-sidenav-item[7]//a[1]");
	public WebElement getReceipt() {
		return driver.findElement(receipt);
	}
	// Page object for Add Receipt module
	By Addreceipt = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
			+ "mat-sidenav-content/main/vex-receipts/div/div[1]/div[2]/button");
	public WebElement getAddReceipt() {
		return driver.findElement(Addreceipt);
	}

	//Customer Details
	//Page object for Project
	By project = By.xpath("//mat-select[@formcontrolname='projectID']");
	public WebElement getProject() {
		return driver.findElement(project);
	}
	//Page object for Customer
	By customer= By.xpath("//mat-select[@formcontrolname='memberID']");
	public WebElement getCustormer() {
		return driver.findElement(customer);
	}
	//Page object for Select Flat/Shop
	By flatshop= By.xpath("//mat-select[@formcontrolname='projectUnitBlockDetailsID']");
	public WebElement getFlatShop() {
		return driver.findElement(flatshop);
	}
	//Page object for Next btn
	By nextbtn=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
			+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[2]/button");
	public WebElement getNextBtn() {
		return driver.findElement(nextbtn);
	}

	//Regular Bank Details
	//Page object for Regular Bank Name
	By bankname=By.xpath("//mat-select[@formcontrolname='rBankID']");
	public WebElement getBankName() {
		return driver.findElement(bankname);
	}
	//Page object for Regular Bank Branch
	By bankbranch =By.xpath("//input[@formcontrolname='rBranchName']");
	public WebElement getBankBranch() {
		return driver.findElement(bankbranch);
	}
	//page object for Payment Type
	By paymenttype=By.xpath("//mat-select[@formcontrolname='paymentType']");
	public WebElement getPaymentType() {
		return driver.findElement(paymenttype);
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
    
    //Page object for Next btn
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
    By challandate=By.xpath("//input[@formcontrolname='tChequeTranDate']");
    public WebElement getChallanDate() {
    	return driver.findElement(challandate);
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
    public WebElement getTDSType() {
	   return driver.findElement(TDStype);
    }
    //Page object for Next btn3
    By nextbtn3=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
    		+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[3]/div/div/div/form/div/form/div[2]/button[2]");
    public WebElement getNextBtn3() {
	   return driver.findElement(nextbtn3);
    }
    
    //GST Bank Details
    //Page object for GST Bank Name
    By GSTbankname=By.xpath("//mat-select[@formcontrolname='gBankID']");
    public WebElement getGSTBankName() {
	   return driver.findElement(GSTbankname);
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
    By chequetransdate=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/"
    		+ "vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[4]/div/div/div/form/div/form/div[1]/div[1]/div[2]/div[2]/"
    		+ "mat-form-field/div[1]/div[2]/div[3]/mat-datepicker-toggle/button");
    public WebElement getChequeTransDate() {
	   return driver.findElement(chequetransdate);
    }
}

