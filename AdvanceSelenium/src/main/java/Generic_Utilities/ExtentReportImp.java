package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener{
ExtentTest test;
ExtentReports report;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("----------im taking ScreenShot-----");
		String screenshot=null;
		try {
			screenshot=WebDriver_Utility.takeScreenShot1(BaseClass.driver,result.getMethod().getMethodName());
		
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	//	test.addScreenCaptureFromPath(screenshot);
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) 
	{
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
	
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+ranNum);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Diksha");
		
		//System configuration
		report=new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("platform", "window8");
		report.setSystemInfo("executedBy", "Diksha");
		report.setSystemInfo("Reviewed By", "Pranav");
		}

	public void onFinish(ITestContext context)
	{
		report.flush();
		
	}

	
}