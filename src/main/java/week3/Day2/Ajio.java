package week3.Day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumProject.UtilFiles;

public class Ajio extends UtilFiles{
	
	public static void main(String[] args) throws InterruptedException {
		//	1. Launch the URL https://www.ajio.com/
		WebDriver driver = setUpDriver("chrome");
		driver.manage().window().maximize();
		
		driver.get("https://www.ajio.com/");
		
		//2. In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("Bags" + Keys.ENTER);
		
		Thread.sleep(1500);
		//driver.findElement(By.className("filter-dropdown")).click();
		//driver.switchTo().alert().dismiss();
		
		//3. To the left  of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		
		Thread.sleep(1500);
		//4. Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("//label[@for='Men - Backpacks & Laptop Bags']")).click();
		Thread.sleep(1500);
		//5. Print the count of the items Found.
		System.out.println("Count of items found: "+driver.findElement(By.className("length")).getText());
		
		//6. Get the list of brand of the products displayed in the page and print the list.
		Set<String> brandName = new HashSet<>();
		List<WebElement> brandList = new ArrayList<>();
		
		brandList = driver.findElements(By.className("brand"));
		brandList.stream().forEach(val ->brandName.add(val.getText()));
		
		//print in the list
		brandName.stream().forEach(val -> System.out.println(val));
		System.out.println();
		
		//7. Get the list of names of the bags and print it
		List<WebElement> bagNames = new ArrayList<>();
		bagNames = driver.findElements(By.className("nameCls"));
		System.out.println("Printing Bag names " +bagNames.size());
		bagNames.stream().forEach(val -> System.out.println(val.getText()));
		
	}

}
