package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUIs.nopcommerce.LoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	private WebDriverWait expicitWait;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserLoginPageObject(WebDriver driver, WebDriverWait expicitWait) {
		this.driver = driver;
		this.expicitWait = expicitWait;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickEnable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return UserPageGeneratorManager.getHomePage(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_UNSUCCESSFULL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_UNSUCCESSFULL_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);	
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		  inputEmailTextbox(emailAddress);
		  inputToPasswordTextbox(password);		
		  return clickToLoginButton();
	}
	
}
