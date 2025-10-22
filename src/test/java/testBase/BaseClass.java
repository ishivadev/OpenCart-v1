package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.apache.logging.log4j.LogManager;  //Log4j package
import org.apache.logging.log4j.Logger;  //Log4j package

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; //Log4j
	public Properties prop;
	String hub_url = "http://localhost:4444/wd/hub"; // Hub URL
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setupApp(String os, String br) throws IOException
	{
		logger = LogManager.getLogger(this.getClass()); // Will get the class as per the call
		
		
		//Loading the config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		
		
		// When the execution environment is 'remote'
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("Windows"))
				{
					capabilities.setPlatform(Platform.WIN11);
				}
			else if(os.equalsIgnoreCase("Linux"))
				{
					capabilities.setPlatform(Platform.LINUX);
				}
			else if(os.equalsIgnoreCase("Mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
			else 
				{ 
					System.out.println("OS does not matched."); 
					return; 
				}
			
			switch(br.toLowerCase())
				{
					case "chrome" : capabilities.setBrowserName("chrome"); break;
					case "edge" :  capabilities.setBrowserName("MicrosoftEdge"); break;
					case "firefox" : capabilities.setBrowserName("firefox"); break;
					default : System.out.println("Browser does not matched."); return;
				}
			
			driver = new RemoteWebDriver(new URL (hub_url), capabilities); // Setting up the 'driver'
		} 
		
		
		// When the execution environment is 'local'
		if(prop.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			
			// Selecting the browser as per request
			switch(br.toLowerCase())
			{
				case "chrome" : driver = new ChromeDriver(); break;
				case "edge" : driver = new EdgeDriver(); break;
				case "firefox" : driver = new FirefoxDriver(); break;
				default : System.out.println("Invalid broswer...!!"); return;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL2")); // 'appURL' is fetched from config.properties file
		driver.manage().window().maximize();
	}
	
	
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	// User defined methods

	// Capturing screenshot method
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss").format(new Date()); // Time stamp
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time stamp

		
		// For taking full page screenshot
		// If the 'driver' is NON-STATIC is BaseClass. then this 'driver' will be pick from the object, which object is called 'captureScreen' method. 
		// Here the 'baseObj' is calling the 'captureScreen' method from ExtentReportManager. 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath); // Storing the file path to 'File' type
		
		sourceFile.renameTo(targetFile); // Storing the screenshot to 'targetFile' location
		
		return targetFilePath; // Returning screenshot's path
	}
	
	
	
	@SuppressWarnings("deprecation")
	public String randomFirstName()
	{
		String generatedfirstname =  RandomStringUtils.randomAlphanumeric(5);
		return generatedfirstname;
	}
	
	
	@SuppressWarnings("deprecation")
	public String randomLastName()
	{
		String generatedlastname = RandomStringUtils.randomAlphanumeric(5);
		return generatedlastname;
	}
	
	@SuppressWarnings("deprecation")
	public String randomTelephone()
	{
		String generatedtelNumber = RandomStringUtils.randomNumeric(10);
		return generatedtelNumber;
	}
	
	@SuppressWarnings("deprecation")
	public String randomEmail()
	{
		String data1 = RandomStringUtils.randomAlphabetic(4);
		String data2 = RandomStringUtils.randomAlphabetic(4);
		
		String generatedEmail = data1 + data2;
		System.out.println("Random Email Id is : " + generatedEmail + "@gmail.com");
		return generatedEmail;
	}
	
	@SuppressWarnings("deprecation")
	public String randomPassword()
	{
		String strVal1 = RandomStringUtils.randomAlphabetic(4);
		String strVal2 = RandomStringUtils.randomNumeric(10);
		String generatedpassword = (strVal1+"@"+strVal2);
		System.out.println("Random Password is : " + generatedpassword);
		return generatedpassword;
	}
	
	
	
	
	
}
