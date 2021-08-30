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
	
	@FindBy(id="u_0_2_zN")
	WebElement createAccoutButton;
	
	@FindBy(xpath="//a[@title='English (UK)']")
	WebElement changeToEnglish;
	
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
		createAccoutButton.click();
		return new SignupPage();
	}
	
}
