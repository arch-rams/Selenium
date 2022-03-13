package stepsLeafTaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import com.seleniumProject.UtilFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClassLeafTaps extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
@BeforeMethod
	public void setUpSite(String url, String username, String password) {
		UtilFiles util = new UtilFiles();
		driver = util.setUpDriver("chrome");
		util.maximize(driver);
		
	}

	public WebElement findElt(String by, String value) {

		switch (by) {
		case "id":
			return driver.findElement(By.id(value));

		case "xpath":
			return driver.findElement(By.xpath(value));

		case "name":
			return driver.findElement(By.name(value));

		case "className":
			return driver.findElement(By.className(value));

		case "linkText":
			return driver.findElement(By.linkText(value));

		case "partialLinkText":
			return driver.findElement(By.partialLinkText(value));

		case "cssSelector":
			return driver.findElement(By.cssSelector(value));

		case "tagName":
			return driver.findElement(By.tagName(value));

		default:
			return driver.findElement(By.id(value));
		}
	}
}
