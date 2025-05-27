package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods{
	
	
	@FindBy(className  = "ico-login")
	WebElement login;
	
	@FindBy(xpath = "//div[@class='validation-summary-errors']/ul/li")
	WebElement noUser;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public RegisterPage clickRegister() {
		
		driver.findElement(By.className("ico-register")).click();
		return new RegisterPage(driver);
	}
	
	public HomePage valiadteLoginAndSignUp(String expectedMessage) throws IOException {
		
		String actualText = driver.findElement(By.className("account")).getText();
		prop.setProperty("message", actualText);
		//output.close();
		
		if(expectedMessage.equals(actualText)) {
			System.out.println("Register completed sucessfully");
		} else {
			
			System.out.println("Validation failed");
		}
		return this;
	}
	
	public void validateLogin(String testType, String expectedMessage) {
		
		if(testType.equals("ValidEmailValidPassword")) {
			
			String actualText = driver.findElement(By.className("account")).getText();
			if(expectedMessage.equals(actualText)) {
				System.out.println("Login completed sucessfully");
			} else {
				
				System.out.println("Validation failed");
			} 
					
			}else if(testType.equals("InvalidEmailValidPassword") || testType.equals("ValidEmailInvalidPassword") || testType.equals("InvalidEmailInvalidPassword")) {
				
				String actualText = noUser.getText();
				if(expectedMessage.equals(actualText)) {
					System.out.println("Login faild with message " + actualText);
				} else {
					System.out.println("Application Failed");
				}
		}
		
	}
	
	public LoginPage clickLogin() {
		
		login.click();
		return new LoginPage(driver);
	}
	

}
