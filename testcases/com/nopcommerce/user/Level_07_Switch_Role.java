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
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  userEmailAddress = "fc-265705590@gmail.com";
	  userPassword = "123456";
	  adminUsername = "admin@yourstore.com";
	  adminPassword = "admin";
  	}
  
  @Test
  public void Role_01_Login() {
	  userLoginPage = userHomePage.openLoginPage();
	  
	  userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
	  Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	  
	  userCustomerInforPage = userHomePage.openMyAccountPage();
	  userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);
	  
	  userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_LINK);
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  
	  adminDashBoardPage = adminLoginPage.loginAsAdmin(adminUsername,adminPassword);
	  Assert.assertTrue(adminDashBoardPage.isDashBoardDisplayed());
	  
	  adminLoginPage = adminDashBoardPage.clickToLogoutLinkAtAdminPage(driver);
  	}
  
  @Test
  public void Role_02_Admin() {
	  adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_LINK);
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
  	}
  
  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
  
	private WebDriver driver;
	private String userEmailAddress, userPassword, adminUsername, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private LoginPO adminLoginPage;
	private DashBoardPO adminDashBoardPage;
}
