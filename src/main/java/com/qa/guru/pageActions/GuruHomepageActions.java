package com.qa.guru.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.pageLocators.GuruHomepageLocators;

public class GuruHomepageActions 
{
	public GuruHomepageLocators guruHomepageLocators=null;
	
	
	public GuruHomepageActions(WebDriver driver)
	{
		this.guruHomepageLocators=new GuruHomepageLocators();
		PageFactory.initElements(driver, guruHomepageLocators);
	}
	
	
	     public void setUsername(String uname)
	     {
	    	 guruHomepageLocators.enterusername.sendKeys(uname);
	     }
	
	     
	     public void setPassword(String pwd)
	     {
	    	 guruHomepageLocators.enterpassword.sendKeys(pwd);
	     }
	
	     
	     public void clickLoginBTN()
	     {
	    	 guruHomepageLocators.clickloginBTN.click();
	     }
}
