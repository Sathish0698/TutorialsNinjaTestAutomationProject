package com.tutorialsninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.AccountPage;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {

	LoginPage loginpage;
	AccountPage accountpage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initializeBrowserandOpenApplicaiton(prop.getProperty("browser"));
//		accountpage  = homepage.navigateToLoginPage();
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		loginpage = hp.selectLogin();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@DataProvider(name = "ValidCredentialsSupplier")
	public Object[][] supplyTestData() throws Throwable {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 1, dataProvider = "ValidCredentialsSupplier")
	public void ValidEmailandPassword(String Email, String Password) {

		accountpage = loginpage.login(Email, Password);
		Assert.assertTrue(accountpage.successLoginVerfication()
				.equals(testProp.getProperty("successloginmessage")), "Unable to find this! Hence, Login Not Confirmed!!!");

	}

	@Test(priority = 2)
	public void InValidEmailandPassword() throws InterruptedException {

		accountpage = loginpage.login(Utilities.generateUniqueMailForTest(), testProp.getProperty("invalidpassword"));
		Assert.assertTrue(accountpage.emailPasswordMismatchVerfication()
				.equals(testProp.getProperty("emailpasswordnotmatchwarning")), "Invalid credentials warning not displayed");

	}

	@Test(priority = 3)
	public void InValidEmailandValidPassword() throws InterruptedException {

		accountpage = loginpage.login(Utilities.generateUniqueMailForTest(), testProp.getProperty("invalidpassword"));
		Assert.assertTrue(accountpage.emailPasswordMismatchVerfication()
				.equals(testProp.getProperty("emailpasswordnotmatchwarning")), "Invalid credentials warning not displayed");

	}

}
