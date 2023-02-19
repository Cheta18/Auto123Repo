package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	@FindBy (xpath ="(//a[text()='Terms'])[2]") 
	private WebElement termsLink;
	
	@FindBy (xpath ="(//a[text()='Privacy Policy'])[2]") 
	private WebElement privacyPolicy;
	
	
	public SignUpPage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
		
	}
	
     public void clickonTermsLink() {
		
		termsLink.click();
		
	}
    public void clickonPrivacyPolicy() {
		
		privacyPolicy.click();
    }	

}
