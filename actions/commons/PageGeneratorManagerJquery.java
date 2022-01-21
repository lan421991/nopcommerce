package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.jquery.HomePageObject;

public class PageGeneratorManagerJquery {
	private WebDriver driver;
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
