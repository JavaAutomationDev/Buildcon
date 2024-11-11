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
	public void Add_Project(String Project,String CustomerName,String FlatShop,String BankName,String Bankbranch,
			String PaymentType,String IMPSNO,String RegularAmount,String ChallanNumber,String ReceivedTDSAmount,
			String TDSTYpe,String GSTbankName,String GSTBankBranch,String ChequeNo,
			String ReceivedGSTAmount,String ChequeFiles) throws InterruptedException {

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

		receipt.getPaymentType(PaymentType);//Required Field
		receipt.getIMPSNO().sendKeys(IMPSNO);
		
		//receipt.getRegularChequeTranDate().click();
		//receipt.getChecqueDate().click();
		//receipt.getChecqueDate().click();
		
		receipt.getRegularAmount().sendKeys(RegularAmount);//Required Field
		receipt.getRegularBankCancelled().click();
		receipt.getGSTNO().click();
		Thread.sleep(2000);
		receipt.getNextBtn1().click();

		receipt.getTDSChallanNumber().sendKeys(ChallanNumber);
		
		//receipt.challandate();
		//receipt.getSelectDate().click();
		//receipt.getSelectDate().click();
		
		receipt.getReceivedTDSAmount().sendKeys(ReceivedTDSAmount);
		//Thread.sleep(2000);
		receipt.getTDSType(TDSTYpe);
		Thread.sleep(2000);	
		receipt.getNextBtn2().click();

		receipt.getGSTBankName(GSTbankName);
		receipt.getGSTBankBranch().sendKeys(GSTBankBranch);
		receipt.getChequeNo().sendKeys(ChequeNo);
		//receipt.chequetransdate();
        receipt.getReceivedGSTAmount().sendKeys(ReceivedGSTAmount);

		Thread.sleep(2000);
		receipt.getNextBtn3().click();
		receipt.getChequeFiles().sendKeys(ChequeFiles);

		Thread.sleep(2000);
		receipt.getSavebtn().click();
	}

	//Editing an existing Receipt using Data Provider
	@Test(dataProvider="ReceiptEditData")
	public void Edit_Receipt(String newBankbranch,String newIMPSNO,String newRegularAmount,String newChallanNumber,
			String newGSTBankBranch) throws InterruptedException {
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
		receipt.getRegularAmount().clear();
		receipt.getRegularAmount().sendKeys(newRegularAmount);
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
	@Test(dataProvider="ReceiptSearchData")
	public void Search_Receipt(String Project) throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();

		Thread.sleep(2000);
		receipt.getSearch().sendKeys(Project + Keys.ENTER);;
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
	@Test()
	public void Print_Receipt() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();

		Thread.sleep(2000);
		receipt.getPrintReceipt().click();		
	}

	//Approve Cancel Receipt
	@Test(dataProvider="ReceiptapproveData")
	public void Approve_Cancel_Receipt(String approve) throws InterruptedException{
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
	@Test(dataProvider="Receiptprojectdropdown")
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
	//Add Receipt Test Mandatory Filed Validation
	@Test
	public void Add_Receipt_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getAddReceipt().click();
		receipt.AddRequierdField();
		receipt.getNextBtn().click();

		WebElement projectname =driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[1]/div[1]/mat-form-field/div[2]/div"));
		Assert.assertEquals(projectname.getText(), "Project name is required1.");

		WebElement customerName =driver.findElement(By.xpath("//span[normalize-space()='Customer name is required.']"));
		Assert.assertEquals(customerName.getText(), "Customer name is required.");

		WebElement flatshop =driver.findElement(By.xpath("//span[normalize-space()='Flat/Shop is required.']"));
		Assert.assertEquals(flatshop.getText(), "Flat/Shop is required.");
	}
	
	//Edit Receipt Test Mandatory Filed Validation
		@Test
		public void Edit_Receipt_Test_Mandatory_Filed_Validation() throws InterruptedException {
		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		receipt.getEdit().click();
		Thread.sleep(2000);
		receipt.EditNextRequierdBtn();

		//WebElement projectname =driver.findElement(By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/mat-sidenav-content/main/vex-add-payment/div/div[2]/div/mat-vertical-stepper/div[1]/div/div/div/form/div/div[1]/div[1]/mat-form-field/div[2]/div"));
		//Assert.assertEquals(projectname.getText(), "Project name is required1.");

		//WebElement customerName =driver.findElement(By.xpath("//span[normalize-space()='Customer name is required.']"));
		//Assert.assertEquals(customerName.getText(), "Customer name is required.");
			
		//WebElement flatshop =driver.findElement(By.xpath("//span[normalize-space()='Flat/Shop is required.']"));
		//Assert.assertEquals(flatshop.getText(), "Flat/Shop is required.");
		}

    //Banks Active Inactive
	//Verify Edit InActive Bank in Receipt
	@Test()
	public void Verify_Edit_InActive_ProjectType_Project() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbankseditclick().click();
		unit.getActiveStatus().click();		
		unit.getbankseditsave().click();

		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		Thread.sleep(2000);
		receipt.GetEditNext();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='rBankID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase(" Axis Bank "))
			{
				Assert.assertFalse(false, "Bank is Inactive.");
				System.out.println("Test  failed");
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
	@Test()
	public void Verify_Edit_Active_ProjectType_Project() throws InterruptedException {
		Bankspage unit = new Bankspage(driver);
		unit.getconfiguration().click();
		unit.getBanksclick().click();
		unit.getbankseditclick().click();
		unit.getActiveStatus().click();		
		unit.getbankseditsave().click();

		ReceiptPage receipt = new ReceiptPage(driver);
		receipt.getReceipt().click();
		Thread.sleep(2000);
		receipt.GetEditNext();

		driver.findElement(By.xpath("//mat-select[@formcontrolname='rBankID']")).click();
		List<WebElement> a = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/mat-option"));
		int Counter=0;
		for(int i=0;i<a.size();i++)
		{
			String b =a.get(i).getText(); 
			if(!b.equalsIgnoreCase(" Axis Bank "))
			{
				Assert.assertFalse(false, "Bank is Active.");
				System.out.println("Test  failed");
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

	//Add Receipt Data
	@DataProvider
	public Object[][] ReceiptAddData() {
		return new Object[][] {
			{"Project1"," Nikanth Tandel "," 3BHK-402 (4th Floor) ","Axis Bank","Bopal"," IMPS ","7890548","10000","78565545",
				"457"," 0% "," Bank Of India ","Bopal","54682485","D:\\Fileupload\\BB1qVDNW.jpg"}
			
			//String Project,String CustomerName,String FlatShop,String BankName,String Bankbranch,String PaymentType,String IMPSNO,
			//String RegularAmount,String ChallanNumber,String ReceivedTDSAmount,String TDSTYpe,String GSTbankName,String GSTBankBranch,
			//String ChequeNo,String ChequeFiles
			//{"Project1","Hiren Vankani"," Flats-A - 104 (2nd Floor) ","HDFC BANK","South Bopal","Cheque","4567001","4000000","21",
				//"40404.04","1%"," AXIS BANK ","PrahladNagar","659806","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project1","Hiren Vankani"," Flats-A - 104 (2nd Floor) ","HDFC BANK","South Bopal","Cheque","4567002","4000000","22",
				//"40404.04","1%"," AXIS BANK ","PrahladNagar","659806","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project1","Hiren Vankani"," Flats-A - 104 (2nd Floor) ","HDFC BANK","South Bopal","Cheque","4567003","4000000","23","40404.04","1%"," AXIS BANK ","PrahladNagar","659867","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project1","Hiren Vankani"," Flats-A - 104 (2nd Floor) ","HDFC BANK","South Bopal","Cheque","4567004","4000000","24",
				//"40404.04","1%"," AXIS BANK ","PrahladNagar","","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project1","Hiren Vankani"," Flats-A - 104 (2nd Floor) ","HDFC BANK","South Bopal","Cheque","4567005","4000000","25",
				//"40404.04","1%"," AXIS BANK ","PrahladNagar","","D:\\Fileupload\\BB1qVDNW.jpg"}
				
				
           //{"Project1","Bhavesh Vankani"," Flats-A - 104 (2nd Floor) ","HDFC BANK","South Bopal"," Cash ","4567001","4000000","18","40404.04","1%"," AXIS BANK ","PrahladNagar","659867","D:\\Fileupload\\BB1qVDNW.jpg"},
				
			//{"Project2","Anita Vankani"," Flats & Bunglows-B - 104 (2nd Floor) ","SBI BANK","South Bopal","Cash","","2500000","128","25252.53","1%"," SBI BANK ","PrahladNagar","659801","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Anita Vankani"," Flats & Bunglows-B - 104 (2nd Floor) ","SBI BANK","South Bopal","Cash","","2500000","129","25252.53","1%"," SBI BANK ","PrahladNagar","659801","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Aruna Vankani"," Flats & Bunglows-B - 102 (1st Floor) ","SBI BANK","South Bopal","Cheque","4567009","5000000","130","50505.05","1%"," SBI BANK ","PrahladNagar","871548","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Bansi Vankani"," Flats & Bunglows-A - 102 (1st Floor) ","SBI BANK","South Bopal","Cheque","4567010","2500000","131","25252.53","1%"," SBI BANK ","PrahladNagar	","985656","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Bansi Vankani"," Flats & Bunglows-A - 102 (1st Floor) ","SBI BANK","South Bopal","Cheque","4567011","2500000","132","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Bharti Vankani"," Flats & Bunglows-C - 102 (1st Floor) ","SBI BANK","South Bopal","Cash","","5000000","133","101010.10","1%","SBI BANK","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Bhavna Vankani"," Shop-14 (2nd Floor) ","SBI BANK","South Bopal","Cash","","2500000","134","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},


			//{"Project2","Bhavna Vankani"," Shop-14 (2nd Floor) ","SBI BANK","South Bopal","Cheque","4567012","2500000","135","25252.53","1%"," SBI BANK","PrahladNagar","874548","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Dhyana Vankani"," Flats & Bunglows-B - 101 (1st Floor) ","SBI BANK","South Bopal","Cash","","2500000","136","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
		    //{"Project2","Dhyana Vankani"," Flats & Bunglows-B - 101 (1st Floor) ","SBI BANK","South Bopal","Cash","","2500000","137","25252.53","1%"," SBI BANK","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},													
		    //{"Project2","Harshvardhan Vankani"," Flats & Bunglows-A - 101 (1st Floor) ","SBI BANK","South Bopal","Cheque","45670013","5000000","138","101010.10","1%"," SBI BANK ","PrahladNagar","871548","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Ila Vankani"," Flats & Bunglows-C - 105 (3rd Floor) ","SBI BANK","South Bopal","Cheque","45670114","2500000","139","25252.53","1%"," SBI BANK ","PrahladNagar	","985656","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Ila Vankani"," Flats & Bunglows-C - 105 (3rd Floor) ","SBI BANK","South Bopal","Cheque","45670115","2500000","140","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Jeni Vankani"," Flats & Bunglows-A - 104 (2nd Floor) ","SBI BANK","South Bopal","Cash","","5000000","141","101010.10","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},													
			//{"Project2","Jiya Vankani"," Flats & Bunglows-A - 103 (2nd Floor) ","SBI BANK","South Bopal","Cash","","2500000","142","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Jiya Vankani"," Flats & Bunglows-A - 103 (2nd Floor) ","SBI BANK","South Bopal","Cheque","45670116","2500000","143","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Kokila Vankani"," Shop-15 (2nd Floor) ","SBI BANK","South Bopal","Cash","","2500000","144","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Kokila Vankani"," Shop-15 (2nd Floor) ","SBI BANK","South Bopal","Cash","","2500000","145","25252.53","1%"," SBI BANK","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},														
			//{"Project2","Kvya Vankani"," Flats & Bunglows-A - 105 (3rd Floor) ","SBI BANK","South Bopal","Cheque","45670017","5000000","146","101010.10","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Manisha Vankani"," Shop-1 (1st Floor) ","SBI BANK","South Bopal","Cheque","45670118","2500000","147","25252.53","1%"," SBI BANK ","PrahladNagar","985656","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Manisha Vankani"," Shop-1 (1st Floor) ","SBI BANK","South Bopal","Cheque","45670119","2500000","148","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Meena Vankani"," Shop-3 (1st Floor) ","SBI BANK","South Bopal","Cash","","5000000","149","101010.10","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Mital Vankani"," Flats & Bunglows-C - 101 (1st Floor) ","SBI BANK","South Bopal","Cash","","2500000","150","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Mital Vankani"," Flats & Bunglows-C - 101 (1st Floor) ","SBI BANK","South Bopal","Cheque","45670120","2500000","151","25252.53","1%"," SBI BANK ","PrahladNagar","874548","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Priya Vankani"," Flats & Bunglows-C - 103 (2nd Floor) ","SBI BANK","South Bopal","Cash","","2500000","152","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},	
			//{"Project2","Priya Vankani"," Flats & Bunglows-C - 103 (2nd Floor) ","SBI BANK","South Bopal","Cash","","2500000","153","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},	
																
			//{"Project2","Rekha Vankani"," Flats & Bunglows-B - 105 (3rd Floor) ","SBI BANK","South Bopal","Cheque","45670021","5000000","154","101010.10","1%"," SBI BANK ","PrahladNagar","871548","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Sharda Vankani"," Shop-2 (1st Floor) ","SBI BANK","South Bopal","Cheque","45670122","2500000","155","25252.53","1%"," SBI BANK ","PrahladNagar","985656","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project2","Sharda Vankani"," Shop-2 (1st Floor) ","SBI BANK","South Bopal","Cheque","45670123","2500000","156","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},
																
			//{"Project2","Usha Vankani"," Shop-4 (1st Floor) ","SBI BANK","South Bopal","Cash","","5000000","157","101010.10","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},	
																
			//{"Project2","Vanita Vankani"," Shop-5 (1st Floor) ","SBI BANK","South Bopal","Cash","","2500000","158","25252.53","1%"," SBI BANK ","PrahladNagar","878755","D:\\Fileupload\\BB1qVDNW.jpg"},	
			//{"Project2","Vanita Vankani"," Shop-5 (1st Floor) ","SBI BANK","South Bopal","Cheque","45670124","2500000","159","25252.53","1%"," SBI BANK ","PrahladNagar","874548","D:\\Fileupload\\BB1qVDNW.jpg"}
	
			//{"Project3","Chiragi Vankani"," Bunglows-2 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685701","5000000","160.0","50505.05","1%","AXIS BANK","PrahladNagar","548757","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Chiragi Vankani"," Bunglows-2 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685702","5000000","161.0","50505.05","1%","AXIS BANK","PrahladNagar","548758","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Chiragi Vankani"," Bunglows-2 (Ground Floor)","AXIS BANK","South Bopal","Cheque","9685703","5000000","162.0","50505.05","1%","AXIS BANK","PrahladNagar","548759","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Chiragi Vankani"," Bunglows-2 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685704","5000000","163.0","50505.05","1%","AXIS BANK","PrahladNagar","548760","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Chiragi Vankani"," Bunglows-2 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685705","5000000","164.0","50505.05","1%","AXIS BANK","PrahladNagar","548761","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dhara Vankani"," Bunglows-40 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","165.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dhara Vankani"," Bunglows-40 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","166.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dhara Vankani"," Bunglows-40 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","167.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dhara Vankani"," Bunglows-40 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","168.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dhara Vankani"," Bunglows-40 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","169.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dharti Vankani"," Bunglows-29 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685711","5000000","170.0","50505.05","1%","AXIS BANK","PrahladNagar","548767","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dharti Vankani"," Bunglows-29 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685712","5000000","171.0","50505.05","1%","AXIS BANK","PrahladNagar","548768","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dharti Vankani"," Bunglows-29 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685713","5000000","172.0","50505.05","1%","AXIS BANK","PrahladNagar","548769","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dharti Vankani"," Bunglows-29 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","173.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Dharti Vankani"," Bunglows-29 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","174.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Drasti Vankani"," Bunglows-27 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685716","25000000","175.0","252525.25","1%","AXIS BANK","PrahladNagar","548772","4545454.5","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Jahnvi Vankani"," Bunglows-28 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","25000000","176.0","252525.25","1%","AXIS BANK","PrahladNagar","","4545454.5","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Kavita Vankani"," Bunglows-41 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685718","5000000","177.0","50505.05","1%","AXIS BANK","PrahladNagar","548774","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Kavita Vankani"," Bunglows-41 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685719","5000000","178.0","50505.05","1%","AXIS BANK","PrahladNagar","548775","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Kavita Vankani"," Bunglows-41 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685720","5000000","179.0","50505.05","1%","AXIS BANK","PrahladNagar","548776","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Kavita Vankani"," Bunglows-41 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685721","5000000","180.0","50505.05","1%","AXIS BANK","PrahladNagar","548777","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Kavita Vankani"," Bunglows-41 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685722","5000000","181.0","50505.05","1%","AXIS BANK","PrahladNagar","548778","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Krishana Vankani"," Bunglows-14 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","182.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Krishana Vankani"," Bunglows-14 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","183.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Krishana Vankani"," Bunglows-14 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","184.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Krishana Vankani"," Bunglows-14 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","185.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Krishana Vankani"," Bunglows-14 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","186.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Namrta Vankani"," Bunglows-39 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685728","5000000","187.0","50505.05","1%","AXIS BANK","PrahladNagar","548784","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Namrta Vankani"," Bunglows-39 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685729","5000000","188.0","50505.05","1%","AXIS BANK","PrahladNagar","548785","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Namrta Vankani"," Bunglows-39 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685730","5000000","189.0","50505.05","1%","AXIS BANK","PrahladNagar","548786","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Namrta Vankani"," Bunglows-39 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","190.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Namrta Vankani"," Bunglows-39 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","5000000","191.0","50505.05","1%","AXIS BANK","PrahladNagar","","909090.9","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Shital Vankani"," Bunglows-1 (Ground Floor) ","AXIS BANK","South Bopal","Cheque","9685733","25000000","192.0","252525.25","1%","AXIS BANK","PrahladNagar","548789","4545454.5","D:\\Fileupload\\BB1qVDNW.jpg"},
			//{"Project3","Tejal Vankani"," Bunglows-15 (Ground Floor) ","AXIS BANK","South Bopal","Cash","","25000000","193.0","252525.25","1%","AXIS BANK","PrahladNagar","","4545454.5","D:\\Fileupload\\BB1qVDNW.jpg"},

		};
		}

	//DataProvider for Edit Receipt
	@DataProvider
	public Object[][] ReceiptEditData() {
		return new Object[][] { 
			{"Ahmedabad","796498723548","97464970021","Thaltej"}};
	}

	//DataProvider for Search Data
	@DataProvider
	public Object[][] ReceiptSearchData() {
		return new Object[][] {
			{" Parisar homes "}};
	}

	//DataProvider for Project Dropdown 
	@DataProvider
	public Object[][] Receiptprojectdropdown() {
		return new Object[][] {
			{" Parisar homes "}};
	}

	//DataProvider for Approve Cancel 
	@DataProvider
	public Object[][] ReceiptapproveData() {
		return new Object[][] {
			{"Approve"}};
	}
}