package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInforPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRewardPointPageObject;
import pageUIs.nopcommerce.user.BasePageUI;
import pageUIs.nopcommerce.user.LoginPageUI;

public class BasePage {
// chứa các hàm dùng dung cho 1 page của application
	public static BasePage getBasePageObject() {
		return new BasePage();
	}
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
		
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
		
	public void refreshCurrentPAge(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
		
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	public void switchToWindowByID(WebDriver driver,String windowPageID) {
			Set<String> allWindows = driver.getWindowHandles();	
			for (String window : allWindows) {
				if(!window.equals(windowPageID)){
					driver.switchTo().window(window);
				}
			}
		}
		
	public void switchToWindowByTitle(WebDriver driver,String expectedPageTitle) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String window : allWindows) {
				driver.switchTo().window(window);
				String actualPageTitle = driver.getTitle().trim();
				if(actualPageTitle.equals(expectedPageTitle)) {
					break;
				}
			}
		}
		
	public void closeAllWindowWithoutParent(WebDriver driver,String parentPageID) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String window : allWindows) {
				if(!window.equals(parentPageID)) {
					driver.switchTo().window(window);
					driver.close();
				}
			}
			driver.switchTo().window(parentPageID);
		}
	
	private By getByLocator(String locatorType) {
		By by = null;
		if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator Type is not support");
		}
		return by;
	}
	
	private WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}	
	
	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver,locatorType).getText() ;
	}	
	
	private List<WebElement> getListElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
	
	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver,locatorType).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver,locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
		
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType,String texValue) {
		Select select = new Select(getWebElement(driver,locatorType));
		select.selectByValue(texValue);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver,locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver,locatorType));
		return select.isMultiple();
	}
	
	
	public void selectItemInDropdown(WebDriver driver,String parentXpath, String childXpath, String expectedText) {
		getWebElement(driver,parentXpath).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems= explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		for (WebElement item : allItems) {
			if(item.getText().trim().equals(expectedText)) {
				if(item.isDisplayed()) {
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(1);
					item.click();
					break;
				}
			}
		}
		
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver,locatorType).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver,locatorType).getCssValue(propertyName);		
	}

	public String convertRgbaToHex(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElemnentSize(WebDriver driver, String locatorType) {
		return getListElement(driver, locatorType).size();
	}

	public void checkToCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}
	
	public boolean isElemnentEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	

	public boolean isElemnentSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	
	public void switchToFramIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void hightlightElement(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element =getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}
	
	public void clickToElementByJS(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElementOnTop(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void scrollToElementOnDown(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver,String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public String getElementValidationMessage(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		}
		return false;
	}
	
	public void waitForElementVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForAllElementVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForElementInvisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locatorType)));
	}
	
	public void waitForElementClickEnable(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElementClickEnable(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver,BasePageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickEnable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver,BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickEnable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver,BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickEnable(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver,BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickEnable(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver,BasePageUI.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickEnable(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver,BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	private long longTimeout = 30;
}
