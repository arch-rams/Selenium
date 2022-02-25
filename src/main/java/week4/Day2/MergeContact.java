package week4.Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumProject.UtilFiles;

import week2.Day2.CreateContact;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		CreateContact cc = new CreateContact();
		cc.loginToLeafTaps(driver);

		// 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[contains(text(),'Merge')]")).click();

		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> handle = driver.getWindowHandles();

		// 8. Click on First Resulting Contact
		List<String> windowList = new ArrayList<>(handle);
		windowList.stream().forEach(val -> System.out.println(val));
		driver.switchTo().window(windowList.get(1));

		// 9. Click on Widget of To Contact
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='linktext'])[1]")));
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(windowList.get(0));
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		handle.removeAll(handle);
		handle = driver.getWindowHandles();
		windowList.removeAll(windowList);
		windowList.addAll(handle);
		driver.switchTo().window(windowList.get(1));
		
		// 10. Click on Second Resulting Contact
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='linktext'])[6]")));
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		driver.switchTo().window(windowList.get(0));
		
		// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.className("buttonDangerous")).click();
		
		// 12. Accept the Alert
		driver.switchTo().alert().accept();
		
		// 13. Verify the title of the page
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("View Contact"));
		System.out.println(title);

	}
}
