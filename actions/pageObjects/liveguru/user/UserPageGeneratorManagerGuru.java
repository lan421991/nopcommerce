package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

public class UserPageGeneratorManagerGuru {
	private WebDriver driver;
	
	public static UserHomePageObjectGuru getHomePage(WebDriver driver) {
		return new UserHomePageObjectGuru(driver);
	}
	
	public static UserLoginPageObjectGuru getLoginPage(WebDriver driver) {
		return new UserLoginPageObjectGuru(driver);
	}
	
	public static UserRegisterPageObjectGuru getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObjectGuru(driver);
	}

	public static UserMyDashboardPageObjectGuru getMyDashboardPage(WebDriver driver) {
		return new UserMyDashboardPageObjectGuru(driver);
	}
}
