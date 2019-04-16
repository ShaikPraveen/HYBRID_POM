package com.qa.guru.testCases;

import java.io.IOException;


import org.testng.annotations.Test;

import com.qa.guru.pageActions.GuruHomepageActions;
import com.qa.guru.pageActions.LoginHomepageActions;

import junit.framework.Assert;

public class TC03_CreateNewCustomer extends TestBase
{
	
	@Test
	public void createNewCustomerTest() throws InterruptedException, IOException
	{
		GuruHomepageActions guruHomepageActions=new GuruHomepageActions(driver);
		LoginHomepageActions loginHomepageActions=new LoginHomepageActions(driver);
		
		guruHomepageActions.setUsername(readconfig.getUsername());
		guruHomepageActions.setPassword(readconfig.getPassword());
		guruHomepageActions.clickLoginBTN();
		Thread.sleep(2000);
		loginHomepageActions.clickNewCustomerLink();
		loginHomepageActions.setCustomerName("Selenium");
		loginHomepageActions.selectGender();
		loginHomepageActions.selectDOB("3", "5", "2019");
		Thread.sleep(2000);
		loginHomepageActions.setAddress("SR NAGAR");
		loginHomepageActions.setCity("Hyderabad");
		loginHomepageActions.setState("TS");
		loginHomepageActions.setPinNumber("112233");
		loginHomepageActions.setMobileNumber("9989461232");
		
		String email=randomString()+"@gmail.com";
		System.out.println(email);
		loginHomepageActions.setEmail(email);
		loginHomepageActions.setCustomerPassword("test@1234");
		loginHomepageActions.clickSubmitBtn();
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) 
		{
			Assert.assertTrue(true);
		} else 
		{
             captureScreen(driver, "createNewCustomerTest");
             Assert.assertTrue(false);
		}
	}
}
