package StepDefination;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.operation.CreateCollectionOperation;

import Locator.LoginPageLocator;
import PageAction.LoginPage;
import Utility.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepdefination {

	LoginPage loginAction;
	
	LoginPageLocator loct = new LoginPageLocator();
	HelperClass helper;

	@Given("the user is on the login page")
	public void theUserIsOnTheLoginPage() {
		helper = new HelperClass();
		HelperClass.openURL("https://demowebshop.tricentis.com/login");
	}

	@When("the user enters valid credentials from the <email> and <password>")
	public void theUserEntersValidCredentialsFromTheFollowingTable(List<Map<String, String>> datatable) {

		loginAction = new LoginPage();
		// List<Map<String, String>> credentialsList = dataTable.asMaps(String.class,
		// String.class);

		for (Map<String, String> credentials : datatable) {
			String email = credentials.get("email");
			String password = credentials.get("password");

			loginAction.enterEmail(email);
			loginAction.enterPassword(password);

		}
	}

	@When("clicks the log in button")
	public void clicksTheLoginButton() {
		loginAction.clickLogin();
	}//https://www.linkedin.com/posts/mrjandeepsingh_leadership-steppingaside-teamsuccess-activity-7158710066777337856-vA5t?utm_source=share&utm_medium=member_desktop

	@Then("the user should be redirected to the home page")
	public void theUserShouldBeRedirectedToTheHomePage() {
    //    	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    //    	WebElement element= wait.until(ExpectedConditions.elementToBeClickable(loct.logout));
//		

		String actual = helper.getDriver().findElement(By.xpath("//h2[@class=\"topic-html-content-header\"]")).getText();
		System.out.println(actual);
		String original="Welcome to our store";
		assertEquals(actual, original);
	
	}

	@Then("see a welcome message")
	public void seeAWelcomeMessage() {
		
		loginAction.logout();
        HelperClass.teardown();
	}
}
