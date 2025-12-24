package tests;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.FundsTransferfunction;
import pages.Loginpage;
import utilities.Log;

public class FundsTransferTest extends BaseTest {

	/*
	@Test(priority=1)
	public void login()
	{
	logStep("log in into System");
	Loginpage loginpage=new Loginpage(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	logStep("login into system");
	loginpage.Enterusername("Home");
	loginpage.Enterpassword("Home@123");
	
	
	loginpage.clickloginbtn();
	}
	*/
	
  @Test(priority=1)
	public void validinternalaccount() throws InterruptedException
	{
	    logStep("log in into System");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logStep("login into system");
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		logStep("Test started : Check that enter valid internal account transfer is success");
		
		Log.info("Test started : Check FundsTransferTest ");
		FundsTransferfunction funds=new FundsTransferfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logStep("click transfer fund link");
		funds.clktransfund();
		logStep("Enter amount");
		funds.enteramountfield("600");
		logStep("click To account dropdown");
		funds.clktoaccountdropdown();
		logStep("select To account");
		funds.selectaccount("14121"); 
	
		System.out.println("selected To account");
		
		Thread.sleep(2000);
			
		logStep("click transaction button");
		funds.clktransactionbtn();
		
		Thread.sleep(2000);
		
		String msg=funds.transactionmsg();
		
		if(msg!=null)
		{
			logPass("Transaction msg = " + msg);
			System.out.println("Transaction msg = " + msg);
		}
		else
		{
			logFail("Transaction failed");
			System.out.println("Transaction failed");
		}
		
	}
	
	@Test(priority=2)

	public void emptyfield() throws InterruptedException
	{
	        logStep("log in into System");
			Loginpage loginpage=new Loginpage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			logStep("login into system");
			loginpage.Enterusername("Job");
			loginpage.Enterpassword("Job@123");
			loginpage.clickloginbtn();
		
		logStep("Test started : check transaction with empty field");
		FundsTransferfunction funds=new FundsTransferfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logStep("click transaction link");
		funds.clktransfund();
		logStep("Empty field..");
		funds.enteramountfield("");
		logStep("click To account dropdown");
		funds.clktoaccountdropdown();
		logStep("select To account");
		funds.selectaccount("14121");
	
		System.out.println("selected To account");
		
		Thread.sleep(2000);
			
		logStep("click transaction button");
		funds.clktransactionbtn();
		
		Thread.sleep(2000);
		
		String errormsg=funds.transactionerrormsg();
		
		if(errormsg!=null)
		{
			logPass("Transaction msg = " + errormsg);

			System.out.println("Empty field= " + errormsg);
		}
		else
		{
			logFail("Transaction complete");

			System.out.println("transaction complete");
		}
	}
	
	@Test(priority=3)
	public void sameaccount() throws InterruptedException
	{
		    logStep("log in into System");
			Loginpage loginpage=new Loginpage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			logStep("login into system");
			loginpage.Enterusername("Job");
			loginpage.Enterpassword("Job@123");
			loginpage.clickloginbtn();
		
		logStep("Test started : check transaction with same account");

		FundsTransferfunction funds=new FundsTransferfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logStep("click transaction link");
		funds.clktransfund();
		logStep("Enter amount..");
		funds.enteramountfield("15");
		logStep("Click from account dropdown");
		funds.clkfromaccountdropdown();
		logStep("select from account");
		funds.selectfromacccount("13899");
		logStep("click To account dropdown");
		funds.clktoaccountdropdown();
		logStep("select To account");
		funds.selectaccount("13899");
	
		System.out.println("selected From and To account ");
		
		Thread.sleep(2000);
			
		
		logStep("click transaction button");
		funds.clktransactionbtn();
		
		Thread.sleep(2000);
		
		String errormsg=funds.transactionerrormsg();
		
		if(errormsg!=null)
		{
			logPass("Transaction msg = " + errormsg);
			System.out.println("Transation msg = " + errormsg);
		}
		else
		{
			logFail("Transaction complete");

			System.out.println("transaction complete");
		}
	}
	
	@Test(priority=4)
	public void decimalamount() throws InterruptedException
	{
		    logStep("log in into System");
			Loginpage loginpage=new Loginpage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			logStep("login into system");
			loginpage.Enterusername("Job");
			loginpage.Enterpassword("Job@123");
			loginpage.clickloginbtn();
		
		logStep("Test started : check transaction with by entering decimal amount");

		FundsTransferfunction funds=new FundsTransferfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logStep("click transaction link");
		funds.clktransfund();
		logStep("Enter amount..");
		funds.enteramountfield("15.500");
		logStep("Click from account dropdown");
		funds.clkfromaccountdropdown();
		logStep("select from account");
		funds.selectfromacccount("13899");
		logStep("click To account dropdown");
		funds.clktoaccountdropdown();
		logStep("select To account");
		funds.selectaccount("14121");
	
		System.out.println("enter decimal amount");
		
		Thread.sleep(2000);
				
		funds.clktransactionbtn();
		
		Thread.sleep(2000);
		
		logStep("click transaction button to get message");
		String errormsg=funds.transactionerrormsg();
		
		if(errormsg!=null)
		{
			logPass("Transaction msg = " + errormsg);

			System.out.println("enter decimal amount= " + errormsg);
		}
		else
		{
			logFail("Transaction complete");

			System.out.println("transaction complete");
		}
	}
	
	@Test(priority=5)
	public void CompletemsgAndBalance() throws InterruptedException
	{
		    logStep("log in into System");
			Loginpage loginpage=new Loginpage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			logStep("login into system");
			loginpage.Enterusername("Job");
			loginpage.Enterpassword("Job@123");
			loginpage.clickloginbtn();
		
		logStep("Test started : check After transaction complete message and balance ");

		FundsTransferfunction funds=new FundsTransferfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logStep("click transaction link");
		funds.clktransfund();
		logStep("Enter amount..");
		funds.enteramountfield("50");
		logStep("Click from account dropdown");
		funds.clkfromaccountdropdown();
		logStep("select from account");
		funds.selectfromacccount("13899");
		logStep("click To account dropdown");
		funds.clktoaccountdropdown();
		logStep("select To account");
		funds.selectaccount("14121");
	
		System.out.println("Complete msg");
		
		Thread.sleep(2000);
			
		logStep("click transaction button to get message");
		funds.clktransactionbtn();
		
		Thread.sleep(2000);
		
		String message=funds.getcompletemsg();
		if(message!=null)
		{
			logPass("Transaction msg = " + message);

			System.out.println("complete msg with balance =" +message);
		}
		else
		{
			logFail("Transaction complete");

			System.out.println("Not complete error message");
			
		}
		
		Log.info("Completed FundsTransferTest");

	}
	
	
	
	
	
	
	
}
