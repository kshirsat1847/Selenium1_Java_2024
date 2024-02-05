package Locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator {

	@FindBy(css = "input.email")
	public WebElement email;

	@FindBy(xpath = "//input[@id='Password']")
	public WebElement pass;

	@FindBy(xpath = "//input[@type='submit']/parent::div[@class='buttons']")
	public WebElement clickBtn;

	// @FindBy(xpath = "//a[text()='Log out']")
	@FindBy(css = "a.ico-logout")
	public WebElement logout;
	
	@FindBy(xpath = "//h2[@class=\"topic-html-content-header\"]")
	public WebElement message;
}
