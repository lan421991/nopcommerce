package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.RegisterPageUI;

public class UserRegisterPageObjectGuru extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObjectGuru(WebDriver driver) {
		this.driver = driver;
	}

	public void inputFisrtNameTextbox(String fisrtName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, fisrtName);
	}

	public void inputMiddleNameTextbox(String middleName) {
		waitForElementVisible(driver, RegisterPageUI.MIDDLE_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.MIDDLE_NAME_TEXTBOX, middleName);
	}

	public void inputLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputEmailAddressTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);	
	}

	public UserMyDashboardPageObjectGuru clickToRegisterLiveguruButton() {
		waitForElementClickEnable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);		
		return UserPageGeneratorManagerGuru.getMyDashboardPage(driver);
	}
}
