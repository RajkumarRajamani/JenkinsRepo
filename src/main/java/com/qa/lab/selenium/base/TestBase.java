package com.qa.lab.selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.qa.lab.resources.config.Configurations;
import com.qa.lab.resources.config.Constants;

import lombok.SneakyThrows;

public class TestBase {

	private static Properties prop;
	private static final String CONFIG_FILE = "src/main/java/com/qa/lab/resources/config/configurations.yaml";
	public static Configurations configs;
	public WebDriver driver;

	static {
		try {
			String propFileName = "src/main/java/com/qa/lab/resources/config/config.properties";
			FileInputStream fis = new FileInputStream(new File(propFileName));
			prop = new Properties();
			prop.load(fis);
			configs = readConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TestBase() {
	}

	@SneakyThrows
	private static Configurations readConfig() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		return mapper.readValue(new File(CONFIG_FILE), Configurations.class);
	}

	public static String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}

	public void initializeWebDriver() {

		String browser = configs.getBrowser();

		switch (browser) {
		case (Constants.CHROME):
			System.setProperty("webdriver.chrome.driver", configs.getChromeDriver());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("--disable-gpu");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);
			break;
		case (Constants.FIREFOX):
			System.setProperty("webdriver.gecko.driver", configs.getFirefoxDriver());	
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(configs.getWebDriverPageLoadTimeout(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(configs.getWebDriverImplicitTimeout(), TimeUnit.SECONDS);
		driver.get(configs.getApplicationUrl());
	}

}
