package pageObjects.facebook;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;

	public LoginPageObject(WebDriver driver){
		this.driver = driver;
	}

}
