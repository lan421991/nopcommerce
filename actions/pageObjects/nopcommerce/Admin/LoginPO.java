package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.admin.LoginPageUI;

public class LoginPO extends BasePage{
	private WebDriver driver;

	public LoginPO(WebDriver driver){
		this.driver = driver;
	}
	public void inputToUsernameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.EMAIl_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIl_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);	
	}

	public DashBoardPO clickToLoginButton() {
		waitForElementClickEnable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
	
	public DashBoardPO loginAsAdmin(String username, String password) {
		inputToUsernameTextbox(username);
		  inputToPasswordTextbox(password);		
		  return clickToLoginButton();
	}
}
