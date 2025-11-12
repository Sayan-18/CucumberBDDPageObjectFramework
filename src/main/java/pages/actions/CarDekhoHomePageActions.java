package pages.actions;

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

	}

	public void clickOnExploreNewCarsMenu() {

	}
}
