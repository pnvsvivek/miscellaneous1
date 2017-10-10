package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class HotstarSignIn {	
	DesiredCapabilities capabilities;
	AppiumDriver<WebElement> driver;
	@BeforeMethod
	public void setUpAppium() throws MalformedURLException
	{
		String devicename = "db95ca790903";
		String plotform = "Android";
		String packagename = "in.startv.hotstar";
		String activityname = "in.startv.hotstar.activities.splash.SplashActivity";
		String url = "http://0.0.0.0:4723/wd/hub";	
		
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
		driver.quit();
	}
	
	@Test
	public void Hotstar_SignIn() throws InterruptedException
	{		
				driver.findElement(By.xpath("//android.widget.ImageView[@index = '1']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text = 'Sign In']")).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//android.widget.EditText[@text = 'Email Address']")).sendKeys("raees@mailinator.com");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.hideKeyboard();
				driver.findElement(By.xpath("//android.widget.EditText[@text = 'Password']")).sendKeys("kabil");;
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.hideKeyboard();
				driver.findElement(By.xpath("//android.widget.Button[@text = 'SIGN IN']")).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//android.widget.ImageView[@index = '1']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text = 'My Account']")).click();
				String AccountInfo = driver.findElement(By.id("in.startv.hotstar:id/my_account_signed_in")).getText();
				System.out.println(AccountInfo);
				driver.findElement(By.xpath("//android.widget.TextView[@text = 'Sign out']")).click();
			    driver.findElement(By.xpath("//android.widget.Button[@text = 'OK']")).click();    
	}
}
