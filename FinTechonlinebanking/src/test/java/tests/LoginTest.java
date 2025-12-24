package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Loginpage;
import utilities.Log;

public class LoginTest extends BaseTest {
	
	
	@Test(priority=1)
	public void validcredit() throws InterruptedException
	{
		logStep("test started : login started");
		Log.info("Test: valid username and valid password");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		logStep("Login into the browser");
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		Thread.sleep(2000);
		String message=loginpage.geterrormsg();
		
		if(message!=null)
		{
			logFail("Login failed " +message);
			//System.out.println("Login failed" + message);
		}
		else
		{
			logPass("Login Sucess " +message);
			//System.out.println("Login Sucess ");
		}
		
		String expectedTitle="ParaBank | Customer Created";
		String Actualtitle=driver.getTitle();
		if(expectedTitle==Actualtitle)
		{
			logPass("Actual title text = expected title"+Actualtitle);
			//System.out.println("Actual title text = expected title"+Actualtitle);
		}
		else
		{
			logFail("Actual title text and Expected title text not same");
			//System.out.println("Actual title text and Expected title text not same");
		}
	}
	
	@Test(priority=2)
	public void incorrecrpassword()
	{
		logStep("test started : login with incorrect password");
		Log.info("Test: incorrecrpassword - entering username");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		logStep("Login into syatem");
		loginpage.Enterusername("test");
		loginpage.Enterpassword("Test");
		loginpage.clickloginbtn();
		
		
        String message=loginpage.geterrormsg();
		
		if(message!=null)
		{
			logPass("Login failed" + message);
			//System.out.println("Login failed" + message);
		}
		else
		{
			logFail("Login Sucess ");
			//System.out.println("Login Sucess ");
		}
		
		driver.navigate().back();
	}
	
	@Test(priority=3)
	public void unregistereduser()
	{
		logStep("Test start : login with unregistereduser");
		Log.info("Test: unregistereduser: user is not registered");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		logStep("log in into system with unregistered user");
		loginpage.Enterusername("easy");
		loginpage.Enterpassword("Test");
		loginpage.clickloginbtn();
		
        String message=loginpage.geterrormsg();
		
		if(message!=null)
		{
			logPass("Login failed" + message);
			//System.out.println("Login failed" + message);
		}
		else
		{
			logFail("Login Sucess ");
			//System.out.println("Login Sucess ");
		}
		
	}
	
	@Test(priority=4)
	public void emptyfield()
	{
		logStep("Test started :log in with emptyfield");
		Log.info("Test: without entering usering and password");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		logStep("login with empty field");
		loginpage.Enterusername("");
		loginpage.Enterpassword("");
		loginpage.clickloginbtn();
		
        String message=loginpage.geterrormsg();
		
		if(message!=null)
		{
			logPass("Login failed" + message);
			//System.out.println("Login failed" + message);
		}
		else
		{
			logFail("Login Sucess ");
			//System.out.println("Login Sucess ");
		}
		
	}
	
	@Test(priority=5)
	public void invalidemailformat()
	{
		logStep("Test started : invalid email format");
		Log.info("Test: entering invalid email and entering correct password");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		logStep("login with invalid emailformat");
		loginpage.Enterusername("Home@xyz");
		loginpage.Enterpassword("Easy@123");
		loginpage.clickloginbtn();
		
       String message=loginpage.geterrormsg();
		
		if(message!=null)
		{
			logPass("Login failed" + message);
			//System.out.println("Login failed" + message);
		}
		else
		{
			logFail("Login Sucess ");
			//System.out.println("Login Sucess ");
		}
		
	}
	
	@Test(priority=6)
	public void maskinput()
	{
		logStep("Test started : with mask input");
		Log.info("Test: entering username as mask and entering password as mask");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		logStep("login by entering mask input");
		loginpage.Enterusername("****");
		loginpage.Enterpassword("*****");
		loginpage.clickloginbtn();
		
       String message=loginpage.geterrormsg();
		
		if(message!=null)
		{
			logPass("Login failed" + message);
			//System.out.println("Login failed" + message);
		}
		else
		{
			logFail("Login Sucess ");
			//System.out.println("Login Sucess ");
		}
		
		Log.info("Completed LoginTest");

	}
	
	

}
