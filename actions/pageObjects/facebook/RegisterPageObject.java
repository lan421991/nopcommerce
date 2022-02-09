package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class RegisterPageObject extends BasePage{
	WebDriver driver;
	
	public void RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
