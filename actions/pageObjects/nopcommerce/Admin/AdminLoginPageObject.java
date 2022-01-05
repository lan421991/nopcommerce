package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageUIs.nopcommerce.admin.AdminLoginUIPageUI;
import pageUIs.nopcommerce.user.LoginPageUI;

public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver){
		this.driver = driver;
	}
	public void inputToUsernameTextbox(String username) {
		waitForElementVisible(driver, AdminLoginUIPageUI.EMAIl_TEXTBOX);
		sendkeyToElement(driver, AdminLoginUIPageUI.EMAIl_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginUIPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginUIPageUI.PASSWORD_TEXTBOX, password);	
	}

	public AdminDashBoardPageObject clickToLoginButton() {
		waitForElementClickEnable(driver, AdminLoginUIPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginUIPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
	
	public AdminDashBoardPageObject loginAsAdmin(String username, String password) {
		inputToUsernameTextbox(username);
		  inputToPasswordTextbox(password);		
		  return clickToLoginButton();
	}
}
