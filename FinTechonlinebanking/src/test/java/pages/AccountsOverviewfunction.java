package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsOverviewfunction {
	
	WebDriver driver;
	
	public AccountsOverviewfunction(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locate elements
	By Accountoview=By.xpath("//a[normalize-space()='Accounts Overview']");
	//By Accountovervw=By.xpath("//a[normalize-space()='Accounts Overview']");
	/*
	By accounttable=By.xpath("//table{@id='accountTable']/tbody/tr");
	By accountlink=By.xpath("//table[@id='accountTable']//tbody/tr/td/a[1]");
	By welmsg=By.xpath("//h1[@class='title']");
	By accountdetails=By.xpath("//div[@id='accountDetails']//table//tr");
	By accdetailslabel=By.xpath("//div[@id='accountDetails']//table//tr/td[1]");
	By accdetailsvalue=By.xpath("//div[@id='accountDetails']//table//tr/td[2]");
	*/
	By accountno=By.xpath("//table[@id='accountTable']//tbody//tr//td//a");
	By Avlbalance=By.xpath("//table[@id='accountTable']//tbody//tr[1]//td[3]");
	By clkaccno=By.xpath("//table[@id='accountTable']//a[contains(@href,'activity.htm?id=')]");
	By Accno=By.xpath("//td[normalize-space()='Account Number:']/following-sibling::td");
	By Acctype=By.xpath("//td[normalize-space()='Account Type:']/following-sibling::td");
	By Accbalance=By.xpath("//td[normalize-space()='Balance:']/following-sibling::td");
	By Availbalance=By.xpath("//td[normalize-space()='Available:']/following-sibling::td");

	/*
	public void clickaccountovervw()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(Accountovervw));
		element.click();
	}
	
	
	public void accounttable()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(accounttable));
	}
	
	public void clickaccountlink()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(accountlink));
		element.click();
	}
	
	public String welmsgtext()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(welmsg));
		return element.getText();
	}
	
	public void accountdetails()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountdetails));
		
		List<WebElement> rows=driver.findElements(accountdetails);
		
		 if (rows.isEmpty()) 
		 {
		        System.out.println("⚠️ No account details found!");
		  } 
		 else 
		 {
		        for (WebElement row : rows) 
		        {
		            List<WebElement> cells = row.findElements(By.tagName("td"));
		            if (cells.size() >= 2) 
		            {
		                String label = cells.get(0).getText().trim();
		                String value = cells.get(1).getText().trim();
		                System.out.println(label + " - " + value);
		            }
		        }
		    }
	}
	*/
	public void clkaccountoverview()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	  driver.findElement(Accountoview).click();
		
	}
	
	public String getaccno()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		try {
		WebElement accno=wait.until(ExpectedConditions.visibilityOfElementLocated(accountno));
		
		return accno.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	
	public String getbalancebyaccno(String accNumber)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		By dyxpath=By.xpath("//table[@id='accountTable']//tr[td[1]='"+accNumber+"']/td[2]");
		
		try {
		WebElement balanceelement=wait.until(ExpectedConditions.visibilityOfElementLocated(dyxpath));
		
		return balanceelement.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	public String getavlblance()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		//By dyxpath=By.xpath("//table[@id='accountTable']//tr[td[1]='"+accNumber+"']/td[3]");
		
		try {
		WebElement balanceelement=wait.until(ExpectedConditions.visibilityOfElementLocated(Avlbalance));
		
		return balanceelement.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	public void clkAccountno()
	{
		driver.findElement(clkaccno).click();
	}
	
	
	
	public String getAccno()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		try {
		WebElement getAccnoElement=wait.until(ExpectedConditions.visibilityOfElementLocated(Accno));
		
		return getAccnoElement.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	public String getacctype()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		try {
		WebElement Accounttype=wait.until(ExpectedConditions.visibilityOfElementLocated(Acctype));
		
		return Accounttype.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	public String getbalance()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		try {
		WebElement balance=wait.until(ExpectedConditions.visibilityOfElementLocated(Accbalance));
		
		return balance.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	public String getAvlbalance()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		try {
		WebElement Avlbalance=wait.until(ExpectedConditions.visibilityOfElementLocated(Availbalance));
		
		return Avlbalance.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	
	
	

	
	

	
}
