package com.qa.guru.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GuruHomepageLocators 
{
	@FindBy(how=How.XPATH,using="//input[@name='uid']")
	public WebElement enterusername;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	public WebElement enterpassword;

	@FindBy(how=How.XPATH,using="//input[@value='LOGIN']")
	public WebElement clickloginBTN;
}
