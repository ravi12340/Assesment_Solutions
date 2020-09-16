package assesment_solution2;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Wayfairverification {
	
	
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
		driver.get("https://www.wayfair.com/");
		driver.manage().window().maximize();
		log.info("Website has been Launched");
		
		
		//* Home Page*//
		
		WayfairHomepage mainPage = new WayfairHomepage(driver);
		mainPage.selectFurniture();
		
		log.info("Sectional Home Page has been launched");
		
	
		
	}
	
	

}


