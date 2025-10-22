package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	// Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	

	// Locators
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fieldFirstName;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement fieldsLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement fieldEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement fieldTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement fieldPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement fieldConfirmPassword;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement checkboxNo;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkboxPrivacy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirm;
	
	
	
	// Methods
	public void setFirstname(String first)
	{
		fieldFirstName.sendKeys(first);
	}
	
	public void setLastname(String last)
	{
		fieldsLastName.sendKeys(last);
	}
	
	public void setEmail(String email)
	{
		fieldEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		fieldTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String pwd)
	{
		fieldPassword.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String pwd)
	{
		fieldConfirmPassword.sendKeys(pwd);
	}
	
	public void selectNoChbk()
	{
		checkboxNo.click();
	}
	
	public void selectPrivacyOption() 
	{
		checkboxPrivacy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String checkMsg()
	{
		try
		{
			return (msgConfirm.getText());
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	
	
}
