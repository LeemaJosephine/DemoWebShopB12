package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;

public class Utility {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileOutputStream output;
	
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
		
		output = new FileOutputStream("C:\\Users\\Digital Suppliers\\second-workspace\\DemoWebShopProject\\src\\test\\resources\\data\\testOutputData.properties");
		prop.store(output,"Validate message");
	}
	
	public static String[][] readExcel() throws IOException {
		// Open the workbook
				XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Digital Suppliers\\second-workspace\\DemoWebShopProject\\src\\test\\resources\\data\\LoginTestData.xlsx");
				
				// Open the sheet
				
				XSSFSheet sheet = book.getSheet("LoginData");
				
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
	
	
}
