package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Constructor
	public HomePage(WebDriver driver) 
	{
		super(driver); // Passing the driver to 'BasePage' class
	}
	
	
	
	// Locators

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement txtMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement txtRegAccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement txtLogin;
	
	
	// Methods
	
	public void clickAccount()
	{
		txtMyAccount.click();
	}
	
	public void clickRegAccount() 
	{
		txtRegAccount.click();
	}
	
	public void clickLogin()
	{
		txtLogin.click();
	}
	
	
}
