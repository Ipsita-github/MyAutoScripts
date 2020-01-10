package Com.E2M.GenericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.E2M.ObjectRepository.EventListPage;
import Com.E2M.ObjectRepository.Event_Dashboard;
import Com.E2M.ObjectRepository.LoginPage;
import Com.E2M.ObjectRepository.LogoutPage;

import org.openqa.selenium.TakesScreenshot;

 
public class Baseclass_libraries extends fileutil
{
	
	public static WebDriver driver;
	public fileutil scrnshothelp=new fileutil();
	public Properties pobj; 
	
	@BeforeClass 
	public void configBc() throws IOException
	{
		System.out.println("========Launch Browser========");
		pobj = scrnshothelp.getpropertiesfileobject();	
		String browsername=pobj.getProperty("BROWSER");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Resourse/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			driver=new FirefoxDriver();
 		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.IE.driver", "");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod 
	public void loginCheck() throws IOException, Throwable
	{
		System.out.println("Login To Event2Mobile Responsive Site");
		
		pobj = scrnshothelp.getpropertiesfileobject();
		driver.get(pobj.getProperty("MAIN_URL"));
		
		 LoginPage log=PageFactory.initElements(driver, LoginPage.class);
		       WebElement uname=log.EnterUsername(pobj.getProperty("USERNAME").trim());
		       scrnshothelp.takeScreenshot(driver, uname,"Username");
		           Thread.sleep(2000);
		
	     LoginPage pro=PageFactory.initElements(driver, LoginPage.class);
		           pro.clickOnProceed();
		           Thread.sleep(2000);
		           
		 LoginPage pwd=PageFactory.initElements(driver, LoginPage.class);
		           pwd.EnterPassword(pobj.getProperty("PASSWORD").trim());
		           Thread.sleep(2000);
		           
		 LoginPage sub=PageFactory.initElements(driver, LoginPage.class);
		           sub.clickOnSubmit();
		           Thread.sleep(2000);  
		 String ExpectedURL = pobj.getProperty("EVENTLISTPAGE_URL".trim());
		 String ExpectedTitle = pobj.getProperty("EVENTLISTPAGE_Title".trim());
		 scrnshothelp.verifyURLTitle(driver,ExpectedURL,ExpectedTitle);
		           	
     }
	
	//@AfterMethod
	 public void Logout() throws IOException
	{
		 System.out.println("Logout From Event2mobile");
		 LogoutPage lout=PageFactory.initElements(driver, LogoutPage.class);
		            lout.clickOnlogout();
		                           
		scrnshothelp.takeScreenshot(driver,null,"/Screenshots/Pass_Screenshots/PostLogoutScreen");    
		            
		  
	}
	 
	@AfterClass 
	 public void closeBrowser()
		{
			System.out.println("========close browser=========");
            driver.close();
            driver.quit();
		
	 }	
}
