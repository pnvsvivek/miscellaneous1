package checkerswithmain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Components {
	
	public static void main(String args[]) throws IOException
	{
		//System.out.println(System.getProperty("user.dir"));
		String a = "1";
		String b="3";
		System.out.println(Integer.valueOf(a)+Integer.valueOf(b));
	}

	public static WebDriver selectBrowser(String browser)
	{
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "drivers//IEDriverServer.exe");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(cap);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public static String getProperties(String keys) throws IOException
	{
		File file = new File("config.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(keys);
	}
	
	@SuppressWarnings("resource")
	public static List<Object[][]>readExcel() throws IOException
	{
		String path = "C:\\Users\\p.nvs.vivek\\Documents\\viki.xlsx";
		String sheetname = "test";
		List<Object[][]> list = new ArrayList<Object[][]>();
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rd = sh.getLastRowNum()-sh.getFirstRowNum();
		int totalCol = sh.getRow(0).getLastCellNum();
		for(int i=1;i<=rd;i++)
		{
		Object[][] ob = new Object[rd][totalCol];
			Row row = sh.getRow(i);
			if(row!=null)
			{
				for(int j=3;j<row.getLastCellNum();j++)
				{
				Cell cell = row.getCell(j);
				if(cell!=null)
				{
					ob[i-1][j-3] = cell.toString();
				}
				}
			}
			list.add(ob);
		}
		return list;
	}
}
