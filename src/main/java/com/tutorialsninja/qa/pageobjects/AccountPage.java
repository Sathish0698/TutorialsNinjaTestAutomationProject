package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	protected RemoteWebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	private WebElement successfulLoginVerificationText;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]" )
	private WebElement emailpasswordunmatch;
	
	public AccountPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String successLoginVerfication() {
		String text = successfulLoginVerificationText.getText();
		return text;
	}
	
	public String emailPasswordMismatchVerfication() {
		String text = emailpasswordunmatch.getText();
		return text;
	}
	
}
