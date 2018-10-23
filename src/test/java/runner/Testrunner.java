package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "F:\\eclipse_Java_with_plugin\\workspace\\cucumber-selenium\\src\\test\\java\\features", glue = {
		"stepdefinition" }, plugin = { "pretty", "html:target/cucumber-reports" }, monochrome = true)

public class Testrunner {

}
