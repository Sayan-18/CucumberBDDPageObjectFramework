package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {
	public static SeleniumDriver seleniumDriver;

//init WebDriver
	private static WebDriver driver;
	private static WebDriverWait wait;
	public final static Duration TIMEOUT = Duration.ofSeconds(30);
	public final static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(50);

	private SeleniumDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
	}

	public static void openPage(String url) {
		driver.get(url);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	public void setUpDriver() {
		if(seleniumDriver==null) {
			seleniumDriver=new SeleniumDriver();
		}
	}
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
		seleniumDriver=null;
	}
}
