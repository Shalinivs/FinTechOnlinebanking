package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundsTransferfunction {

	WebDriver driver;
	
	public FundsTransferfunction(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By transfund= By.xpath("//a[normalize-space()='Transfer Funds']");
	By amountfield=By.id("amount");
	By toaccount=By.id("toAccountId");
	By dropdownoption=By.xpath("//select[@fdprocessedid='qb8zys']//option");
	By getmesg=By.xpath("//h1[normalize-space()='Transfer Complete!']");
	By Transferbtn=By.xpath("//input[@value='Transfer']");
	By geterrormsg=By.xpath("(//h1[normalize-space()='Error!'])[1]");
	By fromaccount=By.id("fromAccountId");
	By Accountoview=By.xpath("//a[text()='Accounts Overview']");
//	By Balance=By.xpath("//table[@id='accountTable']//tr[td[1]='"+accNumber+"']/td[2]");
	By completemsg=By.xpath("//div[@id='transferApp']");
	
	public void clktransfund()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement amount = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(transfund));
		driver.findElement(transfund).click();
	}
	
	public void enteramountfield(String number)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement amount = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(amountfield));
		amount.sendKeys(number);
		
	}
	
	public void clktoaccountdropdown()
	{
		driver.findElement(toaccount).click();
	}
	
	public void selectaccount(String accountId)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		//Select select = new Select(driver.findElement(By.id("toAccountId")));
		WebElement dropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(toaccount));
		
		driver.findElement(toaccount);
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(accountId);
		
			
		/*List<WebElement> options=select.getOptions();
		
		for(WebElement option:options)
		{
			System.out.println("Accounts"+option.getText());
		}
		*/
	}
	
	public void clktransactionbtn()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement button=wait.until(ExpectedConditions.visibilityOfElementLocated(Transferbtn));
		button.click();
	}
	
	public String transactionmsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		try {
		WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(getmesg));
		
		return message.getText();
		}catch(TimeoutException e) {
			return null;
		}
	}
	
	public String transactionerrormsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		try {
		WebElement errmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(geterrormsg));
		
		return errmsg.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	public void clkfromaccountdropdown()
	{
		driver.findElement(fromaccount).click();
	}
	
	public void selectfromacccount(String accountno)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		//Select select = new Select(driver.findElement(By.id("toAccountId")));
		WebElement dropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(fromaccount));
		
		driver.findElement(fromaccount);
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(accountno);
	}
	
	public void clkaccountoverview()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	  driver.findElement(Accountoview).click();
		
	}
	
	public String getbalancebyaccno(String accNumber)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		By dyxpath=By.xpath("//table[@id='accountTable']//tr[td[1]='"+accNumber+"']/td[2]");
		
		WebElement balanceelement=wait.until(ExpectedConditions.visibilityOfElementLocated(dyxpath));
		
		return balanceelement.getText();
	}
	
	public String getcompletemsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		try {
		WebElement comMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(completemsg));
		
		return comMsg.getText();
		}catch(TimeoutException e){
			return null;
		}
			
	}
	
	
	
}
