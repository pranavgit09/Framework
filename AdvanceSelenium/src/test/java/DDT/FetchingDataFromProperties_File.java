package DDT;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromProperties_File {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	 //Normal Approach(not recommended)
		//driver.get("https://www.saucedemo.com/v1/");
		//driver.findElement(By.name("user-name")).sendKeys("standard-user");
		//driver.findElement(By.name("password")).sendKeys("secret_sauce");
		//driver.findElement(By.id("login-button")).click();
		
	 //Reading data from External Resources ------> properties file
		
		//Step 1: get the java representation object of the physical file
		  FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties.txt");
		
		//Step 2: Create an object of property class to load all the keys
		  Properties pro = new Properties();
		  pro.load(fis);
		
		//Step 3: Read the value using getProperty()
		  String URL = pro.getProperty("url");
		  String USERNAME =  pro.getProperty("username");
		  String PASSWORD = pro.getProperty("password");
		  
		  driver.get(URL);
		  driver.findElement(By.name("user-name")).sendKeys(USERNAME);
		  driver.findElement(By.name("password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("login-button")).click();

	}
}
