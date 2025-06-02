package day31;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AttributesExample {


	
	@Test(priority = 1, dependsOnMethods = {"sigupTest"}, groups= {"smoke testing"},alwaysRun = true)
	public void loginTest() {
		System.out.println("Login test");
	}
	
	
	@Test(groups= {"smoke testing"},invocationCount = 4, invocationTimeOut = 10, threadPoolSize = 2)
	public void sigupTest() {
		System.out.println("Sign up test");
		Assert.assertTrue(false);  // for test validation 
		
	}
	
	@Ignore
	@Test(dependsOnGroups = {"smoke testing"}, timeOut = 2000)
	public void paymentTest() {
		
		System.out.println("Payment test");
	}
	
	@Ignore
	@Test(priority = 2, groups= {"regression testing"})
	public void searchProductTest() {
		System.out.println("search product test");
	}
	
	@Test(priority = 3, enabled = false)
	public void selectProduct() {
		System.out.println("select product test");
	}
	
	
	
	
}
