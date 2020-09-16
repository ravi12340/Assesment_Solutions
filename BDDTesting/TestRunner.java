package BDDTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRunner {
	WebDriver driver;
	
	@BeforeClass
	void setClass()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravupadhyay\\Downloads" +
                "\\Drivers\\Chrome\\chromedriver.exe");
	}
	@AfterClass
	void afterClass()
	{
		System.clearProperty("webdriver.chrome.driver");
	}
	
	
	@BeforeMethod
	void setupMethod()
	{
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	@AfterMethod
	void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name = "Calculation")
	Object[][] testData()
	{
		return new Object[][]
				{
			{"2 + 3 ", "5"},
			{"sqrt 16","4"}
	};
	}
	
	@Test (dataProvider = "Calculation")
	void display(String input, String expected)
	{
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search']"));
		searchBox.sendKeys(input);
		searchBox.click();
		WebElement result = driver.findElement(By.className("qv3Wpe"));
		Assert.assertEquals(result.getText(), expected);
		
	}
}
