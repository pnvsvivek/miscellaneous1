package checkerswithmain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CharStrng {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addEncodedExtensions("C:\\Users\\p.nvs.vivek\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\aicmkgpgakddgnaphhhpliifpcfhicfo"); 
		driver = new ChromeDriver(options);	
}
}
