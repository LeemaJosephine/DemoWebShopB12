package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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
		
		WebElement register = driver.findElement(By.className("ico-register"));
		
		//Assert.assertFalse(register.isDisplayed());
		// Validating using soft assert 
	
		assertObj.assertFalse(register.isDisplayed());
		
		register.click();
		return new RegisterPage(driver);
	}
	
	public HomePage valiadteLoginAndSignUp(String expectedMessage) throws IOException {
		
		String actualText = driver.findElement(By.className("account")).getText();
		Assert.assertEquals(actualText, expectedMessage);
		
		return this;
	}
	
	public void validateLogin(String testType, String expectedMessage) {
		
		if(testType.equals("ValidEmailValidPassword")) {
			
			String actualText = driver.findElement(By.className("account")).getText();
			Assert.assertEquals(actualText, expectedMessage);
					
			}else if(testType.equals("InvalidEmailValidPassword") || testType.equals("ValidEmailInvalidPassword") || testType.equals("InvalidEmailInvalidPassword")) {
				
				String actualText = noUser.getText();
				Assert.assertEquals(actualText, expectedMessage);
		}
		
	}
	
	public LoginPage clickLogin() {
		
		login.click();
		return new LoginPage(driver);
	}
	

}
