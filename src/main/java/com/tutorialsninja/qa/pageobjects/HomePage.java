package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	protected RemoteWebDriver driver;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement MyAccount;
	
	@FindBy(linkText = "Login")
	private WebElement Login;
	
	@FindBy(linkText = "Register")
	private WebElement Register;
	
	@FindBy(name = "search")
	WebElement searchBox;
	
	@FindBy(xpath = "//div[@id='search']/descendant::button")
	WebElement searchBtn;
	
	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyAccount() {
		MyAccount.click();
	}
	
	public LoginPage selectLogin() {
		Login.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegister() {
		Register.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductInSearchBox(String product) {
		searchBox.sendKeys(product);
	}
	
	public SearchPage clickSearchBtn() {
		searchBtn.click();
		return new SearchPage(driver);
	}
	
	public AccountPage navigateToLoginPage() {
		MyAccount.click();
		Login.click();
		return new AccountPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		MyAccount.click();
		Register.click();
		return new RegisterPage(driver);
	}

}
