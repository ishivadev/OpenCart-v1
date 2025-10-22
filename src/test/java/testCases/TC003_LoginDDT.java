package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String res)
	{
		logger.info("**** Started TC003_LoginTestDDT **** ");
		
		try
		{
			//Home Page
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			hp.clickLogin();
			
			//Login Page
			LoginPage lg = new LoginPage(driver);
			lg.setEmail(email);
			lg.setPassword(pwd);
			lg.clickLoginBtn();
			
			//MyAccount Page
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean exp_targetPage_text = myacc.exp_myAccount();
			
			
			// Data is valid - Login Success  - Test Passed - Logout
			// Data is valid - Login Failed   - Test Failed 
			 		
			if(res.equalsIgnoreCase("valid"))
			{
				if(exp_targetPage_text == true)
				{
					myacc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			// Data is invalid - Login Success  - Test Failed - Logout
			// Data is invalid - Login Failed   - Test Passed 
			if(res.equalsIgnoreCase("invalid"))
			{
				if(exp_targetPage_text == true)
				{
					myacc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		
		} 
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		
		logger.info("**** Finished TC003_LoginTestDDT **** ");
	}
	
}
