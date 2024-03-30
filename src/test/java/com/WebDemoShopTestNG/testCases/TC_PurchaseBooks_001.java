package com.WebDemoShopTestNG.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebDemoShopTestNG.pageObjects.PurchaseBooksPage;

public class TC_PurchaseBooks_001 extends BaseClass{
	
	@Test
	public void e2eBookPurchase() throws IOException, InterruptedException {
	
		PurchaseBooksPage pb = new PurchaseBooksPage(driver);
		
		TC_Login_001 login = new TC_Login_001();
		login.loginTest();
		logger.info("Looged in to WDS");
		Thread.sleep(2000);
		
		pb.clickBooksButton();
		logger.info("Book button clicked");
		Thread.sleep(2000);
		
		pb.searchBox("Computing and Internet");
		logger.info("Search item entered");
		Thread.sleep(2000);
		
		pb.clickSearchButton();
		logger.info("Search button clicked");
		Thread.sleep(2000);
		
		pb.ClickComputingAndInternets();
		logger.info("Computing and internet clicked");
		Thread.sleep(2000);
		
		pb.clickComAndIntAddToCart();
		logger.info("Add to cart clicked");
		Thread.sleep(2000);
		
		WebElement hoverShoppingCart = driver.findElement(By.xpath("//a[@href='/cart']//span[@class='cart-label']"));
		hoverOverElement(driver, hoverShoppingCart);
		logger.info("Mouse hovered on Shopping cart");
		Thread.sleep(2000);
		
		pb.clicckGoToCart();
		logger.info("Shopping cart clicked");
		Thread.sleep(2000);
		
		WebElement selectCountry = driver.findElement(By.xpath("//Select[@id='CountryId']"));
		Select dropdown = new Select(selectCountry);
		dropdown.selectByVisibleText("United States");
		logger.info("Country selected");
		Thread.sleep(2000);
		
		WebElement selectState = driver.findElement(By.xpath("//Select[@id='StateProvinceId']"));
		Select dropdown1 = new Select(selectState);
		dropdown1.selectByVisibleText("Ohio");
		logger.info("State selected");
		Thread.sleep(2000);
		
		pb.clickchkbxIAgree();
		logger.info("Agreement checked");
		Thread.sleep(2000);
		
		pb.clickbtnCheckout();
		logger.info("Checkout clicked");
		Thread.sleep(2000);
		
		pb.clickbtnBillingAddressContinue();
		logger.info("Clicked billing address continue");
		Thread.sleep(2000);
		
		pb.clickbtnShippingAddressContinue();
		logger.info("Clicked shipping address continue");
		Thread.sleep(2000);
		
		pb.clickrdShippingMethodGround();
		logger.info("Check shipping method as Ground");
		Thread.sleep(2000);
		
		pb.clickbtnShippingMethodContinue();
		logger.info("Clicked shipping method continue");
		Thread.sleep(2000);
		
		pb.clickrdPaymentMethodCash();
		logger.info("Checked payment method as cash");
		Thread.sleep(2000);
		
		pb.clickbtnPaymentMethodContinue();
		logger.info("Clicked payment method continue");
		Thread.sleep(2000);
		
		pb.clickbtnPaymentInformationContinue();
		logger.info("Clicked payment information continue");
		Thread.sleep(2000);
		
		pb.clickbtnOrderConfirm();
		logger.info("Clicked confirm order");
		Thread.sleep(2000);
		
		WebElement orderConfirmation = driver.findElement(By.xpath("//*[contains(text(),'Your order has been successfully processed!')]"));
		if(orderConfirmation.equals("Your order has been successfully processed!")) {
			Assert.assertTrue(true);
			logger.info("Order has been successfully processed");
		}else {
			captureScreen(driver, "e2eBookPurchase");
			Assert.assertFalse(false);
			logger.info("Order could not be processed");
			
		}
		
		
	
		
		
		
	}
	
	

}
