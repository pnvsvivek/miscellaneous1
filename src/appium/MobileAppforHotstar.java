package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobileAppforHotstar {

	
	DesiredCapabilities capabilities;
	AppiumDriver<WebElement> driver;
	@BeforeMethod
	public void setUpAppium() throws MalformedURLException
	{
		String devicename = "ZX1D64B73P";
		String plotform = "Android";
		String packagename = "in.startv.hotstar";
		String activityname = "in.startv.hotstar.activities.splash.SplashActivity";
		String url = "http://127.0.0.1:4723/wd/hub";	
		
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", devicename);
		capabilities.setCapability("plotformName", plotform);
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		capabilities.setCapability("appWaitActivity", activityname);
		capabilities.setCapability("noReset", true);

		
		if(plotform.equalsIgnoreCase("android"))
		{
			driver = new AndroidDriver<WebElement>(new URL(url),capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		if(plotform.equalsIgnoreCase("ios"))
		{
			driver = new IOSDriver<WebElement>(new URL(url),capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}		
	}
	@AfterMethod
	public void tearDownAppium()
	{
		driver.closeApp();
	}
	
	@Test
	public void Hotstar_Navigation() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'SPORTS']")).click();
		driver.findElement(By.id("in.startv.hotstar:id/card_title")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Vivo IPL 2017']")).click();			
	}	
}
