package com.qa.guru.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru.pageActions.GuruHomepageActions;
import com.qa.guru.pageActions.LoginHomepageActions;
import com.qa.guru.utilities.XLUtils;

public class TC02_LoginDDTTest extends TestBase
{
	
	@Test(dataProvider="getData")
	public void guruApplicationDDTTest(String uname, String pwd) throws InterruptedException, IOException
	{
		GuruHomepageActions guruHomepageActions=new GuruHomepageActions(driver);
		LoginHomepageActions loginHomepageActions=new LoginHomepageActions(driver);
		
		logger.info("USERNMAE ENTERED");
		guruHomepageActions.setUsername(uname);
		logger.info("PASSWORD ENTERED");
		guruHomepageActions.setPassword(pwd);
		logger.info("CLICKED LOGIN BUTTON");
		guruHomepageActions.clickLoginBTN();
		Thread.sleep(3000);
		
		if (isAlertPresent()==true) //Failure Case
		{
		   driver.switchTo().alert().accept();
		   driver.switchTo().defaultContent();
		   logger.info("LOGIN FAILURE");
		   Assert.assertTrue(false);
		   Thread.sleep(3000);
		}
		else  //Passed Case
		{
			Assert.assertTrue(true);
			logger.info("LOGIN PASSED");
			loginHomepageActions.clickLogOutLink();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
    /*String welcome_text=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")).getText();
			
			if (welcome_text.contains("Welcome To Manager's"))
			{
			       Assert.assertTrue(true);	
			} else {
				Assert.assertTrue(false);
				captureScreen(driver, "guruApplicationDDTTest");
			}*/
		}	
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\guru\\testData\\TestData.xlsx";
		int rowcount  =XLUtils.getRowCount(path, "Login_Data");
		int cellcount =XLUtils.getCellCount(path, "Login_Data", 1);
		
		Object[][] data=new Object[rowcount][cellcount];
		
		   for (int i = 1; i <=rowcount; i++) 
		   {
		      for (int j = 0; j < cellcount; j++) 
		      {
				  data[i-1][j]=XLUtils.getCellData(path, "Login_Data", i, j);
			}	
		}
		   
		   return data;	
	}
	
	
	//Login is Success, Alert window not present
	//Login is fail , Alert window is present
	
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert(); //This is Alert is Present,retrun true
			return true;
		}catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

}
