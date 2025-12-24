package tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Loginpage;
import pages.navigationUIfunction;
import utilities.Log;

public class navigationandUItest extends BaseTest{

/*	
	@Test(priority=1)
	public void login()
	{
		logStep("Login in to syatem");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Home");
		loginpage.Enterpassword("Home@123");
		loginpage.clickloginbtn();
		logPass("Login Success");
	}
	*/
	
	@Test(priority=1)
	public void Openpages()
	{
		logStep("Login in to syatem");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		
		logStep("Test Started : navigation of pages");
		Log.info("Test started : Check navigationandUItest ");

		navigationUIfunction navigate=new navigationUIfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logStep("click accoutns link");
		navigate.Accounts();
		logPass("Accounts page opened and loaded..");
		System.out.println("Accounts page opened and loaded..");
		
		logStep("click Transferfund");
		navigate.Transferfund();
		logStep("Transferfund page opened and loaded..");
		System.out.println("Transferfund page opened and loaded..");
		
		logStep("click update contact link");
		navigate.Updatecontact();
		logPass("Updatecontact page opened and loaded..");
		System.out.println("Updatecontact page opened and loaded..");
		
		logStep("click Requestloanpage link");
		navigate.Requestloanpage();
		logPass("Requestloanpage page opened and loaded..");
		System.out.println("Requestloanpage page opened and loaded..");
		
		logStep("click Home icon");
		navigate.Home();
		logPass("Home page opened and loaded.");
		System.out.println("Home page opened and loaded..");
	}
	
	@Test(priority=2)

	public void Openhomepage()
	{
		logStep("Test started : check navigation of home page");
		navigationUIfunction navigate=new navigationUIfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logStep("click on Home icon");
		navigate.Home();
		logPass("Redirected to home page");
		System.out.println("Redirected to home page");
	
	}
	
	@Test(priority=3)
	public void Clickablityofbutton() throws InterruptedException
	{
		logStep("Test started : check the clickability of button");
		navigationUIfunction navigate=new navigationUIfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		  logStep("click on new account button");
		  navigate.clknewaccbtn();
		  WebElement openacc = navigate.getOpenNewAccountButton();
		   navigate.validatebutton(openacc, "Open New Account");
		   logPass("open account button is working" +openacc);
		   
		   logStep("click on transfer fund button");
		   navigate.clkTransferbtn();
		  WebElement transfund= navigate.getTransferfundbtn();
		  navigate.validatebutton(transfund, "Transfer");
		  logPass("transferfund button working " +transfund);
		  
		  logStep("click on update profile button");
		  navigate.clkupdateprofilebtn();
		  WebElement updateprofile= navigate.getupdateprofilebtn();
		  navigate.validatebutton(updateprofile, "Update Profile");
		  logPass("update profile button working " +updateprofile);
		  
		  logStep("click on Apply now button");
		  navigate.clkApplynowbtn();
		  WebElement Applynow= navigate.getApplynowbtn();
		  navigate.validatebutton(Applynow, "Apply Now");
		  logPass("Apply now button working " +Applynow);
		  
		  logStep("click on home icon");
		  navigate.clkhomeicon();
		  WebElement homeicon= navigate.gethomeicon();
		  navigate.validatebutton(homeicon, "home");
		  logPass("home icon link is working " +homeicon);
		  
			Log.info("Completed navigationandUItest");
		
	}
}
