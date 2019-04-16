package com.qa.guru.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginHomepageLocators 
{
	@FindBy(how=How.LINK_TEXT,using="Log out")
	public WebElement clicklogoutlink;
	
	@FindBy(how=How.LINK_TEXT,using="New Customer")
	public WebElement clicknewcustomerlink;
	
	@FindBy(how=How.XPATH,using="//input[@name='name']")
	public WebElement entercustomername;
	
	@FindBy(how=How.XPATH,using="//input[@value='m']")
	public WebElement selectgender;
	
	@FindBy(how=How.XPATH,using="//input[@id='dob']")
	public WebElement selectdataofbirth;
	
	@FindBy(how=How.XPATH,using="//textarea[@name='addr']")
	public WebElement enteraddress;
	
	@FindBy(how=How.XPATH,using="//input[@name='city']")
	public WebElement entercityname;
	
	@FindBy(how=How.XPATH,using="//input[@name='state']")
	public WebElement enterstatename;
	
	@FindBy(how=How.XPATH,using="//input[@name='pinno']")
	public WebElement enterpincode;
	
	@FindBy(how=How.XPATH,using="//input[@name='telephoneno']")
	public WebElement entermobilenumber;
	
	
	@FindBy(how=How.XPATH,using="//input[@name='emailid']")
	public WebElement enteremail;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	public WebElement enterpassword;
	
	@FindBy(how=How.XPATH,using="//input[@value='Submit']")
	public WebElement clicksubmitbtn;
}
