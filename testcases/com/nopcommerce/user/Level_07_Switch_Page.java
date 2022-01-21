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

public class Level_07_Switch_Page extends BaseTest{

	@Parameters({"browser","enviromentName"})
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
	  driver = getBrowserDriver(browserName,enviromentName);
	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  firstName = "Automation";
	  lastName = "FC";
	  Email = "fc" + genarateFakeNumber() + "@gmail.com";
	  System.out.println(Email); 
	  validPassword = "123456";
  	}

  @Test
  public void User_01_Register() {
	  registerPage = homePage.openRegisterPage();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(Email);
	  registerPage.inputToPasswordTextbox(validPassword);
	  registerPage.inputToConfirmPasswordTextbox(validPassword);
	  registerPage.clickToRegisterButton();
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	  homePage = registerPage.clickToLogoutLink();
  	}
  
  @Test
  public void User_02_Login() {
	  loginPage = homePage.openLoginPage();
	  loginPage.inputEmailTextbox(Email);
	  loginPage.inputToPasswordTextbox(validPassword);
	  homePage = loginPage.clickToLoginButton();
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
  	}
  
  @Test
  public void User_03_Customer_Infor() {
	  customerInforPage = homePage.openMyAccountPage();
	  Assert.assertTrue(customerInforPage.isCustomerInforDisplayed()); 
  	}
  
  @Test
  public void User_04_Switch_Page() {
	  addressPage = customerInforPage.openAddressPage(driver);
	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	  rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
	  addressPage = rewardPointPage.openAddressPage(driver);
	  rewardPointPage = addressPage.openRewardPointPage(driver);
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	  addressPage = myProductReviewPage.openAddressPage(driver);
	  customerInforPage = addressPage.openCustomerInforPage(driver);
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
