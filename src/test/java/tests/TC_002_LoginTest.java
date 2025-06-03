package tests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import utils.Utility;

public class TC_002_LoginTest extends ProjectSpecificationMethods{

	@BeforeTest
	public void setup() throws Exception {
		
		readAndWritePropFile();
		sheetname="LoginData";
		testName="Login Test";
		testDescription="Testing the login functionality of the application with valid and invalid details";
		testAuthor="Leema Josephine";
		testCategory="Smoke Testing";
	}
	
	@Test(dataProvider = "readData")	
	public void loginTest(String mailId, String password, String expectedMessage, String testType) throws IOException {
	
		new HomePage(driver)
		.clickLogin()
		.enterEmail(mailId)
		.enterPassword(password)
		.clickRememberMe()
		.clickLoginButton()
		.validateLogin(testType, expectedMessage);
	}
}
