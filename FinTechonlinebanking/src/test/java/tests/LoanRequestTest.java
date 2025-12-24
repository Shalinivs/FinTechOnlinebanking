package tests;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoanRequestfunction;
import pages.Loginpage;
import utilities.Log;

public class LoanRequestTest extends BaseTest {

	/*
	@Test(priority=1)
	public void login()
	{
		logStep(" Login with valid credentails");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Motu");
		loginpage.Enterpassword("Motu@123");
		loginpage.clickloginbtn();
		logPass("login success");
	}
	*/
	
	@Test(priority=1)
	public void validdetails() throws InterruptedException
	{
		logStep(" Login with valid credentails");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		logStep("Test started : login with valid credentails");
		
		Log.info("Test started : Check LoanRequestTest ");

		LoanRequestfunction loan=new LoanRequestfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		Thread.sleep(1000);
		logStep("click on loan request link");
		loan.clkloanrequest();
		Thread.sleep(1000);
		
		logStep("click on loan amount");
		loan.clkLamount();
		logStep("Enter loan amount");
		loan.etrLamount("50");
		logStep("Enter down payment amount");
		loan.etrDamount("10");
		logStep("select To account");
		loan.selectaccount("13899");
		logStep("click apply now button");
		loan.clkapplynow();
		Thread.sleep(2000);
		
        String message=loan.geterrormsg();
		
		if(message!=null)
		{
			logFail("Loan not applied = "+message);
			System.out.println("Loan not applied = "+message);
		}
		else
		{
			logPass("Loan applied with valid details");
			System.out.println("Loan applied with valid details");
		}
	}
	
	@Test(priority=2)
	public void missinginformation() throws InterruptedException
	{
		logStep(" Login with valid credentails");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		logStep("Test started : Loan request by missing information");
		LoanRequestfunction loan=new LoanRequestfunction(driver);
		Thread.sleep(1000);
		logStep("click on loan request link");
		loan.clkloanrequest();
		Thread.sleep(1000);
		logStep("without entering amount");
		loan.etrLamount("");
		logStep("Enter down payment amount");
		loan.etrDamount("10");
		logStep("select To account");
		loan.selectaccount("13899");
		logStep("click apply now button");
		loan.clkapplynow();
		Thread.sleep(2000);
		
		String message=loan.geterrormsg();
		
		if(message!=null)
		{
			logPass("Loan not applied = "+message);
			System.out.println("Loan not applied = "+message);
		}
		else
		{
			logFail("Loan applied with valid details");
			System.out.println("Loan applied");
		}
	}
	
	@Test(priority=3)
	public void exceedinglimit() throws InterruptedException
	{
		logStep(" Login with valid credentails");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		logStep("Test started : Loan request by exceeding limit");
		LoanRequestfunction loan=new LoanRequestfunction(driver);
		Thread.sleep(2000);
		logStep("click on loan request link");
		loan.clkloanrequest();
		Thread.sleep(2000);

		logStep(" entering  exceed amoun");
		loan.etrLamount("1000000");
		logStep("Enter down payment amount");
		loan.etrDamount("10");
		logStep("select To account");
		loan.selectaccount("13899");
		logStep("click apply now button");
		loan.clkapplynow();
		Thread.sleep(2000);
		
		String message=loan.geterrormsg();
		
		if(message!=null)
		{
			logPass("Loan not applied = "+message);
			System.out.println("Loan not applied = "+message);
		}
		else
		{
			logFail("Loan applied with valid details");
			System.out.println("Loan applied");
		}
		
		Log.info("Completed LoanRequestTest");

	}
	
	
	
}
