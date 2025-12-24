package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsfunction {
	
	WebDriver driver;
	
	public ContactUsfunction(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By contactUs=By.xpath("//a[text()='Contact Us']");
	By namefield=By.xpath("//input[@id='name']");
	By emailfield=By.xpath("//input[@id='email']");
	By phonefield=By.xpath("//input[@id='phone']");
	By mesfield=By.xpath("//textarea[@id='message']");
	By sendmsgbtn=By.xpath("//input[@type='submit']");
	By message=By.xpath("//div[@id='rightPanel']");
	
	public void clkcontactUs()
	{
		driver.findElement(contactUs).click();
	}
	
	public void etrnamefield(String name)
	{
		driver.findElement(namefield).sendKeys(name);
	}
	
	public void etremailfield(String email)
	{
		driver.findElement(emailfield).sendKeys(email);
	}
	
	public void etrphonefield(String phone)
	{
		driver.findElement(phonefield).sendKeys(phone);
	}
	
	public void etrmesfield(String message)
	{
		driver.findElement(mesfield).sendKeys(message);
	}
	
	public void clksendmsgbtn()
	{
		driver.findElement(sendmsgbtn).click();
	}
	
	public String messagetext()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		try {
		WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(message));
		
		return msg.getText();
		}catch(TimeoutException e) {
			return null;
		}
		
	}
	
	
	
	
}
