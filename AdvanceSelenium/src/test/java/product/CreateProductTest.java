/*2. Login to vtiger application->click on products link->click on create product lookup image->
 * Enter product name->click on save Btn->verify whether the product is created in product Information 
 * page and Logout from the application.*/
package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidationAndVerification;

@Listeners(Generic_Utilities.ListenerImplementation.class)

public class CreateProductTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void CreateProductTest() throws Throwable {

		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();


		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickPrdHookUp();

		int ranNum = jlib.getRandomNum();
		
		String prdName = elib.getExcelData("Product", 0, 0)+ranNum;
        System.out.println(prdName);

        Assert.assertEquals(false, true);
        
        prdPage.enterProductName(prdName);
        prdPage.clickSaveButton();

        ValidationAndVerification page = new ValidationAndVerification(driver);
    //    page.ValidatePrd(driver, prdName);
        
        String data = page.validateProduct(driver);
	
    //   Assert.assertEquals(data, prdName);
     //   Assert.assertEquals(data, prdName+ranNum, "ScriptFailed");
        
   //     Assert.assertEquals(data, prdName, "PrdPass");
   //     Assert.assertEquals(false, true, "AssertFailed");
        
        
	}

}