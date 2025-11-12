package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ExploreNewCarPageLocators {
	@FindBy(how = How.NAME, using = "budget")
	public WebElement selectBudgetDropdown;
	@FindBy(how = How.NAME, using = "vehicleTypeName")
	public WebElement selectAllVehicleTypeDropdown;
	@FindBy(how = How.NAME, using = "go")
	public WebElement searchButton;
}
