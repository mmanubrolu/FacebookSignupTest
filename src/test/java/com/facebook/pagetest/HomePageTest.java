package com.facebook.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.page.HomePage;
import com.facebook.page.SignupPage;
import com.facebook.testbase.TestBase;

public class HomePageTest extends TestBase {
	public HomePage homePage;
	public SignupPage signupPage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test(priority=1) 
	public void validateTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "", "Home page title is not matched");
	}
	
	@Test(priority=2)
	public void validateLogoTest() {
		boolean isLogoDisplayed = homePage.isLogDisplayed();
		Assert.assertTrue(isLogoDisplayed, "Home Page logo was not displayed");
	}
	
	@Test(priority=3)
	public void validatePWDLinkTest() {
		boolean isPWDLinkDisplayed = homePage.ispwdLinkDisplayed();
		Assert.assertTrue(isPWDLinkDisplayed, "Home Page pwd link was not displayed");
	}
	
	@Test(priority=4)
	public void clickOnCrateAccountButtonTest() {
		signupPage = homePage.clickOnCreateAccountButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
