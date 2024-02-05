package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

	private static WebDriver driver;
	private static final int TIMEOUTS = 10;
	private static WebDriverWait wait;
	private static HelperClass helper;

	public HelperClass() {
		// Private constructor to enforce Singleton pattern
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUTS));
		wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUTS));
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			helper = new HelperClass();
		}
		return driver;
	}

	public static void openURL(String url) {
		driver.get(url);
	}

	public static void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static WebDriverWait getWait() {
		return wait;
	}

}
