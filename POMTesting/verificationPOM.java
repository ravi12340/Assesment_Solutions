package POMTesting;



import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class verificationPOM {
	String userID = "John Doe";
	String password = "ThisIsNotAPassword";
	
	

	
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
	
	@Test
	public void fillData()
	{
		Logger log = Logger.getLogger("MyLogger");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		log.info("Website has been Launched");
		//* Login Page*//
		KatalonLoginPage loginPage = new KatalonLoginPage(driver);
		loginPage.setCredential(userID, password);
		loginPage.clickAccess();
		log.info("Login has been completed");
		
		//*Fill Data on Details Page//*
		String appointmentDate = "12/12/2020";
		KatalonAppointmentPage apptBook = new KatalonAppointmentPage(driver);
		apptBook.createAppt(appointmentDate);
		
		//*Verification of Success Message*//
		KatalonConfirmationPage confirm = new KatalonConfirmationPage(driver);
		confirm.verification();
		log.info("this test has been completed, All verifications are passed");
		
	}
	
	

}
