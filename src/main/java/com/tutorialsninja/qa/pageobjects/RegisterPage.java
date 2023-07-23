package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	protected RemoteWebDriver driver;
	
	@FindBy(name = "firstname")
	WebElement firstName;
	
	@FindBy(name = "lastname")
	WebElement lastName;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "telephone")
	WebElement telephone;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "confirm")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	WebElement newsletterRadioBtn;
	
	@FindBy(xpath = "// input[@type='checkbox']")
	WebElement policyCheckBox;
	
	@FindBy(xpath = "//input[contains(@class,'btn-primary')]")
	WebElement submitbtn;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement successAccountGeneratedMsg;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement duplicateWarningMsg;
	
	@FindBy(xpath = "//div[text()='Warning: You must agree to the Privacy Policy!']")
	public WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	WebElement firstNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	WebElement emailIdWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	WebElement telePhoneWarning;
	
	
	public RegisterPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterEmailId(String mailId) {
		email.sendKeys(mailId);
	}
	
	public void enterTelephoneNumber(String phoneNo) {
		telephone.sendKeys(phoneNo);
	}
	
	public void enterPassword(String passwd) {
		password.sendKeys(passwd);
	}
	
	public void reEnterPassword(String passwd) {
		confirmPassword.sendKeys(passwd);
	}
	
	public void clickNewsletterRadioBtn() {
		newsletterRadioBtn.click();
	}
	
	public void clickPolicyCheckBox() {
		policyCheckBox.click();
	}
	
	public void clickSubmitBtn() {
		submitbtn.click();
	}
	
	public boolean accountGeneratedMessageValidation() {
		boolean displayed = successAccountGeneratedMsg.isDisplayed();
		return displayed;
	}
	
	public boolean duplicateMailValidation() {
		boolean displayed = duplicateWarningMsg.isDisplayed();
		return displayed;
	}
	
	public String privacyPolicyWarningMsg() {
		String text = privacyPolicyWarning.getText();
		return text;
	}
	
	public String firstNameWarningMsg() {
		String text = firstNameWarning.getText();
		return text;
	}
	
	public String lastNameWarningMsg() {
		String text = lastNameWarning.getText();
		return text;
	}
	
	public String emailIdWarningMsg() {
		String text = emailIdWarning.getText();
		return text;
	}
	
	public String telephoneWarningMsg() {
		String text = telePhoneWarning.getText();
		return text;
	}

}
