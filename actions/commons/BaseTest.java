package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	// protected WebDriver getBrowserDriverID(String browserName) {
	// return getBrowserDriver(browserName);
	// }

	protected WebDriver getBrowserDriver(String browserName, String enviromentName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}else if(browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}else if(browserList == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("95.0.4638.69").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\browser.exe");
			driver = new ChromeDriver(options);
		}else if(browserList == BrowserList.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("96.0.4664.35").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		}else if(browserList == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}else if(browserList == BrowserList.IE) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}else if(browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			throw new BrowserNotSupport(browserName);
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(getEnviromentUrl(enviromentName));
		return driver;
	}

	private String getEnviromentUrl(String serverName) {
		String envUrl = null;
		EnviromentList enviroment = EnviromentList.valueOf(serverName.toUpperCase());

		if (enviroment == EnviromentList.DEV) {
			envUrl = "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/";
		} else if (enviroment == EnviromentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
		} else if (enviroment == EnviromentList.STAGING) {
			envUrl = "https://www.facebook.com/reg/";
		} else if (enviroment == EnviromentList.PRODUCTION) {
			envUrl = "https://production.nopcommerce.com/";
		}
		return envUrl;
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);//lấy ra tất cả các lỗi
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			//get lỗi ra và add và report
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
}
