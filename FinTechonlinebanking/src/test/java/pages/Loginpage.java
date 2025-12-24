package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Log;

public class Loginpage {

	WebDriver driver;
	
	//Locate Element
	By usernamefield=By.xpath("//input[@name='username']");
	By passwordfield=By.xpath("//input[@name='password']");
	By loginbutton=By.xpath("//input[@type='submit']");
	By errormsg=By.xpath("//p[@class='error']");
	
	//constructor
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void Enterusername(String username)
	{
		
		driver.findElement(usernamefield).sendKeys(username);
	}
	
	public void Enterpassword(String password)
	{
		driver.findElement(passwordfield).sendKeys(password);
	}
	
	public void clickloginbtn()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.findElement(loginbutton).click();
	}
	
	public String geterrormsg()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	
		try {
		WebElement error=wait.until(ExpectedConditions.visibilityOfElementLocated(errormsg));
		
		return error.getText();
	}catch(TimeoutException e) {
		return null;
	}
	}
	
}
