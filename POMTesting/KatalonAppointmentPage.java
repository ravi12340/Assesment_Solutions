package POMTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonAppointmentPage {
	
	
WebDriver driver;
	
	//* Declare all web elements for the page*//
	
	By reAdmission = By.id("chk_hospotal_readmission");
	By visitDate = By.id("txt_visit_date");
	By textComment = By.id("txt_comment");
	By bookButton = By.id("btn-book-appointment");
	
	public  KatalonAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void createAppt(String date)
	{
		Select facility  = new Select(driver.findElement(By.id("combo_facility")));
	    facility.selectByVisibleText("Hongkong CURA Healthcare Center");
	    driver.findElement(reAdmission).click();
	    driver.findElement(By.id("radio_program_medicaid")).click();
	    driver.findElement(visitDate).sendKeys(date);
	    driver.findElement(textComment).sendKeys("Appointment for Surgery");
	    driver.findElement(bookButton).click();
	}
	

    

}
