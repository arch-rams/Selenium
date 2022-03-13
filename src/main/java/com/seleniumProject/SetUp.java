package com.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver","D:\TechTutorials\Eclipse\AutoResourceFiles\chromeDriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		// Logging into application
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.className("decorativeSubmit"));

		username.sendKeys("Demosalesmanager");
		password.sendKeys("crmsfa");
		login.click();

		// Creating LeadLink
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Select Options under source:
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourceType = new Select(source);
		sourceType.selectByVisibleText("Employee");
		
		//Select Options under Industry:
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industryType = new Select(industry);
		industryType.selectByValue("IND_FINANCE");
		
		//Select Options under Ownership:
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownershipType = new Select(ownership);
		ownershipType.selectByIndex(2);
				
		
		
		
		
		// driver.close();

	}

}
