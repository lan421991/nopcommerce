package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopcommerce.user.HomePageUI;

public class HomePageObject extends BasePageFactory{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	public void clickToRegisterLink() {
		waitForElementClickEnable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clicktoLoginLink() {
		waitForElementClickEnable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}
}
