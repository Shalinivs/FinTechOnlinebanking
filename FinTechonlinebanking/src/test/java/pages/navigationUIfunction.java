package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class navigationUIfunction {

	WebDriver driver;
	
	public navigationUIfunction(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Home=By.xpath("//a[normalize-space()='Home']");
	By Accountoverview=By.xpath("//a[normalize-space()='Accounts Overview']");
	By Transferfunds=By.xpath("//a[normalize-space()='Transfer Funds']");
	By Requestloan=By.xpath("//a[normalize-space()='Request Loan']");
    By updateContact=By.xpath("//a[normalize-space()='Update Contact Info']");
  //  By homeicon= By.xpath("//a[normalize-space()='home']");
    By opennewaccbtn= By.xpath("//input[@value='Open New Account']");
    By Transferbtn= By.xpath("//input[@value='Transfer']");
    By updateprofilebtn= By.xpath("//input[@value='Update Profile']");
    By Applynowbtn=By.xpath("//input[@value='Apply Now']");
    By homeicon= By.xpath("//a[normalize-space()='home']");
	
	
	
    public void Accounts()
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	driver.findElement(Accountoverview).click();
    }
    
    public void Transferfund()
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

    	driver.findElement(Transferfunds).click();
    }
    
    public void Requestloanpage()
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

    	driver.findElement(Requestloan).click();
    }
    
    public void Updatecontact()
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

    	driver.findElement(updateContact).click();
    }
    
    public void Home()
	{
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

    	driver.findElement(Home).click();
	}
    
    
    
    
    public WebElement getOpenNewAccountButton() 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(opennewaccbtn)); 
    }
   
    
    
    public WebElement getTransferfundbtn()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
       return wait.until(ExpectedConditions.visibilityOfElementLocated(Transferbtn)); 
    }
    
  
    public WebElement getupdateprofilebtn()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    	return wait.until(ExpectedConditions.visibilityOfElementLocated(updateprofilebtn));
    }
    
    public WebElement getApplynowbtn()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    	return wait.until(ExpectedConditions.visibilityOfElementLocated(Applynowbtn));
     
    }
    
    public WebElement gethomeicon()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    	return wait.until(ExpectedConditions.visibilityOfElementLocated(homeicon));
    }
    
   
    public void validatebutton(WebElement button,String name)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	 wait.until(ExpectedConditions.visibilityOf(button));
    	 wait.until(ExpectedConditions.elementToBeClickable(button));
	
    	 Assert.assertTrue(button.isDisplayed(),name+ "Button is not visible");
    	 Assert.assertTrue(button.isEnabled(),name+ "Button is not clickable");
    	 
    	 System.out.println(name + " button displayed and clickable");
    	 
    }
    
    public void clknewaccbtn()
    {
    	driver.findElement(opennewaccbtn).click();
    }
    public void clkTransferbtn()
    {
    	driver.findElement(Transferbtn).click();
    }
    public void clkupdateprofilebtn()
    {
    	driver.findElement(updateprofilebtn).click();
    }
    public void clkApplynowbtn()
    {
    	driver.findElement(Applynowbtn).click();
    }
    public void clkhomeicon()
    {
    	driver.findElement(homeicon).click();
    }
    
    
    
   
}
