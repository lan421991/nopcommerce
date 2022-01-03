package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.MyDasgboardUI;

public class MyDashboardPageObject extends BasePage{
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getHelloMessage() {
		waitForElementVisible(driver,MyDasgboardUI.HELLO_MESSAGE);
		return getElementText(driver, MyDasgboardUI.HELLO_MESSAGE);
	}

	public String getFullNameMessage() {
		waitForElementVisible(driver,MyDasgboardUI.FULLNAME_MESSAGE);
		return getElementText(driver, MyDasgboardUI.FULLNAME_MESSAGE);
	}

	public void clickToAccount() {
		waitForElementClickEnable(driver, MyDasgboardUI.ACCOUNT_LINK);
		clickToElement(driver, MyDasgboardUI.ACCOUNT_LINK);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickEnable(driver, MyDasgboardUI.LOGOUT_LINK);
		clickToElement(driver, MyDasgboardUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
//	String contactInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div//following-sibling::div[@class='box-content']/p")).getText();
//	Assert.assertTrue(contactInformation.contains(fullName));
//	Assert.assertTrue(contactInformation.contains(email));

}
