package javaBasic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	
	@Parameters("browser")
	@Test
	public void TC_03(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println(browserName); 
		driver.quit();
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		
		//Nếu không break thì chạy qua tất cả các case
		// chỉ sử dụng int, string
		// lọc trùng
		// không dùng được toán tử <,>,...
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			new RuntimeException("Please input corect the browser name!");
			break;
		}
		return driver;
	}

	
}
