package Tests.CucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(features = "Features/", glue = "TestSteps")
@RunWith(Cucumber.class)
public class RunnerTest {
}
