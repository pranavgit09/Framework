package testNG;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class DataProviderEx4ReadExcel {

	@Test(dataProvider = "readData")
	public void readExcelDataTest(String orgName,String phnNum,String mailId) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]")).click();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.quit();
	}

	@DataProvider
	public Object[][] readData() throws Throwable {
		Excel_Utility elib = new Excel_Utility();
		Object[][] values = elib.getDataProviderData("DataProvider");
		return values;
	}
}
