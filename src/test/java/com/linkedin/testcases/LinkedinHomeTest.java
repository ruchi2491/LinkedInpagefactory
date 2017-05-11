package com.linkedin.testcases;

/**
 * 
 */
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author ruchira.more
 *
 */
public class LinkedinHomeTest extends BaseTest {

	@Test
	public void checkValidUser() {

		// passing values as user name and password
		loginpage.loginLinkedIn(prop.getProperty("username"), prop.getProperty("password"));

		Assert.assertTrue(validatePageTitle("LinkedIn"), "page title is not matching");

		logoutFromLinkedIn();
		// navigateToHomePage();
		System.out.println(validatePageTitle("LinkedIn"));
		// loginpage.waitForPageLoad();
		Assert.assertTrue(loginpage.getPageTitle().contains("LinkedIn"), "page title is not matching");
	}

	@Test
	public void checkValidSearchResult() {

		// passing values as first name and last name
		loginpage.findColleague(prop.getProperty("firstname"), prop.getProperty("lastname"));

		Assert.assertTrue(loginpage.getPageTitle().contains("profiles | LinkedIn"), "page title is not matching");

		// navigating to home page of LinkedIn
		navigateToHomePage();
		Assert.assertTrue(loginpage.getPageTitle().contains("LinkedIn: Log In or Sign Up"),
				"page title is not matching");
	}

	@Test
	public void checkvalidSignup() {

		// passing values as first name, last name, email Id and password
		loginpage.joinNow(prop.getProperty("testfname"), prop.getProperty("testlname"), prop.getProperty("username"),
				prop.getProperty("password"));

		// waiting for pop up to be generate
		loginpage.waitForElementToBeClickable();

		Assert.assertEquals(loginpage.getPopUpTitle(), "Trying to sign in?");
		navigateToHomePage();
		Assert.assertTrue(loginpage.getPageTitle().contains("LinkedIn: Log In or Sign Up"),
				"page title is not matching");
	}

}
