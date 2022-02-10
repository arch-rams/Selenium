package com.seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UtilFiles {

	public static WebDriver setUpDriver(String browserType) {

		browserType = browserType.toLowerCase();

		switch (browserType) {

		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "D:\\Archana\\AutoResourceFiles\\chromeDriver.exe");
			ChromeDriver driver = new ChromeDriver();
			return driver;

		}

		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "D:\\Archana\\AutoResourceFiles\\chromeDriver.exe");
			FirefoxDriver driver = new FirefoxDriver();
			return driver;

		}
		default: {
			System.setProperty("webdriver.chrome.driver", "D:\\Archana\\AutoResourceFiles\\chromeDriver.exe");
			ChromeDriver driver = new ChromeDriver();
			return driver;

		}

		}
	}

	public void maximize(WebDriver driver) {

		driver.manage().window().maximize();
	}

	public void minimize(WebDriver driver) {

		driver.manage().window().minimize();
	}


}
