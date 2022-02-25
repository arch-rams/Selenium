package week4.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) 
	{

         WebDriverManager.chromedriver().setup();
         ChromeDriver driver=new ChromeDriver();
         driver.get("https://jqueryui.com/draggable/");
         driver.manage().window().maximize();
         driver.switchTo().frame(0);
         WebElement findElement = driver.findElement(By.id("draggable"));
         Actions builder=new Actions(driver);
         //builder.dragAndDropBy(findElement, 200,200).perform();
         int x = findElement.getLocation().getX();
         int y = findElement.getLocation().getY();
         builder.dragAndDropBy(findElement, x+50, y+50).perform();

	}
}


