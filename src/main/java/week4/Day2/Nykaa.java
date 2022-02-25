package week4.Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumProject.UtilFiles;

public class Nykaa extends UtilFiles{
	
	//WebDriver driver ;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	public static void main(String[] args) {

		// 1) Go to https://www.nykaa.com/
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);
		driver.get("https://www.nykaa.com/");

		Nykaa ny = new Nykaa();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		ny.brandFilter(driver);
		ny.addProdToCart(driver);

		// 18) Close all windows
		driver.quit();

	}

	private void addProdToCart(WebDriver driver) {
		// 9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//div[@class='product-listing']//img")).click();

		// 10) GO to the new window and select size as 360ml
		Set<String> handles = driver.getWindowHandles();
		List<String> handleList = new ArrayList<>(handles);
		driver.switchTo().window(handleList.get(1));
		Select size = new Select(driver.findElement(By.xpath("//select[@title='SIZE']")));
		size.selectByVisibleText("360ml");

		// 11) Print the MRP of the product
		int total = Integer.valueOf(driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span[1]")).getText().replaceAll("[^0-9]", ""));
		System.out.println("The price of the product is: "+total);

		// 12) Click on ADD to BAG
		driver.findElement(By.xpath("//button/span[text()='ADD TO BAG']")).click();

		// 13) Go to Shopping Bag
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();

		// 14) Print the Grand Total amount
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"portal-root\"]/div/div[1]/iframe")));
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[@class='value'])[4]"))));
		String grTotal = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText().replaceAll("[^0-9]", "");
		System.out.println(grTotal);

		// 15) Click Proceed
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();

		// 16) Click on Continue as Guest
		driver.switchTo().defaultContent();
		staleEltWait(driver, By.xpath("//button[text()='CONTINUE AS GUEST']"));

		// 17) Check if this grand total is the same in step 14
		
		if (driver.findElement(By.xpath("//div[text()='Grand Total']//following::span")).getText()
				.replaceAll("[^0-9]", "").equals(grTotal)) {
			System.out.println("Same Price");

		}

	}

	private void brandFilter(WebDriver driver) {
		// 2) Mouseover on Brands and Search L'Oreal Paris && 3) Click L'Oreal Paris
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[text()='brands']")))
				.click(driver.findElement(By.xpath("//img[contains(@src,'loreal')]"))).click().build().perform();

		// 4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		Assert.assertEquals(driver.getTitle().contains("L'Oreal Paris"), true);

		// 5) Click sort By and select customer top rated
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		// 6) Click Category and click Hair->Click haircare->Shampoo
		Actions action = new Actions(driver);
		
		driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		staleEltWait(driver,By.xpath("//span[text()='Hair']"));
		staleEltWait(driver,By.xpath("//span[contains(text(),'Hair Care')]"));
		staleEltWait(driver,By.xpath("(//div[@class='control-indicator checkbox '])[1]"));
		//driver.findElement(By.xpath("//span[contains(text(),'Hair Care')]")).click();
		//driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();

		// 7) Click->Concern->Color Protection
		staleEltWait(driver,By.xpath("//span[contains(text(),'Concern')]"));
		//driver.findElement(By.xpath("//span[contains(text(),'Concern')]")).click();
		String colorProtXpath = "//span[@class='title' and text()='Color Protection']//following::div[contains(@class,'checkbox')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colorProtXpath)));
		driver.findElement(By.xpath(colorProtXpath)).click();

		// 8)check whether the Filter is applied with Shampoo
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='filter-value']")).getText().contains("Shampoo"),
				true);

	}

}
