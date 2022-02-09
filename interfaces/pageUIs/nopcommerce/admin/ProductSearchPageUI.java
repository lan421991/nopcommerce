package pageUIs.nopcommerce.admin;

public class ProductSearchPageUI {
	public static final String PRODUCT_NAME_TEXTBOX = "id=SearchProductName";
	public static final String SEARCH_BUTTON = "id=search-products";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME = "xpath=//td[text()='%s']/following-sibling::td/a[contains(text(),'Edit')]";
	public static final String SUCCESS_MESSAGE_NAME = "xpath=//div[@class='alert alert-success alert-dismissable' and contains(string(),'%s')]";
	public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME = "xpath=//td[text()='%s']/preceding-sibling::td/img[contains(@src,'%s')]";
}
