package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	protected RemoteWebDriver driver;
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitbtn;
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AccountPage login(String mailId, String passwd) {
		email.sendKeys(mailId);
		password.sendKeys(passwd);
		submitbtn.click();
		return new AccountPage(driver);
	}

}
