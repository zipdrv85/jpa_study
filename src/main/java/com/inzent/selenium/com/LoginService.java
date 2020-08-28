package com.inzent.selenium.com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.util.PropertyUtil;
import com.inzent.selenium.util.SeleniumUtil;
import com.inzent.selenium.util.StringUtil;

public class LoginService {
	
	public static boolean Login4 (WebDriver driver, String baseUrl) {
		
		try 
		{
			String mainId = StringUtil.NVL(StaticConstractor.id4, PropertyUtil.getConfigValue("selenium.loginId"));
			String password = StringUtil.NVL(StaticConstractor.password4, PropertyUtil.getConfigValue("selenium.loginPw"));
	    	
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
			
			// 스크린샷
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
			try (FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/screenshot/screenshot.png")) {
			   fos.write(imageByte);
			   fos.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return false;
		}

		return true;
	}
	
	public static boolean Login6 (WebDriver driver, String baseUrl) {
		try 
		{
			String mainId = StringUtil.NVL(StaticConstractor.id6, PropertyUtil.getConfigValue("selenium.loginId"));
			String password = StringUtil.NVL(StaticConstractor.password6, PropertyUtil.getConfigValue("selenium.loginPw"));
	    	
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
}
