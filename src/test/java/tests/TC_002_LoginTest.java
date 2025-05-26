package tests;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_002_LoginTest extends ProjectSpecificationMethods{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProjectSpecificationMethods obj = new ProjectSpecificationMethods();
		obj.browserLaunchAndUrlLoad("chrome", "https://demowebshop.tricentis.com/");
		
		new HomePage(driver)
		.clickLogin()
		.enterEmail("testdemouser789@gmail.com")
		.enterPassword("demouser123")
		.clickRememberMe()
		.clickLoginButton()
		.valiadteLoginAndSignUp("testdemouser789@gmail.com");
		
		
	}

}
