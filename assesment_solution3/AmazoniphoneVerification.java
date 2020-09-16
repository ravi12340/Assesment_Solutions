package assesment_solution3;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class AmazoniphoneVerification {
	@BeforeClass
	void setClass()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravupadhyay\\Downloads" +
	            "\\Drivers\\Chrome\\chromedriver (2).exe");
	}
	@AfterClass
	void afterClass()
	{
		System.clearProperty("webdriver.chrome.driver");
	}
	
	@Test
	public void homepageLogin()
	{
		Logger log = Logger.getLogger("MyLogger");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		log.info("Amazon Website has been Launched");
		
		
		//* Home Page*//
		
		AddiPhone iphone = new AddiPhone(driver);
		iphone.validateIphone();
		log.info("iPhone Page has been displayed");
		log.info("iPro page has been displayed");
		log.info("Compare Chart has been displayed");
		
	}

}
