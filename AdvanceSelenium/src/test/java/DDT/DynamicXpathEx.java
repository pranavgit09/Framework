package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathEx {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/paris-2024");
		Thread.sleep(2000);
    	String gold = driver.findElement(By.xpath("//span[text()='Japan']/../..//span[@data-cy=\"number-of-golds\"]")).getText();
        System.out.println(gold);
	
	String silver = driver.findElement(By.xpath("(//span[text()='Japan']/../..//span[@class='sc-bdnyFh bjnoKy MedalsTallyElement-styles__MedalCounter-sc-d9279d18-0 hlLVoN text--number-xs'])[1]")).getText();
	System.out.println(silver);

	}

}
