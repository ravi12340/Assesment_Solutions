package katalonAppointment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class katalonAppointment {
	HSSFWorkbook workbook;
	HSSFSheet sheet;  
	HSSFCell cell;
	
	
	
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
	void appointmentBookHongkong()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		//*Log into Application*//
		
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        
      //*Fill Details for appointment*//
        
        Select facility  = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByVisibleText("Hongkong CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicaid")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("12/12/2020");
        driver.findElement(By.id("txt_comment")).sendKeys("Appointment for Surgery");
        driver.findElement(By.id("btn-book-appointment")).click();
        
      //*Appointment Booked*//
        
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
	@Test
	void appointmentBookSeoul() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		//*Log into Application*//
		
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        
      //*Fill Details for appointment*//
        
        Select facility  = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByVisibleText("Seoul CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicare")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("12/12/2020");
        
        //*Declare the source of the Excel File//
        
        File src= new File("C:\\Users\\ravupadhyay\\Desktop\\FY21_Firm Activities\\L&D Academy\\Code Snippets\\TestData.xls");
      //Input stream class to allow connection and reading//
        
        FileInputStream inputStream = new FileInputStream(src);
        workbook =  new HSSFWorkbook(inputStream);
        sheet = (HSSFSheet) workbook.getSheetAt(0);
        cell = sheet.getRow(1).getCell(1);
        String comment = cell.getStringCellValue();
        driver.findElement(By.id("txt_comment")).sendKeys(comment);
        driver.findElement(By.id("btn-book-appointment")).click();
        inputStream.close();
        FileOutputStream foutput=new FileOutputStream(src);
        String message = "Passed";
        
        sheet.getRow(1).createCell(2).setCellValue(message);
        FileOutputStream fileOutput = new FileOutputStream(src);	 
		 workbook.write(fileOutput);
		 fileOutput.close();
	
        //*Take Screenshots for this page*//
        String filePath = "C:\\Users\\ravupadhyay\\Desktop\\FY21_Firm Activities\\L&D Academy\\test4.png";
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(filePath);
        Files.copy(SrcFile, DestFile);
        
        
      //*Appointment Booked*//
        
        String apptmess = driver.findElement(By.className("lead")).getText();
        String success= "Please be informed that your appointment has been booked as following:";
        if(apptmess.equals(success))
        {
          System.out.println("Appointment has been booked for Medicare - Seoul");
        }
        else
        {
          System.out.println("Appointment is not booked");
        }

	}


}
