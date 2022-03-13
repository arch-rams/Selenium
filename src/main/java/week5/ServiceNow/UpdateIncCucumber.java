package week5.ServiceNow;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateIncCucumber extends BaseClassServiceNow {

	public static String incNo, state, urgency, assignTo, status;
	public static List<String> incidents = new ArrayList<>();
	public static List<String> currentState = new ArrayList<>();
	public static List<String> urg = new ArrayList<>();
	public static List<String> assignee = new ArrayList<>();
	public static List<String> dataStatus = new ArrayList<>();

	ServiceNow snow = new ServiceNow();

	// @Given("Read incData from excel")
	// @Test(dataProvider = "CreateNUpdate")
	public void readDataFromExcel(String incNo, String state, String urgency, String assignTo, String status) {

		this.incNo = incNo;
		this.state = state;
		this.urgency = urgency;
		this.assignTo = assignTo;
		this.status = status;
	}

	@Given ("Read incData from excel {string},{string},{string},{string},{string}")
	public void readDataFromEg(String incNo, String state, String urgency, String assignTo, String status) {

		this.incNo = incNo;
		this.state = state;
		this.urgency = urgency;
		this.assignTo = assignTo;
		this.status = status;
	}

	@Given("update Incident fields")
	public void update_incident_fields() {
		snow.searchFilter(driver, "Incident", "All");
		snow.userSearch(driver, "number", incNo);
	}

	@When("click on update")
	public void click_on_update() {
		snow.updateInc(driver, incNo, state, urgency, assignTo);
	}

	@Then("incident is updated")
	public void incident_is_updated() {
		System.out.println("It reached this point");
	}

}
