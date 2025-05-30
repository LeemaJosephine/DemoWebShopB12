package tests;

import java.io.IOException;
import java.util.List;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import utils.Utility;

public class TC_002_LoginTest extends ProjectSpecificationMethods{

	public static void main(String[] args) throws IOException {
		
		String[][] testData = readExcel();
		
		for(String[] row : testData) {
			
			loginTest(row[0], row[1], row[2], row[3]);
		}
	}
	
	public static void loginTest(String mailId, String password, String expectedMessage, String testType) throws IOException {

		
		new HomePage(driver)
		.clickLogin()
		.enterEmail(mailId)
		.enterPassword(password)
		.clickRememberMe()
		.clickLoginButton()
		.validateLogin(testType, expectedMessage);
	}
}
