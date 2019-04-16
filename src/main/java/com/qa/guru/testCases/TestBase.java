package com.qa.guru.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.guru.utilities.ReadConfig;


public class TestBase 
{
	ReadConfig readconfig=new ReadConfig();
	
	/*public static WebDriver driver;
	public static String url="http://demo.guru99.com/V4/";
	public static Logger logger;*/
	
	public static WebDriver driver;
	public static Logger logger;
	public static final int PAGELOAD_TIMEOUT=50;
	public static final int TIMEOUT=10;
	
	
	public String baseurl=readconfig.getApplicationURL();
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUP(String br)
	{
		logger=Logger.getLogger("GURU BANKING APPLICATION");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")){
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Executables\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		
		logger.info("CHROME BROWSER LAUNCHED");
		driver=new ChromeDriver();
		}else
		{
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Executables\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			logger.info("FIREFOX BROWSER LAUNCHED");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		logger.info("NAVIGATE TO GURU APPLICATION WEBSITE");
		driver.get(baseurl);	
 }
	
	@AfterClass
	public void tearDown()
	{
		logger.info("BROWSER CLOSED");
		driver.close();
	}
	
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
	     }
	
	   public static String randomString()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);//8 is length
			return generatedstring;
		}
		
		
		public static String randomNumber()
		{
			String generatednumber=RandomStringUtils.randomNumeric(10);//10 is length
			return generatednumber;
		}
}
