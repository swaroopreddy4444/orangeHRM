package com.orangeHRM.TestRunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orangeHRM.utilities.BasePage;
import com.orangeHRM.pageobjects.LoginPage;
import com.orangeHRM.pageobjects.HomePage;
import com.orangeHRM.utilities.BrowserFactory;
import com.orangeHRM.utilities.CommonUtility;

public class Testcases {

	WebDriver driver;

	@Test(priority = 1)
	public void PositiveLoginTest_01() throws IOException {

		String result = "fail", errorMessage = null;
		try {
			String browser = CommonUtility.getProperty("config", "browser");
			this.driver = BrowserFactory.openLocalBrowser(browser);
			Reporter.log("Step 1: " + browser + " is loaded successfully");

			String url = CommonUtility.getProperty("config", "url");
			BrowserFactory.launchApplication(url);
			Reporter.log("Step 2: " + url + " is loaded successfully");

			String valid_username = CommonUtility.getProperty("config", "valid_username");
			String valid_password = CommonUtility.getProperty("config", "valid_password");
			LoginPage login = new LoginPage(driver);
			login.username_input(valid_username);
			Reporter.log("Step 3. entered username :" + valid_username);
			login.password_input(valid_password);
			Reporter.log("Step 4. entered password :" + valid_password);
			HomePage home = login.click_submit();
			Reporter.log("Step 5. Login sucessful");
			String actualtext = home.Check_for_welcome();
			Assert.assertTrue(actualtext.contains("Welcome"), " Validation Failed");
			Reporter.log("Step 6 : validation done");
			result = "pass";
		} catch (Throwable t) {
			errorMessage = t.getMessage();
			BasePage.getScreenshot(driver);
			throw t;
		} finally {
			Reporter.log("Step 7 : Testcase "+result);
			if (errorMessage != null)
					Reporter.log(errorMessage);
			BrowserFactory.KillBrowser();
			Reporter.log("step 8: Browser is closed");
		}
	}

	@Test(priority = 2)
	public void NegtiveLoginTest_02() throws IOException {

		String result = "fail", errorMessage = null;
		try {
			String browser = CommonUtility.getProperty("config", "browser");
			this.driver = BrowserFactory.openLocalBrowser(browser);
			Reporter.log("Step 1: " + browser + " is loaded successfully");
			String url = CommonUtility.getProperty("config", "url");
			BrowserFactory.launchApplication(url);
			Reporter.log("Step 2: " + url + " is loaded successfully");
			String invalid_username = CommonUtility.getProperty("config", "invalid_username");
			String invalid_password = CommonUtility.getProperty("config", "invalid_password");
			LoginPage login = new LoginPage(driver);
			login.username_input(invalid_username);
			Reporter.log("Step 3. entered username :" + invalid_username);
			login.password_input(invalid_password);
			Reporter.log("Step 4. entered password :" + invalid_password);
			login.click_submit();
			Reporter.log("Step 5. Login unsucessful");
			Assert.assertTrue(login.is_username_field_displayed());
			Reporter.log("Step 6. username field displayed");
			String actualtext = login.Invalid_Message();
			Assert.assertEquals(actualtext, "Invalid credentials", " Validation failed");
			Reporter.log("Step 7 : Invalid credentials validated successfully");
			result = "pass";
		} catch (Throwable t) {
			errorMessage = t.getMessage();
			BasePage.getScreenshot(driver);
			throw t;
		} finally {
			Reporter.log("Step 8 : Testcase "+result);
			if (errorMessage != null)
				Reporter.log(errorMessage);
			BrowserFactory.KillBrowser();
			Reporter.log("step 9 : Browser is closed");
		}
	}

}
