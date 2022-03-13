package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import stepsLeafTaps.BaseClassLeafTaps;

public class UpdateContact extends BaseClassLeafTaps {

	@Parameters({ "field", "updateVal" })
	@Test(groups= "update")
	private void updateField(String field, String updateVal) {
		//DeleteLeadTestNG dl = new DeleteLeadTestNG();
		//dl.findLead("Name");
		System.out.println("From update Test");
		// Click Edit
		driver.findElement(By.xpath("//tr//a[@class='linktext'][1]")).click();
		driver.findElement(By.linkText("Edit")).click();

		if (field.equals("Company")) {
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(updateVal);
		}

		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// Assert same Value:
		Assert.assertEquals(driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(updateVal), true);
		System.out.println("Update Assertion Completed");

	}
}
