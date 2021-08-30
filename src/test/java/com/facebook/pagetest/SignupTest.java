package com.facebook.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.page.SignupPage;
import com.facebook.testbase.TestBase;

public class SignupTest extends TestBase {
	public SignupPage signupPage;
	
	public SignupTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signupPage = new SignupPage();
	}
	
	@Test
	public void validateTitleTest() {
		String title = driver.getTitle();
		System.out.println("Title : " + title);
		
		Assert.assertEquals(title, "Facebook – log in or sign up", "Singup page title is not matched");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
