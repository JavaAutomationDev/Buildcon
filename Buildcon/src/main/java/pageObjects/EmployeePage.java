package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeePage {
	public WebDriver driver;

	public EmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	//Page object for click Employee module
	By Employee = By.xpath("//vex-sidenav-item[9]//a[1]");
	public WebElement getEmployee() {
		return driver.findElement(Employee);
	}
	//Page object for Add Employee
	By Addemployee = By.xpath("//span[contains(text(),'Add New Employee')]");
	public WebElement getaddemployee() {
		return driver.findElement(Addemployee);
	}
	//Page object for Profile Image
	By profileimg= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[1]/label/input");
	public WebElement getProfileImg() {
		return driver.findElement(profileimg);
	}

	//Page object for First Name
	By firstName= By.xpath("//input[@formcontrolname='firstName']");
	public WebElement getfname() {
		return driver.findElement(firstName);
	}
	//Page object for Middle Name
	By  middleName= By.xpath("//input[@formcontrolname='middleName']");
	public WebElement getmname() {
		return driver.findElement(middleName);
	}
	//Page object for Last Name
	By lastName= By.xpath("//input[@formcontrolname='lastName']");
	public WebElement getlname() {
		return driver.findElement(lastName);
	}
	//Page object for User Name
	By username= By.xpath("//input[@formcontrolname='userName']");
	public WebElement getUserName() {
		return driver.findElement(username);
	}

	//Page object for Designation
	By Designation= By.xpath("//input[@formcontrolname='designation']");
	public WebElement getDesignation() {
		return driver.findElement(Designation);
	}
	//Page object for DOB
	By dob= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save/div/form/"
			+ "mat-dialog-content/div[2]/div[4]/div/div[3]/mat-form-field/div[1]/div[2]/div[2]/input");
	public WebElement getDOB() {
		return driver.findElement(dob);
	}
	//Page object for Email
	By Email= By.xpath("//input[@formcontrolname='email']");
	public WebElement getEmail() {
		return driver.findElement(Email);
	}
	//Page object for Roles
	By Roles= By.xpath("//mat-select[@formcontrolname='roleRightId']");
	public void getRoles(String Role) {
		WebElement dropdown = driver.findElement(Roles);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + Role + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for City
	By City= By.xpath("//input[@formcontrolname='city']");
	public WebElement getcity() {
		return driver.findElement(City);
	}
	//Page object for State
	By state= By.xpath("//mat-select[@formcontrolname='stateId']");
	public void getstate(String State) {
		WebElement dropdown = driver.findElement(state);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + State + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
	}
	//Page object for Mobile no
	By mobileno= By.xpath("//input[@formcontrolname='mobile']");
	public WebElement getMobileno() {
		return driver.findElement(mobileno);
	}
	//Page object for Password
	By password= By.xpath("//input[@formcontrolname='password']");
	public WebElement getPassword() {
		return driver.findElement(password);
	}	

	//Page object for Address
	By Address= By.xpath("//textarea[@formcontrolname='address']");
	public WebElement getAddress() {
		return driver.findElement(Address);
	}

	//Page object for Project Access
	By projectaccess= By.xpath("//mat-select[@formcontrolname='projectId']");
	public void getProjectAccess(String Proejct) {
		WebElement dropdown = driver.findElement(projectaccess);
		dropdown.click();
		String optionXPath = "//mat-option//span[contains(text(),'" + Proejct + "')]";
		WebElement option = driver.findElement(By.xpath(optionXPath));
		option.click();
		dropdown.sendKeys(Keys.ESCAPE); 
	}

	//Page object for Aadhar card
	By Adharcard= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[2]/div[8]/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement uploadAdharCard() {
		return driver.findElement(Adharcard);
	}

	//Page object for Pan card
	By Pancard= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[2]/div[8]/div/div[2]/mat-form-field/div[1]/div[2]/div[2]/input[2]");
	public WebElement getPancard() {
		return driver.findElement(Pancard);
	}
	//Page object for Select Gender
	By Gender= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-save"
			+ "/div/form/mat-dialog-content/div[3]/div[1]/mat-radio-group/mat-radio-button[1]/div/label");
	public WebElement SelectGender() {
		return driver.findElement(Gender);
	}
	//Page object for Next Button
	By Nextbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/"
			+ "app-employee-save/div/form/mat-dialog-actions/button[1]");
	public WebElement Nextbtn() {
		return driver.findElement(Nextbtn);
	}	
	//Page object for Show phone number
	By shownumber= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles"
			+ "/div/vex-roles-form/form/mat-dialog-content/div[1]/div/mat-checkbox/div/div/input");
	public WebElement Shownumber() {
		return driver.findElement(shownumber);
	}

	//Page object for Employee radio btn
	By empradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div/div[2]/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Empradiobtn() {
		return driver.findElement(empradiobtn);
	}
	//Page object for Project radio btn
	By projectradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div/div[2]/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Projectradiobtn() {
		return driver.findElement(projectradiobtn);
	}
	//Page object for Receipt radio btn
	By receiptradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Receiptradiobtn() {
		return driver.findElement(receiptradiobtn);
	}
	//Page object for Collection radio btn
	By collectionradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[5]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Collectionradiobtn() {
		return driver.findElement(collectionradiobtn);
	}
	//Page object for Customer radio btn
	By customerradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[6]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Customerradiobtn() {
		return driver.findElement(customerradiobtn);
	}
	//Page object for Inquiry radio btn
	By inquiryradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[7]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Inquiryradiobtn() {
		return driver.findElement(inquiryradiobtn);
	}
	//Page object for Prospect radio btn
	By prospectradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[8]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Prospectradiobtn() {
		return driver.findElement(prospectradiobtn);
	}
	//Page object for Bookings radio btn
	By bookingradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[9]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Bookingsradiobtn() {
		return driver.findElement(bookingradiobtn);
	}
	//Page object for Documents radio btn
	By documentradiobtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[10]/div/div[2]/div/mat-radio-group/mat-radio-button[1]/div/div/input");
	public WebElement Documentsradiobtn() {
		return driver.findElement(documentradiobtn);
	}
	//Page object for Create btn
	By createbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/"
			+ "div/app-employee-roles/div/mat-dialog-actions/button[1]");
	public WebElement Createbtn() {
		return driver.findElement(createbtn);
	}
	
	//Add Employee with All Modules - Only View
	//Page object for Employee radio btn
	By empselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div[1]/div[2]/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement EmpSelectbtn() {
		return driver.findElement(empselectbtn);
	}
	//Page object for Employee Entry
	By empentry= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div[2]/mat-checkbox[2]/div/div/input");
	public WebElement EmpEntry() {
		return driver.findElement(empentry);
	}
	//Page object for Employee Modify
	By empmodify= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div[2]/mat-checkbox[3]/div/div/input");
	public WebElement Empmodify() {
		return driver.findElement(empmodify);
	}
	//Page object for Employee Remove
	By empremove= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div[2]/mat-checkbox[4]/div/div/input");
	public WebElement EmpRemove() {
		return driver.findElement(empremove);
	}
	//Page object for Employee Export
	By empexport= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[2]/div[2]/mat-checkbox[5]/div/div/input");
	public WebElement EmpExport() {
		return driver.findElement(empexport);
    }
	
	//Page object for Project radio btn
	By projectselectbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div[1]/div[2]/mat-radio-group/mat-radio-button[2]");
	public WebElement Projectselectbtn() {
		return driver.findElement(projectselectbtn);
	}
	//Page object for Project Entry
	By projectentry= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div[2]/mat-checkbox[2]/div/div/input");
	public WebElement ProjectEntry() {
		return driver.findElement(projectentry);
	}
	//Page object for Project Modify
	By projectmodify= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div[2]/mat-checkbox[3]/div/div/input");
	public WebElement Projectmodify() {
		return driver.findElement(projectmodify);
	}
	//Page object for Project Remove
	By projectremove= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div[2]/mat-checkbox[4]/div/div/input");
	public WebElement ProjectRemove() {
		return driver.findElement(projectremove);
	}
	//Page object for Project Export
	By projectexport= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[3]/div[2]/mat-checkbox[5]/div/div/input");
	public WebElement ProjectExport() {
		return driver.findElement(projectexport);
    }
	
	//Page object for Receipt radio btn
	By receiptselecbtn= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement Receiptselectbtn() {
		return driver.findElement(receiptselecbtn);
    }
	//Page object for Receipt Entry
	By receiptentry= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div[2]/mat-checkbox[2]/div/div/input");
	public WebElement ReceiptEntry() {
		return driver.findElement(receiptentry);
    }
	//Page object for Receipt Modify
	By receiptmodify= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div[2]/mat-checkbox[3]/div/div/input");
	public WebElement ReceiptModify() {
		return driver.findElement(receiptmodify);
	}
	//Page object for Receipt Remove
	By receiptremove= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div[2]/mat-checkbox[4]/div/div/input");
	public WebElement ReceiptRemove() {
		return driver.findElement(receiptremove);
    }
	//Page object for Receipt Export
	By receiptexport= By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[4]/div[2]/mat-checkbox[5]/div/div/input");
	public WebElement ReceiptExport() {
		return driver.findElement(receiptexport);
    }
	
	
	
	
	
	
	
	
	
	
	//Page object for Collection radio btn
	By collectionselectbtn=By.xpath("");
	public WebElement Collectionselectbtn() {
	return driver.findElement(collectionradiobtn);
	}
	
	//Page object for Collection Export
	By collectionexport=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[5]/div[2]/mat-checkbox[2]/div/div/input");
	public WebElement Collectionexport() {
	return driver.findElement(collectionexport);
	}
	//Page object for Customer radio btn
	By customerselectbtn=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[6]/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/div/div/input");
	public WebElement Customerselectbtn() {
		return driver.findElement(customerselectbtn);
	}
	//Page object for Customer Export
	By customerexport=By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/app-employee-roles/div/"
			+ "vex-roles-form/form/mat-dialog-content/div[6]/div[2]/mat-checkbox[2]/div/div/input");
	public WebElement CustomerExport() {
		return driver.findElement(customerexport);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Page object for Search
		By Search = By.xpath("//input[@type='search']");
		public WebElement getSearch() {
			return driver.findElement(Search);
		}
		//Page object for Apply Filter
		By filter = By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
				+ "mat-sidenav-content/main/app-employees/div/div[1]/div[2]/div[3]/button");
		public void Applyfilter(String Filter) {
			WebElement dropdown = driver.findElement(filter);
			dropdown.click();
			String optionXPath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + Filter + "')]";
			WebElement option = driver.findElement(By.xpath(optionXPath));
			option.click();
		}
		//Page object for Export to Excel
		By ExporttoExcel=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
				+ "mat-sidenav-content/main/app-employees/div/div[1]/div[2]/div[4]/button");
		public WebElement ExporttoExcel() {
			return driver.findElement(ExporttoExcel);
		}
		//Page object for Delete Employee
        By deleteemp=By.xpath("/html/body/vex-root/vex-custom-layout/vex-layout/div/mat-sidenav-container/"
        		+ "mat-sidenav-content/main/app-employees/div/div[2]/div/div[2]/div[2]/ul/li[3]/a");
        public void deleteEmployeeByName(String employeeName) {
            By employeeLocator = By.xpath("//li[contains(text(), '" + employeeName + "')]");
            WebElement employeeElement = driver.findElement(employeeLocator);
            employeeElement.findElement(deleteemp).click();
        }
      //Page object for click yes
    	By ClickYes = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/div/div/vex-delete-pop-up"
    			+ "/form/mat-dialog-actions/button[1]");
    	public WebElement getClickYes() {
    		return driver.findElement(ClickYes);
    	}
        







}