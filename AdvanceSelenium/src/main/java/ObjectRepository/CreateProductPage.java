package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[title=\"Create Product...\"]")
	private WebElement loopUpImg;
	
	@FindBy(name = "productname")
	private WebElement prdName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getLoopUpImg() {
		return loopUpImg;
	}

	public WebElement getPrdName() {
		return prdName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickloopUpImg()
	{
		loopUpImg.click();
	}
	
	public void enterPrdName(String name)
	{
		prdName.sendKeys(name);
	}
	
	public void clicksaveButton()
	{
		saveButton.click();
	}

}