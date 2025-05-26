package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods{
	
	
	@FindBy(className  = "ico-login")
	WebElement login;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public RegisterPage clickRegister() {
		
		driver.findElement(By.className("ico-register")).click();
		return new RegisterPage(driver);
	}
	
	public HomePage valiadteLoginAndSignUp(String expectedMessage) {
		
		String actualText = driver.findElement(By.className("account")).getText();
		if(expectedMessage.equals(actualText)) {
			System.out.println("Register completed sucessfully");
		} else {
			
			System.out.println("Validation failed");
		}
		return this;
	}
	
	public LoginPage clickLogin() {
		
		login.click();
		return new LoginPage(driver);
	}
	

}
