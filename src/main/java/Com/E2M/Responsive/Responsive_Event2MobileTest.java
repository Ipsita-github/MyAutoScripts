package Com.E2M.Responsive;

 
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Com.E2M.GenericLibraries.Baseclass_libraries;
import Com.E2M.GenericLibraries.test_listeners;
import Com.E2M.GenericLibraries.fileutil;
import Com.E2M.ObjectRepository.EventListPage;
import Com.E2M.ObjectRepository.Event_Dashboard;
import Com.E2M.ObjectRepository.LogoutPage;

public class Responsive_Event2MobileTest extends  test_listeners {
	
	public fileutil flib=new fileutil();
	public Properties pobj; 
	
	@Test(priority =1)
	public void LogoutAfterImmediateLogin() throws Throwable {
	 
		 System.out.println("Logout From Event2mobile");
		 LogoutPage lout=PageFactory.initElements(driver, LogoutPage.class);
		            lout.clickOnlogout();
		            		             
		   flib.takeScreenshot(driver,null,"/Screenshots/Pass_Screenshots/PostLogoutScreen");
	}
	
	@Test(priority =2)
	public void PostLogin_linkTest() throws Throwable {
		
				
		 EventListPage eList =PageFactory.initElements(driver,EventListPage.class);
         eList.ClickOnEvent();
         		
         flib.takeScreenshot(driver,null,"/Screenshots/Pass_Screenshots/EventLaunchScreen");
         Thread.sleep(2000);
         
         pobj = flib.getpropertiesfileobject();
         String ExpectedURL = pobj.getProperty("EVENTLAUNCHPAGE_URL".trim());
		 String ExpectedTitle = pobj.getProperty("EVENTLAUNCHPAGE_Title".trim());
		 flib.verifyURLTitle(driver,ExpectedURL,ExpectedTitle);
		 
         Event_Dashboard dashbrd=PageFactory.initElements(driver, Event_Dashboard.class);
		 dashbrd.ClickHamburger();
		 Thread.sleep(2000);  
			
		 List<WebElement> links = driver.findElements(By.tagName("a"));    
	        //To print the total number of links
	        System.out.println("Total links are "+links.size());    
	        //used for loop to 
	        for(int i=0; i<links.size(); i++) {
	            WebElement element = links.get(i);
	            //By using "href" attribute, we could get the url of the requried link
	            String url=element.getAttribute("href");
	            //calling verifyLink() method here. Passing the parameter as url which we collected in the above link
	            //See the detailed functionality of the verifyLink(url) method below
	            verifyLink(url);            
	        }   
	    }
	 
	    // The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
 	      public void verifyLink(String urlLink) throws IOException,MalformedURLException{
	        //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
	        
	    	 try {
	    	  pobj = flib.getpropertiesfileobject();
	  		String domain = pobj.getProperty("MAIN_URL");
	    	  if(urlLink == null || urlLink.isEmpty()){
	            	System.out.println(urlLink +" is either not configured for anchor tag or it is empty");
	            	                //continue;
	            	            }
	            	            
	            
	        	   if(!urlLink.startsWith(domain)){
   	                System.out.println(urlLink +" belongs to another domain.");
   	               //continue;
   	            }
	        
	            //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
	            URL link = new URL(urlLink);
	            // Create a connection using URL object (i.e., link)
	            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
	            //Set the timeout for 2 seconds
	            httpConn.setConnectTimeout(2000);
	            //connect using connect method
	            httpConn.connect();
	            //use getResponseCode() to get the response code. 
	                if(httpConn.getResponseCode()== 200) {  
	                    System.out.println(urlLink+" - "+httpConn.getResponseMessage());
	                }
	                if(httpConn.getResponseCode()== 404) {
	                    System.out.println(urlLink+" - "+httpConn.getResponseMessage());
	                }
	                                if(httpConn.getResponseCode()== 400) { 
	                                        System.out.println(urlLink+" - "+httpConn.getResponseMessage()); 
	                                }
	                                if(httpConn.getResponseCode()== 500) {
	                    System.out.println(urlLink+" - "+httpConn.getResponseMessage()); 
	                    }
	                                
	             }
	            //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
	         catch (MalformedURLException e) {
                   e.printStackTrace();
            }catch (IOException ex) {
                  ex.printStackTrace();
            }
	      }


}

