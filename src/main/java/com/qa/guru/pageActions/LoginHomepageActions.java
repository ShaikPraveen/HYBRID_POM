package com.qa.guru.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.pageLocators.LoginHomepageLocators;

public class LoginHomepageActions 
{
	public LoginHomepageLocators loginHomepageLocators=null;
	
	
	public LoginHomepageActions(WebDriver driver)
	{
		this.loginHomepageLocators=new LoginHomepageLocators();
		PageFactory.initElements(driver, loginHomepageLocators);
	}
	
	
	public void clickLogOutLink()
	{
		loginHomepageLocators.clicklogoutlink.click();
	}
	
	
	public void clickNewCustomerLink()
	{
		loginHomepageLocators.clicknewcustomerlink.click();
	}
	 
	public void setCustomerName(String name)
	{
		loginHomepageLocators.entercustomername.sendKeys(name);
	}
	
	
	
	public void selectGender()
	{
		loginHomepageLocators.selectgender.click();
	}
	
	public void selectDOB(String mm, String dd, String yy)
	{
		loginHomepageLocators.selectdataofbirth.sendKeys(mm);
		loginHomepageLocators.selectdataofbirth.sendKeys(dd);
		loginHomepageLocators.selectdataofbirth.sendKeys(yy);
	}

	public void setAddress(String add)
	{
		loginHomepageLocators.enteraddress.sendKeys(add);
	}
	
	
	public void setCity(String city)
	{
		loginHomepageLocators.entercityname.sendKeys(city);
	}
	
	
	public void setState(String state)
	{
		loginHomepageLocators.enterstatename.sendKeys(state);
	}
	
	
	public void setPinNumber(String number)
	{
		loginHomepageLocators.enterpincode.sendKeys(String.valueOf(number));
	}
	
	
	public void setMobileNumber(String number)
	{
		loginHomepageLocators.entermobilenumber.sendKeys(number);
	}
	
	
	public void setEmail(String email)
	{
		loginHomepageLocators.enteremail.sendKeys(email);
	}
	
	public void setCustomerPassword(String pwd)
	{
		loginHomepageLocators.enterpassword.sendKeys(pwd);
	}
	
	
	public void clickSubmitBtn()
	{
		loginHomepageLocators.clicksubmitbtn.click();
	}
}
