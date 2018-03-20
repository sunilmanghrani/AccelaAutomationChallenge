package com.runner;

//import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = {"com.stepDefinations"},
		tags = {}
		)
public class RunCukeTest extends AbstractTestNGCucumberTests {

}
