package com.facebook.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.testbase.TestBase;

public class SignupPage extends TestBase {
	
	// object repositories
	@FindBy(id="u_2_b_eN")
	WebElement firstName;
	
	@FindBy(id="u_2_d_D8")
	WebElement lastName;
	
	@FindBy(id="u_2_g_N4")
	WebElement userName;
	
	@FindBy(id="password_step_input")
	WebElement password;
	
	@FindBy(id="u_2_4_Ec")
	WebElement femaleRadioButton;
	
	@FindBy(id="u_2_5_bg")
	WebElement maleRadioButton;
	
	@FindBy(id="u_2_6_Wd")
	WebElement customRadioButton;
	
	@FindBy(id="day")
	WebElement selectDay;
	
	@FindBy(id="month")
	WebElement selectMonth;
	
	@FindBy(id="year")
	WebElement selectYear;
	
	@FindBy(id="u_2_s_/F")
	WebElement signupButton;
	
	// constructor
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}
	
	// methods or operations

	public void setFirstName(String fn) {
		firstName.clear();
		firstName.sendKeys(fn);	
	}
	
	public void setLasstName(String ln) {
		lastName.clear();
		lastName.sendKeys(ln);	
	}
	
	public void setUserName(String un) {
		userName.clear();
		userName.sendKeys(un);
	}
	
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void selectDay(String day) {
		Select select = new Select(selectDay);
		select.selectByValue(day);
	}
	
	public void selectMonth(String month) {
		Select select = new Select(selectMonth);
		select.selectByValue(month);
	}
	
	public void selectYear(String year) {
		Select select = new Select(selectYear);
		select.selectByValue(year);
	}
	
	public void selectFemale () {
		femaleRadioButton.clear();
		femaleRadioButton.click();
	}
	
	public void selectMale () {
		maleRadioButton.clear();
		maleRadioButton.click();
	}
	
	public SignupVerificationPage singUpButton(String fn, String ln, String un, String pwd , String day, String month, String year, String sex) {
		
		setFirstName(fn);
		setLasstName(ln);
		setUserName(un);
		setPassword(pwd);
		selectDay(day);
		selectMonth(month);
		selectYear(year);
		if(sex.equals("male")) {
			selectMale();
		}
		else {
			selectFemale();
		}
		
		signupButton.click();
		
		return new SignupVerificationPage();
	
		
	}
	
}
