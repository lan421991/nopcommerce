package com.facebook.register;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;



public class Element_Status_Knowledge {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	By reEnterEmail = By.cssSelector("input[name='reg_email_confirmation__']");
	@BeforeClass 
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://facebook.com/");
	}
	
	@Test
	public void TC_01_Timeout_Less_Than_Element_Display() {
		driver.findElement(By.cssSelector("a[data-testid=open-registration-form-button]")).click();
		driver.findElement(By.name("reg_email__")).sendKeys("lan@gmail.com");
		
		System.out.println("visible start time: " + getDateTimeNow());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reEnterEmail));
		System.out.println("visible end time: " + getDateTimeNow());
		
		System.out.println("check display start time: " + getDateTimeNow());
		Assert.assertTrue(driver.findElement(reEnterEmail).isDisplayed());
		System.out.println("check display end time: " + getDateTimeNow());

	}
	
	@Test
	public void TC_02_Timeout_Equal_Than_Element_Display() {
		
	}
	
	@Test
	public void TC_03_Timeout_More_Than_Element_Display() {

	}
	
	@AfterClass // Post-condition
	public void afterclass() {
		driver.quit();
	}
	
    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }
	
}