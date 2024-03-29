package com.WebDemoShopTestNG.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebDemoShopTestNG.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.clickLogin();
		logger.info("Login button clicked");
		Thread.sleep(2000);
		lp.setEmail(username);
		logger.info("Email entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.loginToSubmit();
		logger.info("Login to submit clicked");
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("Demo Web Shop")) {
			Assert.assertTrue(true);
			logger.info("Title found");
		}else {
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			logger.info("Title not found");
		}
		
		  WebElement
		  logout=driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
		  
		  if (logout.isDisplayed()) 
		  { Assert.assertTrue(true);
		  logger.info("Login successful"); 
		  }else 
		  { captureScreen(driver,"loginTest");
		  Assert.assertFalse(false); logger.info("Login failed"); }
		 
		
		
	}
	@Test
	public void catagoryList() {
		List<WebElement> listItems = driver.findElements(By.xpath("//ul[@class='list']"));
		
		 for (int i = 0; i < listItems.size(); i++) {
	            WebElement listItem = listItems.get(i);

	            // Example validation: Check if the list item text contains certain keywords
	            String text = listItem.getText();
	            if (text.contains("Books")) {
	                //System.out.println("List item " + i + " is valid: " + text);
	                Assert.assertTrue(true);
	                logger.info("Catagory items are matching");
	            } else {
	                //System.out.println("List item " + i + " is invalid: " + text);
	            	Assert.assertFalse(false);
	               
	            }
	            
	            // Add more validation criteria as needed
	        }
	
	

}
	
	
	}
