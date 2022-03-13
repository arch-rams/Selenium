package week5.ServiceNow;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import week5.day1.ServiceNow;

public class CreateIncCucumber extends BaseClassServiceNow{
	
	ServiceNow snow = new ServiceNow();
	public String inc;
	
	@When("create New Incident and enter mandatory info {string},{string},{string}")
	public void createNewIncident(String incNum, String Caller, String ShortDesc) {
		snow.searchFilter(driver, "Incident", "Create New");
		inc = snow.enterIncidentDetails(driver, ShortDesc, Caller);
		System.out.println("Incident Created "+inc);
	}
	
	@Given ("login to serviceNow application")
	public void setUpFile() {
		setUpDriver();
	}
	
	@Then("search with Incident Number to verify if created")
	public void verifyIncCreated() {
		Assert.assertEquals(snow.userSearch(driver, "number", inc), inc);
	}

}
