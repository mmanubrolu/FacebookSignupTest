package com.facebook.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.page.HomePage;
import com.facebook.page.SignupPage;
import com.facebook.page.SignupVerificationPage;
import com.facebook.testbase.TestBase;
import com.facebook.utility.Utility;

public class SignupPageTest extends TestBase {
	public SignupPage signupPage;
	public HomePage homePage;
	public SignupVerificationPage signupVerificationPage;
	
	public SignupPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		signupPage =homePage.clickOnCreateAccountButton();
	}
	
	@Test(priority=1)
	public void validateTitleTest() {
		String title = driver.getTitle();
		System.out.println("Title : " + title);
		
		Assert.assertEquals(title, "Facebook – log in or sign up", "Singup page title is not matched");
	}
	
	@DataProvider
	public Object[][] signupTestData() {
		Object[][] obj = Utility.getTestData("sinuptestdata");
		return obj;
		
	}
	@Test(priority=2, dataProvider="signupTestData")
	public void createAccountTest(String tcId, String priority, String description, String fn, String ln, String un, String pwd, String day, String month, String year, String sex) {
		signupVerificationPage = signupPage.singUpButton(fn, ln, un, pwd, day, month, year, sex);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
