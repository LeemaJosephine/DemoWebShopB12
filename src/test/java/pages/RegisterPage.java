package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificationMethods;

public class RegisterPage extends ProjectSpecificationMethods{
	
	public RegisterPage (WebDriver driver) {
		
		this.driver=driver;
	}
	
	public RegisterPage choseGender(String gender) {
		
		if(gender.equalsIgnoreCase("male")) {
		driver.findElement(By.id("gender-male")).click();
		} else if(gender.equalsIgnoreCase("female")) {
			driver.findElement(By.id("gender-female")).click();
		}
		return this;
	}
	
	public RegisterPage enterFirstName(String firstname) {
		
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		return this;
	}
	
	public RegisterPage enterLastName(String lastname) {
		
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		return this;
		
	}
	
	public RegisterPage enterEmail(String email) {
		
		driver.findElement(By.id("Email")).sendKeys(email);
		return this;
	}
	
	public RegisterPage enterPassword(String pass) {
		
		driver.findElement(By.id("Password")).sendKeys(pass);
		return this;
	}
	
	public RegisterPage enterConpass(String conPass) {
		
		driver.findElement(By.id("ConfirmPassword")).sendKeys(conPass);
		return this;
		
	}
	
	public RegisterResult clickSubmit() {
		
		driver.findElement(By.id("register-button")).click();
		return new RegisterResult(driver);
	}

}
