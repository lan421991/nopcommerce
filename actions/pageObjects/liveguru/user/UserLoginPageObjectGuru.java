package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.LoginPageUI;

public class UserLoginPageObjectGuru extends BasePage{
	private WebDriver driver;

	public UserLoginPageObjectGuru(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObjectGuru clickToCreateAnAccount() {
		waitForElementClickEnable(driver, LoginPageUI.CREATE_AN_ACCOUNT_LINK);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_LINK);
		return UserPageGeneratorManagerGuru.getRegisterPage(driver);
	}

	public void inputEmailLiveGuruTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);		
	}

	public void inputToPasswordLiveguruTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);	
	}

	public UserMyDashboardPageObjectGuru clickToLoginButton() {
		waitForElementClickEnable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return UserPageGeneratorManagerGuru.getMyDashboardPage(driver);
	}

}
