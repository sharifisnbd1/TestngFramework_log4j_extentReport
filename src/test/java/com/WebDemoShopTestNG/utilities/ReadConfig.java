package com.WebDemoShopTestNG.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
	File src = new File("./Configuration/config.properties");	//src to refer the property file
		
	try {
		FileInputStream fis = new FileInputStream(src); // FileInputStream is to make the file in read mode.
		pro = new Properties(); // pro object is intitiating the Properties.
		pro.load(fis); // Here pro object is loading the file.
	}catch (Exception e) {
		System.out.println("Exception is "+ e.getMessage());
	}
			
	}
	// Just like page object class, here we need to create method for all reusable varible that are now in base class.
	
	//Method for URL
	
	  public String getApplicationURL() 
	  {
		  String url=pro.getProperty("baseURL");
	  return url; }
	 
	public String getUsername() {
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	/*
	 * public String getChromepath() { String chromepath=
	 * pro.getProperty("chromepath"); return chromepath; } public String
	 * getFirefoxPath() { String firefoxpath= pro.getProperty("firefoxpath"); return
	 * firefoxpath; }
	 */
	

}
