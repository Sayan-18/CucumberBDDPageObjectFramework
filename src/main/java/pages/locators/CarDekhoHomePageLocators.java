package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarDekhoHomePageLocators {
	@FindBy(how = How.LINK_TEXT, using = "NEW CARS")
	public WebElement newCarsLink;
	@FindBy(how = How.LINK_TEXT, using = "USED CARS")
	public WebElement usedCarsLink;
	@FindBy(how = How.LINK_TEXT, using = "NEWS & REVIEWS")
	public WebElement newsAndReviewsLink;
	@FindBy(how = How.LINK_TEXT, using = "VIDEOS")
	public WebElement videosLink;
	@FindBy(how = How.LINK_TEXT, using = "Explore New Cars")
	public WebElement exploreNewCarsLink;
}
