package week4.Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumProject.UtilFiles;

public class ActionsJQueryUI extends UtilFiles{
	
	static WebDriver driver = setUpDriver("chrome");
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	static Actions act = new Actions(driver);
	
	public void draggable() {
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		driver.switchTo().frame(0);
		WebElement dragElt = driver.findElement(By.xpath("//div[@id='draggable']"));
		int x = dragElt.getLocation().getX();
		int y = dragElt.getLocation().getY();
		//act.dragAndDropBy(dragElt, 50, 20);
		act.dragAndDropBy(dragElt, x+50, y+60).perform();
		driver.switchTo().defaultContent();
	}

	public static void main(String[] args) {
		// 1.Load the uRL https://jqueryui.com/draggable
		UtilFiles util = new UtilFiles();
		
		util.maximize(driver);

		driver.get("https://jqueryui.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		ActionsJQueryUI obj = new ActionsJQueryUI();
		
		// Draggable
		obj.draggable();
		
		// Droppable
		obj.droppable();
		
		// Resizable
		obj.resizable();
		
		//Selectable
		obj.selectable();
		
		//Sortable
		obj.sortable();
		
		

	}

	private void sortable() {
		driver.findElement(By.xpath("//a[text()='Sortable']")).click();
		driver.switchTo().frame(0);
		List<WebElement> multiItems = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		act.dragAndDrop(multiItems.get(1), multiItems.get(6)).release().perform();
		act.dragAndDrop(multiItems.get(3) , multiItems.get(4)).perform();
		driver.switchTo().defaultContent();
	}

	private void droppable() {
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		driver.switchTo().frame(0);
		WebElement dragElt = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropElt = driver.findElement(By.id("droppable"));
		act.dragAndDrop(dragElt, dropElt).perform();
		driver.switchTo().defaultContent();
	}
	
	private void resizable() {
		driver.findElement(By.xpath("//a[text()='Resizable']")).click();
		driver.switchTo().frame(0);
		WebElement resizeElt = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		act.clickAndHold(resizeElt).moveByOffset(100,100).release().perform();
		driver.switchTo().defaultContent();
	}
	
	private void selectable() {
		driver.findElement(By.xpath("//a[text()='Selectable']")).click();
		driver.switchTo().frame(0);
		
		List<WebElement> multiItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		//Individual select:
		multiItems.get(0).click();
		multiItems.get(3).click();
		driver.findElement(By.id("selectable")).click();
		
		//multiple Items select - ctrl
		act.click(multiItems.get(1)).keyDown(Keys.CONTROL).click(multiItems.get(3)).click(multiItems.get(5)).keyUp(Keys.CONTROL).build().perform();
		driver.findElement(By.id("selectable")).click();
		
		//multiple Items select - ctrl
		act.dragAndDrop(multiItems.get(1), multiItems.get(5)).release().perform();		
		//
		driver.switchTo().defaultContent();
	}

}
