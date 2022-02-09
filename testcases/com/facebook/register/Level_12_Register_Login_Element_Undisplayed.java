package com.facebook.register;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInforPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointPageObject;

public class Level_12_Register_Login_Element_Undisplayed extends BaseTest{

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
	  driver = getBrowserDriver(browserName,url);
  	}
	
	@Test
	public void Login_01_Element_Displayed() {
		
	}
	
	@Test
	public void Login_01_Element_Undisplayed_In_DOM() {
		
	}

  @Test
  public void Login_01_Element_Undisplayed_Not_In_DOM() {
	  
  }
  
  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
  
	private WebDriver driver;
}