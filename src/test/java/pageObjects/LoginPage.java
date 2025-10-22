package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPasswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	
	//Methods
	public void setEmail(String email)
	{
		txtEmailField.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPasswordField.sendKeys(password);
	}
	
	public void clickLoginBtn()
	{
		btnLogin.click();
	}
	
}
