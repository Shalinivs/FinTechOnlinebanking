package tests;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountsOverviewfunction;
import pages.Loginpage;
import utilities.Log;

public class AccountOverviewTest extends BaseTest {

	/*
	@Test(priority=1)
	public void login()
	{
		 Log.info("Starting Account Overview test");
		logStep("Login into System");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Home");
		loginpage.Enterpassword("Home@123");
		loginpage.clickloginbtn();
	}
	*/

	@Test(priority=1)
	public void clickaccountoverview() throws InterruptedException
	{
		 Log.info("Starting Account Overview test");
			logStep("Login into System");
			Loginpage loginpage=new Loginpage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			loginpage.Enterusername("Job");
			loginpage.Enterpassword("Job@123");
			loginpage.clickloginbtn();
		
		logStep("Test started : Check accountoverview ");
		AccountsOverviewfunction action=new AccountsOverviewfunction(driver);
		
		Thread.sleep(3000);
		logStep("click on account overview link");
		action.clkaccountoverview();
		//action.getbalancebyaccno("13677");
		
        String accountnum=action.getaccno();
		
        logPass("account number="+accountnum);
		System.out.println("account number="+accountnum);
		
		String balance=action.getbalancebyaccno("13899");
		
		logPass("Account balance =" +balance);
		System.out.println("Account balance =" +balance);
		
		String getavlblance=action.getavlblance();
		
		logPass("availble balance =" +getavlblance);
		System.out.println("availble balance =" +getavlblance);
		
	}
	
	@Test(priority=2)
	public void Checkingaccount() throws InterruptedException
	{
		 Log.info("Starting Account Overview test");
			logStep("Login into System");
			Loginpage loginpage=new Loginpage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			loginpage.Enterusername("Job");
			loginpage.Enterpassword("Job@123");
			loginpage.clickloginbtn();
			
		logStep("Test started : Checking account ");
		AccountsOverviewfunction action=new AccountsOverviewfunction(driver);
		
		Thread.sleep(2000);
		logStep("click account overview link");
		action.clkaccountoverview();
		
		logStep("click account no");
		action.clkAccountno();
		
		String accno=action.getAccno();
		logPass("Checking account no = " +accno);
		System.out.println("Checking account no = " +accno);
		
		String type=action.getacctype();
		logPass("Checking account type = " +type);
		System.out.println("Checking account type = " +type);
		
		String balance=action.getbalance();
		logPass("Checking account balance = " +balance);
		System.out.println("Checking account balance = " +balance);
		
        String avlbalance=action.getAvlbalance();
		logPass("Checking account Avlbalance = " +avlbalance);
		System.out.println("Checking account Avlbalance = " +avlbalance);
		
		 Log.info("Completed Account Overview test");
		
	}
	
}
