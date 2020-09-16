package assesment_solution1;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppiumBDD {
	
	WebDriver projectDriver = new ChromeDriver();
    String testUrl = "https://www.amazon.com/";
    Logger log = Logger.getLogger("MyLogger");
    
    @Given("^User is on the Amazon Home page$")
    public void User_is_on_the_Amazon_Homepage()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravupadhyay\\Downloads" +
                "\\Drivers\\Chrome\\chromedriver (2).exe");
        projectDriver.get(testUrl);
        projectDriver.manage().window().maximize();
        log.info("Amazon Website has been Launched");

    }
    
    @When("^Search for appium Book on amazon.com$")
    public void Search_appium_book_on_amazon()
    {
        projectDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("appium");
        projectDriver.findElement(By.className("nav-input")).submit();
        log.info("Searching for Appium Books");
    }
    
    @Then("^Appium books should be displayed$")
    public void display_appiumbook()
    {
          projectDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div[12]/div/span/div/div/div[2]/h2/a/span")).click();
          log.info("Appium Books displayed");
    }
    
    @Then("^print the rating of the book$")
    public void print_ratings_appiumbook()
    {
        System.out.println("Ratings will be displayed");
    }
    
    @Then("^Add book in the cart$")
    public void Addbook_cart()
    {
        projectDriver.findElement(By.id("add-to-cart-button")).click();
        log.info("Book is added to the Cart");
    	
    }
    
    @Then("^Print the total amount of the book$")
    public void print_totalamount()
    {

        String totalAmount = projectDriver.findElement(By.className("a-color-price hlb-price a-inline-block a-text-bold")).getText();
        System.out.println("Total Amount for the Book is " + totalAmount);
    }
}


