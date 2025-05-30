package day31;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotations {


	@BeforeClass
	public void beforeClass() {
		
		System.out.println("Before Class");
		
	}
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Before test");
	}
	
//	@Test
//	public void testmethod() {
//		
//		System.out.println("Test method");
//	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Before method");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("After method");
	}
	
	@AfterTest
	public void afterTest() {
		
		System.out.println("After test");
	}
	
//	@AfterClass
//	public void afterClass() {
//		
//		System.out.println("After class");
//	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("Afte suite");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("Before Suite method");
	}
	
}
