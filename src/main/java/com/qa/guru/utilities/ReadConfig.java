package com.qa.guru.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties prop;
	
	
	public ReadConfig()
	{
		File src=new File("./Configuration/Config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
		}catch(Exception e)
		{
			System.out.println("EXCEPTION IS "+e.getMessage());
		}
	}
	
	
	    public String getApplicationURL()
	    {
	    	String url=prop.getProperty("baseURL");
	    	return url;
	    }
	
	    
	    public String getUsername()
	    {
	    	String username=prop.getProperty("Username");
	    	return username;
	    }
	    
	    
	    public String getPassword()
	    {
	    	String password=prop.getProperty("Password");
	    	return password;
	    }
	
	
	    public String getChromepath()
	    {
	    	String ccpath=prop.getProperty("Chromepath");
	    	return ccpath;
	    }
	
	    
	    public String getFirefoxpath()
	    {
	    	String ffpath=prop.getProperty("Firefoxpath");
	    	return ffpath;
	    }
}
