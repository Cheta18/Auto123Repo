package testNgPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomclass.SignUpPage;
import pomclass.loginOrSignUpPage;

public class TestNgAuto {
	WebDriver driver ;
	loginOrSignUpPage  LoginOrSignUpPage;
	SignUpPage signUpPage;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) throws InterruptedException {
		
		if (browserName.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		if (browserName.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	@BeforeClass
	public void objectCreate() {
		LoginOrSignUpPage = new  loginOrSignUpPage(driver);
	    signUpPage = new SignUpPage(driver);
	}

	@BeforeMethod 
	public void signupForm() {
		driver.get(" https://www.facebook.com/") ;
		loginOrSignUpPage  LoginOrSignUpPage = new  loginOrSignUpPage(driver);
		LoginOrSignUpPage.clickonCreateNewAcc();
	}
	
	@Test
	public void verifyTermsLink() {
		//SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickonTermsLink();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles()) ;
		driver.switchTo().window(addr.get(1));
		
		String actualUrl = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		
		String expectedUrl = "https://www.facebook.com/legal/terms/update";
		String expectedtitle ="Facebook";
		
		if(actualUrl.equals(expectedUrl) && actualTitle.equals(expectedtitle)) {
			System.out.println("passed");
		}
		else {
			System.out.println("failed") ;
		}
	}   
	    @Test
		public void verifyPrivacyPolicy() {
			SignUpPage signUpPage = new SignUpPage(driver);
			signUpPage.clickonTermsLink();
			
			ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles()) ;
			driver.switchTo().window(addr.get(1));
			
			String actualUrl = driver.getCurrentUrl();
			String actualTitle = driver.getTitle();
			
			String expectedUrl = "https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
			String expectedtitle ="Meta Privacy Policy ??? How Meta collects and uses user data | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
			
			if(actualUrl.equals(expectedUrl) && actualTitle.equals(expectedtitle)) {
				System.out.println("passed");
			}
			else {
				System.out.println("failed");
			}
	}
	
	@AfterMethod
	public void closedCrrentTab() {
		System.out.println("After Method");
		driver.close();
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles()) ;
		driver.switchTo().window(addr.get(0));
	}
	@AfterClass
	public void clearObject() {
		System.out.println("After Class");
		LoginOrSignUpPage = null ;
		signUpPage = null ;
	}
	@AfterTest
	public void closeBrowser() {
		System.out.println("After Test");
		driver.quit();
		driver = null ;
		System.gc();
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


