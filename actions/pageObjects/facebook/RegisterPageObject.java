package pageObjects.facebook;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_CONFIRM_TEXTBOX);
	}

	public void inputToEmailTextbox(String emailTextbox) {
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailTextbox);
	}

	public boolean isLoginButtonDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	public boolean isLoginButtonUnDisplayed() {
		return isElementUnDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
		//5s
	}

}
