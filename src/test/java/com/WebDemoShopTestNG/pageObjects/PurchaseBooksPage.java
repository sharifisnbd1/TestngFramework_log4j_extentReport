package com.WebDemoShopTestNG.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseBooksPage {
	
WebDriver Idriver;
	
	public PurchaseBooksPage(WebDriver rdriver){
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(xpath="//ul[@class='top-menu']//a[@href='/books']")
	WebElement clickBooks;
	
	@FindBy(id="small-searchterms")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@class='button-1 search-box-button']")
	WebElement btnSearch;
	
	@FindBy(xpath="//div[@class='item-box']//*[@data-productid='13']//*[contains(text(),'Computing and Internet')]")
	WebElement labelComputingAndInternet;
	
	@FindBy(id="add-to-cart-button-13")
	WebElement btnComAndIntAddToCart;
	
	@FindBy(xpath="//a[@href='/cart']//span[@class='cart-label']")
	WebElement hoverShoppingCart;
	
	@FindBy(xpath="//input[@class='button-1 cart-button']")
	WebElement btnGoToCart;
	
	@FindBy(id="termsofservice")
	WebElement chkbxIAgree;
	
	@FindBy(id="checkout")
	WebElement btnCheckout;
	
	//---Billing Starts-----
	
	@FindBy(id="BillingNewAddress_City")
	WebElement txtBillingCity;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement txtBillingAddress;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement txtAddress;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement txtBillingZipCode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement txtBiillingPhoneNumber;
	
	//----Billing address ends------
	
	@FindBy(xpath="//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']")
	WebElement btnBillingAddressContinue;
	
	@FindBy(xpath="//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']")
	WebElement btnShippingAddressContinue;
	
	@FindBy(xpath="//div[@class='method-name']//input[@id='shippingoption_0']")
	WebElement rdShippingMethodGround;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']//input[@class='button-1 shipping-method-next-step-button']")
	WebElement btnShippingMethodContinue;
	
	@FindBy(xpath="//div[@class='method-name']//input[@id='paymentmethod_0']")
	WebElement rdPaymentMethodCash;
	
	@FindBy(xpath="//div[@id='payment-method-buttons-container']//input[@class='button-1 payment-method-next-step-button']")
	WebElement btnPaymentMethodContinue;
	
	@FindBy(xpath="//div[@id='payment-info-buttons-container']//input[@class='button-1 payment-info-next-step-button']")
	WebElement btnPaymentInformationContinue;
	
	@FindBy(xpath="//div[@id='confirm-order-buttons-container']//input[@class='button-1 confirm-order-next-step-button']")
	WebElement btnOrderConfirm;
	
	@FindBy(xpath="//*[contains(text(),'Your order has been successfully processed!')]")
	WebElement labelOrderSuccessfull;
	
	@FindBy(xpath="//div[@class='header-links']//a[@class='ico-logout']")
	WebElement btnLogout;
	
	public void clickBooksButton() {
		clickBooks.click();
		
	}
	public void searchBox(String search) {
		searchBox.sendKeys(search);;
		
	}public void clickSearchButton() {
		btnSearch.click();
		
	}public void ClickComputingAndInternets() {
		labelComputingAndInternet.click();
		
	}public void clickComAndIntAddToCart() {
		btnComAndIntAddToCart.click();
		
	}public void clicckGoToCart() {
		btnGoToCart.click();
		
	}public void clickchkbxIAgree() {
		chkbxIAgree.click();
		
	}public void clickbtnCheckout() {
		btnCheckout.click();
		
	}public void clickbtnBillingAddressContinue() {
		btnBillingAddressContinue.click();
		
	}public void clickbtnShippingAddressContinue() {
		btnShippingAddressContinue.click();
		
	}public void clickrdShippingMethodGround() {
		rdShippingMethodGround.click();
		
	}public void clickbtnShippingMethodContinue() {
		btnShippingMethodContinue.click();
		
	}public void clickrdPaymentMethodCash() {
		rdPaymentMethodCash.click();
		
	}public void clickbtnPaymentMethodContinue() {
		btnPaymentMethodContinue.click();
		
	}public void clickbtnPaymentInformationContinue() {
		btnPaymentInformationContinue.click();
		
	}public void clickbtnOrderConfirm() {
		btnOrderConfirm.click();
		
	}public void labelOrderSuccessfull() {
		labelOrderSuccessfull.click();
		
	}public void clickbtnLogout() {
		btnLogout.click();
		
	
		
	}

}


