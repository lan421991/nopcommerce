package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	
	 int iNumber = 123;
	 long lNumber = 65000;
	 float fNumber = 15.98f;
	 double dNumber = 15.98d;
	 char cChar = '1';
	 boolean bStatus = false;
	 
	 //kiểu tham chiếu
	 //String
	 String address ="Hồ Chí Minh";
	 
	//Array
	 String[] studentAddress = {address, "Hà Nôi", "Đà Nẵng"};
	 Integer[] studentNumber = {15, 20, 50};
	 
	 //class
	 Topic_02_Data_Type topic;
	 
	 //Interface
	 WebDriver driver;
	 
	 //Object
	 Object aObject;
	 
	 //collection
	 //List/Set/Queue/Map
	 List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	 Set<String> allWindows = driver.getWindowHandles();
	 List<String> productName = new ArrayList<String>();
	 
	public static void main(String[] args) {
		
	}
}
