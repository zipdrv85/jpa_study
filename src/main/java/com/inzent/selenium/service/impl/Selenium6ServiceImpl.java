package com.inzent.selenium.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.inzent.selenium.com.LoginService;
import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.service.Selenium6Service;
import com.inzent.selenium.util.PropertyUtil;
import com.inzent.selenium.util.StringUtil;

public class Selenium6ServiceImpl extends Selenium6Service {

	private final ChromeOptions chromeDriver6Options;
	private final String base_url = StringUtil.NVL(StaticConstractor.url4, PropertyUtil.getConfigValue("selenium.domain"));
	
	public Selenium6ServiceImpl (ChromeOptions chromeDriver6Options) {
		this.chromeDriver6Options = chromeDriver6Options;
	}
	
	@Override
	public void case001 ( HttpServletRequest req ){
		ChromeDriver driver = new ChromeDriver(chromeDriver6Options);
		
		try {
			
			LoginService.Login6(driver, base_url);
			
		} catch (Exception e) {
			
		} finally {
			driver.quit();
		}
		
	}
}
