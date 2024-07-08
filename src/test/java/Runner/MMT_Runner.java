package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/MMT/MMT.feature",glue = "Steps" , tags= "@tag1")

public class MMT_Runner extends AbstractTestNGCucumberTests{

}

