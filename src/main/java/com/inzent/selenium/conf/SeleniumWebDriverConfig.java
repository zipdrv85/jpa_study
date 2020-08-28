package com.inzent.selenium.conf;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.util.PropertyUtil;

@Slf4j
@Configuration
@RefreshScope
public class SeleniumWebDriverConfig {
	
	@Bean(name = "chromeDriverOptions" )
	public ChromeOptions chromeDriverOptions () {
		
		log.debug(System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath"));
		
		System.setProperty(PropertyUtil.getConfigValue("selenium.webDriverName"), System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath"));
		
		ChromeOptions options = new ChromeOptions();

		List<EnvAttr> list = StaticConstractor.envid4Attr;
		
		list.forEach(
			(s) -> {
				System.out.println("s.getAttrName :: " + s.getAttrName());
				options.setCapability(s.getAttrName(), s.getAttrValue());
			}
		);
		//options.setCapability("ignoreProtectedModeSettings", true);
		return options;
	}
}
