package checkerswithmain;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Check23 {
	public static void main(String[] args) {
		WebDriver driver = null;
		try
		{
		driver = Components.selectBrowser("chrome");
		driver.get("https://www.w3schools.com/sql/sql_where.asp");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement table = driver.findElement(By.xpath("//*[contains(text(),'CustomerName')]//ancestor::table[1]"));
		List<WebElement> trows = table.findElements(By.tagName("tr"));
		List<WebElement> tcols = trows.get(1).findElements(By.tagName("td"));
		HashMap<String,HashMap<String,String>> hm = new HashMap<String,HashMap<String,String>>();
		WebElement td=driver.findElement(By.xpath("//*[contains(text(),'CustomerName')]//ancestor::table[1]//tr["+(2)+"]/td["+(1)+"]"));
		int maxValue=Integer.valueOf(td.getText());
		int minValue=Integer.valueOf(td.getText());
		for(int s=1;s<trows.size();s++)
		{
			List<WebElement> tds = trows.get(s).findElements(By.tagName("td"));
			System.out.println(tds.get(2).getText());
		}
		for(int p=1;p<trows.size();p++)
		{
			HashMap<String,String> hm1 = new HashMap<String,String>();
			WebElement td1 = driver.findElement(By.xpath("//*[contains(text(),'CustomerName')]//ancestor::table[1]//tr["+(p+1)+"]/td["+(1)+"]"));
			WebElement td4 = driver.findElement(By.xpath("//*[contains(text(),'CustomerName')]//ancestor::table[1]//tr["+(p+1)+"]/td["+(tcols.size())+"]"));
			WebElement td5 = driver.findElement(By.xpath("//*[contains(text(),'CustomerName')]//ancestor::table[1]//tr["+(p+1)+"]/td["+(tcols.size()-1)+"]"));
			hm1.put(td5.getText(), td4.getText());
			hm.put(td1.getText(), hm1);
			if(maxValue<Integer.valueOf(td1.getText()))
			{
				maxValue=Integer.valueOf(td1.getText());
			}
			if(minValue>Integer.valueOf(td1.getText()))
			{
				minValue=Integer.valueOf(td1.getText());
			}
		}
		System.out.println(hm);
		for(String j:hm.keySet())
		{
			if(Integer.valueOf(j)==maxValue)
			{
				System.out.println(hm.get(j));
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			driver.quit();
		}
	}
}