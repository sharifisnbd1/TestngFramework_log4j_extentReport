package com.WebDemoShopTestNG.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
WebDriver Idriver;
	
	public RegistrationPage(WebDriver rdriver){
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(how=How.XPATH, using ="//a[contains(text(),'Register')]")
	WebElement btnRegister;
	
	@FindBy(id="gender-male")
	WebElement rdGender;
	
	@FindBy(id="FirstName")
	WebElement txtFirstName;
	
	@FindBy(id="LastName")
	WebElement txtLastName;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(id="ConfirmPassword")
	WebElement txtConfirmPassword;
	
	@FindBy(id="register-button")
	WebElement btnRegisterSubmit;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement btnLogout;
	
	public void clickRegister() {
		btnRegister.click();
	}
	public void setGender() {
		rdGender.click();
		
	}
	public void setFirstName(String fn) {
		txtFirstName.sendKeys(fn);
	}
	public void setLastName(String ln) {
		txtLastName.sendKeys(ln);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String conpwd) {
		txtConfirmPassword.sendKeys(conpwd);
	}
	public void clickRegisterToSubmit() {
		btnRegisterSubmit.click();
	}
	public void clickLogout() {
		btnLogout.click();
	}
	
	
	
	
	
	

}
