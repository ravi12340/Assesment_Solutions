package POMTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KatalonLoginPage {
	
	WebDriver driver;
	
	//* Declare all web elements for the page*//
	
	By clickButton  = By.id("btn-make-appointment");
	By userName = By.id("txt-username");
	By userPassword = By.id("txt-password");
	By clickMe = By.id("btn-login");
	
	public  KatalonLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setCredential(String strUser, String strPass)
	{
		driver.findElement(clickButton).click();
		driver.findElement(userName).sendKeys(strUser);
		driver.findElement(userPassword).sendKeys(strPass);
	}
	public void clickAccess()
	{
		driver.findElement(clickMe).click();
	}

}
