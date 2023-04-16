package com.qa.lab.selenium.init;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {
				"pretty",
				"html:TestOutput/cucumber-report/cucumber-pretty.html",
				"json:TestOutput/cucumber-report/cucumber-json.json"
				},
		features = {"src/test/java/com/qa/lab/selenium/features/"},
		glue = {"com.qa.lab.selenium.stepdef"},
		dryRun = false,
		tags = "@jenkins-github"
		
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
