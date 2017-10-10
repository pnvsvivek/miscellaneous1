package checkerswithmain;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slikgrid {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\p.nvs.vivek\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mleibman.github.io/SlickGrid/examples/example1-simple.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//*[contains(@class,'slick-viewport')]/div/div"));
		int rowcount = rows.size();
		System.out.println("Size of the rows is "+rowcount);
		List<WebElement> columns = driver.findElements(By.xpath("//*[contains(@class,'slick-viewport')]/div/div[1]/div"));
		int columncount = columns.size();
		System.out.println("Size of the columns is "+columncount);
		int i=1;
		while(true)
		{
			try
			{
			for(int j=1;j<=columncount;j++)
			{
			System.out.print(driver.findElement(By.xpath("//*[contains(@class,'slick-viewport')]/div/div["+i+"]/div["+j+"]")).getText()+" ");
			}
			}
			catch(Exception e)
			{
			driver.findElement(By.xpath("//*[contains(@class,'slick-viewport')]/div/div")).click();
			driver.findElement(By.xpath("//*[contains(@class,'slick-viewport')]/div/div")).sendKeys(Keys.PAGE_DOWN);
				for(int j=1;j<=columncount; j++)
				{
			System.out.println((driver.findElement(By.xpath("//*[contains(@class,'slick-viewport')]/div/div["+i+"]/div["+j+"]")).getText()));
				}
			Thread.sleep(3000);
			}
			System.out.println();
			i++;
		}
	}
}
