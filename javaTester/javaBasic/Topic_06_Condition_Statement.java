package javaBasic;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	
	public void TC_01() {
		// TODO Auto-generated method stub
		boolean status = 5>3;
		System.out.println(status); 
		
		//Hàm if nhận vào 1 điều kiện đúng
		//Kiểm tra duy nhất 1 điều kiện
		//Nếu điều kiện này đúng sẽ action
		if(status) {
			System.out.println("Go to if"); 
		}
		
		//Gán (assign)
		int studentNumber = 10;
		
		// == so sánh
		status = (studentNumber == 10);
		System.out.println(status); 
		
		status = (studentNumber != 10);
		System.out.println(status); 
		
		WebDriver driver = new FirefoxDriver();

		
		//Element luôn có trong DOM dù popup hiển thị hay không
		WebElement salePopup = driver.findElement(By.id(""));
		if(salePopup.isDisplayed()) {
			
		}
		
		// Element k có trong DOM khi popup k hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		if(salePopups.size() >0 && salePopups.get(0).isDisplayed()) {
			
		}
	}
	
	
	public void TC_02_If_Else() {
		//System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println(driver.toString());  
			
		if(driver.toString().contains("internet explorer")){
			System.out.println("Click by Javascript Executor"); 
		}else {
			System.out.println("Click by Selenium"); 

		}
	}
	
	//@Parameters("browser")
	//@Test
	public void TC_03_If_Else_If_Else(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else throw new RuntimeException("Vui lòng input correct brower name");
		
		System.out.println(browserName); 
		System.out.println(driver.toString()); 
		
		driver.quit();
	}
	@Test
	public void TC_04_If_Else_If_Else() {
		String pageName = "Login";
		
		if(pageName.equals("Login")) {
			
		}else if(pageName.equals("Register")) {
			
		}else if(pageName.equals("New Customer")) {
			
		}else {
			
		}
		
		int age =20;
		String access = (age <18) ? "You can not access" : "Welcome to our system";
		System.out.println(access); 
	}
	
	
}
