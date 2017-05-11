/**
 * 
 */
package com.linkedin.Pages;

import java.io.IOException;
/**
 * @author ruchira.more
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInLoginPage extends BasePage {

	public LinkedInLoginPage(WebDriver driver) throws IOException {
		// TODO Auto-generated constructor stub
		super(driver);

	}

	// locator for user name
	@FindBy(id = "login-email")
	WebElement username;

	// locator for password
	@FindBy(how = How.ID, using = "login-password")
	WebElement userpass;

	// locator for login button
	@FindBy(how = How.ID, using = "login-submit")
	WebElement loginbutton;

	// locator for first name for searching a colleague
	@FindBy(name = "first")
	WebElement firstname;

	// locator for last name for searching a colleague
	@FindBy(name = "last")
	WebElement lastname;

	// locator for search button for searching a colleague
	@FindBy(how = How.CLASS_NAME, using = "submit-btn")
	WebElement searchButton;

	// locator for first name for sign up
	@FindBy(id = "reg-firstname")
	WebElement firstSignupName;

	// locator for last name for sign up
	@FindBy(id = "reg-lastname")
	WebElement lastSignupName;

	// locator for email Id for sign up
	@FindBy(id = "reg-email")
	WebElement emailSignup;

	// locator for password for sign up
	@FindBy(id = "reg-password")
	WebElement passSignup;

	// locator for submit button for sign up
	@FindBy(id = "registration-submit")
	WebElement signupButton;

	// locator for pop up after sign up button click
	@FindBy(className = "hopscotch-title")
	WebElement popupTitle;

	// locator for pop up close button after sign up button click
	@FindBy(className = "close")
	WebElement closebutton;

	/**
	 * Method to login using user name and password.
	 * 
	 * @param uid
	 * @param pass
	 */
	public void loginLinkedIn(String uid, String pass) {
		// entering values for user name and password
		username.sendKeys(uid);
		userpass.sendKeys(pass);
		// click on sign in button
		loginbutton.click();
	}

	/**
	 * method to find a colleagues.
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void findColleague(String firstName, String lastName) {
		// entering values for first name and last name
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		// click on search button
		searchButton.click();
	}

	/**
	 * Method to sign up using firstname, lastname, email and password.
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param pass
	 */
	public void joinNow(String firstname, String lastname, String email, String pass) {

		// wait For element to be clicked
		waitForElementToBeClickable(firstSignupName);
		// entering the values for first name, last name, email and password
		firstSignupName.sendKeys(firstname);
		lastSignupName.sendKeys(lastname);
		emailSignup.sendKeys(email);
		passSignup.sendKeys(pass);

		// Click on sign up.
		signupButton.click();

		// Click on close.
		// closebutton.click();
	}

	/**
	 * method to get a pop up title
	 * 
	 * @return
	 */
	public String getPopUpTitle() {
		return popupTitle.getText();
	}

	/**
	 * method to Wait For Element To Be Clickable
	 */
	public void waitForElementToBeClickable() {
		WebDriverWait wait = new WebDriverWait(driver, MIN_TIME);

		wait.until(ExpectedConditions.elementToBeClickable(signupButton));
	}
}
