/**
 * 
 */
package com.linkedin.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author ruchira.more
 *
 */
public class BasePage {

	public static final int MIN_TIME = 5;
	public static final int MAX_TIME = 10;

	WebDriver driver;
	Properties prop;

	public BasePage(WebDriver driver) throws IOException {
		this.driver = driver;

	}

	/**
	 * 
	 * @return the title of respective page
	 */
	public String getPageTitle() {
		return driver.getTitle();

	}

	/**
	 * method to Wait For Page To Load
	 */
	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, MIN_TIME);
		wait.withTimeout(MIN_TIME, TimeUnit.SECONDS);
	}

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, MIN_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
