package tests;

import java.io.IOException;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_RegisterTest extends ProjectSpecificationMethods{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		readAndWritePropFile();
		
		ProjectSpecificationMethods obj = new ProjectSpecificationMethods();
		obj.browserLaunchAndUrlLoad(prop.getProperty("browser"), prop.getProperty("url"));
		
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
		
		obj.closeBrowser();
		
	}

}
