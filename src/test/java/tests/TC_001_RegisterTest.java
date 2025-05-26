package tests;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_RegisterTest extends ProjectSpecificationMethods{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProjectSpecificationMethods obj = new ProjectSpecificationMethods();
		obj.browserLaunchAndUrlLoad("chrome", "https://demowebshop.tricentis.com/");
		
		HomePage obj1 = new HomePage(driver);
		obj1.clickRegister()
		.choseGender("female")
		.enterFirstName("demoUser18")
		.enterLastName("test")
		.enterEmail("testdemouser789@gmail.com")
		.enterPassword("demouser123")
		.enterConpass("demouser123")
		.clickSubmit()
		.clickContinue()
		.valiadteLoginAndSignUp("testdemouser789@gmail.com");
		
		obj.closeBrowser();
		
	}

}
