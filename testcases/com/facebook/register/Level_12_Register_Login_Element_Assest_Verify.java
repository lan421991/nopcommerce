package com.facebook.register;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;


public class Level_12_Register_Login_Element_Assest_Verify extends BaseTest{
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
	public void Register_01_Element_Displayed() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		registerPage.inputToEmailTextbox("hoa@gmail.com");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
	}
	
	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
		registerPage.inputToEmailTextbox("");
		registerPage.sleepInSecond(3);
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
	}

	@Test
	public void Register_03_Element_Undisplayed_Not_In_DOM() {
		//undisplayed : invisible on UI and not in DOM
		//isdisplayes : false(try-catch)
		//wait maximum implicit
		
		//khẳng định
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
	}
  @Test
  
  public void Register_04_Element_Undisplayed_Not_In_DOM() {
		//undisplayed : invisible on UI and not in DOM
		//find elements
		//overridetimeout
	  
		//phu dinh
	  Assert.assertTrue(registerPage.isLoginButtonUnDisplayed());
  }
  
  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
}