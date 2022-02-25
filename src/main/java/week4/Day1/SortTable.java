package week4.Day1;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumProject.UtilFiles;

public class SortTable {
	public static void main(String[] args) throws IOException {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");

		// 1. Launch URL "http://www.leafground.com/pages/sorttable.html"
		driver.get("http://www.leafground.com/pages/sorttable.html");
		util.maximize(driver);

		// Sorting Functionality for Names:
		List<WebElement> names = driver.findElements(By.xpath("//td[2]"));
		List<String> sortedNameStr = names.stream().map(val -> val.getText()).sorted().collect(Collectors.toList());
		sortedNameStr.stream().forEach(val -> System.out.println(val));

		// Take Screenshot
		util.takeScreenshot(driver, "TableB4Sorting");

		// Click on name header
		driver.findElement(By.xpath("//th[2]")).click();
		List<WebElement> sortedNames = driver.findElements(By.xpath("//td[2]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<String> nameStr = sortedNames.stream().map(val -> val.getText()).collect(Collectors.toList());
		nameStr.stream().forEach(val -> System.out.println(val));
		if (nameStr.equals(sortedNameStr)) {
			System.out.println("Sorted List");
		} else {
			System.out.println("Not sorted");
		}

		// Take Screenshot
		util.takeScreenshot(driver, "TableAfterSorting");

	}

}
