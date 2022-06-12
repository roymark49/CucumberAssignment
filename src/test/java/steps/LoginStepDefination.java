package steps;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DatabasePage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefination extends TestBase {
	LoginPage loginpage;
	DatabasePage databasepage;
	
	@Before
	public void beforeRun() {
		init();
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		databasepage = PageFactory.initElements(driver, DatabasePage.class);
			
	}
	@Given("^User is on the TechFios login page$")
	public void user_is_on_the_TechFios_login_page() {

	}

	@When("^User enters \"([^\"]*)\"$")
	public void user_enters(String data) throws SQLException {
		
		if (data.equalsIgnoreCase("username")) {
			loginpage.insertUserName(databasepage.getDataFromDb("username"));

		}
		else if (data.equalsIgnoreCase("password")) {
			databasepage.getDataFromDb("password");
			loginpage.insertPassword(databasepage.getDataFromDb("password"));

		}
		else {
			
			System.out.println("Invalid Input");
		}
		
	}

	@When("^User clicks signin button$")
	public void user_clicks_signin_button() {
		loginpage.clickSigninButton();
	}

	@Then("^User should land on the dashboard page$")
	public void user_should_land_on_the_dashboard_page() throws IOException, InterruptedException {
		loginpage.assertDashboard();
		screenshotTake();
	   
	}

	@After
	public void afterRun() {
		tearDown();
		
	}
	
}
