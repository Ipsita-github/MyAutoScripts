package Com.E2M.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import Com.E2M.GenericLibraries.Baseclass_libraries;


public class LoginPage extends Baseclass_libraries {
	
		
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement user_name;
	
	@FindBy(xpath="//a[@id='spnLogin']")
	private WebElement proceed;
	
	@FindBy(xpath="//input[@name='password_']")
	private WebElement pass_word;
	
	@FindBy(xpath="//a[@id='spnPassword']")
	private WebElement submit;
	
	
	
	
	
	public WebElement EnterUsername(String username){
		user_name.sendKeys(username);
		return user_name;
	  }
	
	public void clickOnProceed()   {
		proceed.click();
	}
	
	public void EnterPassword(String password){
		pass_word.sendKeys(password);
	}
	
	public void clickOnSubmit()   {
		submit.click();
	}
	
	
    

}
