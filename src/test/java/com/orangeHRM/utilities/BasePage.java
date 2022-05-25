package com.orangeHRM.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public enum All_Locators {
		ID, NAME, CLASSNAME, TAGNAME, LINKTEXT, PARTITALLINKTEXT, XPATH, CSS;
	}

	public WebElement getElement(All_Locators locator_type, String locator_value) {

		switch (locator_type) {
		case ID:
			return this.driver.findElement(By.id(locator_value));
		case NAME:
			return this.driver.findElement(By.name(locator_value));
		case CLASSNAME:
			return this.driver.findElement(By.className(locator_value));
		case TAGNAME:
			return this.driver.findElement(By.tagName(locator_value));
		case LINKTEXT:
			return this.driver.findElement(By.linkText(locator_value));
		case PARTITALLINKTEXT:
			return this.driver.findElement(By.partialLinkText(locator_value));
		case XPATH:
			return this.driver.findElement(By.xpath(locator_value));
		case CSS:
			return this.driver.findElement(By.cssSelector(locator_value));

		}
		return null;
	}

	public List<WebElement> listofElements(All_Locators locator_type, String locator_value) {

		switch (locator_type) {
		case ID:
			return this.driver.findElements(By.id(locator_value));
		case NAME:
			return this.driver.findElements(By.name(locator_value));
		case CLASSNAME:
			return this.driver.findElements(By.className(locator_value));
		case TAGNAME:
			return this.driver.findElements(By.tagName(locator_value));
		case LINKTEXT:
			return this.driver.findElements(By.linkText(locator_value));
		case PARTITALLINKTEXT:
			return this.driver.findElements(By.partialLinkText(locator_value));
		case XPATH:
			return this.driver.findElements(By.xpath(locator_value));
		case CSS:
			return this.driver.findElements(By.cssSelector(locator_value));

		}
		return null;
	}

	public static String getCurrentDate() {

		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm_ss"));
	}

	public static void getScreenshot(SearchContext driver_or_Element) throws IOException {

		File src = ((TakesScreenshot) driver_or_Element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/pic_"+getCurrentDate()+".png"));
	}


}
