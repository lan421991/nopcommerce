package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ReportConfig.ExtentTestManager;
import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInforPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointPageObject;

public class Level_15_Register_Login_Log_Allure_Report extends BaseTest{

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
	  driver = getBrowserDriver(browserName,url);
	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  firstName = "Automation";
	  lastName = "FC";
	  Email = "fc" + genarateFakeNumber() + "@gmail.com";
	  validPassword = "123456";
  	}

  @Description("Register and Login")
  @Severity(SeverityLevel.NORMAL)
  @Test
  public void User_01_Register_Login() {
	  registerPage = homePage.openRegisterPage();
	  
	  registerPage.inputToFirstNameTextbox(firstName);	 
	  
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  registerPage.inputToEmailTextbox(Email);
	  
	  registerPage.inputToPasswordTextbox(validPassword);
	  
	  registerPage.inputToConfirmPasswordTextbox(validPassword);
	  
	  registerPage.clickToRegisterButton();
	  
	  verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	  
//	  homePage = registerPage.clickToLogoutLink();
//	  
//	  loginPage = homePage.openLoginPage();
//	  
//	  loginPage.inputEmailTextbox(Email);
//	  
//	  loginPage.inputToPasswordTextbox(validPassword);
//	  
//	  homePage = loginPage.clickToLoginButton();
//	  
//	  verifyTrue(homePage.isMyAccountLinkDisplayed());
//
//	  customerInforPage = homePage.openMyAccountPage();
//	  
//	  verifyFalse(customerInforPage.isCustomerInforDisplayed()); 
  	}
  
  @Description("Change Page")
  @Severity(SeverityLevel.NORMAL)
  @Test
  public void User_02_Dynamic_Page() {
	  addressPage = customerInforPage.openAddressPage(driver);
	  
	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	  
	  rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
	  
	  addressPage = rewardPointPage.openAddressPage(driver);
	  
	  rewardPointPage = addressPage.openRewardPointPage(driver);
	  
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	  
  }
  
  public int genarateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt();
  }
  
  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
  
	private WebDriver driver;
	private String firstName, lastName, Email, validPassword;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
}
