package week4.Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumProject.UtilFiles;

import week2.Day2.CreateContact;

public class WebTable {

	public static void main(String[] args) {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		
		// 1. Launch URL "http://www.leafground.com/pages/table.html"
		driver.get("http://www.leafground.com/pages/table.html");

		// count of no. columns
		int colNum = driver.findElements(By.xpath("(//table[@id='table_id']//tr)[2]/td")).size();
		System.out.println("Count of columns: " + colNum);

		// count of rows
		int rowNum = driver.findElements(By.xpath("//table[@id='table_id']//tr")).size();
		System.out.println("Count of columns: " + rowNum);

		// progress value of Learn to Interact with Elements:
		String percent = driver.findElement(By.xpath("//td[contains(text(),'Elements')]/following-sibling::td[1]"))
				.getText();
		System.out.println("Learn to Interact with Elements:" + percent);

		// Check the vital task of least completed progress

		List<WebElement> progPercent = driver.findElements(By.xpath("(//tr/td[2])"));
		int n1 = 100;
		/*
		for (WebElement el : progPercent) {
			int num = Integer.valueOf(el.getText().substring(0, el.getText().lastIndexOf('%')));
			n1 = Math.min(n1, num);
		}
		System.out.println("The minimum percentage is:" + n1);

		*/
		n1 = progPercent.stream()
				.mapToInt(
						el -> Integer.valueOf(el.getText().substring(0, el.getText().lastIndexOf('%'))).intValue())
				.min().orElseThrow(NoSuchElementException::new);

		System.out.println("The minimum percentage is:" + n1 +"%");

	}

}
