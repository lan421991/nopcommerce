package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.Admin.DashBoardPO;
import pageObjects.nopcommerce.Admin.LoginPO;
import pageObjects.nopcommerce.user.UserCustomerInforPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

public class Level_07_Switch_Role extends BaseTest{
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
	  driver = getBrowserDriver(browserName,url);
  	}
  
  @Test
  public void Role_01_Login() {
  	}
  
  @Test
  public void Role_02_Admin() {
  	}
  
  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
  
	private WebDriver driver;
}
