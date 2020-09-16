package assesment_solution1_run;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = {"assesment_solution1"}, strict = true )
public class TestRunner {
	
	

}
