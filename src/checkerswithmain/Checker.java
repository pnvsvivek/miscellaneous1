package checkerswithmain;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;


public class Checker {

	public static void main(String[] args) {
		
		WebDriver driver = Components.selectBrowser("chrome");
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		String mainwindow = driver.getWindowHandle();
		Set<String> listofwindows =  driver.getWindowHandles();
		System.out.println("Number of windows "+listofwindows.size());
		int count =0;
		for(String x:listofwindows)
		{
			if(!x.equals(mainwindow))
			{
			driver.switchTo().window(x);
		//	System.out.println("title of the windows "+driver.getTitle());
			count++;
			}
			if(count==2)
			{
				System.out.print("second window name is "+driver.getTitle());;
			}
		}
		System.out.println(count);
		driver.quit();
	}
}
