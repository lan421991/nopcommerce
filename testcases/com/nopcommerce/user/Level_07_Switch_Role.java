package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserPageGeneratorManager;

public class Level_07_Switch_Role extends BaseTest{
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
	  driver = getBrowserDriver(browserName,url);
	  homePage = UserPageGeneratorManager.getHomePage(driver);
	  
	  emailAddress = "actomationfc@gmail.com";
	  password = "123456";
  	}
  
  @Test
  public void Role_01_Login() {
	  loginPage = homePage.openToLoginPage();
	  homePage = loginPage.loginAsUser(emailAddress, password);
	  Assert.assertTrue(homePage.isMyAccountLimkDisplayed());
  	}
  
  @Test
  public void Role_01_Admin() {

  	}
  
  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
  
	private WebDriver driver;
	private String emailAddress, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	
}
