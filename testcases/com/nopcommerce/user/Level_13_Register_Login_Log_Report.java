package com.nopcommerce.user;

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

public class Level_13_Register_Login_Log_Report extends BaseTest{

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition Step 01 : Open Browser '" + browserName + "' and navigate to" + url );
	  driver = getBrowserDriver(browserName,url);
	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  firstName = "Automation";
	  lastName = "FC";
	  Email = "fc" + genarateFakeNumber() + "@gmail.com";
	  System.out.println(Email); 
	  validPassword = "123456";
  	}

  @Test
  public void User_01_Register_Login() {
	  log.info("User_01_Register - Step 01: Open register page");
	  registerPage = homePage.openRegisterPage();
	  
	  log.info("User_01_Register - Step 02: Input firstName Textbox");
	  registerPage.inputToFirstNameTextbox(firstName);	 
	  
	  log.info("User_01_Register - Step 03: Input lastName Textbox");
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  log.info("User_01_Register - Step 04: Input Email Textbox");
	  registerPage.inputToEmailTextbox(Email);
	  
	  log.info("User_01_Register - Step 05: Input valid Password Textbox");
	  registerPage.inputToPasswordTextbox(validPassword);
	  
	  log.info("User_01_Register - Step 06: Input valid ConfirmPassword Textbox");
	  registerPage.inputToConfirmPasswordTextbox(validPassword);
	  
	  log.info("User_01_Register - Step 07: Click RegisterButton");
	  registerPage.clickToRegisterButton();
	  
	  log.info("User_01_Register - Step 08: Verify Register Success");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	  
	  log.info("User_01_Register - Step 09: Click Log out");
	  homePage = registerPage.clickToLogoutLink();
	  
	  log.info("User_01_Register - Step 10: Open Login Page");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("User_01_Register - Step 11: Input Email");
	  loginPage.inputEmailTextbox(Email);
	  
	  log.info("User_01_Register - Step 12: Input Password");
	  loginPage.inputToPasswordTextbox(validPassword);
	  
	  log.info("User_01_Register - Step 13: Click Login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("User_01_Register - Step 14: Vefify Login Success");
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	  log.info("User_01_Register - Step 15: Open MyAccount Page");
	  customerInforPage = homePage.openMyAccountPage();
	  
	  log.info("User_01_Register - Step 16: Verify CustomerInfor Displayed");
	  Assert.assertTrue(customerInforPage.isCustomerInforDisplayed()); 
  	}
  
  @Test
  public void User_02_Dynamic_Page() {
	  log.info("User_02_Register - Step 01: Open Address Page");
	  addressPage = customerInforPage.openAddressPage(driver);
	  
	  log.info("User_02_Register - Step 02: Open MyProductReview Page");
	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	  
	  log.info("User_02_Register - Step 03: Open RewardPoint Page");
	  rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
	  
	  log.info("User_02_Register - Step 04: Open Address Page");
	  addressPage = rewardPointPage.openAddressPage(driver);
	  
	  log.info("User_02_Register - Step 05: Open RewardPoint Page");
	  rewardPointPage = addressPage.openRewardPointPage(driver);
	  
	  log.info("User_02_Register - Step 06: Open MyProductReview Page");
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
  }
  
  public int genarateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt();
  }
  
  @AfterClass
  public void afterClass() {
	  log.info("Post-Condition - Close Browser");
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
