package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificationMethods;

public class RegisterResult extends ProjectSpecificationMethods{

	public RegisterResult(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public HomePage clickContinue() {
		
		driver.findElement(By.xpath("//input[contains(@class,'register-continue-button')]")).click();
		return new HomePage(driver);
	}
}
