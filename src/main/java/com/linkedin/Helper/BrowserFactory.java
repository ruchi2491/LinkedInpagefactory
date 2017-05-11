package com.linkedin.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	static Properties prop;

	public static WebDriver startBrowser(String browsername, String url) throws IOException {
		if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			prop = new Properties();
			FileInputStream objfile = new FileInputStream(
					new File("D://Automation//PageObjectClasses//src//test//resources//config.properties"));
			prop.load(objfile);
			// System.out.println(prop.getProperty("chromedriver"));
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
