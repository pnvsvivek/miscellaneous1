package checkerswithmain;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class SecurityPopup {

	public static void main(String[] args) throws AWTException, IOException, FindFailed, InterruptedException {
		
		WebDriver driver = Components.selectBrowser("ie");
		
		//Runtime.getRuntime().exec("C:\\Users\\p.nvs.vivek\\Desktop\\AutoITScripts\\HandleAuthWindow.exe");
		driver.get("http://staging.filmstruck.com/#!/login/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Screen scr = new Screen();
		Pattern pat = new Pattern("C:/Users/p.nvs.vivek/Downloads/images/ieusname.png");
		Thread.sleep(1000);
	//	scr.wait(pat, 10);
		Match m = scr.exists(pat);
		if(m!=null)
		{
			System.out.println("Found username");
		scr.type(pat, "turnertest");
		
		}
		else
		{
			System.out.println("username not found");
		}
		
		Pattern pat1 = new Pattern("C:/Users/p.nvs.vivek/Downloads/images/iepsword.png");
		//scr.wait(pat1, 10);
		Match m1 = scr.exists(pat1);
		if(m1!=null)
		{
			System.out.println("Found password");
		scr.type(pat1, "t7rn3rt3st!");
		}
		else
		{
			System.out.println("username not found");
		}
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	//	WebDriverWait wait = new WebDriverWait(driver,30);
		/*Alert alert = driver.switchTo().alert();
		alert.sendKeys("turnertest");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		alert.sendKeys("t7rn3rt3st!");
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);*/
		/*StringSelection sel = new StringSelection("turnertest");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		StringSelection sel1 = new StringSelection("t7rn3rt3st!");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel1, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);*/
	}

}
