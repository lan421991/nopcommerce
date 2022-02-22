package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;


public class Level_12_Register_Login_Element_Undisplayed extends BaseTest{
	private WebDriver driver;
	String emailAddress, password;
	RegisterPageObject registerPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
	  driver = getBrowserDriver(browserName,url);
	  registerPage = PageGeneratorManager.getRegisterPage(driver);
  	}
	
	@Test
	public void Register_01_Assert() {
		//fail lan 1
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		
		registerPage.inputToEmailTextbox("hoa@gmail.com");
		
		//fail lan 2
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		registerPage.inputToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		//fail lan 3
		verifyTrue(registerPage.isLoginButtonDisplayed());
		verifyTrue(registerPage.isLoginButtonUnDisplayed());
	}
  
  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
}