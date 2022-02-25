package week4.Day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumProject.UtilFiles;

public class TextChange {
	public static void main(String[] args) throws IOException, InterruptedException {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");

		// 1. Launch URL "http://www.leafground.com/pages/TextChange.html"
		driver.get("http://www.leafground.com/pages/TextChange.html");
		util.maximize(driver);
		
		//Check for button invisibility
		
		util.takeScreenshot(driver, "B4Btn");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBe(By.id("btn"),"Click ME!"));
		util.takeScreenshot(driver, "BtnVisible");
		WebElement btn = driver.findElement(By.id("btn"));
		
		btn.click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		Assert.assertTrue(btn.getText().contains(alertText));
		System.out.println("Alert accepted");
		
	}
}
