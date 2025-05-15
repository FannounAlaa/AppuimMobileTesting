package AppuimMobileTesting.AppuimMobileTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppTest {
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@BeforeTest
	public void Setup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TestDevice");

		File MyApplicationCalculator = new File("src/test/java/MyApplication/calculator.apk");

		caps.setCapability(MobileCapabilityType.APP, MyApplicationCalculator.getAbsolutePath());

	}
	
	@BeforeMethod
	public void BeforeEachTest() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	@Test(priority = 1, enabled = false)
	public void AddTwoDigits() throws MalformedURLException {
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		
		String ActualValue = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		
		
		Assert.assertEquals(ActualValue, "15");

	}
	
	@Test(priority = 2)
	public void ClickOnNumbersOnly() throws IOException {
		
		Date date = new Date();
		
		String FileName = date.toString().replace(":", "-");
		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		
		for (int i = 0; i < AllButtons.size(); i++) {
			if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit")) {
				AllButtons.get(i).click();
			}
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File screenShot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File ("src/test/java/ScreenShots/"+FileName+".jpg"));
	}
	
	@Test (priority = 3)
	public void DivideByZero() {
	    driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
	    driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
	    driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
	    driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

	    String actualResult = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
	    
	    Assert.assertEquals(actualResult, "Can't divide by 0");
	}

	@AfterTest
	public void DoWork() {

	}
}
