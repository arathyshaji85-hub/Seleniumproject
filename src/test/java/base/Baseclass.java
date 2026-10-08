
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Page.Homepage;
import Page.loginpage;


public class Baseclass {
	public static WebDriver driver; 
	public static WebDriver wait;
	
	public static ExtentSparkReporter reporter;
	public   static ExtentTest test;
	public static  ExtentReports extent;
	  
	public static loginpage lo;
	public static Homepage home ; 
	 

	@BeforeTest
	public void setUp()
	{
		reporter=new ExtentSparkReporter("./Reports/myreport1.html");
		reporter.config().setDocumentTitle("AtomationReport");
		reporter.config().setReportName("functional test");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "window11");
		extent.setSystemInfo("testname", "arathy");
		extent.setSystemInfo("browsername","chrome");
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		driver=new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		
	}

	@BeforeMethod  
	public  void objects()
{
		lo=new loginpage(driver);
	    home=new Homepage(driver);
	    
	    
		
	} 
	
	@AfterMethod
	public void browserclose(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"test case failed is"+result.getName());
			test.log(Status.FAIL,"test case failed is"+result.getThrowable());

			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,"test case failed is"+result.getName());

		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"test case passed is"+result.getName());
		}
		

	}
}