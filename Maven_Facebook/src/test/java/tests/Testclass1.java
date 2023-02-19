package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomclass.loginOrSignUpPage;

public class Testclass1 {

	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(" https://www.facebook.com/") ;
		
		 loginOrSignUpPage  LoginOrSignUpPage = new  loginOrSignUpPage(driver);
		 LoginOrSignUpPage.sendUserName();
		 LoginOrSignUpPage.sendPassword();
		 LoginOrSignUpPage.clickonForgotPasswordLink();

	}

}
