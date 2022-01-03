package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToCreateAnAccount() {
		waitForElementClickEnable(driver, LoginPageUI.CREATE_AN_ACCOUNT_LINK);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputEmailLiveGuruTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);		
	}

	public void inputToPasswordLiveguruTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);	
	}

	public MyDashboardPageObject clickToLoginButton() {
		waitForElementClickEnable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}

}
