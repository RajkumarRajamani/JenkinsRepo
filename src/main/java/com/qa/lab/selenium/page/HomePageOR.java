package com.qa.lab.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.lab.selenium.base.TestBase;

import lombok.SneakyThrows;

public class HomePageOR {

	public TestBase base = new TestBase();
	
	@FindBy(xpath = "//*[@id='global-menu-language']")
	WebElement languageIcon;
	
	@FindBy(xpath = "//*[@id=\"fwhomepagehero\"]/div/div[1]/div/div[1]/div/div/a[2]")
	WebElement getDemoLink;
	
	public HomePageOR () {
		base.initializeWebDriver();
		PageFactory.initElements(base.driver, this);
	}
	
	public void clickProductMenu() {
		languageIcon.click();
	}
	
	@SneakyThrows
	public void clickDemoLink() {
//		getDemoLink.click();
		System.out.println("Commented DemoLink click line");
		Thread.sleep(5000);
		base.driver.close();
	}
	
	
}
