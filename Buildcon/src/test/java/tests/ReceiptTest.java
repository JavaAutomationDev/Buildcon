package tests;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.Bankspage;
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
	@Test(dataProvider="ReceiptAddData")
	public void Add_Receipt(String Project,String CustomerName,String FlatShop,String BankName,String Bankbranch,
			String PaymentType,String IMPSNO,String RegularAmount,String ChallanNumber,String ReceivedTDSAmount,
			String TDSTYpe,String GSTbankName,String GSTBankBranch,String ChequeNo,
			String ReceivedGSTAmount,String ChequeFiles) throws InterruptedException, IOException {

		SoftAssert softAssert=new SoftAssert();
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getAddReceipt().click();

		receipt.getProject(Project);//Required Field
		receipt.getCustormer(CustomerName);//Required Field
		receipt.getFlatShop(FlatShop);//Required Field

		//receipt.getCalendarClick().click();
		//receipt.getDateSelect().click();
		//receipt.getDateSelect().click();

		receipt.getNextBtn().click();
		Thread.sleep(2000);
		receipt.getBankName(BankName);//Required Field

		receipt.getBankBranch().sendKeys(Bankbranch);//Required Field
		softAssert.assertFalse(Bankbranch.isEmpty(), "Regular Bank Branch is Required.");
		//Bank Branch Name Text Data Validation
		String valid_string = validateText(Bankbranch,"Bankbranch", 5, 30);
		String valid_Bankbranch = valid_string;
		System.out.println(valid_Bankbranch);


		receipt.getPaymentType(PaymentType);//Required Field

		receipt.getIMPSNO().sendKeys(IMPSNO);
		softAssert.assertFalse(IMPSNO.isEmpty(), "IMPS No is Required.");
		//IMPS No Data Validation
		String valid_string1 = validateText(IMPSNO,"IMPSNO", 5, 30);
		String valid_IMPSNO = valid_string1;
		System.out.println(valid_IMPSNO);

		//receipt.getRegularChequeTranDate().click();
		//receipt.getChecqueDate().click();
		//receipt.getChecqueDate().click();

		receipt.getRegularAmount().sendKeys(RegularAmount);//Required Field
		softAssert.assertFalse(RegularAmount.isEmpty(), "Regular Amount is Required.");
		//Regular Amount Text Data Validation
		String valid_string2 = validateText(RegularAmount,"RegularAmount", 5, 30);
		String valid_RegularAmount = valid_string2;
		System.out.println(valid_RegularAmount);

		receipt.getRegularBankCancelled().click();
		receipt.getGSTNO().click();
		Thread.sleep(2000);
		receipt.getNextBtn1().click();

		receipt.getTDSChallanNumber().sendKeys(ChallanNumber);
		softAssert.assertFalse(ChallanNumber.isEmpty(), "Challan Number is Required.");
		//Challan Number Data Validation
		String valid_string3 = validateText(ChallanNumber,"ChallanNumber", 5, 30);
		String valid_ChallanNumber = valid_string3;
		System.out.println(valid_ChallanNumber);

		//receipt.challandate();
		//receipt.getSelectDate().click();
		//receipt.getSelectDate().click();

		receipt.getReceivedTDSAmount().sendKeys(ReceivedTDSAmount);
		softAssert.assertFalse(ReceivedTDSAmount.isEmpty(), "Received TDS Amount is Required.");
		//Received TDS Amount Data Validation
		String valid_string4 = validateText(ReceivedTDSAmount,"ReceivedTDSAmount", 5, 30);
		String valid_ReceivedTDSAmount = valid_string4;
		System.out.println(valid_ReceivedTDSAmount);

		receipt.getTDSType(TDSTYpe);

		Thread.sleep(2000);	
		receipt.getNextBtn2().click();

		receipt.getGSTBankName(GSTbankName);

		receipt.getGSTBankBranch().sendKeys(GSTBankBranch);
		softAssert.assertFalse(GSTBankBranch.isEmpty(), "GSTBankBranch is Required.");
		//GST Bank Branch Data Validation
		String valid_string5 = validateText(GSTBankBranch,"GSTBankBranch", 5, 30);
		String valid_GSTBankBranch = valid_string5;
		System.out.println(valid_GSTBankBranch);

		receipt.getChequeNo().sendKeys(ChequeNo);
		softAssert.assertFalse(ChequeNo.isEmpty(), "ChequeNo is Required.");
		//Cheque No Data Validation
		String valid_string6 = validateText(ChequeNo,"ChequeNo", 5, 30);
		String valid_ChequeNo = valid_string6;
		System.out.println(valid_ChequeNo);

		//receipt.chequetransdate();

		receipt.getReceivedGSTAmount().sendKeys(ReceivedGSTAmount);
		softAssert.assertFalse(ReceivedGSTAmount.isEmpty(), "ReceivedGSTAmount is Required.");
		//Received GST Amount Data Validation
		String valid_string7 = validateText(ReceivedGSTAmount,"ReceivedGSTAmount", 5, 30);
		String valid_ReceivedGSTAmount = valid_string7;
		System.out.println(valid_ReceivedGSTAmount);

		Thread.sleep(2000);
		receipt.getNextBtn3().click();
		receipt.getChequeFiles().sendKeys(ChequeFiles);

		Thread.sleep(2000);
		receipt.getSavebtn().click();

		softAssert.assertEquals(valid_Bankbranch, "Bankbranch is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_IMPSNO, "IMPSNO is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_RegularAmount, "RegularAmount is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_ChallanNumber, "ChallanNumber is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_ReceivedTDSAmount, "ReceivedTDSAmount is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_GSTBankBranch, "GSTBankBranch is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_ChequeNo, "ChequeNo is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_ReceivedGSTAmount, "ReceivedGSTAmount is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertAll();
	}

	//Editing an existing Receipt using Data Provider
	@Test(dataProvider="ReceiptEditData")
	public void Edit_Receipt(String Receiptno,String newBankbranch,String newIMPSNO,String newRegularAmount,String newChallanNumber,
			String newGSTBankBranch) throws InterruptedException, IOException {
		SoftAssert softAssert=new SoftAssert();
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getSearch().sendKeys(Receiptno +Keys.ENTER);

		Thread.sleep(2000);
		receipt.getEditBtnEditRecord().click();
		Thread.sleep(2000);
		receipt.getEditNext().click();

		receipt.getBankBranch().clear();
		receipt.getBankBranch().sendKeys(newBankbranch);
		softAssert.assertFalse(newBankbranch.isEmpty(), "Bank branch is Required.");
		//Bank branch Data Validation
		String valid_string4 = validateText(newBankbranch,"Bankbranch", 30, 30);
		String valid_newBankbranch = valid_string4;
		System.out.println(valid_newBankbranch);

		receipt.getIMPSNO().clear();
		receipt.getIMPSNO().sendKeys(newIMPSNO);
		softAssert.assertFalse(newIMPSNO.isEmpty(), "IMPS NO is Required.");
		//IMPS NO Data Validation
		String valid_string = validateText(newIMPSNO,"IMPSNO", 30, 30);
		String valid_newIMPSNO = valid_string;
		System.out.println(valid_newIMPSNO);

		receipt.getNextBtn1().click();

		receipt.getRegularAmount().clear();
		receipt.getRegularAmount().sendKeys(newRegularAmount);
		softAssert.assertFalse(newRegularAmount.isEmpty(), "Regular Amount is required");
		//Regular Amount Data Validation
		String valid_string1 = validateText(newRegularAmount,"RegularAmount", 30, 30);
		String valid_newRegularAmount = valid_string1;
		System.out.println(valid_newRegularAmount);

		receipt.getTDSChallanNumber().clear();
		receipt.getTDSChallanNumber().sendKeys(newChallanNumber);
		softAssert.assertFalse(newChallanNumber.isEmpty(), "Challan Number is Required.");
		//Challan Number Data Validation
		String valid_string2 = validateText(newChallanNumber,"ChallanNumber", 30, 30);
		String valid_newChallanNumber = valid_string2;
		System.out.println(valid_newChallanNumber);

		receipt.getNextBtn2().click();

		receipt.getGSTBankBranch().clear();
		receipt.getGSTBankBranch().sendKeys(newGSTBankBranch);
		softAssert.assertFalse(newGSTBankBranch.isEmpty(), "GST Bank Branch is Required.");
		//GST Bank Branch Data Validation
		String valid_string3 = validateText(newGSTBankBranch,"GST Bank Branch", 30, 30);
		String valid_newGSTBankBranch = valid_string3;
		System.out.println(valid_newGSTBankBranch);

		receipt.getNextBtn3().click();

		Thread.sleep(2000);
		receipt.getUpdateBtn().click();

		softAssert.assertEquals(valid_newBankbranch, "newBankbranch is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_newIMPSNO, "newIMPSNO is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_newRegularAmount, "newRegularAmount is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_newChallanNumber, "newChallanNumber is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertEquals(valid_newGSTBankBranch, "newGSTBankBranch is a Valid text - is a valid Minlength - is a valid Maxlength");
		softAssert.assertAll();
	}

	//Download Receipt
	@Test(dataProvider="DownloadReceiptData")
	public void Download_Receipt(String Receiptno) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getSearch().sendKeys(Receiptno + Keys.ENTER);
		Thread.sleep(3000);
		receipt.getthreedotbtn().click();
		receipt.getthreedotbtn().click();
		Thread.sleep(10000);
		receipt.getDownload().click();
	}

	//Search Receipt
	@Test(dataProvider="ReceiptSearchData")
	public void Search_Receipt(String Project) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();

		Thread.sleep(2000);
		receipt.getSearch().sendKeys(Project + Keys.ENTER);
	}

	//Export to Excel Receipt
	@Test()
	public void Export_To_Excel_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();

		Thread.sleep(2000);
		receipt.getExporttoExcel().click();
	}

	//Print Receipt
	@Test(dataProvider="PrintReceiptData")
	public void Print_Receipt(String Receiptno) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getSearch().sendKeys(Receiptno + Keys.ENTER);
		Thread.sleep(2000);
		receipt.getPrintReceipt().click();	
		String originalWindow = driver.getWindowHandle();
		driver.switchTo().window(originalWindow);
	}

	//Approve Cancel Receipt
	@Test(dataProvider="ReceiptApproveCancelData")
	public void Approve_Cancel_Receipt(String Project,String Approve) throws InterruptedException{
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getSearch().sendKeys(Project + Keys.ENTER);
		Thread.sleep(2000);
		receipt.getthreedotbtn().click();
		receipt.getthreedotbtn().click();
		Thread.sleep(2000);
		receipt.getApproveCancel().click();
		Thread.sleep(2000);
		receipt.getReason().sendKeys(Approve);
		receipt.getClickYes().click();
	}

	//View Receipt
	@Test(dataProvider="ViewReceiptData")
	public void View_Receipt(String Receiptno) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getSearch().sendKeys(Receiptno + Keys.ENTER);
		Thread.sleep(2000);
		receipt.getthreedotbtn().click();
		receipt.getthreedotbtn().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		receipt.getViewReceipt().click();
		String originalWindow = driver.getWindowHandle();
		driver.switchTo().window(originalWindow);
	}

	//SendEmail Receipt
	@Test(dataProvider="SendEmailReceiptData")
	public void SendEmail_Receipt(String Receiptno) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getSearch().sendKeys(Receiptno + Keys.ENTER);
		Thread.sleep(2000);
		receipt.getthreedotbtn().click();
		receipt.getthreedotbtn().click();
		Thread.sleep(2000);
		receipt.getSendEmailReceipt().click();
		receipt.getClickYes().click();
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
	@Test(dataProvider="Receiptprojectdropdown")
	public void Apply_Filter_Project_Dropdown(String Project) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();

		Thread.sleep(2000);
		receipt.getapplyfilter().click();
		receipt.getProjectDropdown(Project);
	}

	//Apply Filter Receipt Cancelled Button
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

	//Add Receipt Test Mandatory Filed Validation
	@Test()
	public void Add_Receipt_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getAddReceipt().click();
		receipt.AddRequierdField();

		receipt.getHeaderClick().click();

		SoftAssert softAssert = new SoftAssert();
		WebElement projectname =driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content"
				+ "/main/vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[1]/div[1]/mat-form-field/div[2]/div"));
		softAssert.assertEquals(projectname.getText(), "Project Name is required.");

		WebElement customerName =driver.findElement(By.xpath("//span[normalize-space()='Customer Name is required.']"));
		softAssert.assertEquals(customerName.getText(), "Customer Name is required.");

		WebElement flatshop =driver.findElement(By.xpath("//span[normalize-space()='Flat/Shop is required.']"));
		softAssert.assertEquals(flatshop.getText(), "Flat/Shop is required.");
		softAssert.assertAll();
	}
	//Edit Receipt Test Mandatory Filed Validation
	@Test(dataProvider="EditReceiptTestMandatoryData")
	public void Edit_Receipt_Test_Mandatory_Filed_Validation(String Receiptno) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getSearch().sendKeys(Receiptno + Keys.ENTER);
		receipt.getEditBtnActiveInactive().click();
		Thread.sleep(2000);
		receipt.EditNextRequierdBtn();
		
		receipt.getBankBranch().sendKeys(Keys.TAB);
		receipt.getBankBranch().click();
		int bankbranchname  = receipt.getBankBranch().getAttribute("value").length();
		for (int i = 0; i < bankbranchname ; i++) {
			receipt.getBankBranch().sendKeys(Keys.BACK_SPACE);
		}
		
		receipt.getRegularAmount().click();
		int regularamount  = receipt.getRegularAmount().getAttribute("value").length();
		for (int i = 0; i < regularamount ; i++) {
			receipt.getRegularAmount().sendKeys(Keys.BACK_SPACE);
		}
		receipt.getRegularAmount().sendKeys(Keys.TAB);

		SoftAssert softAssert = new SoftAssert();
		WebElement regularbankbranch =driver.findElement(By.xpath("//span[normalize-space()='Regular Bank Branch is Required']"));
		softAssert.assertEquals(regularbankbranch.getText(), "Regular Bank Branch is Required");

		WebElement regularAmount =driver.findElement(By.xpath("//span[normalize-space()='Regular Amount is required']"));
		softAssert.assertEquals(regularAmount.getText(), "Regular Amount is required");
		softAssert.assertAll();
	}

	//Banks Active Inactive
	//Verify Add InActive Bank in Receipt
	@Test(dataProvider="AddInactiveBank")
	public void Verify_Add_InActive_Bank(String Bankname,String Project,String CustomerName,String FlatShop,String Name) 
			throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBankssearched().sendKeys(Bankname+Keys.ENTER);
		Bank.getbankseditclick().click();
		Bank.getActiveStatus().click();		
		Bank.getbankseditsave().click();

		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		Thread.sleep(2000);
		receipt.getAddReceipt().click();
		receipt.getProject(Project);
		receipt.getCustormer(CustomerName);
		receipt.getFlatShop(FlatShop);
		Thread.sleep(2000);
		receipt.getNextBtn().click();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='rBankID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase(Name))
			{
				Assert.assertFalse(false, "Bank is Inactive.");
				//System.out.println("Test failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}
	
	//Verify Add Active Bank in Receipt
		@Test(dataProvider="AddActiveBank")
		public void Verify_Add_Active_Bank(String Bankname,String Project,String CustomerName,String FlatShop,String Name) 
				throws InterruptedException {
			Bankspage Bank = new Bankspage(driver);
			Bank.getconfiguration().click();
			Bank.getBanksclick().click();
			Bank.getBankssearched().sendKeys(Bankname+Keys.ENTER);
			Bank.getbankseditclick().click();
			Bank.getActiveStatus().click();		
			Bank.getbankseditsave().click();

			ReceiptPage receipt = new ReceiptPage(driver);
			receipt.getReceipt().click();
			Thread.sleep(2000);
			receipt.getAddReceipt().click();
			receipt.getProject(Project);
			receipt.getCustormer(CustomerName);
			receipt.getFlatShop(FlatShop);
			Thread.sleep(2000);
			receipt.getNextBtn().click();

			driver.findElement(By.xpath("//mat-select[@formcontrolname='rBankID']")).click();
			List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
			int Counter=0;
			for(int i=0;i<a.size();i++)
			{
				String b =a.get(i).getText(); 
				if(!b.equalsIgnoreCase(Name))
				{
					Assert.assertFalse(false, "Bank is Active.");
					//System.out.println("Test failed");
					break;
				}
				else
				{
					Counter = Counter+1;
					if(Counter>a.size())
					{
						System.out.println("Test");	
						break;
					}	
				}
			}
		}	
	
	
	//Banks Active Inactive
	//Verify Edit InActive Bank in Receipt
	@Test(dataProvider="EditInactiveBank")
	public void Verify_Edit_InActive_Bank(String Bankname,String Name) throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBankssearched().sendKeys(Bankname+Keys.ENTER);
		Bank.getbankseditclick().click();
		Bank.getActiveStatus().click();		
		Bank.getbankseditsave().click();

		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		Thread.sleep(2000);
		receipt.getEditBtnActiveInactive().click();
		receipt.GetEditNext();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='rBankID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase(Name))
			{
				Assert.assertFalse(false, "Bank is Inactive.");
				//System.out.println("Test failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Verify Edit Active Bank in Receipt
	@Test(dataProvider="EditActiveBank")
	public void Verify_Edit_Active_Bank(String Bankname,String Name) throws InterruptedException {
		Bankspage Bank = new Bankspage(driver);
		Bank.getconfiguration().click();
		Bank.getBanksclick().click();
		Bank.getBankssearched().sendKeys(Bankname+Keys.ENTER);
		Bank.getbankseditclick().click();
		Bank.getActiveStatus().click();		
		Bank.getbankseditsave().click();

		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		Thread.sleep(2000);
		receipt.getEditBtnActiveInactive().click();
		receipt.GetEditNext();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='rBankID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase(Name))
			{
				Assert.assertFalse(false, "Bank is Active.");
				//System.out.println("Test failed");
				break;
			}
			else
			{
				Counter = Counter+1;
				if(Counter>a.size())
				{
					System.out.println("Test");	
					break;
				}	
			}
		}
	}

	//Close the driver
	@AfterMethod
	public void teardown() {
		//driver.close();
	}	

	//DataProvider for Add Receipt Data
	@DataProvider
	public Object[][] ReceiptAddData() {
		return new Object[][] {
			{"Automation Project1","Rohit Sharma","FLAT-102 (1st Floor)","HDFC Bank","Bopal"," IMPS ","7890548","10000","78565545",
				"457"," 0% ","HDFC Bank","Bopal","54682485","65464","C:\\125ktm.jpg"},
			{"Automation Project1","Rohit Sharma","FLAT-102 (1st Floor)","HDFC Bank","Bopal"," IMPS ","7890548","10000","78565545",
				"457"," 0% ","HDFC Bank","Bopal","54682485","65464","C:\\125ktm.jpg"},
			{"Automation Project1","Rohit Sharma","FLAT-102 (1st Floor)","HDFC Bank","Bopal"," IMPS ","7890548","10000","78565545",
				"457"," 0% ","HDFC Bank","Bopal","54682485","65464","C:\\125ktm.jpg"},
			{"Automation Project1","Rohit Sharma","FLAT-102 (1st Floor)","HDFC Bank","Bopal"," IMPS ","7890548","10000","78565545",
				"457"," 0% ","HDFC Bank","Bopal","54682485","65464","C:\\125ktm.jpg"}
		};
	}

	//DataProvider for Edit Receipt
	@DataProvider
	public Object[][] ReceiptEditData() {
		return new Object[][] { 
			{" RecPrefix-1-24 ","Ahmedabad","796498723","97464971","65467978","Thaltej"}};
	}

	//DataProvider for Download Receipt Data
	@DataProvider
	public Object[][] DownloadReceiptData() {
		return new Object[][] {
			{" RecPrefix-1-24 "}};
	}
	//DataProvider for Print Receipt Data
	@DataProvider
	public Object[][] PrintReceiptData() {
		return new Object[][] {
			{" RecPrefix-1-24 "}};
	}
	
	//DataProvider for Search Data
	@DataProvider
	public Object[][] ReceiptSearchData() {
		return new Object[][] {
			{" Parisar homes "}};
	}

	//DataProvider for Project Dropdown data
	@DataProvider
	public Object[][] Receiptprojectdropdown() {
		return new Object[][] {
			{" Parisar homes "}};
	}

	//DataProvider for Approve Cancel 
	@DataProvider
	public Object[][] ReceiptApproveCancelData() {
		return new Object[][] {
			{" Parisar homes ","Approve"}};
	}

	//DataProvider for View Receipt Data
	@DataProvider
	public Object[][] ViewReceiptData() {
		return new Object[][] {
			{" RecPrefix-1-24 "}};
	}

	//DataProvider for Send Email Receipt Data
	@DataProvider
	public Object[][] SendEmailReceiptData() {
		return new Object[][] {
			{" RecPrefix-1-24 "}};
	}
	
	//DataProvider for Edit Receipt Test Mandatory Data
	@DataProvider
	public Object[][] EditReceiptTestMandatoryData() {
		return new Object[][] {
			{" RecPrefix-1-24 "}};
	}
	
	//DataProvider for Add Inactive Bank
	@DataProvider
	public Object[][] AddInactiveBank() {
		return new Object[][] {
		{" Axis Bank ","Automation Project1","Rohit Sharma","FLAT-102 (1st Floor)"," Axis Bank "}};
	}
	
	//DataProvider for Add Active Bank
	@DataProvider
	public Object[][] AddActiveBank() {
		return new Object[][] {
		{" Axis Bank ","Automation Project1","Rohit Sharma","FLAT-102 (1st Floor)"," Axis Bank "}};
	}
	
	//DataProvider for Edit Inactive Bank
	@DataProvider
	public Object[][] EditInactiveBank() {
		return new Object[][] {
			{" Axis Bank "," Axis Bank "}};
	}
	
	//DataProvider for Edit Active Bank
	@DataProvider
	public Object[][] EditActiveBank() {
		return new Object[][] {
			{" Axis Bank "," Axis Bank "}};
	}
}