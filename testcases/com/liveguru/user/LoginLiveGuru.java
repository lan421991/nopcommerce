package com.liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.RegisterPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;

public class LoginLiveGuru extends BaseTest {
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		fisrtName = "Automation";
		middleName = "and";
		lastName = "Testing";
		email = "abc" + genarateFakeNumber() + "@gmail.net";
		password = "123456";
		fullName = fisrtName + " " + middleName+ " " + lastName;
	}
	
	@Test
	public void TC_01_Register_success() {
		homePage.clickToAccountLink();
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccount();
		registerPage.inputFisrtNameTextbox(fisrtName);
		registerPage.inputMiddleNameTextbox(middleName);
		registerPage.inputLastNameTextbox(lastName);
		registerPage.inputEmailAddressTextbox(email);
		registerPage.inputPasswordTextbox(password);
		registerPage.inputConfirmPasswordTextbox(password);
		myDashboardPage = registerPage.clickToRegisterLiveguruButton();
		Assert.assertTrue(myDashboardPage.getHelloMessage().contains(fullName));
		Assert.assertTrue(myDashboardPage.getFullNameMessage().contains(fullName));
		Assert.assertTrue(myDashboardPage.getFullNameMessage().contains(email));
		myDashboardPage.clickToAccount();
		homePage = myDashboardPage.clickToLogoutLink();
	}
	
	@Test
	public void TC_02_Login_success() {
		homePage.clickToAccountLink();
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailLiveGuruTextbox(email);
		loginPage.inputToPasswordLiveguruTextbox(password);
		myDashboardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(myDashboardPage.getHelloMessage().contains(fullName));
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
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyDashboardPageObject myDashboardPage;
	private String fisrtName, middleName, lastName, email, password, fullName;
}
