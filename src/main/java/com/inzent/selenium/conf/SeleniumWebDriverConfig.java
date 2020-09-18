package com.inzent.selenium.conf;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.util.PropertyUtil;

@Slf4j
@Configuration
public class SeleniumWebDriverConfig {
	
	//private final ApplicationContext context;

	public SeleniumWebDriverConfig () { }
	
	/*
	public SeleniumWebDriverConfig (ApplicationContext context) {
		this.context = context;
	}*/
	
	//@RefreshScope
	//@Bean(name = "chromeDriver4Options" )
	public ChromeOptions chromeDriver4Options () {
		
		log.debug(System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath"));
		
		System.setProperty(PropertyUtil.getConfigValue("selenium.webDriverName"), System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath"));
		
		ChromeOptions options = new ChromeOptions();

		List<EnvAttr> list = StaticConstractor.envid4Attr_user;
		
		list.forEach(
			(s) -> {
				if("TRUE".equals(s.getAttrValue()) || "true".equals(s.getAttrValue())) {
					options.setCapability(s.getAttrName(), s.getAttrValue());
				}
			}
		);

		return options;
	}
	
	//@RefreshScope
	//@Bean(name = "chromeDriver6Options" )
	public ChromeOptions chromeDriver6Options () {
		
		log.debug(System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath"));
		
		System.setProperty(PropertyUtil.getConfigValue("selenium.webDriverName"), System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath"));
		
		ChromeOptions options = new ChromeOptions();

		List<EnvAttr> list = StaticConstractor.envid6Attr_user;
		
		list.forEach(
			(s) -> {
				if("TRUE".equals(s.getAttrValue()) || "true".equals(s.getAttrValue())) {
					options.setCapability(s.getAttrName(), s.getAttrValue());
				}
			}
		);
		return options;
	}
}
