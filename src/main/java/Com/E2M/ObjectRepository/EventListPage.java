package Com.E2M.ObjectRepository;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.E2M.GenericLibraries.Baseclass_libraries;

public class EventListPage extends Baseclass_libraries{
	
	@FindBy(xpath="//*[@id='events-view']/a[1]/div/div")
	private WebElement eventName;
	    
		public void ClickOnEvent() {
				eventName.click();
		}

}
