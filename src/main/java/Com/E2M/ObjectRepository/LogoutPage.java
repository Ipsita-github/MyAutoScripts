package Com.E2M.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	//WebElement locators
	@FindBy(xpath="//a[@id='list1']")
	private WebElement settings_icon;
	
	@FindBy(xpath="//*[@id='notification']/ul/li[4]/div/ul/li[5]/a/span")
	private WebElement signOut_link;
	
 
	
	
	//Utilisation
	public void clickOnlogout()   {
		settings_icon.click();
		signOut_link.click();
	}

}
