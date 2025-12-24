package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanRequestfunction {

	WebDriver driver;
	
	public LoanRequestfunction(WebDriver driver)
	{
		this.driver=driver;
	}
	By loanreq=By.xpath("//a[normalize-space()='Request Loan']");
	By loanamount=By.xpath("//table[@class='form2']//input[@id='amount']");
	By downpayment=By.xpath("//table[@class='form2']//input[@id='downPayment']");
	By fromacc=By.xpath("//select[@id='fromAccountId']");
	By applynow=By.xpath("//input[@type='button']");
	By errormsg=By.xpath("//div[@id='requestLoanError']");
	
	public void clkloanrequest()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	      // wait.until(ExpectedConditions.invisibilityOfElementLocated(loanreq));
	        driver.findElement(loanreq).click();
	}
	
	public void clkLamount()
	{
		driver.findElement(loanamount).click();
		//driver.findElement(loanamount).sendKeys(lamount);
	}
	
	public void etrLamount(String lamount)
	{
		//driver.findElement(loanamount).click();
		driver.findElement(loanamount).sendKeys(lamount);
	}
	
	public void etrDamount(String damount)
	{
	  // driver.findElement(loanamount).click();

		driver.findElement(downpayment).sendKeys(damount);
	}
	
	public void selectaccount(String faccount)
	{
		driver.findElement(fromacc).sendKeys(faccount);
	}
	
	public void clkapplynow()
	{
		driver.findElement(applynow).click();
	}
	
	public String geterrormsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		try {
		WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(errormsg));
		
		return msg.getText();
		}catch(TimeoutException e) {
			return null;
		}
	}
	
	
}
