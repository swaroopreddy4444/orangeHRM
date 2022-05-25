package com.orangeHRM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.utilities.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(super.driver, this);
	}

	@FindBy(xpath = "//*[starts-with(text(),'Welcome')]")
	WebElement welcome;
	
	public String Check_for_welcome() {
		return welcome.getText();
	}
}
