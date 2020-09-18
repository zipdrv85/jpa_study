package com.inzent.selenium.service.impl;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;

import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.service.Selenium6Service;
import com.inzent.selenium.service.executor.LoginExecutor;
import com.inzent.selenium.util.PropertyUtil;
import com.inzent.selenium.util.StringUtil;

@Slf4j
public class Selenium6ServiceImpl extends Selenium6Service {

	private final ChromeOptions chromeDriver6Options;
	private final LoginExecutor loginExecutor = new LoginExecutor();

	private final String base_url = StringUtil.NVL(StaticConstractor.url6_user, PropertyUtil.getConfigValue("selenium.domain"));
	
	public Selenium6ServiceImpl (ChromeOptions chromeDriver6Options) {
		this.chromeDriver6Options = chromeDriver6Options;
	}
	
	@Override
	public void acase001 ( HttpServletRequest req ){
		ChromeDriver driver = new ChromeDriver(chromeDriver6Options);
		
		try {

			loginExecutor.Login6(driver, base_url);
			
		} catch (Exception e) {
			log.debug(""+e.getStackTrace());
		} finally {
			driver.quit();
		}
		
	}
	
	@Override
	public void acase002 ( HttpServletRequest req ){
		ChromeDriver driver = new ChromeDriver(chromeDriver6Options);
		
		try {

			loginExecutor.Login6(driver, base_url);
			
			loginExecutor.Logout6(driver);
		} catch (Exception e) {
			log.debug(""+e.getStackTrace());
		} finally {
			driver.quit();
		}
		
	}
}
