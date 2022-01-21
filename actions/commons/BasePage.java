package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
	private String getDynamicXpath(String locatorType, String...dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[])dynamicValues);
			}
		return locatorType;
	}
	
	private WebElement getWebElement(WebDriver driver, String LocatorType) {
		return driver.findElement(getByLocator(LocatorType));
	}	
	
	private List<WebElement> getListElement(WebDriver driver, String LocatorType) {
		return driver.findElements(getByLocator(LocatorType));
	}
	
	public void clickToElement(WebDriver driver, String LocatorType) {
		getWebElement(driver,LocatorType).click();
	}
	
	public void clickToElement(WebDriver driver, String LocatorType, String...dynamicValues) {
		getWebElement(driver,getDynamicXpath(LocatorType,dynamicValues)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String LocatorType, String textValue) {
		WebElement element = getWebElement(driver,LocatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void sendkeyToElement(WebDriver driver, String LocatorType, String textValue, String...dynamicValues) {
		WebElement element = getWebElement(driver,getDynamicXpath(LocatorType,dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String LocatorType,String texValue) {
		Select select = new Select(getWebElement(driver,LocatorType));
		select.selectByValue(texValue);
	}
		
	public void selectItemInDefaultDropdown(WebDriver driver, String LocatorType,String texValue, String...dynamicValues) {
		Select select = new Select(getWebElement(driver,getDynamicXpath(LocatorType,dynamicValues)));
		select.selectByValue(texValue);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String LocatorType) {
		Select select = new Select(getWebElement(driver,LocatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String LocatorType) {
		Select select = new Select(getWebElement(driver,LocatorType));
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

	public String getElementText(WebDriver driver, String LocatorType) {
		return getWebElement(driver,LocatorType).getText() ;
	}
	
	public String getElementText(WebDriver driver, String LocatorType, String...dynamicValues) {
		return getWebElement(driver,getDynamicXpath(LocatorType,dynamicValues)).getText() ;
	}
	
	public String getElementAttribute(WebDriver driver, String LocatorType, String attributeName) {
		return getWebElement(driver,LocatorType).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String LocatorType,String attributeName, String...dynamicValues) {
		return getWebElement(driver,getDynamicXpath(LocatorType,dynamicValues)).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String LocatorType, String propertyName) {
		return getWebElement(driver,LocatorType).getCssValue(propertyName);		
	}

	public String convertRgbaToHex(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElemnentSize(WebDriver driver, String LocatorType) {
		return getListElement(driver, LocatorType).size();
	}

	public int getElemnentSize(WebDriver driver, String LocatorType, String...dynamicValues) {
		return getListElement(driver, getDynamicXpath(LocatorType,dynamicValues)).size();
	}

	public void checkToCheckboxRadio(WebDriver driver, String LocatorType) {
		WebElement element = getWebElement(driver, LocatorType);
		if(!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String LocatorType) {
		WebElement element = getWebElement(driver, LocatorType);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String LocatorType, String...dynamicValues) {
		return getWebElement(driver, getDynamicXpath(LocatorType,dynamicValues)).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String LocatorType) {
		return getWebElement(driver, LocatorType).isDisplayed();
	}
	
	
	public boolean isElemnentEnable(WebDriver driver, String LocatorType) {
		return getWebElement(driver, LocatorType).isEnabled();
	}
	

	public boolean isElemnentSelected(WebDriver driver, String LocatorType) {
		return getWebElement(driver, LocatorType).isSelected();
	}
	
	public void switchToFramIframe(WebDriver driver, String LocatorType) {
		driver.switchTo().frame(getWebElement(driver, LocatorType));
	}
	
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String LocatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, LocatorType)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String LocatorType) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, LocatorType)).perform();
	}
	
	public void dragAndDropElement(WebDriver driver, String sourceLocatorType, String targetLocatorType) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocatorType),getWebElement(driver, targetLocatorType)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String LocatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, LocatorType),key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String LocatorType, Keys key, String...dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(LocatorType,dynamicValues)),key).perform();
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void hightlightElement(WebDriver driver,String LocatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, LocatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}
	
	public void clickToElementByJS(WebDriver driver,String LocatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, LocatorType));
	}

	public void scrollToElementOnTop(WebDriver driver,String LocatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, LocatorType));
	}

	public void scrollToElementOnDown(WebDriver driver,String LocatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, LocatorType));
	}

	public void removeAttributeInDOM(WebDriver driver,String LocatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, LocatorType));
	}

	public String getElementValidationMessage(WebDriver driver,String LocatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, LocatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String LocatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, LocatorType));
		if (status) {
			return true;
		}
		return false;
	}
	
	public void waitForElementVisible(WebDriver driver,String LocatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(LocatorType)));
	}
	
	
	public void waitForElementVisible(WebDriver driver,String LocatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(LocatorType,dynamicValues))));
	}
	
	public void waitForAllElementVisible(WebDriver driver,String LocatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(LocatorType)));
	}
	
	
	public void waitForAllElementVisible(WebDriver driver,String LocatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(LocatorType,dynamicValues))));
	}
	

	public void waitForElementInvisible(WebDriver driver,String LocatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(LocatorType)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver,String LocatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, LocatorType)));
	}
	
	public void waitForElementClickEnable(WebDriver driver,String LocatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(LocatorType)));
	}	

	public void waitForElementClickEnable(WebDriver driver,String LocatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(LocatorType,dynamicValues))));
	}	
	//tối ưu ở switch page
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
	
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickEnable(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInforPage(driver);
		default:
			throw new RuntimeException("Invalid at My Account Area.");
		}
	}
	
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForElementClickEnable(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
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
	
	private long longTimeout = GlobalConstants.LONG_TIME_OUT;
}
