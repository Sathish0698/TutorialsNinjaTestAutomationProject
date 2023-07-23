package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.SearchPage;

public class SearchTest extends Base {
	
	SearchPage searchPage;
	HomePage homePage;
	
	public SearchTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp() {

		initializeBrowserandOpenApplicaiton(prop.getProperty("browser"));
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifySearchExistingProductName() {
		
		homePage = new HomePage(driver);
		homePage.enterProductInSearchBox(testProp.getProperty("validproduct"));
		searchPage = homePage.clickSearchBtn();
		
	}
	
	@Test(priority = 2)
	public void verifyInvalidProductName() {
		
		homePage = new HomePage(driver);
		homePage.enterProductInSearchBox(testProp.getProperty("invalidproduct"));
		searchPage = homePage.clickSearchBtn();

		Assert.assertTrue(searchPage.invalidProductWarningMsg(),testProp.getProperty("invalidproductwarning"));
		
		
	}

}
