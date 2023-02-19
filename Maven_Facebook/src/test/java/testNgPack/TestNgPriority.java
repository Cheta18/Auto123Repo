package testNgPack;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgPriority {
	
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
		Assert.fail();
	}
	@Test (priority = 0, dependsOnMethods = ("test") )
	public void test1() {
		System.out.println("Test-1");
	}
	@Test (priority = 1)
	public void test2() {
		System.out.println("Test-2");
	}
	@Test (priority = 6)
	public void test3() {
		System.out.println("Test-3");
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
