package week4.Day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumProject.UtilFiles;

public class Appear {
	public static void main(String[] args) throws IOException {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");

		// 1. Launch URL "http://www.leafground.com/pages/appear.html"
		driver.get("http://www.leafground.com/pages/appear.html");
		util.maximize(driver);
		
		//Check for button invisibility
		String msgWhenVisible = "I know you can find him";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		util.takeScreenshot(driver, "BtnInvisible");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='flex']//b)[5]"))));
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='flex']//b)[5]")).getText().contains(msgWhenVisible));
		util.takeScreenshot(driver, "BtnShown");
		System.out.println("Element now visible");
		
		
		
	}
}
