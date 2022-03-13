package stepsLeafTaps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateContactLeafTaps extends BaseClassLeafTaps {

	
	@Given("Load the application url {string}")
	public void load_the_application_url(String url) {
		driver.get(url);

	}

	@Given("Enter the username {string}")
	public void enter_the_username(String username) {
		findElt("id", "username").sendKeys(username);

	}

	@Given("Enter the password {string}")
	public void enter_the_password(String password) {
		findElt("id", "password").sendKeys(password);

	}

	@When("Click on the login button")
	public void click_on_the_login_button() {

		findElt("className", "decorativeSubmit").click();
	}

	@Then("Homepage should be displayed")
	public void homepage_should_be_displayed() {

		findElt("partialLinkText", "CRM/SFA").click();
	}
}
