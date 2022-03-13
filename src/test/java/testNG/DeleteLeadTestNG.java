package testNG;

import org.testng.annotations.Test;

import stepsLeafTaps.BaseClassLeafTaps;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteLeadTestNG extends BaseClassLeafTaps{
	
	@Test(groups= {"delete"})
	public void deleteLead() {
		
		System.out.println("From DeleteLead Test mtd");
		// Click on Phone
		String firstID = driver.findElement(By.xpath("//tr//a[@class='linktext'][1]")).getText();
		System.out.println("The first Lead ID is: " + firstID);
		System.out.println("Deleting...");

		// Click Delete
		driver.findElement(By.xpath("//tr//a[@class='linktext'][1]")).click();
		driver.findElement(By.linkText("Delete")).click();

		// Verify message "No records to display" in the Lead List
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(firstID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AssertJUnit.assertEquals(driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText(),
				"No records to display");
		System.out.println("Assertion completed");
	}
	
	
}
