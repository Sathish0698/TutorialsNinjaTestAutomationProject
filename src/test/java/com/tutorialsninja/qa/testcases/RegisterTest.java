package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	RegisterPage registerpage;
	HomePage homepage;
	
	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initializeBrowserandOpenApplicaiton(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		registerpage = hp.selectRegister();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyRegisterWithMandatoryFields() {
		
		registerpage.enterFirstName(testProp.getProperty("firstname"));
		registerpage.enterLastName(testProp.getProperty("lastname"));
		registerpage.enterEmailId(Utilities.generateUniqueMailForTest());
		registerpage.enterTelephoneNumber(testProp.getProperty("telephonenumber"));
		registerpage.enterPassword(testProp.getProperty("password"));
		registerpage.reEnterPassword(testProp.getProperty("password"));
		registerpage.clickPolicyCheckBox();
		registerpage.clickSubmitBtn();
		
		Assert.assertTrue(registerpage.accountGeneratedMessageValidation(), testProp.getProperty("accountsuccessfullycreatedheading"));
		
	}
	
	@Test(priority = 2)
	public void verifyRegisterWithAllFields() {

		registerpage.enterFirstName(testProp.getProperty("firstname"));
		registerpage.enterLastName(testProp.getProperty("lastname"));
		registerpage.enterEmailId(Utilities.generateUniqueMailForTest());
		registerpage.enterTelephoneNumber(testProp.getProperty("telephonenumber"));
		registerpage.enterPassword(testProp.getProperty("password"));
		registerpage.reEnterPassword(testProp.getProperty("password"));
		registerpage.clickNewsletterRadioBtn();
		registerpage.clickPolicyCheckBox();
		registerpage.clickSubmitBtn();
		
		Assert.assertTrue(registerpage.accountGeneratedMessageValidation(), testProp.getProperty("accountsuccessfullycreatedheading"));
		
	}
	
	@Test(priority = 3)
	public void verifyRegisterWithDuplicateMail() {

		registerpage.enterFirstName(testProp.getProperty("firstname"));
		registerpage.enterLastName(testProp.getProperty("lastname"));
		registerpage.enterEmailId(testProp.getProperty("duplicatemail"));
		registerpage.enterTelephoneNumber(testProp.getProperty("telephonenumber"));
		registerpage.enterPassword(testProp.getProperty("password"));
		registerpage.reEnterPassword(testProp.getProperty("password"));
		registerpage.clickNewsletterRadioBtn();
		registerpage.clickPolicyCheckBox();
		registerpage.clickSubmitBtn();
		Assert.assertTrue(registerpage.duplicateMailValidation(), testProp.getProperty("duplicateemailwarning"));
		
		
	}
	
	@Test(priority = 4)
	public void verifyRegisterWithoutFillingDetails() {
		
		registerpage.clickSubmitBtn();
		Assert.assertTrue(registerpage.privacyPolicyWarningMsg().
				equals(testProp.getProperty("privacypolicywarning")), "PrivacyPolicy Warning Message Displayed!!");
		Assert.assertTrue(registerpage.firstNameWarningMsg().
				equals(testProp.getProperty("firstnamewarning")), "FirstName Warning Message Not Displayed!!");
		Assert.assertTrue(registerpage.lastNameWarningMsg().
				equals(testProp.getProperty("lastnamewarning")), "LastName Warning Message Not Displayed!!");
		Assert.assertTrue(registerpage.emailIdWarningMsg().
				equals(testProp.getProperty("emailwarning")), "EmailId Warning Message Not Displayed!!");
		Assert.assertTrue(registerpage.telephoneWarningMsg().
				equals(testProp.getProperty("telephonewarning")), "Telephone Warning Message Not Displayed!!");
	}

}
