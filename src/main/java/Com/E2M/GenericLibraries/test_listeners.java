package Com.E2M.GenericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

 

public class test_listeners extends Baseclass_libraries implements ITestListener{
	
	
	    public fileutil scrnshothelp=new fileutil();
	 	// When Test case get Started, this method is called.
		//@Override
		public void onTestStart(ITestResult result) {
			System.out.println(result.getName()+" testcase started");	
			
		}
	 
		 // When Test case get passed, this method is called.
		//@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println("The name of the testcase passed is :"+result.getName());
			String passedTestName = result.getName();
			
			try {
				scrnshothelp.takeScreenshot(driver,null,"/Screenshots/Pass_TestCases/"+passedTestName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		 // When Test case get failed, this method is called.
		//@Override
		public void onTestFailure(ITestResult result) {
			
			System.out.println("The name of the testcase failed is :"+result.getName());
			String failedTestName = result.getName();
			
			try {
				scrnshothelp.takeScreenshot(driver,null,"/Screenshots/Fail_TestCases/"+failedTestName);
			} catch (IOException e) {
				e.printStackTrace();
			}
						
		}
		
			 
		//@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}
	 
		//@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}
	 
		//@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		
		public void onTestSkipped(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}
		  
		      
	 
	}



