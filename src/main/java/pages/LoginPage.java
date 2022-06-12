package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class LoginPage {
	WebDriver driver;

	//we are making constructor here
	
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	
	}
		
	//Elements List
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")WebElement usernameElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")WebElement passwordElement;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")WebElement singinElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")WebElement dashboardAssertiionElement;
	
	
	//Intractable methods
	
	public void insertUserName(String username) {
		usernameElement.sendKeys(username);
			
	}
	
	public void insertPassword(String password) {
		passwordElement.sendKeys(password);
	}
	
	public void clickSigninButton() {
		singinElement.click();
		
	}
	public void assertDashboard() {
		Assert.assertEquals("Wrong Page","Dashboard", dashboardAssertiionElement.getText());
	}

}
