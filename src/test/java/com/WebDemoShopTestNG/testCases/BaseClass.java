package com.WebDemoShopTestNG.testCases;
import java.io.File;


import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.WebDemoShopTestNG.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

// git source-> https://github.com/pavanoltraining/inetbankingV1/blob/master/src/test/java/com/inetbanking/utilities/XLUtils.java

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig(); // object to read properties from ReadConfig class.
	
	public String baseURL= readconfig.getApplicationURL(); // Read url from property file
	public String username = readconfig.getUsername();
	public String password= readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		logger = Logger.getLogger("Demo Web Shop");
		PropertyConfigurator.configure("Log4j.properties");
		
		if (br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			}
		
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
}
