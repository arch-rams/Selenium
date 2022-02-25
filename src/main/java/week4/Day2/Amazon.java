package week4.Day2;

import java.time.Duration;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumProject.UtilFiles;

public class Amazon {

	public static void main(String[] args) {
			//1.Load the uRL https://www.amazon.in/
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);

		
		driver.get("https://www.amazon.in/");

			//2.search as oneplus 9 pro 
			String searchKey = "oneplus 9 pro";
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchKey+Keys.ENTER);
			
			//3.Get the price of the first product
			WebElement price1 = driver.findElement(By.xpath("(//div//span[@class='a-price-whole'])[1]"));
			String pr1 = price1.getText();
			System.out.println("First prod price is: " +pr1);
			
			//4. Print the number of customer ratings for the first displayed product
			String custRatingNum = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
			System.out.println("Number of customer ratings for this is: "+custRatingNum);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			Actions action = new Actions(driver);
			action.click(driver.findElement(By.xpath("(//span[@class='a-icon-alt']/ancestor::a)[1]"))).build().perform();
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@data-hook='acr-average-stars-rating-text'])[1]"))));
			WebElement star1Rating =  driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']"));
			
			
			String star1 = star1Rating.getText();
			System.out.println("It has got "+star1);
			
			//5. click on the stars 
			
			System.out.println(driver.findElement(By.xpath("//div[@class='a-popover-inner']//a[@class='a-link-normal']")).getText());
			
			//6. Get the percentage of ratings for the 5 star.
			
			//7. Click the first text link of the first image

			// 8. Take a screen shot of the product displayed

			//9. Click 'Add to Cart' button

			//10. Get the cart subtotal and verify if it is correct.
	}
}
