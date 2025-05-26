package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class LoginPage extends ProjectSpecificationMethods{

	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id="RememberMe")
	WebElement remember;
	
	@FindBy(xpath = "//input[contains(@class,'login-button')]")
	WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage enterEmail(String emailId) {
		
		email.sendKeys(emailId);
		return this;
	}
	
	public LoginPage enterPassword(String pass) {
		
		password.sendKeys(pass);
		return this;
	}
	
	public LoginPage clickRememberMe() {
		
		remember.click();
		return this;
	}
	
	public HomePage clickLoginButton() {
		
		loginButton.click();
		return new HomePage(driver);
	}
}
