/**
 * 
 */
package com.linkedin.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.linkedin.Helper.BrowserFactory;
import com.linkedin.Pages.LinkedInAfterLoginPage;
import com.linkedin.Pages.LinkedInLoginPage;

/**
 * @author ruchira.more
 *
 */
public class BaseTest {

	WebDriver driver;
	Properties prop;
	LinkedInLoginPage loginpage;

	@BeforeTest
	public void setup() throws IOException {

		prop = new Properties();
		FileInputStream objfile = new FileInputStream(
				new File("D://Automation//PageObjectClasses//src//test//resources//config.properties"));
		prop.load(objfile);
		driver = BrowserFactory.startBrowser(prop.getProperty("browsername"), prop.getProperty("url"));
		loginpage = PageFactory.initElements(driver, LinkedInLoginPage.class);
		loginpage.waitForPageLoad();
	}

	/**
	 * 
	 * @param pageTitle
	 * @return
	 */
	public boolean validatePageTitle(String pageTitle) {

		String strPageTitle = loginpage.getPageTitle();
		System.out.println(strPageTitle);
		return strPageTitle.contains(pageTitle);
	}

	/**
	 * navigating to home page of Linked In
	 */
	public void navigateToHomePage() {
		driver.get(prop.getProperty("url"));
	}

	/**
	 * logout from linkedIn page
	 */
	public void logoutFromLinkedIn() {
		// logout the page
		LinkedInAfterLoginPage logout_page = PageFactory.initElements(driver, LinkedInAfterLoginPage.class);
		logout_page.logout();
	}

	/**
	 * closing the driver
	 */
	@AfterTest
	public void close() {
		driver.close();

	}

}
