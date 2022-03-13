package week4.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumProject.UtilFiles;

public class ServiceNowTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://dev58620.service-now.com/";
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		driver.manage().window().maximize();
		driver.get(url);

		// 2. Enter UserName and Password Using Id Locator
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Mother@3090");

		// 3. Click on Login Button using ID Locator
		driver.findElement(By.id("sysverb_login")).click();

	}

}
