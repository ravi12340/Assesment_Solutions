package POMTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KatalonConfirmationPage 
{
	WebDriver driver;
	
	public KatalonConfirmationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verification()
	
	{
	String apptmess = driver.findElement(By.className("lead")).getText();
    String success= "Please be informed that your appointment has been booked as following:";
    if(apptmess.equals(success))
    {
      System.out.println("Appointment has been booked for Medicaid - Hongkong");
    }
    else
    {
      System.out.println("Appointment is not booked");
    }
	}
	}


