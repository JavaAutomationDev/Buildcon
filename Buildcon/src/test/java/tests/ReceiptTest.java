package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ReceiptPage;
import resources.base;

public class ReceiptTest extends base {
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize11() throws IOException {
		driver=initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getAccountName().sendKeys(prop.getProperty("AC"));  
		loginPage.getUserName().sendKeys(prop.getProperty("USER"));  
		loginPage.getpass().sendKeys(prop.getProperty("PS"));
		loginPage.getsignIn().click();
		log.info("Login successful");
	}

	//Add Receipt
	@Test(dataProvider="getAddData")
	public void Add_Project(String Project,String CustomerName,String FlatShop,String BankName,String Bankbranch,
			String PaymentType,String IMPSNO,String RegularAmount,String ChallanNumber,String ReceivedTDSAmount,
			String TDSTYpe,String GSTbankName,String GSTBankBranch,String ChequeNo,String ChequeFiles) throws InterruptedException {
		
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getAddReceipt().click();
		
		receipt.getProject(Project);
		receipt.getCustormer(CustomerName);
		receipt.getFlatShop(FlatShop);
		receipt.getNextBtn().click();
		
		Thread.sleep(2000);
		receipt.getBankName(BankName);
		receipt.getBankBranch().sendKeys(Bankbranch);
		receipt.getPaymentType(PaymentType);
		receipt.getIMPSNO().sendKeys(IMPSNO);
		//receipt.getRegularChequeTranDate().sendKeys(ChequeDate);
		receipt.getRegularAmount().sendKeys(RegularAmount);
		receipt.getRegularBankCancelled().click();
		receipt.getGSTNO().click();
		Thread.sleep(2000);
		receipt.getNextBtn1().click();
		
		
		receipt.getTDSChallanNumber().sendKeys(ChallanNumber);
		//receipt.challandate();
		receipt.getReceivedTDSAmount().sendKeys(ReceivedTDSAmount);
		//Thread.sleep(2000);
		receipt.getTDSType(TDSTYpe);
        Thread.sleep(2000);	
		receipt.getNextBtn2().click();
		
		receipt.getGSTBankName(GSTbankName);
		receipt.getGSTBankBranch().sendKeys(GSTBankBranch);
		receipt.getChequeNo().sendKeys(ChequeNo);
		//receipt.chequetransdate();
		
		Thread.sleep(2000);
		receipt.getNextBtn3().click();
		receipt.getChequeFiles().sendKeys(ChequeFiles);

		Thread.sleep(2000);
		receipt.getSavebtn().click();
	}

	//Editing an existing Receipt using Data Provider
	@Test(dataProvider="getEditData")
	public void Edit_Receipt(String newBankbranch,String newIMPSNO,String newChallanNumber,String newGSTBankBranch) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		
		Thread.sleep(2000);
		receipt.getEdit();
		receipt.getEditNext().click();
		
		receipt.getBankBranch().clear();
		receipt.getBankBranch().sendKeys(newBankbranch);
		
		receipt.getIMPSNO().clear();
		receipt.getIMPSNO().sendKeys(newIMPSNO);
		receipt.getNextBtn1().click();
		
		receipt.getTDSChallanNumber().clear();
		receipt.getTDSChallanNumber().sendKeys(newChallanNumber);
		
		receipt.getNextBtn2().click();
		receipt.getGSTBankBranch().clear();
		receipt.getGSTBankBranch().sendKeys(newGSTBankBranch);
		
		receipt.getNextBtn3().click();
		
		Thread.sleep(2000);
		receipt.getUpdateBtn().click();
	}
	
	//Download Receipt
	@Test
	public void Download_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		
		Thread.sleep(3000);
		receipt.getDownload().click();
	}
	
	//Search Receipt
	@Test(dataProvider="getSearchData")
	public void Search_Receipt(String Project) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		
		Thread.sleep(2000);
		receipt.getSearch().sendKeys(Project + Keys.ENTER);;
	}

	//Export to Excel Receipt
	@Test()
	public void Export_to_Excel_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		
		Thread.sleep(2000);
		receipt.getExporttoExcel().click();
	}

	//Print Receipt
	@Test()
	public void Print_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		
		Thread.sleep(2000);
        receipt.getPrintReceipt().click();		
	}
	
	//Approve Cancel Receipt
	@Test(dataProvider="getapproveData")
	public void ApproveCancel_Receipt(String approve) throws InterruptedException{
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		
		Thread.sleep(2000);
		receipt.getApproveCancel().click();
        receipt.getReason().sendKeys(approve);
	}
	
	//View Receipt
	@Test()
	public void View_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		
		Thread.sleep(2000);
        receipt.getViewReceipt();
    }
	
	//Apply Filter Receipt With Date Range
	@Test()
	public void Apply_Filter_Date_Range() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		
		Thread.sleep(2000);
		receipt.getapplyfilter().click();
		receipt.getDateRange().click();
		receipt.getStartDate().click();
		receipt.getEndDate().click();
	}
	//Apply Filter Receipt With Project Dropdown
		@Test(dataProvider="getprojectdropdown")
		public void Apply_Filter_Project_Dropdown(String Project) throws InterruptedException {
			ReceiptPage receipt = new ReceiptPage(driver);
			receipt.getReceipt().click();
			
			Thread.sleep(2000);
			receipt.getapplyfilter().click();
			receipt.getProjectDropdown(Project);
	}
	
	//Apply Filter Receipt Cancelled
	@Test()
	public void Apply_Filter_Cancelled_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getapplyfilter().click();
		
		Thread.sleep(2000);
		receipt.getCancelled().click();
	}
	
	//Apply Filter Receipt All
	@Test()
	public void Apply_Filter_All_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getapplyfilter().click();
		
		Thread.sleep(2000);
		receipt.getApplyFilterAll().click();
	}
	
	//Apply Filter Receipt Reset
	@Test()
	public void Apply_Filter_Reset_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getapplyfilter().click();
		
		Thread.sleep(2000);
		receipt.getReset().click();
	}
	
	//Close the driver
	@AfterMethod
	public void teardown() {
		//driver.close();
	}	

	//Add Receipt Data
	@DataProvider
	public Object[][] getAddData() {
		return new Object[][] {
			{" Parisar homes "," Nikanth Tandel "," 3BHK-402 (4th Floor) ","Axis Bank","Bopal"," IMPS ","7890548","10000","78565545",
				"457"," 0% "," Bank Of India ","Bopal","54682485","D:\\Fileupload\\BB1qVDNW.jpg"}};
	}

	//DataProvider for Edit Receipt
	@DataProvider
	public Object[][] getEditData() {
		return new Object[][] { 
			{"Ahmedabad","796498723548","97464970021","Thaltej"}};
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{" Parisar homes "}};
	}
	
	//DataProvider for Project Dropdown 
		@DataProvider
	public Object[][] getprojectdropdown() {
		return new Object[][] {
			{" Parisar homes "}};
	}
	
	//DataProvider for Approve Cancel 
	@DataProvider
	public Object[][] getapproveData() {
			return new Object[][] {
				{"Approve"}};
	}
}