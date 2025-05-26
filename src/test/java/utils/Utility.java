package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Utility {

	public static WebDriver driver;
	
	public void launchBrowserAndLoadUrl(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver= new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		} else {
			
			driver= new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	public void browserClose() {
		
		driver.close();
	}
}
