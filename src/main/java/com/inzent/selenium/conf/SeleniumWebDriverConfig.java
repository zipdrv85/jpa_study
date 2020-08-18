package com.inzent.selenium.conf;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.util.PropertyUtil;

@Slf4j
@Configuration
public class SeleniumWebDriverConfig {
	
	@Bean(name = "chromeDriverOptions" )
	public ChromeOptions chromeDriverOptions () {
		
		log.debug(System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath8.3"));
		
		System.setProperty(PropertyUtil.getConfigValue("selenium.webDriverName"), System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath8.3"));
		
		ChromeOptions options = new ChromeOptions();
		
		StaticConstractor.envid4Attr.forEach(
			(s) -> {
				options.setCapability(s.getAttrName(), s.getAttrValue());
			}
		);
		//options.setCapability("ignoreProtectedModeSettings", true);		
		return options;
	}
}
