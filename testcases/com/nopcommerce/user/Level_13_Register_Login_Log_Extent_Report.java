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
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInforPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointPageObject;

public class Level_13_Register_Login_Log_Extent_Report extends BaseTest{

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		//ExtentTestManager.getTest().log(LogStatus.INFO, "Pre-Condition Step 01 : Open Browser '" + browserName + "' and navigate to" + url );
	  driver = getBrowserDriver(browserName,url);
	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  firstName = "Automation";
	  lastName = "FC";
	  Email = "fc" + genarateFakeNumber() + "@gmail.com";
	  validPassword = "123456";
  	}

  @Test
  public void User_01_Register_Login(Method method) {
	  ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 01: Open register page");
	  registerPage = homePage.openRegisterPage();
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 02: Input firstName Textbox");
	  registerPage.inputToFirstNameTextbox(firstName);	 
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 03: Input lastName Textbox");
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 04: Input Email Textbox" + Email);
	  registerPage.inputToEmailTextbox(Email);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 05: Input valid Password Textbox");
	  registerPage.inputToPasswordTextbox(validPassword);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 06: Input valid ConfirmPassword Textbox");
	  registerPage.inputToConfirmPasswordTextbox(validPassword);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 07: Click RegisterButton");
	  registerPage.clickToRegisterButton();
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 08: Verify Register Success");
	  verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 09: Click Log out");
	  homePage = registerPage.clickToLogoutLink();
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 10: Open Login Page");
	  loginPage = homePage.openLoginPage();
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 11: Input Email");
	  loginPage.inputEmailTextbox(Email);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 12: Input Password");
	  loginPage.inputToPasswordTextbox(validPassword);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 13: Click Login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 14: Vefify Login Success");
	  verifyTrue(homePage.isMyAccountLinkDisplayed());

	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 15: Open MyAccount Page");
	  customerInforPage = homePage.openMyAccountPage();
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 16: Verify CustomerInfor Displayed");
	  verifyFalse(customerInforPage.isCustomerInforDisplayed()); 
	  
	  ExtentTestManager.endTest();
  	}
  
  @Test
  public void User_02_Dynamic_Page(Method method) {
	  ExtentTestManager.startTest(method.getName(), "User_02_Dynamic_Page_To_System");
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Dynamic_Page - Step 01: Open Address Page");
	  addressPage = customerInforPage.openAddressPage(driver);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Dynamic_Page - Step 02: Open MyProductReview Page");
	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Dynamic_Page - Step 03: Open RewardPoint Page");
	  rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Dynamic_Page - Step 04: Open Address Page");
	  addressPage = rewardPointPage.openAddressPage(driver);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Dynamic_Page - Step 05: Open RewardPoint Page");
	  rewardPointPage = addressPage.openRewardPointPage(driver);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Dynamic_Page - Step 06: Open MyProductReview Page");
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	  
	  ExtentTestManager.endTest();
  }
  
  public int genarateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt();
  }
  
  @AfterClass
  public void afterClass() {
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Post-Condition - Close Browser");
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
