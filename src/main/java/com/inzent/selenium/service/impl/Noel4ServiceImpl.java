package com.inzent.selenium.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.inzent.selenium.com.LoginService;
import com.inzent.selenium.service.Selenium4Service;
import com.inzent.selenium.util.ETCUtil;
import com.inzent.selenium.util.PropertyUtil;

public class Noel4ServiceImpl implements Selenium4Service {

	public Noel4ServiceImpl () {
		
	}
	
	@Override
	public void case034 ( HttpServletRequest req ) {

	}

	@Override
	public void case035(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case036(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case037(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case038(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case039(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case040(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case041(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case042(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case043(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case044(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case045(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case046(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case047(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case048(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case049(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case050(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case051(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case052(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case053(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case054(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case055(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case056(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case057(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case058(HttpServletRequest req) {
		String startUrl = PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/";

		WebDriver driver = new ChromeDriver();
		LoginService.Login4(driver, startUrl);

		try {
			Thread.sleep(1000);
			
	        JavascriptExecutor js;
	        if (driver instanceof JavascriptExecutor) {
	            js = (JavascriptExecutor)driver;

	            driver.get(PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/#/files/%EB%82%B4%20%EB%AC%B8%EC%84%9C%ED%95%A8/");
	            driver.navigate().refresh();
				Thread.sleep(1000);

	            js.executeScript("$(\".fa.fa-upload\").click();", "");

	            WebElement uploadElement = driver.findElement(By.id("files"));

	            String source = System.getProperty("user.dir")+"/samplefile/newtext.txt";
	            String dest = System.getProperty("user.dir")+"/samplefile/"+ETCUtil.randomHangulNameRtnThree()+".txt";

	            Files.copy(new File(source).toPath(), new File(dest).toPath());

	            // enter the file path onto the file-selection input field
	            uploadElement.sendKeys(dest);

	            // check the "I accept the terms of service" check box
	            //driver.findElement(By.id("terms")).click();
	            // click the "UploadFile" button
	            driver.findElement(By.id("uploadBtn")).click();

	            Thread.sleep(1000);

	            js.executeScript("$(\"#uploadBtn\").parent().find(\".el-button.el-button--default\").click();", "");         
	        }
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void case059(HttpServletRequest req) {

	}

	@Override
	public void case060(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case061(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case062(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case063(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case064(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case065(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case066(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case067(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case068(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case069(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case070(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case071(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case072(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case073(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case074(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case075(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case076(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case077(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case078(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}
	
}
