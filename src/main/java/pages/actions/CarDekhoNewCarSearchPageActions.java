package pages.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.locators.ExploreNewCarPageLocators;
import utils.DropdownUtils;
import utils.SeleniumDriver;

public class CarDekhoNewCarSearchPageActions {
	ExploreNewCarPageLocators exploreNewCarPageLocators = null;

	public CarDekhoNewCarSearchPageActions() {
		this.exploreNewCarPageLocators = new ExploreNewCarPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), exploreNewCarPageLocators);
	}

	public void selectBudgetDropdown() {
		selectDropdownByVisibleText(SeleniumDriver.getDriver(), "10 - 15 Lakh");
	}

	public void selectAllVehicleTypesDropdown() {
		selectDropdownByVisibleText(SeleniumDriver.getDriver(), "SUV");
	}

	public void clickOnSearchbutton() {
		exploreNewCarPageLocators.searchButton.click();
	}
	public void selectDropdownByVisibleText(WebDriver driver, String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Step 1: Click on the dropdown input to open it
	    WebElement dropdownInput = driver.findElement(exploreNewCarPageLocators.selectBudgetDropdown);
	    dropdownInput.click();

	    // Step 2: Wait for dropdown options to be visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector(".gs_ta_results ul li")));

	    // Step 3: Find and click the option with matching visible text
	    List<WebElement> options = driver.findElements(
	        By.cssSelector(".gs_ta_results ul li"));

	    for (WebElement option : options) {
	        if (option.getText().trim().equals(visibleText)) {
	            option.click();
	            break;
	        }
	    }
	}

}
