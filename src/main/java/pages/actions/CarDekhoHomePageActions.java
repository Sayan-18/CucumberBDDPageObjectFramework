package pages.actions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.locators.CarDekhoHomePageLocators;
import utils.SeleniumDriver;

public class CarDekhoHomePageActions {
	CarDekhoHomePageLocators cardDekhoHomePageLocators = null;

	public CarDekhoHomePageActions() {
		this.cardDekhoHomePageLocators = new CarDekhoHomePageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), cardDekhoHomePageLocators);
	}

	public void moveToExploreNewCarsMenu() {
		Actions action = new Actions(SeleniumDriver.getDriver());
		action.moveToElement(cardDekhoHomePageLocators.newCarsLink);
	}

	public void clickOnExploreNewCarsMenu() {
		cardDekhoHomePageLocators.exploreNewCarsLink.click();
	}
}
