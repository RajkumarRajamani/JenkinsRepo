package com.qa.lab.selenium.init;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin = "pretty",
		features = {"src/test/java/com/qa/lab/selenium/features/"},
		glue = {"com.qa.lab.selenium.stepdef"},
		dryRun = false,
		tags = "@jenkins-github"
		
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
