package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.Log;

public class BaseTest {
  
	
	protected WebDriver driver;
	public static ExtentReports extent;
	// public static ThreadLocal<com.aventstack.extentreports.ExtentTest> test = new ThreadLocal<>();
	 public static  ExtentTest test;
   // public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	 
    @BeforeSuite
    public void initiateExtentReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    
	 /*
		@BeforeMethod
	 public void openbrowser(Method method)
	 {
			  Log.info("===== STARTING TEST: " + method.getName() + " =====");
			test = extent.createTest(method.getName());
		     //   test.set(extent.createTest(method.getName()));
	
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://parabank.parasoft.com/parabank/index.htm");
	 }
	 */
	 
	
	 
	@BeforeMethod
	 @Parameters("browser")
	    public void Setupopenbrowser(String browser, Method method)
	{
		test = extent.createTest(method.getName());
		
	        switch (browser.toLowerCase()) {

	            case "chrome":
	                driver = new ChromeDriver();
	                break;

	            case "firefox":
	                driver = new FirefoxDriver();
	                break;

	            case "edge":
	                driver = new EdgeDriver();
	                break;

	            default:
	                System.out.println("Invalid browser! Opening Chrome by default.");
	                driver = new ChromeDriver();
	        }

	        driver.manage().window().maximize();
	        driver.get("https://parabank.parasoft.com/parabank/index.htm");
	    }

	        
	
	@AfterMethod
	public void browserclose(Method method)
	{
		Log.info("===== ENDING TEST: " + method.getName() + " =====");
		driver.quit();
	}
	
	 @AfterSuite
	    public void closeReport()
	   {
	        extent.flush();
	}
	 
	 
	
	public void logStep(String msg) 
	{
     test.info(msg);
     }

   public void logPass(String msg) 
    {
     test.pass(msg);
     }

     public void logFail(String msg) 
     {
     test.fail(msg);
      }
      
     /*
	 public void logStep(String msg) {
	        test.get().info(msg);
	    }

	    public void logPass(String msg) {
	        test.get().pass(msg);
	    }

	    public void logFail(String msg) {
	        test.get().fail(msg);
	    }

*/
	

}
