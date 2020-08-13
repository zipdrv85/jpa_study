package com.inzent.selenium.com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.inzent.selenium.util.PropertyUtil;
import com.inzent.selenium.util.SeleniumUtil;

public class LoginService {
	
	public static boolean Login4 (WebDriver driver, String baseUrl) {
		
		try 
		{
			String mainId = PropertyUtil.getConfigValue("selenium.loginId");
			String password = PropertyUtil.getConfigValue("selenium.loginId");
	    	
	    	driver.get(baseUrl);
	
	    	Thread.sleep(3000);
	
	        JavascriptExecutor js;
	        if (driver instanceof JavascriptExecutor) {
	            js = (JavascriptExecutor)driver;
	            
	            SeleniumUtil.WaitForLoad(driver, 10);
	
	            js.executeScript("var pkpEl = document.querySelector('.input_id'); pkpEl.value = '"+mainId+"'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);", "");
	            js.executeScript("var pkpEl = document.querySelector('.input_pw'); pkpEl.value = '"+password+"'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);", "");
	
	            js.executeScript("$(\".btn_login\").click();", "");
	        }
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public static boolean Login4 (WebDriver driver, String userId, String userPw, String baseUrl) {
		
		try 
		{
			String mainId = userId;
			String password = userPw;
	    	
	    	driver.get(baseUrl);
	
	    	Thread.sleep(3000);
	
	        JavascriptExecutor js;
	        if (driver instanceof JavascriptExecutor) {
	            js = (JavascriptExecutor)driver;
	            
	            SeleniumUtil.WaitForLoad(driver, 10);
	
	            js.executeScript("var pkpEl = document.querySelector('.input_id'); pkpEl.value = '"+mainId+"'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);", "");
	            js.executeScript("var pkpEl = document.querySelector('.input_pw'); pkpEl.value = '"+password+"'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);", "");
	
	            js.executeScript("$(\".btn_login\").click();", "");
	        }
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public static boolean Login6 (WebDriver driver, String baseUrl) {
		try 
		{
			String mainId = PropertyUtil.getConfigValue("selenium.loginId");
			String password = PropertyUtil.getConfigValue("selenium.loginPw");
	    	
	    	driver.get(baseUrl);
	
	    	Thread.sleep(3000);
	
	        JavascriptExecutor js;
	        if (driver instanceof JavascriptExecutor) {
	            js = (JavascriptExecutor)driver;
	            
	            SeleniumUtil.WaitForLoad(driver, 10);
	
	            js.executeScript("var pkpEl = document.querySelector('input[type=\"text\"]'); pkpEl.value = '"+mainId+"'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);", "");
	            js.executeScript("var pkpEl = document.querySelector('input[type=\"password\"]'); pkpEl.value = '"+password+"'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);", "");
	            
	            js.executeScript("$('button').click();", "");
	        }
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public static boolean Login6 (WebDriver driver, String userId, String userPw, String baseUrl) {
		
		try 
		{
			String mainId = userId;
			String password = userPw;
	    	
	    	driver.get(baseUrl);
	
	    	Thread.sleep(3000);
	
	        JavascriptExecutor js;
	        if (driver instanceof JavascriptExecutor) {
	            js = (JavascriptExecutor)driver;
	            
	            SeleniumUtil.WaitForLoad(driver, 10);
	
	            js.executeScript("var pkpEl = document.querySelector('input[type=\"text\"]'); pkpEl.value = '"+mainId+"'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);", "");
	            js.executeScript("var pkpEl = document.querySelector('input[type=\"password\"]'); pkpEl.value = '"+password+"'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);", "");
	            
	            js.executeScript("$('button').click();", "");
	        }
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
}
