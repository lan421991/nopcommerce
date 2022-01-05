package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageUIs.nopcommerce.admin.AdminDashBoardUIPageUI;
import pageUIs.nopcommerce.admin.AdminLoginUIPageUI;
import pageUIs.nopcommerce.user.HomePageUI;
import pageUIs.nopcommerce.user.LoginPageUI;

public class AdminDashBoardPageObject extends BasePage{
	private WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean isDashBoardDisplayed() {
		waitForElementVisible(driver, AdminDashBoardUIPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashBoardUIPageUI.DASHBOARD_HEADER);
	}

}
