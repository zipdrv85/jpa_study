package com.inzent.selenium.conf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inzent.selenium.util.PropertyUtil;

@Configuration
public class SeleniumWebDriverConfig {

	@Bean
	public WebDriver chromeDriver () {
		
		System.setProperty(PropertyUtil.getConfigValue("selenium.webDriverName"), System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath8.3"));
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}
