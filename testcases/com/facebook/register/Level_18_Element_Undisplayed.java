package com.facebook.register;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_18_Element_Undisplayed extends BaseTest{
		private WebDriver driver;

  @Parameters({"browser","url"})
  @BeforeClass
  public void beforeClass(String browserName, String url) {
	  driver = getBrowserDriver(browserName, url);
  }
  
  @Test
  public void TC_01_Visible() {
	  
  }
  
  @Test
  public void TC_02_Invisible_In_DOM() {
	  
  }

  @Test
  public void TC_02_Invisible_Not_In_DOM() {
  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }


}
