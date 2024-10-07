package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TraversingWithXpath {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		//finding/traversing using dynamic xpath without indexing
		String wonmatches = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/../../../..//div[@class=\"table-data matches-won\"]")).getText();
		System.out.println(wonmatches);
		
		//traversing using dynamic xpath (sibling relation)
		String lostmatches = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/../../../following-sibling::div[@class=\"table-data matches-lost\"]")).getText();
		System.out.println(lostmatches);
	}

}
