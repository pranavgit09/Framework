package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class DeletePrdAndValidate {

	public DeletePrdAndValidate(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement prdLink;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteLink;
	
	
	public void clickPrdLink()
	{
		prdLink.click();
	}
	
	public void clickOnDeleteLink()
	{
		deleteLink.click();
	}
	
	public void clickPrdName(WebDriver driver, String prdName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + prdName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	public void validatePrdDeleted(WebDriver driver,String prdName1 )
	{
		List<WebElement> productList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

		boolean flag = false;
		for (WebElement prdName11 : productList) {
			String actData = prdName11.getText();
			if (actData.contains(prdName1)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("product data is deleted");
		} else {
			System.out.println("product data not deleted");
		}
	}
}