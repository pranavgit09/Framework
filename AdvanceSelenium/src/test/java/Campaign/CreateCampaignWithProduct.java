package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		File_Utility flib = new File_Utility();
		String URL = flib.getPropertiesData("Url");
		String USERNAME = flib.getPropertiesData("UserName");
		String PASSWORD = flib.getPropertiesData("PassWord");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();


		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		FileInputStream fes = new FileInputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
		// step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet("Product");

		// step4:-taking Control of the rows
		Row row = sheet.getRow(0);

		// step5:-taking Control of the cell
		Cell cel = row.getCell(0);

		String prdName = cel.getStringCellValue() + ranNum;
		System.out.println(prdName);

		driver.findElement(By.name("productname")).sendKeys(prdName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		WebElement link = driver.findElement(By.linkText("More"));
//		Actions act = new Actions(driver);
//		act.moveToElement(link).click().perform();

		driver.findElement(By.linkText("Campaigns")).click();

		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

//----------------------------------------------------------------------------------------------------------------				  
//Navigating to campaigns module	

		FileInputStream fes1 = new FileInputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
		// step2:-keep excel file in read mode
		Workbook book1 = WorkbookFactory.create(fes1);

		// step3:-taking Control of the excel sheet
		Sheet sheet1 = book1.getSheet("Campaigns");

		// step4:-taking Control of the rows
		Row row1 = sheet1.getRow(0);

		// step5:-taking Control of the cell
		Cell cel1 = row1.getCell(0);

		String campName = cel1.getStringCellValue() + ranNum;
		System.out.println(campName);

		driver.findElement(By.name("campaignname")).sendKeys(campName);
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();

//		Set<String> allWin = driver.getWindowHandles(); // window1,window2
//
//		Iterator<String> it = allWin.iterator();
//		while (it.hasNext()) {
//			String win = it.next();
//			driver.switchTo().window(win);
//			String currentTitle = driver.getTitle();
//
//			if (currentTitle.contains("Products&action")) {
//				break;
//			}
//		}
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.switchingWindows(driver, "Products&action");
		
		driver.findElement(By.name("search_text")).sendKeys(prdName);
		driver.findElement(By.xpath("//input[@type=\"button\"]")).click();

		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();

//		Set<String> allWin1 = driver.getWindowHandles(); // win1,win2
//
//		Iterator<String> it1 = allWin1.iterator();
//		while (it1.hasNext()) {
//			String win1 = it1.next();
//			driver.switchTo().window(win1);
//			String currentTitle = driver.getTitle();
//
//			if (currentTitle.contains("Campaigns&action")) {
//				break;
//			}
//		}
		wlib.switchingWindows(driver, "Campaigns&action");
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}
}