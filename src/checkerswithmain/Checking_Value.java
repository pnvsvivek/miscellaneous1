package checkerswithmain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checking_Value {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Components.selectBrowser("chrome");
		driver.get("http://www.compendiumdev.co.uk/selenium/search.php");
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.name("q"));
		Thread.sleep(5000);
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.attributeContains(search, "value", "/^[A-z]+$/"));*/
		String textValue = search.getAttribute("value");
		System.out.println(textValue);
		if(!(textValue.matches("")))
		{
		driver.findElement(By.name("btnG")).click();
		List<WebElement> lis = driver.findElements(By.tagName("a"));
		for(int i=0; i<lis.size();i++)
		{
		if(lis.get(i).getAttribute("href").contains("seleniumhq"))
		{
		lis.get(i).click();
		break;
		}
		}
		System.out.println("Successful");
		}
		else
		{
			System.out.println("Not successful");
		}
	}

}
