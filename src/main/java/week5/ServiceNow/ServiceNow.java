package week5.ServiceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ServiceNow {

	public static String incidentNum;

	public void searchFilter(WebDriver driver, String Keyword, String searchKey) {
		// filter Incident
		driver.findElement(By.id("filter")).sendKeys(Keyword + Keys.ENTER);

		// click on create new
		driver.findElement(By.xpath("//div[text()='" + searchKey + "' ]")).click();
	}

	public String createNewInc(WebDriver driver, String desc, String caller) {

		// switch to Frame
		driver.switchTo().frame("gsft_main");

		// Get IncidentNum
		incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");

		// Search for Caller
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		userSearch(driver, "name", caller);

		// adding incident description
		driver.findElement(By.id("incident.short_description")).sendKeys(desc);

		// click on Submit
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();

		return incidentNum;

	}

	public String userSearch(WebDriver driver, String type, String value) {

		if (type.equalsIgnoreCase("name")) {
			//Switch to the newly opened window
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windowHandleList = new ArrayList<>(windowHandles);
			driver.switchTo().window(windowHandleList.get(1));
			driver.manage().window().maximize();
			
			//search with type as name and the value of caller
			System.out.println("The caller info is: " + value);
			if(!value.isEmpty()) {
			//Select searchType = new Select(driver.findElement(By.className("form-control.default-focus-outline")));
			//searchType.selectByValue("name");
			driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']"))
					.sendKeys(value + Keys.ENTER);
			
			//click on the name from the searchlist
			driver.findElement(By.xpath("//a[contains(text(),'" + value + "')]")).click();

			//switch back to the main window
			driver.switchTo().window(windowHandleList.get(0));
			driver.switchTo().frame("gsft_main");

			return null;
				} else {
					driver.findElement(By.xpath("//tbody[@class='list2_body']//a")).click();
					return null;
				}
			
		} else if (type.equalsIgnoreCase("number")) {
			// switch to Frame
			driver.switchTo().frame("gsft_main");

			// Set the search type to number
			Select searchType = new Select(driver.findElement(By.cssSelector(".form-control.default-focus-outline")));
			searchType.selectByValue("number");
			driver.findElement(By.xpath("(//div[@class='input-group']//input[@placeholder='Search'])[1]"))
					.sendKeys(value + Keys.ENTER);

			String incVal = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
			return incVal;

		} else
			return null;

	}

	public void updateInc(WebDriver driver, String incNum, String state, String Urgency, String AssignTo) {
		//click on the inc Num
		
		driver.findElement(By.xpath("//a[@class='.linked.formlink' and contains(text(),'" + incNum + "')]")).click();
		//Change state
		Select stateVal = new Select(driver.findElement(By.id("incident.state")));
		stateVal.selectByVisibleText(state);
		//Update Urgency
		
	}

}
