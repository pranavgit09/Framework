package testNG;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx3Test {

	@Test(dataProvider = "readData")
	public void organizationModuleTest(String orgName,String phnNum,String mailId) throws Throwable 
	{
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
	public Object[][] readData()
	{
		Object[][] objArr = new Object[2][3];
		Random ranNum = new Random();
		int ranNums = ranNum.nextInt(1000);
		objArr[0][0]="AAA"+ranNums;
		objArr[0][1]="1234567";
		objArr[0][2]="aaa@gmail.com";
		
		objArr[1][0]="BBB"+ranNums;
		objArr[1][1]="4563782";
		objArr[1][2]="bbb@gmail.com";
				
		return objArr;
	}
}
