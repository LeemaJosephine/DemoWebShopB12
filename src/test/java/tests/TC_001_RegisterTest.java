package tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_RegisterTest extends ProjectSpecificationMethods{

	@BeforeTest
	public void setup() throws Exception {
		
		readAndWritePropFile();
		sheetname="Register";
		testName="Register Test";
		testDescription="Testing the register functionality of the application with valid and invalid details";
		testAuthor="Leema Josephine";
		testCategory="Smoke Testing";
	}
	
	@Test
	public  void registerTest() throws IOException {  // test method
		// TODO Auto-generated method stub

		HomePage obj1 = new HomePage(driver);
		obj1.clickRegister()
		.choseGender(prop.getProperty("gender"))
		.enterFirstName(prop.getProperty("fristname"))
		.enterLastName(prop.getProperty("lastname"))
		.enterEmail(prop.getProperty("email"))
		.enterPassword(prop.getProperty("password"))
		.enterConpass(prop.getProperty("conpass"))
		.clickSubmit()
		.clickContinue()
		.valiadteLoginAndSignUp(prop.getProperty("validateMsg"));
		assertObj.assertAll();
		
		
	}
	
	@AfterTest
	public void setupClose() throws IOException {
		
		propClose();
	}

}
