package Com.E2M.GenericLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
 

public class fileutil {
 		
		 String filepath="./Data/commondata.properties";
		 String excelpath="./Data/testdata.xlsx";
		 
		 public Properties getpropertiesfileobject() throws IOException
		 {
			 FileInputStream fis=new FileInputStream(filepath);
			 Properties pobj=new Properties();
			 pobj.load(fis);
			 
			 return pobj;
			 
		 }
		 
		 public void takeScreenshot(WebDriver driv,WebElement element,String filename) throws IOException{
			 
			 if(element==null)
			 {
				 Screenshot screenshot = new AShot().takeScreenshot(driv);
				ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +filename+".png"));

			 }
			 else{
		     Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driv,element);
			ImageIO.write(screenshot.getImage(),"JPG",new File(System.getProperty("user.dir")+ "/Screenshots/Pass_Screenshots/"+filename+".jpg"));
			 }

		 }
		 
		 public void verifyURLTitle(WebDriver Driver,String expectedURL,String expectedTitle){
			 //Storing the url of the current page in a string variable
			 String currentURL = Driver.getCurrentUrl();
			 System.out.println("CurrentURL "+currentURL);
			 System.out.println("ExpectedURL "+expectedURL);
			 Assert.assertTrue("URL does not match", expectedURL.equals(currentURL));
			 String currentTitle = Driver.getTitle();
			 System.out.println("CurrentTitle "+currentTitle);
			 System.out.println("ExpectedTitle "+expectedTitle);
			 Assert.assertTrue("Title does not match", expectedTitle.equals(currentTitle));

		 }
		 
public String getexcelData(String sheetname,int rownum,int celnum) throws Throwable   
   {
	FileInputStream fis=new FileInputStream(excelpath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetname);
	String data=sh.getRow(rownum).getCell(celnum).getStringCellValue();
	wb.close();
	
	return data;
	
}
 
}

	

 
