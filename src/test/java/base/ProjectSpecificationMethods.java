package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import utils.Utility;

public class ProjectSpecificationMethods extends Utility{
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void browserLaunchAndUrlLoad(String browser, String url) {
		
		launchBrowserAndLoadUrl(browser,url);
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		browserClose();
	}
	
	@DataProvider(name ="readData")
	public String[][] dataRead() throws IOException {
		
		 return readExcel(sheetname);
	}
	

}
