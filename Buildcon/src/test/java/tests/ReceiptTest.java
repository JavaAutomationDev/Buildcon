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
		receipt.getNextBtn1().click();
		receipt.getTDSChallanNumber().sendKeys(ChallanNumber);
		//receipt.challandate();
		receipt.getReceivedTDSAmount().sendKeys(ReceivedTDSAmount);
		//Thread.sleep(2000);
		receipt.getTDSType(TDSTYpe);
		receipt.getNextBtn3().click();
		Thread.sleep(2000);
		receipt.getGSTBankName(GSTbankName);
		receipt.getGSTBankBranch().sendKeys(GSTBankBranch);
		receipt.getChequeNo().sendKeys(ChequeNo);
		//receipt.chequetransdate();
		receipt.getNextBtn4().click();
		receipt.getChequeFiles().sendKeys(ChequeFiles);
		receipt.getSavebtn().click();
	}

	//Editing an existing Receipt using Data Provider
	@Test
	public void Edit_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getEdit();
	}
	
	//Download Receipt
	@Test
	public void Download_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		Thread.sleep(5000);
		receipt.getDownload().click();
	}
	
	//Search Receipt
	@Test(dataProvider="getSearchData")
	public void Search_Receipt(String Project) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getSearch().sendKeys(Project + Keys.ENTER);;
	}

	//Export to Excel Receipt
	@Test()
	public void Export_to_Excel_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getExporttoExcel().click();
	}

	//Apply Filter Receipt
	@Test()
	public void Apply_Filter_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getapplyfilter().click();
	}

	//Apply Filter Receipt Cancelled
	@Test()
	public void Apply_Filter_Cancelled_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getapplyfilter().click();
		receipt.getCancelled().click();
	}
	
	//Apply Filter Receipt All
	@Test()
	public void Apply_Filter_All_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getapplyfilter().click();
		receipt.getAll().click();
	}
	
	//Apply Filter Receipt Reset
	@Test()
	public void Apply_Filter_Reset_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getapplyfilter().click();
		receipt.getReset().click();
	}
	
	//Close the driver
	@AfterMethod
	public void teardown() {
		driver.close();
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
			{ } };
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{" Parisar homes "}};
	}


}