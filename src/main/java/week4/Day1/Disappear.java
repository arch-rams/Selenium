package week4.Day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumProject.UtilFiles;

public class Disappear {
	public static void main(String[] args) throws IOException {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");

		// 1. Launch URL "http://www.leafground.com/pages/disapper.html"
		driver.get("http://www.leafground.com/pages/disapper.html");
		util.maximize(driver);
		
		//Check for button
		String msgWhenVisible = "I'm going to disappear. Keep looking at me!!";
		Assert.assertEquals(driver.findElement(By.xpath("//button[@id='btn']/b")).getText(), msgWhenVisible);
		util.takeScreenshot(driver, "BtnShown");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("btn"))));
		System.out.println("Element now invisible");
		
		String msgWhenInvi = "is disappeared";
		Assert.assertTrue(driver.findElement(By.id("show")).getText().contains(msgWhenInvi));
		util.takeScreenshot(driver, "BtnDisappears");
	}
}
