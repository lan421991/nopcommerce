package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.RegisterPageObject;

public class Level_03_Page_Object_Register{
	  
		private WebDriver driver;
		private String firstName, lastName, emailAddress, password;
		private HomePageObject homePage;
		private RegisterPageObject registerPage;
		private String projectPath = System.getProperty("user.dir");
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  
	  driver.get("https://demo.nopcommerce.com/");
	  homePage = new HomePageObject(driver);
	  
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  firstName = "Automation";
	  lastName = "FC";
	  emailAddress = "fc" + genarateFakeNumber() + "@gmail.com";
	  password = "123456";
  }

  //@Test
  public void Register_01_Empty_Data() {
	  System.out.println("Register_01 - Step 01 : Click register link"); 
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);

	  System.out.println("Register_01 - Step 02 : Click register button"); 
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required."); 
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required."); 
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required."); 
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required."); 
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required."); 
  	}
  
  //@Test
  public void Register_02_Invalid_Email() {
	  System.out.println("Register_02 - Step 01 : Click register link"); 
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);

	  System.out.println("Register_02 - Step 02: Input to required fields"); 
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox("123@456#%*");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register_02 - Step 03 : Click register button"); 
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_02 - Step 04: Verify error message displayed"); 
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email"); 
  }
  
  @Test
  public void Register_03_Success() {
	  System.out.println("Register_03 - Step 01 : Click register link"); 
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);

	  System.out.println("Register_03 - Step 02: Input to required fields"); 
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register_03 - Step 03 : Click register button"); 
	  registerPage.clickToRegisterButton();
	  
	  
	  System.out.println("Register_03 - Step 04: Verify success message displayed"); 
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

	  System.out.println("Register_03 - Step 05 : Click to logout link"); 
	  registerPage.clickToLogoutLink();
	  homePage = new HomePageObject(driver);
	  System.out.println(emailAddress); 

  }
  
  @Test
  public void Register_04_Exiting_Email() {
	  System.out.println("Register_04 - Step 01 : Click register link"); 
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);

	  System.out.println("Register_04 - Step 02: Input to required fields"); 
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register_04 - Step 03 : Click register button"); 
	  registerPage.clickToRegisterButton();
	  
	  
	  System.out.println("Register_04 - Step 04: Verify error message displayed"); 
	  Assert.assertEquals(registerPage.getErrorExitingEmailMessage(),"The specified email already exists");
	  
  }
  
  @Test
  public void Register_05_Password_Less_Than_6_Chars() {
	  System.out.println("Register_05 - Step 01 : Click register link"); 
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);

	  System.out.println("Register_05 - Step 02: Input to required fields"); 
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("123");
	  registerPage.inputToConfirmPasswordTextbox("123");
	  
	  System.out.println("Register_05 - Step 03 : Click register button"); 
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_05 - Step 04: Verify error message displayed"); 
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
  }
  
  @Test
  public void Register_06_Invalid_Confirm_Password() {
	  System.out.println("Register_06 - Step 01 : Click register link"); 
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);

	  System.out.println("Register_06 - Step 02: Input to required fields"); 
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox("123111");
	  
	  System.out.println("Register_06 - Step 03 : Click register button"); 
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_06 - Step 04: Verify error message displayed"); 
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
    }
  
  public int genarateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt();
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }


}
