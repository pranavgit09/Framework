package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateCampPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidationAndVerification;
import ObjectRepository.LoginPage;

@Listeners(Generic_Utilities.ListenersImp.class)
public class CreateCampaignsTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createCampaignsTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
        File_Utility file = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);

		home.naviagteCamp(driver);

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.clickLookUpImg();
        
		http://Assert.fail("im failing the script");
		int ranNum = jlib.getRandomNum();

		String campData = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(campData);

		campPage.enterCampNAme(campData);
		campPage.clickSaveButton();

		ValidationAndVerification validate = new ValidationAndVerification(driver);
		validate.validateProduct(driver, campData);
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//        Assert.assertEquals(actData, campData);
	
		
	
	}
//-----------------------------------------------------------------------------	
	

}