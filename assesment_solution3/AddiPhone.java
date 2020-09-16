package assesment_solution3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


public class AddiPhone {
	
	
    //*Declare Variables*//
	
	WebDriver driver;
	String compareStatus = "Compare Apple iPhone products";
	String displayStatus;
	
    //*Identification of WebElements*//
	
	By searchIphone = By.id("twotabsearchtextbox");
	By searchButton = By.className("nav-input");
	By iPhoneStore = By.xpath("//span[@class='sb_3vapQDdI sb_2Jsx-Yw7']");
	By compare = By.xpath("//*[contains(text(),'Compare Apple iPhone products')]");
	
	
	
	public  AddiPhone(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void validateIphone()
	{
		//*Step 1. Type iPhone in search Window*//
		driver.findElement(searchIphone).sendKeys("iphone");
		
		
		//*Step 2. Click on Search button*//
		driver.findElement(searchButton).submit();
		
		//*Step 3. Select iPhone Store*//
		driver.findElement(iPhoneStore).click();
		
		//*Step 4. Select iPhone Pro*//
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		WebElement selectPro = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[5]/div/div/div/div[1]/div/div/a"));
		Actions action = new Actions(driver);
		action.moveToElement(selectPro).click().perform();
		
		//*Step 5. Validate that Compare Chart Displayed*//
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		displayStatus = driver.findElement(compare).getText();
		
		if(compareStatus.equalsIgnoreCase(displayStatus))
		{
			System.out.println("Compare Chart has been displayed");
		}
		else
		{
			System.out.println("Incorrect Page has been displayed");
		}
			
		
	}
}
