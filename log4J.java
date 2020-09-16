import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class log4J {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravupadhyay\\Downloads" +
	            "\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver drive = new ChromeDriver();
		drive.get("https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core/2.12.1");
		Logger log = Logger.getLogger("MyLogger");
		log.info("Website has been Launched");
		
		// TODO Auto-generated method stub

	}

}
