package com.facebook.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.testbase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//img[@class='fb_logo _8ilh img']")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[@id='u_0_2_zN']")
	WebElement createAccoutButton;
	
	//id="u_0_2_zN"
	@FindBy(xpath="//a[@title='English (UK)']")
	WebElement changeToEnglish;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(id="u_0_d_bP")
	WebElement loginButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isLogDisplayed() {
		changeToEnglish.click();
		return logo.isDisplayed();
	}
	
	public boolean ispwdLinkDisplayed() {
		changeToEnglish.click();
		return forgotPasswordLink.isDisplayed();
	}
	
	public SignupPage clickOnCreateAccountButton() {
		changeToEnglish.click();
		boolean isButtonDisplayed = createAccoutButton.isDisplayed();
		System.out.println("is button displayed::  " + isButtonDisplayed);
		
		boolean isButtonSelected = createAccoutButton.isSelected();
		System.out.println("is button isButtonSelected::  " + isButtonSelected);
		
		boolean isButtonEnabled = createAccoutButton.isEnabled();
		System.out.println("is button isButtonEnabled::  " + isButtonEnabled);
		
		createAccoutButton.click();
		
		return new SignupPage();
	}
	
	public FeedPage clickOnLoginButton(String un, String pwd) {
		email.clear();
		email.sendKeys(un);
		
		password.clear();
		password.sendKeys(pwd);
		
		loginButton.click();
		
		return new FeedPage();
		
	}
	
}
