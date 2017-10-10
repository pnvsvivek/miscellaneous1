package appium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Youtube {

	
	DesiredCapabilities capabilities;
	AppiumDriver<WebElement> driver;
	@BeforeMethod
	public void setUpAppium() throws MalformedURLException
	{
		String devicename = "ZX1D64B73P";
		String plotform = "Android";
		String packagename = "com.google.android.youtube";
		String activityname = "com.google.android.youtube.HomeActivity";
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
		//driver.closeApp();
	}
	
	@Test
	public void Youtube_Playback() throws InterruptedException, IOException
	{
		driver.findElement(By.id("com.google.android.youtube:id/menu_search")).click();
		driver.findElement(By.id("com.google.android.youtube:id/search_edit_text")).sendKeys("Sachin Tendulkar");
		Runtime.getRuntime().exec("adb shell input keyevent 66");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> videoList = driver.findElements(By.id("com.google.android.youtube:id/thumbnail"));
		videoList.get(1).click();
		for(int i=0; i< 12; i++)
		{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		WebElement ele = driver.findElement(By.id("com.google.android.youtube:id/player_control_play_pause_replay_button"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).doubleClick().build().perform();
	}
}
