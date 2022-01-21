package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManagerJquery;
import pageObjects.jquery.HomePageObject;

public class Level_10_DataTable extends BaseTest{
	private WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser","enviromentName"})
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
	  driver = getBrowserDriver(browserName,enviromentName);
	  homePage = PageGeneratorManagerJquery.getHomePage(driver);
	}
	
  public void Table_01_Paging() {
	  homePage.openPageByNumber("15");
	  Assert.assertTrue(homePage.isPageActivedByNumber("15"));
	  
	  homePage.openPageByNumber("5");
	  Assert.assertTrue(homePage.isPageActivedByNumber("5"));

	  homePage.openPageByNumber("20");
	  Assert.assertTrue(homePage.isPageActivedByNumber("20"));
  	}
	
  public void Table_02_Input_To_Header_Textbox() {
	  homePage.inputToHeaderTextboxByName("Females" ,"434000");
	  homePage.sleepInSecond(3);
	  homePage.refreshCurrentPAge(driver);
	  
	  homePage.inputToHeaderTextboxByName("Males" ,"45100");
	  homePage.sleepInSecond(3);
	  homePage.refreshCurrentPAge(driver);
	  
	  homePage.inputToHeaderTextboxByName("Country" ,"Argentina");
	  homePage.sleepInSecond(3);
	  homePage.refreshCurrentPAge(driver);
  }
  
  public void Table_03_Action() {
	  homePage.clickToIconByCountryName("Argentina","remove");
	  homePage.clickToIconByCountryName("Algeria","remove");
	  
	  homePage.clickToIconByCountryName("Aruba","edit");
	  homePage.refreshCurrentPAge(driver);
	  
	  homePage.clickToIconByCountryName("Antigua and Barbuda","edit");
	  homePage.refreshCurrentPAge(driver);
  }
  
  public void Table_04_Verify_Row_Values() {
	  homePage.inputToHeaderTextboxByName("Country" ,"Afghanistan");
	  Assert.assertTrue(homePage.isRowValueDisplayed("384187","Afghanistan","407124","791312")); 
	  homePage.sleepInSecond(3);
	  homePage.refreshCurrentPAge(driver);

	  homePage.inputToHeaderTextboxByName("Country" ,"Angola");
	  Assert.assertTrue(homePage.isRowValueDisplayed("276880","Angola","276472","553353")); 
  	}
  
  public void Table_05_Input_To_Row_Textbox() {
	  homePage.inputToTextboxByRowNumber("Artist", "1", "John");
	  homePage.sleepInSecond(3);

	  homePage.inputToTextboxByRowNumber("Year", "1", "1991");
	  homePage.sleepInSecond(3);
  }
	
	@Test
 public void Table_06_Click_Icon_At_Row() {
	  homePage.clickToIconByRowNumber("1","Insert Row Above");
	  homePage.sleepInSecond(3);
	  homePage.inputToTextboxByRowNumber("Artist", "1", "John");
	  homePage.sleepInSecond(3);
	  homePage.inputToTextboxByRowNumber("Artist", "2", "Anna");
	  homePage.sleepInSecond(3);
	  
	  homePage.clickToIconByRowNumber("2","Move Up");
	  homePage.sleepInSecond(3);
	  
	  homePage.clickToIconByRowNumber("2","Remove Current Row");
	  homePage.sleepInSecond(3);
	}
  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
}
