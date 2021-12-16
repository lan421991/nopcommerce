package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login {
	//biến toàn cục
	String homePageUrl= "bien toan cuc";
	
  @BeforeClass
  public void beforeClass() {
  }

  @Test
  public void TC_01() {
		String homePageUrl= "bien cuc bo";
		System.out.println(homePageUrl); 
		
		//block code
		if(3<5) {
			String homePageTitle ="bien if";
			System.out.println(homePageTitle); 
		}
  }
  
  @Test
  public void TC_02() {
		System.out.println(homePageUrl); 

  }
  
  @AfterClass
  public void afterClass() {
  }

}
