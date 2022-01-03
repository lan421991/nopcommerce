package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePageFactory{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="Email")
	private WebElement emailTextbox;
		
	@FindBy(id ="Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath ="//button[@class='button-1 login-button']")
	private WebElement loginButton;
		
	@FindBy(xpath ="//span[@id='Email-error']")
	private WebElement emailErrorMessage;
		
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement emailUnsuccessfullErrorMessage;
	
	public void clickToLoginButton() {
		waitForElementClickEnable(driver, loginButton);
		clickToElement(driver, loginButton);		
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, invalidEmail);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, emailUnsuccessfullErrorMessage);
		return getElementText(driver, emailUnsuccessfullErrorMessage);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);	
	}
	
}
