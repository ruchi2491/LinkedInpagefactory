package com.linkedin.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LinkedInAfterLoginPage extends BasePage {

	
	public LinkedInAfterLoginPage(WebDriver driver) throws IOException {
		super(driver);
	}

	//finding the locators with annotation
	@FindBy(how=How.ID,using="nav-settings__dropdown-trigger")
	WebElement dropdownButton;
	
	
	@FindBy(how=How.LINK_TEXT,using="Sign out")
	WebElement logoutButton;
	
	
	public void logout()
	{
		//clicking on button to reach up to logout button 
		dropdownButton.click();
		logoutButton.click();
	}
}
