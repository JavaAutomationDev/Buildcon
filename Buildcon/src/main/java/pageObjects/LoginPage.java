package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LoginPage {
	
    public WebDriver driver;
 
    public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
    //Page object for Remember Me
  	By remember = By.xpath("//div[@class='mdc-checkbox']");
  	public WebElement getremember() {
  		base.failedElementName = "Login-Remember";
  		return driver.findElement(remember);
  	}
    //Page object for visible password
  	By visiblepass = By.xpath("//button[@type='button']");
  	public WebElement getvisible() {
  		base.failedElementName = "Login-visiblepass";
  		return driver.findElement(visiblepass);
  	}
    //Page object for Login Text
    By title = By.xpath("//p[normalize-space()='Sign in with your credentials below.']");
	public WebElement gettitle() {
		base.failedElementName = "Login-title";
		return driver.findElement(title);
	}
	//Page object for Account Name
	By AccountName = By.xpath("//input[@formcontrolname='agencyName']");
	public WebElement getAccountName() {
		base.failedElementName = "Login-AccountNo";
		return driver.findElement(AccountName);
	}
    //Page object for User Name
    By UserName = By.xpath("//input[@formcontrolname='userName']");
	public WebElement getUserName() {
		base.failedElementName = "Login-UserName";
		return driver.findElement(UserName);
	}
	//Page object for Passowrd
	By pass = By.xpath("//input[@formcontrolname='password']");
	public WebElement getpass() {
		base.failedElementName = "Login-Password";
		return driver.findElement(pass);
	}
	//Page object for Sign In Button
	By signIn = By.xpath("/html/body/vex-root/app-login/div/div[2]/div/div/form/div/button");
	public WebElement getsignIn() {
		base.failedElementName = "Login-signin";
		return driver.findElement(signIn);
	}
}