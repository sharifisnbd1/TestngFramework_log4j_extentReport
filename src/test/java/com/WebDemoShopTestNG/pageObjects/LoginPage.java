package com.WebDemoShopTestNG.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver Idriver;
	
	public LoginPage(WebDriver rdriver){
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	@FindBy(xpath="//a[contains(text(),'Log in')]")
	WebElement btnLogin;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@class='button-1 login-button']")
	WebElement btnLoginToSubmit;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement btnLogout;
	
	//Catagory List
	
	@FindBy(xpath="//ul[@class='list']")
	WebElement catagoryList;
	
	@FindBy(xpath="(//*[contains(text(),'Fiction')])[1]")
	WebElement clickBook;
	
	public void clickLogin() {
		btnLogin.click();
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		
	}
	public void loginToSubmit() {
		btnLoginToSubmit.click();
	}
	public void clickLogout() {
		btnLogin.click();
	}
	public void selectBook() {
		
		// Locate the grid element
        WebElement books = Idriver.findElement(By.xpath("//*[@class='product-grid']"));

        // Find the specific item within the grid (for example, by XPath)
        WebElement item = books.findElement(By.xpath("(//*[contains(text(),'Fiction')])[1]"));
        // Perform the action on the item (for example, click)
        item.click();	
	}
	
	

}
