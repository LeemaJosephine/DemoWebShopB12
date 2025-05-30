package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Utility;

public class ProjectSpecificationMethods extends Utility{
	
	@BeforeMethod
	public void browserLaunchAndUrlLoad() {
		
		launchBrowserAndLoadUrl(prop.getProperty("browser"),prop.getProperty("url"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		browserClose();
	}
	

}
