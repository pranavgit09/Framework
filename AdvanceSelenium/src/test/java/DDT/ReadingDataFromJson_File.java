//for reading data from excel we need to add latest version's Apache poi dependency to pom.xml

package DDT;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ReadingDataFromJson_File {

	public static void main(String[] args) throws Throwable {
	
	  File fis = new File("./src/test/resources/JsonData.json");
	  
	  ObjectMapper jsonData = new ObjectMapper();
	  JsonNode data = jsonData.readTree(fis);         //read json file using objectmapper
	  
	 String URL = data.get("url").asText();
	 String USERNAME  = data.get("username").asText();
	 String PASSWORD  = data.get("password").asText();
	 
	 WebDriver driver = new ChromeDriver();
	 driver.get(URL);
	 driver.findElement(By.name("user-name")).sendKeys(USERNAME);
	 driver.findElement(By.id("password")).sendKeys(PASSWORD);
	 driver.findElement(By.id("login-button")).click();
	}

}
