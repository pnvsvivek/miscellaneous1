package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowser {
	
	DesiredCapabilities capabilities;
	AppiumDriver<WebElement> driver;
	@BeforeMethod
	public void setUpAppium() throws MalformedURLException
	{
		String devicename = "ZX1D64B73P";
		String plotform = "Android";
		String url = "http://127.0.0.1:4723/wd/hub";
		
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, plotform);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");

		
		if(plotform.equalsIgnoreCase("android"))
		{
			driver = new AndroidDriver<WebElement>(new URL(url), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		if(plotform.equalsIgnoreCase("ios"))
		{
			driver = new IOSDriver<WebElement>(new URL(url), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}	
	}
	@AfterMethod
	public void tearDownAppium()
	{
		driver.quit();
	}
	
	@Test
	public void browserTest() throws Exception
	{
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("vivekananda");
		driver.findElement(By.id("tsbb")).click();
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
	}
	@Test
	public void lauch_hotstar()
	{
		driver.get("http://www.hotstar.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
