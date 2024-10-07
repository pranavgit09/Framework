package organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationPage;

@Listeners(Generic_Utilities.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganization() throws Throwable {

     //   WebDriver driver;		
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		// click on organization link
		HomePage home=new HomePage(driver);
		home.getOrgLink().click();

		// click on lookup img
		OrganizationPage orgImg = new OrganizationPage(driver);
		orgImg.clickOrgPlusImg();
	
		// TO avoid Duplicates
		int ranNum = jlib.getRandomNum();
        String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
        
    //    Assert.assertEquals(false, true);
		String phnNum = elib.getExcelDataUsingFormatter("Organization", 1, 0);
		String mailId = elib.getExcelDataUsingFormatter("Organization", 2, 0);

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.enterOrgData(OrgName, phnNum, mailId);
	
		orgPage.clickOnSaveButton();
		Thread.sleep(3000);
	}
	}