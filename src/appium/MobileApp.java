package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * This class is demonstration for the calculator android app
 * @author p.nvs.vivek
 *
 */

public class MobileApp {

	DesiredCapabilities capabilities;
	AppiumDriver<WebElement> driver;
	@BeforeMethod
	public void setUpAppium() throws MalformedURLException
	{
		String devicename = "Hotstar";
		String plotform = "Android";
		String packagename = "com.android.calculator2";
		String activityname = "com.android.calculator2.Calculator";
		String url = "http://127.0.0.1:4723/wd/hub";
		
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", devicename);		
		capabilities.setCapability("plotformName", plotform);
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		//capabilities.setCapability("avd", "nexus");
		//capabilities.setCapability("noReset", true);
		
		if(plotform.equalsIgnoreCase("android"))
		{
			driver = new AndroidDriver<WebElement>(new URL(url),capabilities);
		}
		if(plotform.equalsIgnoreCase("ios"))
		{
			driver = new IOSDriver<WebElement>(new URL(url),capabilities);
		}		
	}
	@AfterMethod
	public void tearDownAppium()
	{
		driver.quit();
	}
	
	@Test
	public void testCalculator() throws Exception
	{
		//2 number selected
		WebElement num1 = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
		num1.click();
		
		// addition symbol is selected
				WebElement mul = driver.findElement(By.id("com.android.calculator2:id/op_add"));
				mul.click();
				
		//9 number selected
		WebElement num2 = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
		num2.click();
		
		
		WebElement outputbox = driver.findElement(By.id("com.android.calculator2:id/formula"));
		String outputboxvalue = outputbox.getText();
		System.out.println("OutputBoxValue "+outputboxvalue);
		Assert.assertEquals(outputboxvalue, "2+9");
 	}
	@Test
	public void tester1()
	{
		WebElement num1 = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
		num1.click();
		
		// addition symbol is selected
				WebElement mul = driver.findElement(By.id("com.android.calculator2:id/op_add"));
				mul.click();
				
		//9 number selected
		WebElement num2 = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
		num2.click();
	}
}
