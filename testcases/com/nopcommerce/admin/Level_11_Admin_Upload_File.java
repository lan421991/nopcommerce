package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.Admin.DashBoardPO;
import pageObjects.nopcommerce.Admin.LoginPO;
import pageObjects.nopcommerce.Admin.PageGeneratorManager;
import pageObjects.nopcommerce.Admin.ProductDetailPO;
import pageObjects.nopcommerce.Admin.ProductSearchPO;

public class Level_11_Admin_Upload_File extends BaseTest{
	private WebDriver driver;
	String productName = "Adobe Photoshop CS4";
	String productAvatarImg = "Avatar.jpg";
	String productAvatarAlt = "Avatar Alt";
	String productAvatarTitle = "Avatar Title";
	String productAvatarOrder = "1";
	LoginPO loginPage;
	DashBoardPO dashBoardPage;
	ProductSearchPO productSearchPage;
	ProductDetailPO productDetailPage;
	@Parameters({"browser","enviromentName"})
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		//https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
	  driver = getBrowserDriver(browserName,enviromentName);
	  
	  loginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  
	  dashBoardPage = loginPage.loginAsAdmin("admin@yourstore.com", "admin");
	  
	  dashBoardPage.openSubMenuPage(driver,"Catalog","Products");
	  productSearchPage = PageGeneratorManager.getAdminProductSearchPage(driver);
	  
	  productSearchPage.enterToProductNameTextbox(productName);
	  
	  productSearchPage.clickToSearchButton();
	  
	  productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);
	}
	
	@Test
  public void Admin_01_Upload_File() {
	  productDetailPage.clickToExpandPanelByName("Pictures");
	  
	  productDetailPage.uploadFileByCardName(driver, "pictures", productAvatarImg);
	  
	  Assert.assertTrue(productDetailPage.isPictureUploadedSuccessByFileName(""));
	  
	  productDetailPage.inputToAltTextbox(productAvatarAlt);
	  productDetailPage.inputToTitleTextbox(productAvatarTitle);
	  productDetailPage.clickToUpDownDisplayedOrderTextbox("Increase");
	  
	  productDetailPage.clickToAddProductPictureButton();
	  
	  Assert.assertTrue(productDetailPage.isPictureImageDisplayed(productName,productAvatarOrder,productAvatarAlt,productAvatarTitle));
	  
	  productSearchPage = productDetailPage.clickToSaveButton();
	  
	  Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed("The product has been updated successfully."));
	  
	  productSearchPage.enterToProductNameTextbox(productName);
	  
	  productSearchPage.clickToSearchButton();
	  
	  Assert.assertTrue(productSearchPage.isPictureImageUpdated(productName,productName));
	  
	  productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);
	  
	  productDetailPage.clickToExpandPanelByName("Pictures");
	  
	  productDetailPage.clickToDeleteButtonAtPictureName(productAvatarTitle);
	  
	  Assert.assertTrue(productDetailPage.isMessageDisplayedInEmptyTable(driver,"productpictures"));
	  
	  productSearchPage = productDetailPage.clickToSaveButton();
	  
	  productSearchPage.enterToProductNameTextbox(productName);
	  
	  productSearchPage.clickToSearchButton();
	  
	  Assert.assertTrue(productSearchPage.isPictureImageUpdated("default-image",productName));

  	}
	
  public void Table_02_Input_To_Header_Textbox() {
  }
  
  public void Table_03_Action() {
  }

  @AfterClass
  public void afterClass() {
	 //driver.quit();
  }
}
