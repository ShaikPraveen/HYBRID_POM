package com.qa.guru.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.guru.pageActions.GuruHomepageActions;
import com.qa.guru.pageActions.LoginHomepageActions;

import junit.framework.Assert;

public class TC01_LoginTest  extends TestBase
{
	@Test
	public void guruApplicationLoginTest() throws IOException
	{
		GuruHomepageActions guruHomepageActions=new GuruHomepageActions(driver);
		LoginHomepageActions loginHomepageActions=new LoginHomepageActions(driver);
		logger.info("USERNAME ENTERED");
		guruHomepageActions.setUsername(readconfig.getUsername());
		logger.info("PASSWORD ENTERED");
		guruHomepageActions.setPassword(readconfig.getPassword());
		logger.info("LOGIN BUTTON CLICKED");
		guruHomepageActions.clickLoginBTN();
		
		if (driver.getTitle().contains("Guru99 Bank Manager HomePage"))
		{
		  logger.info("TITLE VERIFIED");
		  System.out.println("TITLE MATCHED");
		  Assert.assertTrue(true);
			
		} else 
		{
			System.out.println("TITLE NOT MATCHED,EXPECTED TITLE IS => "+driver.getTitle());
            Assert.assertTrue(false);
		}
		
		
		loginHomepageActions.clickLogOutLink();
		driver.switchTo().alert().accept();
		
		if (driver.getCurrentUrl().contains("/V4/index.php13"))
		{
			 System.out.println("URL MATCHED");
			 Assert.assertTrue(true);
			
		} else
		{
			System.out.println("URL NOT MATCHED, EXPECTED URL IS "+driver.getCurrentUrl());
            Assert.assertTrue(false);
            captureScreen(driver, "guruApplicationLoginTest");
		}
	}
}
