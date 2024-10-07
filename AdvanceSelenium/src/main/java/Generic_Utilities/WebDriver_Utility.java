package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriver_Utility {

	public void maximizeWindow(WebDriver driver) 
	{
		/**
		 * This method is used to maximize window/webpage
		 * @param driver
		 * @author Diksha
		 */
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver) 
	{
		/**
		 * This method is used to minimize window/webpage
		 * @param driver
		 * @author Diksha
		 */
		driver.manage().window().minimize();
	}
	
	public void fullScreen(WebDriver driver) 
	{
		/**
		 * This method is used to fullscreen window/webpage
		 * @param driver
		 * @author Diksha
		 */
		driver.manage().window().fullscreen();;
	}
	
	public void waitPageToLoad(WebDriver driver) 
	{
		/**
		 * This method is used to wait element to get loaded in window/webpage
		 * @param driver
		 * @author Diksha
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void switchingWindows(WebDriver driver,String title) {
		/**
		 * This method is used for switching windows/tabs.
		 * @author Diksha
		*/
		Set<String> allWin = driver.getWindowHandles(); // window1,window2
		
		Iterator<String> it = allWin.iterator();
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();

			if (currentTitle.contains(title)) {
				break;
			}
		}
	}
	public void moveToElementAction(WebDriver driver,WebElement ele) {
		/**
		 * 
		 */
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
		return;
		}
	

	
/**
*   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
* @param driver
*/
public void waitForElementInDOM(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

///**
//*   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
//* @param driver
//* @param partailPageURL
//*/
//public void waitForPage(WebDriver driver , String partailPageURL) {
//	WebDriverWait wait = new WebDriverWait(driver, 20);
//	wait.until(ExpectedConditions.urlContains(partailPageURL));
//}
//
///**
//*   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
//* @param driver
//* @param partailPageURL
//*/
//public void waitForElement (WebDriver driver , WebElement element) {
//	WebDriverWait wait = new WebDriverWait(driver, 20);
//	wait.until(ExpectedConditions.visibilityOf(element));
//}



/**
*  used to Switch to Any Window based on Window Title
* @param driver
* @param partialWindowTitle
*/
public void swithToWindow(WebDriver driver , String partialWindowTitle) {
      Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();

         while (it.hasNext()) {
		          String wID = it.next();
		          driver.switchTo().window(wID);
		          String currentWindowTitle = driver.getTitle();
		          if(currentWindowTitle.contains(partialWindowTitle)) {
		        	  break;
		          }
	    	}
}
/**
* this method is used to accept the alert popup
* @param driver
*/
public void alertAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/** this method is used to dismiss the alert popup
* 
* @param driver
*/
public void alertDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

/**
* used to Switch to Frame Window based on index
* @param driver
* @param index
*/
public void swithToFrame(WebDriver driver , int index) {
	driver.switchTo().frame(index);
}

/**
* used to Switch to Frame Window based on id or name attribute
* @param driver
* @param id_name_attribute
*/
public void swithToFrame(WebDriver driver , String id_name_attribute) {
	driver.switchTo().frame(id_name_attribute);
}

/**
* used to select the value from the dropDwon  based on index
* @param driver
* @param index
*/
public void select(WebElement element , int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
* used to select the value from the dropDwon  based on value / option available in GUI
* @param element
* @param value
*/
public void select(WebElement element , String text) {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}
/**
* used to place mouse cursor on specified element
* @param driver
* @param element
*/
public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
{
	Actions act = new Actions(driver);
	act.moveToElement(elemnet).perform();
}

/**
* 	 used to right click  on specified element

* @param driver
* @param elemnet
*/

public void rightClickOnElement(WebDriver driver , WebElement elemnet)
{
	Actions act = new Actions(driver);
	act.contextClick(elemnet).perform();
}

/**
* 
* @param driver
* @param javaScript
*/
public void executeJavaScript(WebDriver driver , String javaScript) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeAsyncScript(javaScript, null);
}

 	   
/**
    * pass enter Key appertain in to Browser
    * @param driver
    */
  public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
  } 

/**
* This method is used to move the cursor to a particular element
* @param driver
* @param ele
*/
public void moveToElement(WebDriver driver,WebElement ele)
{
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
}

public static String takeScreenShot1(WebDriver driver, String screenShotName) throws Throwable {
	
	TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
	File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
	File dst = new File("./ScreenShots/" + screenShotName +".png");
	FileUtils.copyFile(src, dst);
	return dst.getAbsolutePath();
} 
}
