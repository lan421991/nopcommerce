package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.nopcommerce.admin.DashBoardPageUI;

public class DashBoardPO extends BasePage{
	private WebDriver driver;

	public DashBoardPO(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean isDashBoardDisplayed() {
		waitForElementVisible(driver, DashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, DashBoardPageUI.DASHBOARD_HEADER);
	}

}
