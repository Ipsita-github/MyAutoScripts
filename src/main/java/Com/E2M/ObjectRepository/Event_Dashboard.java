package Com.E2M.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.E2M.GenericLibraries.Baseclass_libraries;

public class Event_Dashboard extends Baseclass_libraries {
	
		
		@FindBy(xpath="//button[@class='menubtn-icon']")
		private WebElement sideMenu_icon;
		
		public void ClickHamburger(){
			sideMenu_icon.click();
		}

}
