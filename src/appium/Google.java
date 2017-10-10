package appium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) {
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\p.nvs.vivek\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mleibman.github.io/SlickGrid/examples/example1-simple.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> table = driver.findElements(By.xpath("//span[contains(text(),'Title')]"));
        List<WebElement> trows = table.get(0).findElements(By.tagName("tr"));
        System.out.println("The size of the rows "+trows.size());
        System.out.println("The size of the table "+table.size());
        driver.close();*/
		String element = "xpath;//input[contains(@value,'Log In')]";
		String[] splitter = element.split(";");
		System.out.println(splitter[0]+" and "+splitter[1]);
	}
}
