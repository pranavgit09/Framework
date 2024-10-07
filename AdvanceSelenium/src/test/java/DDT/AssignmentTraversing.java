package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTraversing {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/search?q=iphone+14&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&as-pos=1&as-type=HISTORY");
		String iphonePrice = driver.findElement(By.xpath("//div[@class=\"KzDlHZ\"]/../following-sibling::div[@class=\"col col-5-12 BfVC2z\"]/div[@class=\"cN1yYO\"]/div[@class=\"hl05eU\"]/div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
		System.out.println(iphonePrice);
	}
}
