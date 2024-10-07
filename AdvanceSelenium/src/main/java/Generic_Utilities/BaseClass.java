package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public static WebDriver driver;

	@BeforeSuite(groups = {"smokeTest","regressionTest","sanityTest"})
	public void BS() {
		System.out.println("DataBase Open");
	}

	@BeforeTest(groups = {"smokeTest","regressionTest","sanityTest"})
	public void BT() {
		System.out.println("parallel execution");
	}

	@BeforeClass(groups = {"smokeTest","regressionTest","sanityTest"})
	public void BC() throws Throwable {
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getPropertiesData("Browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		System.out.println("Launching Browser");
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest","sanityTest"})
	public void BM() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility file = new File_Utility();

		wlib.maximizeWindow(driver);

		String URL = file.getPropertiesData("url");
		String USERNAME = file.getPropertiesData("username");
		String PASSWORD = file.getPropertiesData("password");

		driver.get(URL);

		// Business Logics
		LoginPage login = new LoginPage(driver);
		login.loginToVitger(USERNAME, PASSWORD);

		System.out.println("Login To App");
	}

	@AfterMethod(groups = {"smokeTest","regressionTest","sanityTest"})
	public void AM() {
		HomePage home = new HomePage(driver);
		home.clickOnAdmLink();
		home.ClickSignOutLink();
		System.out.println("logout from App");
	}

	@AfterClass(groups = {"smokeTest","regressionTest","sanityTest"})
	public void AC() {
		driver.quit();
		System.out.println("close browser");
	}

	@AfterTest(groups = {"smokeTest","regressionTest","sanityTest"})
	public void AT() {
		System.out.println("parallel execution");
	}

	@AfterSuite(groups = {"smokeTest","regressionTest","sanityTest"})
	public void AS() {
		System.out.println("close DataBase");

	}
}