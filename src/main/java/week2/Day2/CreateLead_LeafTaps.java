package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead_LeafTaps {

	public void loginToLeafTaps(WebDriver driver) {
		//2. Enter UserName and Password Using Id Locator
	  	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	  
	 // 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
	  
	 // 4. Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//return driver;
	}
	
	public static void main(String[] args) {
		  
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		CreateLead_LeafTaps cc = new CreateLead_LeafTaps();
		
		 // 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  	driver.get("http://leaftaps.com/opentaps/control/login");
		  	
		  cc.loginToLeafTaps(driver);
		  cc.createLead(driver);
	}

	private void createLead(WebDriver driver) {
		
		//Click on My Leads
		driver.findElement(By.linkText("Leads")).click();
		// Click on createLead
		driver.findElement(By.linkText("Create Lead")).click();
		//click on company
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("something");
	}
}
