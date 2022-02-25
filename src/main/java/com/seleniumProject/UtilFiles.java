package com.seleniumProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void takeScreenshot(WebDriver driver, String func) throws IOException {
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File tmp = srcShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Archana\\Selenium\\src\\main\\resources\\" +func+timeStamp()+".jpg");
		FileUtils.copyFile(tmp, dest);
	}
	
	public void takeScreenshot(WebDriver driver, WebElement elt,String func) throws IOException {
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		
		File tmp = srcShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Archana\\Selenium\\src\\main\\resources\\" +func+timeStamp()+".jpg");
		FileUtils.copyFile(tmp, dest);
	}
	
	public String timeStamp() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		LocalDateTime now = LocalDateTime.now();
		
		String time = dtf.format(now);
		
		return time;
	}
	
	public void staleEltWait(WebDriver driver, By by) {
		new WebDriverWait(driver, Duration.ofSeconds(5))
        .ignoring(StaleElementReferenceException.class)
        .until((WebDriver d) -> {
            d.findElement(by).click();
            return true;
        });
	}
	
	public boolean moveAndClick(WebDriver driver, List<WebElement> elt) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	        	new Actions(driver).moveToElement(elt.get(0))
				.click(elt.get(1)).build().perform();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}

}
