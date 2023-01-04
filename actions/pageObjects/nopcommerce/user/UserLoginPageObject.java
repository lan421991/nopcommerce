package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.LoginPageUI;

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

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_UNSUCCESSFULL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_UNSUCCESSFULL_ERROR_MESSAGE);
	}

	@Step("Input To Email Textbox")
	public void inputEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Input To Password Textbox")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);	
	}

	@Step("Click To Login Button")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickEnable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		  inputEmailTextbox(emailAddress);
		  inputToPasswordTextbox(password);		
		  return clickToLoginButton();
	}
	
}
