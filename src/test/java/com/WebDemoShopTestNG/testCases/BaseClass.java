package com.WebDemoShopTestNG.testCases;
import java.io.File;


import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
	public static void selectOptionByVisibleText(WebDriver driver, WebElement selectCountry, String visibleText) {
        WebElement dropdownElement = driver.findElement((By) selectCountry);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public static void selectOptionByValue(WebDriver driver, By locator, String value) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public static void selectOptionByIndex(WebDriver driver, By locator, int index) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
        
       //By dropdownLocator = By.id("dropdown");
     // Select option by visible text
     //selectOptionByVisibleText(driver, dropdownLocator, "Option 2");
    }
    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        
       //WebElement elementToHover = driver.findElement(By.id("elementId"));
     // Perform mouse hover action
     //hoverOverElement(driver, elementToHover);
    }
    
	
}
