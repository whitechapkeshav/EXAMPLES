package com.example.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestEngienee {

	protected WebDriver driver;
	protected String browser;

	@Parameters({ "browser" })
	@BeforeSuite
	public void driverInitate(String browser) {

		this.browser = browser;

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("ie")) {
			File file = new File("Drivers\\IEDriverServer32.exe");
			System.setProperty("webdrivver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			File file = new File("Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		}
	}

	@AfterSuite
	public void distroy() {

	}

}
