package com.orangeHRM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.utilities.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(super.driver, this);
	}

	@FindBy(id="txtUsername")
	WebElement userid;
	
	public void username_input(String value) {
		userid.sendKeys(value);
	}
	public boolean is_username_field_displayed() {
		return userid.isDisplayed();
	}
	
	@FindBy(id="txtPassword")
	WebElement password;
	public void password_input(String value) {
		password.sendKeys(value);
	}
	
	@FindBy(id="btnLogin")
	WebElement submit;
	
	public HomePage click_submit() {
		submit.click();
		return new HomePage(super.driver);
	}
	
	@FindBy(xpath="//*[@id=\"spanMessage\"]")
	WebElement invalid_message;
	
	public String Invalid_Message() {
		return invalid_message.getText();
	}
}
