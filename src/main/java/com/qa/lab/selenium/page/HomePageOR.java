package com.qa.lab.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.lab.selenium.base.TestBase;

import lombok.SneakyThrows;

public class HomePageOR {

	public TestBase base = new TestBase();
	
	@FindBy(xpath = "//*[@id=\"menu-home-page-menu\"]/li[3]/a")
	WebElement learningLink;
	
	@FindBy(xpath = "//*[@id=\"menu-home-page-menu\"]/li[6]/a")
	WebElement aboutLink;
	
	public HomePageOR () {
		base.initializeWebDriver();
		PageFactory.initElements(base.driver, this);
	}
	
	@SneakyThrows
	public void clickProductMenu() {
		Actions action = new Actions(base.driver);
		action.moveToElement(learningLink).build().perform();
		Thread.sleep(3000);
	}
	
	@SneakyThrows
	public void clickDemoLink() {
		Actions action = new Actions(base.driver);
		action.moveToElement(aboutLink).build().perform();

		System.out.println("Commented DemoLink click line");
		Thread.sleep(3000);
		base.driver.close();
	}
	
	
}
