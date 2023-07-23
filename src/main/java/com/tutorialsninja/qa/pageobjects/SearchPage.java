package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	protected RemoteWebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	public WebElement validProduct;
	
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	WebElement invalidProductwarning;

	public SearchPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean invalidProductWarningMsg() {
		boolean displayed = invalidProductwarning.isDisplayed();
		return displayed;
	}
	
	public String validProductConfirmation() {
		String text = validProduct.getText();
		return text;
	}

}
