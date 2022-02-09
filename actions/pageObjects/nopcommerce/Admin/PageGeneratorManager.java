package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private WebDriver driver;
	
	public static LoginPO getAdminLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static DashBoardPO getAdminDashBoardPage(WebDriver driver) {
		return new DashBoardPO(driver);
	}
	
	public static ProductDetailPO getAdminProductDetailPage(WebDriver driver) {
		return new ProductDetailPO(driver);
	}
	
	public static ProductSearchPO getAdminProductSearchPage(WebDriver driver) {
		return new ProductSearchPO(driver);
	}
}
