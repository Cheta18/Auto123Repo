package testNgPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestNgClass {
	
	@BeforeClass
	public void beforeClass() {
		
		System.out.println("Before Class");
	}
	@BeforeMethod 
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test (priority = 3)
	public void test() {
		System.out.println("Test");
	}
	@Test (priority = 1, invocationCount = 0)
	public void test1() {
		System.out.println("Test-1");
	}
	@Test (priority = 0)
	public void test2() {
		System.out.println("Test-2");
		
	}	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

}
