package testNG;

import org.testng.annotations.Test;

import stepsLeafTaps.BaseClassLeafTaps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createContactTestNG extends BaseClassLeafTaps{
	
	
	@Test(dataProvider="Leaftaps_ContactCreation")
	public void createContact(String fName, String lName, String fLocal, String lLocal, String dept, String desc, String email, String state) {
		System.out.println("From CreateContact Test mtd");
		 // 5. Click on contacts Button
		 driver.findElement(By.linkText("Contacts")).click();
	 // 6. Click on Create Contact
		 driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
	   
	//  7. Enter FirstName Field Using id Locator
		 driver.findElement(By.id("firstNameField")).sendKeys(fName);
	  
	//  8. Enter LastName Field Using id Locator
		 driver.findElement(By.id("lastNameField")).sendKeys(lName);
		 
	//  9. Enter FirstName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(fLocal);
		 
	 // 10. Enter LastName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(lLocal);
		 
	 // 11. Enter Department Field Using any Locator of Your Choice
		 driver.findElement(By.name("departmentName")).sendKeys(dept);
		 
	 // 12. Enter Description Field Using any Locator of your choice 
		 driver.findElement(By.name("description")).sendKeys(desc);
		 
	 // 13. Enter your email in the E-mail address Field using the locator of your choice
		 driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);
		 
	  //14. Select State/Province as NewYork Using Visible Text
		 Select USstate = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		 USstate.selectByVisibleText(state);
		 
	  // 15. Click on Create Contact
		 driver.findElement(By.name("submitButton")).click();
		
	}
	
	@Test (dependsOnMethods="createContact")
	public void updateContact() {
		System.out.println("From CreateContact UpdateTest mtd");
		// 16. Click on edit button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.linkText("Edit")).click();

		// 17. Clear the Description Field using .clear
		driver.findElement(By.name("description")).clear();

		// 18. Fill ImportantNote Field with Any text
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("This is important");

		// 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//textarea[@name='importantNote']//following::input[@class='smallSubmit'][1]"))
				.click();

		// 20. Get the Title of Resulting Page.
		System.out.println(driver.getTitle());

	}
}
