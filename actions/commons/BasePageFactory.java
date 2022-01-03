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

public class BasePageFactory {
	private long longTimeout = 30;

	public static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
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
	
	public void waitForElementVisible(WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementVisible(WebDriver driver,List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	

	public void waitForElementInvisible(WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForAllElementInvisible(WebDriver driver,List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	

	public void waitForElementClickEnable(WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}
	
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText() ;
	}	
	
}
