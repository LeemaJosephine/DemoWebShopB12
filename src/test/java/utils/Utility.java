package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility {

	public static WebDriver driver;  // remove static while performing parallel execution 
	public static Properties prop = new Properties();
	public static FileOutputStream output;
	public static SoftAssert assertObj = new SoftAssert();
	public String sheetname;
	public static ExtentReports extent;
	public String testName, testDescription, testAuthor, testCategory;
	public static ExtentTest test;
	
	public void launchBrowserAndLoadUrl(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver= new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		} else {
			
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	public void browserClose() {
		
		driver.close();
	}
	
	public static void readAndWritePropFile() throws IOException {
		
		String filePath="C:\\Users\\Digital Suppliers\\second-workspace\\DemoWebShopProject\\src\\test\\resources\\data\\testdata.properties";
		FileInputStream file = new FileInputStream(filePath);
		prop.load(file);
		file.close();
		
		output = new FileOutputStream("C:\\Users\\Digital Suppliers\\second-workspace\\DemoWebShopProject\\src\\test\\resources\\data\\testOutputData.properties");
		prop.store(output,"Validate message");
		
	}
	
	public static void propClose() throws IOException {
		
		output.close();
	}
	
	
	
	
	public static String[][] readExcel(String sheetname) throws IOException {
		// Open the workbook
				XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Digital Suppliers\\second-workspace\\DemoWebShopProject\\src\\test\\resources\\data\\LoginTestData.xlsx");
				
				// Open the sheet
				
				XSSFSheet sheet = book.getSheet(sheetname);
				
				// get the no.of rows
				
				int rowCount = sheet.getLastRowNum();
				
				// get the column count
				
				int columnCount = sheet.getRow(0).getLastCellNum();
				
				// Create 2D array
				
				String[][] data = new String[rowCount][columnCount];
				
				// Get into each row
				
				for(int i=1; i<=rowCount; i++) {
					
					XSSFRow row = sheet.getRow(i);
					
					// get into the column
					
					for(int j=0; j<columnCount ; j++) {
						
						XSSFCell cell = row.getCell(j);
						
						// read the value
						
						System.out.print(cell.getStringCellValue()+"|");
						
						// to store in array
						
						data[i-1][j]=cell.getStringCellValue();
					}
					
					System.out.println();
				}

				book.close();
				return data;
	}
	
	public static String screenShot(String name) throws IOException {
		
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String path="C:\\Users\\Digital Suppliers\\second-workspace\\DemoWebShopProject\\src\\test\\resources\\testOutput\\snaps\\"+name+timestamp+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	
}
