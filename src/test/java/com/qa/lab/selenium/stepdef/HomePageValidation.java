package com.qa.lab.selenium.stepdef;

import com.qa.lab.selenium.page.HomePageOR;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageValidation {
	
	HomePageOR homePage;
	
	public HomePageValidation() {
		homePage = new HomePageOR();
	}
	
	@Given("user opens the application by hitting url in chrome browser")
	public void user_opens_the_application_by_hitting_url_in_chrome_browser() {
		homePage.clickProductMenu();
	}
	@When("homepage is displayed")
	public void homepage_is_displayed() {
		homePage.clickDemoLink();
	}
}

