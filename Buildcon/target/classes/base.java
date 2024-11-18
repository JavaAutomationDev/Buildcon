package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.commons.validator.routines.CurrencyValidator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public static WebElement failedElement;
	public static String failedElementName;

	Boolean res1;
	Boolean res2;
	static Boolean res3;
	static String finmsg;

	// create one menthod for driver initialization
	public WebDriver initializeDriver() throws IOException {

		// locate the properties file for the browser as chrome/FF/IE
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			// Disable the save password prompt
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = new ChromeDriver(options);
		} else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public String getscreenshot(String testname, WebDriver driver) throws IOException {
		// we first take as screen shot and save it in to virtual source file and then
		// will copy same to in physical file with failed test case name
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testname + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	// string validations
	// **********************************************************************
	public String validateText(String text, String mlabel, Integer min, Integer max) throws IOException {

		res1 = valid_text(text);
		res2 = valid_minleghtStr(text, min);
		res3 = valid_maxlenghtStr(text, max);

		if (res1) {
			// System.out.println(text + " is a Valid text");
			finmsg = mlabel + " is a Valid text - ";
		} else {
			// System.out.println(text + " is not a Valid text");
			finmsg = mlabel + " is not a Valid text - ";
		}

		if (res2) {
			// System.out.println(text + " is a valid Minlenght of: "+ min);
			finmsg = finmsg + "is a valid Minlenght - ";
		} else {
			// System.out.println(text + " is not a valid minlenght String");
			finmsg = finmsg + "is not a valid minlenght - ";
		}

		if (res3) {
			// System.out.println(text + " is a valid Maxlenght of: "+max);
			finmsg = finmsg + "is a valid Maxlenght";
		} else {
			// System.out.println(text + " is not a valid Maxlenght String");
			finmsg = finmsg + "is not a valid Maxlenght";
		}

		// System.out.println(finmsg);
		return finmsg;
	}

	// text validation
	public static Boolean valid_text(String text) {
		// String Validation
		boolean res = text.matches("^[a-zA-Z ]*$");
		 if(res)
	      {System.out.println(text + " is a Valid text");}
		 else {System.out.println(text + " is not a Valid text");}
		return res;
	}

	// text max length validation
	public static Boolean valid_maxlenghtStr(String maxlenghtString, int mnum) {
		// Max Lenght String Validation
		Boolean res = GenericValidator.maxLength(maxlenghtString, mnum);
		// if(res)
		// {System.out.println(maxlenghtString + " is a valid Maxlenght String");}
		// else {System.out.println(maxlenghtString + " is not a valid Maxlenght
		// String");}
		return res;
	}

	// text min length validation
	public static Boolean valid_minleghtStr(String minlenghtString, int mnum) {
		// Min Lenght String Validation
		Boolean res = GenericValidator.minLength(minlenghtString, mnum);
		// if(res)
		// {System.out.println(minlenghtString + " is a valid Minlenght String");}
		// else {System.out.println(minlenghtString + " is not a valid minlenght
		// String");}
		return res;
	}
	// string validations
	// *****************************************************************************

	// email validation
	public static String valid_EMail(String memail, String mlabel) {
		// Email Validation
		boolean res = GenericValidator.isEmail(memail);
		if (res) {
			// System.out.println(memail + " is a Valid EMail");
			finmsg = mlabel + " is a Valid EMail";
		} else {
			// System.out.println(memail + " is not a Valid Email");
			finmsg = mlabel + " is not a Valid EMail";
		}
		return finmsg;
	}

	// aadhar validation
	public static String valid_aadhar(String adhar, String mlabel) {
		// Aadhar Validation
		// Aadhaar should be a 12-digit number
		boolean res = adhar.matches("^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$");
		if (res) {
			System.out.println(adhar + " is a Valid Aadhar Number");
			finmsg = mlabel + " is a Valid Assdhar";
		} else {
			System.out.println(adhar + " is not a Valid Aadhar Number");
			finmsg = mlabel + " is not a Valid Assdhar";
		}
		return finmsg;
	}

	// pan validation
	public static String valid_pan(String pan, String mlabel) {
		// pan Validation
		// PAN should be in the format ABCDE1234F
		boolean res = pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		if (res) {
			System.out.println(pan + " is a Valid PAN Card");
			finmsg = mlabel + " is a Valid PAN";
		} else {
			System.out.println(pan + " is not a Valid PAN Card");
			finmsg = mlabel + " is not a Valid PAN";
		}
		return finmsg;
	}

	// number validation
	public static String valid_number(String mnum, String mlabel) {
		// Number Validation
		boolean res = GenericValidator.isLong(mnum);
		if (res) {
			System.out.println(mnum + " is a valid Number");
			finmsg = mlabel + " is a Valid Number";
		} else {
			System.out.println(mnum + " is not a valid Number");
			finmsg = mlabel + " is not a Valid Number";
		}
		return finmsg;
	}

	// Currency Validation
	public static String valid_currency(String curr, Locale locale, String mlabel) {
		BigDecimalValidator validator = CurrencyValidator.getInstance();

		BigDecimal amount = validator.validate(curr, locale);

		if (amount == null) {
			System.out.println(curr);
			System.out.println(locale);
			System.out.println(amount);
			System.out.println("Invalid amount/currency");
			finmsg = mlabel + " is not a valid amount/currency";
		} else {
			System.out.println(curr);
			System.out.println(locale);
			System.out.println(amount);
			System.out.println("Valid amount/currency.");
			finmsg = mlabel + " is a valid amount/currency";
		}
		return finmsg;

	}

	// AlphaNumeric validation
	public static String valid_alphanum(String alpha, String mlabel, Integer max) {
		// alpha numeric Validation
		 String finmsg = ""; 
		boolean res = alpha.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$");
		if (res) {
			System.out.println(alpha + " is a Valid AlphaNumeric");
			finmsg = mlabel + " is a Valid Alpha-Numeric";
		} else {
			System.out.println(alpha + " is not a Valid AlphaNumeric");
			finmsg = mlabel + " is not a Valid Alpha-Numeric";
		}
		
		boolean res3 = valid_maxlenghtStr(alpha, max);

		if (res3) {
			// System.out.println(text + " is a valid Maxlenght of: "+max);
			finmsg = finmsg + " is a valid Maxlenght";
		} else {
			// System.out.println(text + " is not a valid Maxlenght String");
			finmsg = finmsg + " is not a valid Maxlenght";
		}
		return finmsg;
	}

}
