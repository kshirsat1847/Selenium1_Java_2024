package PageAction;

import org.openqa.selenium.support.PageFactory;

import Locator.LoginPageLocator;
import Utility.HelperClass;

public class LoginPage {

	private LoginPageLocator locator;

	public LoginPage() {
		this.locator = new LoginPageLocator();
		PageFactory.initElements(HelperClass.getDriver(), this.locator);
	}

	public void enterEmail(String email) {
		locator.email.click();
		locator.email.sendKeys(email);
	}

	public void enterPassword(String password) {
		locator.pass.sendKeys(password);
	}

	public void clickLogin() {
		locator.clickBtn.click();
	}

	public void logout() {
		locator.logout.click();
	}
}
