package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import java.util.List;

/**
 * Utility class for handling various types of dropdown operations Works with
 * the existing SeleniumDriver singleton pattern
 */
public class DropdownUtils {

	/**
	 * Selects dropdown option by visible text for custom dropdowns
	 * 
	 * @param locator        - By locator for the dropdown trigger element
	 * @param optionsLocator - By locator for dropdown options
	 * @param visibleText    - Text to select
	 * @return boolean - true if selection successful, false otherwise
	 */
	public static boolean selectCustomDropdownByText(By locator, By optionsLocator, String visibleText) {
		try {
			WebDriver driver = SeleniumDriver.getDriver();
			WebDriverWait wait = SeleniumDriver.wait;

			// Click to open dropdown
			WebElement dropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(locator));
			dropdownTrigger.click();

			// Wait for options to be visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(optionsLocator));

			// Find and click the matching option
			List<WebElement> options = driver.findElements(optionsLocator);

			for (WebElement option : options) {
				if (option.getText().trim().equals(visibleText)) {
					wait.until(ExpectedConditions.elementToBeClickable(option));
					option.click();
					return true;
				}
			}

			System.err.println("Option with text '" + visibleText + "' not found");
			return false;

		} catch (TimeoutException | NoSuchElementException e) {
			System.err.println("Error selecting dropdown option: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Selects dropdown option by partial text match
	 * 
	 * @param locator        - By locator for the dropdown trigger element
	 * @param optionsLocator - By locator for dropdown options
	 * @param partialText    - Partial text to match
	 * @return boolean - true if selection successful, false otherwise
	 */
	public static boolean selectCustomDropdownByPartialText(By locator, By optionsLocator, String partialText) {
		try {
			WebDriver driver = SeleniumDriver.getDriver();
			WebDriverWait wait = SeleniumDriver.wait;

			WebElement dropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(locator));
			dropdownTrigger.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(optionsLocator));

			List<WebElement> options = driver.findElements(optionsLocator);

			for (WebElement option : options) {
				if (option.getText().trim().contains(partialText)) {
					wait.until(ExpectedConditions.elementToBeClickable(option));
					option.click();
					return true;
				}
			}

			System.err.println("Option containing text '" + partialText + "' not found");
			return false;

		} catch (TimeoutException | NoSuchElementException e) {
			System.err.println("Error selecting dropdown option: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Selects dropdown option by data attribute value
	 * 
	 * @param locator        - By locator for the dropdown trigger element
	 * @param optionsLocator - By locator for dropdown options
	 * @param attributeName  - Name of the data attribute
	 * @param attributeValue - Value of the data attribute
	 * @return boolean - true if selection successful, false otherwise
	 */
	public static boolean selectCustomDropdownByAttribute(By locator, By optionsLocator, String attributeName,
			String attributeValue) {
		try {
			WebDriver driver = SeleniumDriver.getDriver();
			WebDriverWait wait = SeleniumDriver.wait;

			WebElement dropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(locator));
			dropdownTrigger.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(optionsLocator));

			List<WebElement> options = driver.findElements(optionsLocator);

			for (WebElement option : options) {
				String attrValue = option.getAttribute(attributeName);
				if (attrValue != null && attrValue.equals(attributeValue)) {
					wait.until(ExpectedConditions.elementToBeClickable(option));
					option.click();
					return true;
				}
			}

			System.err.println("Option with " + attributeName + "='" + attributeValue + "' not found");
			return false;

		} catch (TimeoutException | NoSuchElementException e) {
			System.err.println("Error selecting dropdown option: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Specific method for your budget dropdown
	 * 
	 * @param budgetRange - Budget range text to select
	 * @return boolean - true if selection successful, false otherwise
	 */
	public static boolean selectBudgetDropdown(String budgetRange) {
		By dropdownLocator = By.id("budget");
		By optionsLocator = By.cssSelector(".gs_ta_results ul li");

		return selectCustomDropdownByText(dropdownLocator, optionsLocator, budgetRange);
	}

	/**
	 * Gets the currently selected value from a dropdown
	 * 
	 * @param locator - By locator for the dropdown element
	 * @return String - selected value or empty string if not found
	 */
	public static String getSelectedDropdownValue(By locator) {
		try {
			WebDriver driver = SeleniumDriver.getDriver();
			WebElement dropdown = driver.findElement(locator);
			return dropdown.getAttribute("value");
		} catch (NoSuchElementException e) {
			System.err.println("Dropdown element not found: " + e.getMessage());
			return "";
		}
	}

	/**
	 * Checks if dropdown is currently open/expanded
	 * 
	 * @param optionsLocator - By locator for dropdown options container
	 * @return boolean - true if dropdown is open, false otherwise
	 */
	public static boolean isDropdownOpen(By optionsLocator) {
		try {
			WebDriver driver = SeleniumDriver.getDriver();
			WebElement optionsContainer = driver.findElement(optionsLocator);
			return optionsContainer.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Gets all available options from a dropdown
	 * 
	 * @param locator        - By locator for the dropdown trigger element
	 * @param optionsLocator - By locator for dropdown options
	 * @return List<String> - list of all option texts
	 */
	public static List<String> getAllDropdownOptions(By locator, By optionsLocator) {
		try {
			WebDriver driver = SeleniumDriver.getDriver();
			WebDriverWait wait = SeleniumDriver.wait;

			WebElement dropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(locator));
			dropdownTrigger.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(optionsLocator));

			List<WebElement> options = driver.findElements(optionsLocator);

			return options.stream().map(option -> option.getText().trim()).toList();

		} catch (TimeoutException | NoSuchElementException e) {
			System.err.println("Error getting dropdown options: " + e.getMessage());
			return List.of();
		}
	}
}
