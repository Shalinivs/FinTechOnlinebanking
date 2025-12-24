package tests;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactUsfunction;
import pages.Loginpage;
import utilities.Log;

public class ContactUsTest extends BaseTest {

	/*
	@Test(priority=1)
	public void login()
	{
		logStep("log in into system");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Motu");
		loginpage.Enterpassword("Motu@123");
		loginpage.clickloginbtn();
		logPass("login success");
	}
	*/
	
	@Test(priority=1)
	public void opensupportform()
	{
		logStep("log in into system");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		logStep("Test started: check support form");
		Log.info("Test started : Check ContactUsTest ");

		ContactUsfunction open=new ContactUsfunction(driver);
		logStep("click on contact Us");
		open.clkcontactUs();
		
		logPass("Contact Us form opend");
		System.out.println("Contact Us form opend");
	}
	
	@Test(priority=2)
	public void validinformation() throws InterruptedException
	{
		logStep("log in into system");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		logStep("Test started : user fill all required fields with valid details");
		ContactUsfunction open=new ContactUsfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logStep("click on contact Us link");
		open.clkcontactUs();
		Thread.sleep(2000);
		
		logStep("enter username");
		open.etrnamefield("Guvi");
		logStep("enter email id");
		open.etremailfield("guvi@gmail.com");
		logStep("enter phone no");
		open.etrphonefield("9090900010");
		logStep("enter message in msg field");
		open.etrmesfield("enter message in msg field");
		logStep("click send msg button");
		open.clksendmsgbtn();
		
		logPass("Contact created success");
		
	}
	
	@Test(priority=3)
	public void emptyfield() throws InterruptedException
	{
		logStep("log in into system");
		Loginpage loginpage=new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage.Enterusername("Job");
		loginpage.Enterpassword("Job@123");
		loginpage.clickloginbtn();
		
		logStep("Test started : user leave empty fields");
		ContactUsfunction open=new ContactUsfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logStep("click on contact us link");
		open.clkcontactUs();
		Thread.sleep(2000);
		
		logStep("should not enter username");
		open.etrnamefield("");
		logStep("should not enter email");
		open.etremailfield("");
		logStep("should not enter phonenumber");
		open.etrphonefield("");
		logStep("should not enter message ");
		open.etrmesfield("");
		logStep("click on send message button");
		open.clksendmsgbtn();
		
		logPass("Conttact created failed");
		
	}
	
	@Test(priority=4)
	public void successmessage() throws InterruptedException
	{
		logStep("Test started : check submission success message");
		ContactUsfunction open=new ContactUsfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logStep("click contact us link");
		open.clkcontactUs();
		Thread.sleep(2000);
		
		logStep("Enter user name");
		open.etrnamefield("test");
		logStep("Enter email");
		open.etremailfield("test@gmail.com");
		logStep("Enter phone no");
		open.etrphonefield("1234567890");
		logStep("enter message");
		open.etrmesfield("sending message");
		logStep("click send message button");
		open.clksendmsgbtn();
		
		Thread.sleep(2000);
		
		String msg=open.messagetext();
		
		logPass("Message after submission of form - " +msg);
		System.out.println(msg);
		
		Log.info("Completed ContactUsTest test");
		
	}
	
	
	
}
