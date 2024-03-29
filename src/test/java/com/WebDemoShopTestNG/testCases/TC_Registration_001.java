package com.WebDemoShopTestNG.testCases;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.WebDemoShopTestNG.pageObjects.RegistrationPage;
import com.WebDemoShopTestNG.utilities.RandomEmailGenerator;
import com.WebDemoShopTestNG.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_Registration_001 {
		
	public static WebDriver driver;
	public static Logger logger;
	
	ReadConfig readconfig = new ReadConfig(); // object to read properties from ReadConfig class.
	public String baseURL= readconfig.getApplicationURL(); // Read url from property file
	

	@Test
	public void newRegistration() throws InterruptedException {
	
		
	logger = Logger.getLogger("Web Demo Shop");
	PropertyConfigurator.configure("Log4j.properties");
		
	
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();	
	driver.manage().window().maximize();
	driver.get(baseURL);
	
	RegistrationPage rp = new RegistrationPage(driver);
	
	Thread.sleep(3000);
	rp.clickRegister();
	logger.info("Registration button clicked");
	
	rp.setGender();
	logger.info("Gender selected");
	rp.setFirstName("Md");
	logger.info("First name entered");
	rp.setLastName("Ayaaz");
	logger.info("Last name entered");
	
	RandomEmailGenerator reg = new RandomEmailGenerator();
	rp.setEmail(reg.generateRandomEmail());
	logger.info("Email entered");
	rp.setPassword("404404");
	logger.info("Password entered");
	rp.setConfirmPassword("404404");
	logger.info("Password confirmed");
	rp.clickRegisterToSubmit();
	logger.info("Clicked registration for submission");
	
	WebElement lo=driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
	if (lo.isDisplayed()) {
		Assert.assertTrue(true);
		logger.info("Registration completed successfully");
	}else {
		Assert.assertFalse(false);
		logger.info("Registration failed");
	}
	
	rp.clickLogout();
	driver.quit();
		
	}

}
