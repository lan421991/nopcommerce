package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.nopcommerce.admin.ProductSearchPageUI;

public class ProductSearchPO extends BasePage{
	private WebDriver driver;

	public ProductSearchPO(WebDriver driver){
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitForElementClickEnable(driver, ProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_BUTTON);
	}

	public ProductDetailPO clickToEditButtonByProductName(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getAdminProductDetailPage(driver);
	}

	public boolean isSuccessMessageDisplayed(String messageName) {
		waitForAllElementVisible(driver, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, messageName);
		return isElementDisplayed(driver,  ProductSearchPageUI.SUCCESS_MESSAGE_NAME, messageName);
	}

	public boolean isPictureImageUpdated(String productImageName, String productName) {
		productImageName = productImageName.replace(" ", "-").toLowerCase();
		waitForAllElementVisible(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName, productImageName);
		return isElementDisplayed(driver,  ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName, productImageName);
	}
}
