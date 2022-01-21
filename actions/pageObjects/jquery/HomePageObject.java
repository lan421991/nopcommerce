package pageObjects.jquery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickEnable(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActivedByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextboxByName(String headerName, String value) {
		waitForAllElementVisible(driver, HomePageUI.HEADER_TEXT_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXT_BY_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXT_BY_NAME, Keys.ENTER, headerName);
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		waitForElementClickEnable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction );
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);	
	}

	public boolean isRowValueDisplayed(String female, String country, String male, String total) {
		waitForAllElementVisible(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female, country, male, total);
	}

	public void inputToTextboxByRowNumber(String headerName, String rowIndex, String value) {
		int columnIndex = getElemnentSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName);
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, rowIndex,String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, value, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowIndex, String actionIcon) {
		waitForElementClickEnable(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex, actionIcon );
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex, actionIcon);
	}

	 
}
