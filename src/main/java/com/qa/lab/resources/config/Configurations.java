package com.qa.lab.resources.config;

import lombok.Data;

@Data
public class Configurations {

	private String browser;
	private String applicationUrl;
	private String chromeDriver;
	private long webDriverPageLoadTimeout;
	private long webDriverImplicitTimeout;
	
	
	
	
}
