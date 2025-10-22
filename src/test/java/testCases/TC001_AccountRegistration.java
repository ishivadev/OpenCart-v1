package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void registerUser()
	{
		try
		{
		logger.info("**** Starting TC001_AccountRegistration ****");
		
		// Home page 
		HomePage hp = new HomePage(driver);
		
		logger.info("Clicked on 'My Account'");
		hp.clickAccount();
		logger.info("Clicked on 'Register Account'");
		hp.clickRegAccount();
		
		
		// Registration page
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("Providing the User Details");
		regPage.setFirstname(randomFirstName().toUpperCase());
		regPage.setLastname(randomLastName().toUpperCase());
		regPage.setEmail(randomEmail()+"@gmail.com");
		regPage.setTelephone(randomTelephone());
		
		String pwd = randomPassword();
		
		regPage.setPassword(pwd);
		regPage.setConfirmPwd(pwd);
		regPage.selectNoChbk();
		regPage.selectPrivacyOption();
		regPage.clickContinue();
		String response_msg = regPage.checkMsg();
		
		if(response_msg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account creation successful");
			Assert.assertTrue(true);
		}
		else 
		{
			
			logger.error("Test failed..");
			logger.debug("Debbuger statement..");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(response_msg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC001_AccountRegistration ****");
	}
	

}
