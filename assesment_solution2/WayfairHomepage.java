package assesment_solution2;

import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WayfairHomepage {
WebDriver driver;
String ratings;
String price;
String parentWindowHandle, lastWindowHandle;
String finalPrice;

	
	//* Declare all web elements for the page*//
	
	By furnitureLink  = By.className("DepartmentItem-link");
	By popupDimiss = By.xpath("/html/body/div[5]/div[3]/div/div/div/div/button");
	By sectionalItem  = By.linkText("Sectionals");
	By selectSectionalItem = By.xpath("/html/body/div[5]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[12]/div/div/div/a/div[1]/div/img");
	By addCartbutton = By.id("btn-add-to-cart");
	By ratingsofItem = By.className("ProductRatingNumberWithCount-rating");
	By priceofItem = By.className("notranslate");
	
	
	public  WayfairHomepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectFurniture()
	{
		//*This code will handle the Pop up*//
		//*driver.findElement(popupDimiss).click();
		
		//*Step 3. Select Sectional Furniture *//
		
		driver.findElement(furnitureLink).click();
		driver.findElement(sectionalItem).click();
		driver.findElement(selectSectionalItem).click();
		parentWindowHandle = driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!parentWindowHandle.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);
                    //*Step 4. Get the Price of the Item*//
                    
                    price = driver.findElement(priceofItem).getText();
              		System.out.println("Price of the Item is " +  price);
              	    //*Step 5. Get the Ratings of the Item*//
              		
              		ratings = driver.findElement(ratingsofItem).getText();
                    System.out.println("Ratings of your Item is " +  ratings);	
                    
                    //*Step 6. Add the item into the Cart*//
                    driver.findElement(addCartbutton).submit();
                  
                  //* Close the Driver*//
            		
              		driver.close();
	}
	
        }
	}
}


