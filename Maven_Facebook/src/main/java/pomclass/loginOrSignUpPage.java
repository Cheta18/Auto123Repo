package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginOrSignUpPage {
	
	@FindBy (xpath ="//input[@id='email']") 
	private WebElement userName;
	
	@FindBy (xpath ="//input[@id='pass']") 
	private WebElement passWord;

	@FindBy (xpath ="//button[text()='Log in']") 
	private WebElement loginButton;

	@FindBy (xpath ="//a[text()='Forgotten password?']") 
	private WebElement forgotPasswordLink;
	
	@FindBy (xpath ="//a[text()='Create new account']") 
	private WebElement createNewAcc;
	
	public loginOrSignUpPage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
		
	}
	public void sendUserName() {
		
		userName.sendKeys("Chetan");
	}
    public void sendPassword() {
		
		passWord.sendKeys("Chetan");
	}
    public void clickOnLoginButton() {
	
	loginButton.click();
    }

    public void clickonForgotPasswordLink () {
		
    	forgotPasswordLink.click();
	}
    public void clickonCreateNewAcc () {
    	createNewAcc.click();
    }
    
	
	



}
