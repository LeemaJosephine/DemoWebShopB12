package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import utils.Utility;

public class ProjectSpecificationMethods extends Utility{
	
	@BeforeSuite
	public void createReport() {
		
		// To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\Digital Suppliers\\second-workspace\\DemoWebShopProject\\src\\test\\resources\\testOutput\\DemoWebShop_Test_Report.html");
		reporter.config().setReportName("Demo Web Shop Test report");
		
		// To attach the data to the reporter 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@BeforeClass
	public void testDeatils() {
		
		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	}
	
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
	
	@AfterSuite
	public void closeReport() {
		
		extent.flush();
	
	}
	

}
