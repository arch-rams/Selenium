package week4.Day2;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumProject.UtilFiles;

public class Snapdeal extends UtilFiles{
	
	public boolean retryingFindClick(WebDriver driver) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	        	new Actions(driver).moveToElement(driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]")))
				.click(driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"))).build().perform();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
	
	public static void main(String[] args) throws IOException {
		// 1. Launch https://www.snapdeal.com/
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);
		driver.get("https://www.snapdeal.com/");
		
		Snapdeal sd = new Snapdeal();
		sd.trainingShoes(driver);
		
		//set filters
		sd.setFilters(driver);
		
		
		// 11. Mouse Hover on first resulting Training shoesand click Quickview
		sd.retryingFindClick(driver);
		
		//13. Print the cost and the discount percentage 
		System.out.println(driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText()+ " Price");
		System.out.println(driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText() +" Percentage");
		 
	// 14. Take the snapshot of the shoes.	
		util.takeScreenshot(driver, "ShoeSnap");
		
		
		 // 15. Close the current window 16. Close the main window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		driver.close();
		 
	}

	private void setFilters(WebDriver driver) {
		// 6. Sort by Low to High
				new Actions(driver).click(driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")))
						.click(driver.findElement(By.xpath("(//li[@class='search-li'])[1]"))).build().perform();

				// 7. Check if the items displayed are sorted correctly
				List<WebElement> prodPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
				int lowVal = Integer.valueOf(prodPrice.get(0).getText().replaceAll("[^0-9]", ""));
				System.out.println(lowVal);
				for (WebElement pp : prodPrice) {
					int temp = Integer.valueOf(pp.getText().replaceAll("[^0-9]", ""));
					System.out.println(temp);
					if (lowVal > temp) {
						System.out.println("The list is not sorted");
						break;
					}
				}

				// 8.Select the price range (900-1200)
				driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).clear();
				driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).sendKeys("900");

				driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
				driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("1200");

				driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

				// 9.Filter with color Navy
				By by = By.xpath("//label[@for='Color_s-Navy']");
				staleEltWait(driver, by);
				
				// 10 verify the all applied filters
				WebElement fromPrice = driver.findElement(By.xpath("//span[@class='from-price-text']"));
				WebElement toPrice = driver.findElement(By.xpath("//span[@class='to-price-text']"));
				WebElement colorNavy = driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
				
				if (colorNavy.isSelected() && fromPrice.getText().contains("900") && toPrice.getText().contains("1200")) {
					System.out.println("The filters are applied");
				}
		
	}

	private void trainingShoes(WebDriver driver) {
		// 2. Go to Mens Fashion
				WebElement menFasion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
				Actions act = new Actions(driver);
				// 3. Go to Sports Shoes
				act.click(menFasion).moveToElement(driver.findElement(By.xpath("(//span[@class='linkTest'])[1]"))).click()
						.build().perform();

				// 4. Get the count of the sports shoes
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				System.out.println(driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText());
				// 5. Click Training shoes
				driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();	
	}
}
