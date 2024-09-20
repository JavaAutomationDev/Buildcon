package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
    public WebDriver driver;
    //creating driver constructor
    public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
    //page object for Remember Me
  	By remember = By.xpath("//div[@class='mdc-checkbox']");
  	public WebElement getremember() {
  		return driver.findElement(remember);
  	}
    //page object for visible password
  	By visiblepass = By.xpath("//button[@type='button']");
  	public WebElement getvisible() {
  		return driver.findElement(visiblepass);
  	}
    //page object for Login Text
    By title = By.xpath("//p[normalize-space()='Sign in with your credentials below.']");
	public WebElement gettitle() {
		return driver.findElement(title);
	}
	//page object for Account Name
	By AccountName = By.xpath("//input[@formcontrolname='agencyName']");
	public WebElement getAccountName() {
		return driver.findElement(AccountName);
	}
    //page object for User Name
    By UserName = By.xpath("//input[@formcontrolname='userName']");
	public WebElement getUserName() {
		return driver.findElement(UserName);
	}
	//page object for passowrd
	By pass = By.xpath("//input[@formcontrolname='password']");
	public WebElement getpass() {
		return driver.findElement(pass);
	}
	//page object for SignIn button
	By signIn = By.xpath("/html/body/vex-root/app-login/div/div[2]/div/div/form/div/button");
	public WebElement getsignIn() {
		return driver.findElement(signIn);
	}
}
