package takeScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	String projectLocation = System.getProperty("user.dir") + "/screenshotImg/";
	WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object testClass = result.getInstance();
		driver = ((takeScreenshotTestFailed) testClass).getWebDriver();
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(projectLocation + result.getName() + ".png");
		try {
			FileUtils.copyFile(ScrFile, DestFile);
		  } catch (IOException e) {
			e.printStackTrace();
		  }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
