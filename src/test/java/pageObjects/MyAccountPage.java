package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtMyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement txtLogout;
	
	
	// Methods
	public boolean exp_myAccount()
	{
		try
		{
			return (txtMyAccount.isDisplayed());
		} 
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		txtLogout.click();
	}
	
	
}
