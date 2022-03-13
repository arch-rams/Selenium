package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.seleniumProject.UtilFiles;

public class BaseClassTestNG extends UtilFiles {

	public static WebDriver driver;
	public String url = "http://leaftaps.com/opentaps/control/login";

	@BeforeTest()
	public void setUpDriver() {

		driver = setUpDriver("chrome");
		maximize(driver);
		driver.get(url);

	}

	@BeforeMethod()
	public void loginToLeafTaps() {
		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// 4. Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
	}

}
