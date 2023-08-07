package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/createCustomer.feature",
glue = "stepDefinitions", dryRun = false, monochrome = true, plugin = {
		"pretty","html:target/cucumberReports/htmlReport5.html" })
public class testRun {

}
