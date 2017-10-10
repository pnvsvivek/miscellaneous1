package checkerswithmain;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sun.glass.events.KeyEvent;

public class Checker1 {
	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\p.nvs.vivek\\workspace\\cucumber-selenium-testNG-framework\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("vivek");		
		//driver.findElement(By.name("lastname")).sendKeys("vikranth");
		Checker3 ch = new Checker3(driver);
		ch.lastName.sendKeys("vikranth");
		driver.findElement(By.xpath("//input[contains(@value,'Male')]")).click();
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.id("datepicker")).sendKeys("07/13/2017");
		WebElement el = driver.findElement(By.xpath("//input[contains(@value,'Manual Tester')]"));
		if(el.isSelected())
		{
			System.out.println("manual tester is selected");
		}
		else
		{
			el.click();
		}
		driver.findElement(By.name("photo")).click();
		String path = "C:\\Users\\p.nvs.vivek\\Downloads\\images\\my pic2.jpg";
		StringSelection sel = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click();
		WebElement el1 = driver.findElement(By.xpath("//input[contains(@value,'Selenium Webdriver')]"));
		if(el1.isSelected())
		{
			System.out.println("Selenium Webdriver is selected");
		}
		else
		{
			el1.click();
		}
		WebElement continents = driver.findElement(By.name("continents"));
		Select sel1 = new Select(continents);
		if(sel1.isMultiple())
		{
			System.out.println("this is one select");
		}
		else
		{
			System.out.println("this is not one select");
		}
		sel1.selectByVisibleText("Africa");
		System.out.println("first selected option "+sel1.getFirstSelectedOption().getText());
		//System.out.println(continents.getText());
		List<WebElement> listerofmul1 = sel1.getAllSelectedOptions();
		for(int i=0; i<listerofmul1.size();i++)
		{
			System.out.println(" printer for single select "+listerofmul1.get(i).getText());
		}
		
		WebElement selCommands = driver.findElement(By.name("selenium_commands"));
		Select sel2 = new Select(selCommands);
		if(sel2.isMultiple())
		{
			System.out.println("multiple one");
		}
		else
		{
			System.out.println("not a multiple one");
		}
		sel2.selectByVisibleText("Browser Commands");
		sel2.selectByVisibleText("Navigation Commands");
		
		List<WebElement> listerofmul = sel2.getAllSelectedOptions();
		for(int i=0; i<listerofmul.size();i++)
		{
			System.out.println(" printer "+listerofmul.get(i).getText());
		}
		
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\p.nvs.vivek\\Downloads\\image.png");
		FileUtils.copyFile(src, dest);
		
		String val = firstname.getAttribute("value");
		System.out.println("firstName value "+val);
		driver.findElement(By.id("submit")).click();		
		}
}
