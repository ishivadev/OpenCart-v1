package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void testLogin()
	{
		//Home Page
		HomePage hp = new HomePage(driver); // The'driver' is used from 'baseClass' and sending to 'HomePage' as a parameter.
		hp.clickAccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lg = new LoginPage(driver); 
		lg.setEmail(prop.getProperty("email"));
		lg.setPassword(prop.getProperty("password"));
		lg.clickLoginBtn();
		
		//MyAccount Page
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean exp_myacc_text = myacc.exp_myAccount();
		
		if(exp_myacc_text)
		{
			//Assert.assertTrue(true);
			Assert.assertEquals(exp_myacc_text, true);
		}
		else 
		{
			Assert.assertTrue(false);
		}
		
	}
	
}
